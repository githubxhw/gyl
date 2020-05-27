package cn.cuit.gyl.service.business.impl;

import cn.cuit.gyl.dao.business.IXsdd_zhubDao;
import cn.cuit.gyl.dao.business.IXsdd_zibDao;
import cn.cuit.gyl.dao.business.IXsfhd_zhubDao;
import cn.cuit.gyl.dao.business.IXsfhd_zibDao;
import cn.cuit.gyl.domain.business.Xsdd_zhub;
import cn.cuit.gyl.domain.business.Xsdd_zib;
import cn.cuit.gyl.domain.business.Xsfhd_zhub;
import cn.cuit.gyl.domain.business.Xsfhd_zib;
import cn.cuit.gyl.exception.MyException;
import cn.cuit.gyl.service.business.IXsfhdService;
import cn.cuit.gyl.utils.DomainAttrValueConverterUtils;
import cn.cuit.gyl.utils.PageInfo;
import cn.cuit.gyl.utils.StringToIntegerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("xsfhdServiceImpl")
public class XsfhdServiceImpl implements IXsfhdService {

    @Autowired
    @Qualifier("iXsdd_zhubDao")
    private IXsdd_zhubDao iXsdd_zhubDao = null;

    @Autowired
    @Qualifier("iXsdd_zibDao")
    private IXsdd_zibDao iXsdd_zibDao = null;

    @Autowired
    @Qualifier("iXsfhd_zhubDao")
    private IXsfhd_zhubDao iXsfhd_zhubDao = null;

    @Autowired
    @Qualifier("iXsfhd_zibDao")
    private IXsfhd_zibDao iXsfhd_zibDao = null;

    @Override
    public PageInfo saveZhubAndZib(Xsfhd_zhub xsfhd_zhub) throws Exception {
        //先遍历子表进行是否应该添加
        /**
         * 源头单据号
         * xsdd:销售订单
         * 1，代表xsdd单据号有问题
         *      1.1没有此xsdd单据号
         *      1.2该xsdd单据号的主表：发货状态 已经关闭（结束）1
         * 2，代表xsdd子表行号有问题
         *      2.1没有此行号
         *      2.2有该行号但是该商品的发货状态已经是结束 1
         *      2.3有行号，发货状态未结束0，但是商品编码不对应(其实应该验证商品的所有信息，为了简便省略了那些属性)
         *      2.4有行号，发货状态未结束0，商品编码对应，但是应发数量不对
         *      2.5有行号，发货状态未结束0，商品编码对应，但是应发数量对，但是发货数量超过了应发数量
         * 3，来源
         * 来源订单号
         * 来源行号
         */
        PageInfo pageInfo = new PageInfo();
        Long ljfhsl = 0L; //销售订单 累计发货数量
        //获取子表s
        List<Xsfhd_zib> xsfhd_zibs = xsfhd_zhub.getXsfhd_zibs();
        int addFlag = 1; //1代表可以添加，0代表不可以添加
        if(xsfhd_zibs != null){
            for (Xsfhd_zib xsfhd_zib : xsfhd_zibs) {
                //有编号的商品
                if (xsfhd_zib.getSpbm() != null || "".equals(xsfhd_zib.getSpbm())) {
                    //销售订单判断
                    String ytdjh = xsfhd_zib.getYtdjh();//源头订单号
                    Integer ythh = xsfhd_zib.getYthh();//源头行号
                    Integer hh = xsfhd_zib.getHh();
                    //销售订单主表查询
                    Xsdd_zhub byDdh = iXsdd_zhubDao.findByDdh(ytdjh);
                    if(byDdh == null){
                        addFlag = 0;
                        //1.1没有此xsdd单据号
                        pageInfo.setResFlag("0");
                        pageInfo.add("当销售发货单行号为"+hh+"的时候:"+"销售订单中没有"+ytdjh+"的单据号!");
                        break;
                    }else {
                        if(byDdh.getFhbz() == 1){//1.2该xsdd单据号的主表：发货状态 已经关闭（结束）1
                            addFlag = 0;
                            pageInfo.setResFlag("0");
                            pageInfo.add("当销售发货单行号为"+hh+"的时候:"+"订单号为"+ytdjh+"的销售订单（主表）中发货单状态已经结束!");
                            break;
                        }else {
                            //销售订单子表查询
                            Xsdd_zib byZhubIdAndHh = iXsdd_zibDao.findByZhubIdAndHh(byDdh.getXsdd_zhub_id(), ythh);
                            if(byZhubIdAndHh == null){ //没有此行号 2.1没有此行号
                                addFlag = 0;
                                pageInfo.setResFlag("0");
                                pageInfo.add("当销售发货单行号为"+hh+"的时候:"+"订单号为"+ytdjh+"的销售订单中没有行号为"+ythh+"的商品!");
                                break;
                            }else {
                                if(byZhubIdAndHh.getSffhgb() == 1){//2.2有该行号但是该商品的发货状态已经是结束 1
                                    addFlag = 0;
                                    pageInfo.setResFlag("0");
                                    pageInfo.add("当销售发货单行号为"+hh+"的时候:"+"订单号为"+ytdjh+"且行号为"+ythh+"的销售订单（子表）中的发货单状态已经结束!");
                                    break;
                                }else {
                                    //商品编码
                                    String spbm1 = byZhubIdAndHh.getSpbm();
                                    String spbm2 = xsfhd_zib.getSpbm();
                                    if(!spbm1.equals(spbm2)){ //2.3有行号，发货状态未结束0，但是商品编码不对应(其实应该验证商品的所有信息，为了简便省略了那些属性)
                                        addFlag = 0;
                                        pageInfo.setResFlag("0");
                                        pageInfo.add("当销售发货单行号为"+hh+"的时候:"+"对应的发货编码不对!");
                                        break;
                                    }else {
                                        //应发数量
                                        Long count = byZhubIdAndHh.getCount();
                                        Long yfsl = xsfhd_zib.getYfsl();
                                        if(count < yfsl){
                                            addFlag = 0;
                                            pageInfo.setResFlag("0");
                                            pageInfo.add("当销售发货单行号为"+hh+"的时候:"+"当前发货数量大于了总销售数量!");
                                            break;
                                        }else {//该发货单子表通过考核
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if(addFlag == 1){ //检查了所有子表合理 /*开始添加子表*/
                //添加主表
                iXsfhd_zhubDao.save(xsfhd_zhub);
                //根据单据号ddh查询出主表信息,得到主表id
                Xsfhd_zhub xsfhd_zhub1 = iXsfhd_zhubDao.findByDdh(xsfhd_zhub.getDdh());
                Integer xsfhd_zhub_id = xsfhd_zhub1.getXsfhd_zhub_id();
                if (xsfhd_zibs != null) {
                    for (Xsfhd_zib xsfhd_zib : xsfhd_zibs) {
                        if (xsfhd_zib.getSpbm() != null && !"".equals(xsfhd_zib.getSpbm())) {
                            String ytdjh = xsfhd_zib.getYtdjh();//源头订单号
                            Integer ythh = xsfhd_zib.getYthh();//源头行号
                            //主表
                            Xsdd_zhub byDdh = iXsdd_zhubDao.findByDdh(ytdjh);
                            //子表
                            Xsdd_zib byZhubIdAndHh = iXsdd_zibDao.findByZhubIdAndHh(byDdh.getXsdd_zhub_id(), ythh);
                            //获取累计发货数量
                            Long ljfhsl1 = byZhubIdAndHh.getLjfhsl();
                            xsfhd_zib.setLjfhsl(ljfhsl1); //设置累计发货数量
                            xsfhd_zib.setXsfhd_zhub_id(xsfhd_zhub_id); //设置销售发货单主表id(外键)
                            iXsfhd_zibDao.save(xsfhd_zib);
                        }
                    }
                }
                pageInfo.setResFlag("1");
                System.out.println("111111");
            }
            System.out.println("???????");
        }else {
            System.out.println("22222");
            //添加主表
            iXsfhd_zhubDao.save(xsfhd_zhub);
            pageInfo.setResFlag("1");
        }
        return pageInfo;
    }


    @Override
    public List<Xsfhd_zhub> findByXsfhd_zhub(Xsfhd_zhub xsfhd_zhub) throws Exception {
        DomainAttrValueConverterUtils<Xsfhd_zhub> handler = new DomainAttrValueConverterUtils<>(xsfhd_zhub);
        Xsfhd_zhub x = handler.handler(null, "sfsp","spsftg","sfth", "sfckjs","sfkpjs","status");
        List<Xsfhd_zhub> xsfhd_zhubs = iXsfhd_zhubDao.findByZhub(x);
        return xsfhd_zhubs;
    }

    @Override
    public Xsfhd_zhub findXsfhd_zhubById(Integer xsfhd_zhub_id) throws Exception {
        Xsfhd_zhub xsfhd_zhub = iXsfhd_zhubDao.findById(xsfhd_zhub_id);
        return xsfhd_zhub;
    }

    @Override
    public void updateXsfhd_zhubById(Xsfhd_zhub xsfhd_zhub) throws Exception {
        if(xsfhd_zhub.getStatus() == 1){
            throw new MyException("已经结束，不能修改！");
        }
        iXsfhd_zhubDao.updateById(xsfhd_zhub);
    }

    @Override
    public void deleteXsfhd_ZhubById(Integer xsfhd_zhub_id) throws Exception {
        iXsfhd_zhubDao.deleteById(xsfhd_zhub_id);
    }

    @Override
    public void saveXsfhd_zhub(Xsfhd_zhub xsfhd_zhub) throws Exception {
        iXsfhd_zhubDao.save(xsfhd_zhub);
    }

    @Override
    public void deleteXsfhd_ZhubByIds(String ids) throws Exception {
        Integer[] integers = StringToIntegerUtils.converter(ids, ",");
        for (Integer integer:integers) {
            iXsfhd_zhubDao.deleteById(integer);
        }
    }

    @Override
    public List<Xsfhd_zib> findXsfhd_zibByZhubId(Integer xsfhd_zhub_id) throws Exception {
        List<Xsfhd_zib> xsfhd_zibs = iXsfhd_zibDao.findByZhubId(xsfhd_zhub_id);
        return xsfhd_zibs;
    }

    @Override
    public Xsfhd_zib findXsfhd_zibById(Integer xsfhd_zib_id) throws Exception {
        Xsfhd_zib xsfhd_zib = iXsfhd_zibDao.findById(xsfhd_zib_id);
        return xsfhd_zib;
    }

    @Override
    public void deleteXsfhd_ZibById(Integer xsfhd_zib_id) throws Exception {
        iXsfhd_zibDao.deleteById(xsfhd_zib_id);
    }

    @Override
    public void deleteXsfhd_ZibByIds(String ids) throws Exception {
        Integer[] integers = StringToIntegerUtils.converter(ids, ",");
        for (Integer integer:integers) {
            if(integer != null){
                iXsfhd_zibDao.deleteById(integer);
            }
        }
    }

    @Override
    public Integer getZib_hh(Integer xsfhd_zhub_id) throws Exception {
        Integer hh = iXsfhd_zibDao.findMaxHhByZhubId(xsfhd_zhub_id);
        if(hh == null){
            return 1;
        }
        return hh+1;
    }

    @Override
    public void saveXsfhd_zib(Xsfhd_zib xsfhd_zib) throws Exception {
        iXsfhd_zibDao.save(xsfhd_zib);
    }

    @Override
    public List<Xsfhd_zhub> findAllAndSfspIsZero(Xsfhd_zhub xsfhd_zhub) throws Exception {
        DomainAttrValueConverterUtils<Xsfhd_zhub> handler = new DomainAttrValueConverterUtils<>(xsfhd_zhub);
        Xsfhd_zhub x = handler.handler(null, "sfsp","spsftg","sfth","sfckjs","sfkpjs","status");
        List<Xsfhd_zhub> xsfhd_zhubs = iXsfhd_zhubDao.findAllAndSfspIsZero(x);
        return xsfhd_zhubs;
    }

    @Override
    public void spForbidden(String ddh, String spr, Date sprq) throws Exception {
        Xsfhd_zhub xsfhd_zhub = iXsfhd_zhubDao.findByDdh(ddh);
        if(xsfhd_zhub.getSfsp() == 1){
            throw new MyException("已经审批!不能再审批!");
        }else {
            xsfhd_zhub.setSfsp(1);
            xsfhd_zhub.setSpsftg(0);
            xsfhd_zhub.setSpr(spr);
            xsfhd_zhub.setSpsj(sprq);
            iXsfhd_zhubDao.updateById(xsfhd_zhub);
        }
    }

    @Override
    public void spAdopt(String ddh, String spr, Date sprq) throws Exception {
        Xsfhd_zhub xsfhd_zhub = iXsfhd_zhubDao.findByDdh(ddh);
        if(xsfhd_zhub.getSfsp() == 1){
            throw new MyException("已经审批!不能再审批!");
        }else {
            xsfhd_zhub.setSfsp(1);
            xsfhd_zhub.setSpsftg(1);
            xsfhd_zhub.setSpr(spr);
            xsfhd_zhub.setSpsj(sprq);
            iXsfhd_zhubDao.updateById(xsfhd_zhub);
        }
    }

    @Override
    public void updateZibStatusByIds(String ids,String xgr, Date xgsj) throws Exception {
        //1,判断是否发货单子表可以修改
        Integer[] integers = StringToIntegerUtils.converter(ids, ",");
        int statusFlag = 1;
        for (Integer integer:integers) {
            if(integer != null){
                Xsfhd_zib xsfhd_zib = iXsfhd_zibDao.findById(integer);
                if(xsfhd_zib != null){
                    if(xsfhd_zib.getStatus() == 1){
                        statusFlag = 0;
                        break;
                    }
                }
            }
        }

        //2,修改发货单，销售订单信息
        if(statusFlag == 0){
            System.out.println("其中至少一个子表的状态以及结束1，不能重复发货!");
            throw new MyException("其中至少一个子表的状态以及结束1，不能重复发货!");
        }else {
            //修改【销售发货单子表】信息，销售订单信息
            for (Integer xsfhd_zib_id:integers) {
                if(xsfhd_zib_id!=null){
                    Xsfhd_zib xsfhd_zib = iXsfhd_zibDao.findById(xsfhd_zib_id);//根据id查询出【销售发货单子表】
                    if(xsfhd_zib == null){
                        System.out.println("根据id=" + xsfhd_zib_id + "查询销售出库子单为NULL!");
                        throw new MyException("根据id=" + xsfhd_zib_id + "查询销售出库子单为NULL!");
                    }else {
                        String lydjh = xsfhd_zib.getLydjh();//获取【销售订单主表】单据号
                        Integer lyhh = xsfhd_zib.getLyhh();//获取【销售订单子表】行号
                        Xsdd_zhub xsdd_zhub1 = iXsdd_zhubDao.findByDdh(lydjh);//【销售订单主表】
                        Xsdd_zib xsdd_zib1 = iXsdd_zibDao.findByZhubIdAndHh(xsdd_zhub1.getXsdd_zhub_id(), lyhh);//【销售订单子表】

                        //2.1，修改【销售发货子单】状态
                        xsfhd_zib.setStatus(1);
                        iXsfhd_zibDao.updateById(xsfhd_zib);

                        Long sfsl = xsfhd_zib.getSfsl();//【销售发货子单】的实发数量
                        Long ljfhsl = xsdd_zib1.getLjfhsl();//【销售订单子表】的累计发货数量

                        if((sfsl+ljfhsl) > xsdd_zib1.getCount()){//发货累计超额
                            System.out.println("累计发货数量超额!");
                            throw new MyException("累计发货数量超额!");
                        }else if((sfsl+ljfhsl) == xsdd_zib1.getCount()){//销售的发货结束
                            //2.2,修改【销售订单子单】
                            xsdd_zib1.setLjfhsl(sfsl+ljfhsl);//修该【销售订单子单】的累计发货数量
                            xsdd_zib1.setSffhgb(1);//修该【销售订单子单】的是否发货结束 1
                            iXsdd_zibDao.updateById(xsdd_zib1);
                            //2.3，修改【销售订单主单】
                            int flag = 1;
                            List<Xsdd_zib> xsdd_zib2s = iXsdd_zibDao.findByZhubId(xsdd_zhub1.getXsdd_zhub_id());
                            for (Xsdd_zib x:xsdd_zib2s) {
                                if(x.getSffhgb() == 0){
                                    flag = 0;
                                    break;
                                }
                            }
                            if(flag == 1){
                                xsdd_zhub1.setFhbz(1);
                            }else {
                                xsdd_zhub1.setFhbz(0);
                            }
                            iXsdd_zhubDao.updateById(xsdd_zhub1);
                            //2.4，修改【销售订子单】下所有对应的【销售发货子单】的累计发货数量
                            List<Xsfhd_zib> xxs = iXsfhd_zibDao.findByLydjhAndLyhh(lydjh,lyhh);
                            for (Xsfhd_zib xxxs:xxs) {
                                xxxs.setLjfhsl(sfsl+ljfhsl);//修该【销售发货单子单】的累计发货数量
                                iXsfhd_zibDao.updateById(xxxs);
                            }
                        }else {//发货累计不足
                            //2.1,修改【销售订单子单】
                            xsdd_zib1.setLjfhsl(sfsl+ljfhsl);//修该【销售订单子单】的累计发货数量
                            iXsdd_zibDao.updateById(xsdd_zib1);
                            //2.2，修改【销售订子单】下所有对应的【销售发货单子单】的累计发货数量
                            List<Xsfhd_zib> xxs = iXsfhd_zibDao.findByLydjhAndLyhh(lydjh,lyhh);
                            for (Xsfhd_zib xxxs:xxs) {
                                xxxs.setLjfhsl(sfsl+ljfhsl);//修该【销售发货单子单】的累计发货数量
                                iXsfhd_zibDao.updateById(xxxs);
                            }
                        }
                    }
                }
            }
            //修改【销售发货单主表】信息
            for (Integer xsfhd_zib_id:integers) {
                if(xsfhd_zib_id!=null){
                    Xsfhd_zib xsfhd_zib = iXsfhd_zibDao.findById(xsfhd_zib_id);//根据id查询出【销售发货单子表】
                    if(xsfhd_zib!=null){
                        Xsfhd_zhub byId = iXsfhd_zhubDao.findById(xsfhd_zib.getXsfhd_zhub_id());
                        byId.setXgr(xgr);
                        byId.setXgsj(xgsj);
                        //判断是否status结束
                        List<Xsfhd_zib> xs = iXsfhd_zibDao.findByZhubId(byId.getXsfhd_zhub_id());
                        int flag = 1;
                        for (Xsfhd_zib x:xs) {
                            if(x.getStatus() == 0){
                                flag = 0;
                                break;
                            }
                        }
                        if(flag == 1){
                            byId.setStatus(1);
                        }else {
                            byId.setStatus(0);
                        }
                        iXsfhd_zhubDao.updateById(byId);
                    }
                }
            }
        }
    }
}

package cn.cuit.gyl.service.business.impl;

import cn.cuit.gyl.dao.business.IXsdd_zhubDao;
import cn.cuit.gyl.dao.business.IXsdd_zibDao;
import cn.cuit.gyl.dao.business.IXsysdZhibDao;
import cn.cuit.gyl.dao.business.IXsysdZubDao;
import cn.cuit.gyl.domain.business.Xsdd_zhub;
import cn.cuit.gyl.domain.business.Xsdd_zib;
import cn.cuit.gyl.domain.business.Xsysdzhib;
import cn.cuit.gyl.domain.business.Xsysdzhub;
import cn.cuit.gyl.service.business.IXsysdService;
import cn.cuit.gyl.utils.DomainAttrValueConverterUtils;
import cn.cuit.gyl.utils.PageInfo;
import cn.cuit.gyl.utils.StringConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class XsysdServiceImpl implements IXsysdService {

    @Autowired
    @Qualifier("iXsysdZubDao")
    private IXsysdZubDao iXsysdZubDao;
    @Autowired
    @Qualifier("iXsysdZhibDao")
    private IXsysdZhibDao iXsysdZhibDao;
    @Autowired
    @Qualifier("iXsdd_zhubDao")
    private IXsdd_zhubDao iXsdd_zhubDao;
    @Autowired
    @Qualifier("iXsdd_zibDao")
    private IXsdd_zibDao iXsdd_zibDao;

    @Override
    public List<Xsysdzhub> findByCondition(Xsysdzhub xsysdzhub) throws Exception {
        DomainAttrValueConverterUtils<Xsysdzhub> handler=new DomainAttrValueConverterUtils<>(xsysdzhub);
        xsysdzhub =handler.handler(null,"sxbz");
        List<Xsysdzhub> byAll = iXsysdZubDao.findByAll(xsysdzhub);
        return byAll;
    }

    @Override
    public List<Xsysdzhub> findByNoSh(Xsysdzhub xsysdzhub) throws Exception {
        DomainAttrValueConverterUtils<Xsysdzhub> handler=new DomainAttrValueConverterUtils<>(xsysdzhub);
        xsysdzhub =handler.handler(null,"sxbz");
        List<Xsysdzhub> byAll = iXsysdZubDao.findByAll(xsysdzhub);
        if (byAll !=null){
            for (int i = 0;i<byAll.size();i++){
                if (!byAll.get(i).getSher().equals("")||byAll.get(i).getShrq() !=null){
                    byAll.remove(i);
                }
            }
        }
        return byAll;
    }

    @Override
    public List<Xsysdzhib> findZiByZid(Long zid) throws Exception {
        List<Xsysdzhib> byZid = iXsysdZhibDao.findByZid(zid);
        return byZid;
    }

    @Override
    public Xsysdzhib findZiById(Long id) throws Exception {
        Xsysdzhib byId = iXsysdZhibDao.findById(id);
        return byId;
    }

    @Override
    public List<Xsysdzhub> findBySxBzIsOne(Xsysdzhub xsysdzhub) throws Exception {
        List<Xsysdzhub> byAll = iXsysdZubDao.findByAll(xsysdzhub);
        if (byAll !=null){
            for (int i = 0;i<byAll.size();i++){
                if (!byAll.get(i).getQzr().equals("")||byAll.get(i).getQzrq() !=null){
                    byAll.remove(i);
                }
            }
        }
        return byAll;
    }

    @Override
    public Long getZib_hh(Long zid) throws Exception {
        List<Xsysdzhib> byZid = iXsysdZhibDao.findByZid(zid);
        Long x = 0L;
        if (byZid != null){
            for (Xsysdzhib a:byZid){
                if (a.getHh() >=x){
                    x = a.getHh();
                }
            }
        }
        return x+1;
    }

    @Override
    public Xsysdzhub findZhuById(Long id) throws Exception {
        Xsysdzhub byId = iXsysdZubDao.findById(id);
        return byId;
    }

    @Override
    public PageInfo UpdateXsYsZhuB(Xsysdzhub xsysdzhub) throws Exception {
        PageInfo pageInfo = new PageInfo();
        List<String> msgList = pageInfo.getMsgList();
        pageInfo.setResFlag("1");
        if (xsysdzhub.getXgr() == null||xsysdzhub.getXgrq() == null){
            pageInfo.setResFlag("0");
            msgList.add("修改人或修改日期为空");
            return pageInfo;
        }
        iXsysdZubDao.updateById(xsysdzhub);

        return pageInfo;
    }

    @Override
    public void DeleteXsYsZhuBByID(Long id) throws Exception {
        iXsysdZhibDao.deleteByZid(id);
        iXsysdZubDao.deleteById(id);
    }

    @Override
    public void DeleteXsYsZhuBByIDs(String ids) throws Exception {
        Long[] IDS = StringConverterUtils.convertToLong(ids, ",");
        if (IDS != null){
            for (Long id:IDS){
                iXsysdZhibDao.deleteByZid(id);
                iXsysdZubDao.deleteById(id);
            }
        }
    }

    @Override
    public PageInfo AddXsYsZhuB(Xsysdzhub xsysdzhub) throws Exception {
        DomainAttrValueConverterUtils<Xsysdzhub> handler=new DomainAttrValueConverterUtils<>(xsysdzhub);
        xsysdzhub =handler.handler(null,"sxbz");
        PageInfo pageInfo = new PageInfo();
        List<String> msgList = pageInfo.getMsgList();
        pageInfo.setResFlag("1");
        if (xsysdzhub.getZdr() == null||xsysdzhub.getZdrq() == null){
            pageInfo.setResFlag("0");
            msgList.add("制单人或制单日期为空");
            return pageInfo;
        }
        iXsysdZubDao.save(xsysdzhub);
        Xsysdzhub byDdh = iXsysdZubDao.findByDdh(xsysdzhub.getDdh());
        if (xsysdzhub.getXsysdzhibs() !=null){
            List<Xsysdzhib> xsysdzhibs = xsysdzhub.getXsysdzhibs();
            for (Xsysdzhib a:xsysdzhibs){
                if (a.getDw()!=null){
                    a.setZid(byDdh.getXsysdzhubid());
                    iXsysdZhibDao.save(a);
                }

            }
        }
        return pageInfo;
    }

    @Override
    public PageInfo UpdateXsYsZhiB(String xgr, Date xgrq, Xsysdzhib xsysdzhib) throws Exception {
        PageInfo pageInfo = new PageInfo();
        List<String> msgList = pageInfo.getMsgList();
        pageInfo.setResFlag("1");
        if (xgr == null||xgrq == null){
            pageInfo.setResFlag("0");
            msgList.add("修改人或修改日期为空");
            return pageInfo;
        }
        iXsysdZhibDao.updateById(xsysdzhib);
        return pageInfo;
    }

    @Override
    public void DeleteXsYsZhiBByID(Long id) throws Exception {
        iXsysdZhibDao.deleteById(id);
    }

    @Override
    public void DeleteXsYsZhiBByIDs(String ids) throws Exception {
        Long[] IDS = StringConverterUtils.convertToLong(ids, ",");
        if (IDS != null){
            for (Long id:IDS){
                iXsysdZhibDao.deleteById(id);
            }
        }
    }


    @Override
    public PageInfo AddXsYsZhiB(Xsysdzhib xsysdzhib, String xgr, Date xgrq) throws Exception {
        PageInfo pageInfo = new PageInfo();
        List<String> msgList = pageInfo.getMsgList();
        pageInfo.setResFlag("1");
        if (xgr == null||xgrq == null){
            pageInfo.setResFlag("0");
            msgList.add("修改人或修改日期为空");
            return pageInfo;
        }
        iXsysdZhibDao.save(xsysdzhib);
        return pageInfo;
    }

    @Override
    public PageInfo shOK(String shr, Date shrq, String ddh) throws Exception {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setResFlag("1");
        Xsysdzhub xsysdzhub = iXsysdZubDao.findByDdh(ddh);
        List<Xsysdzhib> byZid = iXsysdZhibDao.findByZid(xsysdzhub.getXsysdzhubid());
        List<String> msgList = pageInfo.getMsgList();

        if (shr == null||shrq == null){
            pageInfo.setResFlag("0");
            msgList.add("审核人或审核日期为空");
            return pageInfo;
        }
        if (xsysdzhub.getZdr().equals(shr)){
            pageInfo.setResFlag("0");
            msgList.add("审核人不能和制单人一样");
            return pageInfo;
        }
        if (byZid == null||byZid.size() ==0){
            pageInfo.setResFlag("0");
            msgList.add("无子表 无意义");
            return pageInfo;
        }
        xsysdzhub.setSher(shr);
        xsysdzhub.setShrq(shrq);
        xsysdzhub.setSxbz(1);
        iXsysdZubDao.updateById(xsysdzhub);
        return pageInfo;
    }

    @Override
    public PageInfo shNo(String shr, Date shrq, String ddh) throws Exception {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setResFlag("1");
        Xsysdzhub xsysdzhub = iXsysdZubDao.findByDdh(ddh);
        List<String> msgList = pageInfo.getMsgList();
        if (shr == null||shrq == null){
            pageInfo.setResFlag("0");
            msgList.add("审核人或审核日期为空");
            return pageInfo;
        }
        xsysdzhub.setSher(shr);
        xsysdzhub.setShrq(shrq);
        xsysdzhub.setSxbz(0);
        iXsysdZubDao.updateById(xsysdzhub);
        return pageInfo;
    }



    /**
     * 1、计算累计应收数量，并且把累计应收数量回写到
     *      销售应收单子表中的累计应收数量中
     *      销售订单子表中的累计应收数量中
     * 2、判断是否应收关闭
     *      如果应收关闭了，则
     *         1、
     *            销售应搜单子表中的是否应收关闭设置为true
     *            销售订单子表中的是否应收关闭设置为true
     *            销售订单子表中针对该商品进行行关闭
     *         2、得到销售订单的子表的数据(集合)
     *            循环遍历集合，判断每一种商品的行是否关闭了，如果都关闭了，说明整个销售订单已经完成了
     *                 如果没有都关闭，继续走流程
     */
    @Override
    public PageInfo qz(String qzr, Date qzrq, String ddh) throws Exception {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setResFlag("1");
        List<String> msgList = pageInfo.getMsgList();
        if (qzr == null||qzrq == null){
            pageInfo.setResFlag("0");
            msgList.add("签字人或签字日期为空");
            return pageInfo;
        }
        Xsysdzhub xsysdzhub = iXsysdZubDao.findByDdh(ddh);
        List<Xsysdzhib> xsysdzhibs = iXsysdZhibDao.findByZid(xsysdzhub.getXsysdzhubid());
        for (Xsysdzhib a:xsysdzhibs){
            String ytdjh = a.getYtdjh();//得到源头的单据号
            Integer ythh = a.getYthh();//得到源头的行号
            Xsdd_zhub byDdh = iXsdd_zhubDao.findByDdh(ytdjh);//得到源头的订单
            Xsdd_zib byZhubIdAndHh = iXsdd_zibDao.findByZhubIdAndHh(byDdh.getXsdd_zhub_id(), ythh);//得到订单的子表
            Long sl = a.getSl();//得到应收的数量
            Long ljyssl = byZhubIdAndHh.getLjyssl();//得到之前累积的数量
            if (byZhubIdAndHh.getStatus() == 1){
                    pageInfo.setResFlag("0");
                    msgList.add("应收已结束");
                    return pageInfo;
            }
            if (byDdh.getStatus() == 1){
                pageInfo.setResFlag("0");
                msgList.add("改订单已结束");
                return pageInfo;
            }
            byZhubIdAndHh.setLjyssl(sl+ljyssl);//更新累积的应收数量
            a.setLjyssl(sl+ljyssl);//更新累积的应收数量
            if (byZhubIdAndHh.getCount().equals(byZhubIdAndHh.getLjyssl()) ){
                //判断应收是否结束
                byZhubIdAndHh.setSfskgb(1);
                a.setIsysgb(1);
                byZhubIdAndHh.setStatus(1);
                List<Xsdd_zib> byZhubId = iXsdd_zibDao.findByZhubId(byDdh.getXsdd_zhub_id());
                int flag = 0;
                for (Xsdd_zib xsdd_zib:byZhubId){
                    if (xsdd_zib.getStatus() == 0){
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0){
                    byDdh.setStatus(1);
                }//判断该订单的所有子表是不是全部结束
            }
            System.out.println("销售z"+byZhubIdAndHh);
            System.out.println("xsdd"+byDdh);
            iXsdd_zibDao.updateById(byZhubIdAndHh);
            iXsdd_zhubDao.updateById(byDdh);
            iXsysdZhibDao.updateById(a);
        }
        xsysdzhub.setXsysdzhibs(xsysdzhibs);
        xsysdzhub.setQzr(qzr);
        xsysdzhub.setQzrq(qzrq);
        iXsysdZubDao.updateById(xsysdzhub);
        return null;
    }
}

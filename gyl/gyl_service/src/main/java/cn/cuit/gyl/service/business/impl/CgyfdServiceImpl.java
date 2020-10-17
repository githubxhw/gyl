package cn.cuit.gyl.service.business.impl;

import cn.cuit.gyl.dao.business.*;
import cn.cuit.gyl.domain.business.*;
import cn.cuit.gyl.exception.MyException;

import cn.cuit.gyl.service.business.CgyfdService;
import cn.cuit.gyl.utils.DomainAttrValueConverterUtils;
import cn.cuit.gyl.utils.PageInfo;
import cn.cuit.gyl.utils.StringConverterUtils;
import cn.cuit.gyl.utils.StringToIntegerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("CgyfdService")
public class CgyfdServiceImpl implements CgyfdService {

    //订单（源头）
    @Autowired
    @Qualifier("cgdddao")
    cgdddao cgdddao;


    @Autowired
    @Qualifier("cgddzhidao")
    cgddzhidao cgddzhidao;

    //发票（来源）
    @Autowired
    ICgfp_zhubDao iCgfp_zhubDao;

    @Autowired
    ICgfp_zibDao iCgfp_zibDao;

    //应付
    @Autowired
    ICgyfd_zhubDao iCgyfd_zhubDao;

    @Autowired
    ICgyfd_zibDao iCgyfd_zibDao;
    @Override

    //保存主表和子表
    public PageInfo saveZhubAndZib(Cgyfd_zhub cgyfd_zhub) throws Exception {
        PageInfo pageInfo = new PageInfo();
        ArrayList<Cgyfd_zib> zibs = cgyfd_zhub.getCgyfd_zibs();
        int addflag = 1;//1可，0否
        if(zibs != null){
            for (Cgyfd_zib zib: zibs) {
                String spbm = zib.getSpbm();
                if(spbm == null || spbm.equals("")){
                    pageInfo.setResFlag("0");
                    pageInfo.add("该商品无编码");
                    break;
                }
                else{
                    String ytdjh = zib.getYtdjh();
                    int ythh = zib.getYthh();
                    int hh = zib.getHh();
                    int sl = zib.getSl();

                    pageInfo = YtdjhIsSure(ytdjh,ythh,hh,spbm,sl);
                    if(pageInfo.getResFlag().equals("0")){
                        addflag = 0;
                        break;
                    }
                    else{
                        String lydjh = zib.getLydjh();
                        int lyhh = zib.getLyhh();
                        pageInfo = lydjhIsSure(lydjh,lyhh,hh,spbm);
                        if(pageInfo.getResFlag().equals("0")){
                            addflag = 0;
                            break;
                        }
                    }
                }
            }
            if(addflag==1){
                //保存组表
                iCgyfd_zhubDao.save(cgyfd_zhub);
                //获取由数据库生成的主表id
                int zhuid = iCgyfd_zhubDao.findZhubByDjh(cgyfd_zhub.getDjh()).getCgyfd_zhu_id();
                for (Cgyfd_zib zib:zibs) {
                    //从源头子表获取累计应付数量
                    String ytdjh = zib.getYtdjh();
                    int ythh = zib.getYthh();
                    Cgddzhub cgddzhub = cgdddao.findByDjh(ytdjh);
                    Cgddzhib cgddzhib = cgddzhidao.findByZIdAndHh(cgddzhub.getCgddzhubid(),ythh);
                    Long ljysfl = cgddzhib.getLjyfsl()+zib.getSl();

                    UpdateLjyfsl(ljysfl.intValue() ,ytdjh, ythh, cgddzhib);
                    //设置累计应付数量
                    zib.setLjyfsl(ljysfl.intValue());
                    zib.setZhu_id(zhuid);

                    //保存子表
                    iCgyfd_zibDao.save(zib);
                }
                pageInfo.setResFlag("1");
            }



        }else {
            iCgyfd_zhubDao.save(cgyfd_zhub);
            pageInfo.setResFlag("1");
        }
        return pageInfo;
    }

    @Override
    public void saveZib(Cgyfd_zib cgyfd_zib) {
        iCgyfd_zibDao.save(cgyfd_zib);
    }


    //依据源头单据号核对信息
    private PageInfo YtdjhIsSure(String ytdjh, int ythh, int hh, String spbm, int sl){
        PageInfo pageInfo = new PageInfo();//信息
        pageInfo.setResFlag("1");//初始化flag

        //获取源头主表
        Cgddzhub cgddzhub = cgdddao.findByDjh(ytdjh);
        //判断源头主表是否存在
        if(cgddzhub == null){
            pageInfo.setResFlag("0");
            pageInfo.add("应付单行号为"+hh+"的时候:"+"采购订单中没有"+ytdjh+"的单据号!");
        }
        else if(cgddzhub.getYsbz() == 1){
            pageInfo.setResFlag("0");
            pageInfo.add("应付单行号为"+hh+"的时候:"+"采购订单中"+ytdjh+"的单据号应付以结束!");
        }
        else {
            //判断源头字表是否存在
            Cgddzhib cgddzhib = cgddzhidao.findByZIdAndHh(cgddzhub.getCgddzhubid(),ythh);
            if(cgddzhib == null){
                pageInfo.setResFlag("0");
                pageInfo.add("应付单行号为"+hh+"的时候:"+"采购订单子表中没有行号为"+ythh+"的单据号!");
            }
            else if(cgddzhib.getSffkgb() == 1){
                pageInfo.setResFlag("0");
                pageInfo.add("应付单行号为"+hh+"的时候:"+"采购订单子表中行号为"+ythh+"的单据号付款已结束!");
            }
            else if(!cgddzhib.getSpbm().equals(spbm)){
                pageInfo.setResFlag("0");
                pageInfo.add("应付单行号为"+hh+"的时候:"+"与采购订单子表中行号为"+ythh+"的单据号商品编码不符合");
            }
            else if(sl > cgddzhib.getSl() - cgddzhib.getLjyfsl()){
                pageInfo.setResFlag("0");
                pageInfo.add("应付单行号为"+hh+"的时候:"+"应付数量大于实际数量");
            }
        }
        return pageInfo;
    }

    //依据来源单据号核对信息
    private PageInfo lydjhIsSure(String lydjh, int lyhh, int hh, String spbm) throws Exception {
        PageInfo pageInfo = new PageInfo();//信息
        pageInfo.setResFlag("1");//初始化flag

        //获取来源主表
        Cgfp_zhub cgfp_zhub = iCgfp_zhubDao.findByFph(lydjh);
        //判断来源主表是否存在
        if(cgfp_zhub == null){
            pageInfo.setResFlag("0");
            pageInfo.add("应付单行号为"+hh+"的时候:"+"采购发票中没有"+lydjh+"的单据号!");
        }
        else if(cgfp_zhub.getIsycyf() == 1){
            pageInfo.setResFlag("0");
            pageInfo.add("应付单行号为"+hh+"的时候:"+"采购发票中"+lydjh+"的单据号应付以结束!");
        }
        else {
            //判断来源字表是否存在
            Cgfp_zib cgfp_zib = iCgfp_zibDao.findByZhubIdAndHh(cgfp_zhub.getCgfp_zhub_id(),lyhh);
            if(cgfp_zib == null){
                pageInfo.setResFlag("0");
                pageInfo.add("应付单行号为"+hh+"的时候:"+"采购发票子表中没有行号为"+lyhh+"的单据号!");
            }
            else if(!cgfp_zib.getChbm().equals(spbm)){
                pageInfo.setResFlag("0");
                pageInfo.add("应付单行号为"+hh+"的时候:"+"与采购发票子表中行号为"+lyhh+"的单据号商品编码不符合");
            }
        }
        return pageInfo;
    }


    @Override
    public ArrayList findByCgyfdZhub(Cgyfd_zhub cgyfd_zhub) throws Exception {
        DomainAttrValueConverterUtils<Cgyfd_zhub> handler = new DomainAttrValueConverterUtils<>(cgyfd_zhub);
        Cgyfd_zhub x = handler.handler(null, "sxbz","status");
        ArrayList<Cgyfd_zhub> list = iCgyfd_zhubDao.findByZhub(x);
        return  list;
    }

    @Override
    public Cgyfd_zhub findZhuById(int zhuId) {
        return iCgyfd_zhubDao.findZhubById(zhuId);
    }

    @Override
    public Cgyfd_zib findZibByZiId(int ziId) {
        return iCgyfd_zibDao.findById(ziId);
    }

    @Override
    public ArrayList<Cgyfd_zib> findZibByZhuId(int zhuId) {
        return iCgyfd_zibDao.findByZhuId(zhuId);
    }

    @Override
    public void DeleteZhubById(int zhuId) {
        iCgyfd_zhubDao.deleteById(zhuId);
    }

    @Override
    public void DeleteZibById(int ziId) {
        iCgyfd_zibDao.deleteById(ziId);
    }

    @Override
    public void DeleteZhubByIds(String zhuIds) {
        Integer[] ids = StringConverterUtils.convertToInteger(zhuIds, ",");
        if (ids != null){
            for (Integer id: ids){
                iCgyfd_zibDao.findByZhuId(id);
                iCgyfd_zhubDao.deleteById(id);
            }
        }
    }

    @Override
    public void DeleteZibByIds(String ziIds) {
        Integer[] ids = StringConverterUtils.convertToInteger(ziIds, ",");
        if (ids != null){
            for (Integer id: ids){
                iCgyfd_zibDao.deleteById(id);
            }
        }
    }

    @Override
    public void UpdateZhub(Cgyfd_zhub cgyfd_zhub) throws MyException {
        Integer status = cgyfd_zhub.getStatus();
        if(status == null || status == 0){
            iCgyfd_zhubDao.updateById(cgyfd_zhub);
        }
        else {
            throw new MyException("应付以结束，不能修改");
        }
    }

    @Override
    public void UpdateZib(Cgyfd_zib cgyfd_zib) throws Exception {
        Integer status = cgyfd_zib.getStatus();

        String ytdjh = cgyfd_zib.getYtdjh();
        Cgddzhub cgddzhub = cgdddao.findByDjh(ytdjh);
        Cgddzhib cgddzhib = cgddzhidao.findByZIdAndHh(cgddzhub.getCgddzhubid(),cgyfd_zib.getYthh());
        if(status == null || status == 0){
            //更改累计应付数量
            int yuanSl = iCgyfd_zibDao.findById(cgyfd_zib.getCgyfd_zib_id()).getSl();
            int ljyfsl = cgyfd_zib.getLjyfsl() + cgyfd_zib.getSl()-yuanSl;
            UpdateLjyfsl(ljyfsl, cgyfd_zib.getYtdjh(),cgyfd_zib.getYthh(),cgddzhib);
            iCgyfd_zibDao.updateById(cgyfd_zib);
        }
        else {
            UpdateDataForQz(cgyfd_zib, cgddzhib);
        }
    }



    private void UpdateDataForQz(Cgyfd_zib cgyfd_zib, Cgddzhib cgddzhib) throws Exception {
        //统一累计应付数量
        int ljyfsl = cgyfd_zib.getLjyfsl() + cgyfd_zib.getSl();
        int zhuId = cgyfd_zib.getZhu_id();



        UpdateLjyfsl(ljyfsl,  cgyfd_zib.getYtdjh(), cgyfd_zib.getHh(), cgddzhib);

        //判断子表是否全应付结束，并相应修改主表状态
        ArrayList<Cgyfd_zib> zibs = iCgyfd_zibDao.findByZhuId(zhuId);
        int flag = 0;
        for (Cgyfd_zib zib:zibs){
            if(zib.getStatus() == 1){
                flag++;
            }
        }
        if(flag == zibs.size()){
            Cgyfd_zhub cgyfd_zhub = iCgyfd_zhubDao.findZhubById(cgyfd_zib.getZhu_id());
            cgyfd_zhub.setStatus(1);
            UpdateZhub(cgyfd_zhub);
        }

        //通过数量判断源头单号是否应付结束
        if(cgddzhib.getSl() == ljyfsl){
            cgddzhib.setSffkgb(1);
            cgddzhidao.updateCgddzhib(cgddzhib);
        }

        //判断源头单号同主id是否都应付结束
        List<Cgddzhib> cgddzhibs = cgddzhidao.findByzid(cgddzhib.getZid());
        flag = 0;
        for (Cgddzhib zib: cgddzhibs){
            flag++;
        }
        if(flag == cgddzhibs.size()){
            Cgddzhub cgddzhub = cgdddao.findById(cgddzhib.getZid());
            cgddzhub.setYsbz(1);
            cgdddao.updateCgddzhub(cgddzhub);
        }

        //判断来源主表是否应付结束
        Cgfp_zhub cgfp_zhub = iCgfp_zhubDao.findByFph(cgyfd_zib.getLydjh());
        List<Cgfp_zib> cgfp_zibs = iCgfp_zibDao.findByZhubId(cgfp_zhub.getCgfp_zhub_id());
        flag = 0;
        for (Cgfp_zib zib:cgfp_zibs){
            if(IsLyJs(cgfp_zhub.getFph(),zib.getHh())){
                flag++;
            }
        }
        if(flag == cgfp_zibs.size()){
            cgfp_zhub.setIsycyf(1);
            iCgfp_zhubDao.updateById(cgfp_zhub);
        }

    }


    private void UpdateLjyfsl(Integer ljyfsl, String  ytdjh,int ythh, Cgddzhib cgddzhib) {
        //统一同一源头的累计应付数量
        ArrayList<Cgyfd_zib> zibs = iCgyfd_zibDao.findByYtdjhAndYthh(ytdjh, ythh);

        for (Cgyfd_zib zib:zibs){
            zib.setLjyfsl(ljyfsl);
            iCgyfd_zibDao.updateLjyfslById(zib);
        }

        //修改订单累计应付数量
        cgddzhib.setLjyfsl(ljyfsl.longValue());
        cgddzhidao.updateCgddzhib(cgddzhib);
    }

    private boolean IsLyJs(String lydjh, int lyhh){
        ArrayList<Cgyfd_zib> zibs= iCgyfd_zibDao.findByLydjhAndLyhh(lydjh, lyhh);
        int flag = 0;
        for (Cgyfd_zib zib:zibs){
            flag++;
        }

        if(flag == zibs.size()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public PageInfo qzByZhub(String djh, String qzr, Date qzsj) throws Exception {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setResFlag("1");
        Cgyfd_zhub cgyfd_zhub = iCgyfd_zhubDao.findZhubByDjh(djh);
        ArrayList<Cgyfd_zib> zibs = iCgyfd_zibDao.findByZhuId(cgyfd_zhub.getCgyfd_zhu_id());
        for (Cgyfd_zib zib: zibs){
            zib.setStatus(1);
            try {
                UpdateZib(zib);
            } catch (Exception e) {
                e.printStackTrace();
                pageInfo.setResFlag("0");
                pageInfo.add("跟新"+djh+"主表的"+zib.getHh()+"行状态失败");
            }
        }
        return pageInfo;
    }

    @Override
    public PageInfo spByZhub(String djh, String spr, Date spsj, int sxbz) throws Exception {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setResFlag("1");
        Cgyfd_zhub cgyfd_zhub = iCgyfd_zhubDao.findZhubByDjh(djh);
        cgyfd_zhub.setSxbz(sxbz);
        cgyfd_zhub.setSpr(spr);
        cgyfd_zhub.setSpsj(spsj);
        UpdateZhub(cgyfd_zhub);
        return pageInfo;
    }

    @Override
    public Integer getZib_hh(Integer zhuId) {
        return iCgyfd_zibDao.findMaxHhByZhubId(zhuId);
    }
}

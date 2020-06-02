package cn.cuit.gyl.service.business.impl;

import cn.cuit.gyl.dao.business.IEarlyWarning_XsckDao;
import cn.cuit.gyl.dao.business.IXsdd_zhubDao;
import cn.cuit.gyl.dao.business.IXsdd_zibDao;
import cn.cuit.gyl.domain.business.EarlyWarning_Xsck;
import cn.cuit.gyl.domain.business.Xsdd_zhub;
import cn.cuit.gyl.domain.business.Xsdd_zib;
import cn.cuit.gyl.service.business.IEarlyWarning_XsckService;
import cn.cuit.gyl.utils.ConverterUtils;
import cn.cuit.gyl.utils.PageInfo;
import cn.cuit.gyl.utils.StringConverterUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("earlyWarning_XsckServiceImpl")
public class EarlyWarning_XsckServiceImpl implements IEarlyWarning_XsckService {

    @Autowired
    @Qualifier("iEarlyWarning_XsfhDao")
    private IEarlyWarning_XsckDao  iEarlyWarning_XsfhDao = null;

    @Autowired
    @Qualifier("iXsdd_zhubDao")
    private IXsdd_zhubDao iXsdd_zhubDao = null;

    @Autowired
    @Qualifier("iXsdd_zibDao")
    private IXsdd_zibDao iXsdd_zibDao = null;

    @Override
    public EarlyWarning_Xsck findEWXByDjhAndHh(String ddh, Integer hh) throws Exception {
        PageHelper.startPage(1, 6);
        EarlyWarning_Xsck earlyWarning_xsck = iEarlyWarning_XsfhDao.findByDjhAndHh(ddh,hh);
        return earlyWarning_xsck;
    }

    @Override
    public List<EarlyWarning_Xsck> findEWXsByPage(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<EarlyWarning_Xsck> earlyWarning_xscks = iEarlyWarning_XsfhDao.findAll();
        return earlyWarning_xscks;
    }

    @Override
    public EarlyWarning_Xsck findEWXById(Long id) throws Exception {
        EarlyWarning_Xsck earlyWarning_xsck = iEarlyWarning_XsfhDao.findById(id);
        return earlyWarning_xsck;
    }

    @Override
    public PageInfo updateEWX(EarlyWarning_Xsck earlyWarning_xsck) throws Exception {
        PageInfo pageInfo = new PageInfo();
        List<String> msgList = pageInfo.getMsgList();

        int count = 0;//用于判断是否有错误信息
        Xsdd_zhub xsdd_zhub = iXsdd_zhubDao.findByDdh(earlyWarning_xsck.getDdh());//根据单据号查询销售订单主表
        if(xsdd_zhub == null){//若为null，证明ddh是错误的
            count--;
            msgList.add("该订单号不存在；");
        }else {
            Xsdd_zib xsdd_zib = iXsdd_zibDao.findByZhubIdAndHh(xsdd_zhub.getXsdd_zhub_id(), earlyWarning_xsck.getHh());//根据订单号和行号查询销售订单子表
            if(xsdd_zib == null){
                count--;
                msgList.add("单据号为"+earlyWarning_xsck.getDdh()+"的销售订单没有行号为"+earlyWarning_xsck.getHh()+"的商品信息记录。");
            }else {
                String spbm = xsdd_zib.getSpbm();
                String spmc = xsdd_zib.getSpmc();
                Date yqfhrq = xsdd_zib.getYqshrq();
                if(!earlyWarning_xsck.getProductNum().equals(spbm)){
                    count--;
                    msgList.add("商品编码与销售订单上不对应。");
                }
                if(!earlyWarning_xsck.getProductName().equals(spmc)){
                    count--;
                    msgList.add("商品名称与销售订单上不对应。");
                }
                if(!ConverterUtils.dateToString(yqfhrq,"yyyy-MM-dd HH:mm").equals(ConverterUtils.dateToString(earlyWarning_xsck.getYqfhrq(),"yyyy-MM-dd HH:mm"))){
                    count--;
                    msgList.add("要求发货日期与销售订单上不对应。");
                }
            }
        }
        if(count < 0){//证明信息有误
            pageInfo.setResFlag("0");
        }else {
            iEarlyWarning_XsfhDao.updateById(earlyWarning_xsck);
            pageInfo.setResFlag("1");
        }
        return pageInfo;
    }

    @Override
    public Long getMaxId() throws Exception {
        return iEarlyWarning_XsfhDao.findMaxId();
    }

    @Override
    public PageInfo saveEWX(EarlyWarning_Xsck earlyWarning_xsck) throws Exception {
        PageInfo pageInfo = new PageInfo();
        List<String> msgList = pageInfo.getMsgList();

        if(iEarlyWarning_XsfhDao.findByDjhAndHh(earlyWarning_xsck.getDdh(),earlyWarning_xsck.getHh()) != null){
            msgList.add("已经存在订单号为"+earlyWarning_xsck.getDdh()+"、行号为"+earlyWarning_xsck.getHh()+"的销售出库预警消息。");
            pageInfo.setResFlag("0");
            return pageInfo;
        }else {
            int count = 0;//用于判断是否有错误信息
            Xsdd_zhub xsdd_zhub = iXsdd_zhubDao.findByDdh(earlyWarning_xsck.getDdh());//根据单据号查询销售订单主表
            if(xsdd_zhub == null){//若为null，证明ddh是错误的
                count--;
                msgList.add("该订单号不存在；");
            }else {
                Xsdd_zib xsdd_zib = iXsdd_zibDao.findByZhubIdAndHh(xsdd_zhub.getXsdd_zhub_id(), earlyWarning_xsck.getHh());//根据订单号和行号查询销售订单子表
                if(xsdd_zib == null){
                    count--;
                    msgList.add("单据号为"+earlyWarning_xsck.getDdh()+"的销售订单没有行号为"+earlyWarning_xsck.getHh()+"的商品信息记录。");
                }else {
                    String spbm = xsdd_zib.getSpbm();
                    String spmc = xsdd_zib.getSpmc();
                    Date yqfhrq = xsdd_zib.getYqshrq();
                    if(!earlyWarning_xsck.getProductNum().equals(spbm)){
                        count--;
                        msgList.add("商品编码与销售订单上不对应。");
                    }
                    if(!earlyWarning_xsck.getProductName().equals(spmc)){
                        count--;
                        msgList.add("商品名称与销售订单上不对应。");
                    }
                    if(!ConverterUtils.dateToString(yqfhrq,"yyyy-MM-dd HH:mm").equals(ConverterUtils.dateToString(earlyWarning_xsck.getYqfhrq(),"yyyy-MM-dd HH:mm"))){
                        count--;
                        msgList.add("要求发货日期与销售订单上不对应。");
                    }
                }
            }
            if(count < 0){//证明信息有误
                pageInfo.setResFlag("0");
                return pageInfo;
            }else {
                iEarlyWarning_XsfhDao.saveEWXHasId(earlyWarning_xsck);
                pageInfo.setResFlag("1");
                return pageInfo;
            }
        }
    }

    @Override
    public void deleteEWXsByIds(String ids) throws Exception {
        Long[] IDS = StringConverterUtils.convertToLong(ids, ",");
        if(IDS != null){
            for (Long id:IDS){
                iEarlyWarning_XsfhDao.deleteById(id);
            }
        }
    }
}

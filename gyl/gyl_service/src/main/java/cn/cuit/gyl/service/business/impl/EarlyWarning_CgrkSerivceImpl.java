package cn.cuit.gyl.service.business.impl;

import cn.cuit.gyl.dao.business.IEarlyWarning_CgrkDao;
import cn.cuit.gyl.dao.database.IProductDao;
import cn.cuit.gyl.domain.business.Cgddzhib;
import cn.cuit.gyl.domain.business.Cgddzhub;
import cn.cuit.gyl.domain.business.EarlyWarning_Cgrk;
import cn.cuit.gyl.service.business.IEarlyWarning_CgrkService;
import cn.cuit.gyl.utils.PageInfo;
import cn.cuit.gyl.utils.StringConverterUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EarlyWarning_CgrkSerivceImpl implements IEarlyWarning_CgrkService {

    @Autowired
    @Qualifier("IEarlyWarning_CgrkDao")
    private IEarlyWarning_CgrkDao earlyWarning_cgrkDao;

    @Autowired
    @Qualifier("cgdddao")
    private cn.cuit.gyl.dao.business.cgdddao cgdddao;

    @Autowired
    @Qualifier("cgddzhidao")
    private cn.cuit.gyl.dao.business.cgddzhidao cgddzhidao;

    @Autowired
    @Qualifier("iProductDao")
    private IProductDao iProductDao;

    @Override
    public List<EarlyWarning_Cgrk> findEWckByPage(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<EarlyWarning_Cgrk> all = earlyWarning_cgrkDao.findAll();
        return all;
    }

    @Override
    public EarlyWarning_Cgrk findEWckById(Long id) throws Exception {
        EarlyWarning_Cgrk byId = earlyWarning_cgrkDao.findById(id);
        return byId;
    }

    @Override
    public EarlyWarning_Cgrk findEWckByDjh(String djh) throws Exception {
        EarlyWarning_Cgrk byDjh = earlyWarning_cgrkDao.findByDjh(djh);
        return byDjh;
    }

    @Override
    public List<EarlyWarning_Cgrk> findEWckByDjhOrHH(String djh, Long hh, Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        EarlyWarning_Cgrk earlyWarning_cgrk = new EarlyWarning_Cgrk();
        earlyWarning_cgrk.setDjh(djh);
        earlyWarning_cgrk.setHh(hh);
        List<EarlyWarning_Cgrk> byDjhOrHh = earlyWarning_cgrkDao.findByDjhOrHh(earlyWarning_cgrk);
        return byDjhOrHh;
    }

    @Override
    public PageInfo updateEWck(EarlyWarning_Cgrk earlyWarning_cgrk) throws Exception {
        PageInfo pageInfo = new PageInfo();
        List<String> msgList = pageInfo.getMsgList();
        String djh = earlyWarning_cgrk.getDjh();
        Long hh = earlyWarning_cgrk.getHh();
        String productNum = earlyWarning_cgrk.getProductNum();
        Cgddzhub byDjh = cgdddao.findByDjh(djh);
        if (byDjh == null){
            pageInfo.setResFlag("0");
            msgList.add("单据号为"+djh+"的订单不存在;");
            return pageInfo;
        }
        else{
            if (cgddzhidao.findByZIdAndHh(byDjh.getCgddzhubid(),hh) == null){
                pageInfo.setResFlag("0");
                msgList.add("行号为"+hh+"的订单子表不存在;");
                return pageInfo;
            }

        }
        if (iProductDao.findByPnum(productNum) == null){
            pageInfo.setResFlag("0");
            msgList.add("商品编码为"+productNum+"的商品不存在;");
            return pageInfo;
        }
        earlyWarning_cgrkDao.updateById(earlyWarning_cgrk);
        pageInfo.setResFlag("1");
        return pageInfo;
    }

    @Override
    public PageInfo SaveEWc(EarlyWarning_Cgrk earlyWarning_cgrk) throws Exception {
        PageInfo pageInfo = new PageInfo();
        List<String> msgList = pageInfo.getMsgList();
        String djh = earlyWarning_cgrk.getDjh();
        Long hh = earlyWarning_cgrk.getHh();
        String productNum = earlyWarning_cgrk.getProductNum();
        Cgddzhub byDjh = cgdddao.findByDjh(djh);
        if (byDjh == null){
            pageInfo.setResFlag("0");
            msgList.add("单据号为"+djh+"的订单不存在;");
            return pageInfo;
        }
        else{
            if (cgddzhidao.findByZIdAndHh(byDjh.getCgddzhubid(),hh) == null){
                pageInfo.setResFlag("0");
                msgList.add("行号为"+hh+"的订单子表不存在;");
                return pageInfo;
            }

        }
        if (iProductDao.findByPnum(productNum) == null){
            pageInfo.setResFlag("0");
            msgList.add("商品编码为"+productNum+"的商品不存在;");
            return pageInfo;
        }
        earlyWarning_cgrkDao.save(earlyWarning_cgrk);
        pageInfo.setResFlag("1");
        return pageInfo;
    }

    @Override
    public void deleteEWcById(Long id) throws Exception {
        earlyWarning_cgrkDao.deleteById(id);

    }

    @Override
    public void deleteEWcsByIds(String ids) throws Exception {
        Long[] IDS = StringConverterUtils.convertToLong(ids, ",");
        if (IDS !=null){
            for (Long id:IDS){
                earlyWarning_cgrkDao.deleteById(id);
            }
        }

    }

    @Override
    public Long getEWCIdToUI() throws Exception {
        List<EarlyWarning_Cgrk> all = earlyWarning_cgrkDao.findAll();
        Long x = Long.valueOf(1);
        if (all !=null){
            for (EarlyWarning_Cgrk a:all){
                if (a.getId()>=x){
                    x = a.getId()+1;
                }
            }
        }
        return x;
    }

    @Override
    public PageInfo CheckDjh(String djh) throws Exception {
        PageInfo pageInfo = new PageInfo();
        List<String> msgList = pageInfo.getMsgList();
        Cgddzhub byDjh = cgdddao.findByDjh(djh);
        if (byDjh ==null){
            pageInfo.setResFlag("0");
            msgList.add("单据号为"+djh+"的订单不存在;");
            return pageInfo;
        }
        pageInfo.setResFlag("1");
        return pageInfo;
    }

    @Override
    public PageInfo CheckHh(String djh, Long hh) throws Exception {
        PageInfo pageInfo = new PageInfo();
        List<String> msgList = pageInfo.getMsgList();
        Cgddzhub byDjh = cgdddao.findByDjh(djh);
        if (byDjh == null){
            pageInfo.setResFlag("0");
            msgList.add("单据号为"+djh+"的订单不存在;");
            return pageInfo;
        }
        else{
            if (cgddzhidao.findByZIdAndHh(byDjh.getCgddzhubid(),hh) == null){
                pageInfo.setResFlag("0");
                msgList.add("行号为"+hh+"的订单子表不存在;");
                return pageInfo;
            }

        }
        pageInfo.setResFlag("1");
        return pageInfo;
    }

    @Override
    public Cgddzhib PutValue(String djh, Long hh) throws Exception {
        Cgddzhub byDjh = cgdddao.findByDjh(djh);
        Cgddzhib byZIdAndHh = cgddzhidao.findByZIdAndHh(byDjh.getCgddzhubid(), hh);
        return byZIdAndHh;
    }
}

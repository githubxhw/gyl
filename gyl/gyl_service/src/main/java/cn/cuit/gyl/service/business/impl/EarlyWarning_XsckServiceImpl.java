package cn.cuit.gyl.service.business.impl;

import cn.cuit.gyl.dao.business.IEarlyWarning_XsckDao;
import cn.cuit.gyl.domain.business.EarlyWarning_Xsck;
import cn.cuit.gyl.service.business.IEarlyWarning_XsckService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("earlyWarning_XsckServiceImpl")
public class EarlyWarning_XsckServiceImpl implements IEarlyWarning_XsckService {

    @Autowired
    @Qualifier("iEarlyWarning_XsfhDao")
    private IEarlyWarning_XsckDao  iEarlyWarning_XsfhDao = null;

    @Override
    public List<EarlyWarning_Xsck> findEWXsByPage(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<EarlyWarning_Xsck> earlyWarning_xscks = iEarlyWarning_XsfhDao.findAll();
        return earlyWarning_xscks;
    }
}

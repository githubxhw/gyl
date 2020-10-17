package cn.cuit.gyl.service.business;

import cn.cuit.gyl.domain.business.Cgyfd_zhub;
import cn.cuit.gyl.domain.business.Cgyfd_zib;
import cn.cuit.gyl.exception.MyException;
import cn.cuit.gyl.utils.PageInfo;

import java.util.ArrayList;
import java.util.Date;

public interface CgyfdService {

    PageInfo saveZhubAndZib(Cgyfd_zhub cgyfd_zhub) throws Exception;

    void saveZib(Cgyfd_zib cgyfd_zib);

    Cgyfd_zhub findZhuById(int zhuId);

    ArrayList findByCgyfdZhub(Cgyfd_zhub cgyfd_zhub) throws Exception;

    Cgyfd_zib findZibByZiId(int ziId);

    ArrayList<Cgyfd_zib> findZibByZhuId(int zhuId);

    void DeleteZhubById(int zhuId);

    void DeleteZibById(int ziId);

    void DeleteZhubByIds(String zhuIds);

    void DeleteZibByIds(String ziIds);

    void UpdateZhub(Cgyfd_zhub cgyfd_zhub) throws MyException;

    void  UpdateZib(Cgyfd_zib cgyfd_zib) throws Exception;

    PageInfo qzByZhub(String djh, String qzr, Date qzsj) throws Exception;

    PageInfo spByZhub(String djh, String qzr, Date qzsj, int sxbz) throws Exception;

    Integer getZib_hh(Integer zhuId);
}

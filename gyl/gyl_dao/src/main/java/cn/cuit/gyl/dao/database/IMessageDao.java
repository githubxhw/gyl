package cn.cuit.gyl.dao.database;

import cn.cuit.gyl.domain.database.Message;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//信息dao
@Repository("iMessageDao")
public interface IMessageDao {

    //根据接收用户 查询信息
    @Select("select * from message where receiver=#{username}")
    List<Message> findByName(String username) throws Exception;

    //根据信息id修改状态
    @Update("update message set status=#{status} where mid=#{mid}")
    void updateStatusByMid(@Param("mid") Long mid,@Param("status") Integer status) throws Exception;

    //根据mid删除消息
    @Delete("delete from message where mid=#{mid}")
    void deleteByMid(Long mid) throws Exception;

    //查询最大的mid
    @Select("select MAX(`mid`) from message")
    Long findMaxMid() throws Exception;

    //保存一条记录(有mid)
    @Insert("insert into message (mid,type,msg,sender,sendTime,receiver,status) values (#{mid},#{type},#{msg},#{sender},#{sendTime},#{receiver},#{status})")
    void save(Message message) throws Exception;

    //保存一条记录(没有mid),并返回新插入的id值到对象message中
    @Insert("insert into message (type,msg,sender,sendTime,receiver,status) values (#{type},#{msg},#{sender},#{sendTime},#{receiver},#{status})")
    @Options(useGeneratedKeys = true,keyProperty = "mid",keyColumn = "mid")
    void saveNotHasMidAndReturnId(Message message) throws Exception;

    //根据mid查询信息
    @Select("select * from message where mid=#{mid}")
    Message findByMid(Long mid) throws Exception;
}

package com.hexiaofei.sjzclient.dao.mapper;

import com.hexiaofei.sjzclient.domain.MailAuthen;
import com.hexiaofei.sjzclient.domain.MailAuthenExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailAuthenMapper {

    @SelectProvider(type=MailAuthenSqlProvider.class, method="countByExample")
    int countByExample(MailAuthenExample example);


    @DeleteProvider(type=MailAuthenSqlProvider.class, method="deleteByExample")
    int deleteByExample(MailAuthenExample example);

    /**
     * 删除一条记录
     * @param mailAuthenId
     * @return
     */
    @Delete({
        "delete from mail_authen",
        "where mailAuthenId = #{mailAuthenId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer mailAuthenId);

    /**
     * 插入一条记录
     * @param record
     * @return
     */
    @Insert({
        "insert into mail_authen (mail, ",
        "sendTime, validCode, ",
        "userId)",
        "values (#{mail,jdbcType=VARCHAR}, ",
        "#{sendTime,jdbcType=TIMESTAMP}, #{validCode,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "mailAuthenId")
    int insert(MailAuthen record);


    @InsertProvider(type=MailAuthenSqlProvider.class, method="insertSelective")
    int insertSelective(MailAuthen record);


    @SelectProvider(type=MailAuthenSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="mailAuthenId", property="mailAuthenId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="mail", property="mail", jdbcType=JdbcType.VARCHAR),
        @Result(column="sendTime", property="sendTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validCode", property="validCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER)
    })
    List<MailAuthen> selectByExample(MailAuthenExample example);


    @Select({
        "select",
        "mailAuthenId, mail, sendTime, validCode, userId",
        "from mail_authen",
        "where mailAuthenId = #{mailAuthenId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="mailAuthenId", property="mailAuthenId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="mail", property="mail", jdbcType=JdbcType.VARCHAR),
        @Result(column="sendTime", property="sendTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validCode", property="validCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER)
    })
    MailAuthen selectByPrimaryKey(Integer mailAuthenId);


    @UpdateProvider(type=MailAuthenSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MailAuthen record, @Param("example") MailAuthenExample example);


    @UpdateProvider(type=MailAuthenSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MailAuthen record, @Param("example") MailAuthenExample example);


    @UpdateProvider(type=MailAuthenSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MailAuthen record);


    @Update({
        "update mail_authen",
        "set mail = #{mail,jdbcType=VARCHAR},",
          "sendTime = #{sendTime,jdbcType=TIMESTAMP},",
          "validCode = #{validCode,jdbcType=VARCHAR},",
          "userId = #{userId,jdbcType=INTEGER}",
        "where mailAuthenId = #{mailAuthenId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MailAuthen record);

    @Select("Select * from mail_authen where mailAuthenId=(select max(mailAuthenId) from mail_authen where  mailauthenId =#{mailAuthenId})")
    MailAuthen getMailAuthenByEmail(int mailAuthenId);

    @Delete("delete from mail_authen where mailAuthenId =#{mailAuthenId}")
    void delMailAuthenById(int mailAuthenId);

    @Delete("delete from mail_authen where userId =#{userId}")
    void delOldMailAuthenByUserId(int userId);

    @Delete("delete from mail_authen where mail =#{email}")
    int delOldMailAuthenByMail(String email);

    @Select("SELECT CURRENT_USER()")
    String getCurrentUser();

}
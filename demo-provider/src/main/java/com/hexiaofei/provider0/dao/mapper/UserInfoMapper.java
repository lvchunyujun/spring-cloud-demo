package com.hexiaofei.provider0.dao.mapper;

import com.hexiaofei.provider0.domain.SjzDomainSpiderTask;
import com.hexiaofei.provider0.domain.UserInfo;
import com.hexiaofei.provider0.domain.UserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:28 CST 2019
     */
    @SelectProvider(type=UserInfoSqlProvider.class, method="countByExample")
    int countByExample(UserInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:28 CST 2019
     */
    @DeleteProvider(type=UserInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:28 CST 2019
     */
    @Delete({
        "delete from user_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:28 CST 2019
     */
    @Insert({
        "insert into user_info (id, nickName, ",
        "userName, password, ",
        "realName, role, ",
        "idCard, phone, eMail, ",
        "registerDate, status, ",
        "loginCount)",
        "values (#{id,jdbcType=INTEGER}, #{nickName,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{realName,jdbcType=VARCHAR}, #{role,jdbcType=SMALLINT}, ",
        "#{idCard,jdbcType=CHAR}, #{phone,jdbcType=CHAR}, #{eMail,jdbcType=VARCHAR}, ",
        "#{registerDate,jdbcType=TIMESTAMP}, #{status,jdbcType=SMALLINT}, ",
        "#{loginCount,jdbcType=INTEGER})"
    })
    int insert(UserInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:28 CST 2019
     */
    @InsertProvider(type=UserInfoSqlProvider.class, method="insertSelective")
    int insertSelective(UserInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:28 CST 2019
     */
    @SelectProvider(type=UserInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nickName", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="userName", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="realName", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="role", property="role", jdbcType=JdbcType.SMALLINT),
        @Result(column="idCard", property="idCard", jdbcType=JdbcType.CHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.CHAR),
        @Result(column="eMail", property="eMail", jdbcType=JdbcType.VARCHAR),
        @Result(column="registerDate", property="registerDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.SMALLINT),
        @Result(column="loginCount", property="loginCount", jdbcType=JdbcType.INTEGER)
    })
    List<UserInfo> selectByExample(UserInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:28 CST 2019
     */
    @Select({
        "select",
        "id, nickName, userName, password, realName, role, idCard, phone, eMail, registerDate, ",
        "status, loginCount",
        "from user_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nickName", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="userName", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="realName", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="role", property="role", jdbcType=JdbcType.SMALLINT),
        @Result(column="idCard", property="idCard", jdbcType=JdbcType.CHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.CHAR),
        @Result(column="eMail", property="eMail", jdbcType=JdbcType.VARCHAR),
        @Result(column="registerDate", property="registerDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.SMALLINT),
        @Result(column="loginCount", property="loginCount", jdbcType=JdbcType.INTEGER)
    })
    UserInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:28 CST 2019
     */
    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:28 CST 2019
     */
    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:28 CST 2019
     */
    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:28 CST 2019
     */
    @Update({
        "update user_info",
        "set nickName = #{nickName,jdbcType=VARCHAR},",
          "userName = #{userName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "realName = #{realName,jdbcType=VARCHAR},",
          "role = #{role,jdbcType=SMALLINT},",
          "idCard = #{idCard,jdbcType=CHAR},",
          "phone = #{phone,jdbcType=CHAR},",
          "eMail = #{eMail,jdbcType=VARCHAR},",
          "registerDate = #{registerDate,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=SMALLINT},",
          "loginCount = #{loginCount,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserInfo record);

    @Select({"select",
            "id, nickName, userName, password, realName, role, idCard, phone, eMail, registerDate, ",
            "status, loginCount",
            "from user_info",
            "where userName = #{userName,jdbcType=VARCHAR} and password = #{password,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="nickName", property="nickName", jdbcType=JdbcType.VARCHAR),
            @Result(column="userName", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="realName", property="realName", jdbcType=JdbcType.VARCHAR),
            @Result(column="role", property="role", jdbcType=JdbcType.SMALLINT),
            @Result(column="idCard", property="idCard", jdbcType=JdbcType.CHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.CHAR),
            @Result(column="eMail", property="eMail", jdbcType=JdbcType.VARCHAR),
            @Result(column="registerDate", property="registerDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="status", property="status", jdbcType=JdbcType.SMALLINT),
            @Result(column="loginCount", property="loginCount", jdbcType=JdbcType.INTEGER)
    })
    UserInfo selectUserInfoForLogin(@Param("userName")String userName,@Param("password") String password);

    @Select("select count(*) from user_info ")
    int selectCountByAll();

    @Select({
            "select",
            "id, nickName, userName, password, realName, role, idCard, phone, eMail, registerDate, ",
            "status, loginCount",
            "from user_info",
            " limit #{offset},#{pagesize} "
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="nickName", property="nickName", jdbcType=JdbcType.VARCHAR),
            @Result(column="userName", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="realName", property="realName", jdbcType=JdbcType.VARCHAR),
            @Result(column="role", property="role", jdbcType=JdbcType.SMALLINT),
            @Result(column="idCard", property="idCard", jdbcType=JdbcType.CHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.CHAR),
            @Result(column="eMail", property="eMail", jdbcType=JdbcType.VARCHAR),
            @Result(column="registerDate", property="registerDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="status", property="status", jdbcType=JdbcType.SMALLINT),
            @Result(column="loginCount", property="loginCount", jdbcType=JdbcType.INTEGER)
    })
    List<UserInfo> selectListByPaging(@Param("offset") int offset, @Param("pagesize")  int pageSize);

}
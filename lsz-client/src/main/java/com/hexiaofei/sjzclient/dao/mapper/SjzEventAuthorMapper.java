package com.hexiaofei.sjzclient.dao.mapper;

import com.hexiaofei.sjzclient.domain.SjzEventAuthor;
import com.hexiaofei.sjzclient.domain.SjzEventAuthorExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SjzEventAuthorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_author
     *
     * @mbggenerated Sat Apr 11 15:54:17 CST 2020
     */
    @SelectProvider(type=SjzEventAuthorSqlProvider.class, method="countByExample")
    int countByExample(SjzEventAuthorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_author
     *
     * @mbggenerated Sat Apr 11 15:54:17 CST 2020
     */
    @DeleteProvider(type=SjzEventAuthorSqlProvider.class, method="deleteByExample")
    int deleteByExample(SjzEventAuthorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_author
     *
     * @mbggenerated Sat Apr 11 15:54:17 CST 2020
     */
    @Delete({
        "delete from sjz_event_author",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_author
     *
     * @mbggenerated Sat Apr 11 15:54:17 CST 2020
     */
    @Insert({
        "insert into sjz_event_author (id, eventIndexId, ",
        "userId, nickName, ",
        "createTime)",
        "values (#{id,jdbcType=INTEGER}, #{eventIndexId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER}, #{nickName,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insert(SjzEventAuthor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_author
     *
     * @mbggenerated Sat Apr 11 15:54:17 CST 2020
     */
    @InsertProvider(type=SjzEventAuthorSqlProvider.class, method="insertSelective")
    int insertSelective(SjzEventAuthor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_author
     *
     * @mbggenerated Sat Apr 11 15:54:17 CST 2020
     */
    @SelectProvider(type=SjzEventAuthorSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="eventIndexId", property="eventIndexId", jdbcType=JdbcType.INTEGER),
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="nickName", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SjzEventAuthor> selectByExample(SjzEventAuthorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_author
     *
     * @mbggenerated Sat Apr 11 15:54:17 CST 2020
     */
    @Select({
        "select",
        "id, eventIndexId, userId, nickName, createTime",
        "from sjz_event_author",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="eventIndexId", property="eventIndexId", jdbcType=JdbcType.INTEGER),
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="nickName", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SjzEventAuthor selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_author
     *
     * @mbggenerated Sat Apr 11 15:54:17 CST 2020
     */
    @UpdateProvider(type=SjzEventAuthorSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SjzEventAuthor record, @Param("example") SjzEventAuthorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_author
     *
     * @mbggenerated Sat Apr 11 15:54:17 CST 2020
     */
    @UpdateProvider(type=SjzEventAuthorSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SjzEventAuthor record, @Param("example") SjzEventAuthorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_author
     *
     * @mbggenerated Sat Apr 11 15:54:17 CST 2020
     */
    @UpdateProvider(type=SjzEventAuthorSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SjzEventAuthor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_author
     *
     * @mbggenerated Sat Apr 11 15:54:17 CST 2020
     */
    @Update({
        "update sjz_event_author",
        "set eventIndexId = #{eventIndexId,jdbcType=INTEGER},",
          "userId = #{userId,jdbcType=INTEGER},",
          "nickName = #{nickName,jdbcType=VARCHAR},",
          "createTime = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SjzEventAuthor record);

}
package com.hexiaofei.provider0.dao.mapper;

import com.hexiaofei.provider0.domain.SjzEventIndex;
import com.hexiaofei.provider0.domain.SjzEventIndexExample;
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

public interface SjzEventIndexMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_index
     *
     * @mbggenerated Sun Jun 16 20:12:05 CST 2019
     */
    @SelectProvider(type=SjzEventIndexSqlProvider.class, method="countByExample")
    int countByExample(SjzEventIndexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_index
     *
     * @mbggenerated Sun Jun 16 20:12:05 CST 2019
     */
    @DeleteProvider(type=SjzEventIndexSqlProvider.class, method="deleteByExample")
    int deleteByExample(SjzEventIndexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_index
     *
     * @mbggenerated Sun Jun 16 20:12:05 CST 2019
     */
    @Delete({
        "delete from sjz_event_index",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_index
     *
     * @mbggenerated Sun Jun 16 20:12:05 CST 2019
     */
    @Insert({
        "insert into sjz_event_index (id, eventTime, ",
        "eventContent, eventType, ",
        "eventState, recordCreateTime)",
        "values (#{id,jdbcType=INTEGER}, #{eventTime,jdbcType=TIMESTAMP}, ",
        "#{eventContent,jdbcType=VARCHAR}, #{eventType,jdbcType=TINYINT}, ",
        "#{eventState,jdbcType=TINYINT}, #{recordCreateTime,jdbcType=TIMESTAMP})"
    })
    int insert(SjzEventIndex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_index
     *
     * @mbggenerated Sun Jun 16 20:12:05 CST 2019
     */
    @InsertProvider(type=SjzEventIndexSqlProvider.class, method="insertSelective")
    int insertSelective(SjzEventIndex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_index
     *
     * @mbggenerated Sun Jun 16 20:12:05 CST 2019
     */
    @SelectProvider(type=SjzEventIndexSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="eventTime", property="eventTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="eventContent", property="eventContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="eventType", property="eventType", jdbcType=JdbcType.TINYINT),
        @Result(column="eventState", property="eventState", jdbcType=JdbcType.TINYINT),
        @Result(column="recordCreateTime", property="recordCreateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SjzEventIndex> selectByExample(SjzEventIndexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_index
     *
     * @mbggenerated Sun Jun 16 20:12:05 CST 2019
     */
    @Select({
        "select",
        "id, eventTime, eventContent, eventType, eventState, recordCreateTime",
        "from sjz_event_index",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="eventTime", property="eventTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="eventContent", property="eventContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="eventType", property="eventType", jdbcType=JdbcType.TINYINT),
        @Result(column="eventState", property="eventState", jdbcType=JdbcType.TINYINT),
        @Result(column="recordCreateTime", property="recordCreateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SjzEventIndex selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_index
     *
     * @mbggenerated Sun Jun 16 20:12:05 CST 2019
     */
    @UpdateProvider(type=SjzEventIndexSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SjzEventIndex record, @Param("example") SjzEventIndexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_index
     *
     * @mbggenerated Sun Jun 16 20:12:05 CST 2019
     */
    @UpdateProvider(type=SjzEventIndexSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SjzEventIndex record, @Param("example") SjzEventIndexExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_index
     *
     * @mbggenerated Sun Jun 16 20:12:05 CST 2019
     */
    @UpdateProvider(type=SjzEventIndexSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SjzEventIndex record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_index
     *
     * @mbggenerated Sun Jun 16 20:12:05 CST 2019
     */
    @Update({
        "update sjz_event_index",
        "set eventTime = #{eventTime,jdbcType=TIMESTAMP},",
          "eventContent = #{eventContent,jdbcType=VARCHAR},",
          "eventType = #{eventType,jdbcType=TINYINT},",
          "eventState = #{eventState,jdbcType=TINYINT},",
          "recordCreateTime = #{recordCreateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SjzEventIndex record);
}
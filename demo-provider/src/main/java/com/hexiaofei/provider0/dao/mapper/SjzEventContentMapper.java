package com.hexiaofei.provider0.dao.mapper;

import com.hexiaofei.provider0.domain.SjzEventContent;
import com.hexiaofei.provider0.domain.SjzEventContentExample;
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

public interface SjzEventContentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_content
     *
     * @mbggenerated Sun Jun 16 20:15:41 CST 2019
     */
    @SelectProvider(type=SjzEventContentSqlProvider.class, method="countByExample")
    int countByExample(SjzEventContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_content
     *
     * @mbggenerated Sun Jun 16 20:15:41 CST 2019
     */
    @DeleteProvider(type=SjzEventContentSqlProvider.class, method="deleteByExample")
    int deleteByExample(SjzEventContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_content
     *
     * @mbggenerated Sun Jun 16 20:15:41 CST 2019
     */
    @Delete({
        "delete from sjz_event_content",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_content
     *
     * @mbggenerated Sun Jun 16 20:15:41 CST 2019
     */
    @Insert({
        "insert into sjz_event_content (id, eventTitle, ",
        "recordTime, eventContextId, ",
        "eventContent)",
        "values (#{id,jdbcType=INTEGER}, #{eventTitle,jdbcType=VARCHAR}, ",
        "#{recordTime,jdbcType=TIMESTAMP}, #{eventContextId,jdbcType=INTEGER}, ",
        "#{eventContent,jdbcType=LONGVARCHAR})"
    })
    int insert(SjzEventContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_content
     *
     * @mbggenerated Sun Jun 16 20:15:41 CST 2019
     */
    @InsertProvider(type=SjzEventContentSqlProvider.class, method="insertSelective")
    int insertSelective(SjzEventContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_content
     *
     * @mbggenerated Sun Jun 16 20:15:41 CST 2019
     */
    @SelectProvider(type=SjzEventContentSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="eventTitle", property="eventTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="recordTime", property="recordTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="eventContextId", property="eventContextId", jdbcType=JdbcType.INTEGER),
        @Result(column="eventContent", property="eventContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<SjzEventContent> selectByExampleWithBLOBs(SjzEventContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_content
     *
     * @mbggenerated Sun Jun 16 20:15:41 CST 2019
     */
    @SelectProvider(type=SjzEventContentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="eventTitle", property="eventTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="recordTime", property="recordTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="eventContextId", property="eventContextId", jdbcType=JdbcType.INTEGER)
    })
    List<SjzEventContent> selectByExample(SjzEventContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_content
     *
     * @mbggenerated Sun Jun 16 20:15:41 CST 2019
     */
    @Select({
        "select",
        "id, eventTitle, recordTime, eventContextId, eventContent",
        "from sjz_event_content",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="eventTitle", property="eventTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="recordTime", property="recordTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="eventContextId", property="eventContextId", jdbcType=JdbcType.INTEGER),
        @Result(column="eventContent", property="eventContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    SjzEventContent selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_content
     *
     * @mbggenerated Sun Jun 16 20:15:41 CST 2019
     */
    @UpdateProvider(type=SjzEventContentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SjzEventContent record, @Param("example") SjzEventContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_content
     *
     * @mbggenerated Sun Jun 16 20:15:41 CST 2019
     */
    @UpdateProvider(type=SjzEventContentSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") SjzEventContent record, @Param("example") SjzEventContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_content
     *
     * @mbggenerated Sun Jun 16 20:15:41 CST 2019
     */
    @UpdateProvider(type=SjzEventContentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SjzEventContent record, @Param("example") SjzEventContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_content
     *
     * @mbggenerated Sun Jun 16 20:15:41 CST 2019
     */
    @UpdateProvider(type=SjzEventContentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SjzEventContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_content
     *
     * @mbggenerated Sun Jun 16 20:15:41 CST 2019
     */
    @Update({
        "update sjz_event_content",
        "set eventTitle = #{eventTitle,jdbcType=VARCHAR},",
          "recordTime = #{recordTime,jdbcType=TIMESTAMP},",
          "eventContextId = #{eventContextId,jdbcType=INTEGER},",
          "eventContent = #{eventContent,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(SjzEventContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_event_content
     *
     * @mbggenerated Sun Jun 16 20:15:41 CST 2019
     */
    @Update({
        "update sjz_event_content",
        "set eventTitle = #{eventTitle,jdbcType=VARCHAR},",
          "recordTime = #{recordTime,jdbcType=TIMESTAMP},",
          "eventContextId = #{eventContextId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SjzEventContent record);
}
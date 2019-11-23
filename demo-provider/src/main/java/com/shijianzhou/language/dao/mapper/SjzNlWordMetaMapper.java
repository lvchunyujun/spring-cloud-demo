package com.shijianzhou.language.dao.mapper;

import com.shijianzhou.language.domain.SjzNlWordMeta;
import com.shijianzhou.language.domain.SjzNlWordMetaExample;
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

public interface SjzNlWordMetaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    @SelectProvider(type=SjzNlWordMetaSqlProvider.class, method="countByExample")
    int countByExample(SjzNlWordMetaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    @DeleteProvider(type=SjzNlWordMetaSqlProvider.class, method="deleteByExample")
    int deleteByExample(SjzNlWordMetaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    @Delete({
        "delete from sjz_nl_word_meta",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    @Insert({
        "insert into sjz_nl_word_meta (id, wordMetaCode, ",
        "wordMetaEn, wordMetaZh, ",
        "simpleWordMetaEn, simpleWordMetaZh, ",
        "languageId, languageTypeCode, ",
        "parentWordMetaCode, level, ",
        "createTime, description)",
        "values (#{id,jdbcType=INTEGER}, ",
        "(select max(t.wordMetaCode)+(min(t.wordMetaCode)-#{parentWordMetaCode,jdbcType=INTEGER}) from sjz_nl_word_meta t where t.parentWordMetaCode = #{parentWordMetaCode,jdbcType=INTEGER}),",
        "#{wordMetaEn,jdbcType=CHAR}, #{wordMetaZh,jdbcType=CHAR}, ",
        "#{simpleWordMetaEn,jdbcType=CHAR}, #{simpleWordMetaZh,jdbcType=CHAR}, ",
        "#{languageId,jdbcType=INTEGER}, #{languageTypeCode,jdbcType=CHAR}, ",
        "#{parentWordMetaCode,jdbcType=INTEGER}, #{level,jdbcType=SMALLINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{description,jdbcType=VARCHAR})"
    })
    int insert(SjzNlWordMeta record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    @InsertProvider(type=SjzNlWordMetaSqlProvider.class, method="insertSelective")
    int insertSelective(SjzNlWordMeta record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    @SelectProvider(type=SjzNlWordMetaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="wordMetaCode", property="wordMetaCode", jdbcType=JdbcType.INTEGER),
        @Result(column="wordMetaEn", property="wordMetaEn", jdbcType=JdbcType.CHAR),
        @Result(column="wordMetaZh", property="wordMetaZh", jdbcType=JdbcType.CHAR),
        @Result(column="simpleWordMetaEn", property="simpleWordMetaEn", jdbcType=JdbcType.CHAR),
        @Result(column="simpleWordMetaZh", property="simpleWordMetaZh", jdbcType=JdbcType.CHAR),
        @Result(column="languageId", property="languageId", jdbcType=JdbcType.INTEGER),
        @Result(column="languageTypeCode", property="languageTypeCode", jdbcType=JdbcType.CHAR),
        @Result(column="parentWordMetaCode", property="parentWordMetaCode", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.SMALLINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<SjzNlWordMeta> selectByExample(SjzNlWordMetaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    @Select({
        "select",
        "id, wordMetaCode, wordMetaEn, wordMetaZh, simpleWordMetaEn, simpleWordMetaZh, ",
        "languageId, languageTypeCode, parentWordMetaCode, level, createTime, description",
        "from sjz_nl_word_meta",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="wordMetaCode", property="wordMetaCode", jdbcType=JdbcType.INTEGER),
        @Result(column="wordMetaEn", property="wordMetaEn", jdbcType=JdbcType.CHAR),
        @Result(column="wordMetaZh", property="wordMetaZh", jdbcType=JdbcType.CHAR),
        @Result(column="simpleWordMetaEn", property="simpleWordMetaEn", jdbcType=JdbcType.CHAR),
        @Result(column="simpleWordMetaZh", property="simpleWordMetaZh", jdbcType=JdbcType.CHAR),
        @Result(column="languageId", property="languageId", jdbcType=JdbcType.INTEGER),
        @Result(column="languageTypeCode", property="languageTypeCode", jdbcType=JdbcType.CHAR),
        @Result(column="parentWordMetaCode", property="parentWordMetaCode", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.SMALLINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    SjzNlWordMeta selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    @UpdateProvider(type=SjzNlWordMetaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SjzNlWordMeta record, @Param("example") SjzNlWordMetaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    @UpdateProvider(type=SjzNlWordMetaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SjzNlWordMeta record, @Param("example") SjzNlWordMetaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    @UpdateProvider(type=SjzNlWordMetaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SjzNlWordMeta record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    @Update({
        "update sjz_nl_word_meta",
        "set wordMetaCode = #{wordMetaCode,jdbcType=INTEGER},",
          "wordMetaEn = #{wordMetaEn,jdbcType=CHAR},",
          "wordMetaZh = #{wordMetaZh,jdbcType=CHAR},",
          "simpleWordMetaEn = #{simpleWordMetaEn,jdbcType=CHAR},",
          "simpleWordMetaZh = #{simpleWordMetaZh,jdbcType=CHAR},",
          "languageId = #{languageId,jdbcType=INTEGER},",
          "languageTypeCode = #{languageTypeCode,jdbcType=CHAR},",
          "parentWordMetaCode = #{parentWordMetaCode,jdbcType=INTEGER},",
          "level = #{level,jdbcType=SMALLINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SjzNlWordMeta record);

    @Select("select count(*) from sjz_nl_word_meta order by createTime")
    int selectCountByAll();

    @Select({
            "select",
            "id, wordMetaCode, wordMetaEn, wordMetaZh, simpleWordMetaEn, simpleWordMetaZh, ",
            "languageId, languageTypeCode, parentWordMetaCode, level, createTime, description",
            "from sjz_nl_word_meta",
            " order by createTime desc ",
            " limit #{offset},#{pagesize} "
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="wordMetaCode", property="wordMetaCode", jdbcType=JdbcType.INTEGER),
            @Result(column="wordMetaEn", property="wordMetaEn", jdbcType=JdbcType.CHAR),
            @Result(column="wordMetaZh", property="wordMetaZh", jdbcType=JdbcType.CHAR),
            @Result(column="simpleWordMetaEn", property="simpleWordMetaEn", jdbcType=JdbcType.CHAR),
            @Result(column="simpleWordMetaZh", property="simpleWordMetaZh", jdbcType=JdbcType.CHAR),
            @Result(column="languageId", property="languageId", jdbcType=JdbcType.INTEGER),
            @Result(column="languageTypeCode", property="languageTypeCode", jdbcType=JdbcType.CHAR),
            @Result(column="parentWordMetaCode", property="parentWordMetaCode", jdbcType=JdbcType.INTEGER),
            @Result(column="level", property="level", jdbcType=JdbcType.SMALLINT),
            @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<SjzNlWordMeta> selectListByPaging(@Param("offset") int offset, @Param("pagesize")  int pageSize);

    @Select("select s.* from sjz_nl_word_meta s where s.parentWordMetaCode = #{parentWordMetaCode} ")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="wordMetaCode", property="wordMetaCode", jdbcType=JdbcType.INTEGER),
            @Result(column="wordMetaEn", property="wordMetaEn", jdbcType=JdbcType.CHAR),
            @Result(column="wordMetaZh", property="wordMetaZh", jdbcType=JdbcType.CHAR),
            @Result(column="simpleWordMetaEn", property="simpleWordMetaEn", jdbcType=JdbcType.CHAR),
            @Result(column="simpleWordMetaZh", property="simpleWordMetaZh", jdbcType=JdbcType.CHAR),
            @Result(column="languageId", property="languageId", jdbcType=JdbcType.INTEGER),
            @Result(column="languageTypeCode", property="languageTypeCode", jdbcType=JdbcType.CHAR),
            @Result(column="parentWordMetaCode", property="parentWordMetaCode", jdbcType=JdbcType.INTEGER),
            @Result(column="level", property="level", jdbcType=JdbcType.SMALLINT),
            @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<SjzNlWordMeta> selectListByParentWordMetaCode(@Param("parentWordMetaCode") int parentWordMetaCode);

    @Select("select s.* from sjz_nl_word_meta s where s.wordMetaCode = #{wordMetaCode}")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="wordMetaCode", property="wordMetaCode", jdbcType=JdbcType.INTEGER),
            @Result(column="wordMetaEn", property="wordMetaEn", jdbcType=JdbcType.CHAR),
            @Result(column="wordMetaZh", property="wordMetaZh", jdbcType=JdbcType.CHAR),
            @Result(column="simpleWordMetaEn", property="simpleWordMetaEn", jdbcType=JdbcType.CHAR),
            @Result(column="simpleWordMetaZh", property="simpleWordMetaZh", jdbcType=JdbcType.CHAR),
            @Result(column="languageId", property="languageId", jdbcType=JdbcType.INTEGER),
            @Result(column="languageTypeCode", property="languageTypeCode", jdbcType=JdbcType.CHAR),
            @Result(column="parentWordMetaCode", property="parentWordMetaCode", jdbcType=JdbcType.INTEGER),
            @Result(column="level", property="level", jdbcType=JdbcType.SMALLINT),
            @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    SjzNlWordMeta selectByWordMetaCode(@Param("wordMetaCode") int wordMetaCode);
}
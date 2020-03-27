package com.hexiaofei.sjzclient.dao.mapper;

import com.hexiaofei.sjzclient.domain.SjzDomainSpiderTask;
import com.hexiaofei.sjzclient.domain.SjzDomainWordSort;
import com.hexiaofei.sjzclient.domain.SjzDomainWordSortExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SjzDomainWordSortMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    @SelectProvider(type=SjzDomainWordSortSqlProvider.class, method="countByExample")
    int countByExample(SjzDomainWordSortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    @DeleteProvider(type=SjzDomainWordSortSqlProvider.class, method="deleteByExample")
    int deleteByExample(SjzDomainWordSortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    @Delete({
        "delete from sjz_domain_word_sort",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    @Insert({
        "insert into sjz_domain_word_sort (id, domainName, ",
        "domainUrl, wordMetaCode, ",
        "wordMetaEn, wordMetaZh, ",
        "simpleWordMetaEn, simpleWordMetaZh, ",
        "createTime, description)",
        "values (#{id,jdbcType=INTEGER}, #{domainName,jdbcType=VARCHAR}, ",
        "#{domainUrl,jdbcType=VARCHAR}, #{wordMetaCode,jdbcType=INTEGER}, ",
        "#{wordMetaEn,jdbcType=VARCHAR}, #{wordMetaZh,jdbcType=VARCHAR}, ",
        "#{simpleWordMetaEn,jdbcType=VARCHAR}, #{simpleWordMetaZh,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{description,jdbcType=VARCHAR})"
    })
    int insert(SjzDomainWordSort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    @InsertProvider(type=SjzDomainWordSortSqlProvider.class, method="insertSelective")
    int insertSelective(SjzDomainWordSort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    @SelectProvider(type=SjzDomainWordSortSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="domainName", property="domainName", jdbcType=JdbcType.VARCHAR),
        @Result(column="domainUrl", property="domainUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="wordMetaCode", property="wordMetaCode", jdbcType=JdbcType.INTEGER),
        @Result(column="wordMetaEn", property="wordMetaEn", jdbcType=JdbcType.VARCHAR),
        @Result(column="wordMetaZh", property="wordMetaZh", jdbcType=JdbcType.VARCHAR),
        @Result(column="simpleWordMetaEn", property="simpleWordMetaEn", jdbcType=JdbcType.VARCHAR),
        @Result(column="simpleWordMetaZh", property="simpleWordMetaZh", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<SjzDomainWordSort> selectByExample(SjzDomainWordSortExample example);


    @SelectProvider(type=SjzDomainWordSortSqlProvider.class, method="selectListBySpiderTaskList")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="domainName", property="domainName", jdbcType=JdbcType.VARCHAR),
            @Result(column="domainUrl", property="domainUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="wordMetaCode", property="wordMetaCode", jdbcType=JdbcType.INTEGER),
            @Result(column="wordMetaEn", property="wordMetaEn", jdbcType=JdbcType.VARCHAR),
            @Result(column="wordMetaZh", property="wordMetaZh", jdbcType=JdbcType.VARCHAR),
            @Result(column="simpleWordMetaEn", property="simpleWordMetaEn", jdbcType=JdbcType.VARCHAR),
            @Result(column="simpleWordMetaZh", property="simpleWordMetaZh", jdbcType=JdbcType.VARCHAR),
            @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    Cursor<SjzDomainWordSort> selectCursorBySpiderTaskList(Map<String, List<SjzDomainSpiderTask>> map);

    @SelectProvider(type=SjzDomainWordSortSqlProvider.class, method="selectListBySpiderTaskList")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="domainName", property="domainName", jdbcType=JdbcType.VARCHAR),
            @Result(column="domainUrl", property="domainUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="wordMetaCode", property="wordMetaCode", jdbcType=JdbcType.INTEGER),
            @Result(column="wordMetaEn", property="wordMetaEn", jdbcType=JdbcType.VARCHAR),
            @Result(column="wordMetaZh", property="wordMetaZh", jdbcType=JdbcType.VARCHAR),
            @Result(column="simpleWordMetaEn", property="simpleWordMetaEn", jdbcType=JdbcType.VARCHAR),
            @Result(column="simpleWordMetaZh", property="simpleWordMetaZh", jdbcType=JdbcType.VARCHAR),
            @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<SjzDomainWordSort> selectListBySpiderTaskList(Map<String, List<SjzDomainSpiderTask>> map);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    @Select({
        "select",
        "id, domainName, domainUrl, wordMetaCode, wordMetaEn, wordMetaZh, simpleWordMetaEn, ",
        "simpleWordMetaZh, createTime, description",
        "from sjz_domain_word_sort",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="domainName", property="domainName", jdbcType=JdbcType.VARCHAR),
        @Result(column="domainUrl", property="domainUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="wordMetaCode", property="wordMetaCode", jdbcType=JdbcType.INTEGER),
        @Result(column="wordMetaEn", property="wordMetaEn", jdbcType=JdbcType.VARCHAR),
        @Result(column="wordMetaZh", property="wordMetaZh", jdbcType=JdbcType.VARCHAR),
        @Result(column="simpleWordMetaEn", property="simpleWordMetaEn", jdbcType=JdbcType.VARCHAR),
        @Result(column="simpleWordMetaZh", property="simpleWordMetaZh", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    SjzDomainWordSort selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    @UpdateProvider(type=SjzDomainWordSortSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SjzDomainWordSort record, @Param("example") SjzDomainWordSortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    @UpdateProvider(type=SjzDomainWordSortSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SjzDomainWordSort record, @Param("example") SjzDomainWordSortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    @UpdateProvider(type=SjzDomainWordSortSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SjzDomainWordSort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    @Update({
        "update sjz_domain_word_sort",
        "set domainName = #{domainName,jdbcType=VARCHAR},",
          "domainUrl = #{domainUrl,jdbcType=VARCHAR},",
          "wordMetaCode = #{wordMetaCode,jdbcType=INTEGER},",
          "wordMetaEn = #{wordMetaEn,jdbcType=VARCHAR},",
          "wordMetaZh = #{wordMetaZh,jdbcType=VARCHAR},",
          "simpleWordMetaEn = #{simpleWordMetaEn,jdbcType=VARCHAR},",
          "simpleWordMetaZh = #{simpleWordMetaZh,jdbcType=VARCHAR},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SjzDomainWordSort record);

    @Select("select count(*) from sjz_domain_word_sort ")
    int selectCountByAll();


    @Select({
            "select",
            "id, domainName, domainUrl, wordMetaCode, wordMetaEn, wordMetaZh, simpleWordMetaEn, ",
            "simpleWordMetaZh, createTime, description",
            "from sjz_domain_word_sort",
            " limit #{offset},#{pagesize} "
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="domainName", property="domainName", jdbcType=JdbcType.VARCHAR),
            @Result(column="domainUrl", property="domainUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="wordMetaCode", property="wordMetaCode", jdbcType=JdbcType.INTEGER),
            @Result(column="wordMetaEn", property="wordMetaEn", jdbcType=JdbcType.VARCHAR),
            @Result(column="wordMetaZh", property="wordMetaZh", jdbcType=JdbcType.VARCHAR),
            @Result(column="simpleWordMetaEn", property="simpleWordMetaEn", jdbcType=JdbcType.VARCHAR),
            @Result(column="simpleWordMetaZh", property="simpleWordMetaZh", jdbcType=JdbcType.VARCHAR),
            @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<SjzDomainWordSort> selectListByPaging(@Param("offset") int offset, @Param("pagesize") int pageSize);


}
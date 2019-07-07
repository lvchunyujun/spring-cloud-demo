package com.hexiaofei.provider0.dao.mapper;

import com.hexiaofei.provider0.domain.SjzDomainInfo;
import com.hexiaofei.provider0.domain.SjzDomainInfoExample;

import java.util.Date;
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

public interface SjzDomainInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    @SelectProvider(type=SjzDomainInfoSqlProvider.class, method="countByExample")
    int countByExample(SjzDomainInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    @DeleteProvider(type=SjzDomainInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(SjzDomainInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    @Delete({
        "delete from sjz_domain_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    @Insert({
        "insert into sjz_domain_info (id, domainName, ",
        "domainUrl, domainIp, ",
        "source, type, crawlStatus, ",
        "lastCrawlTime, crawlUseTime, ",
        "description, manageStatus, ",
        "contentLevel, createTime)",
        "values (#{id,jdbcType=INTEGER}, #{domainName,jdbcType=INTEGER}, ",
        "#{domainUrl,jdbcType=VARCHAR}, #{domainIp,jdbcType=CHAR}, ",
        "#{source,jdbcType=VARCHAR}, #{type,jdbcType=SMALLINT}, #{crawlStatus,jdbcType=SMALLINT}, ",
        "#{lastCrawlTime,jdbcType=TIMESTAMP}, #{crawlUseTime,jdbcType=INTEGER}, ",
        "#{description,jdbcType=VARCHAR}, #{manageStatus,jdbcType=SMALLINT}, ",
        "#{contentLevel,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(SjzDomainInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    @InsertProvider(type=SjzDomainInfoSqlProvider.class, method="insertSelective")
    int insertSelective(SjzDomainInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    @SelectProvider(type=SjzDomainInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="domainName", property="domainName", jdbcType=JdbcType.INTEGER),
        @Result(column="domainUrl", property="domainUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="domainIp", property="domainIp", jdbcType=JdbcType.CHAR),
        @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.SMALLINT),
        @Result(column="crawlStatus", property="crawlStatus", jdbcType=JdbcType.SMALLINT),
        @Result(column="lastCrawlTime", property="lastCrawlTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="crawlUseTime", property="crawlUseTime", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="manageStatus", property="manageStatus", jdbcType=JdbcType.SMALLINT),
        @Result(column="contentLevel", property="contentLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SjzDomainInfo> selectByExample(SjzDomainInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    @Select({
        "select",
        "id, domainName, domainUrl, domainIp, source, type, crawlStatus, lastCrawlTime, ",
        "crawlUseTime, description, manageStatus, contentLevel, createTime",
        "from sjz_domain_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="domainName", property="domainName", jdbcType=JdbcType.VARCHAR),
        @Result(column="domainUrl", property="domainUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="domainIp", property="domainIp", jdbcType=JdbcType.CHAR),
        @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.SMALLINT),
        @Result(column="crawlStatus", property="crawlStatus", jdbcType=JdbcType.SMALLINT),
        @Result(column="lastCrawlTime", property="lastCrawlTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="crawlUseTime", property="crawlUseTime", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="manageStatus", property="manageStatus", jdbcType=JdbcType.SMALLINT),
        @Result(column="contentLevel", property="contentLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SjzDomainInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    @UpdateProvider(type=SjzDomainInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SjzDomainInfo record, @Param("example") SjzDomainInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    @UpdateProvider(type=SjzDomainInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SjzDomainInfo record, @Param("example") SjzDomainInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    @UpdateProvider(type=SjzDomainInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SjzDomainInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    @Update({
        "update sjz_domain_info",
        "set domainName = #{domainName,jdbcType=VARCHAR},",
          "domainUrl = #{domainUrl,jdbcType=VARCHAR},",
          "domainIp = #{domainIp,jdbcType=CHAR},",
          "source = #{source,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=SMALLINT},",
          "crawlStatus = #{crawlStatus,jdbcType=SMALLINT},",
          "lastCrawlTime = #{lastCrawlTime,jdbcType=TIMESTAMP},",
          "crawlUseTime = #{crawlUseTime,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR},",
          "manageStatus = #{manageStatus,jdbcType=SMALLINT},",
          "contentLevel = #{contentLevel,jdbcType=INTEGER},",
          "createTime = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SjzDomainInfo record);

    @Select({
            " select ",
            " id, domainName, domainUrl, domainIp, source, type, crawlStatus, lastCrawlTime, ",
            " crawlUseTime, description, manageStatus, contentLevel, createTime ",
            " from sjz_domain_info sdi ",
            " where sdi.crawlStatus = #{crawlStatus,jdbcType=SMALLINT} and (sdi.lastCrawlTime is null or sdi.lastCrawlTime < #{lastCrawlTime}) limit #{offset},#{pageSize} "
    })
    List<SjzDomainInfo> selectListByPaging(@Param("crawlStatus")  Short crawlStatus,@Param("lastCrawlTime")  Date lastCrawlTime,@Param("offset") Integer offset,@Param("pageSize") Integer pageSize);


    /**
     *
     * @param sjzDomainInfo
     * @param offset
     * @param pageSize
     * @return
     */
    @SelectProvider(type=SjzDomainInfoSqlProvider.class, method="selectListByPaging1")
    List<SjzDomainInfo> selectListByPaging1(@Param("sjzDomainInfo")  SjzDomainInfo sjzDomainInfo,@Param("offset") Integer offset,@Param("pageSize") Integer pageSize);

    /**
     *
     * @param sjzDomainInfo
     * @return
     */
    @SelectProvider(type=SjzDomainInfoSqlProvider.class, method="selectCountByPaging1")
    int selectCountByPaging1(SjzDomainInfo sjzDomainInfo);


    @Select(" select count(*) from sjz_domain_info sdi where sdi.crawlStatus = #{crawlStatus,jdbcType=SMALLINT} and (sdi.lastCrawlTime is null or sdi.lastCrawlTime < #{lastCrawlTime}) ")
    int selectCountByPaging(@Param("crawlStatus") Short crawlStatus,@Param("lastCrawlTime") Date lastCrawlTime);

    @Update({
            " update sjz_domain_info ",
            " set domainName = #{domainName,jdbcType=VARCHAR}, ",
            " crawlStatus = #{crawlStatus,jdbcType=SMALLINT}, ",
            " lastCrawlTime = #{lastCrawlTime,jdbcType=TIMESTAMP}, ",
            " crawlUseTime = #{crawlUseTime,jdbcType=INTEGER}",
            " where domainUrl = #{domainUrl,jdbcType=VARCHAR} "
    })
    int updateByCrawlResult(SjzDomainInfo sjzDomainInfo);
}
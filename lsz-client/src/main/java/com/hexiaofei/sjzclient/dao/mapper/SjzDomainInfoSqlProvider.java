package com.hexiaofei.sjzclient.dao.mapper;

import com.hexiaofei.sjzclient.domain.SjzDomainInfoExample.Criteria;
import com.hexiaofei.sjzclient.domain.SjzDomainInfoExample.Criterion;
import com.hexiaofei.sjzclient.domain.SjzDomainInfo;
import com.hexiaofei.sjzclient.domain.SjzDomainInfoExample;
import static org.apache.ibatis.jdbc.SqlBuilder.*;


import java.util.List;
import java.util.Map;


public class SjzDomainInfoSqlProvider {


    /**
     * 特殊业务使用
     * @param parameter
     * @return
     */
    public String selectListByPaging1(Map<String, Object> parameter){
        String or = "OR";
        boolean isAddOR = false;
        SjzDomainInfo sjzDomainInfo = (SjzDomainInfo)parameter.get("sjzDomainInfo");
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT  id, domainName, domainUrl, domainIp, source, type, crawlStatus, lastCrawlTime,  crawlUseTime, description, manageStatus, contentLevel, createTime ");
        sql.append(" FROM sjz_domain_info sdi  ");
        if(sjzDomainInfo!=null ){
            sql.append(" WHERE ");

            if(sjzDomainInfo.getLastCrawlTime()!=null){
                sql.append(" sdi.lastCrawlTime is null  ");
                isAddOR = true;
            }

            if(sjzDomainInfo.getCrawlUseTime()!=null){
                if(isAddOR)sql.append(or);
                sql.append(" sdi.crawlUseTime is null  ");
            }

            if(sjzDomainInfo.getCrawlStatus() != null){
                if(isAddOR)sql.append(or);
                sql.append(" sdi.crawlStatus = #{sjzDomainInfo.crawlStatus,jdbcType=SMALLINT}  ");
            }
            sql.append(" order by sdi.lastCrawlTime asc ");
            // 分页
            if(parameter.get("offset")!=null){
                sql.append(" limit #{offset,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}  ");
            }
        }


        return sql.toString();
    }

    /**
     * 特殊业务使用
     * @param sjzDomainInfo
     * @return
     */
    public String selectCountByPaging1(SjzDomainInfo sjzDomainInfo){
        String or = "OR";
        boolean isAddOR = false;
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT  count(*) ");
        sql.append(" FROM sjz_domain_info sdi  ");
        if(sjzDomainInfo!=null ){
            sql.append(" WHERE ");
            if(sjzDomainInfo.getLastCrawlTime()!=null){
                sql.append(" sdi.lastCrawlTime is null  ");
                isAddOR = true;
            }
            if(sjzDomainInfo.getCrawlUseTime()!=null){
                if(isAddOR)
                {
                    sql.append(or);
                }
                sql.append(" sdi.crawlUseTime is null  ");
            }
            if(sjzDomainInfo.getCrawlStatus() != null){
                if(isAddOR)
                {
                    sql.append(or);
                }
                sql.append(" sdi.crawlStatus = #{crawlStatus,jdbcType=SMALLINT}  ");
            }
        }

        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    public String countByExample(SjzDomainInfoExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sjz_domain_info");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    public String deleteByExample(SjzDomainInfoExample example) {
        BEGIN();
        DELETE_FROM("sjz_domain_info");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    public String insertSelective(SjzDomainInfo record) {
        BEGIN();
        INSERT_INTO("sjz_domain_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getDomainName() != null) {
            VALUES("domainName", "#{domainName,jdbcType=VARCHAR}");
        }
        
        if (record.getDomainUrl() != null) {
            VALUES("domainUrl", "#{domainUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getDomainIp() != null) {
            VALUES("domainIp", "#{domainIp,jdbcType=CHAR}");
        }
        
        if (record.getSource() != null) {
            VALUES("source", "#{source,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            VALUES("type", "#{type,jdbcType=SMALLINT}");
        }
        
        if (record.getCrawlStatus() != null) {
            VALUES("crawlStatus", "#{crawlStatus,jdbcType=SMALLINT}");
        }
        
        if (record.getLastCrawlTime() != null) {
            VALUES("lastCrawlTime", "#{lastCrawlTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCrawlUseTime() != null) {
            VALUES("crawlUseTime", "#{crawlUseTime,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getManageStatus() != null) {
            VALUES("manageStatus", "#{manageStatus,jdbcType=SMALLINT}");
        }
        
        if (record.getContentLevel() != null) {
            VALUES("contentLevel", "#{contentLevel,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    public String selectByExample(SjzDomainInfoExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("domainName");
        SELECT("domainUrl");
        SELECT("domainIp");
        SELECT("source");
        SELECT("type");
        SELECT("crawlStatus");
        SELECT("lastCrawlTime");
        SELECT("crawlUseTime");
        SELECT("description");
        SELECT("manageStatus");
        SELECT("contentLevel");
        SELECT("createTime");
        FROM("sjz_domain_info");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        SjzDomainInfo record = (SjzDomainInfo) parameter.get("record");
        SjzDomainInfoExample example = (SjzDomainInfoExample) parameter.get("example");
        
        BEGIN();
        UPDATE("sjz_domain_info");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getDomainName() != null) {
            SET("domainName = #{record.domainName,jdbcType=VARCHAR}");
        }
        
        if (record.getDomainUrl() != null) {
            SET("domainUrl = #{record.domainUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getDomainIp() != null) {
            SET("domainIp = #{record.domainIp,jdbcType=CHAR}");
        }
        
        if (record.getSource() != null) {
            SET("source = #{record.source,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            SET("type = #{record.type,jdbcType=SMALLINT}");
        }
        
        if (record.getCrawlStatus() != null) {
            SET("crawlStatus = #{record.crawlStatus,jdbcType=SMALLINT}");
        }
        
        if (record.getLastCrawlTime() != null) {
            SET("lastCrawlTime = #{record.lastCrawlTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCrawlUseTime() != null) {
            SET("crawlUseTime = #{record.crawlUseTime,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{record.description,jdbcType=VARCHAR}");
        }
        
        if (record.getManageStatus() != null) {
            SET("manageStatus = #{record.manageStatus,jdbcType=SMALLINT}");
        }
        
        if (record.getContentLevel() != null) {
            SET("contentLevel = #{record.contentLevel,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sjz_domain_info");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("domainName = #{record.domainName,jdbcType=VARCHAR}");
        SET("domainUrl = #{record.domainUrl,jdbcType=VARCHAR}");
        SET("domainIp = #{record.domainIp,jdbcType=CHAR}");
        SET("source = #{record.source,jdbcType=VARCHAR}");
        SET("type = #{record.type,jdbcType=SMALLINT}");
        SET("crawlStatus = #{record.crawlStatus,jdbcType=SMALLINT}");
        SET("lastCrawlTime = #{record.lastCrawlTime,jdbcType=TIMESTAMP}");
        SET("crawlUseTime = #{record.crawlUseTime,jdbcType=INTEGER}");
        SET("description = #{record.description,jdbcType=VARCHAR}");
        SET("manageStatus = #{record.manageStatus,jdbcType=SMALLINT}");
        SET("contentLevel = #{record.contentLevel,jdbcType=INTEGER}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        
        SjzDomainInfoExample example = (SjzDomainInfoExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    public String updateByPrimaryKeySelective(SjzDomainInfo record) {
        BEGIN();
        UPDATE("sjz_domain_info");
        
        if (record.getDomainName() != null) {
            SET("domainName = #{domainName,jdbcType=VARCHAR}");
        }
        
        if (record.getDomainUrl() != null) {
            SET("domainUrl = #{domainUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getDomainIp() != null) {
            SET("domainIp = #{domainIp,jdbcType=CHAR}");
        }
        
        if (record.getSource() != null) {
            SET("source = #{source,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            SET("type = #{type,jdbcType=SMALLINT}");
        }
        
        if (record.getCrawlStatus() != null) {
            SET("crawlStatus = #{crawlStatus,jdbcType=SMALLINT}");
        }
        
        if (record.getLastCrawlTime() != null) {
            SET("lastCrawlTime = #{lastCrawlTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCrawlUseTime() != null) {
            SET("crawlUseTime = #{crawlUseTime,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getManageStatus() != null) {
            SET("manageStatus = #{manageStatus,jdbcType=SMALLINT}");
        }
        
        if (record.getContentLevel() != null) {
            SET("contentLevel = #{contentLevel,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_info
     *
     * @mbggenerated Fri Jun 21 22:31:03 CST 2019
     */
    protected void applyWhere(SjzDomainInfoExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}
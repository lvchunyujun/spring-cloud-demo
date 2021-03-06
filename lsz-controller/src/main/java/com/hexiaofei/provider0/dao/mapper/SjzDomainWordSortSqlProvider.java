package com.hexiaofei.provider0.dao.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.hexiaofei.provider0.domain.SjzDomainSpiderTask;
import com.hexiaofei.provider0.domain.SjzDomainWordSort;
import com.hexiaofei.provider0.domain.SjzDomainWordSortExample.Criteria;
import com.hexiaofei.provider0.domain.SjzDomainWordSortExample.Criterion;
import com.hexiaofei.provider0.domain.SjzDomainWordSortExample;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class SjzDomainWordSortSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    public String countByExample(SjzDomainWordSortExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sjz_domain_word_sort");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    public String deleteByExample(SjzDomainWordSortExample example) {
        BEGIN();
        DELETE_FROM("sjz_domain_word_sort");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    public String insertSelective(SjzDomainWordSort record) {
        BEGIN();
        INSERT_INTO("sjz_domain_word_sort");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getDomainName() != null) {
            VALUES("domainName", "#{domainName,jdbcType=VARCHAR}");
        }
        
        if (record.getDomainUrl() != null) {
            VALUES("domainUrl", "#{domainUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getWordMetaCode() != null) {
            VALUES("wordMetaCode", "#{wordMetaCode,jdbcType=INTEGER}");
        }
        
        if (record.getWordMetaEn() != null) {
            VALUES("wordMetaEn", "#{wordMetaEn,jdbcType=VARCHAR}");
        }
        
        if (record.getWordMetaZh() != null) {
            VALUES("wordMetaZh", "#{wordMetaZh,jdbcType=VARCHAR}");
        }
        
        if (record.getSimpleWordMetaEn() != null) {
            VALUES("simpleWordMetaEn", "#{simpleWordMetaEn,jdbcType=VARCHAR}");
        }
        
        if (record.getSimpleWordMetaZh() != null) {
            VALUES("simpleWordMetaZh", "#{simpleWordMetaZh,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    public String selectByExample(SjzDomainWordSortExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("domainName");
        SELECT("domainUrl");
        SELECT("wordMetaCode");
        SELECT("wordMetaEn");
        SELECT("wordMetaZh");
        SELECT("simpleWordMetaEn");
        SELECT("simpleWordMetaZh");
        SELECT("createTime");
        SELECT("description");
        FROM("sjz_domain_word_sort");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        SjzDomainWordSort record = (SjzDomainWordSort) parameter.get("record");
        SjzDomainWordSortExample example = (SjzDomainWordSortExample) parameter.get("example");
        
        BEGIN();
        UPDATE("sjz_domain_word_sort");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getDomainName() != null) {
            SET("domainName = #{record.domainName,jdbcType=VARCHAR}");
        }
        
        if (record.getDomainUrl() != null) {
            SET("domainUrl = #{record.domainUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getWordMetaCode() != null) {
            SET("wordMetaCode = #{record.wordMetaCode,jdbcType=INTEGER}");
        }
        
        if (record.getWordMetaEn() != null) {
            SET("wordMetaEn = #{record.wordMetaEn,jdbcType=VARCHAR}");
        }
        
        if (record.getWordMetaZh() != null) {
            SET("wordMetaZh = #{record.wordMetaZh,jdbcType=VARCHAR}");
        }
        
        if (record.getSimpleWordMetaEn() != null) {
            SET("simpleWordMetaEn = #{record.simpleWordMetaEn,jdbcType=VARCHAR}");
        }
        
        if (record.getSimpleWordMetaZh() != null) {
            SET("simpleWordMetaZh = #{record.simpleWordMetaZh,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{record.description,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sjz_domain_word_sort");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("domainName = #{record.domainName,jdbcType=VARCHAR}");
        SET("domainUrl = #{record.domainUrl,jdbcType=VARCHAR}");
        SET("wordMetaCode = #{record.wordMetaCode,jdbcType=INTEGER}");
        SET("wordMetaEn = #{record.wordMetaEn,jdbcType=VARCHAR}");
        SET("wordMetaZh = #{record.wordMetaZh,jdbcType=VARCHAR}");
        SET("simpleWordMetaEn = #{record.simpleWordMetaEn,jdbcType=VARCHAR}");
        SET("simpleWordMetaZh = #{record.simpleWordMetaZh,jdbcType=VARCHAR}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("description = #{record.description,jdbcType=VARCHAR}");
        
        SjzDomainWordSortExample example = (SjzDomainWordSortExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    public String updateByPrimaryKeySelective(SjzDomainWordSort record) {
        BEGIN();
        UPDATE("sjz_domain_word_sort");
        
        if (record.getDomainName() != null) {
            SET("domainName = #{domainName,jdbcType=VARCHAR}");
        }
        
        if (record.getDomainUrl() != null) {
            SET("domainUrl = #{domainUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getWordMetaCode() != null) {
            SET("wordMetaCode = #{wordMetaCode,jdbcType=INTEGER}");
        }
        
        if (record.getWordMetaEn() != null) {
            SET("wordMetaEn = #{wordMetaEn,jdbcType=VARCHAR}");
        }
        
        if (record.getWordMetaZh() != null) {
            SET("wordMetaZh = #{wordMetaZh,jdbcType=VARCHAR}");
        }
        
        if (record.getSimpleWordMetaEn() != null) {
            SET("simpleWordMetaEn = #{simpleWordMetaEn,jdbcType=VARCHAR}");
        }
        
        if (record.getSimpleWordMetaZh() != null) {
            SET("simpleWordMetaZh = #{simpleWordMetaZh,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_domain_word_sort
     *
     * @mbggenerated Sat Oct 19 16:14:18 CST 2019
     */
    protected void applyWhere(SjzDomainWordSortExample example, boolean includeExamplePhrase) {
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

    public String selectListBySpiderTaskList(Map<String,List<SjzDomainSpiderTask>> map){
        List<SjzDomainSpiderTask> list = map.get("list");
        StringBuilder sqlBuilder = new StringBuilder("select id, domainName, domainUrl, wordMetaCode, wordMetaEn, wordMetaZh, simpleWordMetaEn,simpleWordMetaZh, createTime, description");
        sqlBuilder.append(" from sjz_domain_word_sort s ") ;
        sqlBuilder.append(" where  s.wordMetaCode in ( ");


        for(int i = 0 ; i < list.size() ; i++){
            sqlBuilder.append(" #{list[");
            sqlBuilder.append(i);
            sqlBuilder.append("].wordCode ,jdbcType=INTEGER}");
            if(list.size()-1 > i){
                sqlBuilder.append(" , ");
            }
        }
        sqlBuilder.append(" ) ");

        return sqlBuilder.toString();
    }
}
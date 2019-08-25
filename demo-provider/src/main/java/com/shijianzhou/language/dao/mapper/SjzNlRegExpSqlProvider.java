package com.shijianzhou.language.dao.mapper;

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

import com.shijianzhou.language.domain.SjzNlRegExp;
import com.shijianzhou.language.domain.SjzNlRegExpExample.Criteria;
import com.shijianzhou.language.domain.SjzNlRegExpExample.Criterion;
import com.shijianzhou.language.domain.SjzNlRegExpExample;
import java.util.List;
import java.util.Map;

public class SjzNlRegExpSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public String countByExample(SjzNlRegExpExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sjz_nl_reg_exp");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public String deleteByExample(SjzNlRegExpExample example) {
        BEGIN();
        DELETE_FROM("sjz_nl_reg_exp");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public String insertSelective(SjzNlRegExp record) {
        BEGIN();
        INSERT_INTO("sjz_nl_reg_exp");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getRegExpPattern() != null) {
            VALUES("regExpPattern", "#{regExpPattern,jdbcType=VARCHAR}");
        }
        
        if (record.getRegExpDemo() != null) {
            VALUES("regExpDemo", "#{regExpDemo,jdbcType=VARCHAR}");
        }
        
        if (record.getPatternType() != null) {
            VALUES("patternType", "#{patternType,jdbcType=SMALLINT}");
        }
        
        if (record.getMatchType() != null) {
            VALUES("matchType", "#{matchType,jdbcType=SMALLINT}");
        }
        
        if (record.getCheckStatus() != null) {
            VALUES("checkStatus", "#{checkStatus,jdbcType=SMALLINT}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescr() != null) {
            VALUES("descr", "#{descr,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public String selectByExample(SjzNlRegExpExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("regExpPattern");
        SELECT("regExpDemo");
        SELECT("patternType");
        SELECT("matchType");
        SELECT("checkStatus");
        SELECT("createTime");
        SELECT("descr");
        FROM("sjz_nl_reg_exp");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        SjzNlRegExp record = (SjzNlRegExp) parameter.get("record");
        SjzNlRegExpExample example = (SjzNlRegExpExample) parameter.get("example");
        
        BEGIN();
        UPDATE("sjz_nl_reg_exp");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getRegExpPattern() != null) {
            SET("regExpPattern = #{record.regExpPattern,jdbcType=VARCHAR}");
        }
        
        if (record.getRegExpDemo() != null) {
            SET("regExpDemo = #{record.regExpDemo,jdbcType=VARCHAR}");
        }
        
        if (record.getPatternType() != null) {
            SET("patternType = #{record.patternType,jdbcType=SMALLINT}");
        }
        
        if (record.getMatchType() != null) {
            SET("matchType = #{record.matchType,jdbcType=SMALLINT}");
        }
        
        if (record.getCheckStatus() != null) {
            SET("checkStatus = #{record.checkStatus,jdbcType=SMALLINT}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescr() != null) {
            SET("descr = #{record.descr,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sjz_nl_reg_exp");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("regExpPattern = #{record.regExpPattern,jdbcType=VARCHAR}");
        SET("regExpDemo = #{record.regExpDemo,jdbcType=VARCHAR}");
        SET("patternType = #{record.patternType,jdbcType=SMALLINT}");
        SET("matchType = #{record.matchType,jdbcType=SMALLINT}");
        SET("checkStatus = #{record.checkStatus,jdbcType=SMALLINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("descr = #{record.descr,jdbcType=VARCHAR}");
        
        SjzNlRegExpExample example = (SjzNlRegExpExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public String updateByPrimaryKeySelective(SjzNlRegExp record) {
        BEGIN();
        UPDATE("sjz_nl_reg_exp");
        
        if (record.getRegExpPattern() != null) {
            SET("regExpPattern = #{regExpPattern,jdbcType=VARCHAR}");
        }
        
        if (record.getRegExpDemo() != null) {
            SET("regExpDemo = #{regExpDemo,jdbcType=VARCHAR}");
        }
        
        if (record.getPatternType() != null) {
            SET("patternType = #{patternType,jdbcType=SMALLINT}");
        }
        
        if (record.getMatchType() != null) {
            SET("matchType = #{matchType,jdbcType=SMALLINT}");
        }
        
        if (record.getCheckStatus() != null) {
            SET("checkStatus = #{checkStatus,jdbcType=SMALLINT}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescr() != null) {
            SET("descr = #{descr,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    protected void applyWhere(SjzNlRegExpExample example, boolean includeExamplePhrase) {
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
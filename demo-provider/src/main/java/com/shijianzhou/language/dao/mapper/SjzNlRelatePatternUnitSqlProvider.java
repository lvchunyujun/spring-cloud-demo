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

import com.shijianzhou.language.domain.SjzNlRelatePatternUnit;
import com.shijianzhou.language.domain.SjzNlRelatePatternUnitExample.Criteria;
import com.shijianzhou.language.domain.SjzNlRelatePatternUnitExample.Criterion;
import com.shijianzhou.language.domain.SjzNlRelatePatternUnitExample;
import java.util.List;
import java.util.Map;

public class SjzNlRelatePatternUnitSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_relate_pattern_unit
     *
     * @mbggenerated Fri Oct 04 21:29:50 CST 2019
     */
    public String countByExample(SjzNlRelatePatternUnitExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sjz_nl_relate_pattern_unit");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_relate_pattern_unit
     *
     * @mbggenerated Fri Oct 04 21:29:50 CST 2019
     */
    public String deleteByExample(SjzNlRelatePatternUnitExample example) {
        BEGIN();
        DELETE_FROM("sjz_nl_relate_pattern_unit");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_relate_pattern_unit
     *
     * @mbggenerated Fri Oct 04 21:29:50 CST 2019
     */
    public String insertSelective(SjzNlRelatePatternUnit record) {
        BEGIN();
        INSERT_INTO("sjz_nl_relate_pattern_unit");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getPatternName() != null) {
            VALUES("patternName", "#{patternName,jdbcType=VARCHAR}");
        }
        
        if (record.getUnitSerialNo() != null) {
            VALUES("unitSerialNo", "#{unitSerialNo,jdbcType=INTEGER}");
        }
        
        if (record.getRegExpCode() != null) {
            VALUES("regExpCode", "#{regExpCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRegExpPattern() != null) {
            VALUES("regExpPattern", "#{regExpPattern,jdbcType=VARCHAR}");
        }
        
        if (record.getRelateType() != null) {
            VALUES("relateType", "#{relateType,jdbcType=SMALLINT}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdateTime() != null) {
            VALUES("lastUpdateTime", "#{lastUpdateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescript() != null) {
            VALUES("descript", "#{descript,jdbcType=VARCHAR}");
        }
        
        if (record.getUseStatus() != null) {
            VALUES("useStatus", "#{useStatus,jdbcType=SMALLINT}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_relate_pattern_unit
     *
     * @mbggenerated Fri Oct 04 21:29:50 CST 2019
     */
    public String selectByExample(SjzNlRelatePatternUnitExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("patternName");
        SELECT("unitSerialNo");
        SELECT("regExpCode");
        SELECT("regExpPattern");
        SELECT("relateType");
        SELECT("createTime");
        SELECT("lastUpdateTime");
        SELECT("descript");
        SELECT("useStatus");
        FROM("sjz_nl_relate_pattern_unit");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_relate_pattern_unit
     *
     * @mbggenerated Fri Oct 04 21:29:50 CST 2019
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        SjzNlRelatePatternUnit record = (SjzNlRelatePatternUnit) parameter.get("record");
        SjzNlRelatePatternUnitExample example = (SjzNlRelatePatternUnitExample) parameter.get("example");
        
        BEGIN();
        UPDATE("sjz_nl_relate_pattern_unit");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getPatternName() != null) {
            SET("patternName = #{record.patternName,jdbcType=VARCHAR}");
        }
        
        if (record.getUnitSerialNo() != null) {
            SET("unitSerialNo = #{record.unitSerialNo,jdbcType=INTEGER}");
        }
        
        if (record.getRegExpCode() != null) {
            SET("regExpCode = #{record.regExpCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRegExpPattern() != null) {
            SET("regExpPattern = #{record.regExpPattern,jdbcType=VARCHAR}");
        }
        
        if (record.getRelateType() != null) {
            SET("relateType = #{record.relateType,jdbcType=SMALLINT}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdateTime() != null) {
            SET("lastUpdateTime = #{record.lastUpdateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescript() != null) {
            SET("descript = #{record.descript,jdbcType=VARCHAR}");
        }
        
        if (record.getUseStatus() != null) {
            SET("useStatus = #{record.useStatus,jdbcType=SMALLINT}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_relate_pattern_unit
     *
     * @mbggenerated Fri Oct 04 21:29:50 CST 2019
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sjz_nl_relate_pattern_unit");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("patternName = #{record.patternName,jdbcType=VARCHAR}");
        SET("unitSerialNo = #{record.unitSerialNo,jdbcType=INTEGER}");
        SET("regExpCode = #{record.regExpCode,jdbcType=VARCHAR}");
        SET("regExpPattern = #{record.regExpPattern,jdbcType=VARCHAR}");
        SET("relateType = #{record.relateType,jdbcType=SMALLINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("lastUpdateTime = #{record.lastUpdateTime,jdbcType=TIMESTAMP}");
        SET("descript = #{record.descript,jdbcType=VARCHAR}");
        SET("useStatus = #{record.useStatus,jdbcType=SMALLINT}");
        
        SjzNlRelatePatternUnitExample example = (SjzNlRelatePatternUnitExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_relate_pattern_unit
     *
     * @mbggenerated Fri Oct 04 21:29:50 CST 2019
     */
    public String updateByPrimaryKeySelective(SjzNlRelatePatternUnit record) {
        BEGIN();
        UPDATE("sjz_nl_relate_pattern_unit");
        
        if (record.getPatternName() != null) {
            SET("patternName = #{patternName,jdbcType=VARCHAR}");
        }
        
        if (record.getUnitSerialNo() != null) {
            SET("unitSerialNo = #{unitSerialNo,jdbcType=INTEGER}");
        }
        
        if (record.getRegExpCode() != null) {
            SET("regExpCode = #{regExpCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRegExpPattern() != null) {
            SET("regExpPattern = #{regExpPattern,jdbcType=VARCHAR}");
        }
        
        if (record.getRelateType() != null) {
            SET("relateType = #{relateType,jdbcType=SMALLINT}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdateTime() != null) {
            SET("lastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescript() != null) {
            SET("descript = #{descript,jdbcType=VARCHAR}");
        }
        
        if (record.getUseStatus() != null) {
            SET("useStatus = #{useStatus,jdbcType=SMALLINT}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_relate_pattern_unit
     *
     * @mbggenerated Fri Oct 04 21:29:50 CST 2019
     */
    protected void applyWhere(SjzNlRelatePatternUnitExample example, boolean includeExamplePhrase) {
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
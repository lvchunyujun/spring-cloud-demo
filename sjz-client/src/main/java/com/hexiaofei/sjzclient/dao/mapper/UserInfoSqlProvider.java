package com.hexiaofei.sjzclient.dao.mapper;


import com.hexiaofei.sjzclient.domain.UserInfo;
import com.hexiaofei.sjzclient.domain.UserInfoExample;
import com.hexiaofei.sjzclient.domain.UserInfoExample.Criteria;
import com.hexiaofei.sjzclient.domain.UserInfoExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class UserInfoSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:29 CST 2019
     */
    public String countByExample(UserInfoExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("user_info");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:29 CST 2019
     */
    public String deleteByExample(UserInfoExample example) {
        BEGIN();
        DELETE_FROM("user_info");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:29 CST 2019
     */
    public String insertSelective(UserInfo record) {
        BEGIN();
        INSERT_INTO("user_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getNickName() != null) {
            VALUES("nickName", "#{nickName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            VALUES("userName", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            VALUES("realName", "#{realName,jdbcType=VARCHAR}");
        }
        
        if (record.getRole() != null) {
            VALUES("role", "#{role,jdbcType=SMALLINT}");
        }
        
        if (record.getIdCard() != null) {
            VALUES("idCard", "#{idCard,jdbcType=CHAR}");
        }
        
        if (record.getPhone() != null) {
            VALUES("phone", "#{phone,jdbcType=CHAR}");
        }
        
        if (record.getEmail() != null) {
            VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getRegisterDate() != null) {
            VALUES("registerDate", "#{registerDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=SMALLINT}");
        }
        
        if (record.getLoginCount() != null) {
            VALUES("loginCount", "#{loginCount,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:29 CST 2019
     */
    public String selectByExample(UserInfoExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("nickName");
        SELECT("userName");
        SELECT("password");
        SELECT("realName");
        SELECT("role");
        SELECT("idCard");
        SELECT("phone");
        SELECT("email");
        SELECT("registerDate");
        SELECT("status");
        SELECT("loginCount");
        FROM("user_info");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:29 CST 2019
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserInfo record = (UserInfo) parameter.get("record");
        UserInfoExample example = (UserInfoExample) parameter.get("example");
        
        BEGIN();
        UPDATE("user_info");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getNickName() != null) {
            SET("nickName = #{record.nickName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            SET("userName = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{record.password,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            SET("realName = #{record.realName,jdbcType=VARCHAR}");
        }
        
        if (record.getRole() != null) {
            SET("role = #{record.role,jdbcType=SMALLINT}");
        }
        
        if (record.getIdCard() != null) {
            SET("idCard = #{record.idCard,jdbcType=CHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{record.phone,jdbcType=CHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getRegisterDate() != null) {
            SET("registerDate = #{record.registerDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=SMALLINT}");
        }
        
        if (record.getLoginCount() != null) {
            SET("loginCount = #{record.loginCount,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:29 CST 2019
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("user_info");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("nickName = #{record.nickName,jdbcType=VARCHAR}");
        SET("userName = #{record.userName,jdbcType=VARCHAR}");
        SET("password = #{record.password,jdbcType=VARCHAR}");
        SET("realName = #{record.realName,jdbcType=VARCHAR}");
        SET("role = #{record.role,jdbcType=SMALLINT}");
        SET("idCard = #{record.idCard,jdbcType=CHAR}");
        SET("phone = #{record.phone,jdbcType=CHAR}");
        SET("email = #{record.email,jdbcType=VARCHAR}");
        SET("registerDate = #{record.registerDate,jdbcType=TIMESTAMP}");
        SET("status = #{record.status,jdbcType=SMALLINT}");
        SET("loginCount = #{record.loginCount,jdbcType=INTEGER}");
        
        UserInfoExample example = (UserInfoExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:29 CST 2019
     */
    public String updateByPrimaryKeySelective(UserInfo record) {
        BEGIN();
        UPDATE("user_info");
        
        if (record.getNickName() != null) {
            SET("nickName = #{nickName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            SET("userName = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            SET("realName = #{realName,jdbcType=VARCHAR}");
        }
        
        if (record.getRole() != null) {
            SET("role = #{role,jdbcType=SMALLINT}");
        }
        
        if (record.getIdCard() != null) {
            SET("idCard = #{idCard,jdbcType=CHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{phone,jdbcType=CHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getRegisterDate() != null) {
            SET("registerDate = #{registerDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=SMALLINT}");
        }
        
        if (record.getLoginCount() != null) {
            SET("loginCount = #{loginCount,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Sat Nov 09 19:41:29 CST 2019
     */
    protected void applyWhere(UserInfoExample example, boolean includeExamplePhrase) {
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
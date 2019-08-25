package com.shijianzhou.language.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SjzNlRegExpExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public SjzNlRegExpExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRegExpPatternIsNull() {
            addCriterion("regExpPattern is null");
            return (Criteria) this;
        }

        public Criteria andRegExpPatternIsNotNull() {
            addCriterion("regExpPattern is not null");
            return (Criteria) this;
        }

        public Criteria andRegExpPatternEqualTo(String value) {
            addCriterion("regExpPattern =", value, "regExpPattern");
            return (Criteria) this;
        }

        public Criteria andRegExpPatternNotEqualTo(String value) {
            addCriterion("regExpPattern <>", value, "regExpPattern");
            return (Criteria) this;
        }

        public Criteria andRegExpPatternGreaterThan(String value) {
            addCriterion("regExpPattern >", value, "regExpPattern");
            return (Criteria) this;
        }

        public Criteria andRegExpPatternGreaterThanOrEqualTo(String value) {
            addCriterion("regExpPattern >=", value, "regExpPattern");
            return (Criteria) this;
        }

        public Criteria andRegExpPatternLessThan(String value) {
            addCriterion("regExpPattern <", value, "regExpPattern");
            return (Criteria) this;
        }

        public Criteria andRegExpPatternLessThanOrEqualTo(String value) {
            addCriterion("regExpPattern <=", value, "regExpPattern");
            return (Criteria) this;
        }

        public Criteria andRegExpPatternLike(String value) {
            addCriterion("regExpPattern like", value, "regExpPattern");
            return (Criteria) this;
        }

        public Criteria andRegExpPatternNotLike(String value) {
            addCriterion("regExpPattern not like", value, "regExpPattern");
            return (Criteria) this;
        }

        public Criteria andRegExpPatternIn(List<String> values) {
            addCriterion("regExpPattern in", values, "regExpPattern");
            return (Criteria) this;
        }

        public Criteria andRegExpPatternNotIn(List<String> values) {
            addCriterion("regExpPattern not in", values, "regExpPattern");
            return (Criteria) this;
        }

        public Criteria andRegExpPatternBetween(String value1, String value2) {
            addCriterion("regExpPattern between", value1, value2, "regExpPattern");
            return (Criteria) this;
        }

        public Criteria andRegExpPatternNotBetween(String value1, String value2) {
            addCriterion("regExpPattern not between", value1, value2, "regExpPattern");
            return (Criteria) this;
        }

        public Criteria andRegExpDemoIsNull() {
            addCriterion("regExpDemo is null");
            return (Criteria) this;
        }

        public Criteria andRegExpDemoIsNotNull() {
            addCriterion("regExpDemo is not null");
            return (Criteria) this;
        }

        public Criteria andRegExpDemoEqualTo(String value) {
            addCriterion("regExpDemo =", value, "regExpDemo");
            return (Criteria) this;
        }

        public Criteria andRegExpDemoNotEqualTo(String value) {
            addCriterion("regExpDemo <>", value, "regExpDemo");
            return (Criteria) this;
        }

        public Criteria andRegExpDemoGreaterThan(String value) {
            addCriterion("regExpDemo >", value, "regExpDemo");
            return (Criteria) this;
        }

        public Criteria andRegExpDemoGreaterThanOrEqualTo(String value) {
            addCriterion("regExpDemo >=", value, "regExpDemo");
            return (Criteria) this;
        }

        public Criteria andRegExpDemoLessThan(String value) {
            addCriterion("regExpDemo <", value, "regExpDemo");
            return (Criteria) this;
        }

        public Criteria andRegExpDemoLessThanOrEqualTo(String value) {
            addCriterion("regExpDemo <=", value, "regExpDemo");
            return (Criteria) this;
        }

        public Criteria andRegExpDemoLike(String value) {
            addCriterion("regExpDemo like", value, "regExpDemo");
            return (Criteria) this;
        }

        public Criteria andRegExpDemoNotLike(String value) {
            addCriterion("regExpDemo not like", value, "regExpDemo");
            return (Criteria) this;
        }

        public Criteria andRegExpDemoIn(List<String> values) {
            addCriterion("regExpDemo in", values, "regExpDemo");
            return (Criteria) this;
        }

        public Criteria andRegExpDemoNotIn(List<String> values) {
            addCriterion("regExpDemo not in", values, "regExpDemo");
            return (Criteria) this;
        }

        public Criteria andRegExpDemoBetween(String value1, String value2) {
            addCriterion("regExpDemo between", value1, value2, "regExpDemo");
            return (Criteria) this;
        }

        public Criteria andRegExpDemoNotBetween(String value1, String value2) {
            addCriterion("regExpDemo not between", value1, value2, "regExpDemo");
            return (Criteria) this;
        }

        public Criteria andPatternTypeIsNull() {
            addCriterion("patternType is null");
            return (Criteria) this;
        }

        public Criteria andPatternTypeIsNotNull() {
            addCriterion("patternType is not null");
            return (Criteria) this;
        }

        public Criteria andPatternTypeEqualTo(Short value) {
            addCriterion("patternType =", value, "patternType");
            return (Criteria) this;
        }

        public Criteria andPatternTypeNotEqualTo(Short value) {
            addCriterion("patternType <>", value, "patternType");
            return (Criteria) this;
        }

        public Criteria andPatternTypeGreaterThan(Short value) {
            addCriterion("patternType >", value, "patternType");
            return (Criteria) this;
        }

        public Criteria andPatternTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("patternType >=", value, "patternType");
            return (Criteria) this;
        }

        public Criteria andPatternTypeLessThan(Short value) {
            addCriterion("patternType <", value, "patternType");
            return (Criteria) this;
        }

        public Criteria andPatternTypeLessThanOrEqualTo(Short value) {
            addCriterion("patternType <=", value, "patternType");
            return (Criteria) this;
        }

        public Criteria andPatternTypeIn(List<Short> values) {
            addCriterion("patternType in", values, "patternType");
            return (Criteria) this;
        }

        public Criteria andPatternTypeNotIn(List<Short> values) {
            addCriterion("patternType not in", values, "patternType");
            return (Criteria) this;
        }

        public Criteria andPatternTypeBetween(Short value1, Short value2) {
            addCriterion("patternType between", value1, value2, "patternType");
            return (Criteria) this;
        }

        public Criteria andPatternTypeNotBetween(Short value1, Short value2) {
            addCriterion("patternType not between", value1, value2, "patternType");
            return (Criteria) this;
        }

        public Criteria andMatchTypeIsNull() {
            addCriterion("matchType is null");
            return (Criteria) this;
        }

        public Criteria andMatchTypeIsNotNull() {
            addCriterion("matchType is not null");
            return (Criteria) this;
        }

        public Criteria andMatchTypeEqualTo(Short value) {
            addCriterion("matchType =", value, "matchType");
            return (Criteria) this;
        }

        public Criteria andMatchTypeNotEqualTo(Short value) {
            addCriterion("matchType <>", value, "matchType");
            return (Criteria) this;
        }

        public Criteria andMatchTypeGreaterThan(Short value) {
            addCriterion("matchType >", value, "matchType");
            return (Criteria) this;
        }

        public Criteria andMatchTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("matchType >=", value, "matchType");
            return (Criteria) this;
        }

        public Criteria andMatchTypeLessThan(Short value) {
            addCriterion("matchType <", value, "matchType");
            return (Criteria) this;
        }

        public Criteria andMatchTypeLessThanOrEqualTo(Short value) {
            addCriterion("matchType <=", value, "matchType");
            return (Criteria) this;
        }

        public Criteria andMatchTypeIn(List<Short> values) {
            addCriterion("matchType in", values, "matchType");
            return (Criteria) this;
        }

        public Criteria andMatchTypeNotIn(List<Short> values) {
            addCriterion("matchType not in", values, "matchType");
            return (Criteria) this;
        }

        public Criteria andMatchTypeBetween(Short value1, Short value2) {
            addCriterion("matchType between", value1, value2, "matchType");
            return (Criteria) this;
        }

        public Criteria andMatchTypeNotBetween(Short value1, Short value2) {
            addCriterion("matchType not between", value1, value2, "matchType");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("checkStatus is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("checkStatus is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(Short value) {
            addCriterion("checkStatus =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(Short value) {
            addCriterion("checkStatus <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(Short value) {
            addCriterion("checkStatus >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("checkStatus >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(Short value) {
            addCriterion("checkStatus <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(Short value) {
            addCriterion("checkStatus <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<Short> values) {
            addCriterion("checkStatus in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<Short> values) {
            addCriterion("checkStatus not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(Short value1, Short value2) {
            addCriterion("checkStatus between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(Short value1, Short value2) {
            addCriterion("checkStatus not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDescrIsNull() {
            addCriterion("descr is null");
            return (Criteria) this;
        }

        public Criteria andDescrIsNotNull() {
            addCriterion("descr is not null");
            return (Criteria) this;
        }

        public Criteria andDescrEqualTo(String value) {
            addCriterion("descr =", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotEqualTo(String value) {
            addCriterion("descr <>", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrGreaterThan(String value) {
            addCriterion("descr >", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrGreaterThanOrEqualTo(String value) {
            addCriterion("descr >=", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrLessThan(String value) {
            addCriterion("descr <", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrLessThanOrEqualTo(String value) {
            addCriterion("descr <=", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrLike(String value) {
            addCriterion("descr like", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotLike(String value) {
            addCriterion("descr not like", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrIn(List<String> values) {
            addCriterion("descr in", values, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotIn(List<String> values) {
            addCriterion("descr not in", values, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrBetween(String value1, String value2) {
            addCriterion("descr between", value1, value2, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotBetween(String value1, String value2) {
            addCriterion("descr not between", value1, value2, "descr");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated do_not_delete_during_merge Sat Aug 24 21:11:39 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sjz_nl_reg_exp
     *
     * @mbggenerated Sat Aug 24 21:11:39 CST 2019
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
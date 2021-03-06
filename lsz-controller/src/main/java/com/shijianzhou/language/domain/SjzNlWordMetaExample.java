package com.shijianzhou.language.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SjzNlWordMetaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    public SjzNlWordMetaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
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
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
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

        public Criteria andWordMetaCodeIsNull() {
            addCriterion("wordMetaCode is null");
            return (Criteria) this;
        }

        public Criteria andWordMetaCodeIsNotNull() {
            addCriterion("wordMetaCode is not null");
            return (Criteria) this;
        }

        public Criteria andWordMetaCodeEqualTo(Integer value) {
            addCriterion("wordMetaCode =", value, "wordMetaCode");
            return (Criteria) this;
        }

        public Criteria andWordMetaCodeNotEqualTo(Integer value) {
            addCriterion("wordMetaCode <>", value, "wordMetaCode");
            return (Criteria) this;
        }

        public Criteria andWordMetaCodeGreaterThan(Integer value) {
            addCriterion("wordMetaCode >", value, "wordMetaCode");
            return (Criteria) this;
        }

        public Criteria andWordMetaCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("wordMetaCode >=", value, "wordMetaCode");
            return (Criteria) this;
        }

        public Criteria andWordMetaCodeLessThan(Integer value) {
            addCriterion("wordMetaCode <", value, "wordMetaCode");
            return (Criteria) this;
        }

        public Criteria andWordMetaCodeLessThanOrEqualTo(Integer value) {
            addCriterion("wordMetaCode <=", value, "wordMetaCode");
            return (Criteria) this;
        }

        public Criteria andWordMetaCodeIn(List<Integer> values) {
            addCriterion("wordMetaCode in", values, "wordMetaCode");
            return (Criteria) this;
        }

        public Criteria andWordMetaCodeNotIn(List<Integer> values) {
            addCriterion("wordMetaCode not in", values, "wordMetaCode");
            return (Criteria) this;
        }

        public Criteria andWordMetaCodeBetween(Integer value1, Integer value2) {
            addCriterion("wordMetaCode between", value1, value2, "wordMetaCode");
            return (Criteria) this;
        }

        public Criteria andWordMetaCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("wordMetaCode not between", value1, value2, "wordMetaCode");
            return (Criteria) this;
        }

        public Criteria andWordMetaEnIsNull() {
            addCriterion("wordMetaEn is null");
            return (Criteria) this;
        }

        public Criteria andWordMetaEnIsNotNull() {
            addCriterion("wordMetaEn is not null");
            return (Criteria) this;
        }

        public Criteria andWordMetaEnEqualTo(String value) {
            addCriterion("wordMetaEn =", value, "wordMetaEn");
            return (Criteria) this;
        }

        public Criteria andWordMetaEnNotEqualTo(String value) {
            addCriterion("wordMetaEn <>", value, "wordMetaEn");
            return (Criteria) this;
        }

        public Criteria andWordMetaEnGreaterThan(String value) {
            addCriterion("wordMetaEn >", value, "wordMetaEn");
            return (Criteria) this;
        }

        public Criteria andWordMetaEnGreaterThanOrEqualTo(String value) {
            addCriterion("wordMetaEn >=", value, "wordMetaEn");
            return (Criteria) this;
        }

        public Criteria andWordMetaEnLessThan(String value) {
            addCriterion("wordMetaEn <", value, "wordMetaEn");
            return (Criteria) this;
        }

        public Criteria andWordMetaEnLessThanOrEqualTo(String value) {
            addCriterion("wordMetaEn <=", value, "wordMetaEn");
            return (Criteria) this;
        }

        public Criteria andWordMetaEnLike(String value) {
            addCriterion("wordMetaEn like", value, "wordMetaEn");
            return (Criteria) this;
        }

        public Criteria andWordMetaEnNotLike(String value) {
            addCriterion("wordMetaEn not like", value, "wordMetaEn");
            return (Criteria) this;
        }

        public Criteria andWordMetaEnIn(List<String> values) {
            addCriterion("wordMetaEn in", values, "wordMetaEn");
            return (Criteria) this;
        }

        public Criteria andWordMetaEnNotIn(List<String> values) {
            addCriterion("wordMetaEn not in", values, "wordMetaEn");
            return (Criteria) this;
        }

        public Criteria andWordMetaEnBetween(String value1, String value2) {
            addCriterion("wordMetaEn between", value1, value2, "wordMetaEn");
            return (Criteria) this;
        }

        public Criteria andWordMetaEnNotBetween(String value1, String value2) {
            addCriterion("wordMetaEn not between", value1, value2, "wordMetaEn");
            return (Criteria) this;
        }

        public Criteria andWordMetaZhIsNull() {
            addCriterion("wordMetaZh is null");
            return (Criteria) this;
        }

        public Criteria andWordMetaZhIsNotNull() {
            addCriterion("wordMetaZh is not null");
            return (Criteria) this;
        }

        public Criteria andWordMetaZhEqualTo(String value) {
            addCriterion("wordMetaZh =", value, "wordMetaZh");
            return (Criteria) this;
        }

        public Criteria andWordMetaZhNotEqualTo(String value) {
            addCriterion("wordMetaZh <>", value, "wordMetaZh");
            return (Criteria) this;
        }

        public Criteria andWordMetaZhGreaterThan(String value) {
            addCriterion("wordMetaZh >", value, "wordMetaZh");
            return (Criteria) this;
        }

        public Criteria andWordMetaZhGreaterThanOrEqualTo(String value) {
            addCriterion("wordMetaZh >=", value, "wordMetaZh");
            return (Criteria) this;
        }

        public Criteria andWordMetaZhLessThan(String value) {
            addCriterion("wordMetaZh <", value, "wordMetaZh");
            return (Criteria) this;
        }

        public Criteria andWordMetaZhLessThanOrEqualTo(String value) {
            addCriterion("wordMetaZh <=", value, "wordMetaZh");
            return (Criteria) this;
        }

        public Criteria andWordMetaZhLike(String value) {
            addCriterion("wordMetaZh like", value, "wordMetaZh");
            return (Criteria) this;
        }

        public Criteria andWordMetaZhNotLike(String value) {
            addCriterion("wordMetaZh not like", value, "wordMetaZh");
            return (Criteria) this;
        }

        public Criteria andWordMetaZhIn(List<String> values) {
            addCriterion("wordMetaZh in", values, "wordMetaZh");
            return (Criteria) this;
        }

        public Criteria andWordMetaZhNotIn(List<String> values) {
            addCriterion("wordMetaZh not in", values, "wordMetaZh");
            return (Criteria) this;
        }

        public Criteria andWordMetaZhBetween(String value1, String value2) {
            addCriterion("wordMetaZh between", value1, value2, "wordMetaZh");
            return (Criteria) this;
        }

        public Criteria andWordMetaZhNotBetween(String value1, String value2) {
            addCriterion("wordMetaZh not between", value1, value2, "wordMetaZh");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaEnIsNull() {
            addCriterion("simpleWordMetaEn is null");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaEnIsNotNull() {
            addCriterion("simpleWordMetaEn is not null");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaEnEqualTo(String value) {
            addCriterion("simpleWordMetaEn =", value, "simpleWordMetaEn");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaEnNotEqualTo(String value) {
            addCriterion("simpleWordMetaEn <>", value, "simpleWordMetaEn");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaEnGreaterThan(String value) {
            addCriterion("simpleWordMetaEn >", value, "simpleWordMetaEn");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaEnGreaterThanOrEqualTo(String value) {
            addCriterion("simpleWordMetaEn >=", value, "simpleWordMetaEn");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaEnLessThan(String value) {
            addCriterion("simpleWordMetaEn <", value, "simpleWordMetaEn");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaEnLessThanOrEqualTo(String value) {
            addCriterion("simpleWordMetaEn <=", value, "simpleWordMetaEn");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaEnLike(String value) {
            addCriterion("simpleWordMetaEn like", value, "simpleWordMetaEn");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaEnNotLike(String value) {
            addCriterion("simpleWordMetaEn not like", value, "simpleWordMetaEn");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaEnIn(List<String> values) {
            addCriterion("simpleWordMetaEn in", values, "simpleWordMetaEn");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaEnNotIn(List<String> values) {
            addCriterion("simpleWordMetaEn not in", values, "simpleWordMetaEn");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaEnBetween(String value1, String value2) {
            addCriterion("simpleWordMetaEn between", value1, value2, "simpleWordMetaEn");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaEnNotBetween(String value1, String value2) {
            addCriterion("simpleWordMetaEn not between", value1, value2, "simpleWordMetaEn");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaZhIsNull() {
            addCriterion("simpleWordMetaZh is null");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaZhIsNotNull() {
            addCriterion("simpleWordMetaZh is not null");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaZhEqualTo(String value) {
            addCriterion("simpleWordMetaZh =", value, "simpleWordMetaZh");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaZhNotEqualTo(String value) {
            addCriterion("simpleWordMetaZh <>", value, "simpleWordMetaZh");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaZhGreaterThan(String value) {
            addCriterion("simpleWordMetaZh >", value, "simpleWordMetaZh");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaZhGreaterThanOrEqualTo(String value) {
            addCriterion("simpleWordMetaZh >=", value, "simpleWordMetaZh");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaZhLessThan(String value) {
            addCriterion("simpleWordMetaZh <", value, "simpleWordMetaZh");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaZhLessThanOrEqualTo(String value) {
            addCriterion("simpleWordMetaZh <=", value, "simpleWordMetaZh");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaZhLike(String value) {
            addCriterion("simpleWordMetaZh like", value, "simpleWordMetaZh");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaZhNotLike(String value) {
            addCriterion("simpleWordMetaZh not like", value, "simpleWordMetaZh");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaZhIn(List<String> values) {
            addCriterion("simpleWordMetaZh in", values, "simpleWordMetaZh");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaZhNotIn(List<String> values) {
            addCriterion("simpleWordMetaZh not in", values, "simpleWordMetaZh");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaZhBetween(String value1, String value2) {
            addCriterion("simpleWordMetaZh between", value1, value2, "simpleWordMetaZh");
            return (Criteria) this;
        }

        public Criteria andSimpleWordMetaZhNotBetween(String value1, String value2) {
            addCriterion("simpleWordMetaZh not between", value1, value2, "simpleWordMetaZh");
            return (Criteria) this;
        }

        public Criteria andLanguageIdIsNull() {
            addCriterion("languageId is null");
            return (Criteria) this;
        }

        public Criteria andLanguageIdIsNotNull() {
            addCriterion("languageId is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageIdEqualTo(Integer value) {
            addCriterion("languageId =", value, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdNotEqualTo(Integer value) {
            addCriterion("languageId <>", value, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdGreaterThan(Integer value) {
            addCriterion("languageId >", value, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("languageId >=", value, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdLessThan(Integer value) {
            addCriterion("languageId <", value, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdLessThanOrEqualTo(Integer value) {
            addCriterion("languageId <=", value, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdIn(List<Integer> values) {
            addCriterion("languageId in", values, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdNotIn(List<Integer> values) {
            addCriterion("languageId not in", values, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdBetween(Integer value1, Integer value2) {
            addCriterion("languageId between", value1, value2, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("languageId not between", value1, value2, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageTypeCodeIsNull() {
            addCriterion("languageTypeCode is null");
            return (Criteria) this;
        }

        public Criteria andLanguageTypeCodeIsNotNull() {
            addCriterion("languageTypeCode is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageTypeCodeEqualTo(String value) {
            addCriterion("languageTypeCode =", value, "languageTypeCode");
            return (Criteria) this;
        }

        public Criteria andLanguageTypeCodeNotEqualTo(String value) {
            addCriterion("languageTypeCode <>", value, "languageTypeCode");
            return (Criteria) this;
        }

        public Criteria andLanguageTypeCodeGreaterThan(String value) {
            addCriterion("languageTypeCode >", value, "languageTypeCode");
            return (Criteria) this;
        }

        public Criteria andLanguageTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("languageTypeCode >=", value, "languageTypeCode");
            return (Criteria) this;
        }

        public Criteria andLanguageTypeCodeLessThan(String value) {
            addCriterion("languageTypeCode <", value, "languageTypeCode");
            return (Criteria) this;
        }

        public Criteria andLanguageTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("languageTypeCode <=", value, "languageTypeCode");
            return (Criteria) this;
        }

        public Criteria andLanguageTypeCodeLike(String value) {
            addCriterion("languageTypeCode like", value, "languageTypeCode");
            return (Criteria) this;
        }

        public Criteria andLanguageTypeCodeNotLike(String value) {
            addCriterion("languageTypeCode not like", value, "languageTypeCode");
            return (Criteria) this;
        }

        public Criteria andLanguageTypeCodeIn(List<String> values) {
            addCriterion("languageTypeCode in", values, "languageTypeCode");
            return (Criteria) this;
        }

        public Criteria andLanguageTypeCodeNotIn(List<String> values) {
            addCriterion("languageTypeCode not in", values, "languageTypeCode");
            return (Criteria) this;
        }

        public Criteria andLanguageTypeCodeBetween(String value1, String value2) {
            addCriterion("languageTypeCode between", value1, value2, "languageTypeCode");
            return (Criteria) this;
        }

        public Criteria andLanguageTypeCodeNotBetween(String value1, String value2) {
            addCriterion("languageTypeCode not between", value1, value2, "languageTypeCode");
            return (Criteria) this;
        }

        public Criteria andParentWordMetaCodeIdIsNull() {
            addCriterion("parentWordMetaCodeId is null");
            return (Criteria) this;
        }

        public Criteria andParentWordMetaCodeIdIsNotNull() {
            addCriterion("parentWordMetaCodeId is not null");
            return (Criteria) this;
        }

        public Criteria andParentWordMetaCodeIdEqualTo(Integer value) {
            addCriterion("parentWordMetaCodeId =", value, "parentWordMetaCodeId");
            return (Criteria) this;
        }

        public Criteria andParentWordMetaCodeIdNotEqualTo(Integer value) {
            addCriterion("parentWordMetaCodeId <>", value, "parentWordMetaCodeId");
            return (Criteria) this;
        }

        public Criteria andParentWordMetaCodeIdGreaterThan(Integer value) {
            addCriterion("parentWordMetaCodeId >", value, "parentWordMetaCodeId");
            return (Criteria) this;
        }

        public Criteria andParentWordMetaCodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentWordMetaCodeId >=", value, "parentWordMetaCodeId");
            return (Criteria) this;
        }

        public Criteria andParentWordMetaCodeIdLessThan(Integer value) {
            addCriterion("parentWordMetaCodeId <", value, "parentWordMetaCodeId");
            return (Criteria) this;
        }

        public Criteria andParentWordMetaCodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("parentWordMetaCodeId <=", value, "parentWordMetaCodeId");
            return (Criteria) this;
        }

        public Criteria andParentWordMetaCodeIdIn(List<Integer> values) {
            addCriterion("parentWordMetaCodeId in", values, "parentWordMetaCodeId");
            return (Criteria) this;
        }

        public Criteria andParentWordMetaCodeIdNotIn(List<Integer> values) {
            addCriterion("parentWordMetaCodeId not in", values, "parentWordMetaCodeId");
            return (Criteria) this;
        }

        public Criteria andParentWordMetaCodeIdBetween(Integer value1, Integer value2) {
            addCriterion("parentWordMetaCodeId between", value1, value2, "parentWordMetaCodeId");
            return (Criteria) this;
        }

        public Criteria andParentWordMetaCodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parentWordMetaCodeId not between", value1, value2, "parentWordMetaCodeId");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Short value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Short value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Short value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Short value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Short value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Short value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Short> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Short> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Short value1, Short value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Short value1, Short value2) {
            addCriterion("level not between", value1, value2, "level");
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

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated do_not_delete_during_merge Thu Oct 03 16:22:15 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sjz_nl_word_meta
     *
     * @mbggenerated Thu Oct 03 16:22:15 CST 2019
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
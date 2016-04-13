package com.ai.paas.ipaas.user.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrderDetailCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

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

        public Criteria andOrderDetailIdIsNull() {
            addCriterion("ORDER_DETAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdIsNotNull() {
            addCriterion("ORDER_DETAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdEqualTo(Long value) {
            addCriterion("ORDER_DETAIL_ID =", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdNotEqualTo(Long value) {
            addCriterion("ORDER_DETAIL_ID <>", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdGreaterThan(Long value) {
            addCriterion("ORDER_DETAIL_ID >", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ORDER_DETAIL_ID >=", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdLessThan(Long value) {
            addCriterion("ORDER_DETAIL_ID <", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdLessThanOrEqualTo(Long value) {
            addCriterion("ORDER_DETAIL_ID <=", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdIn(List<Long> values) {
            addCriterion("ORDER_DETAIL_ID in", values, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdNotIn(List<Long> values) {
            addCriterion("ORDER_DETAIL_ID not in", values, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdBetween(Long value1, Long value2) {
            addCriterion("ORDER_DETAIL_ID between", value1, value2, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdNotBetween(Long value1, Long value2) {
            addCriterion("ORDER_DETAIL_ID not between", value1, value2, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIsNull() {
            addCriterion("OPERATE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIsNotNull() {
            addCriterion("OPERATE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOperateTypeEqualTo(String value) {
            addCriterion("OPERATE_TYPE =", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotEqualTo(String value) {
            addCriterion("OPERATE_TYPE <>", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeGreaterThan(String value) {
            addCriterion("OPERATE_TYPE >", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATE_TYPE >=", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLessThan(String value) {
            addCriterion("OPERATE_TYPE <", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLessThanOrEqualTo(String value) {
            addCriterion("OPERATE_TYPE <=", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLike(String value) {
            addCriterion("OPERATE_TYPE like", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotLike(String value) {
            addCriterion("OPERATE_TYPE not like", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIn(List<String> values) {
            addCriterion("OPERATE_TYPE in", values, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotIn(List<String> values) {
            addCriterion("OPERATE_TYPE not in", values, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeBetween(String value1, String value2) {
            addCriterion("OPERATE_TYPE between", value1, value2, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotBetween(String value1, String value2) {
            addCriterion("OPERATE_TYPE not between", value1, value2, "operateType");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andProdTypeIsNull() {
            addCriterion("PROD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andProdTypeIsNotNull() {
            addCriterion("PROD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andProdTypeEqualTo(String value) {
            addCriterion("PROD_TYPE =", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeNotEqualTo(String value) {
            addCriterion("PROD_TYPE <>", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeGreaterThan(String value) {
            addCriterion("PROD_TYPE >", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_TYPE >=", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeLessThan(String value) {
            addCriterion("PROD_TYPE <", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeLessThanOrEqualTo(String value) {
            addCriterion("PROD_TYPE <=", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeLike(String value) {
            addCriterion("PROD_TYPE like", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeNotLike(String value) {
            addCriterion("PROD_TYPE not like", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeIn(List<String> values) {
            addCriterion("PROD_TYPE in", values, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeNotIn(List<String> values) {
            addCriterion("PROD_TYPE not in", values, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeBetween(String value1, String value2) {
            addCriterion("PROD_TYPE between", value1, value2, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeNotBetween(String value1, String value2) {
            addCriterion("PROD_TYPE not between", value1, value2, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNull() {
            addCriterion("PROD_ID is null");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNotNull() {
            addCriterion("PROD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProdIdEqualTo(String value) {
            addCriterion("PROD_ID =", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotEqualTo(String value) {
            addCriterion("PROD_ID <>", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThan(String value) {
            addCriterion("PROD_ID >", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_ID >=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThan(String value) {
            addCriterion("PROD_ID <", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThanOrEqualTo(String value) {
            addCriterion("PROD_ID <=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLike(String value) {
            addCriterion("PROD_ID like", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotLike(String value) {
            addCriterion("PROD_ID not like", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdIn(List<String> values) {
            addCriterion("PROD_ID in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotIn(List<String> values) {
            addCriterion("PROD_ID not in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdBetween(String value1, String value2) {
            addCriterion("PROD_ID between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotBetween(String value1, String value2) {
            addCriterion("PROD_ID not between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdBynameIsNull() {
            addCriterion("PROD_BYNAME is null");
            return (Criteria) this;
        }

        public Criteria andProdBynameIsNotNull() {
            addCriterion("PROD_BYNAME is not null");
            return (Criteria) this;
        }

        public Criteria andProdBynameEqualTo(String value) {
            addCriterion("PROD_BYNAME =", value, "prodByname");
            return (Criteria) this;
        }

        public Criteria andProdBynameNotEqualTo(String value) {
            addCriterion("PROD_BYNAME <>", value, "prodByname");
            return (Criteria) this;
        }

        public Criteria andProdBynameGreaterThan(String value) {
            addCriterion("PROD_BYNAME >", value, "prodByname");
            return (Criteria) this;
        }

        public Criteria andProdBynameGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_BYNAME >=", value, "prodByname");
            return (Criteria) this;
        }

        public Criteria andProdBynameLessThan(String value) {
            addCriterion("PROD_BYNAME <", value, "prodByname");
            return (Criteria) this;
        }

        public Criteria andProdBynameLessThanOrEqualTo(String value) {
            addCriterion("PROD_BYNAME <=", value, "prodByname");
            return (Criteria) this;
        }

        public Criteria andProdBynameLike(String value) {
            addCriterion("PROD_BYNAME like", value, "prodByname");
            return (Criteria) this;
        }

        public Criteria andProdBynameNotLike(String value) {
            addCriterion("PROD_BYNAME not like", value, "prodByname");
            return (Criteria) this;
        }

        public Criteria andProdBynameIn(List<String> values) {
            addCriterion("PROD_BYNAME in", values, "prodByname");
            return (Criteria) this;
        }

        public Criteria andProdBynameNotIn(List<String> values) {
            addCriterion("PROD_BYNAME not in", values, "prodByname");
            return (Criteria) this;
        }

        public Criteria andProdBynameBetween(String value1, String value2) {
            addCriterion("PROD_BYNAME between", value1, value2, "prodByname");
            return (Criteria) this;
        }

        public Criteria andProdBynameNotBetween(String value1, String value2) {
            addCriterion("PROD_BYNAME not between", value1, value2, "prodByname");
            return (Criteria) this;
        }

        public Criteria andProdParamZhIsNull() {
            addCriterion("PROD_PARAM_ZH is null");
            return (Criteria) this;
        }

        public Criteria andProdParamZhIsNotNull() {
            addCriterion("PROD_PARAM_ZH is not null");
            return (Criteria) this;
        }

        public Criteria andProdParamZhEqualTo(String value) {
            addCriterion("PROD_PARAM_ZH =", value, "prodParamZh");
            return (Criteria) this;
        }

        public Criteria andProdParamZhNotEqualTo(String value) {
            addCriterion("PROD_PARAM_ZH <>", value, "prodParamZh");
            return (Criteria) this;
        }

        public Criteria andProdParamZhGreaterThan(String value) {
            addCriterion("PROD_PARAM_ZH >", value, "prodParamZh");
            return (Criteria) this;
        }

        public Criteria andProdParamZhGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_PARAM_ZH >=", value, "prodParamZh");
            return (Criteria) this;
        }

        public Criteria andProdParamZhLessThan(String value) {
            addCriterion("PROD_PARAM_ZH <", value, "prodParamZh");
            return (Criteria) this;
        }

        public Criteria andProdParamZhLessThanOrEqualTo(String value) {
            addCriterion("PROD_PARAM_ZH <=", value, "prodParamZh");
            return (Criteria) this;
        }

        public Criteria andProdParamZhLike(String value) {
            addCriterion("PROD_PARAM_ZH like", value, "prodParamZh");
            return (Criteria) this;
        }

        public Criteria andProdParamZhNotLike(String value) {
            addCriterion("PROD_PARAM_ZH not like", value, "prodParamZh");
            return (Criteria) this;
        }

        public Criteria andProdParamZhIn(List<String> values) {
            addCriterion("PROD_PARAM_ZH in", values, "prodParamZh");
            return (Criteria) this;
        }

        public Criteria andProdParamZhNotIn(List<String> values) {
            addCriterion("PROD_PARAM_ZH not in", values, "prodParamZh");
            return (Criteria) this;
        }

        public Criteria andProdParamZhBetween(String value1, String value2) {
            addCriterion("PROD_PARAM_ZH between", value1, value2, "prodParamZh");
            return (Criteria) this;
        }

        public Criteria andProdParamZhNotBetween(String value1, String value2) {
            addCriterion("PROD_PARAM_ZH not between", value1, value2, "prodParamZh");
            return (Criteria) this;
        }

        public Criteria andVmNumberIsNull() {
            addCriterion("vm_number is null");
            return (Criteria) this;
        }

        public Criteria andVmNumberIsNotNull() {
            addCriterion("vm_number is not null");
            return (Criteria) this;
        }

        public Criteria andVmNumberEqualTo(Short value) {
            addCriterion("vm_number =", value, "vmNumber");
            return (Criteria) this;
        }

        public Criteria andVmNumberNotEqualTo(Short value) {
            addCriterion("vm_number <>", value, "vmNumber");
            return (Criteria) this;
        }

        public Criteria andVmNumberGreaterThan(Short value) {
            addCriterion("vm_number >", value, "vmNumber");
            return (Criteria) this;
        }

        public Criteria andVmNumberGreaterThanOrEqualTo(Short value) {
            addCriterion("vm_number >=", value, "vmNumber");
            return (Criteria) this;
        }

        public Criteria andVmNumberLessThan(Short value) {
            addCriterion("vm_number <", value, "vmNumber");
            return (Criteria) this;
        }

        public Criteria andVmNumberLessThanOrEqualTo(Short value) {
            addCriterion("vm_number <=", value, "vmNumber");
            return (Criteria) this;
        }

        public Criteria andVmNumberIn(List<Short> values) {
            addCriterion("vm_number in", values, "vmNumber");
            return (Criteria) this;
        }

        public Criteria andVmNumberNotIn(List<Short> values) {
            addCriterion("vm_number not in", values, "vmNumber");
            return (Criteria) this;
        }

        public Criteria andVmNumberBetween(Short value1, Short value2) {
            addCriterion("vm_number between", value1, value2, "vmNumber");
            return (Criteria) this;
        }

        public Criteria andVmNumberNotBetween(Short value1, Short value2) {
            addCriterion("vm_number not between", value1, value2, "vmNumber");
            return (Criteria) this;
        }

        public Criteria andOrderAppDateIsNull() {
            addCriterion("ORDER_APP_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOrderAppDateIsNotNull() {
            addCriterion("ORDER_APP_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAppDateEqualTo(Timestamp value) {
            addCriterion("ORDER_APP_DATE =", value, "orderAppDate");
            return (Criteria) this;
        }

        public Criteria andOrderAppDateNotEqualTo(Timestamp value) {
            addCriterion("ORDER_APP_DATE <>", value, "orderAppDate");
            return (Criteria) this;
        }

        public Criteria andOrderAppDateGreaterThan(Timestamp value) {
            addCriterion("ORDER_APP_DATE >", value, "orderAppDate");
            return (Criteria) this;
        }

        public Criteria andOrderAppDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("ORDER_APP_DATE >=", value, "orderAppDate");
            return (Criteria) this;
        }

        public Criteria andOrderAppDateLessThan(Timestamp value) {
            addCriterion("ORDER_APP_DATE <", value, "orderAppDate");
            return (Criteria) this;
        }

        public Criteria andOrderAppDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("ORDER_APP_DATE <=", value, "orderAppDate");
            return (Criteria) this;
        }

        public Criteria andOrderAppDateIn(List<Timestamp> values) {
            addCriterion("ORDER_APP_DATE in", values, "orderAppDate");
            return (Criteria) this;
        }

        public Criteria andOrderAppDateNotIn(List<Timestamp> values) {
            addCriterion("ORDER_APP_DATE not in", values, "orderAppDate");
            return (Criteria) this;
        }

        public Criteria andOrderAppDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ORDER_APP_DATE between", value1, value2, "orderAppDate");
            return (Criteria) this;
        }

        public Criteria andOrderAppDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ORDER_APP_DATE not between", value1, value2, "orderAppDate");
            return (Criteria) this;
        }

        public Criteria andPreOpenDateIsNull() {
            addCriterion("PRE_OPEN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPreOpenDateIsNotNull() {
            addCriterion("PRE_OPEN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPreOpenDateEqualTo(Timestamp value) {
            addCriterion("PRE_OPEN_DATE =", value, "preOpenDate");
            return (Criteria) this;
        }

        public Criteria andPreOpenDateNotEqualTo(Timestamp value) {
            addCriterion("PRE_OPEN_DATE <>", value, "preOpenDate");
            return (Criteria) this;
        }

        public Criteria andPreOpenDateGreaterThan(Timestamp value) {
            addCriterion("PRE_OPEN_DATE >", value, "preOpenDate");
            return (Criteria) this;
        }

        public Criteria andPreOpenDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("PRE_OPEN_DATE >=", value, "preOpenDate");
            return (Criteria) this;
        }

        public Criteria andPreOpenDateLessThan(Timestamp value) {
            addCriterion("PRE_OPEN_DATE <", value, "preOpenDate");
            return (Criteria) this;
        }

        public Criteria andPreOpenDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("PRE_OPEN_DATE <=", value, "preOpenDate");
            return (Criteria) this;
        }

        public Criteria andPreOpenDateIn(List<Timestamp> values) {
            addCriterion("PRE_OPEN_DATE in", values, "preOpenDate");
            return (Criteria) this;
        }

        public Criteria andPreOpenDateNotIn(List<Timestamp> values) {
            addCriterion("PRE_OPEN_DATE not in", values, "preOpenDate");
            return (Criteria) this;
        }

        public Criteria andPreOpenDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("PRE_OPEN_DATE between", value1, value2, "preOpenDate");
            return (Criteria) this;
        }

        public Criteria andPreOpenDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("PRE_OPEN_DATE not between", value1, value2, "preOpenDate");
            return (Criteria) this;
        }

        public Criteria andOpenStatusIsNull() {
            addCriterion("OPEN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andOpenStatusIsNotNull() {
            addCriterion("OPEN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andOpenStatusEqualTo(String value) {
            addCriterion("OPEN_STATUS =", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusNotEqualTo(String value) {
            addCriterion("OPEN_STATUS <>", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusGreaterThan(String value) {
            addCriterion("OPEN_STATUS >", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusGreaterThanOrEqualTo(String value) {
            addCriterion("OPEN_STATUS >=", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusLessThan(String value) {
            addCriterion("OPEN_STATUS <", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusLessThanOrEqualTo(String value) {
            addCriterion("OPEN_STATUS <=", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusLike(String value) {
            addCriterion("OPEN_STATUS like", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusNotLike(String value) {
            addCriterion("OPEN_STATUS not like", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusIn(List<String> values) {
            addCriterion("OPEN_STATUS in", values, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusNotIn(List<String> values) {
            addCriterion("OPEN_STATUS not in", values, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusBetween(String value1, String value2) {
            addCriterion("OPEN_STATUS between", value1, value2, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusNotBetween(String value1, String value2) {
            addCriterion("OPEN_STATUS not between", value1, value2, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenParamIsNull() {
            addCriterion("OPEN_PARAM is null");
            return (Criteria) this;
        }

        public Criteria andOpenParamIsNotNull() {
            addCriterion("OPEN_PARAM is not null");
            return (Criteria) this;
        }

        public Criteria andOpenParamEqualTo(String value) {
            addCriterion("OPEN_PARAM =", value, "openParam");
            return (Criteria) this;
        }

        public Criteria andOpenParamNotEqualTo(String value) {
            addCriterion("OPEN_PARAM <>", value, "openParam");
            return (Criteria) this;
        }

        public Criteria andOpenParamGreaterThan(String value) {
            addCriterion("OPEN_PARAM >", value, "openParam");
            return (Criteria) this;
        }

        public Criteria andOpenParamGreaterThanOrEqualTo(String value) {
            addCriterion("OPEN_PARAM >=", value, "openParam");
            return (Criteria) this;
        }

        public Criteria andOpenParamLessThan(String value) {
            addCriterion("OPEN_PARAM <", value, "openParam");
            return (Criteria) this;
        }

        public Criteria andOpenParamLessThanOrEqualTo(String value) {
            addCriterion("OPEN_PARAM <=", value, "openParam");
            return (Criteria) this;
        }

        public Criteria andOpenParamLike(String value) {
            addCriterion("OPEN_PARAM like", value, "openParam");
            return (Criteria) this;
        }

        public Criteria andOpenParamNotLike(String value) {
            addCriterion("OPEN_PARAM not like", value, "openParam");
            return (Criteria) this;
        }

        public Criteria andOpenParamIn(List<String> values) {
            addCriterion("OPEN_PARAM in", values, "openParam");
            return (Criteria) this;
        }

        public Criteria andOpenParamNotIn(List<String> values) {
            addCriterion("OPEN_PARAM not in", values, "openParam");
            return (Criteria) this;
        }

        public Criteria andOpenParamBetween(String value1, String value2) {
            addCriterion("OPEN_PARAM between", value1, value2, "openParam");
            return (Criteria) this;
        }

        public Criteria andOpenParamNotBetween(String value1, String value2) {
            addCriterion("OPEN_PARAM not between", value1, value2, "openParam");
            return (Criteria) this;
        }

        public Criteria andOpenResultIsNull() {
            addCriterion("OPEN_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andOpenResultIsNotNull() {
            addCriterion("OPEN_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andOpenResultEqualTo(String value) {
            addCriterion("OPEN_RESULT =", value, "openResult");
            return (Criteria) this;
        }

        public Criteria andOpenResultNotEqualTo(String value) {
            addCriterion("OPEN_RESULT <>", value, "openResult");
            return (Criteria) this;
        }

        public Criteria andOpenResultGreaterThan(String value) {
            addCriterion("OPEN_RESULT >", value, "openResult");
            return (Criteria) this;
        }

        public Criteria andOpenResultGreaterThanOrEqualTo(String value) {
            addCriterion("OPEN_RESULT >=", value, "openResult");
            return (Criteria) this;
        }

        public Criteria andOpenResultLessThan(String value) {
            addCriterion("OPEN_RESULT <", value, "openResult");
            return (Criteria) this;
        }

        public Criteria andOpenResultLessThanOrEqualTo(String value) {
            addCriterion("OPEN_RESULT <=", value, "openResult");
            return (Criteria) this;
        }

        public Criteria andOpenResultLike(String value) {
            addCriterion("OPEN_RESULT like", value, "openResult");
            return (Criteria) this;
        }

        public Criteria andOpenResultNotLike(String value) {
            addCriterion("OPEN_RESULT not like", value, "openResult");
            return (Criteria) this;
        }

        public Criteria andOpenResultIn(List<String> values) {
            addCriterion("OPEN_RESULT in", values, "openResult");
            return (Criteria) this;
        }

        public Criteria andOpenResultNotIn(List<String> values) {
            addCriterion("OPEN_RESULT not in", values, "openResult");
            return (Criteria) this;
        }

        public Criteria andOpenResultBetween(String value1, String value2) {
            addCriterion("OPEN_RESULT between", value1, value2, "openResult");
            return (Criteria) this;
        }

        public Criteria andOpenResultNotBetween(String value1, String value2) {
            addCriterion("OPEN_RESULT not between", value1, value2, "openResult");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNull() {
            addCriterion("OPEN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNotNull() {
            addCriterion("OPEN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOpenDateEqualTo(Timestamp value) {
            addCriterion("OPEN_DATE =", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotEqualTo(Timestamp value) {
            addCriterion("OPEN_DATE <>", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThan(Timestamp value) {
            addCriterion("OPEN_DATE >", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("OPEN_DATE >=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThan(Timestamp value) {
            addCriterion("OPEN_DATE <", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("OPEN_DATE <=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateIn(List<Timestamp> values) {
            addCriterion("OPEN_DATE in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotIn(List<Timestamp> values) {
            addCriterion("OPEN_DATE not in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("OPEN_DATE between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("OPEN_DATE not between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andOrderCheckStatusIsNull() {
            addCriterion("ORDER_CHECK_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andOrderCheckStatusIsNotNull() {
            addCriterion("ORDER_CHECK_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCheckStatusEqualTo(String value) {
            addCriterion("ORDER_CHECK_STATUS =", value, "orderCheckStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCheckStatusNotEqualTo(String value) {
            addCriterion("ORDER_CHECK_STATUS <>", value, "orderCheckStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCheckStatusGreaterThan(String value) {
            addCriterion("ORDER_CHECK_STATUS >", value, "orderCheckStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCheckStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_CHECK_STATUS >=", value, "orderCheckStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCheckStatusLessThan(String value) {
            addCriterion("ORDER_CHECK_STATUS <", value, "orderCheckStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCheckStatusLessThanOrEqualTo(String value) {
            addCriterion("ORDER_CHECK_STATUS <=", value, "orderCheckStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCheckStatusLike(String value) {
            addCriterion("ORDER_CHECK_STATUS like", value, "orderCheckStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCheckStatusNotLike(String value) {
            addCriterion("ORDER_CHECK_STATUS not like", value, "orderCheckStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCheckStatusIn(List<String> values) {
            addCriterion("ORDER_CHECK_STATUS in", values, "orderCheckStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCheckStatusNotIn(List<String> values) {
            addCriterion("ORDER_CHECK_STATUS not in", values, "orderCheckStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCheckStatusBetween(String value1, String value2) {
            addCriterion("ORDER_CHECK_STATUS between", value1, value2, "orderCheckStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCheckStatusNotBetween(String value1, String value2) {
            addCriterion("ORDER_CHECK_STATUS not between", value1, value2, "orderCheckStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCheckResultIsNull() {
            addCriterion("ORDER_CHECK_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andOrderCheckResultIsNotNull() {
            addCriterion("ORDER_CHECK_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCheckResultEqualTo(String value) {
            addCriterion("ORDER_CHECK_RESULT =", value, "orderCheckResult");
            return (Criteria) this;
        }

        public Criteria andOrderCheckResultNotEqualTo(String value) {
            addCriterion("ORDER_CHECK_RESULT <>", value, "orderCheckResult");
            return (Criteria) this;
        }

        public Criteria andOrderCheckResultGreaterThan(String value) {
            addCriterion("ORDER_CHECK_RESULT >", value, "orderCheckResult");
            return (Criteria) this;
        }

        public Criteria andOrderCheckResultGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_CHECK_RESULT >=", value, "orderCheckResult");
            return (Criteria) this;
        }

        public Criteria andOrderCheckResultLessThan(String value) {
            addCriterion("ORDER_CHECK_RESULT <", value, "orderCheckResult");
            return (Criteria) this;
        }

        public Criteria andOrderCheckResultLessThanOrEqualTo(String value) {
            addCriterion("ORDER_CHECK_RESULT <=", value, "orderCheckResult");
            return (Criteria) this;
        }

        public Criteria andOrderCheckResultLike(String value) {
            addCriterion("ORDER_CHECK_RESULT like", value, "orderCheckResult");
            return (Criteria) this;
        }

        public Criteria andOrderCheckResultNotLike(String value) {
            addCriterion("ORDER_CHECK_RESULT not like", value, "orderCheckResult");
            return (Criteria) this;
        }

        public Criteria andOrderCheckResultIn(List<String> values) {
            addCriterion("ORDER_CHECK_RESULT in", values, "orderCheckResult");
            return (Criteria) this;
        }

        public Criteria andOrderCheckResultNotIn(List<String> values) {
            addCriterion("ORDER_CHECK_RESULT not in", values, "orderCheckResult");
            return (Criteria) this;
        }

        public Criteria andOrderCheckResultBetween(String value1, String value2) {
            addCriterion("ORDER_CHECK_RESULT between", value1, value2, "orderCheckResult");
            return (Criteria) this;
        }

        public Criteria andOrderCheckResultNotBetween(String value1, String value2) {
            addCriterion("ORDER_CHECK_RESULT not between", value1, value2, "orderCheckResult");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDateIsNull() {
            addCriterion("ORDER_CHECK_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDateIsNotNull() {
            addCriterion("ORDER_CHECK_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDateEqualTo(Timestamp value) {
            addCriterion("ORDER_CHECK_DATE =", value, "orderCheckDate");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDateNotEqualTo(Timestamp value) {
            addCriterion("ORDER_CHECK_DATE <>", value, "orderCheckDate");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDateGreaterThan(Timestamp value) {
            addCriterion("ORDER_CHECK_DATE >", value, "orderCheckDate");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("ORDER_CHECK_DATE >=", value, "orderCheckDate");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDateLessThan(Timestamp value) {
            addCriterion("ORDER_CHECK_DATE <", value, "orderCheckDate");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("ORDER_CHECK_DATE <=", value, "orderCheckDate");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDateIn(List<Timestamp> values) {
            addCriterion("ORDER_CHECK_DATE in", values, "orderCheckDate");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDateNotIn(List<Timestamp> values) {
            addCriterion("ORDER_CHECK_DATE not in", values, "orderCheckDate");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ORDER_CHECK_DATE between", value1, value2, "orderCheckDate");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ORDER_CHECK_DATE not between", value1, value2, "orderCheckDate");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDescIsNull() {
            addCriterion("ORDER_CHECK_DESC is null");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDescIsNotNull() {
            addCriterion("ORDER_CHECK_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDescEqualTo(String value) {
            addCriterion("ORDER_CHECK_DESC =", value, "orderCheckDesc");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDescNotEqualTo(String value) {
            addCriterion("ORDER_CHECK_DESC <>", value, "orderCheckDesc");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDescGreaterThan(String value) {
            addCriterion("ORDER_CHECK_DESC >", value, "orderCheckDesc");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDescGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_CHECK_DESC >=", value, "orderCheckDesc");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDescLessThan(String value) {
            addCriterion("ORDER_CHECK_DESC <", value, "orderCheckDesc");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDescLessThanOrEqualTo(String value) {
            addCriterion("ORDER_CHECK_DESC <=", value, "orderCheckDesc");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDescLike(String value) {
            addCriterion("ORDER_CHECK_DESC like", value, "orderCheckDesc");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDescNotLike(String value) {
            addCriterion("ORDER_CHECK_DESC not like", value, "orderCheckDesc");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDescIn(List<String> values) {
            addCriterion("ORDER_CHECK_DESC in", values, "orderCheckDesc");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDescNotIn(List<String> values) {
            addCriterion("ORDER_CHECK_DESC not in", values, "orderCheckDesc");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDescBetween(String value1, String value2) {
            addCriterion("ORDER_CHECK_DESC between", value1, value2, "orderCheckDesc");
            return (Criteria) this;
        }

        public Criteria andOrderCheckDescNotBetween(String value1, String value2) {
            addCriterion("ORDER_CHECK_DESC not between", value1, value2, "orderCheckDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("ORDER_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("ORDER_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("ORDER_STATUS =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("ORDER_STATUS <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("ORDER_STATUS >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_STATUS >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("ORDER_STATUS <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("ORDER_STATUS <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("ORDER_STATUS like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("ORDER_STATUS not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("ORDER_STATUS in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("ORDER_STATUS not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("ORDER_STATUS between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("ORDER_STATUS not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andUserServIdIsNull() {
            addCriterion("USER_SERV_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserServIdIsNotNull() {
            addCriterion("USER_SERV_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserServIdEqualTo(String value) {
            addCriterion("USER_SERV_ID =", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdNotEqualTo(String value) {
            addCriterion("USER_SERV_ID <>", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdGreaterThan(String value) {
            addCriterion("USER_SERV_ID >", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_SERV_ID >=", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdLessThan(String value) {
            addCriterion("USER_SERV_ID <", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdLessThanOrEqualTo(String value) {
            addCriterion("USER_SERV_ID <=", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdLike(String value) {
            addCriterion("USER_SERV_ID like", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdNotLike(String value) {
            addCriterion("USER_SERV_ID not like", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdIn(List<String> values) {
            addCriterion("USER_SERV_ID in", values, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdNotIn(List<String> values) {
            addCriterion("USER_SERV_ID not in", values, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdBetween(String value1, String value2) {
            addCriterion("USER_SERV_ID between", value1, value2, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdNotBetween(String value1, String value2) {
            addCriterion("USER_SERV_ID not between", value1, value2, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdIsNull() {
            addCriterion("USER_SERV_IPAAS_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdIsNotNull() {
            addCriterion("USER_SERV_IPAAS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdEqualTo(String value) {
            addCriterion("USER_SERV_IPAAS_ID =", value, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdNotEqualTo(String value) {
            addCriterion("USER_SERV_IPAAS_ID <>", value, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdGreaterThan(String value) {
            addCriterion("USER_SERV_IPAAS_ID >", value, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_SERV_IPAAS_ID >=", value, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdLessThan(String value) {
            addCriterion("USER_SERV_IPAAS_ID <", value, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdLessThanOrEqualTo(String value) {
            addCriterion("USER_SERV_IPAAS_ID <=", value, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdLike(String value) {
            addCriterion("USER_SERV_IPAAS_ID like", value, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdNotLike(String value) {
            addCriterion("USER_SERV_IPAAS_ID not like", value, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdIn(List<String> values) {
            addCriterion("USER_SERV_IPAAS_ID in", values, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdNotIn(List<String> values) {
            addCriterion("USER_SERV_IPAAS_ID not in", values, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdBetween(String value1, String value2) {
            addCriterion("USER_SERV_IPAAS_ID between", value1, value2, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdNotBetween(String value1, String value2) {
            addCriterion("USER_SERV_IPAAS_ID not between", value1, value2, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasPwdIsNull() {
            addCriterion("USER_SERV_IPAAS_PWD is null");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasPwdIsNotNull() {
            addCriterion("USER_SERV_IPAAS_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasPwdEqualTo(String value) {
            addCriterion("USER_SERV_IPAAS_PWD =", value, "userServIpaasPwd");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasPwdNotEqualTo(String value) {
            addCriterion("USER_SERV_IPAAS_PWD <>", value, "userServIpaasPwd");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasPwdGreaterThan(String value) {
            addCriterion("USER_SERV_IPAAS_PWD >", value, "userServIpaasPwd");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasPwdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_SERV_IPAAS_PWD >=", value, "userServIpaasPwd");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasPwdLessThan(String value) {
            addCriterion("USER_SERV_IPAAS_PWD <", value, "userServIpaasPwd");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasPwdLessThanOrEqualTo(String value) {
            addCriterion("USER_SERV_IPAAS_PWD <=", value, "userServIpaasPwd");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasPwdLike(String value) {
            addCriterion("USER_SERV_IPAAS_PWD like", value, "userServIpaasPwd");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasPwdNotLike(String value) {
            addCriterion("USER_SERV_IPAAS_PWD not like", value, "userServIpaasPwd");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasPwdIn(List<String> values) {
            addCriterion("USER_SERV_IPAAS_PWD in", values, "userServIpaasPwd");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasPwdNotIn(List<String> values) {
            addCriterion("USER_SERV_IPAAS_PWD not in", values, "userServIpaasPwd");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasPwdBetween(String value1, String value2) {
            addCriterion("USER_SERV_IPAAS_PWD between", value1, value2, "userServIpaasPwd");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasPwdNotBetween(String value1, String value2) {
            addCriterion("USER_SERV_IPAAS_PWD not between", value1, value2, "userServIpaasPwd");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNull() {
            addCriterion("APPLICANT is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNotNull() {
            addCriterion("APPLICANT is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantEqualTo(String value) {
            addCriterion("APPLICANT =", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotEqualTo(String value) {
            addCriterion("APPLICANT <>", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThan(String value) {
            addCriterion("APPLICANT >", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThanOrEqualTo(String value) {
            addCriterion("APPLICANT >=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThan(String value) {
            addCriterion("APPLICANT <", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThanOrEqualTo(String value) {
            addCriterion("APPLICANT <=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLike(String value) {
            addCriterion("APPLICANT like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotLike(String value) {
            addCriterion("APPLICANT not like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantIn(List<String> values) {
            addCriterion("APPLICANT in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotIn(List<String> values) {
            addCriterion("APPLICANT not in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantBetween(String value1, String value2) {
            addCriterion("APPLICANT between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotBetween(String value1, String value2) {
            addCriterion("APPLICANT not between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantDeptIsNull() {
            addCriterion("APPLICANT_DEPT is null");
            return (Criteria) this;
        }

        public Criteria andApplicantDeptIsNotNull() {
            addCriterion("APPLICANT_DEPT is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantDeptEqualTo(String value) {
            addCriterion("APPLICANT_DEPT =", value, "applicantDept");
            return (Criteria) this;
        }

        public Criteria andApplicantDeptNotEqualTo(String value) {
            addCriterion("APPLICANT_DEPT <>", value, "applicantDept");
            return (Criteria) this;
        }

        public Criteria andApplicantDeptGreaterThan(String value) {
            addCriterion("APPLICANT_DEPT >", value, "applicantDept");
            return (Criteria) this;
        }

        public Criteria andApplicantDeptGreaterThanOrEqualTo(String value) {
            addCriterion("APPLICANT_DEPT >=", value, "applicantDept");
            return (Criteria) this;
        }

        public Criteria andApplicantDeptLessThan(String value) {
            addCriterion("APPLICANT_DEPT <", value, "applicantDept");
            return (Criteria) this;
        }

        public Criteria andApplicantDeptLessThanOrEqualTo(String value) {
            addCriterion("APPLICANT_DEPT <=", value, "applicantDept");
            return (Criteria) this;
        }

        public Criteria andApplicantDeptLike(String value) {
            addCriterion("APPLICANT_DEPT like", value, "applicantDept");
            return (Criteria) this;
        }

        public Criteria andApplicantDeptNotLike(String value) {
            addCriterion("APPLICANT_DEPT not like", value, "applicantDept");
            return (Criteria) this;
        }

        public Criteria andApplicantDeptIn(List<String> values) {
            addCriterion("APPLICANT_DEPT in", values, "applicantDept");
            return (Criteria) this;
        }

        public Criteria andApplicantDeptNotIn(List<String> values) {
            addCriterion("APPLICANT_DEPT not in", values, "applicantDept");
            return (Criteria) this;
        }

        public Criteria andApplicantDeptBetween(String value1, String value2) {
            addCriterion("APPLICANT_DEPT between", value1, value2, "applicantDept");
            return (Criteria) this;
        }

        public Criteria andApplicantDeptNotBetween(String value1, String value2) {
            addCriterion("APPLICANT_DEPT not between", value1, value2, "applicantDept");
            return (Criteria) this;
        }

        public Criteria andApplicantTelIsNull() {
            addCriterion("APPLICANT_TEL is null");
            return (Criteria) this;
        }

        public Criteria andApplicantTelIsNotNull() {
            addCriterion("APPLICANT_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantTelEqualTo(String value) {
            addCriterion("APPLICANT_TEL =", value, "applicantTel");
            return (Criteria) this;
        }

        public Criteria andApplicantTelNotEqualTo(String value) {
            addCriterion("APPLICANT_TEL <>", value, "applicantTel");
            return (Criteria) this;
        }

        public Criteria andApplicantTelGreaterThan(String value) {
            addCriterion("APPLICANT_TEL >", value, "applicantTel");
            return (Criteria) this;
        }

        public Criteria andApplicantTelGreaterThanOrEqualTo(String value) {
            addCriterion("APPLICANT_TEL >=", value, "applicantTel");
            return (Criteria) this;
        }

        public Criteria andApplicantTelLessThan(String value) {
            addCriterion("APPLICANT_TEL <", value, "applicantTel");
            return (Criteria) this;
        }

        public Criteria andApplicantTelLessThanOrEqualTo(String value) {
            addCriterion("APPLICANT_TEL <=", value, "applicantTel");
            return (Criteria) this;
        }

        public Criteria andApplicantTelLike(String value) {
            addCriterion("APPLICANT_TEL like", value, "applicantTel");
            return (Criteria) this;
        }

        public Criteria andApplicantTelNotLike(String value) {
            addCriterion("APPLICANT_TEL not like", value, "applicantTel");
            return (Criteria) this;
        }

        public Criteria andApplicantTelIn(List<String> values) {
            addCriterion("APPLICANT_TEL in", values, "applicantTel");
            return (Criteria) this;
        }

        public Criteria andApplicantTelNotIn(List<String> values) {
            addCriterion("APPLICANT_TEL not in", values, "applicantTel");
            return (Criteria) this;
        }

        public Criteria andApplicantTelBetween(String value1, String value2) {
            addCriterion("APPLICANT_TEL between", value1, value2, "applicantTel");
            return (Criteria) this;
        }

        public Criteria andApplicantTelNotBetween(String value1, String value2) {
            addCriterion("APPLICANT_TEL not between", value1, value2, "applicantTel");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailIsNull() {
            addCriterion("APPLICANT_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailIsNotNull() {
            addCriterion("APPLICANT_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailEqualTo(String value) {
            addCriterion("APPLICANT_EMAIL =", value, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailNotEqualTo(String value) {
            addCriterion("APPLICANT_EMAIL <>", value, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailGreaterThan(String value) {
            addCriterion("APPLICANT_EMAIL >", value, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailGreaterThanOrEqualTo(String value) {
            addCriterion("APPLICANT_EMAIL >=", value, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailLessThan(String value) {
            addCriterion("APPLICANT_EMAIL <", value, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailLessThanOrEqualTo(String value) {
            addCriterion("APPLICANT_EMAIL <=", value, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailLike(String value) {
            addCriterion("APPLICANT_EMAIL like", value, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailNotLike(String value) {
            addCriterion("APPLICANT_EMAIL not like", value, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailIn(List<String> values) {
            addCriterion("APPLICANT_EMAIL in", values, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailNotIn(List<String> values) {
            addCriterion("APPLICANT_EMAIL not in", values, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailBetween(String value1, String value2) {
            addCriterion("APPLICANT_EMAIL between", value1, value2, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantEmailNotBetween(String value1, String value2) {
            addCriterion("APPLICANT_EMAIL not between", value1, value2, "applicantEmail");
            return (Criteria) this;
        }

        public Criteria andApplicantReasonIsNull() {
            addCriterion("APPLICANT_REASON is null");
            return (Criteria) this;
        }

        public Criteria andApplicantReasonIsNotNull() {
            addCriterion("APPLICANT_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantReasonEqualTo(String value) {
            addCriterion("APPLICANT_REASON =", value, "applicantReason");
            return (Criteria) this;
        }

        public Criteria andApplicantReasonNotEqualTo(String value) {
            addCriterion("APPLICANT_REASON <>", value, "applicantReason");
            return (Criteria) this;
        }

        public Criteria andApplicantReasonGreaterThan(String value) {
            addCriterion("APPLICANT_REASON >", value, "applicantReason");
            return (Criteria) this;
        }

        public Criteria andApplicantReasonGreaterThanOrEqualTo(String value) {
            addCriterion("APPLICANT_REASON >=", value, "applicantReason");
            return (Criteria) this;
        }

        public Criteria andApplicantReasonLessThan(String value) {
            addCriterion("APPLICANT_REASON <", value, "applicantReason");
            return (Criteria) this;
        }

        public Criteria andApplicantReasonLessThanOrEqualTo(String value) {
            addCriterion("APPLICANT_REASON <=", value, "applicantReason");
            return (Criteria) this;
        }

        public Criteria andApplicantReasonLike(String value) {
            addCriterion("APPLICANT_REASON like", value, "applicantReason");
            return (Criteria) this;
        }

        public Criteria andApplicantReasonNotLike(String value) {
            addCriterion("APPLICANT_REASON not like", value, "applicantReason");
            return (Criteria) this;
        }

        public Criteria andApplicantReasonIn(List<String> values) {
            addCriterion("APPLICANT_REASON in", values, "applicantReason");
            return (Criteria) this;
        }

        public Criteria andApplicantReasonNotIn(List<String> values) {
            addCriterion("APPLICANT_REASON not in", values, "applicantReason");
            return (Criteria) this;
        }

        public Criteria andApplicantReasonBetween(String value1, String value2) {
            addCriterion("APPLICANT_REASON between", value1, value2, "applicantReason");
            return (Criteria) this;
        }

        public Criteria andApplicantReasonNotBetween(String value1, String value2) {
            addCriterion("APPLICANT_REASON not between", value1, value2, "applicantReason");
            return (Criteria) this;
        }

        public Criteria andApplicantDescIsNull() {
            addCriterion("APPLICANT_DESC is null");
            return (Criteria) this;
        }

        public Criteria andApplicantDescIsNotNull() {
            addCriterion("APPLICANT_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantDescEqualTo(String value) {
            addCriterion("APPLICANT_DESC =", value, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescNotEqualTo(String value) {
            addCriterion("APPLICANT_DESC <>", value, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescGreaterThan(String value) {
            addCriterion("APPLICANT_DESC >", value, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescGreaterThanOrEqualTo(String value) {
            addCriterion("APPLICANT_DESC >=", value, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescLessThan(String value) {
            addCriterion("APPLICANT_DESC <", value, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescLessThanOrEqualTo(String value) {
            addCriterion("APPLICANT_DESC <=", value, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescLike(String value) {
            addCriterion("APPLICANT_DESC like", value, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescNotLike(String value) {
            addCriterion("APPLICANT_DESC not like", value, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescIn(List<String> values) {
            addCriterion("APPLICANT_DESC in", values, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescNotIn(List<String> values) {
            addCriterion("APPLICANT_DESC not in", values, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescBetween(String value1, String value2) {
            addCriterion("APPLICANT_DESC between", value1, value2, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescNotBetween(String value1, String value2) {
            addCriterion("APPLICANT_DESC not between", value1, value2, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andExpirationDateIsNull() {
            addCriterion("EXPIRATION_DATE is null");
            return (Criteria) this;
        }

        public Criteria andExpirationDateIsNotNull() {
            addCriterion("EXPIRATION_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationDateEqualTo(Timestamp value) {
            addCriterion("EXPIRATION_DATE =", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateNotEqualTo(Timestamp value) {
            addCriterion("EXPIRATION_DATE <>", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateGreaterThan(Timestamp value) {
            addCriterion("EXPIRATION_DATE >", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("EXPIRATION_DATE >=", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateLessThan(Timestamp value) {
            addCriterion("EXPIRATION_DATE <", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("EXPIRATION_DATE <=", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateIn(List<Timestamp> values) {
            addCriterion("EXPIRATION_DATE in", values, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateNotIn(List<Timestamp> values) {
            addCriterion("EXPIRATION_DATE not in", values, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("EXPIRATION_DATE between", value1, value2, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("EXPIRATION_DATE not between", value1, value2, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andBelongCloudIsNull() {
            addCriterion("BELONG_CLOUD is null");
            return (Criteria) this;
        }

        public Criteria andBelongCloudIsNotNull() {
            addCriterion("BELONG_CLOUD is not null");
            return (Criteria) this;
        }

        public Criteria andBelongCloudEqualTo(String value) {
            addCriterion("BELONG_CLOUD =", value, "belongCloud");
            return (Criteria) this;
        }

        public Criteria andBelongCloudNotEqualTo(String value) {
            addCriterion("BELONG_CLOUD <>", value, "belongCloud");
            return (Criteria) this;
        }

        public Criteria andBelongCloudGreaterThan(String value) {
            addCriterion("BELONG_CLOUD >", value, "belongCloud");
            return (Criteria) this;
        }

        public Criteria andBelongCloudGreaterThanOrEqualTo(String value) {
            addCriterion("BELONG_CLOUD >=", value, "belongCloud");
            return (Criteria) this;
        }

        public Criteria andBelongCloudLessThan(String value) {
            addCriterion("BELONG_CLOUD <", value, "belongCloud");
            return (Criteria) this;
        }

        public Criteria andBelongCloudLessThanOrEqualTo(String value) {
            addCriterion("BELONG_CLOUD <=", value, "belongCloud");
            return (Criteria) this;
        }

        public Criteria andBelongCloudLike(String value) {
            addCriterion("BELONG_CLOUD like", value, "belongCloud");
            return (Criteria) this;
        }

        public Criteria andBelongCloudNotLike(String value) {
            addCriterion("BELONG_CLOUD not like", value, "belongCloud");
            return (Criteria) this;
        }

        public Criteria andBelongCloudIn(List<String> values) {
            addCriterion("BELONG_CLOUD in", values, "belongCloud");
            return (Criteria) this;
        }

        public Criteria andBelongCloudNotIn(List<String> values) {
            addCriterion("BELONG_CLOUD not in", values, "belongCloud");
            return (Criteria) this;
        }

        public Criteria andBelongCloudBetween(String value1, String value2) {
            addCriterion("BELONG_CLOUD between", value1, value2, "belongCloud");
            return (Criteria) this;
        }

        public Criteria andBelongCloudNotBetween(String value1, String value2) {
            addCriterion("BELONG_CLOUD not between", value1, value2, "belongCloud");
            return (Criteria) this;
        }

        public Criteria andWfInstIdIsNull() {
            addCriterion("WF_INST_ID is null");
            return (Criteria) this;
        }

        public Criteria andWfInstIdIsNotNull() {
            addCriterion("WF_INST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWfInstIdEqualTo(String value) {
            addCriterion("WF_INST_ID =", value, "wfInstId");
            return (Criteria) this;
        }

        public Criteria andWfInstIdNotEqualTo(String value) {
            addCriterion("WF_INST_ID <>", value, "wfInstId");
            return (Criteria) this;
        }

        public Criteria andWfInstIdGreaterThan(String value) {
            addCriterion("WF_INST_ID >", value, "wfInstId");
            return (Criteria) this;
        }

        public Criteria andWfInstIdGreaterThanOrEqualTo(String value) {
            addCriterion("WF_INST_ID >=", value, "wfInstId");
            return (Criteria) this;
        }

        public Criteria andWfInstIdLessThan(String value) {
            addCriterion("WF_INST_ID <", value, "wfInstId");
            return (Criteria) this;
        }

        public Criteria andWfInstIdLessThanOrEqualTo(String value) {
            addCriterion("WF_INST_ID <=", value, "wfInstId");
            return (Criteria) this;
        }

        public Criteria andWfInstIdLike(String value) {
            addCriterion("WF_INST_ID like", value, "wfInstId");
            return (Criteria) this;
        }

        public Criteria andWfInstIdNotLike(String value) {
            addCriterion("WF_INST_ID not like", value, "wfInstId");
            return (Criteria) this;
        }

        public Criteria andWfInstIdIn(List<String> values) {
            addCriterion("WF_INST_ID in", values, "wfInstId");
            return (Criteria) this;
        }

        public Criteria andWfInstIdNotIn(List<String> values) {
            addCriterion("WF_INST_ID not in", values, "wfInstId");
            return (Criteria) this;
        }

        public Criteria andWfInstIdBetween(String value1, String value2) {
            addCriterion("WF_INST_ID between", value1, value2, "wfInstId");
            return (Criteria) this;
        }

        public Criteria andWfInstIdNotBetween(String value1, String value2) {
            addCriterion("WF_INST_ID not between", value1, value2, "wfInstId");
            return (Criteria) this;
        }

        public Criteria andSoftsConfigIsNull() {
            addCriterion("SOFTS_CONFIG is null");
            return (Criteria) this;
        }

        public Criteria andSoftsConfigIsNotNull() {
            addCriterion("SOFTS_CONFIG is not null");
            return (Criteria) this;
        }

        public Criteria andSoftsConfigEqualTo(String value) {
            addCriterion("SOFTS_CONFIG =", value, "softsConfig");
            return (Criteria) this;
        }

        public Criteria andSoftsConfigNotEqualTo(String value) {
            addCriterion("SOFTS_CONFIG <>", value, "softsConfig");
            return (Criteria) this;
        }

        public Criteria andSoftsConfigGreaterThan(String value) {
            addCriterion("SOFTS_CONFIG >", value, "softsConfig");
            return (Criteria) this;
        }

        public Criteria andSoftsConfigGreaterThanOrEqualTo(String value) {
            addCriterion("SOFTS_CONFIG >=", value, "softsConfig");
            return (Criteria) this;
        }

        public Criteria andSoftsConfigLessThan(String value) {
            addCriterion("SOFTS_CONFIG <", value, "softsConfig");
            return (Criteria) this;
        }

        public Criteria andSoftsConfigLessThanOrEqualTo(String value) {
            addCriterion("SOFTS_CONFIG <=", value, "softsConfig");
            return (Criteria) this;
        }

        public Criteria andSoftsConfigLike(String value) {
            addCriterion("SOFTS_CONFIG like", value, "softsConfig");
            return (Criteria) this;
        }

        public Criteria andSoftsConfigNotLike(String value) {
            addCriterion("SOFTS_CONFIG not like", value, "softsConfig");
            return (Criteria) this;
        }

        public Criteria andSoftsConfigIn(List<String> values) {
            addCriterion("SOFTS_CONFIG in", values, "softsConfig");
            return (Criteria) this;
        }

        public Criteria andSoftsConfigNotIn(List<String> values) {
            addCriterion("SOFTS_CONFIG not in", values, "softsConfig");
            return (Criteria) this;
        }

        public Criteria andSoftsConfigBetween(String value1, String value2) {
            addCriterion("SOFTS_CONFIG between", value1, value2, "softsConfig");
            return (Criteria) this;
        }

        public Criteria andSoftsConfigNotBetween(String value1, String value2) {
            addCriterion("SOFTS_CONFIG not between", value1, value2, "softsConfig");
            return (Criteria) this;
        }

        public Criteria andSbutractFlagIsNull() {
            addCriterion("SBUTRACT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSbutractFlagIsNotNull() {
            addCriterion("SBUTRACT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSbutractFlagEqualTo(String value) {
            addCriterion("SBUTRACT_FLAG =", value, "sbutractFlag");
            return (Criteria) this;
        }

        public Criteria andSbutractFlagNotEqualTo(String value) {
            addCriterion("SBUTRACT_FLAG <>", value, "sbutractFlag");
            return (Criteria) this;
        }

        public Criteria andSbutractFlagGreaterThan(String value) {
            addCriterion("SBUTRACT_FLAG >", value, "sbutractFlag");
            return (Criteria) this;
        }

        public Criteria andSbutractFlagGreaterThanOrEqualTo(String value) {
            addCriterion("SBUTRACT_FLAG >=", value, "sbutractFlag");
            return (Criteria) this;
        }

        public Criteria andSbutractFlagLessThan(String value) {
            addCriterion("SBUTRACT_FLAG <", value, "sbutractFlag");
            return (Criteria) this;
        }

        public Criteria andSbutractFlagLessThanOrEqualTo(String value) {
            addCriterion("SBUTRACT_FLAG <=", value, "sbutractFlag");
            return (Criteria) this;
        }

        public Criteria andSbutractFlagLike(String value) {
            addCriterion("SBUTRACT_FLAG like", value, "sbutractFlag");
            return (Criteria) this;
        }

        public Criteria andSbutractFlagNotLike(String value) {
            addCriterion("SBUTRACT_FLAG not like", value, "sbutractFlag");
            return (Criteria) this;
        }

        public Criteria andSbutractFlagIn(List<String> values) {
            addCriterion("SBUTRACT_FLAG in", values, "sbutractFlag");
            return (Criteria) this;
        }

        public Criteria andSbutractFlagNotIn(List<String> values) {
            addCriterion("SBUTRACT_FLAG not in", values, "sbutractFlag");
            return (Criteria) this;
        }

        public Criteria andSbutractFlagBetween(String value1, String value2) {
            addCriterion("SBUTRACT_FLAG between", value1, value2, "sbutractFlag");
            return (Criteria) this;
        }

        public Criteria andSbutractFlagNotBetween(String value1, String value2) {
            addCriterion("SBUTRACT_FLAG not between", value1, value2, "sbutractFlag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
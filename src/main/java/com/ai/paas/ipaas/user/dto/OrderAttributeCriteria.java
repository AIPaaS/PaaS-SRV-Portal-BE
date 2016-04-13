package com.ai.paas.ipaas.user.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderAttributeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrderAttributeCriteria() {
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

        public Criteria andCostCenterCodeIsNull() {
            addCriterion("COST_CENTER_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCostCenterCodeIsNotNull() {
            addCriterion("COST_CENTER_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCostCenterCodeEqualTo(String value) {
            addCriterion("COST_CENTER_CODE =", value, "costCenterCode");
            return (Criteria) this;
        }

        public Criteria andCostCenterCodeNotEqualTo(String value) {
            addCriterion("COST_CENTER_CODE <>", value, "costCenterCode");
            return (Criteria) this;
        }

        public Criteria andCostCenterCodeGreaterThan(String value) {
            addCriterion("COST_CENTER_CODE >", value, "costCenterCode");
            return (Criteria) this;
        }

        public Criteria andCostCenterCodeGreaterThanOrEqualTo(String value) {
            addCriterion("COST_CENTER_CODE >=", value, "costCenterCode");
            return (Criteria) this;
        }

        public Criteria andCostCenterCodeLessThan(String value) {
            addCriterion("COST_CENTER_CODE <", value, "costCenterCode");
            return (Criteria) this;
        }

        public Criteria andCostCenterCodeLessThanOrEqualTo(String value) {
            addCriterion("COST_CENTER_CODE <=", value, "costCenterCode");
            return (Criteria) this;
        }

        public Criteria andCostCenterCodeLike(String value) {
            addCriterion("COST_CENTER_CODE like", value, "costCenterCode");
            return (Criteria) this;
        }

        public Criteria andCostCenterCodeNotLike(String value) {
            addCriterion("COST_CENTER_CODE not like", value, "costCenterCode");
            return (Criteria) this;
        }

        public Criteria andCostCenterCodeIn(List<String> values) {
            addCriterion("COST_CENTER_CODE in", values, "costCenterCode");
            return (Criteria) this;
        }

        public Criteria andCostCenterCodeNotIn(List<String> values) {
            addCriterion("COST_CENTER_CODE not in", values, "costCenterCode");
            return (Criteria) this;
        }

        public Criteria andCostCenterCodeBetween(String value1, String value2) {
            addCriterion("COST_CENTER_CODE between", value1, value2, "costCenterCode");
            return (Criteria) this;
        }

        public Criteria andCostCenterCodeNotBetween(String value1, String value2) {
            addCriterion("COST_CENTER_CODE not between", value1, value2, "costCenterCode");
            return (Criteria) this;
        }

        public Criteria andCostCenterNameIsNull() {
            addCriterion("COST_CENTER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCostCenterNameIsNotNull() {
            addCriterion("COST_CENTER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCostCenterNameEqualTo(String value) {
            addCriterion("COST_CENTER_NAME =", value, "costCenterName");
            return (Criteria) this;
        }

        public Criteria andCostCenterNameNotEqualTo(String value) {
            addCriterion("COST_CENTER_NAME <>", value, "costCenterName");
            return (Criteria) this;
        }

        public Criteria andCostCenterNameGreaterThan(String value) {
            addCriterion("COST_CENTER_NAME >", value, "costCenterName");
            return (Criteria) this;
        }

        public Criteria andCostCenterNameGreaterThanOrEqualTo(String value) {
            addCriterion("COST_CENTER_NAME >=", value, "costCenterName");
            return (Criteria) this;
        }

        public Criteria andCostCenterNameLessThan(String value) {
            addCriterion("COST_CENTER_NAME <", value, "costCenterName");
            return (Criteria) this;
        }

        public Criteria andCostCenterNameLessThanOrEqualTo(String value) {
            addCriterion("COST_CENTER_NAME <=", value, "costCenterName");
            return (Criteria) this;
        }

        public Criteria andCostCenterNameLike(String value) {
            addCriterion("COST_CENTER_NAME like", value, "costCenterName");
            return (Criteria) this;
        }

        public Criteria andCostCenterNameNotLike(String value) {
            addCriterion("COST_CENTER_NAME not like", value, "costCenterName");
            return (Criteria) this;
        }

        public Criteria andCostCenterNameIn(List<String> values) {
            addCriterion("COST_CENTER_NAME in", values, "costCenterName");
            return (Criteria) this;
        }

        public Criteria andCostCenterNameNotIn(List<String> values) {
            addCriterion("COST_CENTER_NAME not in", values, "costCenterName");
            return (Criteria) this;
        }

        public Criteria andCostCenterNameBetween(String value1, String value2) {
            addCriterion("COST_CENTER_NAME between", value1, value2, "costCenterName");
            return (Criteria) this;
        }

        public Criteria andCostCenterNameNotBetween(String value1, String value2) {
            addCriterion("COST_CENTER_NAME not between", value1, value2, "costCenterName");
            return (Criteria) this;
        }

        public Criteria andUserMaxNumbersIsNull() {
            addCriterion("USER_MAX_NUMBERS is null");
            return (Criteria) this;
        }

        public Criteria andUserMaxNumbersIsNotNull() {
            addCriterion("USER_MAX_NUMBERS is not null");
            return (Criteria) this;
        }

        public Criteria andUserMaxNumbersEqualTo(Long value) {
            addCriterion("USER_MAX_NUMBERS =", value, "userMaxNumbers");
            return (Criteria) this;
        }

        public Criteria andUserMaxNumbersNotEqualTo(Long value) {
            addCriterion("USER_MAX_NUMBERS <>", value, "userMaxNumbers");
            return (Criteria) this;
        }

        public Criteria andUserMaxNumbersGreaterThan(Long value) {
            addCriterion("USER_MAX_NUMBERS >", value, "userMaxNumbers");
            return (Criteria) this;
        }

        public Criteria andUserMaxNumbersGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_MAX_NUMBERS >=", value, "userMaxNumbers");
            return (Criteria) this;
        }

        public Criteria andUserMaxNumbersLessThan(Long value) {
            addCriterion("USER_MAX_NUMBERS <", value, "userMaxNumbers");
            return (Criteria) this;
        }

        public Criteria andUserMaxNumbersLessThanOrEqualTo(Long value) {
            addCriterion("USER_MAX_NUMBERS <=", value, "userMaxNumbers");
            return (Criteria) this;
        }

        public Criteria andUserMaxNumbersIn(List<Long> values) {
            addCriterion("USER_MAX_NUMBERS in", values, "userMaxNumbers");
            return (Criteria) this;
        }

        public Criteria andUserMaxNumbersNotIn(List<Long> values) {
            addCriterion("USER_MAX_NUMBERS not in", values, "userMaxNumbers");
            return (Criteria) this;
        }

        public Criteria andUserMaxNumbersBetween(Long value1, Long value2) {
            addCriterion("USER_MAX_NUMBERS between", value1, value2, "userMaxNumbers");
            return (Criteria) this;
        }

        public Criteria andUserMaxNumbersNotBetween(Long value1, Long value2) {
            addCriterion("USER_MAX_NUMBERS not between", value1, value2, "userMaxNumbers");
            return (Criteria) this;
        }

        public Criteria andConcurrentNumbersIsNull() {
            addCriterion("Concurrent_numbers is null");
            return (Criteria) this;
        }

        public Criteria andConcurrentNumbersIsNotNull() {
            addCriterion("Concurrent_numbers is not null");
            return (Criteria) this;
        }

        public Criteria andConcurrentNumbersEqualTo(Long value) {
            addCriterion("Concurrent_numbers =", value, "concurrentNumbers");
            return (Criteria) this;
        }

        public Criteria andConcurrentNumbersNotEqualTo(Long value) {
            addCriterion("Concurrent_numbers <>", value, "concurrentNumbers");
            return (Criteria) this;
        }

        public Criteria andConcurrentNumbersGreaterThan(Long value) {
            addCriterion("Concurrent_numbers >", value, "concurrentNumbers");
            return (Criteria) this;
        }

        public Criteria andConcurrentNumbersGreaterThanOrEqualTo(Long value) {
            addCriterion("Concurrent_numbers >=", value, "concurrentNumbers");
            return (Criteria) this;
        }

        public Criteria andConcurrentNumbersLessThan(Long value) {
            addCriterion("Concurrent_numbers <", value, "concurrentNumbers");
            return (Criteria) this;
        }

        public Criteria andConcurrentNumbersLessThanOrEqualTo(Long value) {
            addCriterion("Concurrent_numbers <=", value, "concurrentNumbers");
            return (Criteria) this;
        }

        public Criteria andConcurrentNumbersIn(List<Long> values) {
            addCriterion("Concurrent_numbers in", values, "concurrentNumbers");
            return (Criteria) this;
        }

        public Criteria andConcurrentNumbersNotIn(List<Long> values) {
            addCriterion("Concurrent_numbers not in", values, "concurrentNumbers");
            return (Criteria) this;
        }

        public Criteria andConcurrentNumbersBetween(Long value1, Long value2) {
            addCriterion("Concurrent_numbers between", value1, value2, "concurrentNumbers");
            return (Criteria) this;
        }

        public Criteria andConcurrentNumbersNotBetween(Long value1, Long value2) {
            addCriterion("Concurrent_numbers not between", value1, value2, "concurrentNumbers");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIsNull() {
            addCriterion("apply_type is null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIsNotNull() {
            addCriterion("apply_type is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeEqualTo(String value) {
            addCriterion("apply_type =", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotEqualTo(String value) {
            addCriterion("apply_type <>", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThan(String value) {
            addCriterion("apply_type >", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("apply_type >=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThan(String value) {
            addCriterion("apply_type <", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThanOrEqualTo(String value) {
            addCriterion("apply_type <=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLike(String value) {
            addCriterion("apply_type like", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotLike(String value) {
            addCriterion("apply_type not like", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIn(List<String> values) {
            addCriterion("apply_type in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotIn(List<String> values) {
            addCriterion("apply_type not in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeBetween(String value1, String value2) {
            addCriterion("apply_type between", value1, value2, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotBetween(String value1, String value2) {
            addCriterion("apply_type not between", value1, value2, "applyType");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNull() {
            addCriterion("use_type is null");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNotNull() {
            addCriterion("use_type is not null");
            return (Criteria) this;
        }

        public Criteria andUseTypeEqualTo(String value) {
            addCriterion("use_type =", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotEqualTo(String value) {
            addCriterion("use_type <>", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThan(String value) {
            addCriterion("use_type >", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("use_type >=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThan(String value) {
            addCriterion("use_type <", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThanOrEqualTo(String value) {
            addCriterion("use_type <=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLike(String value) {
            addCriterion("use_type like", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotLike(String value) {
            addCriterion("use_type not like", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeIn(List<String> values) {
            addCriterion("use_type in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotIn(List<String> values) {
            addCriterion("use_type not in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeBetween(String value1, String value2) {
            addCriterion("use_type between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotBetween(String value1, String value2) {
            addCriterion("use_type not between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andApplyDescIsNull() {
            addCriterion("apply_desc is null");
            return (Criteria) this;
        }

        public Criteria andApplyDescIsNotNull() {
            addCriterion("apply_desc is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDescEqualTo(String value) {
            addCriterion("apply_desc =", value, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescNotEqualTo(String value) {
            addCriterion("apply_desc <>", value, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescGreaterThan(String value) {
            addCriterion("apply_desc >", value, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescGreaterThanOrEqualTo(String value) {
            addCriterion("apply_desc >=", value, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescLessThan(String value) {
            addCriterion("apply_desc <", value, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescLessThanOrEqualTo(String value) {
            addCriterion("apply_desc <=", value, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescLike(String value) {
            addCriterion("apply_desc like", value, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescNotLike(String value) {
            addCriterion("apply_desc not like", value, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescIn(List<String> values) {
            addCriterion("apply_desc in", values, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescNotIn(List<String> values) {
            addCriterion("apply_desc not in", values, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescBetween(String value1, String value2) {
            addCriterion("apply_desc between", value1, value2, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescNotBetween(String value1, String value2) {
            addCriterion("apply_desc not between", value1, value2, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andIsProjectIsNull() {
            addCriterion("IS_PROJECT is null");
            return (Criteria) this;
        }

        public Criteria andIsProjectIsNotNull() {
            addCriterion("IS_PROJECT is not null");
            return (Criteria) this;
        }

        public Criteria andIsProjectEqualTo(String value) {
            addCriterion("IS_PROJECT =", value, "isProject");
            return (Criteria) this;
        }

        public Criteria andIsProjectNotEqualTo(String value) {
            addCriterion("IS_PROJECT <>", value, "isProject");
            return (Criteria) this;
        }

        public Criteria andIsProjectGreaterThan(String value) {
            addCriterion("IS_PROJECT >", value, "isProject");
            return (Criteria) this;
        }

        public Criteria andIsProjectGreaterThanOrEqualTo(String value) {
            addCriterion("IS_PROJECT >=", value, "isProject");
            return (Criteria) this;
        }

        public Criteria andIsProjectLessThan(String value) {
            addCriterion("IS_PROJECT <", value, "isProject");
            return (Criteria) this;
        }

        public Criteria andIsProjectLessThanOrEqualTo(String value) {
            addCriterion("IS_PROJECT <=", value, "isProject");
            return (Criteria) this;
        }

        public Criteria andIsProjectLike(String value) {
            addCriterion("IS_PROJECT like", value, "isProject");
            return (Criteria) this;
        }

        public Criteria andIsProjectNotLike(String value) {
            addCriterion("IS_PROJECT not like", value, "isProject");
            return (Criteria) this;
        }

        public Criteria andIsProjectIn(List<String> values) {
            addCriterion("IS_PROJECT in", values, "isProject");
            return (Criteria) this;
        }

        public Criteria andIsProjectNotIn(List<String> values) {
            addCriterion("IS_PROJECT not in", values, "isProject");
            return (Criteria) this;
        }

        public Criteria andIsProjectBetween(String value1, String value2) {
            addCriterion("IS_PROJECT between", value1, value2, "isProject");
            return (Criteria) this;
        }

        public Criteria andIsProjectNotBetween(String value1, String value2) {
            addCriterion("IS_PROJECT not between", value1, value2, "isProject");
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
package com.ai.paas.ipaas.user.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderSchemeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrderSchemeCriteria() {
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

        public Criteria andSchemeIdIsNull() {
            addCriterion("SCHEME_ID is null");
            return (Criteria) this;
        }

        public Criteria andSchemeIdIsNotNull() {
            addCriterion("SCHEME_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSchemeIdEqualTo(Long value) {
            addCriterion("SCHEME_ID =", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdNotEqualTo(Long value) {
            addCriterion("SCHEME_ID <>", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdGreaterThan(Long value) {
            addCriterion("SCHEME_ID >", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SCHEME_ID >=", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdLessThan(Long value) {
            addCriterion("SCHEME_ID <", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdLessThanOrEqualTo(Long value) {
            addCriterion("SCHEME_ID <=", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdIn(List<Long> values) {
            addCriterion("SCHEME_ID in", values, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdNotIn(List<Long> values) {
            addCriterion("SCHEME_ID not in", values, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdBetween(Long value1, Long value2) {
            addCriterion("SCHEME_ID between", value1, value2, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdNotBetween(Long value1, Long value2) {
            addCriterion("SCHEME_ID not between", value1, value2, "schemeId");
            return (Criteria) this;
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

        public Criteria andValidFlagIsNull() {
            addCriterion("VALID_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andValidFlagIsNotNull() {
            addCriterion("VALID_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andValidFlagEqualTo(String value) {
            addCriterion("VALID_FLAG =", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagNotEqualTo(String value) {
            addCriterion("VALID_FLAG <>", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagGreaterThan(String value) {
            addCriterion("VALID_FLAG >", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagGreaterThanOrEqualTo(String value) {
            addCriterion("VALID_FLAG >=", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagLessThan(String value) {
            addCriterion("VALID_FLAG <", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagLessThanOrEqualTo(String value) {
            addCriterion("VALID_FLAG <=", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagLike(String value) {
            addCriterion("VALID_FLAG like", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagNotLike(String value) {
            addCriterion("VALID_FLAG not like", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagIn(List<String> values) {
            addCriterion("VALID_FLAG in", values, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagNotIn(List<String> values) {
            addCriterion("VALID_FLAG not in", values, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagBetween(String value1, String value2) {
            addCriterion("VALID_FLAG between", value1, value2, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagNotBetween(String value1, String value2) {
            addCriterion("VALID_FLAG not between", value1, value2, "validFlag");
            return (Criteria) this;
        }

        public Criteria andSchemeMakeTimeIsNull() {
            addCriterion("SCHEME_MAKE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSchemeMakeTimeIsNotNull() {
            addCriterion("SCHEME_MAKE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSchemeMakeTimeEqualTo(Timestamp value) {
            addCriterion("SCHEME_MAKE_TIME =", value, "schemeMakeTime");
            return (Criteria) this;
        }

        public Criteria andSchemeMakeTimeNotEqualTo(Timestamp value) {
            addCriterion("SCHEME_MAKE_TIME <>", value, "schemeMakeTime");
            return (Criteria) this;
        }

        public Criteria andSchemeMakeTimeGreaterThan(Timestamp value) {
            addCriterion("SCHEME_MAKE_TIME >", value, "schemeMakeTime");
            return (Criteria) this;
        }

        public Criteria andSchemeMakeTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("SCHEME_MAKE_TIME >=", value, "schemeMakeTime");
            return (Criteria) this;
        }

        public Criteria andSchemeMakeTimeLessThan(Timestamp value) {
            addCriterion("SCHEME_MAKE_TIME <", value, "schemeMakeTime");
            return (Criteria) this;
        }

        public Criteria andSchemeMakeTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("SCHEME_MAKE_TIME <=", value, "schemeMakeTime");
            return (Criteria) this;
        }

        public Criteria andSchemeMakeTimeIn(List<Timestamp> values) {
            addCriterion("SCHEME_MAKE_TIME in", values, "schemeMakeTime");
            return (Criteria) this;
        }

        public Criteria andSchemeMakeTimeNotIn(List<Timestamp> values) {
            addCriterion("SCHEME_MAKE_TIME not in", values, "schemeMakeTime");
            return (Criteria) this;
        }

        public Criteria andSchemeMakeTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("SCHEME_MAKE_TIME between", value1, value2, "schemeMakeTime");
            return (Criteria) this;
        }

        public Criteria andSchemeMakeTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("SCHEME_MAKE_TIME not between", value1, value2, "schemeMakeTime");
            return (Criteria) this;
        }

        public Criteria andSchemeMakerIsNull() {
            addCriterion("SCHEME_MAKER is null");
            return (Criteria) this;
        }

        public Criteria andSchemeMakerIsNotNull() {
            addCriterion("SCHEME_MAKER is not null");
            return (Criteria) this;
        }

        public Criteria andSchemeMakerEqualTo(String value) {
            addCriterion("SCHEME_MAKER =", value, "schemeMaker");
            return (Criteria) this;
        }

        public Criteria andSchemeMakerNotEqualTo(String value) {
            addCriterion("SCHEME_MAKER <>", value, "schemeMaker");
            return (Criteria) this;
        }

        public Criteria andSchemeMakerGreaterThan(String value) {
            addCriterion("SCHEME_MAKER >", value, "schemeMaker");
            return (Criteria) this;
        }

        public Criteria andSchemeMakerGreaterThanOrEqualTo(String value) {
            addCriterion("SCHEME_MAKER >=", value, "schemeMaker");
            return (Criteria) this;
        }

        public Criteria andSchemeMakerLessThan(String value) {
            addCriterion("SCHEME_MAKER <", value, "schemeMaker");
            return (Criteria) this;
        }

        public Criteria andSchemeMakerLessThanOrEqualTo(String value) {
            addCriterion("SCHEME_MAKER <=", value, "schemeMaker");
            return (Criteria) this;
        }

        public Criteria andSchemeMakerLike(String value) {
            addCriterion("SCHEME_MAKER like", value, "schemeMaker");
            return (Criteria) this;
        }

        public Criteria andSchemeMakerNotLike(String value) {
            addCriterion("SCHEME_MAKER not like", value, "schemeMaker");
            return (Criteria) this;
        }

        public Criteria andSchemeMakerIn(List<String> values) {
            addCriterion("SCHEME_MAKER in", values, "schemeMaker");
            return (Criteria) this;
        }

        public Criteria andSchemeMakerNotIn(List<String> values) {
            addCriterion("SCHEME_MAKER not in", values, "schemeMaker");
            return (Criteria) this;
        }

        public Criteria andSchemeMakerBetween(String value1, String value2) {
            addCriterion("SCHEME_MAKER between", value1, value2, "schemeMaker");
            return (Criteria) this;
        }

        public Criteria andSchemeMakerNotBetween(String value1, String value2) {
            addCriterion("SCHEME_MAKER not between", value1, value2, "schemeMaker");
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
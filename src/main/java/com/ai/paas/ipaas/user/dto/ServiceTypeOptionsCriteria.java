package com.ai.paas.ipaas.user.dto;

import java.util.ArrayList;
import java.util.List;

public class ServiceTypeOptionsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public ServiceTypeOptionsCriteria() {
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

        public Criteria andServiceIdIsNull() {
            addCriterion("service_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("service_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(Integer value) {
            addCriterion("service_id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(Integer value) {
            addCriterion("service_id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(Integer value) {
            addCriterion("service_id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(Integer value) {
            addCriterion("service_id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(Integer value) {
            addCriterion("service_id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<Integer> values) {
            addCriterion("service_id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<Integer> values) {
            addCriterion("service_id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(Integer value1, Integer value2) {
            addCriterion("service_id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("service_id not between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceValueIsNull() {
            addCriterion("service_value is null");
            return (Criteria) this;
        }

        public Criteria andServiceValueIsNotNull() {
            addCriterion("service_value is not null");
            return (Criteria) this;
        }

        public Criteria andServiceValueEqualTo(String value) {
            addCriterion("service_value =", value, "serviceValue");
            return (Criteria) this;
        }

        public Criteria andServiceValueNotEqualTo(String value) {
            addCriterion("service_value <>", value, "serviceValue");
            return (Criteria) this;
        }

        public Criteria andServiceValueGreaterThan(String value) {
            addCriterion("service_value >", value, "serviceValue");
            return (Criteria) this;
        }

        public Criteria andServiceValueGreaterThanOrEqualTo(String value) {
            addCriterion("service_value >=", value, "serviceValue");
            return (Criteria) this;
        }

        public Criteria andServiceValueLessThan(String value) {
            addCriterion("service_value <", value, "serviceValue");
            return (Criteria) this;
        }

        public Criteria andServiceValueLessThanOrEqualTo(String value) {
            addCriterion("service_value <=", value, "serviceValue");
            return (Criteria) this;
        }

        public Criteria andServiceValueLike(String value) {
            addCriterion("service_value like", value, "serviceValue");
            return (Criteria) this;
        }

        public Criteria andServiceValueNotLike(String value) {
            addCriterion("service_value not like", value, "serviceValue");
            return (Criteria) this;
        }

        public Criteria andServiceValueIn(List<String> values) {
            addCriterion("service_value in", values, "serviceValue");
            return (Criteria) this;
        }

        public Criteria andServiceValueNotIn(List<String> values) {
            addCriterion("service_value not in", values, "serviceValue");
            return (Criteria) this;
        }

        public Criteria andServiceValueBetween(String value1, String value2) {
            addCriterion("service_value between", value1, value2, "serviceValue");
            return (Criteria) this;
        }

        public Criteria andServiceValueNotBetween(String value1, String value2) {
            addCriterion("service_value not between", value1, value2, "serviceValue");
            return (Criteria) this;
        }

        public Criteria andServiceOptionIsNull() {
            addCriterion("service_option is null");
            return (Criteria) this;
        }

        public Criteria andServiceOptionIsNotNull() {
            addCriterion("service_option is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOptionEqualTo(String value) {
            addCriterion("service_option =", value, "serviceOption");
            return (Criteria) this;
        }

        public Criteria andServiceOptionNotEqualTo(String value) {
            addCriterion("service_option <>", value, "serviceOption");
            return (Criteria) this;
        }

        public Criteria andServiceOptionGreaterThan(String value) {
            addCriterion("service_option >", value, "serviceOption");
            return (Criteria) this;
        }

        public Criteria andServiceOptionGreaterThanOrEqualTo(String value) {
            addCriterion("service_option >=", value, "serviceOption");
            return (Criteria) this;
        }

        public Criteria andServiceOptionLessThan(String value) {
            addCriterion("service_option <", value, "serviceOption");
            return (Criteria) this;
        }

        public Criteria andServiceOptionLessThanOrEqualTo(String value) {
            addCriterion("service_option <=", value, "serviceOption");
            return (Criteria) this;
        }

        public Criteria andServiceOptionLike(String value) {
            addCriterion("service_option like", value, "serviceOption");
            return (Criteria) this;
        }

        public Criteria andServiceOptionNotLike(String value) {
            addCriterion("service_option not like", value, "serviceOption");
            return (Criteria) this;
        }

        public Criteria andServiceOptionIn(List<String> values) {
            addCriterion("service_option in", values, "serviceOption");
            return (Criteria) this;
        }

        public Criteria andServiceOptionNotIn(List<String> values) {
            addCriterion("service_option not in", values, "serviceOption");
            return (Criteria) this;
        }

        public Criteria andServiceOptionBetween(String value1, String value2) {
            addCriterion("service_option between", value1, value2, "serviceOption");
            return (Criteria) this;
        }

        public Criteria andServiceOptionNotBetween(String value1, String value2) {
            addCriterion("service_option not between", value1, value2, "serviceOption");
            return (Criteria) this;
        }

        public Criteria andIsValidateIsNull() {
            addCriterion("is_validate is null");
            return (Criteria) this;
        }

        public Criteria andIsValidateIsNotNull() {
            addCriterion("is_validate is not null");
            return (Criteria) this;
        }

        public Criteria andIsValidateEqualTo(String value) {
            addCriterion("is_validate =", value, "isValidate");
            return (Criteria) this;
        }

        public Criteria andIsValidateNotEqualTo(String value) {
            addCriterion("is_validate <>", value, "isValidate");
            return (Criteria) this;
        }

        public Criteria andIsValidateGreaterThan(String value) {
            addCriterion("is_validate >", value, "isValidate");
            return (Criteria) this;
        }

        public Criteria andIsValidateGreaterThanOrEqualTo(String value) {
            addCriterion("is_validate >=", value, "isValidate");
            return (Criteria) this;
        }

        public Criteria andIsValidateLessThan(String value) {
            addCriterion("is_validate <", value, "isValidate");
            return (Criteria) this;
        }

        public Criteria andIsValidateLessThanOrEqualTo(String value) {
            addCriterion("is_validate <=", value, "isValidate");
            return (Criteria) this;
        }

        public Criteria andIsValidateLike(String value) {
            addCriterion("is_validate like", value, "isValidate");
            return (Criteria) this;
        }

        public Criteria andIsValidateNotLike(String value) {
            addCriterion("is_validate not like", value, "isValidate");
            return (Criteria) this;
        }

        public Criteria andIsValidateIn(List<String> values) {
            addCriterion("is_validate in", values, "isValidate");
            return (Criteria) this;
        }

        public Criteria andIsValidateNotIn(List<String> values) {
            addCriterion("is_validate not in", values, "isValidate");
            return (Criteria) this;
        }

        public Criteria andIsValidateBetween(String value1, String value2) {
            addCriterion("is_validate between", value1, value2, "isValidate");
            return (Criteria) this;
        }

        public Criteria andIsValidateNotBetween(String value1, String value2) {
            addCriterion("is_validate not between", value1, value2, "isValidate");
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
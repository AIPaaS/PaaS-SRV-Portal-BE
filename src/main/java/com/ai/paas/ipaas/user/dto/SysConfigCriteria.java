package com.ai.paas.ipaas.user.dto;

import java.util.ArrayList;
import java.util.List;

public class SysConfigCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public SysConfigCriteria() {
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

        public Criteria andTypeCodeIsNull() {
            addCriterion("type_code is null");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIsNotNull() {
            addCriterion("type_code is not null");
            return (Criteria) this;
        }

        public Criteria andTypeCodeEqualTo(String value) {
            addCriterion("type_code =", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotEqualTo(String value) {
            addCriterion("type_code <>", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeGreaterThan(String value) {
            addCriterion("type_code >", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("type_code >=", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLessThan(String value) {
            addCriterion("type_code <", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("type_code <=", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLike(String value) {
            addCriterion("type_code like", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotLike(String value) {
            addCriterion("type_code not like", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIn(List<String> values) {
            addCriterion("type_code in", values, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotIn(List<String> values) {
            addCriterion("type_code not in", values, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeBetween(String value1, String value2) {
            addCriterion("type_code between", value1, value2, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotBetween(String value1, String value2) {
            addCriterion("type_code not between", value1, value2, "typeCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeIsNull() {
            addCriterion("param_code is null");
            return (Criteria) this;
        }

        public Criteria andParamCodeIsNotNull() {
            addCriterion("param_code is not null");
            return (Criteria) this;
        }

        public Criteria andParamCodeEqualTo(String value) {
            addCriterion("param_code =", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotEqualTo(String value) {
            addCriterion("param_code <>", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeGreaterThan(String value) {
            addCriterion("param_code >", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeGreaterThanOrEqualTo(String value) {
            addCriterion("param_code >=", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLessThan(String value) {
            addCriterion("param_code <", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLessThanOrEqualTo(String value) {
            addCriterion("param_code <=", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLike(String value) {
            addCriterion("param_code like", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotLike(String value) {
            addCriterion("param_code not like", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeIn(List<String> values) {
            addCriterion("param_code in", values, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotIn(List<String> values) {
            addCriterion("param_code not in", values, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeBetween(String value1, String value2) {
            addCriterion("param_code between", value1, value2, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotBetween(String value1, String value2) {
            addCriterion("param_code not between", value1, value2, "paramCode");
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

        public Criteria andDescbIsNull() {
            addCriterion("descb is null");
            return (Criteria) this;
        }

        public Criteria andDescbIsNotNull() {
            addCriterion("descb is not null");
            return (Criteria) this;
        }

        public Criteria andDescbEqualTo(String value) {
            addCriterion("descb =", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbNotEqualTo(String value) {
            addCriterion("descb <>", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbGreaterThan(String value) {
            addCriterion("descb >", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbGreaterThanOrEqualTo(String value) {
            addCriterion("descb >=", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbLessThan(String value) {
            addCriterion("descb <", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbLessThanOrEqualTo(String value) {
            addCriterion("descb <=", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbLike(String value) {
            addCriterion("descb like", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbNotLike(String value) {
            addCriterion("descb not like", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbIn(List<String> values) {
            addCriterion("descb in", values, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbNotIn(List<String> values) {
            addCriterion("descb not in", values, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbBetween(String value1, String value2) {
            addCriterion("descb between", value1, value2, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbNotBetween(String value1, String value2) {
            addCriterion("descb not between", value1, value2, "descb");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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
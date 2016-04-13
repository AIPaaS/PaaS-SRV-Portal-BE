package com.ai.paas.ipaas.user.dto;

import java.util.ArrayList;
import java.util.List;

public class SysConfigRelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public SysConfigRelCriteria() {
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

        public Criteria andSysConfigRelIdIsNull() {
            addCriterion("SYS_CONFIG_REL_ID is null");
            return (Criteria) this;
        }

        public Criteria andSysConfigRelIdIsNotNull() {
            addCriterion("SYS_CONFIG_REL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSysConfigRelIdEqualTo(Short value) {
            addCriterion("SYS_CONFIG_REL_ID =", value, "sysConfigRelId");
            return (Criteria) this;
        }

        public Criteria andSysConfigRelIdNotEqualTo(Short value) {
            addCriterion("SYS_CONFIG_REL_ID <>", value, "sysConfigRelId");
            return (Criteria) this;
        }

        public Criteria andSysConfigRelIdGreaterThan(Short value) {
            addCriterion("SYS_CONFIG_REL_ID >", value, "sysConfigRelId");
            return (Criteria) this;
        }

        public Criteria andSysConfigRelIdGreaterThanOrEqualTo(Short value) {
            addCriterion("SYS_CONFIG_REL_ID >=", value, "sysConfigRelId");
            return (Criteria) this;
        }

        public Criteria andSysConfigRelIdLessThan(Short value) {
            addCriterion("SYS_CONFIG_REL_ID <", value, "sysConfigRelId");
            return (Criteria) this;
        }

        public Criteria andSysConfigRelIdLessThanOrEqualTo(Short value) {
            addCriterion("SYS_CONFIG_REL_ID <=", value, "sysConfigRelId");
            return (Criteria) this;
        }

        public Criteria andSysConfigRelIdIn(List<Short> values) {
            addCriterion("SYS_CONFIG_REL_ID in", values, "sysConfigRelId");
            return (Criteria) this;
        }

        public Criteria andSysConfigRelIdNotIn(List<Short> values) {
            addCriterion("SYS_CONFIG_REL_ID not in", values, "sysConfigRelId");
            return (Criteria) this;
        }

        public Criteria andSysConfigRelIdBetween(Short value1, Short value2) {
            addCriterion("SYS_CONFIG_REL_ID between", value1, value2, "sysConfigRelId");
            return (Criteria) this;
        }

        public Criteria andSysConfigRelIdNotBetween(Short value1, Short value2) {
            addCriterion("SYS_CONFIG_REL_ID not between", value1, value2, "sysConfigRelId");
            return (Criteria) this;
        }

        public Criteria andParentParamIdIsNull() {
            addCriterion("PARENT_PARAM_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentParamIdIsNotNull() {
            addCriterion("PARENT_PARAM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentParamIdEqualTo(Short value) {
            addCriterion("PARENT_PARAM_ID =", value, "parentParamId");
            return (Criteria) this;
        }

        public Criteria andParentParamIdNotEqualTo(Short value) {
            addCriterion("PARENT_PARAM_ID <>", value, "parentParamId");
            return (Criteria) this;
        }

        public Criteria andParentParamIdGreaterThan(Short value) {
            addCriterion("PARENT_PARAM_ID >", value, "parentParamId");
            return (Criteria) this;
        }

        public Criteria andParentParamIdGreaterThanOrEqualTo(Short value) {
            addCriterion("PARENT_PARAM_ID >=", value, "parentParamId");
            return (Criteria) this;
        }

        public Criteria andParentParamIdLessThan(Short value) {
            addCriterion("PARENT_PARAM_ID <", value, "parentParamId");
            return (Criteria) this;
        }

        public Criteria andParentParamIdLessThanOrEqualTo(Short value) {
            addCriterion("PARENT_PARAM_ID <=", value, "parentParamId");
            return (Criteria) this;
        }

        public Criteria andParentParamIdIn(List<Short> values) {
            addCriterion("PARENT_PARAM_ID in", values, "parentParamId");
            return (Criteria) this;
        }

        public Criteria andParentParamIdNotIn(List<Short> values) {
            addCriterion("PARENT_PARAM_ID not in", values, "parentParamId");
            return (Criteria) this;
        }

        public Criteria andParentParamIdBetween(Short value1, Short value2) {
            addCriterion("PARENT_PARAM_ID between", value1, value2, "parentParamId");
            return (Criteria) this;
        }

        public Criteria andParentParamIdNotBetween(Short value1, Short value2) {
            addCriterion("PARENT_PARAM_ID not between", value1, value2, "parentParamId");
            return (Criteria) this;
        }

        public Criteria andChildParamIdIsNull() {
            addCriterion("CHILD_PARAM_ID is null");
            return (Criteria) this;
        }

        public Criteria andChildParamIdIsNotNull() {
            addCriterion("CHILD_PARAM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChildParamIdEqualTo(Short value) {
            addCriterion("CHILD_PARAM_ID =", value, "childParamId");
            return (Criteria) this;
        }

        public Criteria andChildParamIdNotEqualTo(Short value) {
            addCriterion("CHILD_PARAM_ID <>", value, "childParamId");
            return (Criteria) this;
        }

        public Criteria andChildParamIdGreaterThan(Short value) {
            addCriterion("CHILD_PARAM_ID >", value, "childParamId");
            return (Criteria) this;
        }

        public Criteria andChildParamIdGreaterThanOrEqualTo(Short value) {
            addCriterion("CHILD_PARAM_ID >=", value, "childParamId");
            return (Criteria) this;
        }

        public Criteria andChildParamIdLessThan(Short value) {
            addCriterion("CHILD_PARAM_ID <", value, "childParamId");
            return (Criteria) this;
        }

        public Criteria andChildParamIdLessThanOrEqualTo(Short value) {
            addCriterion("CHILD_PARAM_ID <=", value, "childParamId");
            return (Criteria) this;
        }

        public Criteria andChildParamIdIn(List<Short> values) {
            addCriterion("CHILD_PARAM_ID in", values, "childParamId");
            return (Criteria) this;
        }

        public Criteria andChildParamIdNotIn(List<Short> values) {
            addCriterion("CHILD_PARAM_ID not in", values, "childParamId");
            return (Criteria) this;
        }

        public Criteria andChildParamIdBetween(Short value1, Short value2) {
            addCriterion("CHILD_PARAM_ID between", value1, value2, "childParamId");
            return (Criteria) this;
        }

        public Criteria andChildParamIdNotBetween(Short value1, Short value2) {
            addCriterion("CHILD_PARAM_ID not between", value1, value2, "childParamId");
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
package com.ai.paas.ipaas.user.dto;

import java.util.ArrayList;
import java.util.List;

public class OrdStatusOperateRelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrdStatusOperateRelCriteria() {
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

        public Criteria andOperateRelIdIsNull() {
            addCriterion("OPERATE_REL_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperateRelIdIsNotNull() {
            addCriterion("OPERATE_REL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperateRelIdEqualTo(Short value) {
            addCriterion("OPERATE_REL_ID =", value, "operateRelId");
            return (Criteria) this;
        }

        public Criteria andOperateRelIdNotEqualTo(Short value) {
            addCriterion("OPERATE_REL_ID <>", value, "operateRelId");
            return (Criteria) this;
        }

        public Criteria andOperateRelIdGreaterThan(Short value) {
            addCriterion("OPERATE_REL_ID >", value, "operateRelId");
            return (Criteria) this;
        }

        public Criteria andOperateRelIdGreaterThanOrEqualTo(Short value) {
            addCriterion("OPERATE_REL_ID >=", value, "operateRelId");
            return (Criteria) this;
        }

        public Criteria andOperateRelIdLessThan(Short value) {
            addCriterion("OPERATE_REL_ID <", value, "operateRelId");
            return (Criteria) this;
        }

        public Criteria andOperateRelIdLessThanOrEqualTo(Short value) {
            addCriterion("OPERATE_REL_ID <=", value, "operateRelId");
            return (Criteria) this;
        }

        public Criteria andOperateRelIdIn(List<Short> values) {
            addCriterion("OPERATE_REL_ID in", values, "operateRelId");
            return (Criteria) this;
        }

        public Criteria andOperateRelIdNotIn(List<Short> values) {
            addCriterion("OPERATE_REL_ID not in", values, "operateRelId");
            return (Criteria) this;
        }

        public Criteria andOperateRelIdBetween(Short value1, Short value2) {
            addCriterion("OPERATE_REL_ID between", value1, value2, "operateRelId");
            return (Criteria) this;
        }

        public Criteria andOperateRelIdNotBetween(Short value1, Short value2) {
            addCriterion("OPERATE_REL_ID not between", value1, value2, "operateRelId");
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

        public Criteria andNtAccountIsNull() {
            addCriterion("NT_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andNtAccountIsNotNull() {
            addCriterion("NT_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andNtAccountEqualTo(String value) {
            addCriterion("NT_ACCOUNT =", value, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountNotEqualTo(String value) {
            addCriterion("NT_ACCOUNT <>", value, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountGreaterThan(String value) {
            addCriterion("NT_ACCOUNT >", value, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountGreaterThanOrEqualTo(String value) {
            addCriterion("NT_ACCOUNT >=", value, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountLessThan(String value) {
            addCriterion("NT_ACCOUNT <", value, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountLessThanOrEqualTo(String value) {
            addCriterion("NT_ACCOUNT <=", value, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountLike(String value) {
            addCriterion("NT_ACCOUNT like", value, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountNotLike(String value) {
            addCriterion("NT_ACCOUNT not like", value, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountIn(List<String> values) {
            addCriterion("NT_ACCOUNT in", values, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountNotIn(List<String> values) {
            addCriterion("NT_ACCOUNT not in", values, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountBetween(String value1, String value2) {
            addCriterion("NT_ACCOUNT between", value1, value2, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountNotBetween(String value1, String value2) {
            addCriterion("NT_ACCOUNT not between", value1, value2, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andMailGroupIsNull() {
            addCriterion("MAIL_GROUP is null");
            return (Criteria) this;
        }

        public Criteria andMailGroupIsNotNull() {
            addCriterion("MAIL_GROUP is not null");
            return (Criteria) this;
        }

        public Criteria andMailGroupEqualTo(String value) {
            addCriterion("MAIL_GROUP =", value, "mailGroup");
            return (Criteria) this;
        }

        public Criteria andMailGroupNotEqualTo(String value) {
            addCriterion("MAIL_GROUP <>", value, "mailGroup");
            return (Criteria) this;
        }

        public Criteria andMailGroupGreaterThan(String value) {
            addCriterion("MAIL_GROUP >", value, "mailGroup");
            return (Criteria) this;
        }

        public Criteria andMailGroupGreaterThanOrEqualTo(String value) {
            addCriterion("MAIL_GROUP >=", value, "mailGroup");
            return (Criteria) this;
        }

        public Criteria andMailGroupLessThan(String value) {
            addCriterion("MAIL_GROUP <", value, "mailGroup");
            return (Criteria) this;
        }

        public Criteria andMailGroupLessThanOrEqualTo(String value) {
            addCriterion("MAIL_GROUP <=", value, "mailGroup");
            return (Criteria) this;
        }

        public Criteria andMailGroupLike(String value) {
            addCriterion("MAIL_GROUP like", value, "mailGroup");
            return (Criteria) this;
        }

        public Criteria andMailGroupNotLike(String value) {
            addCriterion("MAIL_GROUP not like", value, "mailGroup");
            return (Criteria) this;
        }

        public Criteria andMailGroupIn(List<String> values) {
            addCriterion("MAIL_GROUP in", values, "mailGroup");
            return (Criteria) this;
        }

        public Criteria andMailGroupNotIn(List<String> values) {
            addCriterion("MAIL_GROUP not in", values, "mailGroup");
            return (Criteria) this;
        }

        public Criteria andMailGroupBetween(String value1, String value2) {
            addCriterion("MAIL_GROUP between", value1, value2, "mailGroup");
            return (Criteria) this;
        }

        public Criteria andMailGroupNotBetween(String value1, String value2) {
            addCriterion("MAIL_GROUP not between", value1, value2, "mailGroup");
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
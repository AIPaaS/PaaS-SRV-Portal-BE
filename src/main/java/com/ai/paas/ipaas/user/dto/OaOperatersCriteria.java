package com.ai.paas.ipaas.user.dto;

import java.util.ArrayList;
import java.util.List;

public class OaOperatersCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OaOperatersCriteria() {
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

        public Criteria andOaIdIsNull() {
            addCriterion("OA_ID is null");
            return (Criteria) this;
        }

        public Criteria andOaIdIsNotNull() {
            addCriterion("OA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOaIdEqualTo(Short value) {
            addCriterion("OA_ID =", value, "oaId");
            return (Criteria) this;
        }

        public Criteria andOaIdNotEqualTo(Short value) {
            addCriterion("OA_ID <>", value, "oaId");
            return (Criteria) this;
        }

        public Criteria andOaIdGreaterThan(Short value) {
            addCriterion("OA_ID >", value, "oaId");
            return (Criteria) this;
        }

        public Criteria andOaIdGreaterThanOrEqualTo(Short value) {
            addCriterion("OA_ID >=", value, "oaId");
            return (Criteria) this;
        }

        public Criteria andOaIdLessThan(Short value) {
            addCriterion("OA_ID <", value, "oaId");
            return (Criteria) this;
        }

        public Criteria andOaIdLessThanOrEqualTo(Short value) {
            addCriterion("OA_ID <=", value, "oaId");
            return (Criteria) this;
        }

        public Criteria andOaIdIn(List<Short> values) {
            addCriterion("OA_ID in", values, "oaId");
            return (Criteria) this;
        }

        public Criteria andOaIdNotIn(List<Short> values) {
            addCriterion("OA_ID not in", values, "oaId");
            return (Criteria) this;
        }

        public Criteria andOaIdBetween(Short value1, Short value2) {
            addCriterion("OA_ID between", value1, value2, "oaId");
            return (Criteria) this;
        }

        public Criteria andOaIdNotBetween(Short value1, Short value2) {
            addCriterion("OA_ID not between", value1, value2, "oaId");
            return (Criteria) this;
        }

        public Criteria andBuiCodeIsNull() {
            addCriterion("BUI_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBuiCodeIsNotNull() {
            addCriterion("BUI_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBuiCodeEqualTo(String value) {
            addCriterion("BUI_CODE =", value, "buiCode");
            return (Criteria) this;
        }

        public Criteria andBuiCodeNotEqualTo(String value) {
            addCriterion("BUI_CODE <>", value, "buiCode");
            return (Criteria) this;
        }

        public Criteria andBuiCodeGreaterThan(String value) {
            addCriterion("BUI_CODE >", value, "buiCode");
            return (Criteria) this;
        }

        public Criteria andBuiCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BUI_CODE >=", value, "buiCode");
            return (Criteria) this;
        }

        public Criteria andBuiCodeLessThan(String value) {
            addCriterion("BUI_CODE <", value, "buiCode");
            return (Criteria) this;
        }

        public Criteria andBuiCodeLessThanOrEqualTo(String value) {
            addCriterion("BUI_CODE <=", value, "buiCode");
            return (Criteria) this;
        }

        public Criteria andBuiCodeLike(String value) {
            addCriterion("BUI_CODE like", value, "buiCode");
            return (Criteria) this;
        }

        public Criteria andBuiCodeNotLike(String value) {
            addCriterion("BUI_CODE not like", value, "buiCode");
            return (Criteria) this;
        }

        public Criteria andBuiCodeIn(List<String> values) {
            addCriterion("BUI_CODE in", values, "buiCode");
            return (Criteria) this;
        }

        public Criteria andBuiCodeNotIn(List<String> values) {
            addCriterion("BUI_CODE not in", values, "buiCode");
            return (Criteria) this;
        }

        public Criteria andBuiCodeBetween(String value1, String value2) {
            addCriterion("BUI_CODE between", value1, value2, "buiCode");
            return (Criteria) this;
        }

        public Criteria andBuiCodeNotBetween(String value1, String value2) {
            addCriterion("BUI_CODE not between", value1, value2, "buiCode");
            return (Criteria) this;
        }

        public Criteria andNtAccountIsNull() {
            addCriterion("nt_account is null");
            return (Criteria) this;
        }

        public Criteria andNtAccountIsNotNull() {
            addCriterion("nt_account is not null");
            return (Criteria) this;
        }

        public Criteria andNtAccountEqualTo(String value) {
            addCriterion("nt_account =", value, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountNotEqualTo(String value) {
            addCriterion("nt_account <>", value, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountGreaterThan(String value) {
            addCriterion("nt_account >", value, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountGreaterThanOrEqualTo(String value) {
            addCriterion("nt_account >=", value, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountLessThan(String value) {
            addCriterion("nt_account <", value, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountLessThanOrEqualTo(String value) {
            addCriterion("nt_account <=", value, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountLike(String value) {
            addCriterion("nt_account like", value, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountNotLike(String value) {
            addCriterion("nt_account not like", value, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountIn(List<String> values) {
            addCriterion("nt_account in", values, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountNotIn(List<String> values) {
            addCriterion("nt_account not in", values, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountBetween(String value1, String value2) {
            addCriterion("nt_account between", value1, value2, "ntAccount");
            return (Criteria) this;
        }

        public Criteria andNtAccountNotBetween(String value1, String value2) {
            addCriterion("nt_account not between", value1, value2, "ntAccount");
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
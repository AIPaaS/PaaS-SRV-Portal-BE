package com.ai.paas.ipaas.user.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserMessageCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public UserMessageCriteria() {
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

        public Criteria andUserMsgIdIsNull() {
            addCriterion("USER_MSG_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserMsgIdIsNotNull() {
            addCriterion("USER_MSG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserMsgIdEqualTo(Integer value) {
            addCriterion("USER_MSG_ID =", value, "userMsgId");
            return (Criteria) this;
        }

        public Criteria andUserMsgIdNotEqualTo(Integer value) {
            addCriterion("USER_MSG_ID <>", value, "userMsgId");
            return (Criteria) this;
        }

        public Criteria andUserMsgIdGreaterThan(Integer value) {
            addCriterion("USER_MSG_ID >", value, "userMsgId");
            return (Criteria) this;
        }

        public Criteria andUserMsgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_MSG_ID >=", value, "userMsgId");
            return (Criteria) this;
        }

        public Criteria andUserMsgIdLessThan(Integer value) {
            addCriterion("USER_MSG_ID <", value, "userMsgId");
            return (Criteria) this;
        }

        public Criteria andUserMsgIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_MSG_ID <=", value, "userMsgId");
            return (Criteria) this;
        }

        public Criteria andUserMsgIdIn(List<Integer> values) {
            addCriterion("USER_MSG_ID in", values, "userMsgId");
            return (Criteria) this;
        }

        public Criteria andUserMsgIdNotIn(List<Integer> values) {
            addCriterion("USER_MSG_ID not in", values, "userMsgId");
            return (Criteria) this;
        }

        public Criteria andUserMsgIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_MSG_ID between", value1, value2, "userMsgId");
            return (Criteria) this;
        }

        public Criteria andUserMsgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_MSG_ID not between", value1, value2, "userMsgId");
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

        public Criteria andUserMsgContentIsNull() {
            addCriterion("USER_MSG_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andUserMsgContentIsNotNull() {
            addCriterion("USER_MSG_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andUserMsgContentEqualTo(String value) {
            addCriterion("USER_MSG_CONTENT =", value, "userMsgContent");
            return (Criteria) this;
        }

        public Criteria andUserMsgContentNotEqualTo(String value) {
            addCriterion("USER_MSG_CONTENT <>", value, "userMsgContent");
            return (Criteria) this;
        }

        public Criteria andUserMsgContentGreaterThan(String value) {
            addCriterion("USER_MSG_CONTENT >", value, "userMsgContent");
            return (Criteria) this;
        }

        public Criteria andUserMsgContentGreaterThanOrEqualTo(String value) {
            addCriterion("USER_MSG_CONTENT >=", value, "userMsgContent");
            return (Criteria) this;
        }

        public Criteria andUserMsgContentLessThan(String value) {
            addCriterion("USER_MSG_CONTENT <", value, "userMsgContent");
            return (Criteria) this;
        }

        public Criteria andUserMsgContentLessThanOrEqualTo(String value) {
            addCriterion("USER_MSG_CONTENT <=", value, "userMsgContent");
            return (Criteria) this;
        }

        public Criteria andUserMsgContentLike(String value) {
            addCriterion("USER_MSG_CONTENT like", value, "userMsgContent");
            return (Criteria) this;
        }

        public Criteria andUserMsgContentNotLike(String value) {
            addCriterion("USER_MSG_CONTENT not like", value, "userMsgContent");
            return (Criteria) this;
        }

        public Criteria andUserMsgContentIn(List<String> values) {
            addCriterion("USER_MSG_CONTENT in", values, "userMsgContent");
            return (Criteria) this;
        }

        public Criteria andUserMsgContentNotIn(List<String> values) {
            addCriterion("USER_MSG_CONTENT not in", values, "userMsgContent");
            return (Criteria) this;
        }

        public Criteria andUserMsgContentBetween(String value1, String value2) {
            addCriterion("USER_MSG_CONTENT between", value1, value2, "userMsgContent");
            return (Criteria) this;
        }

        public Criteria andUserMsgContentNotBetween(String value1, String value2) {
            addCriterion("USER_MSG_CONTENT not between", value1, value2, "userMsgContent");
            return (Criteria) this;
        }

        public Criteria andUserMsgSendTimeIsNull() {
            addCriterion("USER_MSG_SEND_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUserMsgSendTimeIsNotNull() {
            addCriterion("USER_MSG_SEND_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUserMsgSendTimeEqualTo(Timestamp value) {
            addCriterion("USER_MSG_SEND_TIME =", value, "userMsgSendTime");
            return (Criteria) this;
        }

        public Criteria andUserMsgSendTimeNotEqualTo(Timestamp value) {
            addCriterion("USER_MSG_SEND_TIME <>", value, "userMsgSendTime");
            return (Criteria) this;
        }

        public Criteria andUserMsgSendTimeGreaterThan(Timestamp value) {
            addCriterion("USER_MSG_SEND_TIME >", value, "userMsgSendTime");
            return (Criteria) this;
        }

        public Criteria andUserMsgSendTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("USER_MSG_SEND_TIME >=", value, "userMsgSendTime");
            return (Criteria) this;
        }

        public Criteria andUserMsgSendTimeLessThan(Timestamp value) {
            addCriterion("USER_MSG_SEND_TIME <", value, "userMsgSendTime");
            return (Criteria) this;
        }

        public Criteria andUserMsgSendTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("USER_MSG_SEND_TIME <=", value, "userMsgSendTime");
            return (Criteria) this;
        }

        public Criteria andUserMsgSendTimeIn(List<Timestamp> values) {
            addCriterion("USER_MSG_SEND_TIME in", values, "userMsgSendTime");
            return (Criteria) this;
        }

        public Criteria andUserMsgSendTimeNotIn(List<Timestamp> values) {
            addCriterion("USER_MSG_SEND_TIME not in", values, "userMsgSendTime");
            return (Criteria) this;
        }

        public Criteria andUserMsgSendTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_MSG_SEND_TIME between", value1, value2, "userMsgSendTime");
            return (Criteria) this;
        }

        public Criteria andUserMsgSendTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_MSG_SEND_TIME not between", value1, value2, "userMsgSendTime");
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
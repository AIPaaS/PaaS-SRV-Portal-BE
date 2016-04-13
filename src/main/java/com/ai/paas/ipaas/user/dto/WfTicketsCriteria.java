package com.ai.paas.ipaas.user.dto;

import java.util.ArrayList;
import java.util.List;

public class WfTicketsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public WfTicketsCriteria() {
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

        public Criteria andWfTicketsIdIsNull() {
            addCriterion("WF_TICKETS_ID is null");
            return (Criteria) this;
        }

        public Criteria andWfTicketsIdIsNotNull() {
            addCriterion("WF_TICKETS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWfTicketsIdEqualTo(Long value) {
            addCriterion("WF_TICKETS_ID =", value, "wfTicketsId");
            return (Criteria) this;
        }

        public Criteria andWfTicketsIdNotEqualTo(Long value) {
            addCriterion("WF_TICKETS_ID <>", value, "wfTicketsId");
            return (Criteria) this;
        }

        public Criteria andWfTicketsIdGreaterThan(Long value) {
            addCriterion("WF_TICKETS_ID >", value, "wfTicketsId");
            return (Criteria) this;
        }

        public Criteria andWfTicketsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("WF_TICKETS_ID >=", value, "wfTicketsId");
            return (Criteria) this;
        }

        public Criteria andWfTicketsIdLessThan(Long value) {
            addCriterion("WF_TICKETS_ID <", value, "wfTicketsId");
            return (Criteria) this;
        }

        public Criteria andWfTicketsIdLessThanOrEqualTo(Long value) {
            addCriterion("WF_TICKETS_ID <=", value, "wfTicketsId");
            return (Criteria) this;
        }

        public Criteria andWfTicketsIdIn(List<Long> values) {
            addCriterion("WF_TICKETS_ID in", values, "wfTicketsId");
            return (Criteria) this;
        }

        public Criteria andWfTicketsIdNotIn(List<Long> values) {
            addCriterion("WF_TICKETS_ID not in", values, "wfTicketsId");
            return (Criteria) this;
        }

        public Criteria andWfTicketsIdBetween(Long value1, Long value2) {
            addCriterion("WF_TICKETS_ID between", value1, value2, "wfTicketsId");
            return (Criteria) this;
        }

        public Criteria andWfTicketsIdNotBetween(Long value1, Long value2) {
            addCriterion("WF_TICKETS_ID not between", value1, value2, "wfTicketsId");
            return (Criteria) this;
        }

        public Criteria andWfIdIsNull() {
            addCriterion("WF_ID is null");
            return (Criteria) this;
        }

        public Criteria andWfIdIsNotNull() {
            addCriterion("WF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWfIdEqualTo(String value) {
            addCriterion("WF_ID =", value, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdNotEqualTo(String value) {
            addCriterion("WF_ID <>", value, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdGreaterThan(String value) {
            addCriterion("WF_ID >", value, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdGreaterThanOrEqualTo(String value) {
            addCriterion("WF_ID >=", value, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdLessThan(String value) {
            addCriterion("WF_ID <", value, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdLessThanOrEqualTo(String value) {
            addCriterion("WF_ID <=", value, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdLike(String value) {
            addCriterion("WF_ID like", value, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdNotLike(String value) {
            addCriterion("WF_ID not like", value, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdIn(List<String> values) {
            addCriterion("WF_ID in", values, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdNotIn(List<String> values) {
            addCriterion("WF_ID not in", values, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdBetween(String value1, String value2) {
            addCriterion("WF_ID between", value1, value2, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdNotBetween(String value1, String value2) {
            addCriterion("WF_ID not between", value1, value2, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfNameIsNull() {
            addCriterion("WF_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWfNameIsNotNull() {
            addCriterion("WF_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWfNameEqualTo(String value) {
            addCriterion("WF_NAME =", value, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameNotEqualTo(String value) {
            addCriterion("WF_NAME <>", value, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameGreaterThan(String value) {
            addCriterion("WF_NAME >", value, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameGreaterThanOrEqualTo(String value) {
            addCriterion("WF_NAME >=", value, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameLessThan(String value) {
            addCriterion("WF_NAME <", value, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameLessThanOrEqualTo(String value) {
            addCriterion("WF_NAME <=", value, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameLike(String value) {
            addCriterion("WF_NAME like", value, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameNotLike(String value) {
            addCriterion("WF_NAME not like", value, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameIn(List<String> values) {
            addCriterion("WF_NAME in", values, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameNotIn(List<String> values) {
            addCriterion("WF_NAME not in", values, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameBetween(String value1, String value2) {
            addCriterion("WF_NAME between", value1, value2, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameNotBetween(String value1, String value2) {
            addCriterion("WF_NAME not between", value1, value2, "wfName");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIsNull() {
            addCriterion("TICKET_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIsNotNull() {
            addCriterion("TICKET_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTicketTypeEqualTo(String value) {
            addCriterion("TICKET_TYPE =", value, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNotEqualTo(String value) {
            addCriterion("TICKET_TYPE <>", value, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeGreaterThan(String value) {
            addCriterion("TICKET_TYPE >", value, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TICKET_TYPE >=", value, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeLessThan(String value) {
            addCriterion("TICKET_TYPE <", value, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeLessThanOrEqualTo(String value) {
            addCriterion("TICKET_TYPE <=", value, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeLike(String value) {
            addCriterion("TICKET_TYPE like", value, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNotLike(String value) {
            addCriterion("TICKET_TYPE not like", value, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIn(List<String> values) {
            addCriterion("TICKET_TYPE in", values, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNotIn(List<String> values) {
            addCriterion("TICKET_TYPE not in", values, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeBetween(String value1, String value2) {
            addCriterion("TICKET_TYPE between", value1, value2, "ticketType");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNotBetween(String value1, String value2) {
            addCriterion("TICKET_TYPE not between", value1, value2, "ticketType");
            return (Criteria) this;
        }

        public Criteria andVaildFlagIsNull() {
            addCriterion("VAILD_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andVaildFlagIsNotNull() {
            addCriterion("VAILD_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andVaildFlagEqualTo(String value) {
            addCriterion("VAILD_FLAG =", value, "vaildFlag");
            return (Criteria) this;
        }

        public Criteria andVaildFlagNotEqualTo(String value) {
            addCriterion("VAILD_FLAG <>", value, "vaildFlag");
            return (Criteria) this;
        }

        public Criteria andVaildFlagGreaterThan(String value) {
            addCriterion("VAILD_FLAG >", value, "vaildFlag");
            return (Criteria) this;
        }

        public Criteria andVaildFlagGreaterThanOrEqualTo(String value) {
            addCriterion("VAILD_FLAG >=", value, "vaildFlag");
            return (Criteria) this;
        }

        public Criteria andVaildFlagLessThan(String value) {
            addCriterion("VAILD_FLAG <", value, "vaildFlag");
            return (Criteria) this;
        }

        public Criteria andVaildFlagLessThanOrEqualTo(String value) {
            addCriterion("VAILD_FLAG <=", value, "vaildFlag");
            return (Criteria) this;
        }

        public Criteria andVaildFlagLike(String value) {
            addCriterion("VAILD_FLAG like", value, "vaildFlag");
            return (Criteria) this;
        }

        public Criteria andVaildFlagNotLike(String value) {
            addCriterion("VAILD_FLAG not like", value, "vaildFlag");
            return (Criteria) this;
        }

        public Criteria andVaildFlagIn(List<String> values) {
            addCriterion("VAILD_FLAG in", values, "vaildFlag");
            return (Criteria) this;
        }

        public Criteria andVaildFlagNotIn(List<String> values) {
            addCriterion("VAILD_FLAG not in", values, "vaildFlag");
            return (Criteria) this;
        }

        public Criteria andVaildFlagBetween(String value1, String value2) {
            addCriterion("VAILD_FLAG between", value1, value2, "vaildFlag");
            return (Criteria) this;
        }

        public Criteria andVaildFlagNotBetween(String value1, String value2) {
            addCriterion("VAILD_FLAG not between", value1, value2, "vaildFlag");
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
package com.ai.paas.ipaas.user.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderWoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrderWoCriteria() {
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

        public Criteria andOrderWoIdIsNull() {
            addCriterion("ORDER_WO_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderWoIdIsNotNull() {
            addCriterion("ORDER_WO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderWoIdEqualTo(Long value) {
            addCriterion("ORDER_WO_ID =", value, "orderWoId");
            return (Criteria) this;
        }

        public Criteria andOrderWoIdNotEqualTo(Long value) {
            addCriterion("ORDER_WO_ID <>", value, "orderWoId");
            return (Criteria) this;
        }

        public Criteria andOrderWoIdGreaterThan(Long value) {
            addCriterion("ORDER_WO_ID >", value, "orderWoId");
            return (Criteria) this;
        }

        public Criteria andOrderWoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ORDER_WO_ID >=", value, "orderWoId");
            return (Criteria) this;
        }

        public Criteria andOrderWoIdLessThan(Long value) {
            addCriterion("ORDER_WO_ID <", value, "orderWoId");
            return (Criteria) this;
        }

        public Criteria andOrderWoIdLessThanOrEqualTo(Long value) {
            addCriterion("ORDER_WO_ID <=", value, "orderWoId");
            return (Criteria) this;
        }

        public Criteria andOrderWoIdIn(List<Long> values) {
            addCriterion("ORDER_WO_ID in", values, "orderWoId");
            return (Criteria) this;
        }

        public Criteria andOrderWoIdNotIn(List<Long> values) {
            addCriterion("ORDER_WO_ID not in", values, "orderWoId");
            return (Criteria) this;
        }

        public Criteria andOrderWoIdBetween(Long value1, Long value2) {
            addCriterion("ORDER_WO_ID between", value1, value2, "orderWoId");
            return (Criteria) this;
        }

        public Criteria andOrderWoIdNotBetween(Long value1, Long value2) {
            addCriterion("ORDER_WO_ID not between", value1, value2, "orderWoId");
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

        public Criteria andWfTaskIdIsNull() {
            addCriterion("WF_TASK_ID is null");
            return (Criteria) this;
        }

        public Criteria andWfTaskIdIsNotNull() {
            addCriterion("WF_TASK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWfTaskIdEqualTo(String value) {
            addCriterion("WF_TASK_ID =", value, "wfTaskId");
            return (Criteria) this;
        }

        public Criteria andWfTaskIdNotEqualTo(String value) {
            addCriterion("WF_TASK_ID <>", value, "wfTaskId");
            return (Criteria) this;
        }

        public Criteria andWfTaskIdGreaterThan(String value) {
            addCriterion("WF_TASK_ID >", value, "wfTaskId");
            return (Criteria) this;
        }

        public Criteria andWfTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("WF_TASK_ID >=", value, "wfTaskId");
            return (Criteria) this;
        }

        public Criteria andWfTaskIdLessThan(String value) {
            addCriterion("WF_TASK_ID <", value, "wfTaskId");
            return (Criteria) this;
        }

        public Criteria andWfTaskIdLessThanOrEqualTo(String value) {
            addCriterion("WF_TASK_ID <=", value, "wfTaskId");
            return (Criteria) this;
        }

        public Criteria andWfTaskIdLike(String value) {
            addCriterion("WF_TASK_ID like", value, "wfTaskId");
            return (Criteria) this;
        }

        public Criteria andWfTaskIdNotLike(String value) {
            addCriterion("WF_TASK_ID not like", value, "wfTaskId");
            return (Criteria) this;
        }

        public Criteria andWfTaskIdIn(List<String> values) {
            addCriterion("WF_TASK_ID in", values, "wfTaskId");
            return (Criteria) this;
        }

        public Criteria andWfTaskIdNotIn(List<String> values) {
            addCriterion("WF_TASK_ID not in", values, "wfTaskId");
            return (Criteria) this;
        }

        public Criteria andWfTaskIdBetween(String value1, String value2) {
            addCriterion("WF_TASK_ID between", value1, value2, "wfTaskId");
            return (Criteria) this;
        }

        public Criteria andWfTaskIdNotBetween(String value1, String value2) {
            addCriterion("WF_TASK_ID not between", value1, value2, "wfTaskId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("ROLE_ID =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("ROLE_ID <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("ROLE_ID >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_ID >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(String value) {
            addCriterion("ROLE_ID <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("ROLE_ID <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLike(String value) {
            addCriterion("ROLE_ID like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLike(String value) {
            addCriterion("ROLE_ID not like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("ROLE_ID in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("ROLE_ID not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("ROLE_ID between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("ROLE_ID not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andOperateIdIsNull() {
            addCriterion("OPERATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperateIdIsNotNull() {
            addCriterion("OPERATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperateIdEqualTo(String value) {
            addCriterion("OPERATE_ID =", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotEqualTo(String value) {
            addCriterion("OPERATE_ID <>", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdGreaterThan(String value) {
            addCriterion("OPERATE_ID >", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATE_ID >=", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdLessThan(String value) {
            addCriterion("OPERATE_ID <", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdLessThanOrEqualTo(String value) {
            addCriterion("OPERATE_ID <=", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdLike(String value) {
            addCriterion("OPERATE_ID like", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotLike(String value) {
            addCriterion("OPERATE_ID not like", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdIn(List<String> values) {
            addCriterion("OPERATE_ID in", values, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotIn(List<String> values) {
            addCriterion("OPERATE_ID not in", values, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdBetween(String value1, String value2) {
            addCriterion("OPERATE_ID between", value1, value2, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotBetween(String value1, String value2) {
            addCriterion("OPERATE_ID not between", value1, value2, "operateId");
            return (Criteria) this;
        }

        public Criteria andWoCreateDateIsNull() {
            addCriterion("WO_CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andWoCreateDateIsNotNull() {
            addCriterion("WO_CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andWoCreateDateEqualTo(Timestamp value) {
            addCriterion("WO_CREATE_DATE =", value, "woCreateDate");
            return (Criteria) this;
        }

        public Criteria andWoCreateDateNotEqualTo(Timestamp value) {
            addCriterion("WO_CREATE_DATE <>", value, "woCreateDate");
            return (Criteria) this;
        }

        public Criteria andWoCreateDateGreaterThan(Timestamp value) {
            addCriterion("WO_CREATE_DATE >", value, "woCreateDate");
            return (Criteria) this;
        }

        public Criteria andWoCreateDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("WO_CREATE_DATE >=", value, "woCreateDate");
            return (Criteria) this;
        }

        public Criteria andWoCreateDateLessThan(Timestamp value) {
            addCriterion("WO_CREATE_DATE <", value, "woCreateDate");
            return (Criteria) this;
        }

        public Criteria andWoCreateDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("WO_CREATE_DATE <=", value, "woCreateDate");
            return (Criteria) this;
        }

        public Criteria andWoCreateDateIn(List<Timestamp> values) {
            addCriterion("WO_CREATE_DATE in", values, "woCreateDate");
            return (Criteria) this;
        }

        public Criteria andWoCreateDateNotIn(List<Timestamp> values) {
            addCriterion("WO_CREATE_DATE not in", values, "woCreateDate");
            return (Criteria) this;
        }

        public Criteria andWoCreateDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("WO_CREATE_DATE between", value1, value2, "woCreateDate");
            return (Criteria) this;
        }

        public Criteria andWoCreateDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("WO_CREATE_DATE not between", value1, value2, "woCreateDate");
            return (Criteria) this;
        }

        public Criteria andWoStatusIsNull() {
            addCriterion("WO_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andWoStatusIsNotNull() {
            addCriterion("WO_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andWoStatusEqualTo(String value) {
            addCriterion("WO_STATUS =", value, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusNotEqualTo(String value) {
            addCriterion("WO_STATUS <>", value, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusGreaterThan(String value) {
            addCriterion("WO_STATUS >", value, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusGreaterThanOrEqualTo(String value) {
            addCriterion("WO_STATUS >=", value, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusLessThan(String value) {
            addCriterion("WO_STATUS <", value, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusLessThanOrEqualTo(String value) {
            addCriterion("WO_STATUS <=", value, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusLike(String value) {
            addCriterion("WO_STATUS like", value, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusNotLike(String value) {
            addCriterion("WO_STATUS not like", value, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusIn(List<String> values) {
            addCriterion("WO_STATUS in", values, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusNotIn(List<String> values) {
            addCriterion("WO_STATUS not in", values, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusBetween(String value1, String value2) {
            addCriterion("WO_STATUS between", value1, value2, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusNotBetween(String value1, String value2) {
            addCriterion("WO_STATUS not between", value1, value2, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoDescIsNull() {
            addCriterion("WO_DESC is null");
            return (Criteria) this;
        }

        public Criteria andWoDescIsNotNull() {
            addCriterion("WO_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andWoDescEqualTo(String value) {
            addCriterion("WO_DESC =", value, "woDesc");
            return (Criteria) this;
        }

        public Criteria andWoDescNotEqualTo(String value) {
            addCriterion("WO_DESC <>", value, "woDesc");
            return (Criteria) this;
        }

        public Criteria andWoDescGreaterThan(String value) {
            addCriterion("WO_DESC >", value, "woDesc");
            return (Criteria) this;
        }

        public Criteria andWoDescGreaterThanOrEqualTo(String value) {
            addCriterion("WO_DESC >=", value, "woDesc");
            return (Criteria) this;
        }

        public Criteria andWoDescLessThan(String value) {
            addCriterion("WO_DESC <", value, "woDesc");
            return (Criteria) this;
        }

        public Criteria andWoDescLessThanOrEqualTo(String value) {
            addCriterion("WO_DESC <=", value, "woDesc");
            return (Criteria) this;
        }

        public Criteria andWoDescLike(String value) {
            addCriterion("WO_DESC like", value, "woDesc");
            return (Criteria) this;
        }

        public Criteria andWoDescNotLike(String value) {
            addCriterion("WO_DESC not like", value, "woDesc");
            return (Criteria) this;
        }

        public Criteria andWoDescIn(List<String> values) {
            addCriterion("WO_DESC in", values, "woDesc");
            return (Criteria) this;
        }

        public Criteria andWoDescNotIn(List<String> values) {
            addCriterion("WO_DESC not in", values, "woDesc");
            return (Criteria) this;
        }

        public Criteria andWoDescBetween(String value1, String value2) {
            addCriterion("WO_DESC between", value1, value2, "woDesc");
            return (Criteria) this;
        }

        public Criteria andWoDescNotBetween(String value1, String value2) {
            addCriterion("WO_DESC not between", value1, value2, "woDesc");
            return (Criteria) this;
        }

        public Criteria andWoDateIsNull() {
            addCriterion("WO_DATE is null");
            return (Criteria) this;
        }

        public Criteria andWoDateIsNotNull() {
            addCriterion("WO_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andWoDateEqualTo(Timestamp value) {
            addCriterion("WO_DATE =", value, "woDate");
            return (Criteria) this;
        }

        public Criteria andWoDateNotEqualTo(Timestamp value) {
            addCriterion("WO_DATE <>", value, "woDate");
            return (Criteria) this;
        }

        public Criteria andWoDateGreaterThan(Timestamp value) {
            addCriterion("WO_DATE >", value, "woDate");
            return (Criteria) this;
        }

        public Criteria andWoDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("WO_DATE >=", value, "woDate");
            return (Criteria) this;
        }

        public Criteria andWoDateLessThan(Timestamp value) {
            addCriterion("WO_DATE <", value, "woDate");
            return (Criteria) this;
        }

        public Criteria andWoDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("WO_DATE <=", value, "woDate");
            return (Criteria) this;
        }

        public Criteria andWoDateIn(List<Timestamp> values) {
            addCriterion("WO_DATE in", values, "woDate");
            return (Criteria) this;
        }

        public Criteria andWoDateNotIn(List<Timestamp> values) {
            addCriterion("WO_DATE not in", values, "woDate");
            return (Criteria) this;
        }

        public Criteria andWoDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("WO_DATE between", value1, value2, "woDate");
            return (Criteria) this;
        }

        public Criteria andWoDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("WO_DATE not between", value1, value2, "woDate");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagIsNull() {
            addCriterion("DISPLAY_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagIsNotNull() {
            addCriterion("DISPLAY_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagEqualTo(String value) {
            addCriterion("DISPLAY_FLAG =", value, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagNotEqualTo(String value) {
            addCriterion("DISPLAY_FLAG <>", value, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagGreaterThan(String value) {
            addCriterion("DISPLAY_FLAG >", value, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagGreaterThanOrEqualTo(String value) {
            addCriterion("DISPLAY_FLAG >=", value, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagLessThan(String value) {
            addCriterion("DISPLAY_FLAG <", value, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagLessThanOrEqualTo(String value) {
            addCriterion("DISPLAY_FLAG <=", value, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagLike(String value) {
            addCriterion("DISPLAY_FLAG like", value, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagNotLike(String value) {
            addCriterion("DISPLAY_FLAG not like", value, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagIn(List<String> values) {
            addCriterion("DISPLAY_FLAG in", values, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagNotIn(List<String> values) {
            addCriterion("DISPLAY_FLAG not in", values, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagBetween(String value1, String value2) {
            addCriterion("DISPLAY_FLAG between", value1, value2, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagNotBetween(String value1, String value2) {
            addCriterion("DISPLAY_FLAG not between", value1, value2, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andWoResultIsNull() {
            addCriterion("WO_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andWoResultIsNotNull() {
            addCriterion("WO_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andWoResultEqualTo(String value) {
            addCriterion("WO_RESULT =", value, "woResult");
            return (Criteria) this;
        }

        public Criteria andWoResultNotEqualTo(String value) {
            addCriterion("WO_RESULT <>", value, "woResult");
            return (Criteria) this;
        }

        public Criteria andWoResultGreaterThan(String value) {
            addCriterion("WO_RESULT >", value, "woResult");
            return (Criteria) this;
        }

        public Criteria andWoResultGreaterThanOrEqualTo(String value) {
            addCriterion("WO_RESULT >=", value, "woResult");
            return (Criteria) this;
        }

        public Criteria andWoResultLessThan(String value) {
            addCriterion("WO_RESULT <", value, "woResult");
            return (Criteria) this;
        }

        public Criteria andWoResultLessThanOrEqualTo(String value) {
            addCriterion("WO_RESULT <=", value, "woResult");
            return (Criteria) this;
        }

        public Criteria andWoResultLike(String value) {
            addCriterion("WO_RESULT like", value, "woResult");
            return (Criteria) this;
        }

        public Criteria andWoResultNotLike(String value) {
            addCriterion("WO_RESULT not like", value, "woResult");
            return (Criteria) this;
        }

        public Criteria andWoResultIn(List<String> values) {
            addCriterion("WO_RESULT in", values, "woResult");
            return (Criteria) this;
        }

        public Criteria andWoResultNotIn(List<String> values) {
            addCriterion("WO_RESULT not in", values, "woResult");
            return (Criteria) this;
        }

        public Criteria andWoResultBetween(String value1, String value2) {
            addCriterion("WO_RESULT between", value1, value2, "woResult");
            return (Criteria) this;
        }

        public Criteria andWoResultNotBetween(String value1, String value2) {
            addCriterion("WO_RESULT not between", value1, value2, "woResult");
            return (Criteria) this;
        }

        public Criteria andReceiptUrlIsNull() {
            addCriterion("RECEIPT_URL is null");
            return (Criteria) this;
        }

        public Criteria andReceiptUrlIsNotNull() {
            addCriterion("RECEIPT_URL is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptUrlEqualTo(String value) {
            addCriterion("RECEIPT_URL =", value, "receiptUrl");
            return (Criteria) this;
        }

        public Criteria andReceiptUrlNotEqualTo(String value) {
            addCriterion("RECEIPT_URL <>", value, "receiptUrl");
            return (Criteria) this;
        }

        public Criteria andReceiptUrlGreaterThan(String value) {
            addCriterion("RECEIPT_URL >", value, "receiptUrl");
            return (Criteria) this;
        }

        public Criteria andReceiptUrlGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIPT_URL >=", value, "receiptUrl");
            return (Criteria) this;
        }

        public Criteria andReceiptUrlLessThan(String value) {
            addCriterion("RECEIPT_URL <", value, "receiptUrl");
            return (Criteria) this;
        }

        public Criteria andReceiptUrlLessThanOrEqualTo(String value) {
            addCriterion("RECEIPT_URL <=", value, "receiptUrl");
            return (Criteria) this;
        }

        public Criteria andReceiptUrlLike(String value) {
            addCriterion("RECEIPT_URL like", value, "receiptUrl");
            return (Criteria) this;
        }

        public Criteria andReceiptUrlNotLike(String value) {
            addCriterion("RECEIPT_URL not like", value, "receiptUrl");
            return (Criteria) this;
        }

        public Criteria andReceiptUrlIn(List<String> values) {
            addCriterion("RECEIPT_URL in", values, "receiptUrl");
            return (Criteria) this;
        }

        public Criteria andReceiptUrlNotIn(List<String> values) {
            addCriterion("RECEIPT_URL not in", values, "receiptUrl");
            return (Criteria) this;
        }

        public Criteria andReceiptUrlBetween(String value1, String value2) {
            addCriterion("RECEIPT_URL between", value1, value2, "receiptUrl");
            return (Criteria) this;
        }

        public Criteria andReceiptUrlNotBetween(String value1, String value2) {
            addCriterion("RECEIPT_URL not between", value1, value2, "receiptUrl");
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
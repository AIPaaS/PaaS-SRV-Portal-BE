package com.ai.paas.ipaas.user.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserMgrOperateCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public UserMgrOperateCriteria() {
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

        public Criteria andUserOperateIdIsNull() {
            addCriterion("USER_OPERATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserOperateIdIsNotNull() {
            addCriterion("USER_OPERATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserOperateIdEqualTo(Long value) {
            addCriterion("USER_OPERATE_ID =", value, "userOperateId");
            return (Criteria) this;
        }

        public Criteria andUserOperateIdNotEqualTo(Long value) {
            addCriterion("USER_OPERATE_ID <>", value, "userOperateId");
            return (Criteria) this;
        }

        public Criteria andUserOperateIdGreaterThan(Long value) {
            addCriterion("USER_OPERATE_ID >", value, "userOperateId");
            return (Criteria) this;
        }

        public Criteria andUserOperateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_OPERATE_ID >=", value, "userOperateId");
            return (Criteria) this;
        }

        public Criteria andUserOperateIdLessThan(Long value) {
            addCriterion("USER_OPERATE_ID <", value, "userOperateId");
            return (Criteria) this;
        }

        public Criteria andUserOperateIdLessThanOrEqualTo(Long value) {
            addCriterion("USER_OPERATE_ID <=", value, "userOperateId");
            return (Criteria) this;
        }

        public Criteria andUserOperateIdIn(List<Long> values) {
            addCriterion("USER_OPERATE_ID in", values, "userOperateId");
            return (Criteria) this;
        }

        public Criteria andUserOperateIdNotIn(List<Long> values) {
            addCriterion("USER_OPERATE_ID not in", values, "userOperateId");
            return (Criteria) this;
        }

        public Criteria andUserOperateIdBetween(Long value1, Long value2) {
            addCriterion("USER_OPERATE_ID between", value1, value2, "userOperateId");
            return (Criteria) this;
        }

        public Criteria andUserOperateIdNotBetween(Long value1, Long value2) {
            addCriterion("USER_OPERATE_ID not between", value1, value2, "userOperateId");
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

        public Criteria andUserProdTypeIsNull() {
            addCriterion("USER_PROD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUserProdTypeIsNotNull() {
            addCriterion("USER_PROD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUserProdTypeEqualTo(String value) {
            addCriterion("USER_PROD_TYPE =", value, "userProdType");
            return (Criteria) this;
        }

        public Criteria andUserProdTypeNotEqualTo(String value) {
            addCriterion("USER_PROD_TYPE <>", value, "userProdType");
            return (Criteria) this;
        }

        public Criteria andUserProdTypeGreaterThan(String value) {
            addCriterion("USER_PROD_TYPE >", value, "userProdType");
            return (Criteria) this;
        }

        public Criteria andUserProdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PROD_TYPE >=", value, "userProdType");
            return (Criteria) this;
        }

        public Criteria andUserProdTypeLessThan(String value) {
            addCriterion("USER_PROD_TYPE <", value, "userProdType");
            return (Criteria) this;
        }

        public Criteria andUserProdTypeLessThanOrEqualTo(String value) {
            addCriterion("USER_PROD_TYPE <=", value, "userProdType");
            return (Criteria) this;
        }

        public Criteria andUserProdTypeLike(String value) {
            addCriterion("USER_PROD_TYPE like", value, "userProdType");
            return (Criteria) this;
        }

        public Criteria andUserProdTypeNotLike(String value) {
            addCriterion("USER_PROD_TYPE not like", value, "userProdType");
            return (Criteria) this;
        }

        public Criteria andUserProdTypeIn(List<String> values) {
            addCriterion("USER_PROD_TYPE in", values, "userProdType");
            return (Criteria) this;
        }

        public Criteria andUserProdTypeNotIn(List<String> values) {
            addCriterion("USER_PROD_TYPE not in", values, "userProdType");
            return (Criteria) this;
        }

        public Criteria andUserProdTypeBetween(String value1, String value2) {
            addCriterion("USER_PROD_TYPE between", value1, value2, "userProdType");
            return (Criteria) this;
        }

        public Criteria andUserProdTypeNotBetween(String value1, String value2) {
            addCriterion("USER_PROD_TYPE not between", value1, value2, "userProdType");
            return (Criteria) this;
        }

        public Criteria andUserProdIdIsNull() {
            addCriterion("USER_PROD_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserProdIdIsNotNull() {
            addCriterion("USER_PROD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserProdIdEqualTo(String value) {
            addCriterion("USER_PROD_ID =", value, "userProdId");
            return (Criteria) this;
        }

        public Criteria andUserProdIdNotEqualTo(String value) {
            addCriterion("USER_PROD_ID <>", value, "userProdId");
            return (Criteria) this;
        }

        public Criteria andUserProdIdGreaterThan(String value) {
            addCriterion("USER_PROD_ID >", value, "userProdId");
            return (Criteria) this;
        }

        public Criteria andUserProdIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PROD_ID >=", value, "userProdId");
            return (Criteria) this;
        }

        public Criteria andUserProdIdLessThan(String value) {
            addCriterion("USER_PROD_ID <", value, "userProdId");
            return (Criteria) this;
        }

        public Criteria andUserProdIdLessThanOrEqualTo(String value) {
            addCriterion("USER_PROD_ID <=", value, "userProdId");
            return (Criteria) this;
        }

        public Criteria andUserProdIdLike(String value) {
            addCriterion("USER_PROD_ID like", value, "userProdId");
            return (Criteria) this;
        }

        public Criteria andUserProdIdNotLike(String value) {
            addCriterion("USER_PROD_ID not like", value, "userProdId");
            return (Criteria) this;
        }

        public Criteria andUserProdIdIn(List<String> values) {
            addCriterion("USER_PROD_ID in", values, "userProdId");
            return (Criteria) this;
        }

        public Criteria andUserProdIdNotIn(List<String> values) {
            addCriterion("USER_PROD_ID not in", values, "userProdId");
            return (Criteria) this;
        }

        public Criteria andUserProdIdBetween(String value1, String value2) {
            addCriterion("USER_PROD_ID between", value1, value2, "userProdId");
            return (Criteria) this;
        }

        public Criteria andUserProdIdNotBetween(String value1, String value2) {
            addCriterion("USER_PROD_ID not between", value1, value2, "userProdId");
            return (Criteria) this;
        }

        public Criteria andUserServIdIsNull() {
            addCriterion("USER_SERV_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserServIdIsNotNull() {
            addCriterion("USER_SERV_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserServIdEqualTo(String value) {
            addCriterion("USER_SERV_ID =", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdNotEqualTo(String value) {
            addCriterion("USER_SERV_ID <>", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdGreaterThan(String value) {
            addCriterion("USER_SERV_ID >", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_SERV_ID >=", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdLessThan(String value) {
            addCriterion("USER_SERV_ID <", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdLessThanOrEqualTo(String value) {
            addCriterion("USER_SERV_ID <=", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdLike(String value) {
            addCriterion("USER_SERV_ID like", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdNotLike(String value) {
            addCriterion("USER_SERV_ID not like", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdIn(List<String> values) {
            addCriterion("USER_SERV_ID in", values, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdNotIn(List<String> values) {
            addCriterion("USER_SERV_ID not in", values, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdBetween(String value1, String value2) {
            addCriterion("USER_SERV_ID between", value1, value2, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdNotBetween(String value1, String value2) {
            addCriterion("USER_SERV_ID not between", value1, value2, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdIsNull() {
            addCriterion("USER_SERV_IPAAS_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdIsNotNull() {
            addCriterion("USER_SERV_IPAAS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdEqualTo(String value) {
            addCriterion("USER_SERV_IPAAS_ID =", value, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdNotEqualTo(String value) {
            addCriterion("USER_SERV_IPAAS_ID <>", value, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdGreaterThan(String value) {
            addCriterion("USER_SERV_IPAAS_ID >", value, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_SERV_IPAAS_ID >=", value, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdLessThan(String value) {
            addCriterion("USER_SERV_IPAAS_ID <", value, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdLessThanOrEqualTo(String value) {
            addCriterion("USER_SERV_IPAAS_ID <=", value, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdLike(String value) {
            addCriterion("USER_SERV_IPAAS_ID like", value, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdNotLike(String value) {
            addCriterion("USER_SERV_IPAAS_ID not like", value, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdIn(List<String> values) {
            addCriterion("USER_SERV_IPAAS_ID in", values, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdNotIn(List<String> values) {
            addCriterion("USER_SERV_IPAAS_ID not in", values, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdBetween(String value1, String value2) {
            addCriterion("USER_SERV_IPAAS_ID between", value1, value2, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserServIpaasIdNotBetween(String value1, String value2) {
            addCriterion("USER_SERV_IPAAS_ID not between", value1, value2, "userServIpaasId");
            return (Criteria) this;
        }

        public Criteria andUserProdParamIsNull() {
            addCriterion("USER_PROD_PARAM is null");
            return (Criteria) this;
        }

        public Criteria andUserProdParamIsNotNull() {
            addCriterion("USER_PROD_PARAM is not null");
            return (Criteria) this;
        }

        public Criteria andUserProdParamEqualTo(String value) {
            addCriterion("USER_PROD_PARAM =", value, "userProdParam");
            return (Criteria) this;
        }

        public Criteria andUserProdParamNotEqualTo(String value) {
            addCriterion("USER_PROD_PARAM <>", value, "userProdParam");
            return (Criteria) this;
        }

        public Criteria andUserProdParamGreaterThan(String value) {
            addCriterion("USER_PROD_PARAM >", value, "userProdParam");
            return (Criteria) this;
        }

        public Criteria andUserProdParamGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PROD_PARAM >=", value, "userProdParam");
            return (Criteria) this;
        }

        public Criteria andUserProdParamLessThan(String value) {
            addCriterion("USER_PROD_PARAM <", value, "userProdParam");
            return (Criteria) this;
        }

        public Criteria andUserProdParamLessThanOrEqualTo(String value) {
            addCriterion("USER_PROD_PARAM <=", value, "userProdParam");
            return (Criteria) this;
        }

        public Criteria andUserProdParamLike(String value) {
            addCriterion("USER_PROD_PARAM like", value, "userProdParam");
            return (Criteria) this;
        }

        public Criteria andUserProdParamNotLike(String value) {
            addCriterion("USER_PROD_PARAM not like", value, "userProdParam");
            return (Criteria) this;
        }

        public Criteria andUserProdParamIn(List<String> values) {
            addCriterion("USER_PROD_PARAM in", values, "userProdParam");
            return (Criteria) this;
        }

        public Criteria andUserProdParamNotIn(List<String> values) {
            addCriterion("USER_PROD_PARAM not in", values, "userProdParam");
            return (Criteria) this;
        }

        public Criteria andUserProdParamBetween(String value1, String value2) {
            addCriterion("USER_PROD_PARAM between", value1, value2, "userProdParam");
            return (Criteria) this;
        }

        public Criteria andUserProdParamNotBetween(String value1, String value2) {
            addCriterion("USER_PROD_PARAM not between", value1, value2, "userProdParam");
            return (Criteria) this;
        }

        public Criteria andUserProdBynameIsNull() {
            addCriterion("USER_PROD_BYNAME is null");
            return (Criteria) this;
        }

        public Criteria andUserProdBynameIsNotNull() {
            addCriterion("USER_PROD_BYNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserProdBynameEqualTo(String value) {
            addCriterion("USER_PROD_BYNAME =", value, "userProdByname");
            return (Criteria) this;
        }

        public Criteria andUserProdBynameNotEqualTo(String value) {
            addCriterion("USER_PROD_BYNAME <>", value, "userProdByname");
            return (Criteria) this;
        }

        public Criteria andUserProdBynameGreaterThan(String value) {
            addCriterion("USER_PROD_BYNAME >", value, "userProdByname");
            return (Criteria) this;
        }

        public Criteria andUserProdBynameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PROD_BYNAME >=", value, "userProdByname");
            return (Criteria) this;
        }

        public Criteria andUserProdBynameLessThan(String value) {
            addCriterion("USER_PROD_BYNAME <", value, "userProdByname");
            return (Criteria) this;
        }

        public Criteria andUserProdBynameLessThanOrEqualTo(String value) {
            addCriterion("USER_PROD_BYNAME <=", value, "userProdByname");
            return (Criteria) this;
        }

        public Criteria andUserProdBynameLike(String value) {
            addCriterion("USER_PROD_BYNAME like", value, "userProdByname");
            return (Criteria) this;
        }

        public Criteria andUserProdBynameNotLike(String value) {
            addCriterion("USER_PROD_BYNAME not like", value, "userProdByname");
            return (Criteria) this;
        }

        public Criteria andUserProdBynameIn(List<String> values) {
            addCriterion("USER_PROD_BYNAME in", values, "userProdByname");
            return (Criteria) this;
        }

        public Criteria andUserProdBynameNotIn(List<String> values) {
            addCriterion("USER_PROD_BYNAME not in", values, "userProdByname");
            return (Criteria) this;
        }

        public Criteria andUserProdBynameBetween(String value1, String value2) {
            addCriterion("USER_PROD_BYNAME between", value1, value2, "userProdByname");
            return (Criteria) this;
        }

        public Criteria andUserProdBynameNotBetween(String value1, String value2) {
            addCriterion("USER_PROD_BYNAME not between", value1, value2, "userProdByname");
            return (Criteria) this;
        }

        public Criteria andUserOperateActionIsNull() {
            addCriterion("USER_OPERATE_ACTION is null");
            return (Criteria) this;
        }

        public Criteria andUserOperateActionIsNotNull() {
            addCriterion("USER_OPERATE_ACTION is not null");
            return (Criteria) this;
        }

        public Criteria andUserOperateActionEqualTo(String value) {
            addCriterion("USER_OPERATE_ACTION =", value, "userOperateAction");
            return (Criteria) this;
        }

        public Criteria andUserOperateActionNotEqualTo(String value) {
            addCriterion("USER_OPERATE_ACTION <>", value, "userOperateAction");
            return (Criteria) this;
        }

        public Criteria andUserOperateActionGreaterThan(String value) {
            addCriterion("USER_OPERATE_ACTION >", value, "userOperateAction");
            return (Criteria) this;
        }

        public Criteria andUserOperateActionGreaterThanOrEqualTo(String value) {
            addCriterion("USER_OPERATE_ACTION >=", value, "userOperateAction");
            return (Criteria) this;
        }

        public Criteria andUserOperateActionLessThan(String value) {
            addCriterion("USER_OPERATE_ACTION <", value, "userOperateAction");
            return (Criteria) this;
        }

        public Criteria andUserOperateActionLessThanOrEqualTo(String value) {
            addCriterion("USER_OPERATE_ACTION <=", value, "userOperateAction");
            return (Criteria) this;
        }

        public Criteria andUserOperateActionLike(String value) {
            addCriterion("USER_OPERATE_ACTION like", value, "userOperateAction");
            return (Criteria) this;
        }

        public Criteria andUserOperateActionNotLike(String value) {
            addCriterion("USER_OPERATE_ACTION not like", value, "userOperateAction");
            return (Criteria) this;
        }

        public Criteria andUserOperateActionIn(List<String> values) {
            addCriterion("USER_OPERATE_ACTION in", values, "userOperateAction");
            return (Criteria) this;
        }

        public Criteria andUserOperateActionNotIn(List<String> values) {
            addCriterion("USER_OPERATE_ACTION not in", values, "userOperateAction");
            return (Criteria) this;
        }

        public Criteria andUserOperateActionBetween(String value1, String value2) {
            addCriterion("USER_OPERATE_ACTION between", value1, value2, "userOperateAction");
            return (Criteria) this;
        }

        public Criteria andUserOperateActionNotBetween(String value1, String value2) {
            addCriterion("USER_OPERATE_ACTION not between", value1, value2, "userOperateAction");
            return (Criteria) this;
        }

        public Criteria andUserOperateDateIsNull() {
            addCriterion("USER_OPERATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUserOperateDateIsNotNull() {
            addCriterion("USER_OPERATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUserOperateDateEqualTo(Timestamp value) {
            addCriterion("USER_OPERATE_DATE =", value, "userOperateDate");
            return (Criteria) this;
        }

        public Criteria andUserOperateDateNotEqualTo(Timestamp value) {
            addCriterion("USER_OPERATE_DATE <>", value, "userOperateDate");
            return (Criteria) this;
        }

        public Criteria andUserOperateDateGreaterThan(Timestamp value) {
            addCriterion("USER_OPERATE_DATE >", value, "userOperateDate");
            return (Criteria) this;
        }

        public Criteria andUserOperateDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("USER_OPERATE_DATE >=", value, "userOperateDate");
            return (Criteria) this;
        }

        public Criteria andUserOperateDateLessThan(Timestamp value) {
            addCriterion("USER_OPERATE_DATE <", value, "userOperateDate");
            return (Criteria) this;
        }

        public Criteria andUserOperateDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("USER_OPERATE_DATE <=", value, "userOperateDate");
            return (Criteria) this;
        }

        public Criteria andUserOperateDateIn(List<Timestamp> values) {
            addCriterion("USER_OPERATE_DATE in", values, "userOperateDate");
            return (Criteria) this;
        }

        public Criteria andUserOperateDateNotIn(List<Timestamp> values) {
            addCriterion("USER_OPERATE_DATE not in", values, "userOperateDate");
            return (Criteria) this;
        }

        public Criteria andUserOperateDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_OPERATE_DATE between", value1, value2, "userOperateDate");
            return (Criteria) this;
        }

        public Criteria andUserOperateDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_OPERATE_DATE not between", value1, value2, "userOperateDate");
            return (Criteria) this;
        }

        public Criteria andUserUpdateBeforeIsNull() {
            addCriterion("USER_UPDATE_BEFORE is null");
            return (Criteria) this;
        }

        public Criteria andUserUpdateBeforeIsNotNull() {
            addCriterion("USER_UPDATE_BEFORE is not null");
            return (Criteria) this;
        }

        public Criteria andUserUpdateBeforeEqualTo(String value) {
            addCriterion("USER_UPDATE_BEFORE =", value, "userUpdateBefore");
            return (Criteria) this;
        }

        public Criteria andUserUpdateBeforeNotEqualTo(String value) {
            addCriterion("USER_UPDATE_BEFORE <>", value, "userUpdateBefore");
            return (Criteria) this;
        }

        public Criteria andUserUpdateBeforeGreaterThan(String value) {
            addCriterion("USER_UPDATE_BEFORE >", value, "userUpdateBefore");
            return (Criteria) this;
        }

        public Criteria andUserUpdateBeforeGreaterThanOrEqualTo(String value) {
            addCriterion("USER_UPDATE_BEFORE >=", value, "userUpdateBefore");
            return (Criteria) this;
        }

        public Criteria andUserUpdateBeforeLessThan(String value) {
            addCriterion("USER_UPDATE_BEFORE <", value, "userUpdateBefore");
            return (Criteria) this;
        }

        public Criteria andUserUpdateBeforeLessThanOrEqualTo(String value) {
            addCriterion("USER_UPDATE_BEFORE <=", value, "userUpdateBefore");
            return (Criteria) this;
        }

        public Criteria andUserUpdateBeforeLike(String value) {
            addCriterion("USER_UPDATE_BEFORE like", value, "userUpdateBefore");
            return (Criteria) this;
        }

        public Criteria andUserUpdateBeforeNotLike(String value) {
            addCriterion("USER_UPDATE_BEFORE not like", value, "userUpdateBefore");
            return (Criteria) this;
        }

        public Criteria andUserUpdateBeforeIn(List<String> values) {
            addCriterion("USER_UPDATE_BEFORE in", values, "userUpdateBefore");
            return (Criteria) this;
        }

        public Criteria andUserUpdateBeforeNotIn(List<String> values) {
            addCriterion("USER_UPDATE_BEFORE not in", values, "userUpdateBefore");
            return (Criteria) this;
        }

        public Criteria andUserUpdateBeforeBetween(String value1, String value2) {
            addCriterion("USER_UPDATE_BEFORE between", value1, value2, "userUpdateBefore");
            return (Criteria) this;
        }

        public Criteria andUserUpdateBeforeNotBetween(String value1, String value2) {
            addCriterion("USER_UPDATE_BEFORE not between", value1, value2, "userUpdateBefore");
            return (Criteria) this;
        }

        public Criteria andUserUpdateAfterIsNull() {
            addCriterion("USER_UPDATE_AFTER is null");
            return (Criteria) this;
        }

        public Criteria andUserUpdateAfterIsNotNull() {
            addCriterion("USER_UPDATE_AFTER is not null");
            return (Criteria) this;
        }

        public Criteria andUserUpdateAfterEqualTo(String value) {
            addCriterion("USER_UPDATE_AFTER =", value, "userUpdateAfter");
            return (Criteria) this;
        }

        public Criteria andUserUpdateAfterNotEqualTo(String value) {
            addCriterion("USER_UPDATE_AFTER <>", value, "userUpdateAfter");
            return (Criteria) this;
        }

        public Criteria andUserUpdateAfterGreaterThan(String value) {
            addCriterion("USER_UPDATE_AFTER >", value, "userUpdateAfter");
            return (Criteria) this;
        }

        public Criteria andUserUpdateAfterGreaterThanOrEqualTo(String value) {
            addCriterion("USER_UPDATE_AFTER >=", value, "userUpdateAfter");
            return (Criteria) this;
        }

        public Criteria andUserUpdateAfterLessThan(String value) {
            addCriterion("USER_UPDATE_AFTER <", value, "userUpdateAfter");
            return (Criteria) this;
        }

        public Criteria andUserUpdateAfterLessThanOrEqualTo(String value) {
            addCriterion("USER_UPDATE_AFTER <=", value, "userUpdateAfter");
            return (Criteria) this;
        }

        public Criteria andUserUpdateAfterLike(String value) {
            addCriterion("USER_UPDATE_AFTER like", value, "userUpdateAfter");
            return (Criteria) this;
        }

        public Criteria andUserUpdateAfterNotLike(String value) {
            addCriterion("USER_UPDATE_AFTER not like", value, "userUpdateAfter");
            return (Criteria) this;
        }

        public Criteria andUserUpdateAfterIn(List<String> values) {
            addCriterion("USER_UPDATE_AFTER in", values, "userUpdateAfter");
            return (Criteria) this;
        }

        public Criteria andUserUpdateAfterNotIn(List<String> values) {
            addCriterion("USER_UPDATE_AFTER not in", values, "userUpdateAfter");
            return (Criteria) this;
        }

        public Criteria andUserUpdateAfterBetween(String value1, String value2) {
            addCriterion("USER_UPDATE_AFTER between", value1, value2, "userUpdateAfter");
            return (Criteria) this;
        }

        public Criteria andUserUpdateAfterNotBetween(String value1, String value2) {
            addCriterion("USER_UPDATE_AFTER not between", value1, value2, "userUpdateAfter");
            return (Criteria) this;
        }

        public Criteria andUserOperateResultIsNull() {
            addCriterion("USER_OPERATE_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andUserOperateResultIsNotNull() {
            addCriterion("USER_OPERATE_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andUserOperateResultEqualTo(String value) {
            addCriterion("USER_OPERATE_RESULT =", value, "userOperateResult");
            return (Criteria) this;
        }

        public Criteria andUserOperateResultNotEqualTo(String value) {
            addCriterion("USER_OPERATE_RESULT <>", value, "userOperateResult");
            return (Criteria) this;
        }

        public Criteria andUserOperateResultGreaterThan(String value) {
            addCriterion("USER_OPERATE_RESULT >", value, "userOperateResult");
            return (Criteria) this;
        }

        public Criteria andUserOperateResultGreaterThanOrEqualTo(String value) {
            addCriterion("USER_OPERATE_RESULT >=", value, "userOperateResult");
            return (Criteria) this;
        }

        public Criteria andUserOperateResultLessThan(String value) {
            addCriterion("USER_OPERATE_RESULT <", value, "userOperateResult");
            return (Criteria) this;
        }

        public Criteria andUserOperateResultLessThanOrEqualTo(String value) {
            addCriterion("USER_OPERATE_RESULT <=", value, "userOperateResult");
            return (Criteria) this;
        }

        public Criteria andUserOperateResultLike(String value) {
            addCriterion("USER_OPERATE_RESULT like", value, "userOperateResult");
            return (Criteria) this;
        }

        public Criteria andUserOperateResultNotLike(String value) {
            addCriterion("USER_OPERATE_RESULT not like", value, "userOperateResult");
            return (Criteria) this;
        }

        public Criteria andUserOperateResultIn(List<String> values) {
            addCriterion("USER_OPERATE_RESULT in", values, "userOperateResult");
            return (Criteria) this;
        }

        public Criteria andUserOperateResultNotIn(List<String> values) {
            addCriterion("USER_OPERATE_RESULT not in", values, "userOperateResult");
            return (Criteria) this;
        }

        public Criteria andUserOperateResultBetween(String value1, String value2) {
            addCriterion("USER_OPERATE_RESULT between", value1, value2, "userOperateResult");
            return (Criteria) this;
        }

        public Criteria andUserOperateResultNotBetween(String value1, String value2) {
            addCriterion("USER_OPERATE_RESULT not between", value1, value2, "userOperateResult");
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
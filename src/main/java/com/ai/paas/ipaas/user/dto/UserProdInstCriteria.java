package com.ai.paas.ipaas.user.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserProdInstCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public UserProdInstCriteria() {
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

        public Criteria andUserServIdIsNull() {
            addCriterion("USER_SERV_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserServIdIsNotNull() {
            addCriterion("USER_SERV_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserServIdEqualTo(Long value) {
            addCriterion("USER_SERV_ID =", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdNotEqualTo(Long value) {
            addCriterion("USER_SERV_ID <>", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdGreaterThan(Long value) {
            addCriterion("USER_SERV_ID >", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_SERV_ID >=", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdLessThan(Long value) {
            addCriterion("USER_SERV_ID <", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdLessThanOrEqualTo(Long value) {
            addCriterion("USER_SERV_ID <=", value, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdIn(List<Long> values) {
            addCriterion("USER_SERV_ID in", values, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdNotIn(List<Long> values) {
            addCriterion("USER_SERV_ID not in", values, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdBetween(Long value1, Long value2) {
            addCriterion("USER_SERV_ID between", value1, value2, "userServId");
            return (Criteria) this;
        }

        public Criteria andUserServIdNotBetween(Long value1, Long value2) {
            addCriterion("USER_SERV_ID not between", value1, value2, "userServId");
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

        public Criteria andUserServTypeIsNull() {
            addCriterion("USER_SERV_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUserServTypeIsNotNull() {
            addCriterion("USER_SERV_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUserServTypeEqualTo(String value) {
            addCriterion("USER_SERV_TYPE =", value, "userServType");
            return (Criteria) this;
        }

        public Criteria andUserServTypeNotEqualTo(String value) {
            addCriterion("USER_SERV_TYPE <>", value, "userServType");
            return (Criteria) this;
        }

        public Criteria andUserServTypeGreaterThan(String value) {
            addCriterion("USER_SERV_TYPE >", value, "userServType");
            return (Criteria) this;
        }

        public Criteria andUserServTypeGreaterThanOrEqualTo(String value) {
            addCriterion("USER_SERV_TYPE >=", value, "userServType");
            return (Criteria) this;
        }

        public Criteria andUserServTypeLessThan(String value) {
            addCriterion("USER_SERV_TYPE <", value, "userServType");
            return (Criteria) this;
        }

        public Criteria andUserServTypeLessThanOrEqualTo(String value) {
            addCriterion("USER_SERV_TYPE <=", value, "userServType");
            return (Criteria) this;
        }

        public Criteria andUserServTypeLike(String value) {
            addCriterion("USER_SERV_TYPE like", value, "userServType");
            return (Criteria) this;
        }

        public Criteria andUserServTypeNotLike(String value) {
            addCriterion("USER_SERV_TYPE not like", value, "userServType");
            return (Criteria) this;
        }

        public Criteria andUserServTypeIn(List<String> values) {
            addCriterion("USER_SERV_TYPE in", values, "userServType");
            return (Criteria) this;
        }

        public Criteria andUserServTypeNotIn(List<String> values) {
            addCriterion("USER_SERV_TYPE not in", values, "userServType");
            return (Criteria) this;
        }

        public Criteria andUserServTypeBetween(String value1, String value2) {
            addCriterion("USER_SERV_TYPE between", value1, value2, "userServType");
            return (Criteria) this;
        }

        public Criteria andUserServTypeNotBetween(String value1, String value2) {
            addCriterion("USER_SERV_TYPE not between", value1, value2, "userServType");
            return (Criteria) this;
        }

        public Criteria andUserServiceIdIsNull() {
            addCriterion("USER_SERVICE_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserServiceIdIsNotNull() {
            addCriterion("USER_SERVICE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserServiceIdEqualTo(String value) {
            addCriterion("USER_SERVICE_ID =", value, "userServiceId");
            return (Criteria) this;
        }

        public Criteria andUserServiceIdNotEqualTo(String value) {
            addCriterion("USER_SERVICE_ID <>", value, "userServiceId");
            return (Criteria) this;
        }

        public Criteria andUserServiceIdGreaterThan(String value) {
            addCriterion("USER_SERVICE_ID >", value, "userServiceId");
            return (Criteria) this;
        }

        public Criteria andUserServiceIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_SERVICE_ID >=", value, "userServiceId");
            return (Criteria) this;
        }

        public Criteria andUserServiceIdLessThan(String value) {
            addCriterion("USER_SERVICE_ID <", value, "userServiceId");
            return (Criteria) this;
        }

        public Criteria andUserServiceIdLessThanOrEqualTo(String value) {
            addCriterion("USER_SERVICE_ID <=", value, "userServiceId");
            return (Criteria) this;
        }

        public Criteria andUserServiceIdLike(String value) {
            addCriterion("USER_SERVICE_ID like", value, "userServiceId");
            return (Criteria) this;
        }

        public Criteria andUserServiceIdNotLike(String value) {
            addCriterion("USER_SERVICE_ID not like", value, "userServiceId");
            return (Criteria) this;
        }

        public Criteria andUserServiceIdIn(List<String> values) {
            addCriterion("USER_SERVICE_ID in", values, "userServiceId");
            return (Criteria) this;
        }

        public Criteria andUserServiceIdNotIn(List<String> values) {
            addCriterion("USER_SERVICE_ID not in", values, "userServiceId");
            return (Criteria) this;
        }

        public Criteria andUserServiceIdBetween(String value1, String value2) {
            addCriterion("USER_SERVICE_ID between", value1, value2, "userServiceId");
            return (Criteria) this;
        }

        public Criteria andUserServiceIdNotBetween(String value1, String value2) {
            addCriterion("USER_SERVICE_ID not between", value1, value2, "userServiceId");
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

        public Criteria andUserServParamIsNull() {
            addCriterion("USER_SERV_PARAM is null");
            return (Criteria) this;
        }

        public Criteria andUserServParamIsNotNull() {
            addCriterion("USER_SERV_PARAM is not null");
            return (Criteria) this;
        }

        public Criteria andUserServParamEqualTo(String value) {
            addCriterion("USER_SERV_PARAM =", value, "userServParam");
            return (Criteria) this;
        }

        public Criteria andUserServParamNotEqualTo(String value) {
            addCriterion("USER_SERV_PARAM <>", value, "userServParam");
            return (Criteria) this;
        }

        public Criteria andUserServParamGreaterThan(String value) {
            addCriterion("USER_SERV_PARAM >", value, "userServParam");
            return (Criteria) this;
        }

        public Criteria andUserServParamGreaterThanOrEqualTo(String value) {
            addCriterion("USER_SERV_PARAM >=", value, "userServParam");
            return (Criteria) this;
        }

        public Criteria andUserServParamLessThan(String value) {
            addCriterion("USER_SERV_PARAM <", value, "userServParam");
            return (Criteria) this;
        }

        public Criteria andUserServParamLessThanOrEqualTo(String value) {
            addCriterion("USER_SERV_PARAM <=", value, "userServParam");
            return (Criteria) this;
        }

        public Criteria andUserServParamLike(String value) {
            addCriterion("USER_SERV_PARAM like", value, "userServParam");
            return (Criteria) this;
        }

        public Criteria andUserServParamNotLike(String value) {
            addCriterion("USER_SERV_PARAM not like", value, "userServParam");
            return (Criteria) this;
        }

        public Criteria andUserServParamIn(List<String> values) {
            addCriterion("USER_SERV_PARAM in", values, "userServParam");
            return (Criteria) this;
        }

        public Criteria andUserServParamNotIn(List<String> values) {
            addCriterion("USER_SERV_PARAM not in", values, "userServParam");
            return (Criteria) this;
        }

        public Criteria andUserServParamBetween(String value1, String value2) {
            addCriterion("USER_SERV_PARAM between", value1, value2, "userServParam");
            return (Criteria) this;
        }

        public Criteria andUserServParamNotBetween(String value1, String value2) {
            addCriterion("USER_SERV_PARAM not between", value1, value2, "userServParam");
            return (Criteria) this;
        }

        public Criteria andUserServParamZhIsNull() {
            addCriterion("USER_SERV_PARAM_ZH is null");
            return (Criteria) this;
        }

        public Criteria andUserServParamZhIsNotNull() {
            addCriterion("USER_SERV_PARAM_ZH is not null");
            return (Criteria) this;
        }

        public Criteria andUserServParamZhEqualTo(String value) {
            addCriterion("USER_SERV_PARAM_ZH =", value, "userServParamZh");
            return (Criteria) this;
        }

        public Criteria andUserServParamZhNotEqualTo(String value) {
            addCriterion("USER_SERV_PARAM_ZH <>", value, "userServParamZh");
            return (Criteria) this;
        }

        public Criteria andUserServParamZhGreaterThan(String value) {
            addCriterion("USER_SERV_PARAM_ZH >", value, "userServParamZh");
            return (Criteria) this;
        }

        public Criteria andUserServParamZhGreaterThanOrEqualTo(String value) {
            addCriterion("USER_SERV_PARAM_ZH >=", value, "userServParamZh");
            return (Criteria) this;
        }

        public Criteria andUserServParamZhLessThan(String value) {
            addCriterion("USER_SERV_PARAM_ZH <", value, "userServParamZh");
            return (Criteria) this;
        }

        public Criteria andUserServParamZhLessThanOrEqualTo(String value) {
            addCriterion("USER_SERV_PARAM_ZH <=", value, "userServParamZh");
            return (Criteria) this;
        }

        public Criteria andUserServParamZhLike(String value) {
            addCriterion("USER_SERV_PARAM_ZH like", value, "userServParamZh");
            return (Criteria) this;
        }

        public Criteria andUserServParamZhNotLike(String value) {
            addCriterion("USER_SERV_PARAM_ZH not like", value, "userServParamZh");
            return (Criteria) this;
        }

        public Criteria andUserServParamZhIn(List<String> values) {
            addCriterion("USER_SERV_PARAM_ZH in", values, "userServParamZh");
            return (Criteria) this;
        }

        public Criteria andUserServParamZhNotIn(List<String> values) {
            addCriterion("USER_SERV_PARAM_ZH not in", values, "userServParamZh");
            return (Criteria) this;
        }

        public Criteria andUserServParamZhBetween(String value1, String value2) {
            addCriterion("USER_SERV_PARAM_ZH between", value1, value2, "userServParamZh");
            return (Criteria) this;
        }

        public Criteria andUserServParamZhNotBetween(String value1, String value2) {
            addCriterion("USER_SERV_PARAM_ZH not between", value1, value2, "userServParamZh");
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

        public Criteria andUserServStateIsNull() {
            addCriterion("USER_SERV_STATE is null");
            return (Criteria) this;
        }

        public Criteria andUserServStateIsNotNull() {
            addCriterion("USER_SERV_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andUserServStateEqualTo(String value) {
            addCriterion("USER_SERV_STATE =", value, "userServState");
            return (Criteria) this;
        }

        public Criteria andUserServStateNotEqualTo(String value) {
            addCriterion("USER_SERV_STATE <>", value, "userServState");
            return (Criteria) this;
        }

        public Criteria andUserServStateGreaterThan(String value) {
            addCriterion("USER_SERV_STATE >", value, "userServState");
            return (Criteria) this;
        }

        public Criteria andUserServStateGreaterThanOrEqualTo(String value) {
            addCriterion("USER_SERV_STATE >=", value, "userServState");
            return (Criteria) this;
        }

        public Criteria andUserServStateLessThan(String value) {
            addCriterion("USER_SERV_STATE <", value, "userServState");
            return (Criteria) this;
        }

        public Criteria andUserServStateLessThanOrEqualTo(String value) {
            addCriterion("USER_SERV_STATE <=", value, "userServState");
            return (Criteria) this;
        }

        public Criteria andUserServStateLike(String value) {
            addCriterion("USER_SERV_STATE like", value, "userServState");
            return (Criteria) this;
        }

        public Criteria andUserServStateNotLike(String value) {
            addCriterion("USER_SERV_STATE not like", value, "userServState");
            return (Criteria) this;
        }

        public Criteria andUserServStateIn(List<String> values) {
            addCriterion("USER_SERV_STATE in", values, "userServState");
            return (Criteria) this;
        }

        public Criteria andUserServStateNotIn(List<String> values) {
            addCriterion("USER_SERV_STATE not in", values, "userServState");
            return (Criteria) this;
        }

        public Criteria andUserServStateBetween(String value1, String value2) {
            addCriterion("USER_SERV_STATE between", value1, value2, "userServState");
            return (Criteria) this;
        }

        public Criteria andUserServStateNotBetween(String value1, String value2) {
            addCriterion("USER_SERV_STATE not between", value1, value2, "userServState");
            return (Criteria) this;
        }

        public Criteria andUserServOpenTimeIsNull() {
            addCriterion("USER_SERV_OPEN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUserServOpenTimeIsNotNull() {
            addCriterion("USER_SERV_OPEN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUserServOpenTimeEqualTo(Timestamp value) {
            addCriterion("USER_SERV_OPEN_TIME =", value, "userServOpenTime");
            return (Criteria) this;
        }

        public Criteria andUserServOpenTimeNotEqualTo(Timestamp value) {
            addCriterion("USER_SERV_OPEN_TIME <>", value, "userServOpenTime");
            return (Criteria) this;
        }

        public Criteria andUserServOpenTimeGreaterThan(Timestamp value) {
            addCriterion("USER_SERV_OPEN_TIME >", value, "userServOpenTime");
            return (Criteria) this;
        }

        public Criteria andUserServOpenTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("USER_SERV_OPEN_TIME >=", value, "userServOpenTime");
            return (Criteria) this;
        }

        public Criteria andUserServOpenTimeLessThan(Timestamp value) {
            addCriterion("USER_SERV_OPEN_TIME <", value, "userServOpenTime");
            return (Criteria) this;
        }

        public Criteria andUserServOpenTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("USER_SERV_OPEN_TIME <=", value, "userServOpenTime");
            return (Criteria) this;
        }

        public Criteria andUserServOpenTimeIn(List<Timestamp> values) {
            addCriterion("USER_SERV_OPEN_TIME in", values, "userServOpenTime");
            return (Criteria) this;
        }

        public Criteria andUserServOpenTimeNotIn(List<Timestamp> values) {
            addCriterion("USER_SERV_OPEN_TIME not in", values, "userServOpenTime");
            return (Criteria) this;
        }

        public Criteria andUserServOpenTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_SERV_OPEN_TIME between", value1, value2, "userServOpenTime");
            return (Criteria) this;
        }

        public Criteria andUserServOpenTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_SERV_OPEN_TIME not between", value1, value2, "userServOpenTime");
            return (Criteria) this;
        }

        public Criteria andUserServBackParamIsNull() {
            addCriterion("USER_SERV_BACK_PARAM is null");
            return (Criteria) this;
        }

        public Criteria andUserServBackParamIsNotNull() {
            addCriterion("USER_SERV_BACK_PARAM is not null");
            return (Criteria) this;
        }

        public Criteria andUserServBackParamEqualTo(String value) {
            addCriterion("USER_SERV_BACK_PARAM =", value, "userServBackParam");
            return (Criteria) this;
        }

        public Criteria andUserServBackParamNotEqualTo(String value) {
            addCriterion("USER_SERV_BACK_PARAM <>", value, "userServBackParam");
            return (Criteria) this;
        }

        public Criteria andUserServBackParamGreaterThan(String value) {
            addCriterion("USER_SERV_BACK_PARAM >", value, "userServBackParam");
            return (Criteria) this;
        }

        public Criteria andUserServBackParamGreaterThanOrEqualTo(String value) {
            addCriterion("USER_SERV_BACK_PARAM >=", value, "userServBackParam");
            return (Criteria) this;
        }

        public Criteria andUserServBackParamLessThan(String value) {
            addCriterion("USER_SERV_BACK_PARAM <", value, "userServBackParam");
            return (Criteria) this;
        }

        public Criteria andUserServBackParamLessThanOrEqualTo(String value) {
            addCriterion("USER_SERV_BACK_PARAM <=", value, "userServBackParam");
            return (Criteria) this;
        }

        public Criteria andUserServBackParamLike(String value) {
            addCriterion("USER_SERV_BACK_PARAM like", value, "userServBackParam");
            return (Criteria) this;
        }

        public Criteria andUserServBackParamNotLike(String value) {
            addCriterion("USER_SERV_BACK_PARAM not like", value, "userServBackParam");
            return (Criteria) this;
        }

        public Criteria andUserServBackParamIn(List<String> values) {
            addCriterion("USER_SERV_BACK_PARAM in", values, "userServBackParam");
            return (Criteria) this;
        }

        public Criteria andUserServBackParamNotIn(List<String> values) {
            addCriterion("USER_SERV_BACK_PARAM not in", values, "userServBackParam");
            return (Criteria) this;
        }

        public Criteria andUserServBackParamBetween(String value1, String value2) {
            addCriterion("USER_SERV_BACK_PARAM between", value1, value2, "userServBackParam");
            return (Criteria) this;
        }

        public Criteria andUserServBackParamNotBetween(String value1, String value2) {
            addCriterion("USER_SERV_BACK_PARAM not between", value1, value2, "userServBackParam");
            return (Criteria) this;
        }

        public Criteria andUserServCloseTimeIsNull() {
            addCriterion("USER_SERV_CLOSE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUserServCloseTimeIsNotNull() {
            addCriterion("USER_SERV_CLOSE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUserServCloseTimeEqualTo(Timestamp value) {
            addCriterion("USER_SERV_CLOSE_TIME =", value, "userServCloseTime");
            return (Criteria) this;
        }

        public Criteria andUserServCloseTimeNotEqualTo(Timestamp value) {
            addCriterion("USER_SERV_CLOSE_TIME <>", value, "userServCloseTime");
            return (Criteria) this;
        }

        public Criteria andUserServCloseTimeGreaterThan(Timestamp value) {
            addCriterion("USER_SERV_CLOSE_TIME >", value, "userServCloseTime");
            return (Criteria) this;
        }

        public Criteria andUserServCloseTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("USER_SERV_CLOSE_TIME >=", value, "userServCloseTime");
            return (Criteria) this;
        }

        public Criteria andUserServCloseTimeLessThan(Timestamp value) {
            addCriterion("USER_SERV_CLOSE_TIME <", value, "userServCloseTime");
            return (Criteria) this;
        }

        public Criteria andUserServCloseTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("USER_SERV_CLOSE_TIME <=", value, "userServCloseTime");
            return (Criteria) this;
        }

        public Criteria andUserServCloseTimeIn(List<Timestamp> values) {
            addCriterion("USER_SERV_CLOSE_TIME in", values, "userServCloseTime");
            return (Criteria) this;
        }

        public Criteria andUserServCloseTimeNotIn(List<Timestamp> values) {
            addCriterion("USER_SERV_CLOSE_TIME not in", values, "userServCloseTime");
            return (Criteria) this;
        }

        public Criteria andUserServCloseTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_SERV_CLOSE_TIME between", value1, value2, "userServCloseTime");
            return (Criteria) this;
        }

        public Criteria andUserServCloseTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_SERV_CLOSE_TIME not between", value1, value2, "userServCloseTime");
            return (Criteria) this;
        }

        public Criteria andUserServRunStateIsNull() {
            addCriterion("USER_SERV_RUN_STATE is null");
            return (Criteria) this;
        }

        public Criteria andUserServRunStateIsNotNull() {
            addCriterion("USER_SERV_RUN_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andUserServRunStateEqualTo(String value) {
            addCriterion("USER_SERV_RUN_STATE =", value, "userServRunState");
            return (Criteria) this;
        }

        public Criteria andUserServRunStateNotEqualTo(String value) {
            addCriterion("USER_SERV_RUN_STATE <>", value, "userServRunState");
            return (Criteria) this;
        }

        public Criteria andUserServRunStateGreaterThan(String value) {
            addCriterion("USER_SERV_RUN_STATE >", value, "userServRunState");
            return (Criteria) this;
        }

        public Criteria andUserServRunStateGreaterThanOrEqualTo(String value) {
            addCriterion("USER_SERV_RUN_STATE >=", value, "userServRunState");
            return (Criteria) this;
        }

        public Criteria andUserServRunStateLessThan(String value) {
            addCriterion("USER_SERV_RUN_STATE <", value, "userServRunState");
            return (Criteria) this;
        }

        public Criteria andUserServRunStateLessThanOrEqualTo(String value) {
            addCriterion("USER_SERV_RUN_STATE <=", value, "userServRunState");
            return (Criteria) this;
        }

        public Criteria andUserServRunStateLike(String value) {
            addCriterion("USER_SERV_RUN_STATE like", value, "userServRunState");
            return (Criteria) this;
        }

        public Criteria andUserServRunStateNotLike(String value) {
            addCriterion("USER_SERV_RUN_STATE not like", value, "userServRunState");
            return (Criteria) this;
        }

        public Criteria andUserServRunStateIn(List<String> values) {
            addCriterion("USER_SERV_RUN_STATE in", values, "userServRunState");
            return (Criteria) this;
        }

        public Criteria andUserServRunStateNotIn(List<String> values) {
            addCriterion("USER_SERV_RUN_STATE not in", values, "userServRunState");
            return (Criteria) this;
        }

        public Criteria andUserServRunStateBetween(String value1, String value2) {
            addCriterion("USER_SERV_RUN_STATE between", value1, value2, "userServRunState");
            return (Criteria) this;
        }

        public Criteria andUserServRunStateNotBetween(String value1, String value2) {
            addCriterion("USER_SERV_RUN_STATE not between", value1, value2, "userServRunState");
            return (Criteria) this;
        }

        public Criteria andUserServStartTimeIsNull() {
            addCriterion("USER_SERV_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUserServStartTimeIsNotNull() {
            addCriterion("USER_SERV_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUserServStartTimeEqualTo(Timestamp value) {
            addCriterion("USER_SERV_START_TIME =", value, "userServStartTime");
            return (Criteria) this;
        }

        public Criteria andUserServStartTimeNotEqualTo(Timestamp value) {
            addCriterion("USER_SERV_START_TIME <>", value, "userServStartTime");
            return (Criteria) this;
        }

        public Criteria andUserServStartTimeGreaterThan(Timestamp value) {
            addCriterion("USER_SERV_START_TIME >", value, "userServStartTime");
            return (Criteria) this;
        }

        public Criteria andUserServStartTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("USER_SERV_START_TIME >=", value, "userServStartTime");
            return (Criteria) this;
        }

        public Criteria andUserServStartTimeLessThan(Timestamp value) {
            addCriterion("USER_SERV_START_TIME <", value, "userServStartTime");
            return (Criteria) this;
        }

        public Criteria andUserServStartTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("USER_SERV_START_TIME <=", value, "userServStartTime");
            return (Criteria) this;
        }

        public Criteria andUserServStartTimeIn(List<Timestamp> values) {
            addCriterion("USER_SERV_START_TIME in", values, "userServStartTime");
            return (Criteria) this;
        }

        public Criteria andUserServStartTimeNotIn(List<Timestamp> values) {
            addCriterion("USER_SERV_START_TIME not in", values, "userServStartTime");
            return (Criteria) this;
        }

        public Criteria andUserServStartTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_SERV_START_TIME between", value1, value2, "userServStartTime");
            return (Criteria) this;
        }

        public Criteria andUserServStartTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_SERV_START_TIME not between", value1, value2, "userServStartTime");
            return (Criteria) this;
        }

        public Criteria andUserServStopTimeIsNull() {
            addCriterion("USER_SERV_STOP_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUserServStopTimeIsNotNull() {
            addCriterion("USER_SERV_STOP_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUserServStopTimeEqualTo(Timestamp value) {
            addCriterion("USER_SERV_STOP_TIME =", value, "userServStopTime");
            return (Criteria) this;
        }

        public Criteria andUserServStopTimeNotEqualTo(Timestamp value) {
            addCriterion("USER_SERV_STOP_TIME <>", value, "userServStopTime");
            return (Criteria) this;
        }

        public Criteria andUserServStopTimeGreaterThan(Timestamp value) {
            addCriterion("USER_SERV_STOP_TIME >", value, "userServStopTime");
            return (Criteria) this;
        }

        public Criteria andUserServStopTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("USER_SERV_STOP_TIME >=", value, "userServStopTime");
            return (Criteria) this;
        }

        public Criteria andUserServStopTimeLessThan(Timestamp value) {
            addCriterion("USER_SERV_STOP_TIME <", value, "userServStopTime");
            return (Criteria) this;
        }

        public Criteria andUserServStopTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("USER_SERV_STOP_TIME <=", value, "userServStopTime");
            return (Criteria) this;
        }

        public Criteria andUserServStopTimeIn(List<Timestamp> values) {
            addCriterion("USER_SERV_STOP_TIME in", values, "userServStopTime");
            return (Criteria) this;
        }

        public Criteria andUserServStopTimeNotIn(List<Timestamp> values) {
            addCriterion("USER_SERV_STOP_TIME not in", values, "userServStopTime");
            return (Criteria) this;
        }

        public Criteria andUserServStopTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_SERV_STOP_TIME between", value1, value2, "userServStopTime");
            return (Criteria) this;
        }

        public Criteria andUserServStopTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_SERV_STOP_TIME not between", value1, value2, "userServStopTime");
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
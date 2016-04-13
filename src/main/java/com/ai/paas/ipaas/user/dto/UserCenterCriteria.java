package com.ai.paas.ipaas.user.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserCenterCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public UserCenterCriteria() {
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

        public Criteria andUserOrgNameIsNull() {
            addCriterion("USER_ORG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserOrgNameIsNotNull() {
            addCriterion("USER_ORG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserOrgNameEqualTo(String value) {
            addCriterion("USER_ORG_NAME =", value, "userOrgName");
            return (Criteria) this;
        }

        public Criteria andUserOrgNameNotEqualTo(String value) {
            addCriterion("USER_ORG_NAME <>", value, "userOrgName");
            return (Criteria) this;
        }

        public Criteria andUserOrgNameGreaterThan(String value) {
            addCriterion("USER_ORG_NAME >", value, "userOrgName");
            return (Criteria) this;
        }

        public Criteria andUserOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ORG_NAME >=", value, "userOrgName");
            return (Criteria) this;
        }

        public Criteria andUserOrgNameLessThan(String value) {
            addCriterion("USER_ORG_NAME <", value, "userOrgName");
            return (Criteria) this;
        }

        public Criteria andUserOrgNameLessThanOrEqualTo(String value) {
            addCriterion("USER_ORG_NAME <=", value, "userOrgName");
            return (Criteria) this;
        }

        public Criteria andUserOrgNameLike(String value) {
            addCriterion("USER_ORG_NAME like", value, "userOrgName");
            return (Criteria) this;
        }

        public Criteria andUserOrgNameNotLike(String value) {
            addCriterion("USER_ORG_NAME not like", value, "userOrgName");
            return (Criteria) this;
        }

        public Criteria andUserOrgNameIn(List<String> values) {
            addCriterion("USER_ORG_NAME in", values, "userOrgName");
            return (Criteria) this;
        }

        public Criteria andUserOrgNameNotIn(List<String> values) {
            addCriterion("USER_ORG_NAME not in", values, "userOrgName");
            return (Criteria) this;
        }

        public Criteria andUserOrgNameBetween(String value1, String value2) {
            addCriterion("USER_ORG_NAME between", value1, value2, "userOrgName");
            return (Criteria) this;
        }

        public Criteria andUserOrgNameNotBetween(String value1, String value2) {
            addCriterion("USER_ORG_NAME not between", value1, value2, "userOrgName");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("USER_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("USER_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("USER_EMAIL =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("USER_EMAIL <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("USER_EMAIL >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("USER_EMAIL >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("USER_EMAIL <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("USER_EMAIL <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("USER_EMAIL like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("USER_EMAIL not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("USER_EMAIL in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("USER_EMAIL not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("USER_EMAIL between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("USER_EMAIL not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumIsNull() {
            addCriterion("USER_PHONE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumIsNotNull() {
            addCriterion("USER_PHONE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumEqualTo(String value) {
            addCriterion("USER_PHONE_NUM =", value, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumNotEqualTo(String value) {
            addCriterion("USER_PHONE_NUM <>", value, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumGreaterThan(String value) {
            addCriterion("USER_PHONE_NUM >", value, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PHONE_NUM >=", value, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumLessThan(String value) {
            addCriterion("USER_PHONE_NUM <", value, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumLessThanOrEqualTo(String value) {
            addCriterion("USER_PHONE_NUM <=", value, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumLike(String value) {
            addCriterion("USER_PHONE_NUM like", value, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumNotLike(String value) {
            addCriterion("USER_PHONE_NUM not like", value, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumIn(List<String> values) {
            addCriterion("USER_PHONE_NUM in", values, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumNotIn(List<String> values) {
            addCriterion("USER_PHONE_NUM not in", values, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumBetween(String value1, String value2) {
            addCriterion("USER_PHONE_NUM between", value1, value2, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumNotBetween(String value1, String value2) {
            addCriterion("USER_PHONE_NUM not between", value1, value2, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserStateIsNull() {
            addCriterion("USER_STATE is null");
            return (Criteria) this;
        }

        public Criteria andUserStateIsNotNull() {
            addCriterion("USER_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andUserStateEqualTo(String value) {
            addCriterion("USER_STATE =", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotEqualTo(String value) {
            addCriterion("USER_STATE <>", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateGreaterThan(String value) {
            addCriterion("USER_STATE >", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateGreaterThanOrEqualTo(String value) {
            addCriterion("USER_STATE >=", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLessThan(String value) {
            addCriterion("USER_STATE <", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLessThanOrEqualTo(String value) {
            addCriterion("USER_STATE <=", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLike(String value) {
            addCriterion("USER_STATE like", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotLike(String value) {
            addCriterion("USER_STATE not like", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateIn(List<String> values) {
            addCriterion("USER_STATE in", values, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotIn(List<String> values) {
            addCriterion("USER_STATE not in", values, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateBetween(String value1, String value2) {
            addCriterion("USER_STATE between", value1, value2, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotBetween(String value1, String value2) {
            addCriterion("USER_STATE not between", value1, value2, "userState");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeIsNull() {
            addCriterion("USER_REGISTER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeIsNotNull() {
            addCriterion("USER_REGISTER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeEqualTo(Timestamp value) {
            addCriterion("USER_REGISTER_TIME =", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeNotEqualTo(Timestamp value) {
            addCriterion("USER_REGISTER_TIME <>", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeGreaterThan(Timestamp value) {
            addCriterion("USER_REGISTER_TIME >", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("USER_REGISTER_TIME >=", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeLessThan(Timestamp value) {
            addCriterion("USER_REGISTER_TIME <", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("USER_REGISTER_TIME <=", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeIn(List<Timestamp> values) {
            addCriterion("USER_REGISTER_TIME in", values, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeNotIn(List<Timestamp> values) {
            addCriterion("USER_REGISTER_TIME not in", values, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_REGISTER_TIME between", value1, value2, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_REGISTER_TIME not between", value1, value2, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserActiveTimeIsNull() {
            addCriterion("USER_ACTIVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUserActiveTimeIsNotNull() {
            addCriterion("USER_ACTIVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUserActiveTimeEqualTo(Timestamp value) {
            addCriterion("USER_ACTIVE_TIME =", value, "userActiveTime");
            return (Criteria) this;
        }

        public Criteria andUserActiveTimeNotEqualTo(Timestamp value) {
            addCriterion("USER_ACTIVE_TIME <>", value, "userActiveTime");
            return (Criteria) this;
        }

        public Criteria andUserActiveTimeGreaterThan(Timestamp value) {
            addCriterion("USER_ACTIVE_TIME >", value, "userActiveTime");
            return (Criteria) this;
        }

        public Criteria andUserActiveTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("USER_ACTIVE_TIME >=", value, "userActiveTime");
            return (Criteria) this;
        }

        public Criteria andUserActiveTimeLessThan(Timestamp value) {
            addCriterion("USER_ACTIVE_TIME <", value, "userActiveTime");
            return (Criteria) this;
        }

        public Criteria andUserActiveTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("USER_ACTIVE_TIME <=", value, "userActiveTime");
            return (Criteria) this;
        }

        public Criteria andUserActiveTimeIn(List<Timestamp> values) {
            addCriterion("USER_ACTIVE_TIME in", values, "userActiveTime");
            return (Criteria) this;
        }

        public Criteria andUserActiveTimeNotIn(List<Timestamp> values) {
            addCriterion("USER_ACTIVE_TIME not in", values, "userActiveTime");
            return (Criteria) this;
        }

        public Criteria andUserActiveTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_ACTIVE_TIME between", value1, value2, "userActiveTime");
            return (Criteria) this;
        }

        public Criteria andUserActiveTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_ACTIVE_TIME not between", value1, value2, "userActiveTime");
            return (Criteria) this;
        }

        public Criteria andUserCancelTimeIsNull() {
            addCriterion("USER_CANCEL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUserCancelTimeIsNotNull() {
            addCriterion("USER_CANCEL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUserCancelTimeEqualTo(Timestamp value) {
            addCriterion("USER_CANCEL_TIME =", value, "userCancelTime");
            return (Criteria) this;
        }

        public Criteria andUserCancelTimeNotEqualTo(Timestamp value) {
            addCriterion("USER_CANCEL_TIME <>", value, "userCancelTime");
            return (Criteria) this;
        }

        public Criteria andUserCancelTimeGreaterThan(Timestamp value) {
            addCriterion("USER_CANCEL_TIME >", value, "userCancelTime");
            return (Criteria) this;
        }

        public Criteria andUserCancelTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("USER_CANCEL_TIME >=", value, "userCancelTime");
            return (Criteria) this;
        }

        public Criteria andUserCancelTimeLessThan(Timestamp value) {
            addCriterion("USER_CANCEL_TIME <", value, "userCancelTime");
            return (Criteria) this;
        }

        public Criteria andUserCancelTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("USER_CANCEL_TIME <=", value, "userCancelTime");
            return (Criteria) this;
        }

        public Criteria andUserCancelTimeIn(List<Timestamp> values) {
            addCriterion("USER_CANCEL_TIME in", values, "userCancelTime");
            return (Criteria) this;
        }

        public Criteria andUserCancelTimeNotIn(List<Timestamp> values) {
            addCriterion("USER_CANCEL_TIME not in", values, "userCancelTime");
            return (Criteria) this;
        }

        public Criteria andUserCancelTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_CANCEL_TIME between", value1, value2, "userCancelTime");
            return (Criteria) this;
        }

        public Criteria andUserCancelTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("USER_CANCEL_TIME not between", value1, value2, "userCancelTime");
            return (Criteria) this;
        }

        public Criteria andUserInsideTagIsNull() {
            addCriterion("USER_INSIDE_TAG is null");
            return (Criteria) this;
        }

        public Criteria andUserInsideTagIsNotNull() {
            addCriterion("USER_INSIDE_TAG is not null");
            return (Criteria) this;
        }

        public Criteria andUserInsideTagEqualTo(String value) {
            addCriterion("USER_INSIDE_TAG =", value, "userInsideTag");
            return (Criteria) this;
        }

        public Criteria andUserInsideTagNotEqualTo(String value) {
            addCriterion("USER_INSIDE_TAG <>", value, "userInsideTag");
            return (Criteria) this;
        }

        public Criteria andUserInsideTagGreaterThan(String value) {
            addCriterion("USER_INSIDE_TAG >", value, "userInsideTag");
            return (Criteria) this;
        }

        public Criteria andUserInsideTagGreaterThanOrEqualTo(String value) {
            addCriterion("USER_INSIDE_TAG >=", value, "userInsideTag");
            return (Criteria) this;
        }

        public Criteria andUserInsideTagLessThan(String value) {
            addCriterion("USER_INSIDE_TAG <", value, "userInsideTag");
            return (Criteria) this;
        }

        public Criteria andUserInsideTagLessThanOrEqualTo(String value) {
            addCriterion("USER_INSIDE_TAG <=", value, "userInsideTag");
            return (Criteria) this;
        }

        public Criteria andUserInsideTagLike(String value) {
            addCriterion("USER_INSIDE_TAG like", value, "userInsideTag");
            return (Criteria) this;
        }

        public Criteria andUserInsideTagNotLike(String value) {
            addCriterion("USER_INSIDE_TAG not like", value, "userInsideTag");
            return (Criteria) this;
        }

        public Criteria andUserInsideTagIn(List<String> values) {
            addCriterion("USER_INSIDE_TAG in", values, "userInsideTag");
            return (Criteria) this;
        }

        public Criteria andUserInsideTagNotIn(List<String> values) {
            addCriterion("USER_INSIDE_TAG not in", values, "userInsideTag");
            return (Criteria) this;
        }

        public Criteria andUserInsideTagBetween(String value1, String value2) {
            addCriterion("USER_INSIDE_TAG between", value1, value2, "userInsideTag");
            return (Criteria) this;
        }

        public Criteria andUserInsideTagNotBetween(String value1, String value2) {
            addCriterion("USER_INSIDE_TAG not between", value1, value2, "userInsideTag");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeIsNull() {
            addCriterion("PARTNER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeIsNotNull() {
            addCriterion("PARTNER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeEqualTo(String value) {
            addCriterion("PARTNER_TYPE =", value, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeNotEqualTo(String value) {
            addCriterion("PARTNER_TYPE <>", value, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeGreaterThan(String value) {
            addCriterion("PARTNER_TYPE >", value, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PARTNER_TYPE >=", value, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeLessThan(String value) {
            addCriterion("PARTNER_TYPE <", value, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeLessThanOrEqualTo(String value) {
            addCriterion("PARTNER_TYPE <=", value, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeLike(String value) {
            addCriterion("PARTNER_TYPE like", value, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeNotLike(String value) {
            addCriterion("PARTNER_TYPE not like", value, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeIn(List<String> values) {
            addCriterion("PARTNER_TYPE in", values, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeNotIn(List<String> values) {
            addCriterion("PARTNER_TYPE not in", values, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeBetween(String value1, String value2) {
            addCriterion("PARTNER_TYPE between", value1, value2, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerTypeNotBetween(String value1, String value2) {
            addCriterion("PARTNER_TYPE not between", value1, value2, "partnerType");
            return (Criteria) this;
        }

        public Criteria andPartnerAccountIsNull() {
            addCriterion("PARTNER_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPartnerAccountIsNotNull() {
            addCriterion("PARTNER_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerAccountEqualTo(String value) {
            addCriterion("PARTNER_ACCOUNT =", value, "partnerAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerAccountNotEqualTo(String value) {
            addCriterion("PARTNER_ACCOUNT <>", value, "partnerAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerAccountGreaterThan(String value) {
            addCriterion("PARTNER_ACCOUNT >", value, "partnerAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerAccountGreaterThanOrEqualTo(String value) {
            addCriterion("PARTNER_ACCOUNT >=", value, "partnerAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerAccountLessThan(String value) {
            addCriterion("PARTNER_ACCOUNT <", value, "partnerAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerAccountLessThanOrEqualTo(String value) {
            addCriterion("PARTNER_ACCOUNT <=", value, "partnerAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerAccountLike(String value) {
            addCriterion("PARTNER_ACCOUNT like", value, "partnerAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerAccountNotLike(String value) {
            addCriterion("PARTNER_ACCOUNT not like", value, "partnerAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerAccountIn(List<String> values) {
            addCriterion("PARTNER_ACCOUNT in", values, "partnerAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerAccountNotIn(List<String> values) {
            addCriterion("PARTNER_ACCOUNT not in", values, "partnerAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerAccountBetween(String value1, String value2) {
            addCriterion("PARTNER_ACCOUNT between", value1, value2, "partnerAccount");
            return (Criteria) this;
        }

        public Criteria andPartnerAccountNotBetween(String value1, String value2) {
            addCriterion("PARTNER_ACCOUNT not between", value1, value2, "partnerAccount");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("PID is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("PID is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("PID =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("PID <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("PID >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("PID >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("PID <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("PID <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("PID like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("PID not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("PID in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("PID not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("PID between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("PID not between", value1, value2, "pid");
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
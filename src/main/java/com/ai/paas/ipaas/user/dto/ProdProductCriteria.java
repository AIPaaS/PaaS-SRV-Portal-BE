package com.ai.paas.ipaas.user.dto;

import java.util.ArrayList;
import java.util.List;

public class ProdProductCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public ProdProductCriteria() {
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

        public Criteria andProdIdIsNull() {
            addCriterion("PROD_ID is null");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNotNull() {
            addCriterion("PROD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProdIdEqualTo(Short value) {
            addCriterion("PROD_ID =", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotEqualTo(Short value) {
            addCriterion("PROD_ID <>", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThan(Short value) {
            addCriterion("PROD_ID >", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThanOrEqualTo(Short value) {
            addCriterion("PROD_ID >=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThan(Short value) {
            addCriterion("PROD_ID <", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThanOrEqualTo(Short value) {
            addCriterion("PROD_ID <=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdIn(List<Short> values) {
            addCriterion("PROD_ID in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotIn(List<Short> values) {
            addCriterion("PROD_ID not in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdBetween(Short value1, Short value2) {
            addCriterion("PROD_ID between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotBetween(Short value1, Short value2) {
            addCriterion("PROD_ID not between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdEnSimpIsNull() {
            addCriterion("PROD_EN_SIMP is null");
            return (Criteria) this;
        }

        public Criteria andProdEnSimpIsNotNull() {
            addCriterion("PROD_EN_SIMP is not null");
            return (Criteria) this;
        }

        public Criteria andProdEnSimpEqualTo(String value) {
            addCriterion("PROD_EN_SIMP =", value, "prodEnSimp");
            return (Criteria) this;
        }

        public Criteria andProdEnSimpNotEqualTo(String value) {
            addCriterion("PROD_EN_SIMP <>", value, "prodEnSimp");
            return (Criteria) this;
        }

        public Criteria andProdEnSimpGreaterThan(String value) {
            addCriterion("PROD_EN_SIMP >", value, "prodEnSimp");
            return (Criteria) this;
        }

        public Criteria andProdEnSimpGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_EN_SIMP >=", value, "prodEnSimp");
            return (Criteria) this;
        }

        public Criteria andProdEnSimpLessThan(String value) {
            addCriterion("PROD_EN_SIMP <", value, "prodEnSimp");
            return (Criteria) this;
        }

        public Criteria andProdEnSimpLessThanOrEqualTo(String value) {
            addCriterion("PROD_EN_SIMP <=", value, "prodEnSimp");
            return (Criteria) this;
        }

        public Criteria andProdEnSimpLike(String value) {
            addCriterion("PROD_EN_SIMP like", value, "prodEnSimp");
            return (Criteria) this;
        }

        public Criteria andProdEnSimpNotLike(String value) {
            addCriterion("PROD_EN_SIMP not like", value, "prodEnSimp");
            return (Criteria) this;
        }

        public Criteria andProdEnSimpIn(List<String> values) {
            addCriterion("PROD_EN_SIMP in", values, "prodEnSimp");
            return (Criteria) this;
        }

        public Criteria andProdEnSimpNotIn(List<String> values) {
            addCriterion("PROD_EN_SIMP not in", values, "prodEnSimp");
            return (Criteria) this;
        }

        public Criteria andProdEnSimpBetween(String value1, String value2) {
            addCriterion("PROD_EN_SIMP between", value1, value2, "prodEnSimp");
            return (Criteria) this;
        }

        public Criteria andProdEnSimpNotBetween(String value1, String value2) {
            addCriterion("PROD_EN_SIMP not between", value1, value2, "prodEnSimp");
            return (Criteria) this;
        }

        public Criteria andProdTypeIsNull() {
            addCriterion("PROD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andProdTypeIsNotNull() {
            addCriterion("PROD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andProdTypeEqualTo(String value) {
            addCriterion("PROD_TYPE =", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeNotEqualTo(String value) {
            addCriterion("PROD_TYPE <>", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeGreaterThan(String value) {
            addCriterion("PROD_TYPE >", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_TYPE >=", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeLessThan(String value) {
            addCriterion("PROD_TYPE <", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeLessThanOrEqualTo(String value) {
            addCriterion("PROD_TYPE <=", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeLike(String value) {
            addCriterion("PROD_TYPE like", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeNotLike(String value) {
            addCriterion("PROD_TYPE not like", value, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeIn(List<String> values) {
            addCriterion("PROD_TYPE in", values, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeNotIn(List<String> values) {
            addCriterion("PROD_TYPE not in", values, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeBetween(String value1, String value2) {
            addCriterion("PROD_TYPE between", value1, value2, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdTypeNotBetween(String value1, String value2) {
            addCriterion("PROD_TYPE not between", value1, value2, "prodType");
            return (Criteria) this;
        }

        public Criteria andProdCategoryIsNull() {
            addCriterion("PROD_CATEGORY is null");
            return (Criteria) this;
        }

        public Criteria andProdCategoryIsNotNull() {
            addCriterion("PROD_CATEGORY is not null");
            return (Criteria) this;
        }

        public Criteria andProdCategoryEqualTo(String value) {
            addCriterion("PROD_CATEGORY =", value, "prodCategory");
            return (Criteria) this;
        }

        public Criteria andProdCategoryNotEqualTo(String value) {
            addCriterion("PROD_CATEGORY <>", value, "prodCategory");
            return (Criteria) this;
        }

        public Criteria andProdCategoryGreaterThan(String value) {
            addCriterion("PROD_CATEGORY >", value, "prodCategory");
            return (Criteria) this;
        }

        public Criteria andProdCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_CATEGORY >=", value, "prodCategory");
            return (Criteria) this;
        }

        public Criteria andProdCategoryLessThan(String value) {
            addCriterion("PROD_CATEGORY <", value, "prodCategory");
            return (Criteria) this;
        }

        public Criteria andProdCategoryLessThanOrEqualTo(String value) {
            addCriterion("PROD_CATEGORY <=", value, "prodCategory");
            return (Criteria) this;
        }

        public Criteria andProdCategoryLike(String value) {
            addCriterion("PROD_CATEGORY like", value, "prodCategory");
            return (Criteria) this;
        }

        public Criteria andProdCategoryNotLike(String value) {
            addCriterion("PROD_CATEGORY not like", value, "prodCategory");
            return (Criteria) this;
        }

        public Criteria andProdCategoryIn(List<String> values) {
            addCriterion("PROD_CATEGORY in", values, "prodCategory");
            return (Criteria) this;
        }

        public Criteria andProdCategoryNotIn(List<String> values) {
            addCriterion("PROD_CATEGORY not in", values, "prodCategory");
            return (Criteria) this;
        }

        public Criteria andProdCategoryBetween(String value1, String value2) {
            addCriterion("PROD_CATEGORY between", value1, value2, "prodCategory");
            return (Criteria) this;
        }

        public Criteria andProdCategoryNotBetween(String value1, String value2) {
            addCriterion("PROD_CATEGORY not between", value1, value2, "prodCategory");
            return (Criteria) this;
        }

        public Criteria andProdNameIsNull() {
            addCriterion("PROD_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProdNameIsNotNull() {
            addCriterion("PROD_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProdNameEqualTo(String value) {
            addCriterion("PROD_NAME =", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameNotEqualTo(String value) {
            addCriterion("PROD_NAME <>", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameGreaterThan(String value) {
            addCriterion("PROD_NAME >", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_NAME >=", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameLessThan(String value) {
            addCriterion("PROD_NAME <", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameLessThanOrEqualTo(String value) {
            addCriterion("PROD_NAME <=", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameLike(String value) {
            addCriterion("PROD_NAME like", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameNotLike(String value) {
            addCriterion("PROD_NAME not like", value, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameIn(List<String> values) {
            addCriterion("PROD_NAME in", values, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameNotIn(List<String> values) {
            addCriterion("PROD_NAME not in", values, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameBetween(String value1, String value2) {
            addCriterion("PROD_NAME between", value1, value2, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdNameNotBetween(String value1, String value2) {
            addCriterion("PROD_NAME not between", value1, value2, "prodName");
            return (Criteria) this;
        }

        public Criteria andProdLogopicIdIsNull() {
            addCriterion("PROD_LOGOPIC_ID is null");
            return (Criteria) this;
        }

        public Criteria andProdLogopicIdIsNotNull() {
            addCriterion("PROD_LOGOPIC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProdLogopicIdEqualTo(String value) {
            addCriterion("PROD_LOGOPIC_ID =", value, "prodLogopicId");
            return (Criteria) this;
        }

        public Criteria andProdLogopicIdNotEqualTo(String value) {
            addCriterion("PROD_LOGOPIC_ID <>", value, "prodLogopicId");
            return (Criteria) this;
        }

        public Criteria andProdLogopicIdGreaterThan(String value) {
            addCriterion("PROD_LOGOPIC_ID >", value, "prodLogopicId");
            return (Criteria) this;
        }

        public Criteria andProdLogopicIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_LOGOPIC_ID >=", value, "prodLogopicId");
            return (Criteria) this;
        }

        public Criteria andProdLogopicIdLessThan(String value) {
            addCriterion("PROD_LOGOPIC_ID <", value, "prodLogopicId");
            return (Criteria) this;
        }

        public Criteria andProdLogopicIdLessThanOrEqualTo(String value) {
            addCriterion("PROD_LOGOPIC_ID <=", value, "prodLogopicId");
            return (Criteria) this;
        }

        public Criteria andProdLogopicIdLike(String value) {
            addCriterion("PROD_LOGOPIC_ID like", value, "prodLogopicId");
            return (Criteria) this;
        }

        public Criteria andProdLogopicIdNotLike(String value) {
            addCriterion("PROD_LOGOPIC_ID not like", value, "prodLogopicId");
            return (Criteria) this;
        }

        public Criteria andProdLogopicIdIn(List<String> values) {
            addCriterion("PROD_LOGOPIC_ID in", values, "prodLogopicId");
            return (Criteria) this;
        }

        public Criteria andProdLogopicIdNotIn(List<String> values) {
            addCriterion("PROD_LOGOPIC_ID not in", values, "prodLogopicId");
            return (Criteria) this;
        }

        public Criteria andProdLogopicIdBetween(String value1, String value2) {
            addCriterion("PROD_LOGOPIC_ID between", value1, value2, "prodLogopicId");
            return (Criteria) this;
        }

        public Criteria andProdLogopicIdNotBetween(String value1, String value2) {
            addCriterion("PROD_LOGOPIC_ID not between", value1, value2, "prodLogopicId");
            return (Criteria) this;
        }

        public Criteria andProdDescIsNull() {
            addCriterion("PROD_DESC is null");
            return (Criteria) this;
        }

        public Criteria andProdDescIsNotNull() {
            addCriterion("PROD_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andProdDescEqualTo(String value) {
            addCriterion("PROD_DESC =", value, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescNotEqualTo(String value) {
            addCriterion("PROD_DESC <>", value, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescGreaterThan(String value) {
            addCriterion("PROD_DESC >", value, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_DESC >=", value, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescLessThan(String value) {
            addCriterion("PROD_DESC <", value, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescLessThanOrEqualTo(String value) {
            addCriterion("PROD_DESC <=", value, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescLike(String value) {
            addCriterion("PROD_DESC like", value, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescNotLike(String value) {
            addCriterion("PROD_DESC not like", value, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescIn(List<String> values) {
            addCriterion("PROD_DESC in", values, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescNotIn(List<String> values) {
            addCriterion("PROD_DESC not in", values, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescBetween(String value1, String value2) {
            addCriterion("PROD_DESC between", value1, value2, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdDescNotBetween(String value1, String value2) {
            addCriterion("PROD_DESC not between", value1, value2, "prodDesc");
            return (Criteria) this;
        }

        public Criteria andProdValidFlagIsNull() {
            addCriterion("PROD_VALID_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andProdValidFlagIsNotNull() {
            addCriterion("PROD_VALID_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andProdValidFlagEqualTo(String value) {
            addCriterion("PROD_VALID_FLAG =", value, "prodValidFlag");
            return (Criteria) this;
        }

        public Criteria andProdValidFlagNotEqualTo(String value) {
            addCriterion("PROD_VALID_FLAG <>", value, "prodValidFlag");
            return (Criteria) this;
        }

        public Criteria andProdValidFlagGreaterThan(String value) {
            addCriterion("PROD_VALID_FLAG >", value, "prodValidFlag");
            return (Criteria) this;
        }

        public Criteria andProdValidFlagGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_VALID_FLAG >=", value, "prodValidFlag");
            return (Criteria) this;
        }

        public Criteria andProdValidFlagLessThan(String value) {
            addCriterion("PROD_VALID_FLAG <", value, "prodValidFlag");
            return (Criteria) this;
        }

        public Criteria andProdValidFlagLessThanOrEqualTo(String value) {
            addCriterion("PROD_VALID_FLAG <=", value, "prodValidFlag");
            return (Criteria) this;
        }

        public Criteria andProdValidFlagLike(String value) {
            addCriterion("PROD_VALID_FLAG like", value, "prodValidFlag");
            return (Criteria) this;
        }

        public Criteria andProdValidFlagNotLike(String value) {
            addCriterion("PROD_VALID_FLAG not like", value, "prodValidFlag");
            return (Criteria) this;
        }

        public Criteria andProdValidFlagIn(List<String> values) {
            addCriterion("PROD_VALID_FLAG in", values, "prodValidFlag");
            return (Criteria) this;
        }

        public Criteria andProdValidFlagNotIn(List<String> values) {
            addCriterion("PROD_VALID_FLAG not in", values, "prodValidFlag");
            return (Criteria) this;
        }

        public Criteria andProdValidFlagBetween(String value1, String value2) {
            addCriterion("PROD_VALID_FLAG between", value1, value2, "prodValidFlag");
            return (Criteria) this;
        }

        public Criteria andProdValidFlagNotBetween(String value1, String value2) {
            addCriterion("PROD_VALID_FLAG not between", value1, value2, "prodValidFlag");
            return (Criteria) this;
        }

        public Criteria andProdSaleFlagIsNull() {
            addCriterion("PROD_SALE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andProdSaleFlagIsNotNull() {
            addCriterion("PROD_SALE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andProdSaleFlagEqualTo(String value) {
            addCriterion("PROD_SALE_FLAG =", value, "prodSaleFlag");
            return (Criteria) this;
        }

        public Criteria andProdSaleFlagNotEqualTo(String value) {
            addCriterion("PROD_SALE_FLAG <>", value, "prodSaleFlag");
            return (Criteria) this;
        }

        public Criteria andProdSaleFlagGreaterThan(String value) {
            addCriterion("PROD_SALE_FLAG >", value, "prodSaleFlag");
            return (Criteria) this;
        }

        public Criteria andProdSaleFlagGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_SALE_FLAG >=", value, "prodSaleFlag");
            return (Criteria) this;
        }

        public Criteria andProdSaleFlagLessThan(String value) {
            addCriterion("PROD_SALE_FLAG <", value, "prodSaleFlag");
            return (Criteria) this;
        }

        public Criteria andProdSaleFlagLessThanOrEqualTo(String value) {
            addCriterion("PROD_SALE_FLAG <=", value, "prodSaleFlag");
            return (Criteria) this;
        }

        public Criteria andProdSaleFlagLike(String value) {
            addCriterion("PROD_SALE_FLAG like", value, "prodSaleFlag");
            return (Criteria) this;
        }

        public Criteria andProdSaleFlagNotLike(String value) {
            addCriterion("PROD_SALE_FLAG not like", value, "prodSaleFlag");
            return (Criteria) this;
        }

        public Criteria andProdSaleFlagIn(List<String> values) {
            addCriterion("PROD_SALE_FLAG in", values, "prodSaleFlag");
            return (Criteria) this;
        }

        public Criteria andProdSaleFlagNotIn(List<String> values) {
            addCriterion("PROD_SALE_FLAG not in", values, "prodSaleFlag");
            return (Criteria) this;
        }

        public Criteria andProdSaleFlagBetween(String value1, String value2) {
            addCriterion("PROD_SALE_FLAG between", value1, value2, "prodSaleFlag");
            return (Criteria) this;
        }

        public Criteria andProdSaleFlagNotBetween(String value1, String value2) {
            addCriterion("PROD_SALE_FLAG not between", value1, value2, "prodSaleFlag");
            return (Criteria) this;
        }

        public Criteria andProdParamIsNull() {
            addCriterion("PROD_PARAM is null");
            return (Criteria) this;
        }

        public Criteria andProdParamIsNotNull() {
            addCriterion("PROD_PARAM is not null");
            return (Criteria) this;
        }

        public Criteria andProdParamEqualTo(String value) {
            addCriterion("PROD_PARAM =", value, "prodParam");
            return (Criteria) this;
        }

        public Criteria andProdParamNotEqualTo(String value) {
            addCriterion("PROD_PARAM <>", value, "prodParam");
            return (Criteria) this;
        }

        public Criteria andProdParamGreaterThan(String value) {
            addCriterion("PROD_PARAM >", value, "prodParam");
            return (Criteria) this;
        }

        public Criteria andProdParamGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_PARAM >=", value, "prodParam");
            return (Criteria) this;
        }

        public Criteria andProdParamLessThan(String value) {
            addCriterion("PROD_PARAM <", value, "prodParam");
            return (Criteria) this;
        }

        public Criteria andProdParamLessThanOrEqualTo(String value) {
            addCriterion("PROD_PARAM <=", value, "prodParam");
            return (Criteria) this;
        }

        public Criteria andProdParamLike(String value) {
            addCriterion("PROD_PARAM like", value, "prodParam");
            return (Criteria) this;
        }

        public Criteria andProdParamNotLike(String value) {
            addCriterion("PROD_PARAM not like", value, "prodParam");
            return (Criteria) this;
        }

        public Criteria andProdParamIn(List<String> values) {
            addCriterion("PROD_PARAM in", values, "prodParam");
            return (Criteria) this;
        }

        public Criteria andProdParamNotIn(List<String> values) {
            addCriterion("PROD_PARAM not in", values, "prodParam");
            return (Criteria) this;
        }

        public Criteria andProdParamBetween(String value1, String value2) {
            addCriterion("PROD_PARAM between", value1, value2, "prodParam");
            return (Criteria) this;
        }

        public Criteria andProdParamNotBetween(String value1, String value2) {
            addCriterion("PROD_PARAM not between", value1, value2, "prodParam");
            return (Criteria) this;
        }

        public Criteria andProdOpenRestfullIsNull() {
            addCriterion("PROD_OPEN_RESTFULL is null");
            return (Criteria) this;
        }

        public Criteria andProdOpenRestfullIsNotNull() {
            addCriterion("PROD_OPEN_RESTFULL is not null");
            return (Criteria) this;
        }

        public Criteria andProdOpenRestfullEqualTo(String value) {
            addCriterion("PROD_OPEN_RESTFULL =", value, "prodOpenRestfull");
            return (Criteria) this;
        }

        public Criteria andProdOpenRestfullNotEqualTo(String value) {
            addCriterion("PROD_OPEN_RESTFULL <>", value, "prodOpenRestfull");
            return (Criteria) this;
        }

        public Criteria andProdOpenRestfullGreaterThan(String value) {
            addCriterion("PROD_OPEN_RESTFULL >", value, "prodOpenRestfull");
            return (Criteria) this;
        }

        public Criteria andProdOpenRestfullGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_OPEN_RESTFULL >=", value, "prodOpenRestfull");
            return (Criteria) this;
        }

        public Criteria andProdOpenRestfullLessThan(String value) {
            addCriterion("PROD_OPEN_RESTFULL <", value, "prodOpenRestfull");
            return (Criteria) this;
        }

        public Criteria andProdOpenRestfullLessThanOrEqualTo(String value) {
            addCriterion("PROD_OPEN_RESTFULL <=", value, "prodOpenRestfull");
            return (Criteria) this;
        }

        public Criteria andProdOpenRestfullLike(String value) {
            addCriterion("PROD_OPEN_RESTFULL like", value, "prodOpenRestfull");
            return (Criteria) this;
        }

        public Criteria andProdOpenRestfullNotLike(String value) {
            addCriterion("PROD_OPEN_RESTFULL not like", value, "prodOpenRestfull");
            return (Criteria) this;
        }

        public Criteria andProdOpenRestfullIn(List<String> values) {
            addCriterion("PROD_OPEN_RESTFULL in", values, "prodOpenRestfull");
            return (Criteria) this;
        }

        public Criteria andProdOpenRestfullNotIn(List<String> values) {
            addCriterion("PROD_OPEN_RESTFULL not in", values, "prodOpenRestfull");
            return (Criteria) this;
        }

        public Criteria andProdOpenRestfullBetween(String value1, String value2) {
            addCriterion("PROD_OPEN_RESTFULL between", value1, value2, "prodOpenRestfull");
            return (Criteria) this;
        }

        public Criteria andProdOpenRestfullNotBetween(String value1, String value2) {
            addCriterion("PROD_OPEN_RESTFULL not between", value1, value2, "prodOpenRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStartRestfullIsNull() {
            addCriterion("PROD_START_RESTFULL is null");
            return (Criteria) this;
        }

        public Criteria andProdStartRestfullIsNotNull() {
            addCriterion("PROD_START_RESTFULL is not null");
            return (Criteria) this;
        }

        public Criteria andProdStartRestfullEqualTo(String value) {
            addCriterion("PROD_START_RESTFULL =", value, "prodStartRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStartRestfullNotEqualTo(String value) {
            addCriterion("PROD_START_RESTFULL <>", value, "prodStartRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStartRestfullGreaterThan(String value) {
            addCriterion("PROD_START_RESTFULL >", value, "prodStartRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStartRestfullGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_START_RESTFULL >=", value, "prodStartRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStartRestfullLessThan(String value) {
            addCriterion("PROD_START_RESTFULL <", value, "prodStartRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStartRestfullLessThanOrEqualTo(String value) {
            addCriterion("PROD_START_RESTFULL <=", value, "prodStartRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStartRestfullLike(String value) {
            addCriterion("PROD_START_RESTFULL like", value, "prodStartRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStartRestfullNotLike(String value) {
            addCriterion("PROD_START_RESTFULL not like", value, "prodStartRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStartRestfullIn(List<String> values) {
            addCriterion("PROD_START_RESTFULL in", values, "prodStartRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStartRestfullNotIn(List<String> values) {
            addCriterion("PROD_START_RESTFULL not in", values, "prodStartRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStartRestfullBetween(String value1, String value2) {
            addCriterion("PROD_START_RESTFULL between", value1, value2, "prodStartRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStartRestfullNotBetween(String value1, String value2) {
            addCriterion("PROD_START_RESTFULL not between", value1, value2, "prodStartRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStopRestfullIsNull() {
            addCriterion("PROD_STOP_RESTFULL is null");
            return (Criteria) this;
        }

        public Criteria andProdStopRestfullIsNotNull() {
            addCriterion("PROD_STOP_RESTFULL is not null");
            return (Criteria) this;
        }

        public Criteria andProdStopRestfullEqualTo(String value) {
            addCriterion("PROD_STOP_RESTFULL =", value, "prodStopRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStopRestfullNotEqualTo(String value) {
            addCriterion("PROD_STOP_RESTFULL <>", value, "prodStopRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStopRestfullGreaterThan(String value) {
            addCriterion("PROD_STOP_RESTFULL >", value, "prodStopRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStopRestfullGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_STOP_RESTFULL >=", value, "prodStopRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStopRestfullLessThan(String value) {
            addCriterion("PROD_STOP_RESTFULL <", value, "prodStopRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStopRestfullLessThanOrEqualTo(String value) {
            addCriterion("PROD_STOP_RESTFULL <=", value, "prodStopRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStopRestfullLike(String value) {
            addCriterion("PROD_STOP_RESTFULL like", value, "prodStopRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStopRestfullNotLike(String value) {
            addCriterion("PROD_STOP_RESTFULL not like", value, "prodStopRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStopRestfullIn(List<String> values) {
            addCriterion("PROD_STOP_RESTFULL in", values, "prodStopRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStopRestfullNotIn(List<String> values) {
            addCriterion("PROD_STOP_RESTFULL not in", values, "prodStopRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStopRestfullBetween(String value1, String value2) {
            addCriterion("PROD_STOP_RESTFULL between", value1, value2, "prodStopRestfull");
            return (Criteria) this;
        }

        public Criteria andProdStopRestfullNotBetween(String value1, String value2) {
            addCriterion("PROD_STOP_RESTFULL not between", value1, value2, "prodStopRestfull");
            return (Criteria) this;
        }

        public Criteria andProdMdypwdRestfullIsNull() {
            addCriterion("PROD_MDYPWD_RESTFULL is null");
            return (Criteria) this;
        }

        public Criteria andProdMdypwdRestfullIsNotNull() {
            addCriterion("PROD_MDYPWD_RESTFULL is not null");
            return (Criteria) this;
        }

        public Criteria andProdMdypwdRestfullEqualTo(String value) {
            addCriterion("PROD_MDYPWD_RESTFULL =", value, "prodMdypwdRestfull");
            return (Criteria) this;
        }

        public Criteria andProdMdypwdRestfullNotEqualTo(String value) {
            addCriterion("PROD_MDYPWD_RESTFULL <>", value, "prodMdypwdRestfull");
            return (Criteria) this;
        }

        public Criteria andProdMdypwdRestfullGreaterThan(String value) {
            addCriterion("PROD_MDYPWD_RESTFULL >", value, "prodMdypwdRestfull");
            return (Criteria) this;
        }

        public Criteria andProdMdypwdRestfullGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_MDYPWD_RESTFULL >=", value, "prodMdypwdRestfull");
            return (Criteria) this;
        }

        public Criteria andProdMdypwdRestfullLessThan(String value) {
            addCriterion("PROD_MDYPWD_RESTFULL <", value, "prodMdypwdRestfull");
            return (Criteria) this;
        }

        public Criteria andProdMdypwdRestfullLessThanOrEqualTo(String value) {
            addCriterion("PROD_MDYPWD_RESTFULL <=", value, "prodMdypwdRestfull");
            return (Criteria) this;
        }

        public Criteria andProdMdypwdRestfullLike(String value) {
            addCriterion("PROD_MDYPWD_RESTFULL like", value, "prodMdypwdRestfull");
            return (Criteria) this;
        }

        public Criteria andProdMdypwdRestfullNotLike(String value) {
            addCriterion("PROD_MDYPWD_RESTFULL not like", value, "prodMdypwdRestfull");
            return (Criteria) this;
        }

        public Criteria andProdMdypwdRestfullIn(List<String> values) {
            addCriterion("PROD_MDYPWD_RESTFULL in", values, "prodMdypwdRestfull");
            return (Criteria) this;
        }

        public Criteria andProdMdypwdRestfullNotIn(List<String> values) {
            addCriterion("PROD_MDYPWD_RESTFULL not in", values, "prodMdypwdRestfull");
            return (Criteria) this;
        }

        public Criteria andProdMdypwdRestfullBetween(String value1, String value2) {
            addCriterion("PROD_MDYPWD_RESTFULL between", value1, value2, "prodMdypwdRestfull");
            return (Criteria) this;
        }

        public Criteria andProdMdypwdRestfullNotBetween(String value1, String value2) {
            addCriterion("PROD_MDYPWD_RESTFULL not between", value1, value2, "prodMdypwdRestfull");
            return (Criteria) this;
        }

        public Criteria andProdFullclearRestfullIsNull() {
            addCriterion("PROD_FULLCLEAR_RESTFULL is null");
            return (Criteria) this;
        }

        public Criteria andProdFullclearRestfullIsNotNull() {
            addCriterion("PROD_FULLCLEAR_RESTFULL is not null");
            return (Criteria) this;
        }

        public Criteria andProdFullclearRestfullEqualTo(String value) {
            addCriterion("PROD_FULLCLEAR_RESTFULL =", value, "prodFullclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdFullclearRestfullNotEqualTo(String value) {
            addCriterion("PROD_FULLCLEAR_RESTFULL <>", value, "prodFullclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdFullclearRestfullGreaterThan(String value) {
            addCriterion("PROD_FULLCLEAR_RESTFULL >", value, "prodFullclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdFullclearRestfullGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_FULLCLEAR_RESTFULL >=", value, "prodFullclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdFullclearRestfullLessThan(String value) {
            addCriterion("PROD_FULLCLEAR_RESTFULL <", value, "prodFullclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdFullclearRestfullLessThanOrEqualTo(String value) {
            addCriterion("PROD_FULLCLEAR_RESTFULL <=", value, "prodFullclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdFullclearRestfullLike(String value) {
            addCriterion("PROD_FULLCLEAR_RESTFULL like", value, "prodFullclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdFullclearRestfullNotLike(String value) {
            addCriterion("PROD_FULLCLEAR_RESTFULL not like", value, "prodFullclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdFullclearRestfullIn(List<String> values) {
            addCriterion("PROD_FULLCLEAR_RESTFULL in", values, "prodFullclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdFullclearRestfullNotIn(List<String> values) {
            addCriterion("PROD_FULLCLEAR_RESTFULL not in", values, "prodFullclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdFullclearRestfullBetween(String value1, String value2) {
            addCriterion("PROD_FULLCLEAR_RESTFULL between", value1, value2, "prodFullclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdFullclearRestfullNotBetween(String value1, String value2) {
            addCriterion("PROD_FULLCLEAR_RESTFULL not between", value1, value2, "prodFullclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdKeyclearRestfullIsNull() {
            addCriterion("PROD_KEYCLEAR_RESTFULL is null");
            return (Criteria) this;
        }

        public Criteria andProdKeyclearRestfullIsNotNull() {
            addCriterion("PROD_KEYCLEAR_RESTFULL is not null");
            return (Criteria) this;
        }

        public Criteria andProdKeyclearRestfullEqualTo(String value) {
            addCriterion("PROD_KEYCLEAR_RESTFULL =", value, "prodKeyclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdKeyclearRestfullNotEqualTo(String value) {
            addCriterion("PROD_KEYCLEAR_RESTFULL <>", value, "prodKeyclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdKeyclearRestfullGreaterThan(String value) {
            addCriterion("PROD_KEYCLEAR_RESTFULL >", value, "prodKeyclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdKeyclearRestfullGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_KEYCLEAR_RESTFULL >=", value, "prodKeyclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdKeyclearRestfullLessThan(String value) {
            addCriterion("PROD_KEYCLEAR_RESTFULL <", value, "prodKeyclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdKeyclearRestfullLessThanOrEqualTo(String value) {
            addCriterion("PROD_KEYCLEAR_RESTFULL <=", value, "prodKeyclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdKeyclearRestfullLike(String value) {
            addCriterion("PROD_KEYCLEAR_RESTFULL like", value, "prodKeyclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdKeyclearRestfullNotLike(String value) {
            addCriterion("PROD_KEYCLEAR_RESTFULL not like", value, "prodKeyclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdKeyclearRestfullIn(List<String> values) {
            addCriterion("PROD_KEYCLEAR_RESTFULL in", values, "prodKeyclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdKeyclearRestfullNotIn(List<String> values) {
            addCriterion("PROD_KEYCLEAR_RESTFULL not in", values, "prodKeyclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdKeyclearRestfullBetween(String value1, String value2) {
            addCriterion("PROD_KEYCLEAR_RESTFULL between", value1, value2, "prodKeyclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdKeyclearRestfullNotBetween(String value1, String value2) {
            addCriterion("PROD_KEYCLEAR_RESTFULL not between", value1, value2, "prodKeyclearRestfull");
            return (Criteria) this;
        }

        public Criteria andProdSeltedkeyRestfullIsNull() {
            addCriterion("PROD_SELTEDKEY_RESTFULL is null");
            return (Criteria) this;
        }

        public Criteria andProdSeltedkeyRestfullIsNotNull() {
            addCriterion("PROD_SELTEDKEY_RESTFULL is not null");
            return (Criteria) this;
        }

        public Criteria andProdSeltedkeyRestfullEqualTo(String value) {
            addCriterion("PROD_SELTEDKEY_RESTFULL =", value, "prodSeltedkeyRestfull");
            return (Criteria) this;
        }

        public Criteria andProdSeltedkeyRestfullNotEqualTo(String value) {
            addCriterion("PROD_SELTEDKEY_RESTFULL <>", value, "prodSeltedkeyRestfull");
            return (Criteria) this;
        }

        public Criteria andProdSeltedkeyRestfullGreaterThan(String value) {
            addCriterion("PROD_SELTEDKEY_RESTFULL >", value, "prodSeltedkeyRestfull");
            return (Criteria) this;
        }

        public Criteria andProdSeltedkeyRestfullGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_SELTEDKEY_RESTFULL >=", value, "prodSeltedkeyRestfull");
            return (Criteria) this;
        }

        public Criteria andProdSeltedkeyRestfullLessThan(String value) {
            addCriterion("PROD_SELTEDKEY_RESTFULL <", value, "prodSeltedkeyRestfull");
            return (Criteria) this;
        }

        public Criteria andProdSeltedkeyRestfullLessThanOrEqualTo(String value) {
            addCriterion("PROD_SELTEDKEY_RESTFULL <=", value, "prodSeltedkeyRestfull");
            return (Criteria) this;
        }

        public Criteria andProdSeltedkeyRestfullLike(String value) {
            addCriterion("PROD_SELTEDKEY_RESTFULL like", value, "prodSeltedkeyRestfull");
            return (Criteria) this;
        }

        public Criteria andProdSeltedkeyRestfullNotLike(String value) {
            addCriterion("PROD_SELTEDKEY_RESTFULL not like", value, "prodSeltedkeyRestfull");
            return (Criteria) this;
        }

        public Criteria andProdSeltedkeyRestfullIn(List<String> values) {
            addCriterion("PROD_SELTEDKEY_RESTFULL in", values, "prodSeltedkeyRestfull");
            return (Criteria) this;
        }

        public Criteria andProdSeltedkeyRestfullNotIn(List<String> values) {
            addCriterion("PROD_SELTEDKEY_RESTFULL not in", values, "prodSeltedkeyRestfull");
            return (Criteria) this;
        }

        public Criteria andProdSeltedkeyRestfullBetween(String value1, String value2) {
            addCriterion("PROD_SELTEDKEY_RESTFULL between", value1, value2, "prodSeltedkeyRestfull");
            return (Criteria) this;
        }

        public Criteria andProdSeltedkeyRestfullNotBetween(String value1, String value2) {
            addCriterion("PROD_SELTEDKEY_RESTFULL not between", value1, value2, "prodSeltedkeyRestfull");
            return (Criteria) this;
        }

        public Criteria andProdCancleRestfullIsNull() {
            addCriterion("PROD_CANCLE_RESTFULL is null");
            return (Criteria) this;
        }

        public Criteria andProdCancleRestfullIsNotNull() {
            addCriterion("PROD_CANCLE_RESTFULL is not null");
            return (Criteria) this;
        }

        public Criteria andProdCancleRestfullEqualTo(String value) {
            addCriterion("PROD_CANCLE_RESTFULL =", value, "prodCancleRestfull");
            return (Criteria) this;
        }

        public Criteria andProdCancleRestfullNotEqualTo(String value) {
            addCriterion("PROD_CANCLE_RESTFULL <>", value, "prodCancleRestfull");
            return (Criteria) this;
        }

        public Criteria andProdCancleRestfullGreaterThan(String value) {
            addCriterion("PROD_CANCLE_RESTFULL >", value, "prodCancleRestfull");
            return (Criteria) this;
        }

        public Criteria andProdCancleRestfullGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_CANCLE_RESTFULL >=", value, "prodCancleRestfull");
            return (Criteria) this;
        }

        public Criteria andProdCancleRestfullLessThan(String value) {
            addCriterion("PROD_CANCLE_RESTFULL <", value, "prodCancleRestfull");
            return (Criteria) this;
        }

        public Criteria andProdCancleRestfullLessThanOrEqualTo(String value) {
            addCriterion("PROD_CANCLE_RESTFULL <=", value, "prodCancleRestfull");
            return (Criteria) this;
        }

        public Criteria andProdCancleRestfullLike(String value) {
            addCriterion("PROD_CANCLE_RESTFULL like", value, "prodCancleRestfull");
            return (Criteria) this;
        }

        public Criteria andProdCancleRestfullNotLike(String value) {
            addCriterion("PROD_CANCLE_RESTFULL not like", value, "prodCancleRestfull");
            return (Criteria) this;
        }

        public Criteria andProdCancleRestfullIn(List<String> values) {
            addCriterion("PROD_CANCLE_RESTFULL in", values, "prodCancleRestfull");
            return (Criteria) this;
        }

        public Criteria andProdCancleRestfullNotIn(List<String> values) {
            addCriterion("PROD_CANCLE_RESTFULL not in", values, "prodCancleRestfull");
            return (Criteria) this;
        }

        public Criteria andProdCancleRestfullBetween(String value1, String value2) {
            addCriterion("PROD_CANCLE_RESTFULL between", value1, value2, "prodCancleRestfull");
            return (Criteria) this;
        }

        public Criteria andProdCancleRestfullNotBetween(String value1, String value2) {
            addCriterion("PROD_CANCLE_RESTFULL not between", value1, value2, "prodCancleRestfull");
            return (Criteria) this;
        }

        public Criteria andProdUsedAmountRestfullIsNull() {
            addCriterion("PROD_USED_AMOUNT_RESTFULL is null");
            return (Criteria) this;
        }

        public Criteria andProdUsedAmountRestfullIsNotNull() {
            addCriterion("PROD_USED_AMOUNT_RESTFULL is not null");
            return (Criteria) this;
        }

        public Criteria andProdUsedAmountRestfullEqualTo(String value) {
            addCriterion("PROD_USED_AMOUNT_RESTFULL =", value, "prodUsedAmountRestfull");
            return (Criteria) this;
        }

        public Criteria andProdUsedAmountRestfullNotEqualTo(String value) {
            addCriterion("PROD_USED_AMOUNT_RESTFULL <>", value, "prodUsedAmountRestfull");
            return (Criteria) this;
        }

        public Criteria andProdUsedAmountRestfullGreaterThan(String value) {
            addCriterion("PROD_USED_AMOUNT_RESTFULL >", value, "prodUsedAmountRestfull");
            return (Criteria) this;
        }

        public Criteria andProdUsedAmountRestfullGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_USED_AMOUNT_RESTFULL >=", value, "prodUsedAmountRestfull");
            return (Criteria) this;
        }

        public Criteria andProdUsedAmountRestfullLessThan(String value) {
            addCriterion("PROD_USED_AMOUNT_RESTFULL <", value, "prodUsedAmountRestfull");
            return (Criteria) this;
        }

        public Criteria andProdUsedAmountRestfullLessThanOrEqualTo(String value) {
            addCriterion("PROD_USED_AMOUNT_RESTFULL <=", value, "prodUsedAmountRestfull");
            return (Criteria) this;
        }

        public Criteria andProdUsedAmountRestfullLike(String value) {
            addCriterion("PROD_USED_AMOUNT_RESTFULL like", value, "prodUsedAmountRestfull");
            return (Criteria) this;
        }

        public Criteria andProdUsedAmountRestfullNotLike(String value) {
            addCriterion("PROD_USED_AMOUNT_RESTFULL not like", value, "prodUsedAmountRestfull");
            return (Criteria) this;
        }

        public Criteria andProdUsedAmountRestfullIn(List<String> values) {
            addCriterion("PROD_USED_AMOUNT_RESTFULL in", values, "prodUsedAmountRestfull");
            return (Criteria) this;
        }

        public Criteria andProdUsedAmountRestfullNotIn(List<String> values) {
            addCriterion("PROD_USED_AMOUNT_RESTFULL not in", values, "prodUsedAmountRestfull");
            return (Criteria) this;
        }

        public Criteria andProdUsedAmountRestfullBetween(String value1, String value2) {
            addCriterion("PROD_USED_AMOUNT_RESTFULL between", value1, value2, "prodUsedAmountRestfull");
            return (Criteria) this;
        }

        public Criteria andProdUsedAmountRestfullNotBetween(String value1, String value2) {
            addCriterion("PROD_USED_AMOUNT_RESTFULL not between", value1, value2, "prodUsedAmountRestfull");
            return (Criteria) this;
        }

        public Criteria andProdBindRestfulIsNull() {
            addCriterion("PROD_BIND_RESTFUL is null");
            return (Criteria) this;
        }

        public Criteria andProdBindRestfulIsNotNull() {
            addCriterion("PROD_BIND_RESTFUL is not null");
            return (Criteria) this;
        }

        public Criteria andProdBindRestfulEqualTo(String value) {
            addCriterion("PROD_BIND_RESTFUL =", value, "prodBindRestful");
            return (Criteria) this;
        }

        public Criteria andProdBindRestfulNotEqualTo(String value) {
            addCriterion("PROD_BIND_RESTFUL <>", value, "prodBindRestful");
            return (Criteria) this;
        }

        public Criteria andProdBindRestfulGreaterThan(String value) {
            addCriterion("PROD_BIND_RESTFUL >", value, "prodBindRestful");
            return (Criteria) this;
        }

        public Criteria andProdBindRestfulGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_BIND_RESTFUL >=", value, "prodBindRestful");
            return (Criteria) this;
        }

        public Criteria andProdBindRestfulLessThan(String value) {
            addCriterion("PROD_BIND_RESTFUL <", value, "prodBindRestful");
            return (Criteria) this;
        }

        public Criteria andProdBindRestfulLessThanOrEqualTo(String value) {
            addCriterion("PROD_BIND_RESTFUL <=", value, "prodBindRestful");
            return (Criteria) this;
        }

        public Criteria andProdBindRestfulLike(String value) {
            addCriterion("PROD_BIND_RESTFUL like", value, "prodBindRestful");
            return (Criteria) this;
        }

        public Criteria andProdBindRestfulNotLike(String value) {
            addCriterion("PROD_BIND_RESTFUL not like", value, "prodBindRestful");
            return (Criteria) this;
        }

        public Criteria andProdBindRestfulIn(List<String> values) {
            addCriterion("PROD_BIND_RESTFUL in", values, "prodBindRestful");
            return (Criteria) this;
        }

        public Criteria andProdBindRestfulNotIn(List<String> values) {
            addCriterion("PROD_BIND_RESTFUL not in", values, "prodBindRestful");
            return (Criteria) this;
        }

        public Criteria andProdBindRestfulBetween(String value1, String value2) {
            addCriterion("PROD_BIND_RESTFUL between", value1, value2, "prodBindRestful");
            return (Criteria) this;
        }

        public Criteria andProdBindRestfulNotBetween(String value1, String value2) {
            addCriterion("PROD_BIND_RESTFUL not between", value1, value2, "prodBindRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundRestfulIsNull() {
            addCriterion("PROD_GETBOUND_RESTFUL is null");
            return (Criteria) this;
        }

        public Criteria andProdGetboundRestfulIsNotNull() {
            addCriterion("PROD_GETBOUND_RESTFUL is not null");
            return (Criteria) this;
        }

        public Criteria andProdGetboundRestfulEqualTo(String value) {
            addCriterion("PROD_GETBOUND_RESTFUL =", value, "prodGetboundRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundRestfulNotEqualTo(String value) {
            addCriterion("PROD_GETBOUND_RESTFUL <>", value, "prodGetboundRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundRestfulGreaterThan(String value) {
            addCriterion("PROD_GETBOUND_RESTFUL >", value, "prodGetboundRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundRestfulGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_GETBOUND_RESTFUL >=", value, "prodGetboundRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundRestfulLessThan(String value) {
            addCriterion("PROD_GETBOUND_RESTFUL <", value, "prodGetboundRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundRestfulLessThanOrEqualTo(String value) {
            addCriterion("PROD_GETBOUND_RESTFUL <=", value, "prodGetboundRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundRestfulLike(String value) {
            addCriterion("PROD_GETBOUND_RESTFUL like", value, "prodGetboundRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundRestfulNotLike(String value) {
            addCriterion("PROD_GETBOUND_RESTFUL not like", value, "prodGetboundRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundRestfulIn(List<String> values) {
            addCriterion("PROD_GETBOUND_RESTFUL in", values, "prodGetboundRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundRestfulNotIn(List<String> values) {
            addCriterion("PROD_GETBOUND_RESTFUL not in", values, "prodGetboundRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundRestfulBetween(String value1, String value2) {
            addCriterion("PROD_GETBOUND_RESTFUL between", value1, value2, "prodGetboundRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundRestfulNotBetween(String value1, String value2) {
            addCriterion("PROD_GETBOUND_RESTFUL not between", value1, value2, "prodGetboundRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundtableinfoRestfulIsNull() {
            addCriterion("PROD_GetBoundTableInfo_RESTFUL is null");
            return (Criteria) this;
        }

        public Criteria andProdGetboundtableinfoRestfulIsNotNull() {
            addCriterion("PROD_GetBoundTableInfo_RESTFUL is not null");
            return (Criteria) this;
        }

        public Criteria andProdGetboundtableinfoRestfulEqualTo(String value) {
            addCriterion("PROD_GetBoundTableInfo_RESTFUL =", value, "prodGetboundtableinfoRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundtableinfoRestfulNotEqualTo(String value) {
            addCriterion("PROD_GetBoundTableInfo_RESTFUL <>", value, "prodGetboundtableinfoRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundtableinfoRestfulGreaterThan(String value) {
            addCriterion("PROD_GetBoundTableInfo_RESTFUL >", value, "prodGetboundtableinfoRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundtableinfoRestfulGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_GetBoundTableInfo_RESTFUL >=", value, "prodGetboundtableinfoRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundtableinfoRestfulLessThan(String value) {
            addCriterion("PROD_GetBoundTableInfo_RESTFUL <", value, "prodGetboundtableinfoRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundtableinfoRestfulLessThanOrEqualTo(String value) {
            addCriterion("PROD_GetBoundTableInfo_RESTFUL <=", value, "prodGetboundtableinfoRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundtableinfoRestfulLike(String value) {
            addCriterion("PROD_GetBoundTableInfo_RESTFUL like", value, "prodGetboundtableinfoRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundtableinfoRestfulNotLike(String value) {
            addCriterion("PROD_GetBoundTableInfo_RESTFUL not like", value, "prodGetboundtableinfoRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundtableinfoRestfulIn(List<String> values) {
            addCriterion("PROD_GetBoundTableInfo_RESTFUL in", values, "prodGetboundtableinfoRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundtableinfoRestfulNotIn(List<String> values) {
            addCriterion("PROD_GetBoundTableInfo_RESTFUL not in", values, "prodGetboundtableinfoRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundtableinfoRestfulBetween(String value1, String value2) {
            addCriterion("PROD_GetBoundTableInfo_RESTFUL between", value1, value2, "prodGetboundtableinfoRestful");
            return (Criteria) this;
        }

        public Criteria andProdGetboundtableinfoRestfulNotBetween(String value1, String value2) {
            addCriterion("PROD_GetBoundTableInfo_RESTFUL not between", value1, value2, "prodGetboundtableinfoRestful");
            return (Criteria) this;
        }

        public Criteria andProdUnbindRestfulIsNull() {
            addCriterion("PROD_UNBIND_RESTFUL is null");
            return (Criteria) this;
        }

        public Criteria andProdUnbindRestfulIsNotNull() {
            addCriterion("PROD_UNBIND_RESTFUL is not null");
            return (Criteria) this;
        }

        public Criteria andProdUnbindRestfulEqualTo(String value) {
            addCriterion("PROD_UNBIND_RESTFUL =", value, "prodUnbindRestful");
            return (Criteria) this;
        }

        public Criteria andProdUnbindRestfulNotEqualTo(String value) {
            addCriterion("PROD_UNBIND_RESTFUL <>", value, "prodUnbindRestful");
            return (Criteria) this;
        }

        public Criteria andProdUnbindRestfulGreaterThan(String value) {
            addCriterion("PROD_UNBIND_RESTFUL >", value, "prodUnbindRestful");
            return (Criteria) this;
        }

        public Criteria andProdUnbindRestfulGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_UNBIND_RESTFUL >=", value, "prodUnbindRestful");
            return (Criteria) this;
        }

        public Criteria andProdUnbindRestfulLessThan(String value) {
            addCriterion("PROD_UNBIND_RESTFUL <", value, "prodUnbindRestful");
            return (Criteria) this;
        }

        public Criteria andProdUnbindRestfulLessThanOrEqualTo(String value) {
            addCriterion("PROD_UNBIND_RESTFUL <=", value, "prodUnbindRestful");
            return (Criteria) this;
        }

        public Criteria andProdUnbindRestfulLike(String value) {
            addCriterion("PROD_UNBIND_RESTFUL like", value, "prodUnbindRestful");
            return (Criteria) this;
        }

        public Criteria andProdUnbindRestfulNotLike(String value) {
            addCriterion("PROD_UNBIND_RESTFUL not like", value, "prodUnbindRestful");
            return (Criteria) this;
        }

        public Criteria andProdUnbindRestfulIn(List<String> values) {
            addCriterion("PROD_UNBIND_RESTFUL in", values, "prodUnbindRestful");
            return (Criteria) this;
        }

        public Criteria andProdUnbindRestfulNotIn(List<String> values) {
            addCriterion("PROD_UNBIND_RESTFUL not in", values, "prodUnbindRestful");
            return (Criteria) this;
        }

        public Criteria andProdUnbindRestfulBetween(String value1, String value2) {
            addCriterion("PROD_UNBIND_RESTFUL between", value1, value2, "prodUnbindRestful");
            return (Criteria) this;
        }

        public Criteria andProdUnbindRestfulNotBetween(String value1, String value2) {
            addCriterion("PROD_UNBIND_RESTFUL not between", value1, value2, "prodUnbindRestful");
            return (Criteria) this;
        }

        public Criteria andProdFiltertableRestfulIsNull() {
            addCriterion("PROD_FilterTable_RESTFUL is null");
            return (Criteria) this;
        }

        public Criteria andProdFiltertableRestfulIsNotNull() {
            addCriterion("PROD_FilterTable_RESTFUL is not null");
            return (Criteria) this;
        }

        public Criteria andProdFiltertableRestfulEqualTo(String value) {
            addCriterion("PROD_FilterTable_RESTFUL =", value, "prodFiltertableRestful");
            return (Criteria) this;
        }

        public Criteria andProdFiltertableRestfulNotEqualTo(String value) {
            addCriterion("PROD_FilterTable_RESTFUL <>", value, "prodFiltertableRestful");
            return (Criteria) this;
        }

        public Criteria andProdFiltertableRestfulGreaterThan(String value) {
            addCriterion("PROD_FilterTable_RESTFUL >", value, "prodFiltertableRestful");
            return (Criteria) this;
        }

        public Criteria andProdFiltertableRestfulGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_FilterTable_RESTFUL >=", value, "prodFiltertableRestful");
            return (Criteria) this;
        }

        public Criteria andProdFiltertableRestfulLessThan(String value) {
            addCriterion("PROD_FilterTable_RESTFUL <", value, "prodFiltertableRestful");
            return (Criteria) this;
        }

        public Criteria andProdFiltertableRestfulLessThanOrEqualTo(String value) {
            addCriterion("PROD_FilterTable_RESTFUL <=", value, "prodFiltertableRestful");
            return (Criteria) this;
        }

        public Criteria andProdFiltertableRestfulLike(String value) {
            addCriterion("PROD_FilterTable_RESTFUL like", value, "prodFiltertableRestful");
            return (Criteria) this;
        }

        public Criteria andProdFiltertableRestfulNotLike(String value) {
            addCriterion("PROD_FilterTable_RESTFUL not like", value, "prodFiltertableRestful");
            return (Criteria) this;
        }

        public Criteria andProdFiltertableRestfulIn(List<String> values) {
            addCriterion("PROD_FilterTable_RESTFUL in", values, "prodFiltertableRestful");
            return (Criteria) this;
        }

        public Criteria andProdFiltertableRestfulNotIn(List<String> values) {
            addCriterion("PROD_FilterTable_RESTFUL not in", values, "prodFiltertableRestful");
            return (Criteria) this;
        }

        public Criteria andProdFiltertableRestfulBetween(String value1, String value2) {
            addCriterion("PROD_FilterTable_RESTFUL between", value1, value2, "prodFiltertableRestful");
            return (Criteria) this;
        }

        public Criteria andProdFiltertableRestfulNotBetween(String value1, String value2) {
            addCriterion("PROD_FilterTable_RESTFUL not between", value1, value2, "prodFiltertableRestful");
            return (Criteria) this;
        }

        public Criteria andExpanseCapacityRestfulIsNull() {
            addCriterion("EXPANSE_CAPACITY_RESTFUL is null");
            return (Criteria) this;
        }

        public Criteria andExpanseCapacityRestfulIsNotNull() {
            addCriterion("EXPANSE_CAPACITY_RESTFUL is not null");
            return (Criteria) this;
        }

        public Criteria andExpanseCapacityRestfulEqualTo(String value) {
            addCriterion("EXPANSE_CAPACITY_RESTFUL =", value, "expanseCapacityRestful");
            return (Criteria) this;
        }

        public Criteria andExpanseCapacityRestfulNotEqualTo(String value) {
            addCriterion("EXPANSE_CAPACITY_RESTFUL <>", value, "expanseCapacityRestful");
            return (Criteria) this;
        }

        public Criteria andExpanseCapacityRestfulGreaterThan(String value) {
            addCriterion("EXPANSE_CAPACITY_RESTFUL >", value, "expanseCapacityRestful");
            return (Criteria) this;
        }

        public Criteria andExpanseCapacityRestfulGreaterThanOrEqualTo(String value) {
            addCriterion("EXPANSE_CAPACITY_RESTFUL >=", value, "expanseCapacityRestful");
            return (Criteria) this;
        }

        public Criteria andExpanseCapacityRestfulLessThan(String value) {
            addCriterion("EXPANSE_CAPACITY_RESTFUL <", value, "expanseCapacityRestful");
            return (Criteria) this;
        }

        public Criteria andExpanseCapacityRestfulLessThanOrEqualTo(String value) {
            addCriterion("EXPANSE_CAPACITY_RESTFUL <=", value, "expanseCapacityRestful");
            return (Criteria) this;
        }

        public Criteria andExpanseCapacityRestfulLike(String value) {
            addCriterion("EXPANSE_CAPACITY_RESTFUL like", value, "expanseCapacityRestful");
            return (Criteria) this;
        }

        public Criteria andExpanseCapacityRestfulNotLike(String value) {
            addCriterion("EXPANSE_CAPACITY_RESTFUL not like", value, "expanseCapacityRestful");
            return (Criteria) this;
        }

        public Criteria andExpanseCapacityRestfulIn(List<String> values) {
            addCriterion("EXPANSE_CAPACITY_RESTFUL in", values, "expanseCapacityRestful");
            return (Criteria) this;
        }

        public Criteria andExpanseCapacityRestfulNotIn(List<String> values) {
            addCriterion("EXPANSE_CAPACITY_RESTFUL not in", values, "expanseCapacityRestful");
            return (Criteria) this;
        }

        public Criteria andExpanseCapacityRestfulBetween(String value1, String value2) {
            addCriterion("EXPANSE_CAPACITY_RESTFUL between", value1, value2, "expanseCapacityRestful");
            return (Criteria) this;
        }

        public Criteria andExpanseCapacityRestfulNotBetween(String value1, String value2) {
            addCriterion("EXPANSE_CAPACITY_RESTFUL not between", value1, value2, "expanseCapacityRestful");
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
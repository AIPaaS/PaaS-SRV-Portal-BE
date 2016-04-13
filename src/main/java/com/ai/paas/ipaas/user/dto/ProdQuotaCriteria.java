package com.ai.paas.ipaas.user.dto;

import java.util.ArrayList;
import java.util.List;

public class ProdQuotaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public ProdQuotaCriteria() {
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

        public Criteria andProdIdEqualTo(Integer value) {
            addCriterion("PROD_ID =", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotEqualTo(Integer value) {
            addCriterion("PROD_ID <>", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThan(Integer value) {
            addCriterion("PROD_ID >", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROD_ID >=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThan(Integer value) {
            addCriterion("PROD_ID <", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThanOrEqualTo(Integer value) {
            addCriterion("PROD_ID <=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdIn(List<Integer> values) {
            addCriterion("PROD_ID in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotIn(List<Integer> values) {
            addCriterion("PROD_ID not in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdBetween(Integer value1, Integer value2) {
            addCriterion("PROD_ID between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PROD_ID not between", value1, value2, "prodId");
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

        public Criteria andCpuQuotaIsNull() {
            addCriterion("CPU_QUOTA is null");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaIsNotNull() {
            addCriterion("CPU_QUOTA is not null");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaEqualTo(Integer value) {
            addCriterion("CPU_QUOTA =", value, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaNotEqualTo(Integer value) {
            addCriterion("CPU_QUOTA <>", value, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaGreaterThan(Integer value) {
            addCriterion("CPU_QUOTA >", value, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaGreaterThanOrEqualTo(Integer value) {
            addCriterion("CPU_QUOTA >=", value, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaLessThan(Integer value) {
            addCriterion("CPU_QUOTA <", value, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaLessThanOrEqualTo(Integer value) {
            addCriterion("CPU_QUOTA <=", value, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaIn(List<Integer> values) {
            addCriterion("CPU_QUOTA in", values, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaNotIn(List<Integer> values) {
            addCriterion("CPU_QUOTA not in", values, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaBetween(Integer value1, Integer value2) {
            addCriterion("CPU_QUOTA between", value1, value2, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaNotBetween(Integer value1, Integer value2) {
            addCriterion("CPU_QUOTA not between", value1, value2, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaIsNull() {
            addCriterion("MEMORY_QUOTA is null");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaIsNotNull() {
            addCriterion("MEMORY_QUOTA is not null");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaEqualTo(Integer value) {
            addCriterion("MEMORY_QUOTA =", value, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaNotEqualTo(Integer value) {
            addCriterion("MEMORY_QUOTA <>", value, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaGreaterThan(Integer value) {
            addCriterion("MEMORY_QUOTA >", value, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaGreaterThanOrEqualTo(Integer value) {
            addCriterion("MEMORY_QUOTA >=", value, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaLessThan(Integer value) {
            addCriterion("MEMORY_QUOTA <", value, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaLessThanOrEqualTo(Integer value) {
            addCriterion("MEMORY_QUOTA <=", value, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaIn(List<Integer> values) {
            addCriterion("MEMORY_QUOTA in", values, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaNotIn(List<Integer> values) {
            addCriterion("MEMORY_QUOTA not in", values, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaBetween(Integer value1, Integer value2) {
            addCriterion("MEMORY_QUOTA between", value1, value2, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaNotBetween(Integer value1, Integer value2) {
            addCriterion("MEMORY_QUOTA not between", value1, value2, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andDiskSpaceQuotaIsNull() {
            addCriterion("DISK_SPACE_QUOTA is null");
            return (Criteria) this;
        }

        public Criteria andDiskSpaceQuotaIsNotNull() {
            addCriterion("DISK_SPACE_QUOTA is not null");
            return (Criteria) this;
        }

        public Criteria andDiskSpaceQuotaEqualTo(Integer value) {
            addCriterion("DISK_SPACE_QUOTA =", value, "diskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andDiskSpaceQuotaNotEqualTo(Integer value) {
            addCriterion("DISK_SPACE_QUOTA <>", value, "diskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andDiskSpaceQuotaGreaterThan(Integer value) {
            addCriterion("DISK_SPACE_QUOTA >", value, "diskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andDiskSpaceQuotaGreaterThanOrEqualTo(Integer value) {
            addCriterion("DISK_SPACE_QUOTA >=", value, "diskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andDiskSpaceQuotaLessThan(Integer value) {
            addCriterion("DISK_SPACE_QUOTA <", value, "diskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andDiskSpaceQuotaLessThanOrEqualTo(Integer value) {
            addCriterion("DISK_SPACE_QUOTA <=", value, "diskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andDiskSpaceQuotaIn(List<Integer> values) {
            addCriterion("DISK_SPACE_QUOTA in", values, "diskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andDiskSpaceQuotaNotIn(List<Integer> values) {
            addCriterion("DISK_SPACE_QUOTA not in", values, "diskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andDiskSpaceQuotaBetween(Integer value1, Integer value2) {
            addCriterion("DISK_SPACE_QUOTA between", value1, value2, "diskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andDiskSpaceQuotaNotBetween(Integer value1, Integer value2) {
            addCriterion("DISK_SPACE_QUOTA not between", value1, value2, "diskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andRemainCpuQuotaIsNull() {
            addCriterion("REMAIN_CPU_QUOTA is null");
            return (Criteria) this;
        }

        public Criteria andRemainCpuQuotaIsNotNull() {
            addCriterion("REMAIN_CPU_QUOTA is not null");
            return (Criteria) this;
        }

        public Criteria andRemainCpuQuotaEqualTo(Integer value) {
            addCriterion("REMAIN_CPU_QUOTA =", value, "remainCpuQuota");
            return (Criteria) this;
        }

        public Criteria andRemainCpuQuotaNotEqualTo(Integer value) {
            addCriterion("REMAIN_CPU_QUOTA <>", value, "remainCpuQuota");
            return (Criteria) this;
        }

        public Criteria andRemainCpuQuotaGreaterThan(Integer value) {
            addCriterion("REMAIN_CPU_QUOTA >", value, "remainCpuQuota");
            return (Criteria) this;
        }

        public Criteria andRemainCpuQuotaGreaterThanOrEqualTo(Integer value) {
            addCriterion("REMAIN_CPU_QUOTA >=", value, "remainCpuQuota");
            return (Criteria) this;
        }

        public Criteria andRemainCpuQuotaLessThan(Integer value) {
            addCriterion("REMAIN_CPU_QUOTA <", value, "remainCpuQuota");
            return (Criteria) this;
        }

        public Criteria andRemainCpuQuotaLessThanOrEqualTo(Integer value) {
            addCriterion("REMAIN_CPU_QUOTA <=", value, "remainCpuQuota");
            return (Criteria) this;
        }

        public Criteria andRemainCpuQuotaIn(List<Integer> values) {
            addCriterion("REMAIN_CPU_QUOTA in", values, "remainCpuQuota");
            return (Criteria) this;
        }

        public Criteria andRemainCpuQuotaNotIn(List<Integer> values) {
            addCriterion("REMAIN_CPU_QUOTA not in", values, "remainCpuQuota");
            return (Criteria) this;
        }

        public Criteria andRemainCpuQuotaBetween(Integer value1, Integer value2) {
            addCriterion("REMAIN_CPU_QUOTA between", value1, value2, "remainCpuQuota");
            return (Criteria) this;
        }

        public Criteria andRemainCpuQuotaNotBetween(Integer value1, Integer value2) {
            addCriterion("REMAIN_CPU_QUOTA not between", value1, value2, "remainCpuQuota");
            return (Criteria) this;
        }

        public Criteria andRemainMemoryQuotaIsNull() {
            addCriterion("REMAIN_MEMORY_QUOTA is null");
            return (Criteria) this;
        }

        public Criteria andRemainMemoryQuotaIsNotNull() {
            addCriterion("REMAIN_MEMORY_QUOTA is not null");
            return (Criteria) this;
        }

        public Criteria andRemainMemoryQuotaEqualTo(Integer value) {
            addCriterion("REMAIN_MEMORY_QUOTA =", value, "remainMemoryQuota");
            return (Criteria) this;
        }

        public Criteria andRemainMemoryQuotaNotEqualTo(Integer value) {
            addCriterion("REMAIN_MEMORY_QUOTA <>", value, "remainMemoryQuota");
            return (Criteria) this;
        }

        public Criteria andRemainMemoryQuotaGreaterThan(Integer value) {
            addCriterion("REMAIN_MEMORY_QUOTA >", value, "remainMemoryQuota");
            return (Criteria) this;
        }

        public Criteria andRemainMemoryQuotaGreaterThanOrEqualTo(Integer value) {
            addCriterion("REMAIN_MEMORY_QUOTA >=", value, "remainMemoryQuota");
            return (Criteria) this;
        }

        public Criteria andRemainMemoryQuotaLessThan(Integer value) {
            addCriterion("REMAIN_MEMORY_QUOTA <", value, "remainMemoryQuota");
            return (Criteria) this;
        }

        public Criteria andRemainMemoryQuotaLessThanOrEqualTo(Integer value) {
            addCriterion("REMAIN_MEMORY_QUOTA <=", value, "remainMemoryQuota");
            return (Criteria) this;
        }

        public Criteria andRemainMemoryQuotaIn(List<Integer> values) {
            addCriterion("REMAIN_MEMORY_QUOTA in", values, "remainMemoryQuota");
            return (Criteria) this;
        }

        public Criteria andRemainMemoryQuotaNotIn(List<Integer> values) {
            addCriterion("REMAIN_MEMORY_QUOTA not in", values, "remainMemoryQuota");
            return (Criteria) this;
        }

        public Criteria andRemainMemoryQuotaBetween(Integer value1, Integer value2) {
            addCriterion("REMAIN_MEMORY_QUOTA between", value1, value2, "remainMemoryQuota");
            return (Criteria) this;
        }

        public Criteria andRemainMemoryQuotaNotBetween(Integer value1, Integer value2) {
            addCriterion("REMAIN_MEMORY_QUOTA not between", value1, value2, "remainMemoryQuota");
            return (Criteria) this;
        }

        public Criteria andRemainDiskSpaceQuotaIsNull() {
            addCriterion("REMAIN_DISK_SPACE_QUOTA is null");
            return (Criteria) this;
        }

        public Criteria andRemainDiskSpaceQuotaIsNotNull() {
            addCriterion("REMAIN_DISK_SPACE_QUOTA is not null");
            return (Criteria) this;
        }

        public Criteria andRemainDiskSpaceQuotaEqualTo(Integer value) {
            addCriterion("REMAIN_DISK_SPACE_QUOTA =", value, "remainDiskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andRemainDiskSpaceQuotaNotEqualTo(Integer value) {
            addCriterion("REMAIN_DISK_SPACE_QUOTA <>", value, "remainDiskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andRemainDiskSpaceQuotaGreaterThan(Integer value) {
            addCriterion("REMAIN_DISK_SPACE_QUOTA >", value, "remainDiskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andRemainDiskSpaceQuotaGreaterThanOrEqualTo(Integer value) {
            addCriterion("REMAIN_DISK_SPACE_QUOTA >=", value, "remainDiskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andRemainDiskSpaceQuotaLessThan(Integer value) {
            addCriterion("REMAIN_DISK_SPACE_QUOTA <", value, "remainDiskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andRemainDiskSpaceQuotaLessThanOrEqualTo(Integer value) {
            addCriterion("REMAIN_DISK_SPACE_QUOTA <=", value, "remainDiskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andRemainDiskSpaceQuotaIn(List<Integer> values) {
            addCriterion("REMAIN_DISK_SPACE_QUOTA in", values, "remainDiskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andRemainDiskSpaceQuotaNotIn(List<Integer> values) {
            addCriterion("REMAIN_DISK_SPACE_QUOTA not in", values, "remainDiskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andRemainDiskSpaceQuotaBetween(Integer value1, Integer value2) {
            addCriterion("REMAIN_DISK_SPACE_QUOTA between", value1, value2, "remainDiskSpaceQuota");
            return (Criteria) this;
        }

        public Criteria andRemainDiskSpaceQuotaNotBetween(Integer value1, Integer value2) {
            addCriterion("REMAIN_DISK_SPACE_QUOTA not between", value1, value2, "remainDiskSpaceQuota");
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
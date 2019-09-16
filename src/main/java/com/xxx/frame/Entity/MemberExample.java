package com.xxx.frame.Entity;

import java.util.ArrayList;
import java.util.List;

public class MemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMemebernameIsNull() {
            addCriterion("memeberName is null");
            return (Criteria) this;
        }

        public Criteria andMemebernameIsNotNull() {
            addCriterion("memeberName is not null");
            return (Criteria) this;
        }

        public Criteria andMemebernameEqualTo(String value) {
            addCriterion("memeberName =", value, "memebername");
            return (Criteria) this;
        }

        public Criteria andMemebernameNotEqualTo(String value) {
            addCriterion("memeberName <>", value, "memebername");
            return (Criteria) this;
        }

        public Criteria andMemebernameGreaterThan(String value) {
            addCriterion("memeberName >", value, "memebername");
            return (Criteria) this;
        }

        public Criteria andMemebernameGreaterThanOrEqualTo(String value) {
            addCriterion("memeberName >=", value, "memebername");
            return (Criteria) this;
        }

        public Criteria andMemebernameLessThan(String value) {
            addCriterion("memeberName <", value, "memebername");
            return (Criteria) this;
        }

        public Criteria andMemebernameLessThanOrEqualTo(String value) {
            addCriterion("memeberName <=", value, "memebername");
            return (Criteria) this;
        }

        public Criteria andMemebernameLike(String value) {
            addCriterion("memeberName like", value, "memebername");
            return (Criteria) this;
        }

        public Criteria andMemebernameNotLike(String value) {
            addCriterion("memeberName not like", value, "memebername");
            return (Criteria) this;
        }

        public Criteria andMemebernameIn(List<String> values) {
            addCriterion("memeberName in", values, "memebername");
            return (Criteria) this;
        }

        public Criteria andMemebernameNotIn(List<String> values) {
            addCriterion("memeberName not in", values, "memebername");
            return (Criteria) this;
        }

        public Criteria andMemebernameBetween(String value1, String value2) {
            addCriterion("memeberName between", value1, value2, "memebername");
            return (Criteria) this;
        }

        public Criteria andMemebernameNotBetween(String value1, String value2) {
            addCriterion("memeberName not between", value1, value2, "memebername");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeIsNull() {
            addCriterion("certificateType is null");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeIsNotNull() {
            addCriterion("certificateType is not null");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeEqualTo(String value) {
            addCriterion("certificateType =", value, "certificatetype");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeNotEqualTo(String value) {
            addCriterion("certificateType <>", value, "certificatetype");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeGreaterThan(String value) {
            addCriterion("certificateType >", value, "certificatetype");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeGreaterThanOrEqualTo(String value) {
            addCriterion("certificateType >=", value, "certificatetype");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeLessThan(String value) {
            addCriterion("certificateType <", value, "certificatetype");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeLessThanOrEqualTo(String value) {
            addCriterion("certificateType <=", value, "certificatetype");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeLike(String value) {
            addCriterion("certificateType like", value, "certificatetype");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeNotLike(String value) {
            addCriterion("certificateType not like", value, "certificatetype");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeIn(List<String> values) {
            addCriterion("certificateType in", values, "certificatetype");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeNotIn(List<String> values) {
            addCriterion("certificateType not in", values, "certificatetype");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeBetween(String value1, String value2) {
            addCriterion("certificateType between", value1, value2, "certificatetype");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeNotBetween(String value1, String value2) {
            addCriterion("certificateType not between", value1, value2, "certificatetype");
            return (Criteria) this;
        }

        public Criteria andCertificatecodeIsNull() {
            addCriterion("certificateCode is null");
            return (Criteria) this;
        }

        public Criteria andCertificatecodeIsNotNull() {
            addCriterion("certificateCode is not null");
            return (Criteria) this;
        }

        public Criteria andCertificatecodeEqualTo(String value) {
            addCriterion("certificateCode =", value, "certificatecode");
            return (Criteria) this;
        }

        public Criteria andCertificatecodeNotEqualTo(String value) {
            addCriterion("certificateCode <>", value, "certificatecode");
            return (Criteria) this;
        }

        public Criteria andCertificatecodeGreaterThan(String value) {
            addCriterion("certificateCode >", value, "certificatecode");
            return (Criteria) this;
        }

        public Criteria andCertificatecodeGreaterThanOrEqualTo(String value) {
            addCriterion("certificateCode >=", value, "certificatecode");
            return (Criteria) this;
        }

        public Criteria andCertificatecodeLessThan(String value) {
            addCriterion("certificateCode <", value, "certificatecode");
            return (Criteria) this;
        }

        public Criteria andCertificatecodeLessThanOrEqualTo(String value) {
            addCriterion("certificateCode <=", value, "certificatecode");
            return (Criteria) this;
        }

        public Criteria andCertificatecodeLike(String value) {
            addCriterion("certificateCode like", value, "certificatecode");
            return (Criteria) this;
        }

        public Criteria andCertificatecodeNotLike(String value) {
            addCriterion("certificateCode not like", value, "certificatecode");
            return (Criteria) this;
        }

        public Criteria andCertificatecodeIn(List<String> values) {
            addCriterion("certificateCode in", values, "certificatecode");
            return (Criteria) this;
        }

        public Criteria andCertificatecodeNotIn(List<String> values) {
            addCriterion("certificateCode not in", values, "certificatecode");
            return (Criteria) this;
        }

        public Criteria andCertificatecodeBetween(String value1, String value2) {
            addCriterion("certificateCode between", value1, value2, "certificatecode");
            return (Criteria) this;
        }

        public Criteria andCertificatecodeNotBetween(String value1, String value2) {
            addCriterion("certificateCode not between", value1, value2, "certificatecode");
            return (Criteria) this;
        }

        public Criteria andFirmnameIsNull() {
            addCriterion("firmName is null");
            return (Criteria) this;
        }

        public Criteria andFirmnameIsNotNull() {
            addCriterion("firmName is not null");
            return (Criteria) this;
        }

        public Criteria andFirmnameEqualTo(String value) {
            addCriterion("firmName =", value, "firmname");
            return (Criteria) this;
        }

        public Criteria andFirmnameNotEqualTo(String value) {
            addCriterion("firmName <>", value, "firmname");
            return (Criteria) this;
        }

        public Criteria andFirmnameGreaterThan(String value) {
            addCriterion("firmName >", value, "firmname");
            return (Criteria) this;
        }

        public Criteria andFirmnameGreaterThanOrEqualTo(String value) {
            addCriterion("firmName >=", value, "firmname");
            return (Criteria) this;
        }

        public Criteria andFirmnameLessThan(String value) {
            addCriterion("firmName <", value, "firmname");
            return (Criteria) this;
        }

        public Criteria andFirmnameLessThanOrEqualTo(String value) {
            addCriterion("firmName <=", value, "firmname");
            return (Criteria) this;
        }

        public Criteria andFirmnameLike(String value) {
            addCriterion("firmName like", value, "firmname");
            return (Criteria) this;
        }

        public Criteria andFirmnameNotLike(String value) {
            addCriterion("firmName not like", value, "firmname");
            return (Criteria) this;
        }

        public Criteria andFirmnameIn(List<String> values) {
            addCriterion("firmName in", values, "firmname");
            return (Criteria) this;
        }

        public Criteria andFirmnameNotIn(List<String> values) {
            addCriterion("firmName not in", values, "firmname");
            return (Criteria) this;
        }

        public Criteria andFirmnameBetween(String value1, String value2) {
            addCriterion("firmName between", value1, value2, "firmname");
            return (Criteria) this;
        }

        public Criteria andFirmnameNotBetween(String value1, String value2) {
            addCriterion("firmName not between", value1, value2, "firmname");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIsselfIsNull() {
            addCriterion("isSelf is null");
            return (Criteria) this;
        }

        public Criteria andIsselfIsNotNull() {
            addCriterion("isSelf is not null");
            return (Criteria) this;
        }

        public Criteria andIsselfEqualTo(Integer value) {
            addCriterion("isSelf =", value, "isself");
            return (Criteria) this;
        }

        public Criteria andIsselfNotEqualTo(Integer value) {
            addCriterion("isSelf <>", value, "isself");
            return (Criteria) this;
        }

        public Criteria andIsselfGreaterThan(Integer value) {
            addCriterion("isSelf >", value, "isself");
            return (Criteria) this;
        }

        public Criteria andIsselfGreaterThanOrEqualTo(Integer value) {
            addCriterion("isSelf >=", value, "isself");
            return (Criteria) this;
        }

        public Criteria andIsselfLessThan(Integer value) {
            addCriterion("isSelf <", value, "isself");
            return (Criteria) this;
        }

        public Criteria andIsselfLessThanOrEqualTo(Integer value) {
            addCriterion("isSelf <=", value, "isself");
            return (Criteria) this;
        }

        public Criteria andIsselfIn(List<Integer> values) {
            addCriterion("isSelf in", values, "isself");
            return (Criteria) this;
        }

        public Criteria andIsselfNotIn(List<Integer> values) {
            addCriterion("isSelf not in", values, "isself");
            return (Criteria) this;
        }

        public Criteria andIsselfBetween(Integer value1, Integer value2) {
            addCriterion("isSelf between", value1, value2, "isself");
            return (Criteria) this;
        }

        public Criteria andIsselfNotBetween(Integer value1, Integer value2) {
            addCriterion("isSelf not between", value1, value2, "isself");
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
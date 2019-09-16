package com.xxx.frame.Entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClassColumnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassColumnExample() {
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

        public Criteria andColumnnameIsNull() {
            addCriterion("columnName is null");
            return (Criteria) this;
        }

        public Criteria andColumnnameIsNotNull() {
            addCriterion("columnName is not null");
            return (Criteria) this;
        }

        public Criteria andColumnnameEqualTo(String value) {
            addCriterion("columnName =", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotEqualTo(String value) {
            addCriterion("columnName <>", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameGreaterThan(String value) {
            addCriterion("columnName >", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameGreaterThanOrEqualTo(String value) {
            addCriterion("columnName >=", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLessThan(String value) {
            addCriterion("columnName <", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLessThanOrEqualTo(String value) {
            addCriterion("columnName <=", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLike(String value) {
            addCriterion("columnName like", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotLike(String value) {
            addCriterion("columnName not like", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameIn(List<String> values) {
            addCriterion("columnName in", values, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotIn(List<String> values) {
            addCriterion("columnName not in", values, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameBetween(String value1, String value2) {
            addCriterion("columnName between", value1, value2, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotBetween(String value1, String value2) {
            addCriterion("columnName not between", value1, value2, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumncontentIsNull() {
            addCriterion("columnContent is null");
            return (Criteria) this;
        }

        public Criteria andColumncontentIsNotNull() {
            addCriterion("columnContent is not null");
            return (Criteria) this;
        }

        public Criteria andColumncontentEqualTo(String value) {
            addCriterion("columnContent =", value, "columncontent");
            return (Criteria) this;
        }

        public Criteria andColumncontentNotEqualTo(String value) {
            addCriterion("columnContent <>", value, "columncontent");
            return (Criteria) this;
        }

        public Criteria andColumncontentGreaterThan(String value) {
            addCriterion("columnContent >", value, "columncontent");
            return (Criteria) this;
        }

        public Criteria andColumncontentGreaterThanOrEqualTo(String value) {
            addCriterion("columnContent >=", value, "columncontent");
            return (Criteria) this;
        }

        public Criteria andColumncontentLessThan(String value) {
            addCriterion("columnContent <", value, "columncontent");
            return (Criteria) this;
        }

        public Criteria andColumncontentLessThanOrEqualTo(String value) {
            addCriterion("columnContent <=", value, "columncontent");
            return (Criteria) this;
        }

        public Criteria andColumncontentLike(String value) {
            addCriterion("columnContent like", value, "columncontent");
            return (Criteria) this;
        }

        public Criteria andColumncontentNotLike(String value) {
            addCriterion("columnContent not like", value, "columncontent");
            return (Criteria) this;
        }

        public Criteria andColumncontentIn(List<String> values) {
            addCriterion("columnContent in", values, "columncontent");
            return (Criteria) this;
        }

        public Criteria andColumncontentNotIn(List<String> values) {
            addCriterion("columnContent not in", values, "columncontent");
            return (Criteria) this;
        }

        public Criteria andColumncontentBetween(String value1, String value2) {
            addCriterion("columnContent between", value1, value2, "columncontent");
            return (Criteria) this;
        }

        public Criteria andColumncontentNotBetween(String value1, String value2) {
            addCriterion("columnContent not between", value1, value2, "columncontent");
            return (Criteria) this;
        }

        public Criteria andColumnpriceIsNull() {
            addCriterion("columnPrice is null");
            return (Criteria) this;
        }

        public Criteria andColumnpriceIsNotNull() {
            addCriterion("columnPrice is not null");
            return (Criteria) this;
        }

        public Criteria andColumnpriceEqualTo(BigDecimal value) {
            addCriterion("columnPrice =", value, "columnprice");
            return (Criteria) this;
        }

        public Criteria andColumnpriceNotEqualTo(BigDecimal value) {
            addCriterion("columnPrice <>", value, "columnprice");
            return (Criteria) this;
        }

        public Criteria andColumnpriceGreaterThan(BigDecimal value) {
            addCriterion("columnPrice >", value, "columnprice");
            return (Criteria) this;
        }

        public Criteria andColumnpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("columnPrice >=", value, "columnprice");
            return (Criteria) this;
        }

        public Criteria andColumnpriceLessThan(BigDecimal value) {
            addCriterion("columnPrice <", value, "columnprice");
            return (Criteria) this;
        }

        public Criteria andColumnpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("columnPrice <=", value, "columnprice");
            return (Criteria) this;
        }

        public Criteria andColumnpriceIn(List<BigDecimal> values) {
            addCriterion("columnPrice in", values, "columnprice");
            return (Criteria) this;
        }

        public Criteria andColumnpriceNotIn(List<BigDecimal> values) {
            addCriterion("columnPrice not in", values, "columnprice");
            return (Criteria) this;
        }

        public Criteria andColumnpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("columnPrice between", value1, value2, "columnprice");
            return (Criteria) this;
        }

        public Criteria andColumnpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("columnPrice not between", value1, value2, "columnprice");
            return (Criteria) this;
        }

        public Criteria andColumnimgIsNull() {
            addCriterion("columnImg is null");
            return (Criteria) this;
        }

        public Criteria andColumnimgIsNotNull() {
            addCriterion("columnImg is not null");
            return (Criteria) this;
        }

        public Criteria andColumnimgEqualTo(String value) {
            addCriterion("columnImg =", value, "columnimg");
            return (Criteria) this;
        }

        public Criteria andColumnimgNotEqualTo(String value) {
            addCriterion("columnImg <>", value, "columnimg");
            return (Criteria) this;
        }

        public Criteria andColumnimgGreaterThan(String value) {
            addCriterion("columnImg >", value, "columnimg");
            return (Criteria) this;
        }

        public Criteria andColumnimgGreaterThanOrEqualTo(String value) {
            addCriterion("columnImg >=", value, "columnimg");
            return (Criteria) this;
        }

        public Criteria andColumnimgLessThan(String value) {
            addCriterion("columnImg <", value, "columnimg");
            return (Criteria) this;
        }

        public Criteria andColumnimgLessThanOrEqualTo(String value) {
            addCriterion("columnImg <=", value, "columnimg");
            return (Criteria) this;
        }

        public Criteria andColumnimgLike(String value) {
            addCriterion("columnImg like", value, "columnimg");
            return (Criteria) this;
        }

        public Criteria andColumnimgNotLike(String value) {
            addCriterion("columnImg not like", value, "columnimg");
            return (Criteria) this;
        }

        public Criteria andColumnimgIn(List<String> values) {
            addCriterion("columnImg in", values, "columnimg");
            return (Criteria) this;
        }

        public Criteria andColumnimgNotIn(List<String> values) {
            addCriterion("columnImg not in", values, "columnimg");
            return (Criteria) this;
        }

        public Criteria andColumnimgBetween(String value1, String value2) {
            addCriterion("columnImg between", value1, value2, "columnimg");
            return (Criteria) this;
        }

        public Criteria andColumnimgNotBetween(String value1, String value2) {
            addCriterion("columnImg not between", value1, value2, "columnimg");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNull() {
            addCriterion("payType is null");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNotNull() {
            addCriterion("payType is not null");
            return (Criteria) this;
        }

        public Criteria andPaytypeEqualTo(String value) {
            addCriterion("payType =", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotEqualTo(String value) {
            addCriterion("payType <>", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThan(String value) {
            addCriterion("payType >", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThanOrEqualTo(String value) {
            addCriterion("payType >=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThan(String value) {
            addCriterion("payType <", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThanOrEqualTo(String value) {
            addCriterion("payType <=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLike(String value) {
            addCriterion("payType like", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotLike(String value) {
            addCriterion("payType not like", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeIn(List<String> values) {
            addCriterion("payType in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotIn(List<String> values) {
            addCriterion("payType not in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeBetween(String value1, String value2) {
            addCriterion("payType between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotBetween(String value1, String value2) {
            addCriterion("payType not between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNull() {
            addCriterion("filePath is null");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNotNull() {
            addCriterion("filePath is not null");
            return (Criteria) this;
        }

        public Criteria andFilepathEqualTo(String value) {
            addCriterion("filePath =", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotEqualTo(String value) {
            addCriterion("filePath <>", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThan(String value) {
            addCriterion("filePath >", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThanOrEqualTo(String value) {
            addCriterion("filePath >=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThan(String value) {
            addCriterion("filePath <", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThanOrEqualTo(String value) {
            addCriterion("filePath <=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLike(String value) {
            addCriterion("filePath like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotLike(String value) {
            addCriterion("filePath not like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathIn(List<String> values) {
            addCriterion("filePath in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotIn(List<String> values) {
            addCriterion("filePath not in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathBetween(String value1, String value2) {
            addCriterion("filePath between", value1, value2, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotBetween(String value1, String value2) {
            addCriterion("filePath not between", value1, value2, "filepath");
            return (Criteria) this;
        }

        public Criteria andLinetypeIsNull() {
            addCriterion("lineType is null");
            return (Criteria) this;
        }

        public Criteria andLinetypeIsNotNull() {
            addCriterion("lineType is not null");
            return (Criteria) this;
        }

        public Criteria andLinetypeEqualTo(Integer value) {
            addCriterion("lineType =", value, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeNotEqualTo(Integer value) {
            addCriterion("lineType <>", value, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeGreaterThan(Integer value) {
            addCriterion("lineType >", value, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("lineType >=", value, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeLessThan(Integer value) {
            addCriterion("lineType <", value, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeLessThanOrEqualTo(Integer value) {
            addCriterion("lineType <=", value, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeIn(List<Integer> values) {
            addCriterion("lineType in", values, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeNotIn(List<Integer> values) {
            addCriterion("lineType not in", values, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeBetween(Integer value1, Integer value2) {
            addCriterion("lineType between", value1, value2, "linetype");
            return (Criteria) this;
        }

        public Criteria andLinetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("lineType not between", value1, value2, "linetype");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andSpeakerIsNull() {
            addCriterion("Speaker is null");
            return (Criteria) this;
        }

        public Criteria andSpeakerIsNotNull() {
            addCriterion("Speaker is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakerEqualTo(String value) {
            addCriterion("Speaker =", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerNotEqualTo(String value) {
            addCriterion("Speaker <>", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerGreaterThan(String value) {
            addCriterion("Speaker >", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerGreaterThanOrEqualTo(String value) {
            addCriterion("Speaker >=", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerLessThan(String value) {
            addCriterion("Speaker <", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerLessThanOrEqualTo(String value) {
            addCriterion("Speaker <=", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerLike(String value) {
            addCriterion("Speaker like", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerNotLike(String value) {
            addCriterion("Speaker not like", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerIn(List<String> values) {
            addCriterion("Speaker in", values, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerNotIn(List<String> values) {
            addCriterion("Speaker not in", values, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerBetween(String value1, String value2) {
            addCriterion("Speaker between", value1, value2, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerNotBetween(String value1, String value2) {
            addCriterion("Speaker not between", value1, value2, "speaker");
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
package com.xxx.frame.Entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassInfoExample() {
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

        public Criteria andClassnameIsNull() {
            addCriterion("className is null");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNotNull() {
            addCriterion("className is not null");
            return (Criteria) this;
        }

        public Criteria andClassnameEqualTo(String value) {
            addCriterion("className =", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotEqualTo(String value) {
            addCriterion("className <>", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThan(String value) {
            addCriterion("className >", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThanOrEqualTo(String value) {
            addCriterion("className >=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThan(String value) {
            addCriterion("className <", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThanOrEqualTo(String value) {
            addCriterion("className <=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLike(String value) {
            addCriterion("className like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotLike(String value) {
            addCriterion("className not like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameIn(List<String> values) {
            addCriterion("className in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotIn(List<String> values) {
            addCriterion("className not in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameBetween(String value1, String value2) {
            addCriterion("className between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotBetween(String value1, String value2) {
            addCriterion("className not between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andClasscontentIsNull() {
            addCriterion("classContent is null");
            return (Criteria) this;
        }

        public Criteria andClasscontentIsNotNull() {
            addCriterion("classContent is not null");
            return (Criteria) this;
        }

        public Criteria andClasscontentEqualTo(String value) {
            addCriterion("classContent =", value, "classcontent");
            return (Criteria) this;
        }

        public Criteria andClasscontentNotEqualTo(String value) {
            addCriterion("classContent <>", value, "classcontent");
            return (Criteria) this;
        }

        public Criteria andClasscontentGreaterThan(String value) {
            addCriterion("classContent >", value, "classcontent");
            return (Criteria) this;
        }

        public Criteria andClasscontentGreaterThanOrEqualTo(String value) {
            addCriterion("classContent >=", value, "classcontent");
            return (Criteria) this;
        }

        public Criteria andClasscontentLessThan(String value) {
            addCriterion("classContent <", value, "classcontent");
            return (Criteria) this;
        }

        public Criteria andClasscontentLessThanOrEqualTo(String value) {
            addCriterion("classContent <=", value, "classcontent");
            return (Criteria) this;
        }

        public Criteria andClasscontentLike(String value) {
            addCriterion("classContent like", value, "classcontent");
            return (Criteria) this;
        }

        public Criteria andClasscontentNotLike(String value) {
            addCriterion("classContent not like", value, "classcontent");
            return (Criteria) this;
        }

        public Criteria andClasscontentIn(List<String> values) {
            addCriterion("classContent in", values, "classcontent");
            return (Criteria) this;
        }

        public Criteria andClasscontentNotIn(List<String> values) {
            addCriterion("classContent not in", values, "classcontent");
            return (Criteria) this;
        }

        public Criteria andClasscontentBetween(String value1, String value2) {
            addCriterion("classContent between", value1, value2, "classcontent");
            return (Criteria) this;
        }

        public Criteria andClasscontentNotBetween(String value1, String value2) {
            addCriterion("classContent not between", value1, value2, "classcontent");
            return (Criteria) this;
        }

        public Criteria andClasstypeIsNull() {
            addCriterion("classType is null");
            return (Criteria) this;
        }

        public Criteria andClasstypeIsNotNull() {
            addCriterion("classType is not null");
            return (Criteria) this;
        }

        public Criteria andClasstypeEqualTo(Integer value) {
            addCriterion("classType =", value, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeNotEqualTo(Integer value) {
            addCriterion("classType <>", value, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeGreaterThan(Integer value) {
            addCriterion("classType >", value, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("classType >=", value, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeLessThan(Integer value) {
            addCriterion("classType <", value, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeLessThanOrEqualTo(Integer value) {
            addCriterion("classType <=", value, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeIn(List<Integer> values) {
            addCriterion("classType in", values, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeNotIn(List<Integer> values) {
            addCriterion("classType not in", values, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeBetween(Integer value1, Integer value2) {
            addCriterion("classType between", value1, value2, "classtype");
            return (Criteria) this;
        }

        public Criteria andClasstypeNotBetween(Integer value1, Integer value2) {
            addCriterion("classType not between", value1, value2, "classtype");
            return (Criteria) this;
        }

        public Criteria andIsreferralIsNull() {
            addCriterion("isReferral is null");
            return (Criteria) this;
        }

        public Criteria andIsreferralIsNotNull() {
            addCriterion("isReferral is not null");
            return (Criteria) this;
        }

        public Criteria andIsreferralEqualTo(Integer value) {
            addCriterion("isReferral =", value, "isreferral");
            return (Criteria) this;
        }

        public Criteria andIsreferralNotEqualTo(Integer value) {
            addCriterion("isReferral <>", value, "isreferral");
            return (Criteria) this;
        }

        public Criteria andIsreferralGreaterThan(Integer value) {
            addCriterion("isReferral >", value, "isreferral");
            return (Criteria) this;
        }

        public Criteria andIsreferralGreaterThanOrEqualTo(Integer value) {
            addCriterion("isReferral >=", value, "isreferral");
            return (Criteria) this;
        }

        public Criteria andIsreferralLessThan(Integer value) {
            addCriterion("isReferral <", value, "isreferral");
            return (Criteria) this;
        }

        public Criteria andIsreferralLessThanOrEqualTo(Integer value) {
            addCriterion("isReferral <=", value, "isreferral");
            return (Criteria) this;
        }

        public Criteria andIsreferralIn(List<Integer> values) {
            addCriterion("isReferral in", values, "isreferral");
            return (Criteria) this;
        }

        public Criteria andIsreferralNotIn(List<Integer> values) {
            addCriterion("isReferral not in", values, "isreferral");
            return (Criteria) this;
        }

        public Criteria andIsreferralBetween(Integer value1, Integer value2) {
            addCriterion("isReferral between", value1, value2, "isreferral");
            return (Criteria) this;
        }

        public Criteria andIsreferralNotBetween(Integer value1, Integer value2) {
            addCriterion("isReferral not between", value1, value2, "isreferral");
            return (Criteria) this;
        }

        public Criteria andPricetypeIsNull() {
            addCriterion("priceType is null");
            return (Criteria) this;
        }

        public Criteria andPricetypeIsNotNull() {
            addCriterion("priceType is not null");
            return (Criteria) this;
        }

        public Criteria andPricetypeEqualTo(Integer value) {
            addCriterion("priceType =", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeNotEqualTo(Integer value) {
            addCriterion("priceType <>", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeGreaterThan(Integer value) {
            addCriterion("priceType >", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("priceType >=", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeLessThan(Integer value) {
            addCriterion("priceType <", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeLessThanOrEqualTo(Integer value) {
            addCriterion("priceType <=", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeIn(List<Integer> values) {
            addCriterion("priceType in", values, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeNotIn(List<Integer> values) {
            addCriterion("priceType not in", values, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeBetween(Integer value1, Integer value2) {
            addCriterion("priceType between", value1, value2, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("priceType not between", value1, value2, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("Duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("Duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Long value) {
            addCriterion("Duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Long value) {
            addCriterion("Duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Long value) {
            addCriterion("Duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Long value) {
            addCriterion("Duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Long value) {
            addCriterion("Duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Long value) {
            addCriterion("Duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Long> values) {
            addCriterion("Duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Long> values) {
            addCriterion("Duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Long value1, Long value2) {
            addCriterion("Duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Long value1, Long value2) {
            addCriterion("Duration not between", value1, value2, "duration");
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

        public Criteria andCreattimeIsNull() {
            addCriterion("creatTime is null");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNotNull() {
            addCriterion("creatTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreattimeEqualTo(Date value) {
            addCriterion("creatTime =", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotEqualTo(Date value) {
            addCriterion("creatTime <>", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThan(Date value) {
            addCriterion("creatTime >", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creatTime >=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThan(Date value) {
            addCriterion("creatTime <", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThanOrEqualTo(Date value) {
            addCriterion("creatTime <=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeIn(List<Date> values) {
            addCriterion("creatTime in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotIn(List<Date> values) {
            addCriterion("creatTime not in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeBetween(Date value1, Date value2) {
            addCriterion("creatTime between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotBetween(Date value1, Date value2) {
            addCriterion("creatTime not between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andClassimgIsNull() {
            addCriterion("classImg is null");
            return (Criteria) this;
        }

        public Criteria andClassimgIsNotNull() {
            addCriterion("classImg is not null");
            return (Criteria) this;
        }

        public Criteria andClassimgEqualTo(String value) {
            addCriterion("classImg =", value, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgNotEqualTo(String value) {
            addCriterion("classImg <>", value, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgGreaterThan(String value) {
            addCriterion("classImg >", value, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgGreaterThanOrEqualTo(String value) {
            addCriterion("classImg >=", value, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgLessThan(String value) {
            addCriterion("classImg <", value, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgLessThanOrEqualTo(String value) {
            addCriterion("classImg <=", value, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgLike(String value) {
            addCriterion("classImg like", value, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgNotLike(String value) {
            addCriterion("classImg not like", value, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgIn(List<String> values) {
            addCriterion("classImg in", values, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgNotIn(List<String> values) {
            addCriterion("classImg not in", values, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgBetween(String value1, String value2) {
            addCriterion("classImg between", value1, value2, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgNotBetween(String value1, String value2) {
            addCriterion("classImg not between", value1, value2, "classimg");
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

        public Criteria andSpeakerIsNull() {
            addCriterion("speaker is null");
            return (Criteria) this;
        }

        public Criteria andSpeakerIsNotNull() {
            addCriterion("speaker is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakerEqualTo(String value) {
            addCriterion("speaker =", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerNotEqualTo(String value) {
            addCriterion("speaker <>", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerGreaterThan(String value) {
            addCriterion("speaker >", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerGreaterThanOrEqualTo(String value) {
            addCriterion("speaker >=", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerLessThan(String value) {
            addCriterion("speaker <", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerLessThanOrEqualTo(String value) {
            addCriterion("speaker <=", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerLike(String value) {
            addCriterion("speaker like", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerNotLike(String value) {
            addCriterion("speaker not like", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerIn(List<String> values) {
            addCriterion("speaker in", values, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerNotIn(List<String> values) {
            addCriterion("speaker not in", values, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerBetween(String value1, String value2) {
            addCriterion("speaker between", value1, value2, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerNotBetween(String value1, String value2) {
            addCriterion("speaker not between", value1, value2, "speaker");
            return (Criteria) this;
        }

        public Criteria andPlaycountIsNull() {
            addCriterion("playCount is null");
            return (Criteria) this;
        }

        public Criteria andPlaycountIsNotNull() {
            addCriterion("playCount is not null");
            return (Criteria) this;
        }

        public Criteria andPlaycountEqualTo(Long value) {
            addCriterion("playCount =", value, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountNotEqualTo(Long value) {
            addCriterion("playCount <>", value, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountGreaterThan(Long value) {
            addCriterion("playCount >", value, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountGreaterThanOrEqualTo(Long value) {
            addCriterion("playCount >=", value, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountLessThan(Long value) {
            addCriterion("playCount <", value, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountLessThanOrEqualTo(Long value) {
            addCriterion("playCount <=", value, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountIn(List<Long> values) {
            addCriterion("playCount in", values, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountNotIn(List<Long> values) {
            addCriterion("playCount not in", values, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountBetween(Long value1, Long value2) {
            addCriterion("playCount between", value1, value2, "playcount");
            return (Criteria) this;
        }

        public Criteria andPlaycountNotBetween(Long value1, Long value2) {
            addCriterion("playCount not between", value1, value2, "playcount");
            return (Criteria) this;
        }

        public Criteria andColumnidIsNull() {
            addCriterion("columnId is null");
            return (Criteria) this;
        }

        public Criteria andColumnidIsNotNull() {
            addCriterion("columnId is not null");
            return (Criteria) this;
        }

        public Criteria andColumnidEqualTo(Integer value) {
            addCriterion("columnId =", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidNotEqualTo(Integer value) {
            addCriterion("columnId <>", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidGreaterThan(Integer value) {
            addCriterion("columnId >", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidGreaterThanOrEqualTo(Integer value) {
            addCriterion("columnId >=", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidLessThan(Integer value) {
            addCriterion("columnId <", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidLessThanOrEqualTo(Integer value) {
            addCriterion("columnId <=", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidIn(List<Integer> values) {
            addCriterion("columnId in", values, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidNotIn(List<Integer> values) {
            addCriterion("columnId not in", values, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidBetween(Integer value1, Integer value2) {
            addCriterion("columnId between", value1, value2, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidNotBetween(Integer value1, Integer value2) {
            addCriterion("columnId not between", value1, value2, "columnid");
            return (Criteria) this;
        }

        public Criteria andMembercountIsNull() {
            addCriterion("memberCount is null");
            return (Criteria) this;
        }

        public Criteria andMembercountIsNotNull() {
            addCriterion("memberCount is not null");
            return (Criteria) this;
        }

        public Criteria andMembercountEqualTo(Integer value) {
            addCriterion("memberCount =", value, "membercount");
            return (Criteria) this;
        }

        public Criteria andMembercountNotEqualTo(Integer value) {
            addCriterion("memberCount <>", value, "membercount");
            return (Criteria) this;
        }

        public Criteria andMembercountGreaterThan(Integer value) {
            addCriterion("memberCount >", value, "membercount");
            return (Criteria) this;
        }

        public Criteria andMembercountGreaterThanOrEqualTo(Integer value) {
            addCriterion("memberCount >=", value, "membercount");
            return (Criteria) this;
        }

        public Criteria andMembercountLessThan(Integer value) {
            addCriterion("memberCount <", value, "membercount");
            return (Criteria) this;
        }

        public Criteria andMembercountLessThanOrEqualTo(Integer value) {
            addCriterion("memberCount <=", value, "membercount");
            return (Criteria) this;
        }

        public Criteria andMembercountIn(List<Integer> values) {
            addCriterion("memberCount in", values, "membercount");
            return (Criteria) this;
        }

        public Criteria andMembercountNotIn(List<Integer> values) {
            addCriterion("memberCount not in", values, "membercount");
            return (Criteria) this;
        }

        public Criteria andMembercountBetween(Integer value1, Integer value2) {
            addCriterion("memberCount between", value1, value2, "membercount");
            return (Criteria) this;
        }

        public Criteria andMembercountNotBetween(Integer value1, Integer value2) {
            addCriterion("memberCount not between", value1, value2, "membercount");
            return (Criteria) this;
        }

        public Criteria andApplydateIsNull() {
            addCriterion("applyDate is null");
            return (Criteria) this;
        }

        public Criteria andApplydateIsNotNull() {
            addCriterion("applyDate is not null");
            return (Criteria) this;
        }

        public Criteria andApplydateEqualTo(Date value) {
            addCriterion("applyDate =", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotEqualTo(Date value) {
            addCriterion("applyDate <>", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThan(Date value) {
            addCriterion("applyDate >", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThanOrEqualTo(Date value) {
            addCriterion("applyDate >=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThan(Date value) {
            addCriterion("applyDate <", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThanOrEqualTo(Date value) {
            addCriterion("applyDate <=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateIn(List<Date> values) {
            addCriterion("applyDate in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotIn(List<Date> values) {
            addCriterion("applyDate not in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateBetween(Date value1, Date value2) {
            addCriterion("applyDate between", value1, value2, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotBetween(Date value1, Date value2) {
            addCriterion("applyDate not between", value1, value2, "applydate");
            return (Criteria) this;
        }

        public Criteria andAttendtimeIsNull() {
            addCriterion("attendTime is null");
            return (Criteria) this;
        }

        public Criteria andAttendtimeIsNotNull() {
            addCriterion("attendTime is not null");
            return (Criteria) this;
        }

        public Criteria andAttendtimeEqualTo(Date value) {
            addCriterion("attendTime =", value, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeNotEqualTo(Date value) {
            addCriterion("attendTime <>", value, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeGreaterThan(Date value) {
            addCriterion("attendTime >", value, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attendTime >=", value, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeLessThan(Date value) {
            addCriterion("attendTime <", value, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeLessThanOrEqualTo(Date value) {
            addCriterion("attendTime <=", value, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeIn(List<Date> values) {
            addCriterion("attendTime in", values, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeNotIn(List<Date> values) {
            addCriterion("attendTime not in", values, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeBetween(Date value1, Date value2) {
            addCriterion("attendTime between", value1, value2, "attendtime");
            return (Criteria) this;
        }

        public Criteria andAttendtimeNotBetween(Date value1, Date value2) {
            addCriterion("attendTime not between", value1, value2, "attendtime");
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
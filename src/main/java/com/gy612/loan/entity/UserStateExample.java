package com.gy612.loan.entity;

import java.util.ArrayList;
import java.util.List;

public class UserStateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserStateExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIsCertificationIsNull() {
            addCriterion("is_certification is null");
            return (Criteria) this;
        }

        public Criteria andIsCertificationIsNotNull() {
            addCriterion("is_certification is not null");
            return (Criteria) this;
        }

        public Criteria andIsCertificationEqualTo(Byte value) {
            addCriterion("is_certification =", value, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationNotEqualTo(Byte value) {
            addCriterion("is_certification <>", value, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationGreaterThan(Byte value) {
            addCriterion("is_certification >", value, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_certification >=", value, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationLessThan(Byte value) {
            addCriterion("is_certification <", value, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationLessThanOrEqualTo(Byte value) {
            addCriterion("is_certification <=", value, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationIn(List<Byte> values) {
            addCriterion("is_certification in", values, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationNotIn(List<Byte> values) {
            addCriterion("is_certification not in", values, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationBetween(Byte value1, Byte value2) {
            addCriterion("is_certification between", value1, value2, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationNotBetween(Byte value1, Byte value2) {
            addCriterion("is_certification not between", value1, value2, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsFreezeIsNull() {
            addCriterion("is_freeze is null");
            return (Criteria) this;
        }

        public Criteria andIsFreezeIsNotNull() {
            addCriterion("is_freeze is not null");
            return (Criteria) this;
        }

        public Criteria andIsFreezeEqualTo(Byte value) {
            addCriterion("is_freeze =", value, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeNotEqualTo(Byte value) {
            addCriterion("is_freeze <>", value, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeGreaterThan(Byte value) {
            addCriterion("is_freeze >", value, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_freeze >=", value, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeLessThan(Byte value) {
            addCriterion("is_freeze <", value, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeLessThanOrEqualTo(Byte value) {
            addCriterion("is_freeze <=", value, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeIn(List<Byte> values) {
            addCriterion("is_freeze in", values, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeNotIn(List<Byte> values) {
            addCriterion("is_freeze not in", values, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeBetween(Byte value1, Byte value2) {
            addCriterion("is_freeze between", value1, value2, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsFreezeNotBetween(Byte value1, Byte value2) {
            addCriterion("is_freeze not between", value1, value2, "isFreeze");
            return (Criteria) this;
        }

        public Criteria andIsShieldIsNull() {
            addCriterion("is_shield is null");
            return (Criteria) this;
        }

        public Criteria andIsShieldIsNotNull() {
            addCriterion("is_shield is not null");
            return (Criteria) this;
        }

        public Criteria andIsShieldEqualTo(Byte value) {
            addCriterion("is_shield =", value, "isShield");
            return (Criteria) this;
        }

        public Criteria andIsShieldNotEqualTo(Byte value) {
            addCriterion("is_shield <>", value, "isShield");
            return (Criteria) this;
        }

        public Criteria andIsShieldGreaterThan(Byte value) {
            addCriterion("is_shield >", value, "isShield");
            return (Criteria) this;
        }

        public Criteria andIsShieldGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_shield >=", value, "isShield");
            return (Criteria) this;
        }

        public Criteria andIsShieldLessThan(Byte value) {
            addCriterion("is_shield <", value, "isShield");
            return (Criteria) this;
        }

        public Criteria andIsShieldLessThanOrEqualTo(Byte value) {
            addCriterion("is_shield <=", value, "isShield");
            return (Criteria) this;
        }

        public Criteria andIsShieldIn(List<Byte> values) {
            addCriterion("is_shield in", values, "isShield");
            return (Criteria) this;
        }

        public Criteria andIsShieldNotIn(List<Byte> values) {
            addCriterion("is_shield not in", values, "isShield");
            return (Criteria) this;
        }

        public Criteria andIsShieldBetween(Byte value1, Byte value2) {
            addCriterion("is_shield between", value1, value2, "isShield");
            return (Criteria) this;
        }

        public Criteria andIsShieldNotBetween(Byte value1, Byte value2) {
            addCriterion("is_shield not between", value1, value2, "isShield");
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
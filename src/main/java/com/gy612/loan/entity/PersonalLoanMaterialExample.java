package com.gy612.loan.entity;

import java.util.ArrayList;
import java.util.List;

public class PersonalLoanMaterialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonalLoanMaterialExample() {
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

        public Criteria andMaterialPersonalIsNull() {
            addCriterion("material_personal is null");
            return (Criteria) this;
        }

        public Criteria andMaterialPersonalIsNotNull() {
            addCriterion("material_personal is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialPersonalEqualTo(String value) {
            addCriterion("material_personal =", value, "materialPersonal");
            return (Criteria) this;
        }

        public Criteria andMaterialPersonalNotEqualTo(String value) {
            addCriterion("material_personal <>", value, "materialPersonal");
            return (Criteria) this;
        }

        public Criteria andMaterialPersonalGreaterThan(String value) {
            addCriterion("material_personal >", value, "materialPersonal");
            return (Criteria) this;
        }

        public Criteria andMaterialPersonalGreaterThanOrEqualTo(String value) {
            addCriterion("material_personal >=", value, "materialPersonal");
            return (Criteria) this;
        }

        public Criteria andMaterialPersonalLessThan(String value) {
            addCriterion("material_personal <", value, "materialPersonal");
            return (Criteria) this;
        }

        public Criteria andMaterialPersonalLessThanOrEqualTo(String value) {
            addCriterion("material_personal <=", value, "materialPersonal");
            return (Criteria) this;
        }

        public Criteria andMaterialPersonalLike(String value) {
            addCriterion("material_personal like", value, "materialPersonal");
            return (Criteria) this;
        }

        public Criteria andMaterialPersonalNotLike(String value) {
            addCriterion("material_personal not like", value, "materialPersonal");
            return (Criteria) this;
        }

        public Criteria andMaterialPersonalIn(List<String> values) {
            addCriterion("material_personal in", values, "materialPersonal");
            return (Criteria) this;
        }

        public Criteria andMaterialPersonalNotIn(List<String> values) {
            addCriterion("material_personal not in", values, "materialPersonal");
            return (Criteria) this;
        }

        public Criteria andMaterialPersonalBetween(String value1, String value2) {
            addCriterion("material_personal between", value1, value2, "materialPersonal");
            return (Criteria) this;
        }

        public Criteria andMaterialPersonalNotBetween(String value1, String value2) {
            addCriterion("material_personal not between", value1, value2, "materialPersonal");
            return (Criteria) this;
        }

        public Criteria andMaterialMortgageIsNull() {
            addCriterion("material_mortgage is null");
            return (Criteria) this;
        }

        public Criteria andMaterialMortgageIsNotNull() {
            addCriterion("material_mortgage is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialMortgageEqualTo(String value) {
            addCriterion("material_mortgage =", value, "materialMortgage");
            return (Criteria) this;
        }

        public Criteria andMaterialMortgageNotEqualTo(String value) {
            addCriterion("material_mortgage <>", value, "materialMortgage");
            return (Criteria) this;
        }

        public Criteria andMaterialMortgageGreaterThan(String value) {
            addCriterion("material_mortgage >", value, "materialMortgage");
            return (Criteria) this;
        }

        public Criteria andMaterialMortgageGreaterThanOrEqualTo(String value) {
            addCriterion("material_mortgage >=", value, "materialMortgage");
            return (Criteria) this;
        }

        public Criteria andMaterialMortgageLessThan(String value) {
            addCriterion("material_mortgage <", value, "materialMortgage");
            return (Criteria) this;
        }

        public Criteria andMaterialMortgageLessThanOrEqualTo(String value) {
            addCriterion("material_mortgage <=", value, "materialMortgage");
            return (Criteria) this;
        }

        public Criteria andMaterialMortgageLike(String value) {
            addCriterion("material_mortgage like", value, "materialMortgage");
            return (Criteria) this;
        }

        public Criteria andMaterialMortgageNotLike(String value) {
            addCriterion("material_mortgage not like", value, "materialMortgage");
            return (Criteria) this;
        }

        public Criteria andMaterialMortgageIn(List<String> values) {
            addCriterion("material_mortgage in", values, "materialMortgage");
            return (Criteria) this;
        }

        public Criteria andMaterialMortgageNotIn(List<String> values) {
            addCriterion("material_mortgage not in", values, "materialMortgage");
            return (Criteria) this;
        }

        public Criteria andMaterialMortgageBetween(String value1, String value2) {
            addCriterion("material_mortgage between", value1, value2, "materialMortgage");
            return (Criteria) this;
        }

        public Criteria andMaterialMortgageNotBetween(String value1, String value2) {
            addCriterion("material_mortgage not between", value1, value2, "materialMortgage");
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
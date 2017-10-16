package com.gy612.loan.entity;

import java.util.ArrayList;
import java.util.List;

public class BorrowMaterialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BorrowMaterialExample() {
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

        public Criteria andMaterialIdentificationIsNull() {
            addCriterion("material_identification is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdentificationIsNotNull() {
            addCriterion("material_identification is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdentificationEqualTo(String value) {
            addCriterion("material_identification =", value, "materialIdentification");
            return (Criteria) this;
        }

        public Criteria andMaterialIdentificationNotEqualTo(String value) {
            addCriterion("material_identification <>", value, "materialIdentification");
            return (Criteria) this;
        }

        public Criteria andMaterialIdentificationGreaterThan(String value) {
            addCriterion("material_identification >", value, "materialIdentification");
            return (Criteria) this;
        }

        public Criteria andMaterialIdentificationGreaterThanOrEqualTo(String value) {
            addCriterion("material_identification >=", value, "materialIdentification");
            return (Criteria) this;
        }

        public Criteria andMaterialIdentificationLessThan(String value) {
            addCriterion("material_identification <", value, "materialIdentification");
            return (Criteria) this;
        }

        public Criteria andMaterialIdentificationLessThanOrEqualTo(String value) {
            addCriterion("material_identification <=", value, "materialIdentification");
            return (Criteria) this;
        }

        public Criteria andMaterialIdentificationLike(String value) {
            addCriterion("material_identification like", value, "materialIdentification");
            return (Criteria) this;
        }

        public Criteria andMaterialIdentificationNotLike(String value) {
            addCriterion("material_identification not like", value, "materialIdentification");
            return (Criteria) this;
        }

        public Criteria andMaterialIdentificationIn(List<String> values) {
            addCriterion("material_identification in", values, "materialIdentification");
            return (Criteria) this;
        }

        public Criteria andMaterialIdentificationNotIn(List<String> values) {
            addCriterion("material_identification not in", values, "materialIdentification");
            return (Criteria) this;
        }

        public Criteria andMaterialIdentificationBetween(String value1, String value2) {
            addCriterion("material_identification between", value1, value2, "materialIdentification");
            return (Criteria) this;
        }

        public Criteria andMaterialIdentificationNotBetween(String value1, String value2) {
            addCriterion("material_identification not between", value1, value2, "materialIdentification");
            return (Criteria) this;
        }

        public Criteria andMaterialHousepropertyIsNull() {
            addCriterion("material_houseproperty is null");
            return (Criteria) this;
        }

        public Criteria andMaterialHousepropertyIsNotNull() {
            addCriterion("material_houseproperty is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialHousepropertyEqualTo(String value) {
            addCriterion("material_houseproperty =", value, "materialHouseproperty");
            return (Criteria) this;
        }

        public Criteria andMaterialHousepropertyNotEqualTo(String value) {
            addCriterion("material_houseproperty <>", value, "materialHouseproperty");
            return (Criteria) this;
        }

        public Criteria andMaterialHousepropertyGreaterThan(String value) {
            addCriterion("material_houseproperty >", value, "materialHouseproperty");
            return (Criteria) this;
        }

        public Criteria andMaterialHousepropertyGreaterThanOrEqualTo(String value) {
            addCriterion("material_houseproperty >=", value, "materialHouseproperty");
            return (Criteria) this;
        }

        public Criteria andMaterialHousepropertyLessThan(String value) {
            addCriterion("material_houseproperty <", value, "materialHouseproperty");
            return (Criteria) this;
        }

        public Criteria andMaterialHousepropertyLessThanOrEqualTo(String value) {
            addCriterion("material_houseproperty <=", value, "materialHouseproperty");
            return (Criteria) this;
        }

        public Criteria andMaterialHousepropertyLike(String value) {
            addCriterion("material_houseproperty like", value, "materialHouseproperty");
            return (Criteria) this;
        }

        public Criteria andMaterialHousepropertyNotLike(String value) {
            addCriterion("material_houseproperty not like", value, "materialHouseproperty");
            return (Criteria) this;
        }

        public Criteria andMaterialHousepropertyIn(List<String> values) {
            addCriterion("material_houseproperty in", values, "materialHouseproperty");
            return (Criteria) this;
        }

        public Criteria andMaterialHousepropertyNotIn(List<String> values) {
            addCriterion("material_houseproperty not in", values, "materialHouseproperty");
            return (Criteria) this;
        }

        public Criteria andMaterialHousepropertyBetween(String value1, String value2) {
            addCriterion("material_houseproperty between", value1, value2, "materialHouseproperty");
            return (Criteria) this;
        }

        public Criteria andMaterialHousepropertyNotBetween(String value1, String value2) {
            addCriterion("material_houseproperty not between", value1, value2, "materialHouseproperty");
            return (Criteria) this;
        }

        public Criteria andMaterialDrivinglicenceIsNull() {
            addCriterion("material_drivinglicence is null");
            return (Criteria) this;
        }

        public Criteria andMaterialDrivinglicenceIsNotNull() {
            addCriterion("material_drivinglicence is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialDrivinglicenceEqualTo(String value) {
            addCriterion("material_drivinglicence =", value, "materialDrivinglicence");
            return (Criteria) this;
        }

        public Criteria andMaterialDrivinglicenceNotEqualTo(String value) {
            addCriterion("material_drivinglicence <>", value, "materialDrivinglicence");
            return (Criteria) this;
        }

        public Criteria andMaterialDrivinglicenceGreaterThan(String value) {
            addCriterion("material_drivinglicence >", value, "materialDrivinglicence");
            return (Criteria) this;
        }

        public Criteria andMaterialDrivinglicenceGreaterThanOrEqualTo(String value) {
            addCriterion("material_drivinglicence >=", value, "materialDrivinglicence");
            return (Criteria) this;
        }

        public Criteria andMaterialDrivinglicenceLessThan(String value) {
            addCriterion("material_drivinglicence <", value, "materialDrivinglicence");
            return (Criteria) this;
        }

        public Criteria andMaterialDrivinglicenceLessThanOrEqualTo(String value) {
            addCriterion("material_drivinglicence <=", value, "materialDrivinglicence");
            return (Criteria) this;
        }

        public Criteria andMaterialDrivinglicenceLike(String value) {
            addCriterion("material_drivinglicence like", value, "materialDrivinglicence");
            return (Criteria) this;
        }

        public Criteria andMaterialDrivinglicenceNotLike(String value) {
            addCriterion("material_drivinglicence not like", value, "materialDrivinglicence");
            return (Criteria) this;
        }

        public Criteria andMaterialDrivinglicenceIn(List<String> values) {
            addCriterion("material_drivinglicence in", values, "materialDrivinglicence");
            return (Criteria) this;
        }

        public Criteria andMaterialDrivinglicenceNotIn(List<String> values) {
            addCriterion("material_drivinglicence not in", values, "materialDrivinglicence");
            return (Criteria) this;
        }

        public Criteria andMaterialDrivinglicenceBetween(String value1, String value2) {
            addCriterion("material_drivinglicence between", value1, value2, "materialDrivinglicence");
            return (Criteria) this;
        }

        public Criteria andMaterialDrivinglicenceNotBetween(String value1, String value2) {
            addCriterion("material_drivinglicence not between", value1, value2, "materialDrivinglicence");
            return (Criteria) this;
        }

        public Criteria andMaterialPaymenthistoryIsNull() {
            addCriterion("material_paymenthistory is null");
            return (Criteria) this;
        }

        public Criteria andMaterialPaymenthistoryIsNotNull() {
            addCriterion("material_paymenthistory is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialPaymenthistoryEqualTo(String value) {
            addCriterion("material_paymenthistory =", value, "materialPaymenthistory");
            return (Criteria) this;
        }

        public Criteria andMaterialPaymenthistoryNotEqualTo(String value) {
            addCriterion("material_paymenthistory <>", value, "materialPaymenthistory");
            return (Criteria) this;
        }

        public Criteria andMaterialPaymenthistoryGreaterThan(String value) {
            addCriterion("material_paymenthistory >", value, "materialPaymenthistory");
            return (Criteria) this;
        }

        public Criteria andMaterialPaymenthistoryGreaterThanOrEqualTo(String value) {
            addCriterion("material_paymenthistory >=", value, "materialPaymenthistory");
            return (Criteria) this;
        }

        public Criteria andMaterialPaymenthistoryLessThan(String value) {
            addCriterion("material_paymenthistory <", value, "materialPaymenthistory");
            return (Criteria) this;
        }

        public Criteria andMaterialPaymenthistoryLessThanOrEqualTo(String value) {
            addCriterion("material_paymenthistory <=", value, "materialPaymenthistory");
            return (Criteria) this;
        }

        public Criteria andMaterialPaymenthistoryLike(String value) {
            addCriterion("material_paymenthistory like", value, "materialPaymenthistory");
            return (Criteria) this;
        }

        public Criteria andMaterialPaymenthistoryNotLike(String value) {
            addCriterion("material_paymenthistory not like", value, "materialPaymenthistory");
            return (Criteria) this;
        }

        public Criteria andMaterialPaymenthistoryIn(List<String> values) {
            addCriterion("material_paymenthistory in", values, "materialPaymenthistory");
            return (Criteria) this;
        }

        public Criteria andMaterialPaymenthistoryNotIn(List<String> values) {
            addCriterion("material_paymenthistory not in", values, "materialPaymenthistory");
            return (Criteria) this;
        }

        public Criteria andMaterialPaymenthistoryBetween(String value1, String value2) {
            addCriterion("material_paymenthistory between", value1, value2, "materialPaymenthistory");
            return (Criteria) this;
        }

        public Criteria andMaterialPaymenthistoryNotBetween(String value1, String value2) {
            addCriterion("material_paymenthistory not between", value1, value2, "materialPaymenthistory");
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
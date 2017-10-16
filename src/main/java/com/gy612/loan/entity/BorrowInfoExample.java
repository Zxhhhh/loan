package com.gy612.loan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BorrowInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BorrowInfoExample() {
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

        public Criteria andBorrowContactIsNull() {
            addCriterion("borrow_contact is null");
            return (Criteria) this;
        }

        public Criteria andBorrowContactIsNotNull() {
            addCriterion("borrow_contact is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowContactEqualTo(String value) {
            addCriterion("borrow_contact =", value, "borrowContact");
            return (Criteria) this;
        }

        public Criteria andBorrowContactNotEqualTo(String value) {
            addCriterion("borrow_contact <>", value, "borrowContact");
            return (Criteria) this;
        }

        public Criteria andBorrowContactGreaterThan(String value) {
            addCriterion("borrow_contact >", value, "borrowContact");
            return (Criteria) this;
        }

        public Criteria andBorrowContactGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_contact >=", value, "borrowContact");
            return (Criteria) this;
        }

        public Criteria andBorrowContactLessThan(String value) {
            addCriterion("borrow_contact <", value, "borrowContact");
            return (Criteria) this;
        }

        public Criteria andBorrowContactLessThanOrEqualTo(String value) {
            addCriterion("borrow_contact <=", value, "borrowContact");
            return (Criteria) this;
        }

        public Criteria andBorrowContactLike(String value) {
            addCriterion("borrow_contact like", value, "borrowContact");
            return (Criteria) this;
        }

        public Criteria andBorrowContactNotLike(String value) {
            addCriterion("borrow_contact not like", value, "borrowContact");
            return (Criteria) this;
        }

        public Criteria andBorrowContactIn(List<String> values) {
            addCriterion("borrow_contact in", values, "borrowContact");
            return (Criteria) this;
        }

        public Criteria andBorrowContactNotIn(List<String> values) {
            addCriterion("borrow_contact not in", values, "borrowContact");
            return (Criteria) this;
        }

        public Criteria andBorrowContactBetween(String value1, String value2) {
            addCriterion("borrow_contact between", value1, value2, "borrowContact");
            return (Criteria) this;
        }

        public Criteria andBorrowContactNotBetween(String value1, String value2) {
            addCriterion("borrow_contact not between", value1, value2, "borrowContact");
            return (Criteria) this;
        }

        public Criteria andBorrowUnitIsNull() {
            addCriterion("borrow_unit is null");
            return (Criteria) this;
        }

        public Criteria andBorrowUnitIsNotNull() {
            addCriterion("borrow_unit is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowUnitEqualTo(String value) {
            addCriterion("borrow_unit =", value, "borrowUnit");
            return (Criteria) this;
        }

        public Criteria andBorrowUnitNotEqualTo(String value) {
            addCriterion("borrow_unit <>", value, "borrowUnit");
            return (Criteria) this;
        }

        public Criteria andBorrowUnitGreaterThan(String value) {
            addCriterion("borrow_unit >", value, "borrowUnit");
            return (Criteria) this;
        }

        public Criteria andBorrowUnitGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_unit >=", value, "borrowUnit");
            return (Criteria) this;
        }

        public Criteria andBorrowUnitLessThan(String value) {
            addCriterion("borrow_unit <", value, "borrowUnit");
            return (Criteria) this;
        }

        public Criteria andBorrowUnitLessThanOrEqualTo(String value) {
            addCriterion("borrow_unit <=", value, "borrowUnit");
            return (Criteria) this;
        }

        public Criteria andBorrowUnitLike(String value) {
            addCriterion("borrow_unit like", value, "borrowUnit");
            return (Criteria) this;
        }

        public Criteria andBorrowUnitNotLike(String value) {
            addCriterion("borrow_unit not like", value, "borrowUnit");
            return (Criteria) this;
        }

        public Criteria andBorrowUnitIn(List<String> values) {
            addCriterion("borrow_unit in", values, "borrowUnit");
            return (Criteria) this;
        }

        public Criteria andBorrowUnitNotIn(List<String> values) {
            addCriterion("borrow_unit not in", values, "borrowUnit");
            return (Criteria) this;
        }

        public Criteria andBorrowUnitBetween(String value1, String value2) {
            addCriterion("borrow_unit between", value1, value2, "borrowUnit");
            return (Criteria) this;
        }

        public Criteria andBorrowUnitNotBetween(String value1, String value2) {
            addCriterion("borrow_unit not between", value1, value2, "borrowUnit");
            return (Criteria) this;
        }

        public Criteria andBorrowFinanceIsNull() {
            addCriterion("borrow_finance is null");
            return (Criteria) this;
        }

        public Criteria andBorrowFinanceIsNotNull() {
            addCriterion("borrow_finance is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowFinanceEqualTo(String value) {
            addCriterion("borrow_finance =", value, "borrowFinance");
            return (Criteria) this;
        }

        public Criteria andBorrowFinanceNotEqualTo(String value) {
            addCriterion("borrow_finance <>", value, "borrowFinance");
            return (Criteria) this;
        }

        public Criteria andBorrowFinanceGreaterThan(String value) {
            addCriterion("borrow_finance >", value, "borrowFinance");
            return (Criteria) this;
        }

        public Criteria andBorrowFinanceGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_finance >=", value, "borrowFinance");
            return (Criteria) this;
        }

        public Criteria andBorrowFinanceLessThan(String value) {
            addCriterion("borrow_finance <", value, "borrowFinance");
            return (Criteria) this;
        }

        public Criteria andBorrowFinanceLessThanOrEqualTo(String value) {
            addCriterion("borrow_finance <=", value, "borrowFinance");
            return (Criteria) this;
        }

        public Criteria andBorrowFinanceLike(String value) {
            addCriterion("borrow_finance like", value, "borrowFinance");
            return (Criteria) this;
        }

        public Criteria andBorrowFinanceNotLike(String value) {
            addCriterion("borrow_finance not like", value, "borrowFinance");
            return (Criteria) this;
        }

        public Criteria andBorrowFinanceIn(List<String> values) {
            addCriterion("borrow_finance in", values, "borrowFinance");
            return (Criteria) this;
        }

        public Criteria andBorrowFinanceNotIn(List<String> values) {
            addCriterion("borrow_finance not in", values, "borrowFinance");
            return (Criteria) this;
        }

        public Criteria andBorrowFinanceBetween(String value1, String value2) {
            addCriterion("borrow_finance between", value1, value2, "borrowFinance");
            return (Criteria) this;
        }

        public Criteria andBorrowFinanceNotBetween(String value1, String value2) {
            addCriterion("borrow_finance not between", value1, value2, "borrowFinance");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyNameIsNull() {
            addCriterion("borrow_company_name is null");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyNameIsNotNull() {
            addCriterion("borrow_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyNameEqualTo(String value) {
            addCriterion("borrow_company_name =", value, "borrowCompanyName");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyNameNotEqualTo(String value) {
            addCriterion("borrow_company_name <>", value, "borrowCompanyName");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyNameGreaterThan(String value) {
            addCriterion("borrow_company_name >", value, "borrowCompanyName");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_company_name >=", value, "borrowCompanyName");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyNameLessThan(String value) {
            addCriterion("borrow_company_name <", value, "borrowCompanyName");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("borrow_company_name <=", value, "borrowCompanyName");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyNameLike(String value) {
            addCriterion("borrow_company_name like", value, "borrowCompanyName");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyNameNotLike(String value) {
            addCriterion("borrow_company_name not like", value, "borrowCompanyName");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyNameIn(List<String> values) {
            addCriterion("borrow_company_name in", values, "borrowCompanyName");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyNameNotIn(List<String> values) {
            addCriterion("borrow_company_name not in", values, "borrowCompanyName");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyNameBetween(String value1, String value2) {
            addCriterion("borrow_company_name between", value1, value2, "borrowCompanyName");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyNameNotBetween(String value1, String value2) {
            addCriterion("borrow_company_name not between", value1, value2, "borrowCompanyName");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyEntityIsNull() {
            addCriterion("borrow_company_entity is null");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyEntityIsNotNull() {
            addCriterion("borrow_company_entity is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyEntityEqualTo(String value) {
            addCriterion("borrow_company_entity =", value, "borrowCompanyEntity");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyEntityNotEqualTo(String value) {
            addCriterion("borrow_company_entity <>", value, "borrowCompanyEntity");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyEntityGreaterThan(String value) {
            addCriterion("borrow_company_entity >", value, "borrowCompanyEntity");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyEntityGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_company_entity >=", value, "borrowCompanyEntity");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyEntityLessThan(String value) {
            addCriterion("borrow_company_entity <", value, "borrowCompanyEntity");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyEntityLessThanOrEqualTo(String value) {
            addCriterion("borrow_company_entity <=", value, "borrowCompanyEntity");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyEntityLike(String value) {
            addCriterion("borrow_company_entity like", value, "borrowCompanyEntity");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyEntityNotLike(String value) {
            addCriterion("borrow_company_entity not like", value, "borrowCompanyEntity");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyEntityIn(List<String> values) {
            addCriterion("borrow_company_entity in", values, "borrowCompanyEntity");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyEntityNotIn(List<String> values) {
            addCriterion("borrow_company_entity not in", values, "borrowCompanyEntity");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyEntityBetween(String value1, String value2) {
            addCriterion("borrow_company_entity between", value1, value2, "borrowCompanyEntity");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyEntityNotBetween(String value1, String value2) {
            addCriterion("borrow_company_entity not between", value1, value2, "borrowCompanyEntity");
            return (Criteria) this;
        }

        public Criteria andBorrowRegisteredCapitalIsNull() {
            addCriterion("borrow_registered_capital is null");
            return (Criteria) this;
        }

        public Criteria andBorrowRegisteredCapitalIsNotNull() {
            addCriterion("borrow_registered_capital is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowRegisteredCapitalEqualTo(Double value) {
            addCriterion("borrow_registered_capital =", value, "borrowRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andBorrowRegisteredCapitalNotEqualTo(Double value) {
            addCriterion("borrow_registered_capital <>", value, "borrowRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andBorrowRegisteredCapitalGreaterThan(Double value) {
            addCriterion("borrow_registered_capital >", value, "borrowRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andBorrowRegisteredCapitalGreaterThanOrEqualTo(Double value) {
            addCriterion("borrow_registered_capital >=", value, "borrowRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andBorrowRegisteredCapitalLessThan(Double value) {
            addCriterion("borrow_registered_capital <", value, "borrowRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andBorrowRegisteredCapitalLessThanOrEqualTo(Double value) {
            addCriterion("borrow_registered_capital <=", value, "borrowRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andBorrowRegisteredCapitalIn(List<Double> values) {
            addCriterion("borrow_registered_capital in", values, "borrowRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andBorrowRegisteredCapitalNotIn(List<Double> values) {
            addCriterion("borrow_registered_capital not in", values, "borrowRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andBorrowRegisteredCapitalBetween(Double value1, Double value2) {
            addCriterion("borrow_registered_capital between", value1, value2, "borrowRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andBorrowRegisteredCapitalNotBetween(Double value1, Double value2) {
            addCriterion("borrow_registered_capital not between", value1, value2, "borrowRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyLocationIsNull() {
            addCriterion("borrow_company_location is null");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyLocationIsNotNull() {
            addCriterion("borrow_company_location is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyLocationEqualTo(String value) {
            addCriterion("borrow_company_location =", value, "borrowCompanyLocation");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyLocationNotEqualTo(String value) {
            addCriterion("borrow_company_location <>", value, "borrowCompanyLocation");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyLocationGreaterThan(String value) {
            addCriterion("borrow_company_location >", value, "borrowCompanyLocation");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyLocationGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_company_location >=", value, "borrowCompanyLocation");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyLocationLessThan(String value) {
            addCriterion("borrow_company_location <", value, "borrowCompanyLocation");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyLocationLessThanOrEqualTo(String value) {
            addCriterion("borrow_company_location <=", value, "borrowCompanyLocation");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyLocationLike(String value) {
            addCriterion("borrow_company_location like", value, "borrowCompanyLocation");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyLocationNotLike(String value) {
            addCriterion("borrow_company_location not like", value, "borrowCompanyLocation");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyLocationIn(List<String> values) {
            addCriterion("borrow_company_location in", values, "borrowCompanyLocation");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyLocationNotIn(List<String> values) {
            addCriterion("borrow_company_location not in", values, "borrowCompanyLocation");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyLocationBetween(String value1, String value2) {
            addCriterion("borrow_company_location between", value1, value2, "borrowCompanyLocation");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyLocationNotBetween(String value1, String value2) {
            addCriterion("borrow_company_location not between", value1, value2, "borrowCompanyLocation");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyCodeIsNull() {
            addCriterion("borrow_company_code is null");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyCodeIsNotNull() {
            addCriterion("borrow_company_code is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyCodeEqualTo(String value) {
            addCriterion("borrow_company_code =", value, "borrowCompanyCode");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyCodeNotEqualTo(String value) {
            addCriterion("borrow_company_code <>", value, "borrowCompanyCode");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyCodeGreaterThan(String value) {
            addCriterion("borrow_company_code >", value, "borrowCompanyCode");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_company_code >=", value, "borrowCompanyCode");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyCodeLessThan(String value) {
            addCriterion("borrow_company_code <", value, "borrowCompanyCode");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("borrow_company_code <=", value, "borrowCompanyCode");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyCodeLike(String value) {
            addCriterion("borrow_company_code like", value, "borrowCompanyCode");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyCodeNotLike(String value) {
            addCriterion("borrow_company_code not like", value, "borrowCompanyCode");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyCodeIn(List<String> values) {
            addCriterion("borrow_company_code in", values, "borrowCompanyCode");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyCodeNotIn(List<String> values) {
            addCriterion("borrow_company_code not in", values, "borrowCompanyCode");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyCodeBetween(String value1, String value2) {
            addCriterion("borrow_company_code between", value1, value2, "borrowCompanyCode");
            return (Criteria) this;
        }

        public Criteria andBorrowCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("borrow_company_code not between", value1, value2, "borrowCompanyCode");
            return (Criteria) this;
        }

        public Criteria andBorrowFinancingFundIsNull() {
            addCriterion("borrow_financing_fund is null");
            return (Criteria) this;
        }

        public Criteria andBorrowFinancingFundIsNotNull() {
            addCriterion("borrow_financing_fund is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowFinancingFundEqualTo(Double value) {
            addCriterion("borrow_financing_fund =", value, "borrowFinancingFund");
            return (Criteria) this;
        }

        public Criteria andBorrowFinancingFundNotEqualTo(Double value) {
            addCriterion("borrow_financing_fund <>", value, "borrowFinancingFund");
            return (Criteria) this;
        }

        public Criteria andBorrowFinancingFundGreaterThan(Double value) {
            addCriterion("borrow_financing_fund >", value, "borrowFinancingFund");
            return (Criteria) this;
        }

        public Criteria andBorrowFinancingFundGreaterThanOrEqualTo(Double value) {
            addCriterion("borrow_financing_fund >=", value, "borrowFinancingFund");
            return (Criteria) this;
        }

        public Criteria andBorrowFinancingFundLessThan(Double value) {
            addCriterion("borrow_financing_fund <", value, "borrowFinancingFund");
            return (Criteria) this;
        }

        public Criteria andBorrowFinancingFundLessThanOrEqualTo(Double value) {
            addCriterion("borrow_financing_fund <=", value, "borrowFinancingFund");
            return (Criteria) this;
        }

        public Criteria andBorrowFinancingFundIn(List<Double> values) {
            addCriterion("borrow_financing_fund in", values, "borrowFinancingFund");
            return (Criteria) this;
        }

        public Criteria andBorrowFinancingFundNotIn(List<Double> values) {
            addCriterion("borrow_financing_fund not in", values, "borrowFinancingFund");
            return (Criteria) this;
        }

        public Criteria andBorrowFinancingFundBetween(Double value1, Double value2) {
            addCriterion("borrow_financing_fund between", value1, value2, "borrowFinancingFund");
            return (Criteria) this;
        }

        public Criteria andBorrowFinancingFundNotBetween(Double value1, Double value2) {
            addCriterion("borrow_financing_fund not between", value1, value2, "borrowFinancingFund");
            return (Criteria) this;
        }

        public Criteria andBorrowStateIsNull() {
            addCriterion("borrow_state is null");
            return (Criteria) this;
        }

        public Criteria andBorrowStateIsNotNull() {
            addCriterion("borrow_state is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowStateEqualTo(Byte value) {
            addCriterion("borrow_state =", value, "borrowState");
            return (Criteria) this;
        }

        public Criteria andBorrowStateNotEqualTo(Byte value) {
            addCriterion("borrow_state <>", value, "borrowState");
            return (Criteria) this;
        }

        public Criteria andBorrowStateGreaterThan(Byte value) {
            addCriterion("borrow_state >", value, "borrowState");
            return (Criteria) this;
        }

        public Criteria andBorrowStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("borrow_state >=", value, "borrowState");
            return (Criteria) this;
        }

        public Criteria andBorrowStateLessThan(Byte value) {
            addCriterion("borrow_state <", value, "borrowState");
            return (Criteria) this;
        }

        public Criteria andBorrowStateLessThanOrEqualTo(Byte value) {
            addCriterion("borrow_state <=", value, "borrowState");
            return (Criteria) this;
        }

        public Criteria andBorrowStateIn(List<Byte> values) {
            addCriterion("borrow_state in", values, "borrowState");
            return (Criteria) this;
        }

        public Criteria andBorrowStateNotIn(List<Byte> values) {
            addCriterion("borrow_state not in", values, "borrowState");
            return (Criteria) this;
        }

        public Criteria andBorrowStateBetween(Byte value1, Byte value2) {
            addCriterion("borrow_state between", value1, value2, "borrowState");
            return (Criteria) this;
        }

        public Criteria andBorrowStateNotBetween(Byte value1, Byte value2) {
            addCriterion("borrow_state not between", value1, value2, "borrowState");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andIsRepayIsNull() {
            addCriterion("is_repay is null");
            return (Criteria) this;
        }

        public Criteria andIsRepayIsNotNull() {
            addCriterion("is_repay is not null");
            return (Criteria) this;
        }

        public Criteria andIsRepayEqualTo(Byte value) {
            addCriterion("is_repay =", value, "isRepay");
            return (Criteria) this;
        }

        public Criteria andIsRepayNotEqualTo(Byte value) {
            addCriterion("is_repay <>", value, "isRepay");
            return (Criteria) this;
        }

        public Criteria andIsRepayGreaterThan(Byte value) {
            addCriterion("is_repay >", value, "isRepay");
            return (Criteria) this;
        }

        public Criteria andIsRepayGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_repay >=", value, "isRepay");
            return (Criteria) this;
        }

        public Criteria andIsRepayLessThan(Byte value) {
            addCriterion("is_repay <", value, "isRepay");
            return (Criteria) this;
        }

        public Criteria andIsRepayLessThanOrEqualTo(Byte value) {
            addCriterion("is_repay <=", value, "isRepay");
            return (Criteria) this;
        }

        public Criteria andIsRepayIn(List<Byte> values) {
            addCriterion("is_repay in", values, "isRepay");
            return (Criteria) this;
        }

        public Criteria andIsRepayNotIn(List<Byte> values) {
            addCriterion("is_repay not in", values, "isRepay");
            return (Criteria) this;
        }

        public Criteria andIsRepayBetween(Byte value1, Byte value2) {
            addCriterion("is_repay between", value1, value2, "isRepay");
            return (Criteria) this;
        }

        public Criteria andIsRepayNotBetween(Byte value1, Byte value2) {
            addCriterion("is_repay not between", value1, value2, "isRepay");
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

        public Criteria andMaterialIdIsNull() {
            addCriterion("material_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNotNull() {
            addCriterion("material_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdEqualTo(String value) {
            addCriterion("material_id =", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotEqualTo(String value) {
            addCriterion("material_id <>", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThan(String value) {
            addCriterion("material_id >", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThanOrEqualTo(String value) {
            addCriterion("material_id >=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThan(String value) {
            addCriterion("material_id <", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThanOrEqualTo(String value) {
            addCriterion("material_id <=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLike(String value) {
            addCriterion("material_id like", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotLike(String value) {
            addCriterion("material_id not like", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIn(List<String> values) {
            addCriterion("material_id in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotIn(List<String> values) {
            addCriterion("material_id not in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdBetween(String value1, String value2) {
            addCriterion("material_id between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotBetween(String value1, String value2) {
            addCriterion("material_id not between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andRemindContentIsNull() {
            addCriterion("remind_content is null");
            return (Criteria) this;
        }

        public Criteria andRemindContentIsNotNull() {
            addCriterion("remind_content is not null");
            return (Criteria) this;
        }

        public Criteria andRemindContentEqualTo(String value) {
            addCriterion("remind_content =", value, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentNotEqualTo(String value) {
            addCriterion("remind_content <>", value, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentGreaterThan(String value) {
            addCriterion("remind_content >", value, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentGreaterThanOrEqualTo(String value) {
            addCriterion("remind_content >=", value, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentLessThan(String value) {
            addCriterion("remind_content <", value, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentLessThanOrEqualTo(String value) {
            addCriterion("remind_content <=", value, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentLike(String value) {
            addCriterion("remind_content like", value, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentNotLike(String value) {
            addCriterion("remind_content not like", value, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentIn(List<String> values) {
            addCriterion("remind_content in", values, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentNotIn(List<String> values) {
            addCriterion("remind_content not in", values, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentBetween(String value1, String value2) {
            addCriterion("remind_content between", value1, value2, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentNotBetween(String value1, String value2) {
            addCriterion("remind_content not between", value1, value2, "remindContent");
            return (Criteria) this;
        }

        public Criteria andBorrowMoneyIsNull() {
            addCriterion("borrow_money is null");
            return (Criteria) this;
        }

        public Criteria andBorrowMoneyIsNotNull() {
            addCriterion("borrow_money is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowMoneyEqualTo(Double value) {
            addCriterion("borrow_money =", value, "borrowMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowMoneyNotEqualTo(Double value) {
            addCriterion("borrow_money <>", value, "borrowMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowMoneyGreaterThan(Double value) {
            addCriterion("borrow_money >", value, "borrowMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("borrow_money >=", value, "borrowMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowMoneyLessThan(Double value) {
            addCriterion("borrow_money <", value, "borrowMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowMoneyLessThanOrEqualTo(Double value) {
            addCriterion("borrow_money <=", value, "borrowMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowMoneyIn(List<Double> values) {
            addCriterion("borrow_money in", values, "borrowMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowMoneyNotIn(List<Double> values) {
            addCriterion("borrow_money not in", values, "borrowMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowMoneyBetween(Double value1, Double value2) {
            addCriterion("borrow_money between", value1, value2, "borrowMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowMoneyNotBetween(Double value1, Double value2) {
            addCriterion("borrow_money not between", value1, value2, "borrowMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnMoneyIsNull() {
            addCriterion("borrow_return_money is null");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnMoneyIsNotNull() {
            addCriterion("borrow_return_money is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnMoneyEqualTo(Double value) {
            addCriterion("borrow_return_money =", value, "borrowReturnMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnMoneyNotEqualTo(Double value) {
            addCriterion("borrow_return_money <>", value, "borrowReturnMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnMoneyGreaterThan(Double value) {
            addCriterion("borrow_return_money >", value, "borrowReturnMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("borrow_return_money >=", value, "borrowReturnMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnMoneyLessThan(Double value) {
            addCriterion("borrow_return_money <", value, "borrowReturnMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnMoneyLessThanOrEqualTo(Double value) {
            addCriterion("borrow_return_money <=", value, "borrowReturnMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnMoneyIn(List<Double> values) {
            addCriterion("borrow_return_money in", values, "borrowReturnMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnMoneyNotIn(List<Double> values) {
            addCriterion("borrow_return_money not in", values, "borrowReturnMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnMoneyBetween(Double value1, Double value2) {
            addCriterion("borrow_return_money between", value1, value2, "borrowReturnMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnMoneyNotBetween(Double value1, Double value2) {
            addCriterion("borrow_return_money not between", value1, value2, "borrowReturnMoney");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnDateIsNull() {
            addCriterion("borrow_return_date is null");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnDateIsNotNull() {
            addCriterion("borrow_return_date is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnDateEqualTo(Date value) {
            addCriterion("borrow_return_date =", value, "borrowReturnDate");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnDateNotEqualTo(Date value) {
            addCriterion("borrow_return_date <>", value, "borrowReturnDate");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnDateGreaterThan(Date value) {
            addCriterion("borrow_return_date >", value, "borrowReturnDate");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnDateGreaterThanOrEqualTo(Date value) {
            addCriterion("borrow_return_date >=", value, "borrowReturnDate");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnDateLessThan(Date value) {
            addCriterion("borrow_return_date <", value, "borrowReturnDate");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnDateLessThanOrEqualTo(Date value) {
            addCriterion("borrow_return_date <=", value, "borrowReturnDate");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnDateIn(List<Date> values) {
            addCriterion("borrow_return_date in", values, "borrowReturnDate");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnDateNotIn(List<Date> values) {
            addCriterion("borrow_return_date not in", values, "borrowReturnDate");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnDateBetween(Date value1, Date value2) {
            addCriterion("borrow_return_date between", value1, value2, "borrowReturnDate");
            return (Criteria) this;
        }

        public Criteria andBorrowReturnDateNotBetween(Date value1, Date value2) {
            addCriterion("borrow_return_date not between", value1, value2, "borrowReturnDate");
            return (Criteria) this;
        }

        public Criteria andBorrowMonthIsNull() {
            addCriterion("borrow_month is null");
            return (Criteria) this;
        }

        public Criteria andBorrowMonthIsNotNull() {
            addCriterion("borrow_month is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowMonthEqualTo(String value) {
            addCriterion("borrow_month =", value, "borrowMonth");
            return (Criteria) this;
        }

        public Criteria andBorrowMonthNotEqualTo(String value) {
            addCriterion("borrow_month <>", value, "borrowMonth");
            return (Criteria) this;
        }

        public Criteria andBorrowMonthGreaterThan(String value) {
            addCriterion("borrow_month >", value, "borrowMonth");
            return (Criteria) this;
        }

        public Criteria andBorrowMonthGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_month >=", value, "borrowMonth");
            return (Criteria) this;
        }

        public Criteria andBorrowMonthLessThan(String value) {
            addCriterion("borrow_month <", value, "borrowMonth");
            return (Criteria) this;
        }

        public Criteria andBorrowMonthLessThanOrEqualTo(String value) {
            addCriterion("borrow_month <=", value, "borrowMonth");
            return (Criteria) this;
        }

        public Criteria andBorrowMonthLike(String value) {
            addCriterion("borrow_month like", value, "borrowMonth");
            return (Criteria) this;
        }

        public Criteria andBorrowMonthNotLike(String value) {
            addCriterion("borrow_month not like", value, "borrowMonth");
            return (Criteria) this;
        }

        public Criteria andBorrowMonthIn(List<String> values) {
            addCriterion("borrow_month in", values, "borrowMonth");
            return (Criteria) this;
        }

        public Criteria andBorrowMonthNotIn(List<String> values) {
            addCriterion("borrow_month not in", values, "borrowMonth");
            return (Criteria) this;
        }

        public Criteria andBorrowMonthBetween(String value1, String value2) {
            addCriterion("borrow_month between", value1, value2, "borrowMonth");
            return (Criteria) this;
        }

        public Criteria andBorrowMonthNotBetween(String value1, String value2) {
            addCriterion("borrow_month not between", value1, value2, "borrowMonth");
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
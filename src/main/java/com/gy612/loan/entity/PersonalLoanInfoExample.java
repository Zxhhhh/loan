package com.gy612.loan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonalLoanInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonalLoanInfoExample() {
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

        public Criteria andLoanNameIsNull() {
            addCriterion("loan_name is null");
            return (Criteria) this;
        }

        public Criteria andLoanNameIsNotNull() {
            addCriterion("loan_name is not null");
            return (Criteria) this;
        }

        public Criteria andLoanNameEqualTo(String value) {
            addCriterion("loan_name =", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameNotEqualTo(String value) {
            addCriterion("loan_name <>", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameGreaterThan(String value) {
            addCriterion("loan_name >", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameGreaterThanOrEqualTo(String value) {
            addCriterion("loan_name >=", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameLessThan(String value) {
            addCriterion("loan_name <", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameLessThanOrEqualTo(String value) {
            addCriterion("loan_name <=", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameLike(String value) {
            addCriterion("loan_name like", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameNotLike(String value) {
            addCriterion("loan_name not like", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameIn(List<String> values) {
            addCriterion("loan_name in", values, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameNotIn(List<String> values) {
            addCriterion("loan_name not in", values, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameBetween(String value1, String value2) {
            addCriterion("loan_name between", value1, value2, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameNotBetween(String value1, String value2) {
            addCriterion("loan_name not between", value1, value2, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneIsNull() {
            addCriterion("loan_phone is null");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneIsNotNull() {
            addCriterion("loan_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneEqualTo(String value) {
            addCriterion("loan_phone =", value, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneNotEqualTo(String value) {
            addCriterion("loan_phone <>", value, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneGreaterThan(String value) {
            addCriterion("loan_phone >", value, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("loan_phone >=", value, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneLessThan(String value) {
            addCriterion("loan_phone <", value, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneLessThanOrEqualTo(String value) {
            addCriterion("loan_phone <=", value, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneLike(String value) {
            addCriterion("loan_phone like", value, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneNotLike(String value) {
            addCriterion("loan_phone not like", value, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneIn(List<String> values) {
            addCriterion("loan_phone in", values, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneNotIn(List<String> values) {
            addCriterion("loan_phone not in", values, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneBetween(String value1, String value2) {
            addCriterion("loan_phone between", value1, value2, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneNotBetween(String value1, String value2) {
            addCriterion("loan_phone not between", value1, value2, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanLocationIsNull() {
            addCriterion("loan_location is null");
            return (Criteria) this;
        }

        public Criteria andLoanLocationIsNotNull() {
            addCriterion("loan_location is not null");
            return (Criteria) this;
        }

        public Criteria andLoanLocationEqualTo(String value) {
            addCriterion("loan_location =", value, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationNotEqualTo(String value) {
            addCriterion("loan_location <>", value, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationGreaterThan(String value) {
            addCriterion("loan_location >", value, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationGreaterThanOrEqualTo(String value) {
            addCriterion("loan_location >=", value, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationLessThan(String value) {
            addCriterion("loan_location <", value, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationLessThanOrEqualTo(String value) {
            addCriterion("loan_location <=", value, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationLike(String value) {
            addCriterion("loan_location like", value, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationNotLike(String value) {
            addCriterion("loan_location not like", value, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationIn(List<String> values) {
            addCriterion("loan_location in", values, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationNotIn(List<String> values) {
            addCriterion("loan_location not in", values, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationBetween(String value1, String value2) {
            addCriterion("loan_location between", value1, value2, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationNotBetween(String value1, String value2) {
            addCriterion("loan_location not between", value1, value2, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyIsNull() {
            addCriterion("loan_money is null");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyIsNotNull() {
            addCriterion("loan_money is not null");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyEqualTo(Double value) {
            addCriterion("loan_money =", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyNotEqualTo(Double value) {
            addCriterion("loan_money <>", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyGreaterThan(Double value) {
            addCriterion("loan_money >", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("loan_money >=", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyLessThan(Double value) {
            addCriterion("loan_money <", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyLessThanOrEqualTo(Double value) {
            addCriterion("loan_money <=", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyIn(List<Double> values) {
            addCriterion("loan_money in", values, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyNotIn(List<Double> values) {
            addCriterion("loan_money not in", values, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyBetween(Double value1, Double value2) {
            addCriterion("loan_money between", value1, value2, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyNotBetween(Double value1, Double value2) {
            addCriterion("loan_money not between", value1, value2, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanDeadlineIsNull() {
            addCriterion("loan_deadline is null");
            return (Criteria) this;
        }

        public Criteria andLoanDeadlineIsNotNull() {
            addCriterion("loan_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andLoanDeadlineEqualTo(Date value) {
            addCriterion("loan_deadline =", value, "loanDeadline");
            return (Criteria) this;
        }

        public Criteria andLoanDeadlineNotEqualTo(Date value) {
            addCriterion("loan_deadline <>", value, "loanDeadline");
            return (Criteria) this;
        }

        public Criteria andLoanDeadlineGreaterThan(Date value) {
            addCriterion("loan_deadline >", value, "loanDeadline");
            return (Criteria) this;
        }

        public Criteria andLoanDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("loan_deadline >=", value, "loanDeadline");
            return (Criteria) this;
        }

        public Criteria andLoanDeadlineLessThan(Date value) {
            addCriterion("loan_deadline <", value, "loanDeadline");
            return (Criteria) this;
        }

        public Criteria andLoanDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("loan_deadline <=", value, "loanDeadline");
            return (Criteria) this;
        }

        public Criteria andLoanDeadlineIn(List<Date> values) {
            addCriterion("loan_deadline in", values, "loanDeadline");
            return (Criteria) this;
        }

        public Criteria andLoanDeadlineNotIn(List<Date> values) {
            addCriterion("loan_deadline not in", values, "loanDeadline");
            return (Criteria) this;
        }

        public Criteria andLoanDeadlineBetween(Date value1, Date value2) {
            addCriterion("loan_deadline between", value1, value2, "loanDeadline");
            return (Criteria) this;
        }

        public Criteria andLoanDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("loan_deadline not between", value1, value2, "loanDeadline");
            return (Criteria) this;
        }

        public Criteria andLoanStateIsNull() {
            addCriterion("loan_state is null");
            return (Criteria) this;
        }

        public Criteria andLoanStateIsNotNull() {
            addCriterion("loan_state is not null");
            return (Criteria) this;
        }

        public Criteria andLoanStateEqualTo(Byte value) {
            addCriterion("loan_state =", value, "loanState");
            return (Criteria) this;
        }

        public Criteria andLoanStateNotEqualTo(Byte value) {
            addCriterion("loan_state <>", value, "loanState");
            return (Criteria) this;
        }

        public Criteria andLoanStateGreaterThan(Byte value) {
            addCriterion("loan_state >", value, "loanState");
            return (Criteria) this;
        }

        public Criteria andLoanStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("loan_state >=", value, "loanState");
            return (Criteria) this;
        }

        public Criteria andLoanStateLessThan(Byte value) {
            addCriterion("loan_state <", value, "loanState");
            return (Criteria) this;
        }

        public Criteria andLoanStateLessThanOrEqualTo(Byte value) {
            addCriterion("loan_state <=", value, "loanState");
            return (Criteria) this;
        }

        public Criteria andLoanStateIn(List<Byte> values) {
            addCriterion("loan_state in", values, "loanState");
            return (Criteria) this;
        }

        public Criteria andLoanStateNotIn(List<Byte> values) {
            addCriterion("loan_state not in", values, "loanState");
            return (Criteria) this;
        }

        public Criteria andLoanStateBetween(Byte value1, Byte value2) {
            addCriterion("loan_state between", value1, value2, "loanState");
            return (Criteria) this;
        }

        public Criteria andLoanStateNotBetween(Byte value1, Byte value2) {
            addCriterion("loan_state not between", value1, value2, "loanState");
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

        public Criteria andMeterialIdIsNull() {
            addCriterion("meterial_id is null");
            return (Criteria) this;
        }

        public Criteria andMeterialIdIsNotNull() {
            addCriterion("meterial_id is not null");
            return (Criteria) this;
        }

        public Criteria andMeterialIdEqualTo(String value) {
            addCriterion("meterial_id =", value, "meterialId");
            return (Criteria) this;
        }

        public Criteria andMeterialIdNotEqualTo(String value) {
            addCriterion("meterial_id <>", value, "meterialId");
            return (Criteria) this;
        }

        public Criteria andMeterialIdGreaterThan(String value) {
            addCriterion("meterial_id >", value, "meterialId");
            return (Criteria) this;
        }

        public Criteria andMeterialIdGreaterThanOrEqualTo(String value) {
            addCriterion("meterial_id >=", value, "meterialId");
            return (Criteria) this;
        }

        public Criteria andMeterialIdLessThan(String value) {
            addCriterion("meterial_id <", value, "meterialId");
            return (Criteria) this;
        }

        public Criteria andMeterialIdLessThanOrEqualTo(String value) {
            addCriterion("meterial_id <=", value, "meterialId");
            return (Criteria) this;
        }

        public Criteria andMeterialIdLike(String value) {
            addCriterion("meterial_id like", value, "meterialId");
            return (Criteria) this;
        }

        public Criteria andMeterialIdNotLike(String value) {
            addCriterion("meterial_id not like", value, "meterialId");
            return (Criteria) this;
        }

        public Criteria andMeterialIdIn(List<String> values) {
            addCriterion("meterial_id in", values, "meterialId");
            return (Criteria) this;
        }

        public Criteria andMeterialIdNotIn(List<String> values) {
            addCriterion("meterial_id not in", values, "meterialId");
            return (Criteria) this;
        }

        public Criteria andMeterialIdBetween(String value1, String value2) {
            addCriterion("meterial_id between", value1, value2, "meterialId");
            return (Criteria) this;
        }

        public Criteria andMeterialIdNotBetween(String value1, String value2) {
            addCriterion("meterial_id not between", value1, value2, "meterialId");
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

        public Criteria andLoanReturnMoneyIsNull() {
            addCriterion("loan_return_money is null");
            return (Criteria) this;
        }

        public Criteria andLoanReturnMoneyIsNotNull() {
            addCriterion("loan_return_money is not null");
            return (Criteria) this;
        }

        public Criteria andLoanReturnMoneyEqualTo(Double value) {
            addCriterion("loan_return_money =", value, "loanReturnMoney");
            return (Criteria) this;
        }

        public Criteria andLoanReturnMoneyNotEqualTo(Double value) {
            addCriterion("loan_return_money <>", value, "loanReturnMoney");
            return (Criteria) this;
        }

        public Criteria andLoanReturnMoneyGreaterThan(Double value) {
            addCriterion("loan_return_money >", value, "loanReturnMoney");
            return (Criteria) this;
        }

        public Criteria andLoanReturnMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("loan_return_money >=", value, "loanReturnMoney");
            return (Criteria) this;
        }

        public Criteria andLoanReturnMoneyLessThan(Double value) {
            addCriterion("loan_return_money <", value, "loanReturnMoney");
            return (Criteria) this;
        }

        public Criteria andLoanReturnMoneyLessThanOrEqualTo(Double value) {
            addCriterion("loan_return_money <=", value, "loanReturnMoney");
            return (Criteria) this;
        }

        public Criteria andLoanReturnMoneyIn(List<Double> values) {
            addCriterion("loan_return_money in", values, "loanReturnMoney");
            return (Criteria) this;
        }

        public Criteria andLoanReturnMoneyNotIn(List<Double> values) {
            addCriterion("loan_return_money not in", values, "loanReturnMoney");
            return (Criteria) this;
        }

        public Criteria andLoanReturnMoneyBetween(Double value1, Double value2) {
            addCriterion("loan_return_money between", value1, value2, "loanReturnMoney");
            return (Criteria) this;
        }

        public Criteria andLoanReturnMoneyNotBetween(Double value1, Double value2) {
            addCriterion("loan_return_money not between", value1, value2, "loanReturnMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMonthIsNull() {
            addCriterion("loan_month is null");
            return (Criteria) this;
        }

        public Criteria andLoanMonthIsNotNull() {
            addCriterion("loan_month is not null");
            return (Criteria) this;
        }

        public Criteria andLoanMonthEqualTo(Integer value) {
            addCriterion("loan_month =", value, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthNotEqualTo(Integer value) {
            addCriterion("loan_month <>", value, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthGreaterThan(Integer value) {
            addCriterion("loan_month >", value, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan_month >=", value, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthLessThan(Integer value) {
            addCriterion("loan_month <", value, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthLessThanOrEqualTo(Integer value) {
            addCriterion("loan_month <=", value, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthIn(List<Integer> values) {
            addCriterion("loan_month in", values, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthNotIn(List<Integer> values) {
            addCriterion("loan_month not in", values, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthBetween(Integer value1, Integer value2) {
            addCriterion("loan_month between", value1, value2, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("loan_month not between", value1, value2, "loanMonth");
            return (Criteria) this;
        }

        public Criteria andLoanRepayDateIsNull() {
            addCriterion("loan_repay_date is null");
            return (Criteria) this;
        }

        public Criteria andLoanRepayDateIsNotNull() {
            addCriterion("loan_repay_date is not null");
            return (Criteria) this;
        }

        public Criteria andLoanRepayDateEqualTo(Date value) {
            addCriterion("loan_repay_date =", value, "loanRepayDate");
            return (Criteria) this;
        }

        public Criteria andLoanRepayDateNotEqualTo(Date value) {
            addCriterion("loan_repay_date <>", value, "loanRepayDate");
            return (Criteria) this;
        }

        public Criteria andLoanRepayDateGreaterThan(Date value) {
            addCriterion("loan_repay_date >", value, "loanRepayDate");
            return (Criteria) this;
        }

        public Criteria andLoanRepayDateGreaterThanOrEqualTo(Date value) {
            addCriterion("loan_repay_date >=", value, "loanRepayDate");
            return (Criteria) this;
        }

        public Criteria andLoanRepayDateLessThan(Date value) {
            addCriterion("loan_repay_date <", value, "loanRepayDate");
            return (Criteria) this;
        }

        public Criteria andLoanRepayDateLessThanOrEqualTo(Date value) {
            addCriterion("loan_repay_date <=", value, "loanRepayDate");
            return (Criteria) this;
        }

        public Criteria andLoanRepayDateIn(List<Date> values) {
            addCriterion("loan_repay_date in", values, "loanRepayDate");
            return (Criteria) this;
        }

        public Criteria andLoanRepayDateNotIn(List<Date> values) {
            addCriterion("loan_repay_date not in", values, "loanRepayDate");
            return (Criteria) this;
        }

        public Criteria andLoanRepayDateBetween(Date value1, Date value2) {
            addCriterion("loan_repay_date between", value1, value2, "loanRepayDate");
            return (Criteria) this;
        }

        public Criteria andLoanRepayDateNotBetween(Date value1, Date value2) {
            addCriterion("loan_repay_date not between", value1, value2, "loanRepayDate");
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
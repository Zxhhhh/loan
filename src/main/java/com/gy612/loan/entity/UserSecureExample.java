package com.gy612.loan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserSecureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserSecureExample() {
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

        public Criteria andSecureMailIsNull() {
            addCriterion("secure_mail is null");
            return (Criteria) this;
        }

        public Criteria andSecureMailIsNotNull() {
            addCriterion("secure_mail is not null");
            return (Criteria) this;
        }

        public Criteria andSecureMailEqualTo(String value) {
            addCriterion("secure_mail =", value, "secureMail");
            return (Criteria) this;
        }

        public Criteria andSecureMailNotEqualTo(String value) {
            addCriterion("secure_mail <>", value, "secureMail");
            return (Criteria) this;
        }

        public Criteria andSecureMailGreaterThan(String value) {
            addCriterion("secure_mail >", value, "secureMail");
            return (Criteria) this;
        }

        public Criteria andSecureMailGreaterThanOrEqualTo(String value) {
            addCriterion("secure_mail >=", value, "secureMail");
            return (Criteria) this;
        }

        public Criteria andSecureMailLessThan(String value) {
            addCriterion("secure_mail <", value, "secureMail");
            return (Criteria) this;
        }

        public Criteria andSecureMailLessThanOrEqualTo(String value) {
            addCriterion("secure_mail <=", value, "secureMail");
            return (Criteria) this;
        }

        public Criteria andSecureMailLike(String value) {
            addCriterion("secure_mail like", value, "secureMail");
            return (Criteria) this;
        }

        public Criteria andSecureMailNotLike(String value) {
            addCriterion("secure_mail not like", value, "secureMail");
            return (Criteria) this;
        }

        public Criteria andSecureMailIn(List<String> values) {
            addCriterion("secure_mail in", values, "secureMail");
            return (Criteria) this;
        }

        public Criteria andSecureMailNotIn(List<String> values) {
            addCriterion("secure_mail not in", values, "secureMail");
            return (Criteria) this;
        }

        public Criteria andSecureMailBetween(String value1, String value2) {
            addCriterion("secure_mail between", value1, value2, "secureMail");
            return (Criteria) this;
        }

        public Criteria andSecureMailNotBetween(String value1, String value2) {
            addCriterion("secure_mail not between", value1, value2, "secureMail");
            return (Criteria) this;
        }

        public Criteria andSecureQuestionIsNull() {
            addCriterion("secure_question is null");
            return (Criteria) this;
        }

        public Criteria andSecureQuestionIsNotNull() {
            addCriterion("secure_question is not null");
            return (Criteria) this;
        }

        public Criteria andSecureQuestionEqualTo(String value) {
            addCriterion("secure_question =", value, "secureQuestion");
            return (Criteria) this;
        }

        public Criteria andSecureQuestionNotEqualTo(String value) {
            addCriterion("secure_question <>", value, "secureQuestion");
            return (Criteria) this;
        }

        public Criteria andSecureQuestionGreaterThan(String value) {
            addCriterion("secure_question >", value, "secureQuestion");
            return (Criteria) this;
        }

        public Criteria andSecureQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("secure_question >=", value, "secureQuestion");
            return (Criteria) this;
        }

        public Criteria andSecureQuestionLessThan(String value) {
            addCriterion("secure_question <", value, "secureQuestion");
            return (Criteria) this;
        }

        public Criteria andSecureQuestionLessThanOrEqualTo(String value) {
            addCriterion("secure_question <=", value, "secureQuestion");
            return (Criteria) this;
        }

        public Criteria andSecureQuestionLike(String value) {
            addCriterion("secure_question like", value, "secureQuestion");
            return (Criteria) this;
        }

        public Criteria andSecureQuestionNotLike(String value) {
            addCriterion("secure_question not like", value, "secureQuestion");
            return (Criteria) this;
        }

        public Criteria andSecureQuestionIn(List<String> values) {
            addCriterion("secure_question in", values, "secureQuestion");
            return (Criteria) this;
        }

        public Criteria andSecureQuestionNotIn(List<String> values) {
            addCriterion("secure_question not in", values, "secureQuestion");
            return (Criteria) this;
        }

        public Criteria andSecureQuestionBetween(String value1, String value2) {
            addCriterion("secure_question between", value1, value2, "secureQuestion");
            return (Criteria) this;
        }

        public Criteria andSecureQuestionNotBetween(String value1, String value2) {
            addCriterion("secure_question not between", value1, value2, "secureQuestion");
            return (Criteria) this;
        }

        public Criteria andSecureAnswerIsNull() {
            addCriterion("secure_answer is null");
            return (Criteria) this;
        }

        public Criteria andSecureAnswerIsNotNull() {
            addCriterion("secure_answer is not null");
            return (Criteria) this;
        }

        public Criteria andSecureAnswerEqualTo(String value) {
            addCriterion("secure_answer =", value, "secureAnswer");
            return (Criteria) this;
        }

        public Criteria andSecureAnswerNotEqualTo(String value) {
            addCriterion("secure_answer <>", value, "secureAnswer");
            return (Criteria) this;
        }

        public Criteria andSecureAnswerGreaterThan(String value) {
            addCriterion("secure_answer >", value, "secureAnswer");
            return (Criteria) this;
        }

        public Criteria andSecureAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("secure_answer >=", value, "secureAnswer");
            return (Criteria) this;
        }

        public Criteria andSecureAnswerLessThan(String value) {
            addCriterion("secure_answer <", value, "secureAnswer");
            return (Criteria) this;
        }

        public Criteria andSecureAnswerLessThanOrEqualTo(String value) {
            addCriterion("secure_answer <=", value, "secureAnswer");
            return (Criteria) this;
        }

        public Criteria andSecureAnswerLike(String value) {
            addCriterion("secure_answer like", value, "secureAnswer");
            return (Criteria) this;
        }

        public Criteria andSecureAnswerNotLike(String value) {
            addCriterion("secure_answer not like", value, "secureAnswer");
            return (Criteria) this;
        }

        public Criteria andSecureAnswerIn(List<String> values) {
            addCriterion("secure_answer in", values, "secureAnswer");
            return (Criteria) this;
        }

        public Criteria andSecureAnswerNotIn(List<String> values) {
            addCriterion("secure_answer not in", values, "secureAnswer");
            return (Criteria) this;
        }

        public Criteria andSecureAnswerBetween(String value1, String value2) {
            addCriterion("secure_answer between", value1, value2, "secureAnswer");
            return (Criteria) this;
        }

        public Criteria andSecureAnswerNotBetween(String value1, String value2) {
            addCriterion("secure_answer not between", value1, value2, "secureAnswer");
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
package com.gy612.loan.entity;

import java.util.ArrayList;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
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

        public Criteria andUserRealnameIsNull() {
            addCriterion("user_realname is null");
            return (Criteria) this;
        }

        public Criteria andUserRealnameIsNotNull() {
            addCriterion("user_realname is not null");
            return (Criteria) this;
        }

        public Criteria andUserRealnameEqualTo(String value) {
            addCriterion("user_realname =", value, "userRealname");
            return (Criteria) this;
        }

        public Criteria andUserRealnameNotEqualTo(String value) {
            addCriterion("user_realname <>", value, "userRealname");
            return (Criteria) this;
        }

        public Criteria andUserRealnameGreaterThan(String value) {
            addCriterion("user_realname >", value, "userRealname");
            return (Criteria) this;
        }

        public Criteria andUserRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("user_realname >=", value, "userRealname");
            return (Criteria) this;
        }

        public Criteria andUserRealnameLessThan(String value) {
            addCriterion("user_realname <", value, "userRealname");
            return (Criteria) this;
        }

        public Criteria andUserRealnameLessThanOrEqualTo(String value) {
            addCriterion("user_realname <=", value, "userRealname");
            return (Criteria) this;
        }

        public Criteria andUserRealnameLike(String value) {
            addCriterion("user_realname like", value, "userRealname");
            return (Criteria) this;
        }

        public Criteria andUserRealnameNotLike(String value) {
            addCriterion("user_realname not like", value, "userRealname");
            return (Criteria) this;
        }

        public Criteria andUserRealnameIn(List<String> values) {
            addCriterion("user_realname in", values, "userRealname");
            return (Criteria) this;
        }

        public Criteria andUserRealnameNotIn(List<String> values) {
            addCriterion("user_realname not in", values, "userRealname");
            return (Criteria) this;
        }

        public Criteria andUserRealnameBetween(String value1, String value2) {
            addCriterion("user_realname between", value1, value2, "userRealname");
            return (Criteria) this;
        }

        public Criteria andUserRealnameNotBetween(String value1, String value2) {
            addCriterion("user_realname not between", value1, value2, "userRealname");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserAddrIsNull() {
            addCriterion("user_addr is null");
            return (Criteria) this;
        }

        public Criteria andUserAddrIsNotNull() {
            addCriterion("user_addr is not null");
            return (Criteria) this;
        }

        public Criteria andUserAddrEqualTo(String value) {
            addCriterion("user_addr =", value, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrNotEqualTo(String value) {
            addCriterion("user_addr <>", value, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrGreaterThan(String value) {
            addCriterion("user_addr >", value, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrGreaterThanOrEqualTo(String value) {
            addCriterion("user_addr >=", value, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrLessThan(String value) {
            addCriterion("user_addr <", value, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrLessThanOrEqualTo(String value) {
            addCriterion("user_addr <=", value, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrLike(String value) {
            addCriterion("user_addr like", value, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrNotLike(String value) {
            addCriterion("user_addr not like", value, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrIn(List<String> values) {
            addCriterion("user_addr in", values, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrNotIn(List<String> values) {
            addCriterion("user_addr not in", values, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrBetween(String value1, String value2) {
            addCriterion("user_addr between", value1, value2, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserAddrNotBetween(String value1, String value2) {
            addCriterion("user_addr not between", value1, value2, "userAddr");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("user_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(String value) {
            addCriterion("user_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(String value) {
            addCriterion("user_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(String value) {
            addCriterion("user_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(String value) {
            addCriterion("user_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(String value) {
            addCriterion("user_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(String value) {
            addCriterion("user_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLike(String value) {
            addCriterion("user_sex like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotLike(String value) {
            addCriterion("user_sex not like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<String> values) {
            addCriterion("user_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<String> values) {
            addCriterion("user_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(String value1, String value2) {
            addCriterion("user_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(String value1, String value2) {
            addCriterion("user_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserAgeIsNull() {
            addCriterion("user_age is null");
            return (Criteria) this;
        }

        public Criteria andUserAgeIsNotNull() {
            addCriterion("user_age is not null");
            return (Criteria) this;
        }

        public Criteria andUserAgeEqualTo(Integer value) {
            addCriterion("user_age =", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotEqualTo(Integer value) {
            addCriterion("user_age <>", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeGreaterThan(Integer value) {
            addCriterion("user_age >", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_age >=", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeLessThan(Integer value) {
            addCriterion("user_age <", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeLessThanOrEqualTo(Integer value) {
            addCriterion("user_age <=", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeIn(List<Integer> values) {
            addCriterion("user_age in", values, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotIn(List<Integer> values) {
            addCriterion("user_age not in", values, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeBetween(Integer value1, Integer value2) {
            addCriterion("user_age between", value1, value2, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_age not between", value1, value2, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserLogoIsNull() {
            addCriterion("user_logo is null");
            return (Criteria) this;
        }

        public Criteria andUserLogoIsNotNull() {
            addCriterion("user_logo is not null");
            return (Criteria) this;
        }

        public Criteria andUserLogoEqualTo(String value) {
            addCriterion("user_logo =", value, "userLogo");
            return (Criteria) this;
        }

        public Criteria andUserLogoNotEqualTo(String value) {
            addCriterion("user_logo <>", value, "userLogo");
            return (Criteria) this;
        }

        public Criteria andUserLogoGreaterThan(String value) {
            addCriterion("user_logo >", value, "userLogo");
            return (Criteria) this;
        }

        public Criteria andUserLogoGreaterThanOrEqualTo(String value) {
            addCriterion("user_logo >=", value, "userLogo");
            return (Criteria) this;
        }

        public Criteria andUserLogoLessThan(String value) {
            addCriterion("user_logo <", value, "userLogo");
            return (Criteria) this;
        }

        public Criteria andUserLogoLessThanOrEqualTo(String value) {
            addCriterion("user_logo <=", value, "userLogo");
            return (Criteria) this;
        }

        public Criteria andUserLogoLike(String value) {
            addCriterion("user_logo like", value, "userLogo");
            return (Criteria) this;
        }

        public Criteria andUserLogoNotLike(String value) {
            addCriterion("user_logo not like", value, "userLogo");
            return (Criteria) this;
        }

        public Criteria andUserLogoIn(List<String> values) {
            addCriterion("user_logo in", values, "userLogo");
            return (Criteria) this;
        }

        public Criteria andUserLogoNotIn(List<String> values) {
            addCriterion("user_logo not in", values, "userLogo");
            return (Criteria) this;
        }

        public Criteria andUserLogoBetween(String value1, String value2) {
            addCriterion("user_logo between", value1, value2, "userLogo");
            return (Criteria) this;
        }

        public Criteria andUserLogoNotBetween(String value1, String value2) {
            addCriterion("user_logo not between", value1, value2, "userLogo");
            return (Criteria) this;
        }

        public Criteria andUserIdentitynumIsNull() {
            addCriterion("user_identitynum is null");
            return (Criteria) this;
        }

        public Criteria andUserIdentitynumIsNotNull() {
            addCriterion("user_identitynum is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdentitynumEqualTo(String value) {
            addCriterion("user_identitynum =", value, "userIdentitynum");
            return (Criteria) this;
        }

        public Criteria andUserIdentitynumNotEqualTo(String value) {
            addCriterion("user_identitynum <>", value, "userIdentitynum");
            return (Criteria) this;
        }

        public Criteria andUserIdentitynumGreaterThan(String value) {
            addCriterion("user_identitynum >", value, "userIdentitynum");
            return (Criteria) this;
        }

        public Criteria andUserIdentitynumGreaterThanOrEqualTo(String value) {
            addCriterion("user_identitynum >=", value, "userIdentitynum");
            return (Criteria) this;
        }

        public Criteria andUserIdentitynumLessThan(String value) {
            addCriterion("user_identitynum <", value, "userIdentitynum");
            return (Criteria) this;
        }

        public Criteria andUserIdentitynumLessThanOrEqualTo(String value) {
            addCriterion("user_identitynum <=", value, "userIdentitynum");
            return (Criteria) this;
        }

        public Criteria andUserIdentitynumLike(String value) {
            addCriterion("user_identitynum like", value, "userIdentitynum");
            return (Criteria) this;
        }

        public Criteria andUserIdentitynumNotLike(String value) {
            addCriterion("user_identitynum not like", value, "userIdentitynum");
            return (Criteria) this;
        }

        public Criteria andUserIdentitynumIn(List<String> values) {
            addCriterion("user_identitynum in", values, "userIdentitynum");
            return (Criteria) this;
        }

        public Criteria andUserIdentitynumNotIn(List<String> values) {
            addCriterion("user_identitynum not in", values, "userIdentitynum");
            return (Criteria) this;
        }

        public Criteria andUserIdentitynumBetween(String value1, String value2) {
            addCriterion("user_identitynum between", value1, value2, "userIdentitynum");
            return (Criteria) this;
        }

        public Criteria andUserIdentitynumNotBetween(String value1, String value2) {
            addCriterion("user_identitynum not between", value1, value2, "userIdentitynum");
            return (Criteria) this;
        }

        public Criteria andUserIdentitypicIsNull() {
            addCriterion("user_identitypic is null");
            return (Criteria) this;
        }

        public Criteria andUserIdentitypicIsNotNull() {
            addCriterion("user_identitypic is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdentitypicEqualTo(String value) {
            addCriterion("user_identitypic =", value, "userIdentitypic");
            return (Criteria) this;
        }

        public Criteria andUserIdentitypicNotEqualTo(String value) {
            addCriterion("user_identitypic <>", value, "userIdentitypic");
            return (Criteria) this;
        }

        public Criteria andUserIdentitypicGreaterThan(String value) {
            addCriterion("user_identitypic >", value, "userIdentitypic");
            return (Criteria) this;
        }

        public Criteria andUserIdentitypicGreaterThanOrEqualTo(String value) {
            addCriterion("user_identitypic >=", value, "userIdentitypic");
            return (Criteria) this;
        }

        public Criteria andUserIdentitypicLessThan(String value) {
            addCriterion("user_identitypic <", value, "userIdentitypic");
            return (Criteria) this;
        }

        public Criteria andUserIdentitypicLessThanOrEqualTo(String value) {
            addCriterion("user_identitypic <=", value, "userIdentitypic");
            return (Criteria) this;
        }

        public Criteria andUserIdentitypicLike(String value) {
            addCriterion("user_identitypic like", value, "userIdentitypic");
            return (Criteria) this;
        }

        public Criteria andUserIdentitypicNotLike(String value) {
            addCriterion("user_identitypic not like", value, "userIdentitypic");
            return (Criteria) this;
        }

        public Criteria andUserIdentitypicIn(List<String> values) {
            addCriterion("user_identitypic in", values, "userIdentitypic");
            return (Criteria) this;
        }

        public Criteria andUserIdentitypicNotIn(List<String> values) {
            addCriterion("user_identitypic not in", values, "userIdentitypic");
            return (Criteria) this;
        }

        public Criteria andUserIdentitypicBetween(String value1, String value2) {
            addCriterion("user_identitypic between", value1, value2, "userIdentitypic");
            return (Criteria) this;
        }

        public Criteria andUserIdentitypicNotBetween(String value1, String value2) {
            addCriterion("user_identitypic not between", value1, value2, "userIdentitypic");
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
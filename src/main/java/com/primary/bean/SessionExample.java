package com.primary.bean;

import java.util.ArrayList;
import java.util.List;

public class SessionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SessionExample() {
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

        public Criteria andSessnidIsNull() {
            addCriterion("sessnId is null");
            return (Criteria) this;
        }

        public Criteria andSessnidIsNotNull() {
            addCriterion("sessnId is not null");
            return (Criteria) this;
        }

        public Criteria andSessnidEqualTo(Integer value) {
            addCriterion("sessnId =", value, "sessnid");
            return (Criteria) this;
        }

        public Criteria andSessnidNotEqualTo(Integer value) {
            addCriterion("sessnId <>", value, "sessnid");
            return (Criteria) this;
        }

        public Criteria andSessnidGreaterThan(Integer value) {
            addCriterion("sessnId >", value, "sessnid");
            return (Criteria) this;
        }

        public Criteria andSessnidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sessnId >=", value, "sessnid");
            return (Criteria) this;
        }

        public Criteria andSessnidLessThan(Integer value) {
            addCriterion("sessnId <", value, "sessnid");
            return (Criteria) this;
        }

        public Criteria andSessnidLessThanOrEqualTo(Integer value) {
            addCriterion("sessnId <=", value, "sessnid");
            return (Criteria) this;
        }

        public Criteria andSessnidIn(List<Integer> values) {
            addCriterion("sessnId in", values, "sessnid");
            return (Criteria) this;
        }

        public Criteria andSessnidNotIn(List<Integer> values) {
            addCriterion("sessnId not in", values, "sessnid");
            return (Criteria) this;
        }

        public Criteria andSessnidBetween(Integer value1, Integer value2) {
            addCriterion("sessnId between", value1, value2, "sessnid");
            return (Criteria) this;
        }

        public Criteria andSessnidNotBetween(Integer value1, Integer value2) {
            addCriterion("sessnId not between", value1, value2, "sessnid");
            return (Criteria) this;
        }

        public Criteria andSessnnameIsNull() {
            addCriterion("sessnName is null");
            return (Criteria) this;
        }

        public Criteria andSessnnameIsNotNull() {
            addCriterion("sessnName is not null");
            return (Criteria) this;
        }

        public Criteria andSessnnameEqualTo(String value) {
            addCriterion("sessnName =", value, "sessnname");
            return (Criteria) this;
        }

        public Criteria andSessnnameNotEqualTo(String value) {
            addCriterion("sessnName <>", value, "sessnname");
            return (Criteria) this;
        }

        public Criteria andSessnnameGreaterThan(String value) {
            addCriterion("sessnName >", value, "sessnname");
            return (Criteria) this;
        }

        public Criteria andSessnnameGreaterThanOrEqualTo(String value) {
            addCriterion("sessnName >=", value, "sessnname");
            return (Criteria) this;
        }

        public Criteria andSessnnameLessThan(String value) {
            addCriterion("sessnName <", value, "sessnname");
            return (Criteria) this;
        }

        public Criteria andSessnnameLessThanOrEqualTo(String value) {
            addCriterion("sessnName <=", value, "sessnname");
            return (Criteria) this;
        }

        public Criteria andSessnnameLike(String value) {
            addCriterion("sessnName like", value, "sessnname");
            return (Criteria) this;
        }

        public Criteria andSessnnameNotLike(String value) {
            addCriterion("sessnName not like", value, "sessnname");
            return (Criteria) this;
        }

        public Criteria andSessnnameIn(List<String> values) {
            addCriterion("sessnName in", values, "sessnname");
            return (Criteria) this;
        }

        public Criteria andSessnnameNotIn(List<String> values) {
            addCriterion("sessnName not in", values, "sessnname");
            return (Criteria) this;
        }

        public Criteria andSessnnameBetween(String value1, String value2) {
            addCriterion("sessnName between", value1, value2, "sessnname");
            return (Criteria) this;
        }

        public Criteria andSessnnameNotBetween(String value1, String value2) {
            addCriterion("sessnName not between", value1, value2, "sessnname");
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
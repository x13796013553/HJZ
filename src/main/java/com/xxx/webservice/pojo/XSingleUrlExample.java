package com.xxx.webservice.pojo;

import java.util.ArrayList;
import java.util.List;

public class XSingleUrlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XSingleUrlExample() {
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

        public Criteria andUrlIdIsNull() {
            addCriterion("url_id is null");
            return (Criteria) this;
        }

        public Criteria andUrlIdIsNotNull() {
            addCriterion("url_id is not null");
            return (Criteria) this;
        }

        public Criteria andUrlIdEqualTo(String value) {
            addCriterion("url_id =", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdNotEqualTo(String value) {
            addCriterion("url_id <>", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdGreaterThan(String value) {
            addCriterion("url_id >", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdGreaterThanOrEqualTo(String value) {
            addCriterion("url_id >=", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdLessThan(String value) {
            addCriterion("url_id <", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdLessThanOrEqualTo(String value) {
            addCriterion("url_id <=", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdLike(String value) {
            addCriterion("url_id like", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdNotLike(String value) {
            addCriterion("url_id not like", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdIn(List<String> values) {
            addCriterion("url_id in", values, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdNotIn(List<String> values) {
            addCriterion("url_id not in", values, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdBetween(String value1, String value2) {
            addCriterion("url_id between", value1, value2, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdNotBetween(String value1, String value2) {
            addCriterion("url_id not between", value1, value2, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlAddressIsNull() {
            addCriterion("url_address is null");
            return (Criteria) this;
        }

        public Criteria andUrlAddressIsNotNull() {
            addCriterion("url_address is not null");
            return (Criteria) this;
        }

        public Criteria andUrlAddressEqualTo(String value) {
            addCriterion("url_address =", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressNotEqualTo(String value) {
            addCriterion("url_address <>", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressGreaterThan(String value) {
            addCriterion("url_address >", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressGreaterThanOrEqualTo(String value) {
            addCriterion("url_address >=", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressLessThan(String value) {
            addCriterion("url_address <", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressLessThanOrEqualTo(String value) {
            addCriterion("url_address <=", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressLike(String value) {
            addCriterion("url_address like", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressNotLike(String value) {
            addCriterion("url_address not like", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressIn(List<String> values) {
            addCriterion("url_address in", values, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressNotIn(List<String> values) {
            addCriterion("url_address not in", values, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressBetween(String value1, String value2) {
            addCriterion("url_address between", value1, value2, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressNotBetween(String value1, String value2) {
            addCriterion("url_address not between", value1, value2, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andLocalUrlIsNull() {
            addCriterion("local_url is null");
            return (Criteria) this;
        }

        public Criteria andLocalUrlIsNotNull() {
            addCriterion("local_url is not null");
            return (Criteria) this;
        }

        public Criteria andLocalUrlEqualTo(String value) {
            addCriterion("local_url =", value, "localUrl");
            return (Criteria) this;
        }

        public Criteria andLocalUrlNotEqualTo(String value) {
            addCriterion("local_url <>", value, "localUrl");
            return (Criteria) this;
        }

        public Criteria andLocalUrlGreaterThan(String value) {
            addCriterion("local_url >", value, "localUrl");
            return (Criteria) this;
        }

        public Criteria andLocalUrlGreaterThanOrEqualTo(String value) {
            addCriterion("local_url >=", value, "localUrl");
            return (Criteria) this;
        }

        public Criteria andLocalUrlLessThan(String value) {
            addCriterion("local_url <", value, "localUrl");
            return (Criteria) this;
        }

        public Criteria andLocalUrlLessThanOrEqualTo(String value) {
            addCriterion("local_url <=", value, "localUrl");
            return (Criteria) this;
        }

        public Criteria andLocalUrlLike(String value) {
            addCriterion("local_url like", value, "localUrl");
            return (Criteria) this;
        }

        public Criteria andLocalUrlNotLike(String value) {
            addCriterion("local_url not like", value, "localUrl");
            return (Criteria) this;
        }

        public Criteria andLocalUrlIn(List<String> values) {
            addCriterion("local_url in", values, "localUrl");
            return (Criteria) this;
        }

        public Criteria andLocalUrlNotIn(List<String> values) {
            addCriterion("local_url not in", values, "localUrl");
            return (Criteria) this;
        }

        public Criteria andLocalUrlBetween(String value1, String value2) {
            addCriterion("local_url between", value1, value2, "localUrl");
            return (Criteria) this;
        }

        public Criteria andLocalUrlNotBetween(String value1, String value2) {
            addCriterion("local_url not between", value1, value2, "localUrl");
            return (Criteria) this;
        }

        public Criteria andIllustrateIsNull() {
            addCriterion("illustrate is null");
            return (Criteria) this;
        }

        public Criteria andIllustrateIsNotNull() {
            addCriterion("illustrate is not null");
            return (Criteria) this;
        }

        public Criteria andIllustrateEqualTo(String value) {
            addCriterion("illustrate =", value, "illustrate");
            return (Criteria) this;
        }

        public Criteria andIllustrateNotEqualTo(String value) {
            addCriterion("illustrate <>", value, "illustrate");
            return (Criteria) this;
        }

        public Criteria andIllustrateGreaterThan(String value) {
            addCriterion("illustrate >", value, "illustrate");
            return (Criteria) this;
        }

        public Criteria andIllustrateGreaterThanOrEqualTo(String value) {
            addCriterion("illustrate >=", value, "illustrate");
            return (Criteria) this;
        }

        public Criteria andIllustrateLessThan(String value) {
            addCriterion("illustrate <", value, "illustrate");
            return (Criteria) this;
        }

        public Criteria andIllustrateLessThanOrEqualTo(String value) {
            addCriterion("illustrate <=", value, "illustrate");
            return (Criteria) this;
        }

        public Criteria andIllustrateLike(String value) {
            addCriterion("illustrate like", value, "illustrate");
            return (Criteria) this;
        }

        public Criteria andIllustrateNotLike(String value) {
            addCriterion("illustrate not like", value, "illustrate");
            return (Criteria) this;
        }

        public Criteria andIllustrateIn(List<String> values) {
            addCriterion("illustrate in", values, "illustrate");
            return (Criteria) this;
        }

        public Criteria andIllustrateNotIn(List<String> values) {
            addCriterion("illustrate not in", values, "illustrate");
            return (Criteria) this;
        }

        public Criteria andIllustrateBetween(String value1, String value2) {
            addCriterion("illustrate between", value1, value2, "illustrate");
            return (Criteria) this;
        }

        public Criteria andIllustrateNotBetween(String value1, String value2) {
            addCriterion("illustrate not between", value1, value2, "illustrate");
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
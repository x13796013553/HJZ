package com.xxx.webservice.pojo;

import java.util.ArrayList;
import java.util.List;

public class XMiddleNavExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XMiddleNavExample() {
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

        public Criteria andNavIdIsNull() {
            addCriterion("nav_id is null");
            return (Criteria) this;
        }

        public Criteria andNavIdIsNotNull() {
            addCriterion("nav_id is not null");
            return (Criteria) this;
        }

        public Criteria andNavIdEqualTo(Integer value) {
            addCriterion("nav_id =", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdNotEqualTo(Integer value) {
            addCriterion("nav_id <>", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdGreaterThan(Integer value) {
            addCriterion("nav_id >", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("nav_id >=", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdLessThan(Integer value) {
            addCriterion("nav_id <", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdLessThanOrEqualTo(Integer value) {
            addCriterion("nav_id <=", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdIn(List<Integer> values) {
            addCriterion("nav_id in", values, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdNotIn(List<Integer> values) {
            addCriterion("nav_id not in", values, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdBetween(Integer value1, Integer value2) {
            addCriterion("nav_id between", value1, value2, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdNotBetween(Integer value1, Integer value2) {
            addCriterion("nav_id not between", value1, value2, "navId");
            return (Criteria) this;
        }

        public Criteria andNavNameIsNull() {
            addCriterion("nav_name is null");
            return (Criteria) this;
        }

        public Criteria andNavNameIsNotNull() {
            addCriterion("nav_name is not null");
            return (Criteria) this;
        }

        public Criteria andNavNameEqualTo(String value) {
            addCriterion("nav_name =", value, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameNotEqualTo(String value) {
            addCriterion("nav_name <>", value, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameGreaterThan(String value) {
            addCriterion("nav_name >", value, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameGreaterThanOrEqualTo(String value) {
            addCriterion("nav_name >=", value, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameLessThan(String value) {
            addCriterion("nav_name <", value, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameLessThanOrEqualTo(String value) {
            addCriterion("nav_name <=", value, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameLike(String value) {
            addCriterion("nav_name like", value, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameNotLike(String value) {
            addCriterion("nav_name not like", value, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameIn(List<String> values) {
            addCriterion("nav_name in", values, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameNotIn(List<String> values) {
            addCriterion("nav_name not in", values, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameBetween(String value1, String value2) {
            addCriterion("nav_name between", value1, value2, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameNotBetween(String value1, String value2) {
            addCriterion("nav_name not between", value1, value2, "navName");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("img_url in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("img_url not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andNavUrlIsNull() {
            addCriterion("nav_url is null");
            return (Criteria) this;
        }

        public Criteria andNavUrlIsNotNull() {
            addCriterion("nav_url is not null");
            return (Criteria) this;
        }

        public Criteria andNavUrlEqualTo(String value) {
            addCriterion("nav_url =", value, "navUrl");
            return (Criteria) this;
        }

        public Criteria andNavUrlNotEqualTo(String value) {
            addCriterion("nav_url <>", value, "navUrl");
            return (Criteria) this;
        }

        public Criteria andNavUrlGreaterThan(String value) {
            addCriterion("nav_url >", value, "navUrl");
            return (Criteria) this;
        }

        public Criteria andNavUrlGreaterThanOrEqualTo(String value) {
            addCriterion("nav_url >=", value, "navUrl");
            return (Criteria) this;
        }

        public Criteria andNavUrlLessThan(String value) {
            addCriterion("nav_url <", value, "navUrl");
            return (Criteria) this;
        }

        public Criteria andNavUrlLessThanOrEqualTo(String value) {
            addCriterion("nav_url <=", value, "navUrl");
            return (Criteria) this;
        }

        public Criteria andNavUrlLike(String value) {
            addCriterion("nav_url like", value, "navUrl");
            return (Criteria) this;
        }

        public Criteria andNavUrlNotLike(String value) {
            addCriterion("nav_url not like", value, "navUrl");
            return (Criteria) this;
        }

        public Criteria andNavUrlIn(List<String> values) {
            addCriterion("nav_url in", values, "navUrl");
            return (Criteria) this;
        }

        public Criteria andNavUrlNotIn(List<String> values) {
            addCriterion("nav_url not in", values, "navUrl");
            return (Criteria) this;
        }

        public Criteria andNavUrlBetween(String value1, String value2) {
            addCriterion("nav_url between", value1, value2, "navUrl");
            return (Criteria) this;
        }

        public Criteria andNavUrlNotBetween(String value1, String value2) {
            addCriterion("nav_url not between", value1, value2, "navUrl");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andImgLocalUrlIsNull() {
            addCriterion("img_local_url is null");
            return (Criteria) this;
        }

        public Criteria andImgLocalUrlIsNotNull() {
            addCriterion("img_local_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgLocalUrlEqualTo(String value) {
            addCriterion("img_local_url =", value, "imgLocalUrl");
            return (Criteria) this;
        }

        public Criteria andImgLocalUrlNotEqualTo(String value) {
            addCriterion("img_local_url <>", value, "imgLocalUrl");
            return (Criteria) this;
        }

        public Criteria andImgLocalUrlGreaterThan(String value) {
            addCriterion("img_local_url >", value, "imgLocalUrl");
            return (Criteria) this;
        }

        public Criteria andImgLocalUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_local_url >=", value, "imgLocalUrl");
            return (Criteria) this;
        }

        public Criteria andImgLocalUrlLessThan(String value) {
            addCriterion("img_local_url <", value, "imgLocalUrl");
            return (Criteria) this;
        }

        public Criteria andImgLocalUrlLessThanOrEqualTo(String value) {
            addCriterion("img_local_url <=", value, "imgLocalUrl");
            return (Criteria) this;
        }

        public Criteria andImgLocalUrlLike(String value) {
            addCriterion("img_local_url like", value, "imgLocalUrl");
            return (Criteria) this;
        }

        public Criteria andImgLocalUrlNotLike(String value) {
            addCriterion("img_local_url not like", value, "imgLocalUrl");
            return (Criteria) this;
        }

        public Criteria andImgLocalUrlIn(List<String> values) {
            addCriterion("img_local_url in", values, "imgLocalUrl");
            return (Criteria) this;
        }

        public Criteria andImgLocalUrlNotIn(List<String> values) {
            addCriterion("img_local_url not in", values, "imgLocalUrl");
            return (Criteria) this;
        }

        public Criteria andImgLocalUrlBetween(String value1, String value2) {
            addCriterion("img_local_url between", value1, value2, "imgLocalUrl");
            return (Criteria) this;
        }

        public Criteria andImgLocalUrlNotBetween(String value1, String value2) {
            addCriterion("img_local_url not between", value1, value2, "imgLocalUrl");
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
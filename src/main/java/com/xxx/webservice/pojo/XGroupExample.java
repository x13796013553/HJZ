package com.xxx.webservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XGroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XGroupExample() {
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

    /**
     * 
     * 
     * @author wcyong
     * 
     * @date 2018-08-07
     */
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

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("group_id like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("group_id not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andSelectMenuIsNull() {
            addCriterion("select_menu is null");
            return (Criteria) this;
        }

        public Criteria andSelectMenuIsNotNull() {
            addCriterion("select_menu is not null");
            return (Criteria) this;
        }

        public Criteria andSelectMenuEqualTo(String value) {
            addCriterion("select_menu =", value, "selectMenu");
            return (Criteria) this;
        }

        public Criteria andSelectMenuNotEqualTo(String value) {
            addCriterion("select_menu <>", value, "selectMenu");
            return (Criteria) this;
        }

        public Criteria andSelectMenuGreaterThan(String value) {
            addCriterion("select_menu >", value, "selectMenu");
            return (Criteria) this;
        }

        public Criteria andSelectMenuGreaterThanOrEqualTo(String value) {
            addCriterion("select_menu >=", value, "selectMenu");
            return (Criteria) this;
        }

        public Criteria andSelectMenuLessThan(String value) {
            addCriterion("select_menu <", value, "selectMenu");
            return (Criteria) this;
        }

        public Criteria andSelectMenuLessThanOrEqualTo(String value) {
            addCriterion("select_menu <=", value, "selectMenu");
            return (Criteria) this;
        }

        public Criteria andSelectMenuLike(String value) {
            addCriterion("select_menu like", value, "selectMenu");
            return (Criteria) this;
        }

        public Criteria andSelectMenuNotLike(String value) {
            addCriterion("select_menu not like", value, "selectMenu");
            return (Criteria) this;
        }

        public Criteria andSelectMenuIn(List<String> values) {
            addCriterion("select_menu in", values, "selectMenu");
            return (Criteria) this;
        }

        public Criteria andSelectMenuNotIn(List<String> values) {
            addCriterion("select_menu not in", values, "selectMenu");
            return (Criteria) this;
        }

        public Criteria andSelectMenuBetween(String value1, String value2) {
            addCriterion("select_menu between", value1, value2, "selectMenu");
            return (Criteria) this;
        }

        public Criteria andSelectMenuNotBetween(String value1, String value2) {
            addCriterion("select_menu not between", value1, value2, "selectMenu");
            return (Criteria) this;
        }

        public Criteria andAddMenuIsNull() {
            addCriterion("add_menu is null");
            return (Criteria) this;
        }

        public Criteria andAddMenuIsNotNull() {
            addCriterion("add_menu is not null");
            return (Criteria) this;
        }

        public Criteria andAddMenuEqualTo(String value) {
            addCriterion("add_menu =", value, "addMenu");
            return (Criteria) this;
        }

        public Criteria andAddMenuNotEqualTo(String value) {
            addCriterion("add_menu <>", value, "addMenu");
            return (Criteria) this;
        }

        public Criteria andAddMenuGreaterThan(String value) {
            addCriterion("add_menu >", value, "addMenu");
            return (Criteria) this;
        }

        public Criteria andAddMenuGreaterThanOrEqualTo(String value) {
            addCriterion("add_menu >=", value, "addMenu");
            return (Criteria) this;
        }

        public Criteria andAddMenuLessThan(String value) {
            addCriterion("add_menu <", value, "addMenu");
            return (Criteria) this;
        }

        public Criteria andAddMenuLessThanOrEqualTo(String value) {
            addCriterion("add_menu <=", value, "addMenu");
            return (Criteria) this;
        }

        public Criteria andAddMenuLike(String value) {
            addCriterion("add_menu like", value, "addMenu");
            return (Criteria) this;
        }

        public Criteria andAddMenuNotLike(String value) {
            addCriterion("add_menu not like", value, "addMenu");
            return (Criteria) this;
        }

        public Criteria andAddMenuIn(List<String> values) {
            addCriterion("add_menu in", values, "addMenu");
            return (Criteria) this;
        }

        public Criteria andAddMenuNotIn(List<String> values) {
            addCriterion("add_menu not in", values, "addMenu");
            return (Criteria) this;
        }

        public Criteria andAddMenuBetween(String value1, String value2) {
            addCriterion("add_menu between", value1, value2, "addMenu");
            return (Criteria) this;
        }

        public Criteria andAddMenuNotBetween(String value1, String value2) {
            addCriterion("add_menu not between", value1, value2, "addMenu");
            return (Criteria) this;
        }

        public Criteria andDeleteMenuIsNull() {
            addCriterion("delete_menu is null");
            return (Criteria) this;
        }

        public Criteria andDeleteMenuIsNotNull() {
            addCriterion("delete_menu is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteMenuEqualTo(String value) {
            addCriterion("delete_menu =", value, "deleteMenu");
            return (Criteria) this;
        }

        public Criteria andDeleteMenuNotEqualTo(String value) {
            addCriterion("delete_menu <>", value, "deleteMenu");
            return (Criteria) this;
        }

        public Criteria andDeleteMenuGreaterThan(String value) {
            addCriterion("delete_menu >", value, "deleteMenu");
            return (Criteria) this;
        }

        public Criteria andDeleteMenuGreaterThanOrEqualTo(String value) {
            addCriterion("delete_menu >=", value, "deleteMenu");
            return (Criteria) this;
        }

        public Criteria andDeleteMenuLessThan(String value) {
            addCriterion("delete_menu <", value, "deleteMenu");
            return (Criteria) this;
        }

        public Criteria andDeleteMenuLessThanOrEqualTo(String value) {
            addCriterion("delete_menu <=", value, "deleteMenu");
            return (Criteria) this;
        }

        public Criteria andDeleteMenuLike(String value) {
            addCriterion("delete_menu like", value, "deleteMenu");
            return (Criteria) this;
        }

        public Criteria andDeleteMenuNotLike(String value) {
            addCriterion("delete_menu not like", value, "deleteMenu");
            return (Criteria) this;
        }

        public Criteria andDeleteMenuIn(List<String> values) {
            addCriterion("delete_menu in", values, "deleteMenu");
            return (Criteria) this;
        }

        public Criteria andDeleteMenuNotIn(List<String> values) {
            addCriterion("delete_menu not in", values, "deleteMenu");
            return (Criteria) this;
        }

        public Criteria andDeleteMenuBetween(String value1, String value2) {
            addCriterion("delete_menu between", value1, value2, "deleteMenu");
            return (Criteria) this;
        }

        public Criteria andDeleteMenuNotBetween(String value1, String value2) {
            addCriterion("delete_menu not between", value1, value2, "deleteMenu");
            return (Criteria) this;
        }

        public Criteria andUpdateMenuIsNull() {
            addCriterion("update_menu is null");
            return (Criteria) this;
        }

        public Criteria andUpdateMenuIsNotNull() {
            addCriterion("update_menu is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateMenuEqualTo(String value) {
            addCriterion("update_menu =", value, "updateMenu");
            return (Criteria) this;
        }

        public Criteria andUpdateMenuNotEqualTo(String value) {
            addCriterion("update_menu <>", value, "updateMenu");
            return (Criteria) this;
        }

        public Criteria andUpdateMenuGreaterThan(String value) {
            addCriterion("update_menu >", value, "updateMenu");
            return (Criteria) this;
        }

        public Criteria andUpdateMenuGreaterThanOrEqualTo(String value) {
            addCriterion("update_menu >=", value, "updateMenu");
            return (Criteria) this;
        }

        public Criteria andUpdateMenuLessThan(String value) {
            addCriterion("update_menu <", value, "updateMenu");
            return (Criteria) this;
        }

        public Criteria andUpdateMenuLessThanOrEqualTo(String value) {
            addCriterion("update_menu <=", value, "updateMenu");
            return (Criteria) this;
        }

        public Criteria andUpdateMenuLike(String value) {
            addCriterion("update_menu like", value, "updateMenu");
            return (Criteria) this;
        }

        public Criteria andUpdateMenuNotLike(String value) {
            addCriterion("update_menu not like", value, "updateMenu");
            return (Criteria) this;
        }

        public Criteria andUpdateMenuIn(List<String> values) {
            addCriterion("update_menu in", values, "updateMenu");
            return (Criteria) this;
        }

        public Criteria andUpdateMenuNotIn(List<String> values) {
            addCriterion("update_menu not in", values, "updateMenu");
            return (Criteria) this;
        }

        public Criteria andUpdateMenuBetween(String value1, String value2) {
            addCriterion("update_menu between", value1, value2, "updateMenu");
            return (Criteria) this;
        }

        public Criteria andUpdateMenuNotBetween(String value1, String value2) {
            addCriterion("update_menu not between", value1, value2, "updateMenu");
            return (Criteria) this;
        }

        public Criteria andSelectArticleIsNull() {
            addCriterion("select_article is null");
            return (Criteria) this;
        }

        public Criteria andSelectArticleIsNotNull() {
            addCriterion("select_article is not null");
            return (Criteria) this;
        }

        public Criteria andSelectArticleEqualTo(String value) {
            addCriterion("select_article =", value, "selectArticle");
            return (Criteria) this;
        }

        public Criteria andSelectArticleNotEqualTo(String value) {
            addCriterion("select_article <>", value, "selectArticle");
            return (Criteria) this;
        }

        public Criteria andSelectArticleGreaterThan(String value) {
            addCriterion("select_article >", value, "selectArticle");
            return (Criteria) this;
        }

        public Criteria andSelectArticleGreaterThanOrEqualTo(String value) {
            addCriterion("select_article >=", value, "selectArticle");
            return (Criteria) this;
        }

        public Criteria andSelectArticleLessThan(String value) {
            addCriterion("select_article <", value, "selectArticle");
            return (Criteria) this;
        }

        public Criteria andSelectArticleLessThanOrEqualTo(String value) {
            addCriterion("select_article <=", value, "selectArticle");
            return (Criteria) this;
        }

        public Criteria andSelectArticleLike(String value) {
            addCriterion("select_article like", value, "selectArticle");
            return (Criteria) this;
        }

        public Criteria andSelectArticleNotLike(String value) {
            addCriterion("select_article not like", value, "selectArticle");
            return (Criteria) this;
        }

        public Criteria andSelectArticleIn(List<String> values) {
            addCriterion("select_article in", values, "selectArticle");
            return (Criteria) this;
        }

        public Criteria andSelectArticleNotIn(List<String> values) {
            addCriterion("select_article not in", values, "selectArticle");
            return (Criteria) this;
        }

        public Criteria andSelectArticleBetween(String value1, String value2) {
            addCriterion("select_article between", value1, value2, "selectArticle");
            return (Criteria) this;
        }

        public Criteria andSelectArticleNotBetween(String value1, String value2) {
            addCriterion("select_article not between", value1, value2, "selectArticle");
            return (Criteria) this;
        }

        public Criteria andAddArticleIsNull() {
            addCriterion("add_article is null");
            return (Criteria) this;
        }

        public Criteria andAddArticleIsNotNull() {
            addCriterion("add_article is not null");
            return (Criteria) this;
        }

        public Criteria andAddArticleEqualTo(String value) {
            addCriterion("add_article =", value, "addArticle");
            return (Criteria) this;
        }

        public Criteria andAddArticleNotEqualTo(String value) {
            addCriterion("add_article <>", value, "addArticle");
            return (Criteria) this;
        }

        public Criteria andAddArticleGreaterThan(String value) {
            addCriterion("add_article >", value, "addArticle");
            return (Criteria) this;
        }

        public Criteria andAddArticleGreaterThanOrEqualTo(String value) {
            addCriterion("add_article >=", value, "addArticle");
            return (Criteria) this;
        }

        public Criteria andAddArticleLessThan(String value) {
            addCriterion("add_article <", value, "addArticle");
            return (Criteria) this;
        }

        public Criteria andAddArticleLessThanOrEqualTo(String value) {
            addCriterion("add_article <=", value, "addArticle");
            return (Criteria) this;
        }

        public Criteria andAddArticleLike(String value) {
            addCriterion("add_article like", value, "addArticle");
            return (Criteria) this;
        }

        public Criteria andAddArticleNotLike(String value) {
            addCriterion("add_article not like", value, "addArticle");
            return (Criteria) this;
        }

        public Criteria andAddArticleIn(List<String> values) {
            addCriterion("add_article in", values, "addArticle");
            return (Criteria) this;
        }

        public Criteria andAddArticleNotIn(List<String> values) {
            addCriterion("add_article not in", values, "addArticle");
            return (Criteria) this;
        }

        public Criteria andAddArticleBetween(String value1, String value2) {
            addCriterion("add_article between", value1, value2, "addArticle");
            return (Criteria) this;
        }

        public Criteria andAddArticleNotBetween(String value1, String value2) {
            addCriterion("add_article not between", value1, value2, "addArticle");
            return (Criteria) this;
        }

        public Criteria andDeleteArticleIsNull() {
            addCriterion("delete_article is null");
            return (Criteria) this;
        }

        public Criteria andDeleteArticleIsNotNull() {
            addCriterion("delete_article is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteArticleEqualTo(String value) {
            addCriterion("delete_article =", value, "deleteArticle");
            return (Criteria) this;
        }

        public Criteria andDeleteArticleNotEqualTo(String value) {
            addCriterion("delete_article <>", value, "deleteArticle");
            return (Criteria) this;
        }

        public Criteria andDeleteArticleGreaterThan(String value) {
            addCriterion("delete_article >", value, "deleteArticle");
            return (Criteria) this;
        }

        public Criteria andDeleteArticleGreaterThanOrEqualTo(String value) {
            addCriterion("delete_article >=", value, "deleteArticle");
            return (Criteria) this;
        }

        public Criteria andDeleteArticleLessThan(String value) {
            addCriterion("delete_article <", value, "deleteArticle");
            return (Criteria) this;
        }

        public Criteria andDeleteArticleLessThanOrEqualTo(String value) {
            addCriterion("delete_article <=", value, "deleteArticle");
            return (Criteria) this;
        }

        public Criteria andDeleteArticleLike(String value) {
            addCriterion("delete_article like", value, "deleteArticle");
            return (Criteria) this;
        }

        public Criteria andDeleteArticleNotLike(String value) {
            addCriterion("delete_article not like", value, "deleteArticle");
            return (Criteria) this;
        }

        public Criteria andDeleteArticleIn(List<String> values) {
            addCriterion("delete_article in", values, "deleteArticle");
            return (Criteria) this;
        }

        public Criteria andDeleteArticleNotIn(List<String> values) {
            addCriterion("delete_article not in", values, "deleteArticle");
            return (Criteria) this;
        }

        public Criteria andDeleteArticleBetween(String value1, String value2) {
            addCriterion("delete_article between", value1, value2, "deleteArticle");
            return (Criteria) this;
        }

        public Criteria andDeleteArticleNotBetween(String value1, String value2) {
            addCriterion("delete_article not between", value1, value2, "deleteArticle");
            return (Criteria) this;
        }

        public Criteria andUpdateArticleIsNull() {
            addCriterion("update_article is null");
            return (Criteria) this;
        }

        public Criteria andUpdateArticleIsNotNull() {
            addCriterion("update_article is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateArticleEqualTo(Date value) {
            addCriterion("update_article =", value, "updateArticle");
            return (Criteria) this;
        }

        public Criteria andUpdateArticleNotEqualTo(Date value) {
            addCriterion("update_article <>", value, "updateArticle");
            return (Criteria) this;
        }

        public Criteria andUpdateArticleGreaterThan(Date value) {
            addCriterion("update_article >", value, "updateArticle");
            return (Criteria) this;
        }

        public Criteria andUpdateArticleGreaterThanOrEqualTo(Date value) {
            addCriterion("update_article >=", value, "updateArticle");
            return (Criteria) this;
        }

        public Criteria andUpdateArticleLessThan(Date value) {
            addCriterion("update_article <", value, "updateArticle");
            return (Criteria) this;
        }

        public Criteria andUpdateArticleLessThanOrEqualTo(Date value) {
            addCriterion("update_article <=", value, "updateArticle");
            return (Criteria) this;
        }

        public Criteria andUpdateArticleIn(List<Date> values) {
            addCriterion("update_article in", values, "updateArticle");
            return (Criteria) this;
        }

        public Criteria andUpdateArticleNotIn(List<Date> values) {
            addCriterion("update_article not in", values, "updateArticle");
            return (Criteria) this;
        }

        public Criteria andUpdateArticleBetween(Date value1, Date value2) {
            addCriterion("update_article between", value1, value2, "updateArticle");
            return (Criteria) this;
        }

        public Criteria andUpdateArticleNotBetween(Date value1, Date value2) {
            addCriterion("update_article not between", value1, value2, "updateArticle");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 
     * 
     * @author wcyong
     * 
     * @date 2018-08-07
     */
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
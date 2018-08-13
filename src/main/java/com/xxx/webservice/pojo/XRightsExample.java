package com.xxx.webservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XRightsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XRightsExample() {
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

        public Criteria andRightsIdIsNull() {
            addCriterion("rights_id is null");
            return (Criteria) this;
        }

        public Criteria andRightsIdIsNotNull() {
            addCriterion("rights_id is not null");
            return (Criteria) this;
        }

        public Criteria andRightsIdEqualTo(Integer value) {
            addCriterion("rights_id =", value, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdNotEqualTo(Integer value) {
            addCriterion("rights_id <>", value, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdGreaterThan(Integer value) {
            addCriterion("rights_id >", value, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rights_id >=", value, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdLessThan(Integer value) {
            addCriterion("rights_id <", value, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdLessThanOrEqualTo(Integer value) {
            addCriterion("rights_id <=", value, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdIn(List<Integer> values) {
            addCriterion("rights_id in", values, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdNotIn(List<Integer> values) {
            addCriterion("rights_id not in", values, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdBetween(Integer value1, Integer value2) {
            addCriterion("rights_id between", value1, value2, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rights_id not between", value1, value2, "rightsId");
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

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(Integer value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(Integer value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(Integer value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(Integer value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<Integer> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<Integer> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andInsertRightsIsNull() {
            addCriterion("insert_rights is null");
            return (Criteria) this;
        }

        public Criteria andInsertRightsIsNotNull() {
            addCriterion("insert_rights is not null");
            return (Criteria) this;
        }

        public Criteria andInsertRightsEqualTo(Integer value) {
            addCriterion("insert_rights =", value, "insertRights");
            return (Criteria) this;
        }

        public Criteria andInsertRightsNotEqualTo(Integer value) {
            addCriterion("insert_rights <>", value, "insertRights");
            return (Criteria) this;
        }

        public Criteria andInsertRightsGreaterThan(Integer value) {
            addCriterion("insert_rights >", value, "insertRights");
            return (Criteria) this;
        }

        public Criteria andInsertRightsGreaterThanOrEqualTo(Integer value) {
            addCriterion("insert_rights >=", value, "insertRights");
            return (Criteria) this;
        }

        public Criteria andInsertRightsLessThan(Integer value) {
            addCriterion("insert_rights <", value, "insertRights");
            return (Criteria) this;
        }

        public Criteria andInsertRightsLessThanOrEqualTo(Integer value) {
            addCriterion("insert_rights <=", value, "insertRights");
            return (Criteria) this;
        }

        public Criteria andInsertRightsIn(List<Integer> values) {
            addCriterion("insert_rights in", values, "insertRights");
            return (Criteria) this;
        }

        public Criteria andInsertRightsNotIn(List<Integer> values) {
            addCriterion("insert_rights not in", values, "insertRights");
            return (Criteria) this;
        }

        public Criteria andInsertRightsBetween(Integer value1, Integer value2) {
            addCriterion("insert_rights between", value1, value2, "insertRights");
            return (Criteria) this;
        }

        public Criteria andInsertRightsNotBetween(Integer value1, Integer value2) {
            addCriterion("insert_rights not between", value1, value2, "insertRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsIsNull() {
            addCriterion("delete_rights is null");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsIsNotNull() {
            addCriterion("delete_rights is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsEqualTo(Integer value) {
            addCriterion("delete_rights =", value, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsNotEqualTo(Integer value) {
            addCriterion("delete_rights <>", value, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsGreaterThan(Integer value) {
            addCriterion("delete_rights >", value, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_rights >=", value, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsLessThan(Integer value) {
            addCriterion("delete_rights <", value, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsLessThanOrEqualTo(Integer value) {
            addCriterion("delete_rights <=", value, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsIn(List<Integer> values) {
            addCriterion("delete_rights in", values, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsNotIn(List<Integer> values) {
            addCriterion("delete_rights not in", values, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsBetween(Integer value1, Integer value2) {
            addCriterion("delete_rights between", value1, value2, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andDeleteRightsNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_rights not between", value1, value2, "deleteRights");
            return (Criteria) this;
        }

        public Criteria andUpdateRightsIsNull() {
            addCriterion("update_rights is null");
            return (Criteria) this;
        }

        public Criteria andUpdateRightsIsNotNull() {
            addCriterion("update_rights is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateRightsEqualTo(Integer value) {
            addCriterion("update_rights =", value, "updateRights");
            return (Criteria) this;
        }

        public Criteria andUpdateRightsNotEqualTo(Integer value) {
            addCriterion("update_rights <>", value, "updateRights");
            return (Criteria) this;
        }

        public Criteria andUpdateRightsGreaterThan(Integer value) {
            addCriterion("update_rights >", value, "updateRights");
            return (Criteria) this;
        }

        public Criteria andUpdateRightsGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_rights >=", value, "updateRights");
            return (Criteria) this;
        }

        public Criteria andUpdateRightsLessThan(Integer value) {
            addCriterion("update_rights <", value, "updateRights");
            return (Criteria) this;
        }

        public Criteria andUpdateRightsLessThanOrEqualTo(Integer value) {
            addCriterion("update_rights <=", value, "updateRights");
            return (Criteria) this;
        }

        public Criteria andUpdateRightsIn(List<Integer> values) {
            addCriterion("update_rights in", values, "updateRights");
            return (Criteria) this;
        }

        public Criteria andUpdateRightsNotIn(List<Integer> values) {
            addCriterion("update_rights not in", values, "updateRights");
            return (Criteria) this;
        }

        public Criteria andUpdateRightsBetween(Integer value1, Integer value2) {
            addCriterion("update_rights between", value1, value2, "updateRights");
            return (Criteria) this;
        }

        public Criteria andUpdateRightsNotBetween(Integer value1, Integer value2) {
            addCriterion("update_rights not between", value1, value2, "updateRights");
            return (Criteria) this;
        }

        public Criteria andSelectRightsIsNull() {
            addCriterion("select_rights is null");
            return (Criteria) this;
        }

        public Criteria andSelectRightsIsNotNull() {
            addCriterion("select_rights is not null");
            return (Criteria) this;
        }

        public Criteria andSelectRightsEqualTo(Integer value) {
            addCriterion("select_rights =", value, "selectRights");
            return (Criteria) this;
        }

        public Criteria andSelectRightsNotEqualTo(Integer value) {
            addCriterion("select_rights <>", value, "selectRights");
            return (Criteria) this;
        }

        public Criteria andSelectRightsGreaterThan(Integer value) {
            addCriterion("select_rights >", value, "selectRights");
            return (Criteria) this;
        }

        public Criteria andSelectRightsGreaterThanOrEqualTo(Integer value) {
            addCriterion("select_rights >=", value, "selectRights");
            return (Criteria) this;
        }

        public Criteria andSelectRightsLessThan(Integer value) {
            addCriterion("select_rights <", value, "selectRights");
            return (Criteria) this;
        }

        public Criteria andSelectRightsLessThanOrEqualTo(Integer value) {
            addCriterion("select_rights <=", value, "selectRights");
            return (Criteria) this;
        }

        public Criteria andSelectRightsIn(List<Integer> values) {
            addCriterion("select_rights in", values, "selectRights");
            return (Criteria) this;
        }

        public Criteria andSelectRightsNotIn(List<Integer> values) {
            addCriterion("select_rights not in", values, "selectRights");
            return (Criteria) this;
        }

        public Criteria andSelectRightsBetween(Integer value1, Integer value2) {
            addCriterion("select_rights between", value1, value2, "selectRights");
            return (Criteria) this;
        }

        public Criteria andSelectRightsNotBetween(Integer value1, Integer value2) {
            addCriterion("select_rights not between", value1, value2, "selectRights");
            return (Criteria) this;
        }

        public Criteria andLastChangeDatetimeIsNull() {
            addCriterion("last_change_datetime is null");
            return (Criteria) this;
        }

        public Criteria andLastChangeDatetimeIsNotNull() {
            addCriterion("last_change_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andLastChangeDatetimeEqualTo(Date value) {
            addCriterion("last_change_datetime =", value, "lastChangeDatetime");
            return (Criteria) this;
        }

        public Criteria andLastChangeDatetimeNotEqualTo(Date value) {
            addCriterion("last_change_datetime <>", value, "lastChangeDatetime");
            return (Criteria) this;
        }

        public Criteria andLastChangeDatetimeGreaterThan(Date value) {
            addCriterion("last_change_datetime >", value, "lastChangeDatetime");
            return (Criteria) this;
        }

        public Criteria andLastChangeDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_change_datetime >=", value, "lastChangeDatetime");
            return (Criteria) this;
        }

        public Criteria andLastChangeDatetimeLessThan(Date value) {
            addCriterion("last_change_datetime <", value, "lastChangeDatetime");
            return (Criteria) this;
        }

        public Criteria andLastChangeDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("last_change_datetime <=", value, "lastChangeDatetime");
            return (Criteria) this;
        }

        public Criteria andLastChangeDatetimeIn(List<Date> values) {
            addCriterion("last_change_datetime in", values, "lastChangeDatetime");
            return (Criteria) this;
        }

        public Criteria andLastChangeDatetimeNotIn(List<Date> values) {
            addCriterion("last_change_datetime not in", values, "lastChangeDatetime");
            return (Criteria) this;
        }

        public Criteria andLastChangeDatetimeBetween(Date value1, Date value2) {
            addCriterion("last_change_datetime between", value1, value2, "lastChangeDatetime");
            return (Criteria) this;
        }

        public Criteria andLastChangeDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("last_change_datetime not between", value1, value2, "lastChangeDatetime");
            return (Criteria) this;
        }

        public Criteria andLastOperateUseridIsNull() {
            addCriterion("last_operate_userid is null");
            return (Criteria) this;
        }

        public Criteria andLastOperateUseridIsNotNull() {
            addCriterion("last_operate_userid is not null");
            return (Criteria) this;
        }

        public Criteria andLastOperateUseridEqualTo(String value) {
            addCriterion("last_operate_userid =", value, "lastOperateUserid");
            return (Criteria) this;
        }

        public Criteria andLastOperateUseridNotEqualTo(String value) {
            addCriterion("last_operate_userid <>", value, "lastOperateUserid");
            return (Criteria) this;
        }

        public Criteria andLastOperateUseridGreaterThan(String value) {
            addCriterion("last_operate_userid >", value, "lastOperateUserid");
            return (Criteria) this;
        }

        public Criteria andLastOperateUseridGreaterThanOrEqualTo(String value) {
            addCriterion("last_operate_userid >=", value, "lastOperateUserid");
            return (Criteria) this;
        }

        public Criteria andLastOperateUseridLessThan(String value) {
            addCriterion("last_operate_userid <", value, "lastOperateUserid");
            return (Criteria) this;
        }

        public Criteria andLastOperateUseridLessThanOrEqualTo(String value) {
            addCriterion("last_operate_userid <=", value, "lastOperateUserid");
            return (Criteria) this;
        }

        public Criteria andLastOperateUseridLike(String value) {
            addCriterion("last_operate_userid like", value, "lastOperateUserid");
            return (Criteria) this;
        }

        public Criteria andLastOperateUseridNotLike(String value) {
            addCriterion("last_operate_userid not like", value, "lastOperateUserid");
            return (Criteria) this;
        }

        public Criteria andLastOperateUseridIn(List<String> values) {
            addCriterion("last_operate_userid in", values, "lastOperateUserid");
            return (Criteria) this;
        }

        public Criteria andLastOperateUseridNotIn(List<String> values) {
            addCriterion("last_operate_userid not in", values, "lastOperateUserid");
            return (Criteria) this;
        }

        public Criteria andLastOperateUseridBetween(String value1, String value2) {
            addCriterion("last_operate_userid between", value1, value2, "lastOperateUserid");
            return (Criteria) this;
        }

        public Criteria andLastOperateUseridNotBetween(String value1, String value2) {
            addCriterion("last_operate_userid not between", value1, value2, "lastOperateUserid");
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
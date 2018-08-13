package com.xxx.webservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XMessageExample() {
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
     * @date 2018-08-01
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

        public Criteria andMsgIdIsNull() {
            addCriterion("msg_id is null");
            return (Criteria) this;
        }

        public Criteria andMsgIdIsNotNull() {
            addCriterion("msg_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsgIdEqualTo(Integer value) {
            addCriterion("msg_id =", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotEqualTo(Integer value) {
            addCriterion("msg_id <>", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThan(Integer value) {
            addCriterion("msg_id >", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_id >=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThan(Integer value) {
            addCriterion("msg_id <", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThanOrEqualTo(Integer value) {
            addCriterion("msg_id <=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdIn(List<Integer> values) {
            addCriterion("msg_id in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotIn(List<Integer> values) {
            addCriterion("msg_id not in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdBetween(Integer value1, Integer value2) {
            addCriterion("msg_id between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_id not between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andMsgContentIsNull() {
            addCriterion("msg_content is null");
            return (Criteria) this;
        }

        public Criteria andMsgContentIsNotNull() {
            addCriterion("msg_content is not null");
            return (Criteria) this;
        }

        public Criteria andMsgContentEqualTo(String value) {
            addCriterion("msg_content =", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotEqualTo(String value) {
            addCriterion("msg_content <>", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentGreaterThan(String value) {
            addCriterion("msg_content >", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentGreaterThanOrEqualTo(String value) {
            addCriterion("msg_content >=", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLessThan(String value) {
            addCriterion("msg_content <", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLessThanOrEqualTo(String value) {
            addCriterion("msg_content <=", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLike(String value) {
            addCriterion("msg_content like", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotLike(String value) {
            addCriterion("msg_content not like", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentIn(List<String> values) {
            addCriterion("msg_content in", values, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotIn(List<String> values) {
            addCriterion("msg_content not in", values, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentBetween(String value1, String value2) {
            addCriterion("msg_content between", value1, value2, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotBetween(String value1, String value2) {
            addCriterion("msg_content not between", value1, value2, "msgContent");
            return (Criteria) this;
        }

        public Criteria andFileUrl1IsNull() {
            addCriterion("file_url1 is null");
            return (Criteria) this;
        }

        public Criteria andFileUrl1IsNotNull() {
            addCriterion("file_url1 is not null");
            return (Criteria) this;
        }

        public Criteria andFileUrl1EqualTo(String value) {
            addCriterion("file_url1 =", value, "fileUrl1");
            return (Criteria) this;
        }

        public Criteria andFileUrl1NotEqualTo(String value) {
            addCriterion("file_url1 <>", value, "fileUrl1");
            return (Criteria) this;
        }

        public Criteria andFileUrl1GreaterThan(String value) {
            addCriterion("file_url1 >", value, "fileUrl1");
            return (Criteria) this;
        }

        public Criteria andFileUrl1GreaterThanOrEqualTo(String value) {
            addCriterion("file_url1 >=", value, "fileUrl1");
            return (Criteria) this;
        }

        public Criteria andFileUrl1LessThan(String value) {
            addCriterion("file_url1 <", value, "fileUrl1");
            return (Criteria) this;
        }

        public Criteria andFileUrl1LessThanOrEqualTo(String value) {
            addCriterion("file_url1 <=", value, "fileUrl1");
            return (Criteria) this;
        }

        public Criteria andFileUrl1Like(String value) {
            addCriterion("file_url1 like", value, "fileUrl1");
            return (Criteria) this;
        }

        public Criteria andFileUrl1NotLike(String value) {
            addCriterion("file_url1 not like", value, "fileUrl1");
            return (Criteria) this;
        }

        public Criteria andFileUrl1In(List<String> values) {
            addCriterion("file_url1 in", values, "fileUrl1");
            return (Criteria) this;
        }

        public Criteria andFileUrl1NotIn(List<String> values) {
            addCriterion("file_url1 not in", values, "fileUrl1");
            return (Criteria) this;
        }

        public Criteria andFileUrl1Between(String value1, String value2) {
            addCriterion("file_url1 between", value1, value2, "fileUrl1");
            return (Criteria) this;
        }

        public Criteria andFileUrl1NotBetween(String value1, String value2) {
            addCriterion("file_url1 not between", value1, value2, "fileUrl1");
            return (Criteria) this;
        }

        public Criteria andFileUrl2IsNull() {
            addCriterion("file_url2 is null");
            return (Criteria) this;
        }

        public Criteria andFileUrl2IsNotNull() {
            addCriterion("file_url2 is not null");
            return (Criteria) this;
        }

        public Criteria andFileUrl2EqualTo(String value) {
            addCriterion("file_url2 =", value, "fileUrl2");
            return (Criteria) this;
        }

        public Criteria andFileUrl2NotEqualTo(String value) {
            addCriterion("file_url2 <>", value, "fileUrl2");
            return (Criteria) this;
        }

        public Criteria andFileUrl2GreaterThan(String value) {
            addCriterion("file_url2 >", value, "fileUrl2");
            return (Criteria) this;
        }

        public Criteria andFileUrl2GreaterThanOrEqualTo(String value) {
            addCriterion("file_url2 >=", value, "fileUrl2");
            return (Criteria) this;
        }

        public Criteria andFileUrl2LessThan(String value) {
            addCriterion("file_url2 <", value, "fileUrl2");
            return (Criteria) this;
        }

        public Criteria andFileUrl2LessThanOrEqualTo(String value) {
            addCriterion("file_url2 <=", value, "fileUrl2");
            return (Criteria) this;
        }

        public Criteria andFileUrl2Like(String value) {
            addCriterion("file_url2 like", value, "fileUrl2");
            return (Criteria) this;
        }

        public Criteria andFileUrl2NotLike(String value) {
            addCriterion("file_url2 not like", value, "fileUrl2");
            return (Criteria) this;
        }

        public Criteria andFileUrl2In(List<String> values) {
            addCriterion("file_url2 in", values, "fileUrl2");
            return (Criteria) this;
        }

        public Criteria andFileUrl2NotIn(List<String> values) {
            addCriterion("file_url2 not in", values, "fileUrl2");
            return (Criteria) this;
        }

        public Criteria andFileUrl2Between(String value1, String value2) {
            addCriterion("file_url2 between", value1, value2, "fileUrl2");
            return (Criteria) this;
        }

        public Criteria andFileUrl2NotBetween(String value1, String value2) {
            addCriterion("file_url2 not between", value1, value2, "fileUrl2");
            return (Criteria) this;
        }

        public Criteria andMsgDatetimeIsNull() {
            addCriterion("msg_datetime is null");
            return (Criteria) this;
        }

        public Criteria andMsgDatetimeIsNotNull() {
            addCriterion("msg_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andMsgDatetimeEqualTo(Date value) {
            addCriterion("msg_datetime =", value, "msgDatetime");
            return (Criteria) this;
        }

        public Criteria andMsgDatetimeNotEqualTo(Date value) {
            addCriterion("msg_datetime <>", value, "msgDatetime");
            return (Criteria) this;
        }

        public Criteria andMsgDatetimeGreaterThan(Date value) {
            addCriterion("msg_datetime >", value, "msgDatetime");
            return (Criteria) this;
        }

        public Criteria andMsgDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("msg_datetime >=", value, "msgDatetime");
            return (Criteria) this;
        }

        public Criteria andMsgDatetimeLessThan(Date value) {
            addCriterion("msg_datetime <", value, "msgDatetime");
            return (Criteria) this;
        }

        public Criteria andMsgDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("msg_datetime <=", value, "msgDatetime");
            return (Criteria) this;
        }

        public Criteria andMsgDatetimeIn(List<Date> values) {
            addCriterion("msg_datetime in", values, "msgDatetime");
            return (Criteria) this;
        }

        public Criteria andMsgDatetimeNotIn(List<Date> values) {
            addCriterion("msg_datetime not in", values, "msgDatetime");
            return (Criteria) this;
        }

        public Criteria andMsgDatetimeBetween(Date value1, Date value2) {
            addCriterion("msg_datetime between", value1, value2, "msgDatetime");
            return (Criteria) this;
        }

        public Criteria andMsgDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("msg_datetime not between", value1, value2, "msgDatetime");
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

        public Criteria andSendUserIsNull() {
            addCriterion("send_user is null");
            return (Criteria) this;
        }

        public Criteria andSendUserIsNotNull() {
            addCriterion("send_user is not null");
            return (Criteria) this;
        }

        public Criteria andSendUserEqualTo(String value) {
            addCriterion("send_user =", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserNotEqualTo(String value) {
            addCriterion("send_user <>", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserGreaterThan(String value) {
            addCriterion("send_user >", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserGreaterThanOrEqualTo(String value) {
            addCriterion("send_user >=", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserLessThan(String value) {
            addCriterion("send_user <", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserLessThanOrEqualTo(String value) {
            addCriterion("send_user <=", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserLike(String value) {
            addCriterion("send_user like", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserNotLike(String value) {
            addCriterion("send_user not like", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserIn(List<String> values) {
            addCriterion("send_user in", values, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserNotIn(List<String> values) {
            addCriterion("send_user not in", values, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserBetween(String value1, String value2) {
            addCriterion("send_user between", value1, value2, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserNotBetween(String value1, String value2) {
            addCriterion("send_user not between", value1, value2, "sendUser");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNull() {
            addCriterion("is_read is null");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNotNull() {
            addCriterion("is_read is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadEqualTo(Integer value) {
            addCriterion("is_read =", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotEqualTo(Integer value) {
            addCriterion("is_read <>", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThan(Integer value) {
            addCriterion("is_read >", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_read >=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThan(Integer value) {
            addCriterion("is_read <", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThanOrEqualTo(Integer value) {
            addCriterion("is_read <=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadIn(List<Integer> values) {
            addCriterion("is_read in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotIn(List<Integer> values) {
            addCriterion("is_read not in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadBetween(Integer value1, Integer value2) {
            addCriterion("is_read between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotBetween(Integer value1, Integer value2) {
            addCriterion("is_read not between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsPassIsNull() {
            addCriterion("is_pass is null");
            return (Criteria) this;
        }

        public Criteria andIsPassIsNotNull() {
            addCriterion("is_pass is not null");
            return (Criteria) this;
        }

        public Criteria andIsPassEqualTo(Integer value) {
            addCriterion("is_pass =", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotEqualTo(Integer value) {
            addCriterion("is_pass <>", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassGreaterThan(Integer value) {
            addCriterion("is_pass >", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_pass >=", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassLessThan(Integer value) {
            addCriterion("is_pass <", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassLessThanOrEqualTo(Integer value) {
            addCriterion("is_pass <=", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassIn(List<Integer> values) {
            addCriterion("is_pass in", values, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotIn(List<Integer> values) {
            addCriterion("is_pass not in", values, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassBetween(Integer value1, Integer value2) {
            addCriterion("is_pass between", value1, value2, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotBetween(Integer value1, Integer value2) {
            addCriterion("is_pass not between", value1, value2, "isPass");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSendUserHeadurlIsNull() {
            addCriterion("send_user_headUrl is null");
            return (Criteria) this;
        }

        public Criteria andSendUserHeadurlIsNotNull() {
            addCriterion("send_user_headUrl is not null");
            return (Criteria) this;
        }

        public Criteria andSendUserHeadurlEqualTo(String value) {
            addCriterion("send_user_headUrl =", value, "sendUserHeadurl");
            return (Criteria) this;
        }

        public Criteria andSendUserHeadurlNotEqualTo(String value) {
            addCriterion("send_user_headUrl <>", value, "sendUserHeadurl");
            return (Criteria) this;
        }

        public Criteria andSendUserHeadurlGreaterThan(String value) {
            addCriterion("send_user_headUrl >", value, "sendUserHeadurl");
            return (Criteria) this;
        }

        public Criteria andSendUserHeadurlGreaterThanOrEqualTo(String value) {
            addCriterion("send_user_headUrl >=", value, "sendUserHeadurl");
            return (Criteria) this;
        }

        public Criteria andSendUserHeadurlLessThan(String value) {
            addCriterion("send_user_headUrl <", value, "sendUserHeadurl");
            return (Criteria) this;
        }

        public Criteria andSendUserHeadurlLessThanOrEqualTo(String value) {
            addCriterion("send_user_headUrl <=", value, "sendUserHeadurl");
            return (Criteria) this;
        }

        public Criteria andSendUserHeadurlLike(String value) {
            addCriterion("send_user_headUrl like", value, "sendUserHeadurl");
            return (Criteria) this;
        }

        public Criteria andSendUserHeadurlNotLike(String value) {
            addCriterion("send_user_headUrl not like", value, "sendUserHeadurl");
            return (Criteria) this;
        }

        public Criteria andSendUserHeadurlIn(List<String> values) {
            addCriterion("send_user_headUrl in", values, "sendUserHeadurl");
            return (Criteria) this;
        }

        public Criteria andSendUserHeadurlNotIn(List<String> values) {
            addCriterion("send_user_headUrl not in", values, "sendUserHeadurl");
            return (Criteria) this;
        }

        public Criteria andSendUserHeadurlBetween(String value1, String value2) {
            addCriterion("send_user_headUrl between", value1, value2, "sendUserHeadurl");
            return (Criteria) this;
        }

        public Criteria andSendUserHeadurlNotBetween(String value1, String value2) {
            addCriterion("send_user_headUrl not between", value1, value2, "sendUserHeadurl");
            return (Criteria) this;
        }

        public Criteria andSendUserPicnameIsNull() {
            addCriterion("send_user_picName is null");
            return (Criteria) this;
        }

        public Criteria andSendUserPicnameIsNotNull() {
            addCriterion("send_user_picName is not null");
            return (Criteria) this;
        }

        public Criteria andSendUserPicnameEqualTo(String value) {
            addCriterion("send_user_picName =", value, "sendUserPicname");
            return (Criteria) this;
        }

        public Criteria andSendUserPicnameNotEqualTo(String value) {
            addCriterion("send_user_picName <>", value, "sendUserPicname");
            return (Criteria) this;
        }

        public Criteria andSendUserPicnameGreaterThan(String value) {
            addCriterion("send_user_picName >", value, "sendUserPicname");
            return (Criteria) this;
        }

        public Criteria andSendUserPicnameGreaterThanOrEqualTo(String value) {
            addCriterion("send_user_picName >=", value, "sendUserPicname");
            return (Criteria) this;
        }

        public Criteria andSendUserPicnameLessThan(String value) {
            addCriterion("send_user_picName <", value, "sendUserPicname");
            return (Criteria) this;
        }

        public Criteria andSendUserPicnameLessThanOrEqualTo(String value) {
            addCriterion("send_user_picName <=", value, "sendUserPicname");
            return (Criteria) this;
        }

        public Criteria andSendUserPicnameLike(String value) {
            addCriterion("send_user_picName like", value, "sendUserPicname");
            return (Criteria) this;
        }

        public Criteria andSendUserPicnameNotLike(String value) {
            addCriterion("send_user_picName not like", value, "sendUserPicname");
            return (Criteria) this;
        }

        public Criteria andSendUserPicnameIn(List<String> values) {
            addCriterion("send_user_picName in", values, "sendUserPicname");
            return (Criteria) this;
        }

        public Criteria andSendUserPicnameNotIn(List<String> values) {
            addCriterion("send_user_picName not in", values, "sendUserPicname");
            return (Criteria) this;
        }

        public Criteria andSendUserPicnameBetween(String value1, String value2) {
            addCriterion("send_user_picName between", value1, value2, "sendUserPicname");
            return (Criteria) this;
        }

        public Criteria andSendUserPicnameNotBetween(String value1, String value2) {
            addCriterion("send_user_picName not between", value1, value2, "sendUserPicname");
            return (Criteria) this;
        }

        public Criteria andReplyContentIsNull() {
            addCriterion("reply_content is null");
            return (Criteria) this;
        }

        public Criteria andReplyContentIsNotNull() {
            addCriterion("reply_content is not null");
            return (Criteria) this;
        }

        public Criteria andReplyContentEqualTo(String value) {
            addCriterion("reply_content =", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotEqualTo(String value) {
            addCriterion("reply_content <>", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentGreaterThan(String value) {
            addCriterion("reply_content >", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentGreaterThanOrEqualTo(String value) {
            addCriterion("reply_content >=", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLessThan(String value) {
            addCriterion("reply_content <", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLessThanOrEqualTo(String value) {
            addCriterion("reply_content <=", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLike(String value) {
            addCriterion("reply_content like", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotLike(String value) {
            addCriterion("reply_content not like", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentIn(List<String> values) {
            addCriterion("reply_content in", values, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotIn(List<String> values) {
            addCriterion("reply_content not in", values, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentBetween(String value1, String value2) {
            addCriterion("reply_content between", value1, value2, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotBetween(String value1, String value2) {
            addCriterion("reply_content not between", value1, value2, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeIsNull() {
            addCriterion("reply_datetime is null");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeIsNotNull() {
            addCriterion("reply_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeEqualTo(Date value) {
            addCriterion("reply_datetime =", value, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeNotEqualTo(Date value) {
            addCriterion("reply_datetime <>", value, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeGreaterThan(Date value) {
            addCriterion("reply_datetime >", value, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reply_datetime >=", value, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeLessThan(Date value) {
            addCriterion("reply_datetime <", value, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("reply_datetime <=", value, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeIn(List<Date> values) {
            addCriterion("reply_datetime in", values, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeNotIn(List<Date> values) {
            addCriterion("reply_datetime not in", values, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeBetween(Date value1, Date value2) {
            addCriterion("reply_datetime between", value1, value2, "replyDatetime");
            return (Criteria) this;
        }

        public Criteria andReplyDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("reply_datetime not between", value1, value2, "replyDatetime");
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
     * @date 2018-08-01
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
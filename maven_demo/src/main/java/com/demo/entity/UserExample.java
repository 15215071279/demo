package com.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("appid is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appid is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("appid =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("appid <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("appid >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("appid >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("appid <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("appid <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("appid like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("appid not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("appid in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("appid not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("appid between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("appid not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andGroupidIsNull() {
            addCriterion("groupid is null");
            return (Criteria) this;
        }

        public Criteria andGroupidIsNotNull() {
            addCriterion("groupid is not null");
            return (Criteria) this;
        }

        public Criteria andGroupidEqualTo(Long value) {
            addCriterion("groupid =", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotEqualTo(Long value) {
            addCriterion("groupid <>", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThan(Long value) {
            addCriterion("groupid >", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThanOrEqualTo(Long value) {
            addCriterion("groupid >=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThan(Long value) {
            addCriterion("groupid <", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThanOrEqualTo(Long value) {
            addCriterion("groupid <=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidIn(List<Long> values) {
            addCriterion("groupid in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotIn(List<Long> values) {
            addCriterion("groupid not in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidBetween(Long value1, Long value2) {
            addCriterion("groupid between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotBetween(Long value1, Long value2) {
            addCriterion("groupid not between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNull() {
            addCriterion("roleid is null");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNotNull() {
            addCriterion("roleid is not null");
            return (Criteria) this;
        }

        public Criteria andRoleidEqualTo(Long value) {
            addCriterion("roleid =", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotEqualTo(Long value) {
            addCriterion("roleid <>", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThan(Long value) {
            addCriterion("roleid >", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThanOrEqualTo(Long value) {
            addCriterion("roleid >=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThan(Long value) {
            addCriterion("roleid <", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThanOrEqualTo(Long value) {
            addCriterion("roleid <=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidIn(List<Long> values) {
            addCriterion("roleid in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotIn(List<Long> values) {
            addCriterion("roleid not in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidBetween(Long value1, Long value2) {
            addCriterion("roleid between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotBetween(Long value1, Long value2) {
            addCriterion("roleid not between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openid is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openid is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openid =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openid <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openid >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openid >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openid <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openid <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openid like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openid not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openid in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openid not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openid between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openid not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andMsisdnIsNull() {
            addCriterion("msisdn is null");
            return (Criteria) this;
        }

        public Criteria andMsisdnIsNotNull() {
            addCriterion("msisdn is not null");
            return (Criteria) this;
        }

        public Criteria andMsisdnEqualTo(String value) {
            addCriterion("msisdn =", value, "msisdn");
            return (Criteria) this;
        }

        public Criteria andMsisdnNotEqualTo(String value) {
            addCriterion("msisdn <>", value, "msisdn");
            return (Criteria) this;
        }

        public Criteria andMsisdnGreaterThan(String value) {
            addCriterion("msisdn >", value, "msisdn");
            return (Criteria) this;
        }

        public Criteria andMsisdnGreaterThanOrEqualTo(String value) {
            addCriterion("msisdn >=", value, "msisdn");
            return (Criteria) this;
        }

        public Criteria andMsisdnLessThan(String value) {
            addCriterion("msisdn <", value, "msisdn");
            return (Criteria) this;
        }

        public Criteria andMsisdnLessThanOrEqualTo(String value) {
            addCriterion("msisdn <=", value, "msisdn");
            return (Criteria) this;
        }

        public Criteria andMsisdnLike(String value) {
            addCriterion("msisdn like", value, "msisdn");
            return (Criteria) this;
        }

        public Criteria andMsisdnNotLike(String value) {
            addCriterion("msisdn not like", value, "msisdn");
            return (Criteria) this;
        }

        public Criteria andMsisdnIn(List<String> values) {
            addCriterion("msisdn in", values, "msisdn");
            return (Criteria) this;
        }

        public Criteria andMsisdnNotIn(List<String> values) {
            addCriterion("msisdn not in", values, "msisdn");
            return (Criteria) this;
        }

        public Criteria andMsisdnBetween(String value1, String value2) {
            addCriterion("msisdn between", value1, value2, "msisdn");
            return (Criteria) this;
        }

        public Criteria andMsisdnNotBetween(String value1, String value2) {
            addCriterion("msisdn not between", value1, value2, "msisdn");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPwdIsNull() {
            addCriterion("pwd is null");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("pwd =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("pwd <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("pwd >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pwd >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("pwd <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("pwd <=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLike(String value) {
            addCriterion("pwd like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("pwd not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdIn(List<String> values) {
            addCriterion("pwd in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("pwd not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("pwd between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("pwd not between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andSexsIsNull() {
            addCriterion("sexs is null");
            return (Criteria) this;
        }

        public Criteria andSexsIsNotNull() {
            addCriterion("sexs is not null");
            return (Criteria) this;
        }

        public Criteria andSexsEqualTo(String value) {
            addCriterion("sexs =", value, "sexs");
            return (Criteria) this;
        }

        public Criteria andSexsNotEqualTo(String value) {
            addCriterion("sexs <>", value, "sexs");
            return (Criteria) this;
        }

        public Criteria andSexsGreaterThan(String value) {
            addCriterion("sexs >", value, "sexs");
            return (Criteria) this;
        }

        public Criteria andSexsGreaterThanOrEqualTo(String value) {
            addCriterion("sexs >=", value, "sexs");
            return (Criteria) this;
        }

        public Criteria andSexsLessThan(String value) {
            addCriterion("sexs <", value, "sexs");
            return (Criteria) this;
        }

        public Criteria andSexsLessThanOrEqualTo(String value) {
            addCriterion("sexs <=", value, "sexs");
            return (Criteria) this;
        }

        public Criteria andSexsLike(String value) {
            addCriterion("sexs like", value, "sexs");
            return (Criteria) this;
        }

        public Criteria andSexsNotLike(String value) {
            addCriterion("sexs not like", value, "sexs");
            return (Criteria) this;
        }

        public Criteria andSexsIn(List<String> values) {
            addCriterion("sexs in", values, "sexs");
            return (Criteria) this;
        }

        public Criteria andSexsNotIn(List<String> values) {
            addCriterion("sexs not in", values, "sexs");
            return (Criteria) this;
        }

        public Criteria andSexsBetween(String value1, String value2) {
            addCriterion("sexs between", value1, value2, "sexs");
            return (Criteria) this;
        }

        public Criteria andSexsNotBetween(String value1, String value2) {
            addCriterion("sexs not between", value1, value2, "sexs");
            return (Criteria) this;
        }

        public Criteria andRaddressIsNull() {
            addCriterion("raddress is null");
            return (Criteria) this;
        }

        public Criteria andRaddressIsNotNull() {
            addCriterion("raddress is not null");
            return (Criteria) this;
        }

        public Criteria andRaddressEqualTo(String value) {
            addCriterion("raddress =", value, "raddress");
            return (Criteria) this;
        }

        public Criteria andRaddressNotEqualTo(String value) {
            addCriterion("raddress <>", value, "raddress");
            return (Criteria) this;
        }

        public Criteria andRaddressGreaterThan(String value) {
            addCriterion("raddress >", value, "raddress");
            return (Criteria) this;
        }

        public Criteria andRaddressGreaterThanOrEqualTo(String value) {
            addCriterion("raddress >=", value, "raddress");
            return (Criteria) this;
        }

        public Criteria andRaddressLessThan(String value) {
            addCriterion("raddress <", value, "raddress");
            return (Criteria) this;
        }

        public Criteria andRaddressLessThanOrEqualTo(String value) {
            addCriterion("raddress <=", value, "raddress");
            return (Criteria) this;
        }

        public Criteria andRaddressLike(String value) {
            addCriterion("raddress like", value, "raddress");
            return (Criteria) this;
        }

        public Criteria andRaddressNotLike(String value) {
            addCriterion("raddress not like", value, "raddress");
            return (Criteria) this;
        }

        public Criteria andRaddressIn(List<String> values) {
            addCriterion("raddress in", values, "raddress");
            return (Criteria) this;
        }

        public Criteria andRaddressNotIn(List<String> values) {
            addCriterion("raddress not in", values, "raddress");
            return (Criteria) this;
        }

        public Criteria andRaddressBetween(String value1, String value2) {
            addCriterion("raddress between", value1, value2, "raddress");
            return (Criteria) this;
        }

        public Criteria andRaddressNotBetween(String value1, String value2) {
            addCriterion("raddress not between", value1, value2, "raddress");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNull() {
            addCriterion("idcard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("idcard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("idcard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("idcard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("idcard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("idcard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("idcard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("idcard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("idcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("idcard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("idcard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("idcard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("idcard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("idcard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andCardnumIsNull() {
            addCriterion("cardnum is null");
            return (Criteria) this;
        }

        public Criteria andCardnumIsNotNull() {
            addCriterion("cardnum is not null");
            return (Criteria) this;
        }

        public Criteria andCardnumEqualTo(String value) {
            addCriterion("cardnum =", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotEqualTo(String value) {
            addCriterion("cardnum <>", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumGreaterThan(String value) {
            addCriterion("cardnum >", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumGreaterThanOrEqualTo(String value) {
            addCriterion("cardnum >=", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumLessThan(String value) {
            addCriterion("cardnum <", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumLessThanOrEqualTo(String value) {
            addCriterion("cardnum <=", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumLike(String value) {
            addCriterion("cardnum like", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotLike(String value) {
            addCriterion("cardnum not like", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumIn(List<String> values) {
            addCriterion("cardnum in", values, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotIn(List<String> values) {
            addCriterion("cardnum not in", values, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumBetween(String value1, String value2) {
            addCriterion("cardnum between", value1, value2, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotBetween(String value1, String value2) {
            addCriterion("cardnum not between", value1, value2, "cardnum");
            return (Criteria) this;
        }

        public Criteria andEtimeIsNull() {
            addCriterion("etime is null");
            return (Criteria) this;
        }

        public Criteria andEtimeIsNotNull() {
            addCriterion("etime is not null");
            return (Criteria) this;
        }

        public Criteria andEtimeEqualTo(Date value) {
            addCriterion("etime =", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotEqualTo(Date value) {
            addCriterion("etime <>", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeGreaterThan(Date value) {
            addCriterion("etime >", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("etime >=", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeLessThan(Date value) {
            addCriterion("etime <", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeLessThanOrEqualTo(Date value) {
            addCriterion("etime <=", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeIn(List<Date> values) {
            addCriterion("etime in", values, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotIn(List<Date> values) {
            addCriterion("etime not in", values, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeBetween(Date value1, Date value2) {
            addCriterion("etime between", value1, value2, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotBetween(Date value1, Date value2) {
            addCriterion("etime not between", value1, value2, "etime");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andStIsNull() {
            addCriterion("st is null");
            return (Criteria) this;
        }

        public Criteria andStIsNotNull() {
            addCriterion("st is not null");
            return (Criteria) this;
        }

        public Criteria andStEqualTo(Integer value) {
            addCriterion("st =", value, "st");
            return (Criteria) this;
        }

        public Criteria andStNotEqualTo(Integer value) {
            addCriterion("st <>", value, "st");
            return (Criteria) this;
        }

        public Criteria andStGreaterThan(Integer value) {
            addCriterion("st >", value, "st");
            return (Criteria) this;
        }

        public Criteria andStGreaterThanOrEqualTo(Integer value) {
            addCriterion("st >=", value, "st");
            return (Criteria) this;
        }

        public Criteria andStLessThan(Integer value) {
            addCriterion("st <", value, "st");
            return (Criteria) this;
        }

        public Criteria andStLessThanOrEqualTo(Integer value) {
            addCriterion("st <=", value, "st");
            return (Criteria) this;
        }

        public Criteria andStIn(List<Integer> values) {
            addCriterion("st in", values, "st");
            return (Criteria) this;
        }

        public Criteria andStNotIn(List<Integer> values) {
            addCriterion("st not in", values, "st");
            return (Criteria) this;
        }

        public Criteria andStBetween(Integer value1, Integer value2) {
            addCriterion("st between", value1, value2, "st");
            return (Criteria) this;
        }

        public Criteria andStNotBetween(Integer value1, Integer value2) {
            addCriterion("st not between", value1, value2, "st");
            return (Criteria) this;
        }

        public Criteria andChanneltypeIsNull() {
            addCriterion("channeltype is null");
            return (Criteria) this;
        }

        public Criteria andChanneltypeIsNotNull() {
            addCriterion("channeltype is not null");
            return (Criteria) this;
        }

        public Criteria andChanneltypeEqualTo(Integer value) {
            addCriterion("channeltype =", value, "channeltype");
            return (Criteria) this;
        }

        public Criteria andChanneltypeNotEqualTo(Integer value) {
            addCriterion("channeltype <>", value, "channeltype");
            return (Criteria) this;
        }

        public Criteria andChanneltypeGreaterThan(Integer value) {
            addCriterion("channeltype >", value, "channeltype");
            return (Criteria) this;
        }

        public Criteria andChanneltypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("channeltype >=", value, "channeltype");
            return (Criteria) this;
        }

        public Criteria andChanneltypeLessThan(Integer value) {
            addCriterion("channeltype <", value, "channeltype");
            return (Criteria) this;
        }

        public Criteria andChanneltypeLessThanOrEqualTo(Integer value) {
            addCriterion("channeltype <=", value, "channeltype");
            return (Criteria) this;
        }

        public Criteria andChanneltypeIn(List<Integer> values) {
            addCriterion("channeltype in", values, "channeltype");
            return (Criteria) this;
        }

        public Criteria andChanneltypeNotIn(List<Integer> values) {
            addCriterion("channeltype not in", values, "channeltype");
            return (Criteria) this;
        }

        public Criteria andChanneltypeBetween(Integer value1, Integer value2) {
            addCriterion("channeltype between", value1, value2, "channeltype");
            return (Criteria) this;
        }

        public Criteria andChanneltypeNotBetween(Integer value1, Integer value2) {
            addCriterion("channeltype not between", value1, value2, "channeltype");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Long value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Long value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Long value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Long value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Long> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Long> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andRcodeIsNull() {
            addCriterion("rcode is null");
            return (Criteria) this;
        }

        public Criteria andRcodeIsNotNull() {
            addCriterion("rcode is not null");
            return (Criteria) this;
        }

        public Criteria andRcodeEqualTo(String value) {
            addCriterion("rcode =", value, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeNotEqualTo(String value) {
            addCriterion("rcode <>", value, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeGreaterThan(String value) {
            addCriterion("rcode >", value, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeGreaterThanOrEqualTo(String value) {
            addCriterion("rcode >=", value, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeLessThan(String value) {
            addCriterion("rcode <", value, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeLessThanOrEqualTo(String value) {
            addCriterion("rcode <=", value, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeLike(String value) {
            addCriterion("rcode like", value, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeNotLike(String value) {
            addCriterion("rcode not like", value, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeIn(List<String> values) {
            addCriterion("rcode in", values, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeNotIn(List<String> values) {
            addCriterion("rcode not in", values, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeBetween(String value1, String value2) {
            addCriterion("rcode between", value1, value2, "rcode");
            return (Criteria) this;
        }

        public Criteria andRcodeNotBetween(String value1, String value2) {
            addCriterion("rcode not between", value1, value2, "rcode");
            return (Criteria) this;
        }

        public Criteria andRidIsNull() {
            addCriterion("rid is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rid is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Long value) {
            addCriterion("rid =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Long value) {
            addCriterion("rid <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Long value) {
            addCriterion("rid >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Long value) {
            addCriterion("rid >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Long value) {
            addCriterion("rid <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Long value) {
            addCriterion("rid <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Long> values) {
            addCriterion("rid in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Long> values) {
            addCriterion("rid not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Long value1, Long value2) {
            addCriterion("rid between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Long value1, Long value2) {
            addCriterion("rid not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andUtimeIsNull() {
            addCriterion("utime is null");
            return (Criteria) this;
        }

        public Criteria andUtimeIsNotNull() {
            addCriterion("utime is not null");
            return (Criteria) this;
        }

        public Criteria andUtimeEqualTo(Date value) {
            addCriterion("utime =", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotEqualTo(Date value) {
            addCriterion("utime <>", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeGreaterThan(Date value) {
            addCriterion("utime >", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("utime >=", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeLessThan(Date value) {
            addCriterion("utime <", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeLessThanOrEqualTo(Date value) {
            addCriterion("utime <=", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeIn(List<Date> values) {
            addCriterion("utime in", values, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotIn(List<Date> values) {
            addCriterion("utime not in", values, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeBetween(Date value1, Date value2) {
            addCriterion("utime between", value1, value2, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotBetween(Date value1, Date value2) {
            addCriterion("utime not between", value1, value2, "utime");
            return (Criteria) this;
        }

        public Criteria andChannelstringIsNull() {
            addCriterion("channelString is null");
            return (Criteria) this;
        }

        public Criteria andChannelstringIsNotNull() {
            addCriterion("channelString is not null");
            return (Criteria) this;
        }

        public Criteria andChannelstringEqualTo(String value) {
            addCriterion("channelString =", value, "channelstring");
            return (Criteria) this;
        }

        public Criteria andChannelstringNotEqualTo(String value) {
            addCriterion("channelString <>", value, "channelstring");
            return (Criteria) this;
        }

        public Criteria andChannelstringGreaterThan(String value) {
            addCriterion("channelString >", value, "channelstring");
            return (Criteria) this;
        }

        public Criteria andChannelstringGreaterThanOrEqualTo(String value) {
            addCriterion("channelString >=", value, "channelstring");
            return (Criteria) this;
        }

        public Criteria andChannelstringLessThan(String value) {
            addCriterion("channelString <", value, "channelstring");
            return (Criteria) this;
        }

        public Criteria andChannelstringLessThanOrEqualTo(String value) {
            addCriterion("channelString <=", value, "channelstring");
            return (Criteria) this;
        }

        public Criteria andChannelstringLike(String value) {
            addCriterion("channelString like", value, "channelstring");
            return (Criteria) this;
        }

        public Criteria andChannelstringNotLike(String value) {
            addCriterion("channelString not like", value, "channelstring");
            return (Criteria) this;
        }

        public Criteria andChannelstringIn(List<String> values) {
            addCriterion("channelString in", values, "channelstring");
            return (Criteria) this;
        }

        public Criteria andChannelstringNotIn(List<String> values) {
            addCriterion("channelString not in", values, "channelstring");
            return (Criteria) this;
        }

        public Criteria andChannelstringBetween(String value1, String value2) {
            addCriterion("channelString between", value1, value2, "channelstring");
            return (Criteria) this;
        }

        public Criteria andChannelstringNotBetween(String value1, String value2) {
            addCriterion("channelString not between", value1, value2, "channelstring");
            return (Criteria) this;
        }

        public Criteria andTgyIsNull() {
            addCriterion("tgy is null");
            return (Criteria) this;
        }

        public Criteria andTgyIsNotNull() {
            addCriterion("tgy is not null");
            return (Criteria) this;
        }

        public Criteria andTgyEqualTo(String value) {
            addCriterion("tgy =", value, "tgy");
            return (Criteria) this;
        }

        public Criteria andTgyNotEqualTo(String value) {
            addCriterion("tgy <>", value, "tgy");
            return (Criteria) this;
        }

        public Criteria andTgyGreaterThan(String value) {
            addCriterion("tgy >", value, "tgy");
            return (Criteria) this;
        }

        public Criteria andTgyGreaterThanOrEqualTo(String value) {
            addCriterion("tgy >=", value, "tgy");
            return (Criteria) this;
        }

        public Criteria andTgyLessThan(String value) {
            addCriterion("tgy <", value, "tgy");
            return (Criteria) this;
        }

        public Criteria andTgyLessThanOrEqualTo(String value) {
            addCriterion("tgy <=", value, "tgy");
            return (Criteria) this;
        }

        public Criteria andTgyLike(String value) {
            addCriterion("tgy like", value, "tgy");
            return (Criteria) this;
        }

        public Criteria andTgyNotLike(String value) {
            addCriterion("tgy not like", value, "tgy");
            return (Criteria) this;
        }

        public Criteria andTgyIn(List<String> values) {
            addCriterion("tgy in", values, "tgy");
            return (Criteria) this;
        }

        public Criteria andTgyNotIn(List<String> values) {
            addCriterion("tgy not in", values, "tgy");
            return (Criteria) this;
        }

        public Criteria andTgyBetween(String value1, String value2) {
            addCriterion("tgy between", value1, value2, "tgy");
            return (Criteria) this;
        }

        public Criteria andTgyNotBetween(String value1, String value2) {
            addCriterion("tgy not between", value1, value2, "tgy");
            return (Criteria) this;
        }

        public Criteria andTgymsisdnIsNull() {
            addCriterion("tgymsisdn is null");
            return (Criteria) this;
        }

        public Criteria andTgymsisdnIsNotNull() {
            addCriterion("tgymsisdn is not null");
            return (Criteria) this;
        }

        public Criteria andTgymsisdnEqualTo(String value) {
            addCriterion("tgymsisdn =", value, "tgymsisdn");
            return (Criteria) this;
        }

        public Criteria andTgymsisdnNotEqualTo(String value) {
            addCriterion("tgymsisdn <>", value, "tgymsisdn");
            return (Criteria) this;
        }

        public Criteria andTgymsisdnGreaterThan(String value) {
            addCriterion("tgymsisdn >", value, "tgymsisdn");
            return (Criteria) this;
        }

        public Criteria andTgymsisdnGreaterThanOrEqualTo(String value) {
            addCriterion("tgymsisdn >=", value, "tgymsisdn");
            return (Criteria) this;
        }

        public Criteria andTgymsisdnLessThan(String value) {
            addCriterion("tgymsisdn <", value, "tgymsisdn");
            return (Criteria) this;
        }

        public Criteria andTgymsisdnLessThanOrEqualTo(String value) {
            addCriterion("tgymsisdn <=", value, "tgymsisdn");
            return (Criteria) this;
        }

        public Criteria andTgymsisdnLike(String value) {
            addCriterion("tgymsisdn like", value, "tgymsisdn");
            return (Criteria) this;
        }

        public Criteria andTgymsisdnNotLike(String value) {
            addCriterion("tgymsisdn not like", value, "tgymsisdn");
            return (Criteria) this;
        }

        public Criteria andTgymsisdnIn(List<String> values) {
            addCriterion("tgymsisdn in", values, "tgymsisdn");
            return (Criteria) this;
        }

        public Criteria andTgymsisdnNotIn(List<String> values) {
            addCriterion("tgymsisdn not in", values, "tgymsisdn");
            return (Criteria) this;
        }

        public Criteria andTgymsisdnBetween(String value1, String value2) {
            addCriterion("tgymsisdn between", value1, value2, "tgymsisdn");
            return (Criteria) this;
        }

        public Criteria andTgymsisdnNotBetween(String value1, String value2) {
            addCriterion("tgymsisdn not between", value1, value2, "tgymsisdn");
            return (Criteria) this;
        }

        public Criteria andRetirestIsNull() {
            addCriterion("retirest is null");
            return (Criteria) this;
        }

        public Criteria andRetirestIsNotNull() {
            addCriterion("retirest is not null");
            return (Criteria) this;
        }

        public Criteria andRetirestEqualTo(String value) {
            addCriterion("retirest =", value, "retirest");
            return (Criteria) this;
        }

        public Criteria andRetirestNotEqualTo(String value) {
            addCriterion("retirest <>", value, "retirest");
            return (Criteria) this;
        }

        public Criteria andRetirestGreaterThan(String value) {
            addCriterion("retirest >", value, "retirest");
            return (Criteria) this;
        }

        public Criteria andRetirestGreaterThanOrEqualTo(String value) {
            addCriterion("retirest >=", value, "retirest");
            return (Criteria) this;
        }

        public Criteria andRetirestLessThan(String value) {
            addCriterion("retirest <", value, "retirest");
            return (Criteria) this;
        }

        public Criteria andRetirestLessThanOrEqualTo(String value) {
            addCriterion("retirest <=", value, "retirest");
            return (Criteria) this;
        }

        public Criteria andRetirestLike(String value) {
            addCriterion("retirest like", value, "retirest");
            return (Criteria) this;
        }

        public Criteria andRetirestNotLike(String value) {
            addCriterion("retirest not like", value, "retirest");
            return (Criteria) this;
        }

        public Criteria andRetirestIn(List<String> values) {
            addCriterion("retirest in", values, "retirest");
            return (Criteria) this;
        }

        public Criteria andRetirestNotIn(List<String> values) {
            addCriterion("retirest not in", values, "retirest");
            return (Criteria) this;
        }

        public Criteria andRetirestBetween(String value1, String value2) {
            addCriterion("retirest between", value1, value2, "retirest");
            return (Criteria) this;
        }

        public Criteria andRetirestNotBetween(String value1, String value2) {
            addCriterion("retirest not between", value1, value2, "retirest");
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
package com.landasoft.players.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAdExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_ad
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_ad
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_ad
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ad
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public TAdExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ad
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ad
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ad
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ad
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ad
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ad
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ad
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ad
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ad
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ad
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_ad
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
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

        public Criteria andAdNameIsNull() {
            addCriterion("ad_name is null");
            return (Criteria) this;
        }

        public Criteria andAdNameIsNotNull() {
            addCriterion("ad_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdNameEqualTo(String value) {
            addCriterion("ad_name =", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotEqualTo(String value) {
            addCriterion("ad_name <>", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameGreaterThan(String value) {
            addCriterion("ad_name >", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameGreaterThanOrEqualTo(String value) {
            addCriterion("ad_name >=", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLessThan(String value) {
            addCriterion("ad_name <", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLessThanOrEqualTo(String value) {
            addCriterion("ad_name <=", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLike(String value) {
            addCriterion("ad_name like", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotLike(String value) {
            addCriterion("ad_name not like", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameIn(List<String> values) {
            addCriterion("ad_name in", values, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotIn(List<String> values) {
            addCriterion("ad_name not in", values, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameBetween(String value1, String value2) {
            addCriterion("ad_name between", value1, value2, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotBetween(String value1, String value2) {
            addCriterion("ad_name not between", value1, value2, "adName");
            return (Criteria) this;
        }

        public Criteria andAdLinkIsNull() {
            addCriterion("ad_link is null");
            return (Criteria) this;
        }

        public Criteria andAdLinkIsNotNull() {
            addCriterion("ad_link is not null");
            return (Criteria) this;
        }

        public Criteria andAdLinkEqualTo(String value) {
            addCriterion("ad_link =", value, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkNotEqualTo(String value) {
            addCriterion("ad_link <>", value, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkGreaterThan(String value) {
            addCriterion("ad_link >", value, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkGreaterThanOrEqualTo(String value) {
            addCriterion("ad_link >=", value, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkLessThan(String value) {
            addCriterion("ad_link <", value, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkLessThanOrEqualTo(String value) {
            addCriterion("ad_link <=", value, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkLike(String value) {
            addCriterion("ad_link like", value, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkNotLike(String value) {
            addCriterion("ad_link not like", value, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkIn(List<String> values) {
            addCriterion("ad_link in", values, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkNotIn(List<String> values) {
            addCriterion("ad_link not in", values, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkBetween(String value1, String value2) {
            addCriterion("ad_link between", value1, value2, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkNotBetween(String value1, String value2) {
            addCriterion("ad_link not between", value1, value2, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdImageDirIsNull() {
            addCriterion("ad_image_dir is null");
            return (Criteria) this;
        }

        public Criteria andAdImageDirIsNotNull() {
            addCriterion("ad_image_dir is not null");
            return (Criteria) this;
        }

        public Criteria andAdImageDirEqualTo(String value) {
            addCriterion("ad_image_dir =", value, "adImageDir");
            return (Criteria) this;
        }

        public Criteria andAdImageDirNotEqualTo(String value) {
            addCriterion("ad_image_dir <>", value, "adImageDir");
            return (Criteria) this;
        }

        public Criteria andAdImageDirGreaterThan(String value) {
            addCriterion("ad_image_dir >", value, "adImageDir");
            return (Criteria) this;
        }

        public Criteria andAdImageDirGreaterThanOrEqualTo(String value) {
            addCriterion("ad_image_dir >=", value, "adImageDir");
            return (Criteria) this;
        }

        public Criteria andAdImageDirLessThan(String value) {
            addCriterion("ad_image_dir <", value, "adImageDir");
            return (Criteria) this;
        }

        public Criteria andAdImageDirLessThanOrEqualTo(String value) {
            addCriterion("ad_image_dir <=", value, "adImageDir");
            return (Criteria) this;
        }

        public Criteria andAdImageDirLike(String value) {
            addCriterion("ad_image_dir like", value, "adImageDir");
            return (Criteria) this;
        }

        public Criteria andAdImageDirNotLike(String value) {
            addCriterion("ad_image_dir not like", value, "adImageDir");
            return (Criteria) this;
        }

        public Criteria andAdImageDirIn(List<String> values) {
            addCriterion("ad_image_dir in", values, "adImageDir");
            return (Criteria) this;
        }

        public Criteria andAdImageDirNotIn(List<String> values) {
            addCriterion("ad_image_dir not in", values, "adImageDir");
            return (Criteria) this;
        }

        public Criteria andAdImageDirBetween(String value1, String value2) {
            addCriterion("ad_image_dir between", value1, value2, "adImageDir");
            return (Criteria) this;
        }

        public Criteria andAdImageDirNotBetween(String value1, String value2) {
            addCriterion("ad_image_dir not between", value1, value2, "adImageDir");
            return (Criteria) this;
        }

        public Criteria andAdTypeIsNull() {
            addCriterion("ad_type is null");
            return (Criteria) this;
        }

        public Criteria andAdTypeIsNotNull() {
            addCriterion("ad_type is not null");
            return (Criteria) this;
        }

        public Criteria andAdTypeEqualTo(Byte value) {
            addCriterion("ad_type =", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeNotEqualTo(Byte value) {
            addCriterion("ad_type <>", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeGreaterThan(Byte value) {
            addCriterion("ad_type >", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("ad_type >=", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeLessThan(Byte value) {
            addCriterion("ad_type <", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeLessThanOrEqualTo(Byte value) {
            addCriterion("ad_type <=", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeIn(List<Byte> values) {
            addCriterion("ad_type in", values, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeNotIn(List<Byte> values) {
            addCriterion("ad_type not in", values, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeBetween(Byte value1, Byte value2) {
            addCriterion("ad_type between", value1, value2, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("ad_type not between", value1, value2, "adType");
            return (Criteria) this;
        }

        public Criteria andAdStateIsNull() {
            addCriterion("ad_state is null");
            return (Criteria) this;
        }

        public Criteria andAdStateIsNotNull() {
            addCriterion("ad_state is not null");
            return (Criteria) this;
        }

        public Criteria andAdStateEqualTo(Byte value) {
            addCriterion("ad_state =", value, "adState");
            return (Criteria) this;
        }

        public Criteria andAdStateNotEqualTo(Byte value) {
            addCriterion("ad_state <>", value, "adState");
            return (Criteria) this;
        }

        public Criteria andAdStateGreaterThan(Byte value) {
            addCriterion("ad_state >", value, "adState");
            return (Criteria) this;
        }

        public Criteria andAdStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("ad_state >=", value, "adState");
            return (Criteria) this;
        }

        public Criteria andAdStateLessThan(Byte value) {
            addCriterion("ad_state <", value, "adState");
            return (Criteria) this;
        }

        public Criteria andAdStateLessThanOrEqualTo(Byte value) {
            addCriterion("ad_state <=", value, "adState");
            return (Criteria) this;
        }

        public Criteria andAdStateIn(List<Byte> values) {
            addCriterion("ad_state in", values, "adState");
            return (Criteria) this;
        }

        public Criteria andAdStateNotIn(List<Byte> values) {
            addCriterion("ad_state not in", values, "adState");
            return (Criteria) this;
        }

        public Criteria andAdStateBetween(Byte value1, Byte value2) {
            addCriterion("ad_state between", value1, value2, "adState");
            return (Criteria) this;
        }

        public Criteria andAdStateNotBetween(Byte value1, Byte value2) {
            addCriterion("ad_state not between", value1, value2, "adState");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_ad
     *
     * @mbggenerated do_not_delete_during_merge Fri Feb 21 20:05:06 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_ad
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
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
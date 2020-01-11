package com.example.springboot20200107.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScenicSpotExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScenicSpotExample() {
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

        public Criteria andScenicSpotNameIsNull() {
            addCriterion("scenic_spot_name is null");
            return (Criteria) this;
        }

        public Criteria andScenicSpotNameIsNotNull() {
            addCriterion("scenic_spot_name is not null");
            return (Criteria) this;
        }

        public Criteria andScenicSpotNameEqualTo(String value) {
            addCriterion("scenic_spot_name =", value, "scenicSpotName");
            return (Criteria) this;
        }

        public Criteria andScenicSpotNameNotEqualTo(String value) {
            addCriterion("scenic_spot_name <>", value, "scenicSpotName");
            return (Criteria) this;
        }

        public Criteria andScenicSpotNameGreaterThan(String value) {
            addCriterion("scenic_spot_name >", value, "scenicSpotName");
            return (Criteria) this;
        }

        public Criteria andScenicSpotNameGreaterThanOrEqualTo(String value) {
            addCriterion("scenic_spot_name >=", value, "scenicSpotName");
            return (Criteria) this;
        }

        public Criteria andScenicSpotNameLessThan(String value) {
            addCriterion("scenic_spot_name <", value, "scenicSpotName");
            return (Criteria) this;
        }

        public Criteria andScenicSpotNameLessThanOrEqualTo(String value) {
            addCriterion("scenic_spot_name <=", value, "scenicSpotName");
            return (Criteria) this;
        }

        public Criteria andScenicSpotNameLike(String value) {
            addCriterion("scenic_spot_name like", value, "scenicSpotName");
            return (Criteria) this;
        }

        public Criteria andScenicSpotNameNotLike(String value) {
            addCriterion("scenic_spot_name not like", value, "scenicSpotName");
            return (Criteria) this;
        }

        public Criteria andScenicSpotNameIn(List<String> values) {
            addCriterion("scenic_spot_name in", values, "scenicSpotName");
            return (Criteria) this;
        }

        public Criteria andScenicSpotNameNotIn(List<String> values) {
            addCriterion("scenic_spot_name not in", values, "scenicSpotName");
            return (Criteria) this;
        }

        public Criteria andScenicSpotNameBetween(String value1, String value2) {
            addCriterion("scenic_spot_name between", value1, value2, "scenicSpotName");
            return (Criteria) this;
        }

        public Criteria andScenicSpotNameNotBetween(String value1, String value2) {
            addCriterion("scenic_spot_name not between", value1, value2, "scenicSpotName");
            return (Criteria) this;
        }

        public Criteria andScenicSpotAddressIsNull() {
            addCriterion("scenic_spot_address is null");
            return (Criteria) this;
        }

        public Criteria andScenicSpotAddressIsNotNull() {
            addCriterion("scenic_spot_address is not null");
            return (Criteria) this;
        }

        public Criteria andScenicSpotAddressEqualTo(String value) {
            addCriterion("scenic_spot_address =", value, "scenicSpotAddress");
            return (Criteria) this;
        }

        public Criteria andScenicSpotAddressNotEqualTo(String value) {
            addCriterion("scenic_spot_address <>", value, "scenicSpotAddress");
            return (Criteria) this;
        }

        public Criteria andScenicSpotAddressGreaterThan(String value) {
            addCriterion("scenic_spot_address >", value, "scenicSpotAddress");
            return (Criteria) this;
        }

        public Criteria andScenicSpotAddressGreaterThanOrEqualTo(String value) {
            addCriterion("scenic_spot_address >=", value, "scenicSpotAddress");
            return (Criteria) this;
        }

        public Criteria andScenicSpotAddressLessThan(String value) {
            addCriterion("scenic_spot_address <", value, "scenicSpotAddress");
            return (Criteria) this;
        }

        public Criteria andScenicSpotAddressLessThanOrEqualTo(String value) {
            addCriterion("scenic_spot_address <=", value, "scenicSpotAddress");
            return (Criteria) this;
        }

        public Criteria andScenicSpotAddressLike(String value) {
            addCriterion("scenic_spot_address like", value, "scenicSpotAddress");
            return (Criteria) this;
        }

        public Criteria andScenicSpotAddressNotLike(String value) {
            addCriterion("scenic_spot_address not like", value, "scenicSpotAddress");
            return (Criteria) this;
        }

        public Criteria andScenicSpotAddressIn(List<String> values) {
            addCriterion("scenic_spot_address in", values, "scenicSpotAddress");
            return (Criteria) this;
        }

        public Criteria andScenicSpotAddressNotIn(List<String> values) {
            addCriterion("scenic_spot_address not in", values, "scenicSpotAddress");
            return (Criteria) this;
        }

        public Criteria andScenicSpotAddressBetween(String value1, String value2) {
            addCriterion("scenic_spot_address between", value1, value2, "scenicSpotAddress");
            return (Criteria) this;
        }

        public Criteria andScenicSpotAddressNotBetween(String value1, String value2) {
            addCriterion("scenic_spot_address not between", value1, value2, "scenicSpotAddress");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgIsNull() {
            addCriterion("scenic_spot_img is null");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgIsNotNull() {
            addCriterion("scenic_spot_img is not null");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgEqualTo(String value) {
            addCriterion("scenic_spot_img =", value, "scenicSpotImg");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgNotEqualTo(String value) {
            addCriterion("scenic_spot_img <>", value, "scenicSpotImg");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgGreaterThan(String value) {
            addCriterion("scenic_spot_img >", value, "scenicSpotImg");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgGreaterThanOrEqualTo(String value) {
            addCriterion("scenic_spot_img >=", value, "scenicSpotImg");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgLessThan(String value) {
            addCriterion("scenic_spot_img <", value, "scenicSpotImg");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgLessThanOrEqualTo(String value) {
            addCriterion("scenic_spot_img <=", value, "scenicSpotImg");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgLike(String value) {
            addCriterion("scenic_spot_img like", value, "scenicSpotImg");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgNotLike(String value) {
            addCriterion("scenic_spot_img not like", value, "scenicSpotImg");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgIn(List<String> values) {
            addCriterion("scenic_spot_img in", values, "scenicSpotImg");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgNotIn(List<String> values) {
            addCriterion("scenic_spot_img not in", values, "scenicSpotImg");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgBetween(String value1, String value2) {
            addCriterion("scenic_spot_img between", value1, value2, "scenicSpotImg");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgNotBetween(String value1, String value2) {
            addCriterion("scenic_spot_img not between", value1, value2, "scenicSpotImg");
            return (Criteria) this;
        }

        public Criteria andScenicSpotDescribeIsNull() {
            addCriterion("scenic_spot_describe is null");
            return (Criteria) this;
        }

        public Criteria andScenicSpotDescribeIsNotNull() {
            addCriterion("scenic_spot_describe is not null");
            return (Criteria) this;
        }

        public Criteria andScenicSpotDescribeEqualTo(String value) {
            addCriterion("scenic_spot_describe =", value, "scenicSpotDescribe");
            return (Criteria) this;
        }

        public Criteria andScenicSpotDescribeNotEqualTo(String value) {
            addCriterion("scenic_spot_describe <>", value, "scenicSpotDescribe");
            return (Criteria) this;
        }

        public Criteria andScenicSpotDescribeGreaterThan(String value) {
            addCriterion("scenic_spot_describe >", value, "scenicSpotDescribe");
            return (Criteria) this;
        }

        public Criteria andScenicSpotDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("scenic_spot_describe >=", value, "scenicSpotDescribe");
            return (Criteria) this;
        }

        public Criteria andScenicSpotDescribeLessThan(String value) {
            addCriterion("scenic_spot_describe <", value, "scenicSpotDescribe");
            return (Criteria) this;
        }

        public Criteria andScenicSpotDescribeLessThanOrEqualTo(String value) {
            addCriterion("scenic_spot_describe <=", value, "scenicSpotDescribe");
            return (Criteria) this;
        }

        public Criteria andScenicSpotDescribeLike(String value) {
            addCriterion("scenic_spot_describe like", value, "scenicSpotDescribe");
            return (Criteria) this;
        }

        public Criteria andScenicSpotDescribeNotLike(String value) {
            addCriterion("scenic_spot_describe not like", value, "scenicSpotDescribe");
            return (Criteria) this;
        }

        public Criteria andScenicSpotDescribeIn(List<String> values) {
            addCriterion("scenic_spot_describe in", values, "scenicSpotDescribe");
            return (Criteria) this;
        }

        public Criteria andScenicSpotDescribeNotIn(List<String> values) {
            addCriterion("scenic_spot_describe not in", values, "scenicSpotDescribe");
            return (Criteria) this;
        }

        public Criteria andScenicSpotDescribeBetween(String value1, String value2) {
            addCriterion("scenic_spot_describe between", value1, value2, "scenicSpotDescribe");
            return (Criteria) this;
        }

        public Criteria andScenicSpotDescribeNotBetween(String value1, String value2) {
            addCriterion("scenic_spot_describe not between", value1, value2, "scenicSpotDescribe");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgsIsNull() {
            addCriterion("scenic_spot_imgs is null");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgsIsNotNull() {
            addCriterion("scenic_spot_imgs is not null");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgsEqualTo(String value) {
            addCriterion("scenic_spot_imgs =", value, "scenicSpotImgs");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgsNotEqualTo(String value) {
            addCriterion("scenic_spot_imgs <>", value, "scenicSpotImgs");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgsGreaterThan(String value) {
            addCriterion("scenic_spot_imgs >", value, "scenicSpotImgs");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgsGreaterThanOrEqualTo(String value) {
            addCriterion("scenic_spot_imgs >=", value, "scenicSpotImgs");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgsLessThan(String value) {
            addCriterion("scenic_spot_imgs <", value, "scenicSpotImgs");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgsLessThanOrEqualTo(String value) {
            addCriterion("scenic_spot_imgs <=", value, "scenicSpotImgs");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgsLike(String value) {
            addCriterion("scenic_spot_imgs like", value, "scenicSpotImgs");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgsNotLike(String value) {
            addCriterion("scenic_spot_imgs not like", value, "scenicSpotImgs");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgsIn(List<String> values) {
            addCriterion("scenic_spot_imgs in", values, "scenicSpotImgs");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgsNotIn(List<String> values) {
            addCriterion("scenic_spot_imgs not in", values, "scenicSpotImgs");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgsBetween(String value1, String value2) {
            addCriterion("scenic_spot_imgs between", value1, value2, "scenicSpotImgs");
            return (Criteria) this;
        }

        public Criteria andScenicSpotImgsNotBetween(String value1, String value2) {
            addCriterion("scenic_spot_imgs not between", value1, value2, "scenicSpotImgs");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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
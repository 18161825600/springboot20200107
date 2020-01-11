package com.example.springboot20200107.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TicketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketExample() {
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

        public Criteria andScenicSpotIdIsNull() {
            addCriterion("scenic_spot_id is null");
            return (Criteria) this;
        }

        public Criteria andScenicSpotIdIsNotNull() {
            addCriterion("scenic_spot_id is not null");
            return (Criteria) this;
        }

        public Criteria andScenicSpotIdEqualTo(Long value) {
            addCriterion("scenic_spot_id =", value, "scenicSpotId");
            return (Criteria) this;
        }

        public Criteria andScenicSpotIdNotEqualTo(Long value) {
            addCriterion("scenic_spot_id <>", value, "scenicSpotId");
            return (Criteria) this;
        }

        public Criteria andScenicSpotIdGreaterThan(Long value) {
            addCriterion("scenic_spot_id >", value, "scenicSpotId");
            return (Criteria) this;
        }

        public Criteria andScenicSpotIdGreaterThanOrEqualTo(Long value) {
            addCriterion("scenic_spot_id >=", value, "scenicSpotId");
            return (Criteria) this;
        }

        public Criteria andScenicSpotIdLessThan(Long value) {
            addCriterion("scenic_spot_id <", value, "scenicSpotId");
            return (Criteria) this;
        }

        public Criteria andScenicSpotIdLessThanOrEqualTo(Long value) {
            addCriterion("scenic_spot_id <=", value, "scenicSpotId");
            return (Criteria) this;
        }

        public Criteria andScenicSpotIdIn(List<Long> values) {
            addCriterion("scenic_spot_id in", values, "scenicSpotId");
            return (Criteria) this;
        }

        public Criteria andScenicSpotIdNotIn(List<Long> values) {
            addCriterion("scenic_spot_id not in", values, "scenicSpotId");
            return (Criteria) this;
        }

        public Criteria andScenicSpotIdBetween(Long value1, Long value2) {
            addCriterion("scenic_spot_id between", value1, value2, "scenicSpotId");
            return (Criteria) this;
        }

        public Criteria andScenicSpotIdNotBetween(Long value1, Long value2) {
            addCriterion("scenic_spot_id not between", value1, value2, "scenicSpotId");
            return (Criteria) this;
        }

        public Criteria andTicketNameIsNull() {
            addCriterion("ticket_name is null");
            return (Criteria) this;
        }

        public Criteria andTicketNameIsNotNull() {
            addCriterion("ticket_name is not null");
            return (Criteria) this;
        }

        public Criteria andTicketNameEqualTo(String value) {
            addCriterion("ticket_name =", value, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameNotEqualTo(String value) {
            addCriterion("ticket_name <>", value, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameGreaterThan(String value) {
            addCriterion("ticket_name >", value, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_name >=", value, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameLessThan(String value) {
            addCriterion("ticket_name <", value, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameLessThanOrEqualTo(String value) {
            addCriterion("ticket_name <=", value, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameLike(String value) {
            addCriterion("ticket_name like", value, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameNotLike(String value) {
            addCriterion("ticket_name not like", value, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameIn(List<String> values) {
            addCriterion("ticket_name in", values, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameNotIn(List<String> values) {
            addCriterion("ticket_name not in", values, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameBetween(String value1, String value2) {
            addCriterion("ticket_name between", value1, value2, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameNotBetween(String value1, String value2) {
            addCriterion("ticket_name not between", value1, value2, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketPriceAdultIsNull() {
            addCriterion("ticket_price_adult is null");
            return (Criteria) this;
        }

        public Criteria andTicketPriceAdultIsNotNull() {
            addCriterion("ticket_price_adult is not null");
            return (Criteria) this;
        }

        public Criteria andTicketPriceAdultEqualTo(Double value) {
            addCriterion("ticket_price_adult =", value, "ticketPriceAdult");
            return (Criteria) this;
        }

        public Criteria andTicketPriceAdultNotEqualTo(Double value) {
            addCriterion("ticket_price_adult <>", value, "ticketPriceAdult");
            return (Criteria) this;
        }

        public Criteria andTicketPriceAdultGreaterThan(Double value) {
            addCriterion("ticket_price_adult >", value, "ticketPriceAdult");
            return (Criteria) this;
        }

        public Criteria andTicketPriceAdultGreaterThanOrEqualTo(Double value) {
            addCriterion("ticket_price_adult >=", value, "ticketPriceAdult");
            return (Criteria) this;
        }

        public Criteria andTicketPriceAdultLessThan(Double value) {
            addCriterion("ticket_price_adult <", value, "ticketPriceAdult");
            return (Criteria) this;
        }

        public Criteria andTicketPriceAdultLessThanOrEqualTo(Double value) {
            addCriterion("ticket_price_adult <=", value, "ticketPriceAdult");
            return (Criteria) this;
        }

        public Criteria andTicketPriceAdultIn(List<Double> values) {
            addCriterion("ticket_price_adult in", values, "ticketPriceAdult");
            return (Criteria) this;
        }

        public Criteria andTicketPriceAdultNotIn(List<Double> values) {
            addCriterion("ticket_price_adult not in", values, "ticketPriceAdult");
            return (Criteria) this;
        }

        public Criteria andTicketPriceAdultBetween(Double value1, Double value2) {
            addCriterion("ticket_price_adult between", value1, value2, "ticketPriceAdult");
            return (Criteria) this;
        }

        public Criteria andTicketPriceAdultNotBetween(Double value1, Double value2) {
            addCriterion("ticket_price_adult not between", value1, value2, "ticketPriceAdult");
            return (Criteria) this;
        }

        public Criteria andTicketPriceStudentIsNull() {
            addCriterion("ticket_price_student is null");
            return (Criteria) this;
        }

        public Criteria andTicketPriceStudentIsNotNull() {
            addCriterion("ticket_price_student is not null");
            return (Criteria) this;
        }

        public Criteria andTicketPriceStudentEqualTo(Double value) {
            addCriterion("ticket_price_student =", value, "ticketPriceStudent");
            return (Criteria) this;
        }

        public Criteria andTicketPriceStudentNotEqualTo(Double value) {
            addCriterion("ticket_price_student <>", value, "ticketPriceStudent");
            return (Criteria) this;
        }

        public Criteria andTicketPriceStudentGreaterThan(Double value) {
            addCriterion("ticket_price_student >", value, "ticketPriceStudent");
            return (Criteria) this;
        }

        public Criteria andTicketPriceStudentGreaterThanOrEqualTo(Double value) {
            addCriterion("ticket_price_student >=", value, "ticketPriceStudent");
            return (Criteria) this;
        }

        public Criteria andTicketPriceStudentLessThan(Double value) {
            addCriterion("ticket_price_student <", value, "ticketPriceStudent");
            return (Criteria) this;
        }

        public Criteria andTicketPriceStudentLessThanOrEqualTo(Double value) {
            addCriterion("ticket_price_student <=", value, "ticketPriceStudent");
            return (Criteria) this;
        }

        public Criteria andTicketPriceStudentIn(List<Double> values) {
            addCriterion("ticket_price_student in", values, "ticketPriceStudent");
            return (Criteria) this;
        }

        public Criteria andTicketPriceStudentNotIn(List<Double> values) {
            addCriterion("ticket_price_student not in", values, "ticketPriceStudent");
            return (Criteria) this;
        }

        public Criteria andTicketPriceStudentBetween(Double value1, Double value2) {
            addCriterion("ticket_price_student between", value1, value2, "ticketPriceStudent");
            return (Criteria) this;
        }

        public Criteria andTicketPriceStudentNotBetween(Double value1, Double value2) {
            addCriterion("ticket_price_student not between", value1, value2, "ticketPriceStudent");
            return (Criteria) this;
        }

        public Criteria andTicketNumberAdultIsNull() {
            addCriterion("ticket_number_adult is null");
            return (Criteria) this;
        }

        public Criteria andTicketNumberAdultIsNotNull() {
            addCriterion("ticket_number_adult is not null");
            return (Criteria) this;
        }

        public Criteria andTicketNumberAdultEqualTo(Integer value) {
            addCriterion("ticket_number_adult =", value, "ticketNumberAdult");
            return (Criteria) this;
        }

        public Criteria andTicketNumberAdultNotEqualTo(Integer value) {
            addCriterion("ticket_number_adult <>", value, "ticketNumberAdult");
            return (Criteria) this;
        }

        public Criteria andTicketNumberAdultGreaterThan(Integer value) {
            addCriterion("ticket_number_adult >", value, "ticketNumberAdult");
            return (Criteria) this;
        }

        public Criteria andTicketNumberAdultGreaterThanOrEqualTo(Integer value) {
            addCriterion("ticket_number_adult >=", value, "ticketNumberAdult");
            return (Criteria) this;
        }

        public Criteria andTicketNumberAdultLessThan(Integer value) {
            addCriterion("ticket_number_adult <", value, "ticketNumberAdult");
            return (Criteria) this;
        }

        public Criteria andTicketNumberAdultLessThanOrEqualTo(Integer value) {
            addCriterion("ticket_number_adult <=", value, "ticketNumberAdult");
            return (Criteria) this;
        }

        public Criteria andTicketNumberAdultIn(List<Integer> values) {
            addCriterion("ticket_number_adult in", values, "ticketNumberAdult");
            return (Criteria) this;
        }

        public Criteria andTicketNumberAdultNotIn(List<Integer> values) {
            addCriterion("ticket_number_adult not in", values, "ticketNumberAdult");
            return (Criteria) this;
        }

        public Criteria andTicketNumberAdultBetween(Integer value1, Integer value2) {
            addCriterion("ticket_number_adult between", value1, value2, "ticketNumberAdult");
            return (Criteria) this;
        }

        public Criteria andTicketNumberAdultNotBetween(Integer value1, Integer value2) {
            addCriterion("ticket_number_adult not between", value1, value2, "ticketNumberAdult");
            return (Criteria) this;
        }

        public Criteria andTicketNumberStudentIsNull() {
            addCriterion("ticket_number_student is null");
            return (Criteria) this;
        }

        public Criteria andTicketNumberStudentIsNotNull() {
            addCriterion("ticket_number_student is not null");
            return (Criteria) this;
        }

        public Criteria andTicketNumberStudentEqualTo(Integer value) {
            addCriterion("ticket_number_student =", value, "ticketNumberStudent");
            return (Criteria) this;
        }

        public Criteria andTicketNumberStudentNotEqualTo(Integer value) {
            addCriterion("ticket_number_student <>", value, "ticketNumberStudent");
            return (Criteria) this;
        }

        public Criteria andTicketNumberStudentGreaterThan(Integer value) {
            addCriterion("ticket_number_student >", value, "ticketNumberStudent");
            return (Criteria) this;
        }

        public Criteria andTicketNumberStudentGreaterThanOrEqualTo(Integer value) {
            addCriterion("ticket_number_student >=", value, "ticketNumberStudent");
            return (Criteria) this;
        }

        public Criteria andTicketNumberStudentLessThan(Integer value) {
            addCriterion("ticket_number_student <", value, "ticketNumberStudent");
            return (Criteria) this;
        }

        public Criteria andTicketNumberStudentLessThanOrEqualTo(Integer value) {
            addCriterion("ticket_number_student <=", value, "ticketNumberStudent");
            return (Criteria) this;
        }

        public Criteria andTicketNumberStudentIn(List<Integer> values) {
            addCriterion("ticket_number_student in", values, "ticketNumberStudent");
            return (Criteria) this;
        }

        public Criteria andTicketNumberStudentNotIn(List<Integer> values) {
            addCriterion("ticket_number_student not in", values, "ticketNumberStudent");
            return (Criteria) this;
        }

        public Criteria andTicketNumberStudentBetween(Integer value1, Integer value2) {
            addCriterion("ticket_number_student between", value1, value2, "ticketNumberStudent");
            return (Criteria) this;
        }

        public Criteria andTicketNumberStudentNotBetween(Integer value1, Integer value2) {
            addCriterion("ticket_number_student not between", value1, value2, "ticketNumberStudent");
            return (Criteria) this;
        }

        public Criteria andTicketDescribeIsNull() {
            addCriterion("ticket_describe is null");
            return (Criteria) this;
        }

        public Criteria andTicketDescribeIsNotNull() {
            addCriterion("ticket_describe is not null");
            return (Criteria) this;
        }

        public Criteria andTicketDescribeEqualTo(String value) {
            addCriterion("ticket_describe =", value, "ticketDescribe");
            return (Criteria) this;
        }

        public Criteria andTicketDescribeNotEqualTo(String value) {
            addCriterion("ticket_describe <>", value, "ticketDescribe");
            return (Criteria) this;
        }

        public Criteria andTicketDescribeGreaterThan(String value) {
            addCriterion("ticket_describe >", value, "ticketDescribe");
            return (Criteria) this;
        }

        public Criteria andTicketDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_describe >=", value, "ticketDescribe");
            return (Criteria) this;
        }

        public Criteria andTicketDescribeLessThan(String value) {
            addCriterion("ticket_describe <", value, "ticketDescribe");
            return (Criteria) this;
        }

        public Criteria andTicketDescribeLessThanOrEqualTo(String value) {
            addCriterion("ticket_describe <=", value, "ticketDescribe");
            return (Criteria) this;
        }

        public Criteria andTicketDescribeLike(String value) {
            addCriterion("ticket_describe like", value, "ticketDescribe");
            return (Criteria) this;
        }

        public Criteria andTicketDescribeNotLike(String value) {
            addCriterion("ticket_describe not like", value, "ticketDescribe");
            return (Criteria) this;
        }

        public Criteria andTicketDescribeIn(List<String> values) {
            addCriterion("ticket_describe in", values, "ticketDescribe");
            return (Criteria) this;
        }

        public Criteria andTicketDescribeNotIn(List<String> values) {
            addCriterion("ticket_describe not in", values, "ticketDescribe");
            return (Criteria) this;
        }

        public Criteria andTicketDescribeBetween(String value1, String value2) {
            addCriterion("ticket_describe between", value1, value2, "ticketDescribe");
            return (Criteria) this;
        }

        public Criteria andTicketDescribeNotBetween(String value1, String value2) {
            addCriterion("ticket_describe not between", value1, value2, "ticketDescribe");
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
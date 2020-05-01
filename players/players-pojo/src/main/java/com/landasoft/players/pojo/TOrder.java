package com.landasoft.players.pojo;

import java.util.Date;

public class TOrder {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.order_id
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.payment
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    private String payment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.states
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    private Byte states;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.created
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    private Date created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.updated
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    private Date updated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.end_time
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    private Date endTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.order_id
     *
     * @return the value of t_order.order_id
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.order_id
     *
     * @param orderId the value for t_order.order_id
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.payment
     *
     * @return the value of t_order.payment
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    public String getPayment() {
        return payment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.payment
     *
     * @param payment the value for t_order.payment
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    public void setPayment(String payment) {
        this.payment = payment == null ? null : payment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.states
     *
     * @return the value of t_order.states
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    public Byte getStates() {
        return states;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.states
     *
     * @param states the value for t_order.states
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    public void setStates(Byte states) {
        this.states = states;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.created
     *
     * @return the value of t_order.created
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.created
     *
     * @param created the value for t_order.created
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.updated
     *
     * @return the value of t_order.updated
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.updated
     *
     * @param updated the value for t_order.updated
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.end_time
     *
     * @return the value of t_order.end_time
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.end_time
     *
     * @param endTime the value for t_order.end_time
     *
     * @mbggenerated Thu Feb 20 17:44:08 CST 2020
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
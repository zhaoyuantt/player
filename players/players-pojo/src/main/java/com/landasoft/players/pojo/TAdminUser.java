package com.landasoft.players.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TAdminUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin_user.id
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin_user.username
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin_user.password
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin_user.state
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    private Byte state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin_user.created
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin_user.updated
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    private Date updated;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin_user.id
     *
     * @return the value of t_admin_user.id
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin_user.id
     *
     * @param id the value for t_admin_user.id
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin_user.username
     *
     * @return the value of t_admin_user.username
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin_user.username
     *
     * @param username the value for t_admin_user.username
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin_user.password
     *
     * @return the value of t_admin_user.password
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin_user.password
     *
     * @param password the value for t_admin_user.password
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin_user.state
     *
     * @return the value of t_admin_user.state
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    public Byte getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin_user.state
     *
     * @param state the value for t_admin_user.state
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin_user.created
     *
     * @return the value of t_admin_user.created
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin_user.created
     *
     * @param created the value for t_admin_user.created
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin_user.updated
     *
     * @return the value of t_admin_user.updated
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin_user.updated
     *
     * @param updated the value for t_admin_user.updated
     *
     * @mbggenerated Wed Feb 12 14:27:12 CST 2020
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
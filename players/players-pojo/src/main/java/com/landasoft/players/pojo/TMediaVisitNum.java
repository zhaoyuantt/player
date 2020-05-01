package com.landasoft.players.pojo;

import java.util.Date;

public class TMediaVisitNum {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_media_visit_num.id
     *
     * @mbggenerated Thu Feb 13 11:40:21 CST 2020
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_media_visit_num.media_id
     *
     * @mbggenerated Thu Feb 13 11:40:21 CST 2020
     */
    private Long mediaId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_media_visit_num.media_visit_num
     *
     * @mbggenerated Thu Feb 13 11:40:21 CST 2020
     */
    private Long mediaVisitNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_media_visit_num.created
     *
     * @mbggenerated Thu Feb 13 11:40:21 CST 2020
     */
    private Date created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_media_visit_num.updated
     *
     * @mbggenerated Thu Feb 13 11:40:21 CST 2020
     */
    private Date updated;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_media_visit_num.id
     *
     * @return the value of t_media_visit_num.id
     *
     * @mbggenerated Thu Feb 13 11:40:21 CST 2020
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_media_visit_num.id
     *
     * @param id the value for t_media_visit_num.id
     *
     * @mbggenerated Thu Feb 13 11:40:21 CST 2020
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_media_visit_num.media_id
     *
     * @return the value of t_media_visit_num.media_id
     *
     * @mbggenerated Thu Feb 13 11:40:21 CST 2020
     */
    public Long getMediaId() {
        return mediaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_media_visit_num.media_id
     *
     * @param mediaId the value for t_media_visit_num.media_id
     *
     * @mbggenerated Thu Feb 13 11:40:21 CST 2020
     */
    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_media_visit_num.media_visit_num
     *
     * @return the value of t_media_visit_num.media_visit_num
     *
     * @mbggenerated Thu Feb 13 11:40:21 CST 2020
     */
    public Long getMediaVisitNum() {
        return mediaVisitNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_media_visit_num.media_visit_num
     *
     * @param mediaVisitNum the value for t_media_visit_num.media_visit_num
     *
     * @mbggenerated Thu Feb 13 11:40:21 CST 2020
     */
    public void setMediaVisitNum(Long mediaVisitNum) {
        this.mediaVisitNum = mediaVisitNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_media_visit_num.created
     *
     * @return the value of t_media_visit_num.created
     *
     * @mbggenerated Thu Feb 13 11:40:21 CST 2020
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_media_visit_num.created
     *
     * @param created the value for t_media_visit_num.created
     *
     * @mbggenerated Thu Feb 13 11:40:21 CST 2020
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_media_visit_num.updated
     *
     * @return the value of t_media_visit_num.updated
     *
     * @mbggenerated Thu Feb 13 11:40:21 CST 2020
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_media_visit_num.updated
     *
     * @param updated the value for t_media_visit_num.updated
     *
     * @mbggenerated Thu Feb 13 11:40:21 CST 2020
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
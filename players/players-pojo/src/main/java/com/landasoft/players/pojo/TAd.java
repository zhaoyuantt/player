package com.landasoft.players.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TAd {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ad.id
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ad.ad_name
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    private String adName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ad.ad_link
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    private String adLink;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ad.ad_image_dir
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    private String adImageDir;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ad.ad_type
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    private Byte adType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ad.ad_state
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    private Byte adState;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ad.created
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ad.updated
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updated;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ad.id
     *
     * @return the value of t_ad.id
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ad.id
     *
     * @param id the value for t_ad.id
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ad.ad_name
     *
     * @return the value of t_ad.ad_name
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public String getAdName() {
        return adName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ad.ad_name
     *
     * @param adName the value for t_ad.ad_name
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public void setAdName(String adName) {
        this.adName = adName == null ? null : adName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ad.ad_link
     *
     * @return the value of t_ad.ad_link
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public String getAdLink() {
        return adLink;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ad.ad_link
     *
     * @param adLink the value for t_ad.ad_link
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public void setAdLink(String adLink) {
        this.adLink = adLink == null ? null : adLink.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ad.ad_image_dir
     *
     * @return the value of t_ad.ad_image_dir
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public String getAdImageDir() {
        return adImageDir;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ad.ad_image_dir
     *
     * @param adImageDir the value for t_ad.ad_image_dir
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public void setAdImageDir(String adImageDir) {
        this.adImageDir = adImageDir == null ? null : adImageDir.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ad.ad_type
     *
     * @return the value of t_ad.ad_type
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public Byte getAdType() {
        return adType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ad.ad_type
     *
     * @param adType the value for t_ad.ad_type
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public void setAdType(Byte adType) {
        this.adType = adType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ad.ad_state
     *
     * @return the value of t_ad.ad_state
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public Byte getAdState() {
        return adState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ad.ad_state
     *
     * @param adState the value for t_ad.ad_state
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public void setAdState(Byte adState) {
        this.adState = adState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ad.created
     *
     * @return the value of t_ad.created
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ad.created
     *
     * @param created the value for t_ad.created
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ad.updated
     *
     * @return the value of t_ad.updated
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ad.updated
     *
     * @param updated the value for t_ad.updated
     *
     * @mbggenerated Fri Feb 21 20:05:06 CST 2020
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
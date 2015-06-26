package com.mjtoolbox.bean;

import java.util.Date;

/**
 * Project: springrest
 * Description:
 * Created by mijo on 2015-06-25.
 */
public class Message {

    private String oid;
    private Long id;
    private String reservoir;
    private String title;
    private String description;
    private Date triggerTime;
    private Date submitTime;
    private String submitBy;
    private String status;


    public Message() {
    }

    public Message(String oid, Long id, String reservoir, String title, String description, Date triggerTime, Date submitTime, String submitBy, String status) {
        this.oid = oid;
        this.id = id;
        this.reservoir = reservoir;
        this.title = title;
        this.description = description;
        this.triggerTime = triggerTime;
        this.submitTime = submitTime;
        this.submitBy = submitBy;
        this.status = status;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReservoir() {
        return reservoir;
    }

    public void setReservoir(String reservoir) {
        this.reservoir = reservoir;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getSubmitBy() {
        return submitBy;
    }

    public void setSubmitBy(String submitBy) {
        this.submitBy = submitBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Message{" +
                "oid='" + oid + '\'' +
                ", id=" + id +
                ", reservoir='" + reservoir + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", triggerTime=" + triggerTime +
                ", submitTime=" + submitTime +
                ", submitBy='" + submitBy + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

package com.gy612.loan.entity;

import java.util.Date;

public class Log {
    private String id;

    private String triggerId;

    private String logFrom;

    private String logType;

    private String logContent;

    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTriggerId() {
        return triggerId;
    }

    public void setTriggerId(String triggerId) {
        this.triggerId = triggerId == null ? null : triggerId.trim();
    }

    public String getLogFrom() {
        return logFrom;
    }

    public void setLogFrom(String logFrom) {
        this.logFrom = logFrom == null ? null : logFrom.trim();
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
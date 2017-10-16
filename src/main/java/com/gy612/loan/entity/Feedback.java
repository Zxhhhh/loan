package com.gy612.loan.entity;

import java.util.Date;

public class Feedback {
    private String id;

    private String feedbackContent;

    private Byte feedbackState;

    private String feedbackAnswer;

    private Date createDate;

    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent == null ? null : feedbackContent.trim();
    }

    public Byte getFeedbackState() {
        return feedbackState;
    }

    public void setFeedbackState(Byte feedbackState) {
        this.feedbackState = feedbackState;
    }

    public String getFeedbackAnswer() {
        return feedbackAnswer;
    }

    public void setFeedbackAnswer(String feedbackAnswer) {
        this.feedbackAnswer = feedbackAnswer == null ? null : feedbackAnswer.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}
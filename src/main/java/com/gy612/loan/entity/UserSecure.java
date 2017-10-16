package com.gy612.loan.entity;

import java.util.Date;

public class UserSecure {
    private String id;

    private String secureMail;

    private String secureQuestion;

    private String secureAnswer;

    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSecureMail() {
        return secureMail;
    }

    public void setSecureMail(String secureMail) {
        this.secureMail = secureMail == null ? null : secureMail.trim();
    }

    public String getSecureQuestion() {
        return secureQuestion;
    }

    public void setSecureQuestion(String secureQuestion) {
        this.secureQuestion = secureQuestion == null ? null : secureQuestion.trim();
    }

    public String getSecureAnswer() {
        return secureAnswer;
    }

    public void setSecureAnswer(String secureAnswer) {
        this.secureAnswer = secureAnswer == null ? null : secureAnswer.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
package com.ydb.enums;

import lombok.Data;

/**
 * Created by ligeng on 17/1/18.
 */
public enum IssueType {
    square("square","首页和广场发的帖子"),
    question("question","提问"),
    feedback("feedback","反馈");
    private IssueType(String value,String comment){
        this.value = value;
        this.comment = comment;
    }

    private String value;
    private String comment;
    public String getValue(){
        return this.value;
    }
    public String getComment(){
        return this.comment;
    }
}

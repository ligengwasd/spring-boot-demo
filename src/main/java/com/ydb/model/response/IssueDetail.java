package com.ydb.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * Created by ligeng on 17/1/17.
 */
@Data
public class IssueDetail {
    private String uid;
    private String content;
    @JsonIgnore
    private String feedback;
}

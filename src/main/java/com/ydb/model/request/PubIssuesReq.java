package com.ydb.model.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * Created by ligeng on 16/11/30.
 */
@Data
public class PubIssuesReq {
    @NotEmpty
    private String tokenKey;
    @NotEmpty
    private String type;
    private String title;
    private String content;
    private String feedback;
    private String isAnonyMous;
    private String images;
//    private String audios;
    private String invited;
    private Long teamID;
    private String isSync;
//    private String addition_activity;
//    private String addition_team;
    private String questioner;
    private Long shareUserID;
    private Long additionActivityId;
    private Long additionTeamId;

    // 后台添加的帖子时候用到的参数
    private Date createTime;
    private int praiseNum = 0;
    private int collectNum = 0;
    private int readNum = 0;
    private String tags;
}

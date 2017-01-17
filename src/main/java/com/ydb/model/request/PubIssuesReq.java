package com.ydb.model.request;

import com.ydb.enums.IssueType;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.StringUtils;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by ligeng on 16/11/30.
 */
@Data
public class PubIssuesReq {
    @NotEmpty(message = "2001")
    private String tokenKey;
    @NotNull(message = "3001")
    private IssueType type;
    private String title;
    @Length(max = 10, min = 2, message = "3002")
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

    @AssertTrue(message = "1002")
    private boolean getMixed(){
        if (type == IssueType.feedback){
            return !StringUtils.isEmpty(feedback);
        }
        if (type == IssueType.square){
            return !StringUtils.isEmpty(content);
        }
        return true;
    }

}

package com.ydb.entity.mysql;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ligeng on 17/9/20.
 */
@Entity
@Table(name = "feed")
@Data
public class Feed extends BaseEntity{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "content_id")
    private String contentId;
    @Column(name = "content_publish_time")
    private Date contentPublishTime;
    @Column(name = "have_read")
    private boolean haveRead = false;

//    private String remark;
//    @Column(name = "update_time")
//    private Date updateTime;
//    @Column(name = "create_time")
//    private Date createTime;
}

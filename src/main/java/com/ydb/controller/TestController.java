package com.ydb.controller;

import com.ydb.entity.mysql.Feed;
import com.ydb.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by ligeng on 17/1/15.
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private FeedRepository feedRepository;

    @GetMapping("index")
    public String index(){
//        Issue issue = new Issue();
//        issue.setUID(UUID.randomUUID().toString());
//        issueMapper.insert(issue);
        List<Feed> feedList = new ArrayList<>();
        for (int i= 0; i< 90000000L; i++){
            feedList.add(getFeed());
            if (!feedList.isEmpty() && feedList.size()%10000 == 0){
                feedRepository.save(feedList);
                feedList.clear();
            }
        }
        return "这是测试主页";
    }

    public Feed getFeed(){
        int userId = new Random().nextInt(10000000);
        String conetntId = new Random().nextInt(300000)+"";
        Feed feed = new Feed();
        feed.setUserId(new Long(userId));
        feed.setContentId(conetntId);
        feed.setContentPublishTime(randomDateBetweenMinAndMax());
        feed.setCreateTime(new Date());
        feed.setHaveRead(false);
        feed.setUpdateTime(new Date());
        return feed;
    }

    public static Date randomDateBetweenMinAndMax(){
        Calendar calendar = Calendar.getInstance();
        //注意月份要减去1
        calendar.set(2013,11,31);
        calendar.getTime().getTime();
        //根据需求，这里要将时分秒设置为0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND,0);
        long min = calendar.getTime().getTime();;
        calendar.set(2017,11,31);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.getTime().getTime();
        long max = calendar.getTime().getTime();
        //得到大于等于min小于max的double值
        double randomDate = Math.random()*(max-min)+min;
        //将double值舍入为整数，转化成long类型
        calendar.setTimeInMillis(Math.round(randomDate));
        return calendar.getTime();
    }
}

package com.ydb.controller;

import com.ydb.entity.nochange.Issue;
import com.ydb.mapper.nochange.IssueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by ligeng on 17/1/15.
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private IssueMapper issueMapper;

    @GetMapping("index")
    public String index(){
        Issue issue = new Issue();
        issue.setUID(UUID.randomUUID().toString());
        issueMapper.insert(issue);
        return "这是测试主页";
    }
}

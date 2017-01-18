package com.ydb.controller;

import com.ydb.entity.nochange.Issue;
import com.ydb.mapper.IssueMapper;
import com.ydb.model.request.PubIssuesReq;
import com.ydb.model.response.BaseResModel;
import com.ydb.model.response.IssueDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by ligeng on 17/1/17.
 */

@RestController
@RequestMapping("/issue")
public class IssueController {
    @Autowired
    private IssueMapper issueMapper;

    @GetMapping("/{id}")
    public IssueDetail getIssueById(@PathVariable String id){
        IssueDetail data = new IssueDetail();
        Issue issue = issueMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(issue, data);
        return data;
    }

    @PostMapping
    public BaseResModel pubIssue(@Valid @RequestBody PubIssuesReq req , BindingResult validResult){
        return new BaseResModel(1000);
    }
}

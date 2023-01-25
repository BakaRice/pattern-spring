package com.ricemarch.patternspring.service;

import com.ricemarch.patternspring.handler.SuggestRequirementHandleProcess;
import com.ricemarch.patternspring.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private SuggestRequirementHandleProcess suggestRequirementHandleProcess;

    public List<String> suggestRequirement(String username) {
        // 获取用户信息，因为用户已经登录了，那么user的信息是保存在我们的缓存里面的。

        UserInfo userInfo = getUserInfo(username);
        List<String> results = new ArrayList<>();
        suggestRequirementHandleProcess.process(userInfo, results);
        return results;
    }


    //这部分是需要查询缓存的 （如果缓存没有，是需要查库的）
    //为了书写简便，模拟在service中
    private UserInfo getUserInfo(String username) {
        return new UserInfo();
    }
}

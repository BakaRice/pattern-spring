package com.ricemarch.patternspring.handler;

import com.ricemarch.patternspring.pojo.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class NewCheckHandler extends AbstractSuggestRequirementHandle {
    @Override
    public void processHandler(UserInfo userInfo, List<String> suggestLists) {
        boolean newUser = userInfo.isNewUser();
        if (newUser) {
            // 特定的新用户奖励
            suggestLists = new ArrayList<>();
        } else {
            // 老用户

        }

    }
}

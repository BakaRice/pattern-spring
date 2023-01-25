package com.ricemarch.patternspring.handler;

import com.ricemarch.patternspring.pojo.UserInfo;

import java.util.List;

public class PersonalCheckHandler extends AbstractSuggestRequirementHandle {
    @Override
    public void processHandler(UserInfo userInfo, List<String> suggestLists) {
        // 通过个人逻辑的check，我们找到了 4个 可以投放的业务，放在suggestLists中。
        suggestLists.add("1");
        suggestLists.add("2");
        suggestLists.add("3");
        suggestLists.add("4");
    }
}

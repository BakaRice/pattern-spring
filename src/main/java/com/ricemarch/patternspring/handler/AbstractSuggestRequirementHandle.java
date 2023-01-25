package com.ricemarch.patternspring.handler;

import com.ricemarch.patternspring.pojo.UserInfo;

import java.util.List;

public abstract class AbstractSuggestRequirementHandle {

    public abstract void processHandler(UserInfo userInfo, List<String> suggestLists);
}

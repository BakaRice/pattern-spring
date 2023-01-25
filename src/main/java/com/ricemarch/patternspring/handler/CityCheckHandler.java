package com.ricemarch.patternspring.handler;

import com.ricemarch.patternspring.pojo.UserInfo;

import java.util.List;

public class CityCheckHandler extends AbstractSuggestRequirementHandle {
    @Override
    public void processHandler(UserInfo userInfo, List<String> suggestLists) {
        // 通过获取userInfo的city属性
        String city = userInfo.getCity();

        // 通过city 和 之前保留的4个业务信息进行对比，然后筛选出剩余的 3个业务投放
        suggestLists.remove("1");
    }
}

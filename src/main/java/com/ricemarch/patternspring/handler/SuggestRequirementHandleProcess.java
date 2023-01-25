package com.ricemarch.patternspring.handler;

import com.ricemarch.patternspring.pojo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class SuggestRequirementHandleProcess {


    @Value("#{'${suggest.requirement.handler}'.split(',')}")
    private List<String> handlers;

    public void process(UserInfo userInfo, List<String> suggestLists) {
        // 如果想要实时的进行顺序的调整或者增减，那必须要使用配置中心进行配置
        log.info("{}", handlers.toArray());
        for (String handler : handlers) {
            try {
                AbstractSuggestRequirementHandle handle = (AbstractSuggestRequirementHandle) Class.forName(handler).newInstance();
                handle.processHandler(userInfo, suggestLists);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

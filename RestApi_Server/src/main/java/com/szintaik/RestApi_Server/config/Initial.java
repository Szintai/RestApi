package com.szintaik.RestApi_Server.config;

import com.szintaik.RestApi_Server.model.User;
import com.szintaik.RestApi_Server.service.UserService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Component
@Transactional
public class Initial implements ApplicationListener<ContextRefreshedEvent>{

    private final UserService userService;

    public Initial(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(CollectionUtils.isEmpty(userService.findAll())) {
              init();
        }
    }

    private void init() {
        User user=null;

        for (int i=1; i<11; i++){

            user=new User("User"+i);
            userService.save(user);
        }


    }
}

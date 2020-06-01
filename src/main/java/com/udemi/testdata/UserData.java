package com.udemi.testdata;

import com.udemi.models.User;

public interface UserData {

    User newUser = new User()
            .setName("Test User")
            .setEmail("lm"+System.currentTimeMillis()+"@appcreative.net")
            .setPassword("@@test"+System.currentTimeMillis()+"User")
            .setUserLbl("TU");

    User baseUser = new User ("dj_session_id", "ue5va8vru50qk5cxbhy4614u9xbxxpm7");
}

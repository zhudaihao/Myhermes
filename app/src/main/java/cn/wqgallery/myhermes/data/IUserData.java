package cn.wqgallery.myhermes.data;

import xiaofei.library.hermes.annotation.ClassId;

@ClassId("UserData")
public interface IUserData {

    User getUser();

    void setUser(User user);

}

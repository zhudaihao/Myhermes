package cn.wqgallery.myhermes.data;

import cn.wqgallery.myhermes.MyApplication;
import xiaofei.library.datastorage.DataStorageFactory;
import xiaofei.library.datastorage.IDataStorage;
import xiaofei.library.hermes.annotation.ClassId;

@ClassId("UserData")
public class UserData implements IUserData {

    private static final String KEY = "USER_DATA";
    private IDataStorage iDataStorage;
    private static UserData userManage = null;

    //初始化
    private UserData() {
        iDataStorage = DataStorageFactory.getInstance(MyApplication.getInstance(), DataStorageFactory.TYPE_DATABASE);
    }


    //单利
    public static UserData getInstance() {
        if (userManage == null) {
            synchronized (UserData.class) {
                if (userManage == null) {
                    userManage = new UserData();
                }
            }
        }
        return userManage;
    }


    //实现接口方法
    @Override
    public User getUser() {
        return iDataStorage.load(User.class, KEY);
    }

    @Override
    public void setUser(User user) {
        iDataStorage.storeOrUpdate(user, KEY);
    }
}

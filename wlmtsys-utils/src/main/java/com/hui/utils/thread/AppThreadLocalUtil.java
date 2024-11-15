package com.hui.utils.thread;


import com.hui.model.user.po.User;

public class AppThreadLocalUtil {

    private final static ThreadLocal<User> WM_USER_THREAD_LOCAL = new ThreadLocal<>();

    //存入线程中
    public static void setUser(User user){
        WM_USER_THREAD_LOCAL.set(user);
    }

    //从线程中获取
    public static User getUser(){
        return WM_USER_THREAD_LOCAL.get();
    }

    //清理
    public static void clear(){
        WM_USER_THREAD_LOCAL.remove();
    }

}

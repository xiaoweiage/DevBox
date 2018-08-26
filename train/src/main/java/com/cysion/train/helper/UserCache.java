package com.cysion.train.helper;

import android.text.TextUtils;

import com.cysion.baselib.Box;
import com.cysion.baselib.cache.ACache;
import com.cysion.train.entity.UserEntity;

public class UserCache {

    //用户的uid和session
    private String uid = "";
    private String session = "";
    public UserEntity mUserEntity;
    private static volatile UserCache instance;
    public static final String UID = "uid";
    public static final String SESSION = "session";

    private UserCache() {

    }

    public static synchronized UserCache obj() {
        if (instance == null) {
            instance = new UserCache();
        }
        return instance;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String aUid) {
        uid = aUid;
        ACache.get(Box.ctx()).put(UID, uid);
    }

    public String getSession() {
        return session;
    }

    public void setSession(String aSession) {
        session = aSession;
        ACache.get(Box.ctx()).put(SESSION, session);
    }

    public void outCache() {
        uid = ACache.get(Box.ctx()).getAsString(UID);
        session = ACache.get(Box.ctx()).getAsString(SESSION);
    }

    public void clearCache(){
        uid = "";
        session = "";
        ACache.get(Box.ctx()).put(UID, uid);
        ACache.get(Box.ctx()).put(SESSION, session);
    }
    public boolean isLogin(){
        if (TextUtils.isEmpty(session)) {
            return false;
        }
        return true;
    }
}

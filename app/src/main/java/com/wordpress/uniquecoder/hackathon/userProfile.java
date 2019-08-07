package com.wordpress.uniquecoder.hackathon;

public class userProfile {
      public static String userId;
    public static String userName;
    public static String userEmailid;

    public userProfile() {
    }

    public userProfile(String userId, String userName, String userEmailid) {
        this.userId = userId;
        this.userName = userName;
        this.userEmailid = userEmailid;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmailid() {
        return userEmailid;
    }
}


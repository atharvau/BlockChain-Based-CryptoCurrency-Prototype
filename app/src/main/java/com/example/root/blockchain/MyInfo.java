package com.example.root.blockchain;

public class MyInfo {
String uid;
String name;
String profilepicture;

    public MyInfo(String uid, String name, String profilepicture) {
        this.uid = uid;
        this.name = name;
        this.profilepicture = profilepicture;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(String profilepicture) {
        this.profilepicture = profilepicture;
    }
}

package com.example.h20;

public class User {
int id;
int mobilenumber;
int deviceid;

    public User(int id, int mobilenumber, int deviceid) {
        this.id = id;
        this.mobilenumber = mobilenumber;
        this.deviceid = deviceid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(int mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public int getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(int deviceid) {
        this.deviceid = deviceid;
    }
}

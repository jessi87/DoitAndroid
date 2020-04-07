package com.android.doitmission13;

public class Person {
    String name;
    String birthday;
    String mobile;

    public Person(String name, String birthday, String mobile) {
        this.name = name;
        this.birthday = birthday;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

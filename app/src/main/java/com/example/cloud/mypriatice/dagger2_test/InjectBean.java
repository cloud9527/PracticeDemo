package com.example.cloud.mypriatice.dagger2_test;

import javax.inject.Inject;

/**
 * Created by Cloud on 2017/5/26.
 */

public class InjectBean {
    String mName;
    String mAddress;

    @Inject
    public InjectBean(String name, String address) {
        mName = name;
        mAddress = address;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }
}

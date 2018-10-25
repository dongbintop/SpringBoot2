package com.dongbin.springboot2;


public class Demo {

    private String id;

    private boolean success = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Demo(String id) {
        this.id = id;
    }
}

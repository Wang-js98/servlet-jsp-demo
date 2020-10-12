package com.qst.pojo;

public class WorkPlan {
    private String c_name;

    public WorkPlan() {
    }

    public WorkPlan(String c_name) {
        this.c_name = c_name;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    @Override
    public String toString() {
        return "WorkPlan{" +
                "c_name='" + c_name + '\'' +
                '}';
    }
}

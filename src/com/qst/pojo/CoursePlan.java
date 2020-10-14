package com.qst.pojo;

public class CoursePlan {
    private String c_name;
    private String t_name;
    private String c_name1;

    public CoursePlan(){

    }

    public CoursePlan(String c_name,String t_name,String c_name1){
        this.c_name=c_name;
        this.t_name=t_name;
        this.c_name1=c_name1;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getC_name1() {
        return c_name1;
    }

    public void setC_name1(String c_name1) {
        this.c_name1 = c_name1;
    }

    @Override
    public String toString() {
        return "StudentPlan{" +
                "c_name='" + c_name + '\'' +
                ", t_name='" + t_name + '\'' +
                ", c_name1='" + c_name1 + '\'' +
                '}';
    }
}

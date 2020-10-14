package com.qst.pojo;

public class ScorePlan {
    private String c_name;
    private Integer daily_work;
    private Integer exam_results;
    private Integer total_mark;

    public ScorePlan(){

    }

    public ScorePlan(String c_name,Integer daily_work,Integer exam_results,Integer total_mark){
        this.c_name=c_name;
        this.daily_work=daily_work;
        this.exam_results=exam_results;
        this.total_mark=total_mark;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public Integer getDaily_work() {
        return daily_work;
    }

    public void setDaily_work(Integer daily_work) {
        this.daily_work = daily_work;
    }

    public Integer getExam_results() {
        return exam_results;
    }

    public void setExam_results(Integer exam_results) {
        this.exam_results = exam_results;
    }

    public Integer getTotal_mark() {
        return total_mark;
    }

    public void setTotal_mark(Integer total_mark) {
        this.total_mark = total_mark;
    }

    @Override
    public String toString() {
        return "ScorePlan{" +
                "c_name='" + c_name + '\'' +
                ", daily_work=" + daily_work +
                ", exam_results=" + exam_results +
                ", total_mark=" + total_mark +
                '}';
    }
}

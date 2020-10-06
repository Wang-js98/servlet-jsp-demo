package com.qst.pojo;

public class Teacher {
    private Integer t_id;
    private String userName;
    private String t_name;
    private Integer age;
    private Integer sex;
    private String education;
    private Integer course_id;

    public Teacher() {
    }

    public Teacher(Integer t_id, String userName, String t_name, Integer age, Integer sex, String education, Integer course_id) {
        this.t_id = t_id;
        this.userName = userName;
        this.t_name = t_name;
        this.age = age;
        this.sex = sex;
        this.education = education;
        this.course_id = course_id;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "t_id=" + t_id +
                ", userName='" + userName + '\'' +
                ", t_name='" + t_name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education='" + education + '\'' +
                ", course_id=" + course_id +
                '}';
    }
}

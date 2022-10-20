package com.example.anniversary_backend.pojo;

import java.sql.Date;

public class Student {
    private int stu_id;
    private String stu_name;
    private double distance;
    private String date;

    public int getStuID() {
        return stu_id;
    }

    public void setStuID(int stuID) {
        this.stu_id = stuID;
    }

    public String getStuName() {
        return stu_name;
    }

    public void setStuName(String stuName) {
        this.stu_name = stuName;
    }

    public double getStuDistance() {
        return distance;
    }

    public void setStuDistance(double stuDistance) {
        this.distance = stuDistance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return this.stu_name+" "+this.stu_id+" "+this.distance;
    }
}

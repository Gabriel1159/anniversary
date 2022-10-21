package com.example.anniversary_backend.pojo;

public class Student {
    private int stu_id;
    private String stu_name;
    private double distance;
    private String date;
    private int status;   //0 未贡献， 1 已贡献

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.stu_name+" "+this.stu_id+" "+this.distance;
    }
}

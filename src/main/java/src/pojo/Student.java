package src.pojo;

public class Student {
    private int stuID;
    private String stuName;
    private double stuDistance;

    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public double getStuDistance() {
        return stuDistance;
    }

    public void setStuDistance(double stuDistance) {
        this.stuDistance = stuDistance;
    }

    @Override
    public String toString() {
        return this.stuName+" "+this.stuID+" "+this.stuDistance;
    }
}

package com.example.anniversary_backend.mapper;

import com.example.anniversary_backend.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface TableMapper {

    ArrayList<Student> getAllRecords();

    double sumAllRecords();

    ArrayList<Student> sumGivenRecords();

    int giveDistance(String stuID);

    Student queryRecordByID(String stuID);

    void setTime(String stuID, String time);
}

package com.example.anniversary_backend.mapper;

import com.example.anniversary_backend.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataInputMapper {
    void addRecord(Student s);
}

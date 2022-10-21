package com.example.anniversary_backend.service;

import com.example.anniversary_backend.mapper.DataInputMapper;
import com.example.anniversary_backend.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataInputService {
    @Autowired
    DataInputMapper dataInputMapper;
    public int inputData(ArrayList<Student> students) {
        try {
            for(Student s:students)
            {
                dataInputMapper.addRecord(s);
            }
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}

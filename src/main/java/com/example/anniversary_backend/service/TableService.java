package com.example.anniversary_backend.service;

import com.example.anniversary_backend.mapper.TableMapper;
import com.example.anniversary_backend.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TableService {
    @Autowired
    private TableMapper tableMapper;
    public ArrayList<Student> getAllRecords() {
        try {
            return tableMapper.getAllRecords();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

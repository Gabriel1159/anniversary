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
    public double sumAllRecords()
    {
        try {
            return tableMapper.sumAllRecords();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public double sumGivenRecords()
    {
        try {
            double res = 0;
            ArrayList<Student> ret = tableMapper.sumGivenRecords();
            for(int i=0;i<ret.size();i++)
            {
                res += ret.get(i).getStuDistance();
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int giveDistance(String stuID, String time) {
        try {
            tableMapper.setTime(stuID, time);
            return tableMapper.giveDistance(stuID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Student queryRecordByID(String stuID) {
        try {
            Student ret = tableMapper.queryRecordByID(stuID);
            if(ret==null)
            {
                ret = new Student();
                ret.setStatus(-1);
                return ret;
            }
            else
            {
                return ret;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

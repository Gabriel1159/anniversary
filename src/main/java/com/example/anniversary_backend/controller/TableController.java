package com.example.anniversary_backend.controller;

import com.example.anniversary_backend.pojo.Student;
import com.example.anniversary_backend.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

@RestController
public class TableController {
    @Autowired
    TableService tableService;
    static class MyComparator1 implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return -Double.compare(s1.getStuDistance(), s2.getStuDistance());
        }
    }
    static class MyComparator2 implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            System.out.println(s1.getDate());
            System.out.println(s2.getDate());
            return -s1.getDate().compareTo(s2.getDate());
        }
    }

    @RequestMapping(value = "/getTopTenRecords",method = RequestMethod.POST)
    public ArrayList<Student> getTopTenRecords()
    {
        ArrayList<Student> ret = new ArrayList<>();
        ret = tableService.getAllRecords();
        MyComparator1 comparator_1 = new MyComparator1();
        ret.sort(comparator_1);
        if(ret.size()>10)
        {
            ret = (ArrayList<Student>) ret.subList(0, 9);
        }
        return ret;
    }

    @RequestMapping(value = "/getRecentTenRecords",method = RequestMethod.POST)
    public ArrayList<Student> getRecentTenRecords()
    {
        ArrayList<Student> ret = new ArrayList<>();
        ret = tableService.getAllRecords();
        MyComparator2 comparator_2 = new MyComparator2();
        ret.sort(comparator_2);
        if(ret.size()>10)
        {
            ret = (ArrayList<Student>) ret.subList(0, 9);
        }
        return ret;
    }

    @RequestMapping(value = "/getPercentage", method = RequestMethod.POST)
    public double getPercentage()
    {
        double totalDistance = tableService.sumAllRecords();
        double givenDistance = tableService.sumGivenRecords();
        DecimalFormat decimalFormat = new DecimalFormat("0.000");
        double ret = givenDistance/totalDistance;
        return Double.parseDouble(decimalFormat.format(ret));
    }

    @RequestMapping(value = "/giveDistance", method = RequestMethod.POST)
    public int giveDistance(int stuID)
    {
        Date date = new Date();
        SimpleDateFormat myformat = new SimpleDateFormat("yyyyMMddHHmmss");
        return tableService.giveDistance(stuID, myformat.format(date));
    }

    @RequestMapping(value = "/queryRecordByID", method = RequestMethod.POST)
    public Student queryRecordByID(int stuID)
    {
        return tableService.queryRecordByID(stuID);
    }

}

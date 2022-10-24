package com.example.anniversary_backend.controller;

import com.example.anniversary_backend.pojo.Student;
import com.example.anniversary_backend.service.DataInputService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@Controller
@CrossOrigin
public class DataInputController {
    @Autowired
    DataInputService dataInputService;

    @RequestMapping(value = "/inputData", method = RequestMethod.GET)
    @ResponseBody
    public int inputData() {
        ArrayList<Student> students = new ArrayList<>();
        String path = "E:\\个人事务\\校庆院庆网站\\信息统计demo.xls";
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(path);
            Workbook workbook = null;
            if (path.substring(path.lastIndexOf(".")).equals(".xls")) {
                workbook = new HSSFWorkbook(inputStream);
            } else if (path.substring(path.lastIndexOf(".")).equals(".xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
            }
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);
                Student s = new Student();
                s.setStuID((int) row.getCell(0).getNumericCellValue());
                s.setStuName(row.getCell(1).getStringCellValue());
                s.setStuDistance(row.getCell(2).getNumericCellValue());
                s.setStatus(0);
                if(s.getStuDistance()!=0)
                {
                    students.add(s);
                }
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataInputService.inputData(students);
    }
}

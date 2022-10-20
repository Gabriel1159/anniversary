package src.util;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import src.pojo.Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DataInputer {
    private ArrayList<Student> students = new ArrayList<Student>();
    public boolean inputData(String path)
    {
        try
        {
            InputStream is = new FileInputStream(path);
            Workbook wb = null;
            String suffix = path.substring(path.lastIndexOf("."));
//            System.out.println(suffix);
            if (suffix.equals(".xls"))
            {
                wb = new HSSFWorkbook(is);
            }
            else if (suffix.equals(".xlsx"))
            {
                wb = new XSSFWorkbook(is);
            }
            assert wb != null;
            Sheet sheet = wb.getSheetAt(0);
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);
                Student s = new Student();
                s.setStuID((int)row.getCell(0).getNumericCellValue());
                s.setStuName(row.getCell(1).getStringCellValue());
                s.setStuDistance(row.getCell(2).getNumericCellValue());
                students.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Student s:students)
        {
            System.out.println(s.toString());
        }
        return true;
    }

    public static void main(String[] args) {
        DataInputer dataInputer = new DataInputer();
        dataInputer.inputData("E:\\个人事务\\校庆院庆网站\\信息统计demo.xls");
    }
}

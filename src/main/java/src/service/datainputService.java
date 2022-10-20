package src.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.mapper.datainputMapper;
import src.pojo.Student;

import java.util.ArrayList;

@Service
public class datainputService {
    @Autowired
    private datainputMapper dm;
    public void addStudents(ArrayList<Student> students)
    {
        try {
            for(Student s:students)
            {
                dm.addStudent(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

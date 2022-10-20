package src.mapper;

import org.apache.ibatis.annotations.Mapper;
import src.pojo.Student;

import java.util.ArrayList;
@Mapper
public interface datainputMapper {
    void addStudent(Student s);
}

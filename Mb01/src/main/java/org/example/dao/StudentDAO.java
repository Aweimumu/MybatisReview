package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.domain.Student;

import java.util.List;

public interface StudentDAO {
    public  int insertStudent(Student student);
    public int deleteStudent(String stuNum);
    public int updateStudent(Student student);
    public List<Student> listStudentList();
    public List<Student> listStudents(@Param("start") int start,@Param("pageSize") int pageSize);
    public int getCount();

}

package org.example.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Student;
import org.example.utils.MybatisUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentDAOTest extends TestCase {

    public void testInsertStudent() {
        try {
            InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = builder.build(is);
            SqlSession sqlSession = build.openSession(true);
            StudentDAO mapper = sqlSession.getMapper(StudentDAO.class);
            Student student = new Student(0, "10006", "张三", "M", 18);
            int i = mapper.insertStudent(student);
            System.out.println(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void testDeleteStudent() throws IOException {
        InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(is);
        SqlSession sqlSession = build.openSession(true);
        StudentDAO mapper = sqlSession.getMapper(StudentDAO.class);
        int i = mapper.deleteStudent("10001");
        System.out.println(i);
    }

    public void testUpdateStudent() throws IOException {
        InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(is);
        SqlSession sqlSession = build.openSession(true);
        StudentDAO mapper = sqlSession.getMapper(StudentDAO.class);
        Student student = new Student(1, "10001", "张三", "M", 20);
        int i = mapper.updateStudent(student);
        System.out.println(i);
    }

    public void testListStudentList() throws IOException {
        InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(is);
        SqlSession sqlSession = build.openSession(true);
        StudentDAO mapper = sqlSession.getMapper(StudentDAO.class);
        List<Student> students = mapper.listStudentList();
        System.out.println(students);
    }
    @Test
   public void testListStudentByPage(){
        StudentDAO mapper = MybatisUtil.getMapper(StudentDAO.class);
        PageHelper.startPage(2,4);
        List<Student> students = mapper.listStudentList();
        PageInfo<Student> studentPageInfo = new PageInfo<>(students);
        List<Student> list = studentPageInfo.getList();
        System.out.println(list);
    }
}

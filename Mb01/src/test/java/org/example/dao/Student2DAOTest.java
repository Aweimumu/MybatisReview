package org.example.dao;

import junit.framework.TestCase;
import org.example.domain.Clazz;
import org.example.domain.Student2;
import org.example.utils.MybatisUtil;

import java.util.List;

public class Student2DAOTest extends TestCase {

    public void testQueryStudents() {
        ClazzDAO mapper = MybatisUtil.getMapper(ClazzDAO.class);
        Clazz clazz = mapper.queryClazz(1);
        System.out.println(clazz);
    }
}
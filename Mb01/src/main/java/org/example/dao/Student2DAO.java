package org.example.dao;

import org.example.domain.Student2;

import java.util.List;

public interface Student2DAO {
    List<Student2> queryStudents(int stuCid);
}

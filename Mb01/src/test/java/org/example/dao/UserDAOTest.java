package org.example.dao;

import junit.framework.TestCase;
import org.example.domain.User;
import org.example.utils.MybatisUtil;

public class UserDAOTest extends TestCase {

    public void testInsertUser() {
    }

    public void testQueryUser() {
        UserDAO mapper = MybatisUtil.getMapper(UserDAO.class);
        User a2wasd324ei = mapper.queryUser("a2wasd324ei");
        System.out.println(a2wasd324ei);
    }
}
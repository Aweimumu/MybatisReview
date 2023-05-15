package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.domain.Clazz;
import org.example.domain.Detail;
import org.example.domain.Member;
import org.example.domain.User;
import org.example.utils.MybatisUtil;

public class Test {
    @org.junit.Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        User user = new User(0, "a2wasd324ei", "111132421", "tan342wei", "13242.png", null);
        Detail detail = new Detail(0, "cq3242", "1212234212", "aw342ei", 23);
        try {
            UserDAO mapper = sqlSession.getMapper(UserDAO.class);
            int i = mapper.insertUser(user);
            detail.setUserId(user.getUserId());
            DetailDAO mapper1 = sqlSession.getMapper(DetailDAO.class);
            int i1 = mapper1.insertDetail(detail);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
    }
    @org.junit.Test
    public void testCache(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        MemberDAO mapper = sqlSession.getMapper(MemberDAO.class);
        Member member = mapper.queryMemberById(1);
        System.out.println(member);
        sqlSession.clearCache();
        MemberDAO mapper2 = sqlSession.getMapper(MemberDAO.class);
        Member member2 = mapper2.queryMemberById(1);
        System.out.println(member2);
    }
    @org.junit.Test
    public void testSecondCache(){
        SqlSessionFactory factory = MybatisUtil.getFactory();
        SqlSession sqlSession = factory.openSession(true);
        SqlSession sqlSession1 = factory.openSession(true);
        System.out.println(sqlSession1==sqlSession1);
        MemberDAO mapper = sqlSession.getMapper(MemberDAO.class);
        Member member = mapper.queryMemberById(1);
        System.out.println(member);
        member.setMemberAge(29);
        sqlSession.commit();
        MemberDAO mapper1 = sqlSession1.getMapper(MemberDAO.class);
        Member member1 = mapper1.queryMemberById(1);
        System.out.println(member1);
    }
    @org.junit.Test
    public void testLazy(){
        ClazzDAO mapper = MybatisUtil.getMapper(ClazzDAO.class);
        Clazz clazz = mapper.queryClazz(3);
        System.out.println(clazz.getClassName());
        System.out.println("-------------");
        System.out.println(clazz.getStus());
    }
}

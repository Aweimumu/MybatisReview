package org.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
public class MybatisUtil {
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> local=new ThreadLocal<SqlSession>();
    static {
        try {
            InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory=builder.build(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static  SqlSessionFactory getFactory(){
        return factory;
    }
    public static SqlSession getSqlSession(boolean isAutoCommit){
        SqlSession sqlSession=local.get();
        if (sqlSession == null){
            sqlSession=factory.openSession(isAutoCommit);
            local.set(sqlSession);
        }
        return sqlSession;
    }
    public static SqlSession getSqlSession(){
        return getSqlSession(false);
    }
    public static <T extends Object> T  getMapper(Class<T> c){
        SqlSession sqlSession = getSqlSession(true);
        return  sqlSession.getMapper(c);
    }
}

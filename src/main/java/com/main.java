package com;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //do work
        List<student> studentList=sqlSession.selectList("selectBlog");
        //结束
        sqlSession.commit();
        sqlSession.close();
        //text
        for(student s:studentList){
            System.out.println(s.getId()+"  "+s.getName()+"  "+s.getBirth());
        }
//        System.out.println("main");
    }
}

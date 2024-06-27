package cn.edcenter;

import cn.edcenter.domain.student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import utils.Uiltbatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {



        SqlSession sqlSession = Uiltbatis.getSqlSession();
        //6.指定要执行的SQL语句的标识。 sql映射文件中的namespace + "." + 标签的id值
        String sqlId = "cn.edcenter.dao.StudentDao.selectStudents";
        //7.执行sql语句，通过sqlId找到语句
        List<student> studentList = sqlSession.selectList(sqlId);
        //8.输出结果
        studentList.forEach(stu -> System.out.println(stu));
        //9.关闭SQLSession对象
        sqlSession.close();
    }
}

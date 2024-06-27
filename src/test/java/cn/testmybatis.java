package cn;

import cn.edcenter.domain.student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testmybatis {
    //测试方法，测试功能
    @Test
    public void testInsert() throws IOException {
//访问mybatis读取student数据
        //1.定义mybatis主配置文件的名称，从类路径的根开始（target/clasess）
        String config = "mybatis.xml";
        //2.读取这个config表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建了SQLSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5.【重要】获取SQLSession对象，从SQL SessionFactory中获取SQLSession
        SqlSession sqlSession = factory.openSession();
        //6.指定要执行的SQL语句的标识。 sql映射文件中的namespace + "." + 标签的id值
        // String sqlId = "cn.edcenter.dao.StudentDao" + "." + "selectStudents";
        String sqlId = "cn.edcenter.dao.StudentDao.insertStudent";
        //7.执行sql语句，通过sqlId找到语句
        student student = new student();
        student.setId(1003);
        student.setName("张飞");
        student.setAge(20);
        student.setGender("难");
        int nums = sqlSession.insert(sqlId, student);
        //8.输出结果
        System.out.println("执行insert的结果=" + nums);
        //mybatis默认不是自动提交事务的，所以在insert，update，delete后要手工提交事务
        sqlSession.commit();
        //9.关闭SQLSession对象
        sqlSession.close();
    }
}

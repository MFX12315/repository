package cn.edcenter.dao;

import cn.edcenter.domain.student;

import java.util.List;

//接口操作student表
public interface StudentDao {
    //查询student表的所有的数据
    public List<student> selectStudents();

//插入方法
    //参数“student，表示要插入到数据库的数据
    //返回值：int，表示执行insert操作后的  影响数据库的行数
    public int insertStudent(student student);
}

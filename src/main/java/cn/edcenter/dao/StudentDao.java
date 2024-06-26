package cn.edcenter.dao;

import cn.edcenter.domain.student;

import java.util.List;

//接口操作student表
public interface StudentDao {
    //查询student表的所有的数据
    public List<student> selectStudents();
}

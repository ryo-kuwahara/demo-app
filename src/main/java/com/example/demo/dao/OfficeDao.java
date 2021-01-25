package com.example.demo.dao;


import com.example.demo.entity.Office;
import com.example.demo.entity.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OfficeDao {
    @Select("SELECT * FROM offices WHERE id = #{id}")
    Office findById(Integer id);
}

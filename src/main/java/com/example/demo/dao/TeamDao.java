package com.example.demo.dao;

import com.example.demo.entity.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface TeamDao {

    @Select("SELECT * FROM teams")
    List<Team> findAll();

    @Select("SELECT * FROM teams WHERE id = #{id}")
    Team findById(Integer id);


}

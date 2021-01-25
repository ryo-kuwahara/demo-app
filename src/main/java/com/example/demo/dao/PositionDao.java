package com.example.demo.dao;

import com.example.demo.entity.Office;
import com.example.demo.entity.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface PositionDao {
    @Select("SELECT * FROM positions")
    List<Position> findAll();

    @Select("SELECT * FROM positions WHERE id = #{id}")
    Position findById(Integer id);
}

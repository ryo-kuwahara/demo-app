package com.example.demo.service;

import com.example.demo.dao.PositionDao;
import com.example.demo.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl {
    private final PositionDao positionDao;

    @Autowired
    PositionServiceImpl(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    List<Position> findAll() {
        List<Position> list = positionDao.findAll();
        return list;
    }

}

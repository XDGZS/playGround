package com.gradproject.playground.mapper;

import com.gradproject.playground.entity.Scenic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScenicMapper {
    public int addScenic(Scenic scenic);
    public List<Scenic> findAll();
    public Scenic findById(int id);
    public int delScenic(int id);
    public int updateScenic(Scenic scenic);
    public int discountScenic(int id);
}

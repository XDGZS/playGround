package com.gradproject.playground.service;

import com.gradproject.playground.entity.Scenic;
import com.gradproject.playground.mapper.ScenicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScenicService {
    @Autowired
    private ScenicMapper scenicMapper;
    private List<Scenic> scenicList;

    public ScenicService() {
        scenicList = new ArrayList<>();
    }

    private void find() {
        scenicList.clear();
        scenicList = scenicMapper.findAll();
    }

    public List<Scenic> findAll() {
        find();
        return scenicList;
    }

    public boolean addScenic(Scenic scenic) {
        int code = scenicMapper.addScenic(scenic);
        return code > 0 ? true : false;
    }

    public boolean updateScenic(Scenic scenic) {
        int code = scenicMapper.updateScenic(scenic);
        return code > 0 ? true : false;
    }

    public boolean delScenic(int id) {
        int code = scenicMapper.delScenic(id);
        return code > 0 ? true : false;
    }
}

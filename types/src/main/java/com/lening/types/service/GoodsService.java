package com.lening.types.service;

import com.github.pagehelper.PageInfo;
import com.lening.types.entity.GoodsBean;

import java.util.List;

public interface GoodsService {
    List<GoodsBean> findAll();

    List<GoodsBean> findAllByName(String gname);

    PageInfo<GoodsBean> findAllConnAndPage(GoodsBean searchEntity, Integer pageNum, Integer pageSize);
}

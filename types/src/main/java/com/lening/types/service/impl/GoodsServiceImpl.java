package com.lening.types.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lening.types.entity.GoodsBean;
import com.lening.types.mapper.GoodsMapper;
import com.lening.types.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsBean> findAll() {
        return goodsMapper.selectAll();
    }

    @Override
    public List<GoodsBean> findAllByName(String gname) {
        return goodsMapper.selectByExample(gname);
    }

    @Override
    public PageInfo<GoodsBean> findAllConnAndPage(GoodsBean searchEntity, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(GoodsBean.class);
        Example.Criteria criteria = example.createCriteria();

        if(searchEntity!=null){
            if(!StringUtils.isEmpty(searchEntity.getGname())){
                criteria.andLike("gname", "%"+searchEntity.getGname()+"%");
            }
        }
        List<GoodsBean> list = goodsMapper.selectByExample(example);
        PageInfo<GoodsBean> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}

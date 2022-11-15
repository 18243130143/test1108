package com.lening.types.controller;

import com.github.pagehelper.PageInfo;
import com.lening.types.entity.GoodsBean;
import com.lening.types.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @GetMapping()
    public List<GoodsBean> findAll() {
        return this.goodsService.findAll();
    }
    @GetMapping("gname")
    public List<GoodsBean> findAllByName(@PathVariable("gname")String gname) {
        return this.goodsService.findAllByName(gname);
    }
    @RequestMapping("/findAllConnAndPage")
    public PageInfo<GoodsBean> findAllConnAndPage(@RequestBody(required = false) GoodsBean searchEntity,
                                                  @RequestParam(defaultValue = "1") Integer pageNum,
                                                  @RequestParam(defaultValue = "2") Integer pageSize){
        return goodsService.findAllConnAndPage(searchEntity,pageNum,pageSize);
    }


}

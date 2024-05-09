package com.gupaoedu.vip.mall.goods.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.goods.model.Brand;

import java.util.List;

/*****
 * @Author: 李梦圆
 * @Description: 云商城项目
 ****/
public interface BrandService extends IService<Brand> {

    /**
     * 根据条件查询品牌列表。
     *
     * @param brand 包含查询条件的Brand对象，可以是部分或全部条件。
     * @return 返回匹配条件的品牌列表，类型为List<Brand>。
     */
    List<Brand> queryList(Brand brand);


    /**
     * 条件分页查询品牌信息。
     *
     * @param brand 包含品牌查询条件的对象，可以为空，用于指定查询的条件。
     * @param currentPage 当前页码，从1开始。
     * @param size 每页显示的数量。
     * @return 返回品牌信息的分页对象，包含当前页的品牌信息列表。
     */
    Page<Brand> queryPageList(Brand brand,Long currentPage,Long size);


}

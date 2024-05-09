package com.gupaoedu.vip.mall.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gupaoedu.vip.mall.goods.mapper.BrandMapper;
import com.gupaoedu.vip.mall.goods.model.Brand;
import com.gupaoedu.vip.mall.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*****
 * @Author: 李梦圆
 * @Description: 云商城项目
 ****/
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper,Brand> implements BrandService {


    @Autowired
    private BrandMapper brandMapper;

    /****
     * 条件查询
     * 根据提供的品牌对象中的name和initial属性作为条件，查询符合条件的所有品牌列表。
     * @param brand 包含查询条件的品牌对象
     * @return 返回品牌列表的集合
     */
    @Override
    public List<Brand> queryList(Brand brand) {
        // 创建条件包装对象
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<Brand>();
        // 根据name属性进行模糊查询
        queryWrapper.like("name",brand.getName());
        // 根据initial属性进行精确查询
        queryWrapper.eq("initial",brand.getInitial());
        // 根据包装好的条件查询品牌列表并返回
        return brandMapper.selectList(queryWrapper);
    }

    /****
     * 条件分页查询
     * 根据提供的品牌对象中的name和initial属性作为条件，进行分页查询符合条件的品牌列表。
     * @param brand 包含查询条件的品牌对象
     * @param currentPage 当前页码
     * @param size 每页显示的数量
     * @return 返回分页后的品牌列表页面对象
     */
    @Override
    public Page<Brand> queryPageList(Brand brand, Long currentPage, Long size) {
        // 创建条件包装对象
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<Brand>();
        // 根据name属性进行模糊查询
        queryWrapper.like("name",brand.getName());
        // 执行分页查询操作并返回分页结果
        return brandMapper.selectPage(new Page<Brand>(currentPage,size),queryWrapper);
    }

}

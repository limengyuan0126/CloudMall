package com.gupaoedu.vip.mall.goods.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.goods.model.Brand;
import com.gupaoedu.vip.mall.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*****
 * @Author: 李梦圆
 * @Description: 云商城项目
 ****/
@RestController
@RequestMapping(value = "/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;


    /**
     * 添加品牌信息
     * @param brand 品牌对象，包含品牌相关的详细信息，通过RequestBody接收前端传来的JSON数据
     * @return 返回操作结果，如果操作成功，则返回一个包含成功标识的RespResult对象
     */
    @PostMapping
    public RespResult add(@RequestBody Brand brand){
        brandService.save(brand);
        return RespResult.ok();
    }


    /**
     * 更新品牌信息
     * @param brand 品牌对象，包含需要更新的品牌信息
     * @return 返回操作结果，如果操作成功，则返回OK
     */
    @PutMapping
    public RespResult update(@RequestBody Brand brand){
        brandService.updateById(brand);
        return RespResult.ok();
    }


    /**
     * 删除指定ID的品牌信息
     *
     * @param id 品牌的唯一标识符，通过路径变量传递
     * @return 返回操作结果，如果删除成功则返回成功响应
     */
    @DeleteMapping("/{id}")
    public RespResult delete(@PathVariable(value = "id") String id) {
        brandService.removeById(id);
        return RespResult.ok();
    }


    /**
     * 条件查询接口
     * 通过传入的Brand对象作为查询条件，获取符合条件的品牌列表。
     *
     * @param brand 包含查询条件的Brand对象，可以通过这个对象的属性来筛选查询结果。
     * @return RespResult<List<Brand>> 包含查询结果的RespResult对象，其中data字段是一个Brand对象列表。
     */
    @PostMapping(value = "/search")
    public RespResult<List<Brand>> queryList(@RequestBody Brand brand){
        List<Brand> brands = brandService.queryList(brand);
        return RespResult.ok(brands);
    }


    /**
     * 条件查询 - 分页查询品牌信息
     *
     * @param page  请求的页码
     * @param size  每页显示的数量
     * @param brand 查询条件对象，包含品牌相关的查询条件
     * @return RespResult<Page<Brand>> 包含查询结果的分页信息，其中RespResult是响应结果的封装类，Page是分页信息的封装类
     */
    @PostMapping(value = "/search/{page}/{size}")
    public RespResult<Page<Brand>> queryPageList(
            @PathVariable(value = "page") Long page,
            @PathVariable(value = "size") Long size,
            @RequestBody Brand brand) {
        Page<Brand> pageInfo = brandService.queryPageList(brand, page, size);
        return RespResult.ok(pageInfo);
    }

}

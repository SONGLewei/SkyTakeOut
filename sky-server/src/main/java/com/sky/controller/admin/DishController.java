package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dish")
@Api(tags = "interfaces of dishs")
@Slf4j
public class DishController {
    @Autowired
    private DishService dishService;

    /**
     * New dish the chain complete of a developement
     * @param dishDTO
     * @return
     */
    @PostMapping
    @ApiOperation("New dish")
    public Result save(@RequestBody DishDTO dishDTO){
        log.info("New dish :{}",dishDTO);
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("dishes page query")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO){
        log.info("dishes page query: {}",dishPageQueryDTO);
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping
    @ApiOperation("Delete dishes")
    public Result delete(@RequestParam List<Long> ids ){
        log.info("Delete dishes : {}" ,ids);
        dishService.deleteBatch(ids);
        return Result.success();
    }
}

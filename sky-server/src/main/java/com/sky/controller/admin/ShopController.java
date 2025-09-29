package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/shop")
@Api(tags = "interface of shop")
@Slf4j
public class ShopController {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * set the status of shopt
     * @param status
     * @return
     */
    @PutMapping("/{status}")
    @ApiOperation("Set the status of shop")
    public Result setStatus(@PathVariable Integer status){
        log.info("set the status of the shop : {} ", status == 1 ? "营业中" : "打样中");
        redisTemplate.opsForValue().set("SHOP_STATUS",status);
        return Result.success();
    }
}

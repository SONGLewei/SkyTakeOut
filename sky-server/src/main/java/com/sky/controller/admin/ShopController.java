package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("shopShopController")
@RequestMapping("/admin/shop")
@Api(tags = "interface of shop")
@Slf4j
public class ShopController {

    @Autowired
    private RedisTemplate redisTemplate;

    public final static String KEY = "SHOP_STATUS";

    /**
     * set the status of shopt
     * @param status
     * @return
     */
    @PutMapping("/{status}")
    @ApiOperation("Set the status of shop")
    public Result setStatus(@PathVariable Integer status){
        log.info("set the status of the shop : {} ", status == 1 ? "营业中" : "打样中");
        redisTemplate.opsForValue().set(KEY,status);
        return Result.success();
    }

    /**
     * Get the status of the shop
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("Get the status of shop")
    public Result<Integer> getStatus(){
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        log.info("Get the status of shop: {}",status==1 ?"营业中" : "打样中" );

        return Result.success(status);
    }
}

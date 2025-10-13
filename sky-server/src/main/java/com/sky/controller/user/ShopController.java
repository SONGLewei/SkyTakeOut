package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("userShopController")
@RequestMapping("/user/shop")
@Api(tags = "interface of shop")
@Slf4j
public class ShopController {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * Get the status of the shop
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("Get the status of shop")
    public Result<Integer> getStatus(){
        Integer status = (Integer) redisTemplate.opsForValue().get("SHOP_STATUS");
        log.info("Get the status of shop: {}",status==1 ?"营业中" : "打样中" );

        return Result.success(status);
    }
}

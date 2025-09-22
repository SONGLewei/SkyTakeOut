package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {

    /**
     * insert en masse flavor data
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * delete dish flavor(if have) by dish id
     * @param dishId
     */
    @Delete("delete from dish_flavor where dish_id = #{dishId}")
    void deleteByDishId(Long dishId);

    /**
     * delete by dish id
     * @param dishIds
     */
    void deleteByDishIds(List<Long> dishIds);
}

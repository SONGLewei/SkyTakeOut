package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {

    /**
     * insert en masse flavor data
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);
}

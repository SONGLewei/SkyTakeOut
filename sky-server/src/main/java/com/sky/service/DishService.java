package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

public interface DishService {

    /**
     * new dish and flavor
     * @param dishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);

    /**
     * Dishes page query search
     * @param dishPageQueryDTO
     * @return
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * Delete batch of dishes
     * @param ids
     */
    void deleteBatch(List<Long> ids);


    /**
     * search by id
     * @param id
     * @return
     */
    DishVO getByIdWithFlavor(Long id);

    /**
     * update dishes with falvor
     * @param dishDTO
     */
    void updateWithFlavor(DishDTO dishDTO);
}

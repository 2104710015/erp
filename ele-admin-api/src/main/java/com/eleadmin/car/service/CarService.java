package com.eleadmin.car.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.car.entity.Car;
import com.eleadmin.car.param.CarParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-05-14 15:37:43
 */
public interface CarService extends IService<Car> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Car>
     */
    PageResult<Car> pageRel(CarParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Car>
     */
    List<Car> listRel(CarParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return Car
     */
    Car getByIdRel(Integer id);

    List<Car> findAllCars();

    void deleteCar(int id);

    boolean updateCar(Car car);

    boolean addCar(Car car);


}
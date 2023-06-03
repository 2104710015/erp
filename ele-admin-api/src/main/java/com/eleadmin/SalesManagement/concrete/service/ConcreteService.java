package com.eleadmin.SalesManagement.concrete.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.SalesManagement.concrete.entity.Concrete;
import com.eleadmin.SalesManagement.concrete.param.ConcreteParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-06-01 22:05:02
 */
public interface ConcreteService extends IService<Concrete> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Concrete>
     */
    PageResult<Concrete> pageRel(ConcreteParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Concrete>
     */
    List<Concrete> listRel(ConcreteParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return Concrete
     */
    Concrete getByIdRel(Integer id);

    List<ConcreteParam> findAllConcretes();

    boolean updateConcrete(Concrete concrete);

    boolean addConcrete(Concrete concrete);

}

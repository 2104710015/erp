package com.eleadmin.SalesManagement.concrete.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.SalesManagement.concrete.entity.Concrete;
import com.eleadmin.SalesManagement.concrete.param.ConcreteParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-06-01 22:05:02
 */
public interface ConcreteMapper extends BaseMapper<Concrete> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Concrete>
     */
    List<Concrete> selectPageRel(@Param("page") IPage<Concrete> page,
                             @Param("param") ConcreteParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Concrete> selectListRel(@Param("param") ConcreteParam param);

    List<ConcreteParam> findAllConcretes();

    void updateConcrete(Concrete concrete);

    void addConcrete(Concrete concrete);

}

package com.eleadmin.SalesManagement.concrete.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.SalesManagement.concrete.mapper.ConcreteMapper;
import com.eleadmin.SalesManagement.concrete.service.ConcreteService;
import com.eleadmin.SalesManagement.concrete.entity.Concrete;
import com.eleadmin.SalesManagement.concrete.param.ConcreteParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-06-01 22:05:02
 */
@Service
public class ConcreteServiceImpl extends ServiceImpl<ConcreteMapper, Concrete> implements ConcreteService {

    @Autowired
    ConcreteMapper concreteMapper;

    @Override
    public PageResult<Concrete> pageRel(ConcreteParam param) {
        PageParam<Concrete, ConcreteParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Concrete> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Concrete> listRel(ConcreteParam param) {
        List<Concrete> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Concrete, ConcreteParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Concrete getByIdRel(Integer id) {
        ConcreteParam param = new ConcreteParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

    @Override
    public List<ConcreteParam> findAllConcretes() {
        return concreteMapper.findAllConcretes();
    }

    @Override
    public boolean updateConcrete(Concrete concrete) {
        concreteMapper.updateConcrete(concrete);
        System.out.println(concrete.getConcretemarkings());
        return true;
    }

    @Override
    public boolean addConcrete(Concrete concrete) {
        System.out.println(concrete.getConcretemarkings());
        concreteMapper.addConcrete(concrete);
        return true;
    }

}

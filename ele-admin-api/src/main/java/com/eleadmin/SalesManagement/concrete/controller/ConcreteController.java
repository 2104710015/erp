package com.eleadmin.SalesManagement.concrete.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.SalesManagement.concrete.service.ConcreteService;
import com.eleadmin.SalesManagement.concrete.entity.Concrete;
import com.eleadmin.SalesManagement.concrete.param.ConcreteParam;
import com.eleadmin.common.core.web.ApiResult;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.BatchParam;
import com.eleadmin.common.core.annotation.OperationLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 控制器
 *
 * @author EleAdmin
 * @since 2023-06-01 22:05:02
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/concrete/concrete")
public class ConcreteController extends BaseController {
    @Resource
    private ConcreteService concreteService;

    @PreAuthorize("hasAuthority('concrete:concrete:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Concrete>> page(ConcreteParam param) {
        PageParam<Concrete, ConcreteParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(concreteService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(concreteService.pageRel(param));
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findAllConcretes")
    public List<ConcreteParam> list(ConcreteParam param) {
            return concreteService.findAllConcretes();
    }

    @PreAuthorize("hasAuthority('concrete:concrete:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public ApiResult<Concrete> get(@PathVariable("id") Integer id) {
        return success(concreteService.getById(id));
        // 使用关联查询
        //return success(concreteService.getByIdRel(id));
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping("/addConcrete")
    public ApiResult<?> save(@RequestBody Concrete concrete) {
        if (concreteService.addConcrete(concrete)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping("/updateConcrete")
    public ApiResult<?> update(@RequestBody Concrete concrete) {
        if (concreteService.updateConcrete(concrete)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('concrete:concrete:remove')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public ApiResult<?> remove(@PathVariable("id") Integer id) {
        if (concreteService.removeById(id)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

    @PreAuthorize("hasAuthority('concrete:concrete:save')")
    @OperationLog
    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public ApiResult<?> saveBatch(@RequestBody List<Concrete> list) {
        if (concreteService.saveBatch(list)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('concrete:concrete:update')")
    @OperationLog
    @ApiOperation("批量修改")
    @PutMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody BatchParam<Concrete> batchParam) {
        if (batchParam.update(concreteService, "id")) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('concrete:concrete:remove')")
    @OperationLog
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
        if (concreteService.removeByIds(ids)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

}

package com.eleadmin.SalesManagement.concrete.param;

import com.baomidou.mybatisplus.annotation.TableField;
import com.eleadmin.common.core.annotation.QueryField;
import com.eleadmin.common.core.annotation.QueryType;
import com.eleadmin.common.core.web.BaseParam;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询参数
 *
 * @author EleAdmin
 * @since 2023-06-01 22:05:02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "ConcreteParam对象", description = "查询参数")
public class ConcreteParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @QueryField(type = QueryType.EQ)
    private Integer id;

//    @QueryField(type = QueryType.EQ)
//    private Integer orderid;

    @ApiModelProperty(value = "强度等级")
    private String strengthlevel;

    @ApiModelProperty(value = "坍落度")
    private String slump;

    @ApiModelProperty(value = "抗渗等级")
    private String impermeabilitylevel;

    @ApiModelProperty(value = "抗冻等级")
    private String frostresistancelevel;

    @ApiModelProperty(value = "抗硫酸盐等级")
    private String sulfateresistancelevel;

    @ApiModelProperty(value = "抗氯离子等级")
    private String chlorideionresistancelevel;

    @ApiModelProperty(value = "外加剂")
    private String admixture;

    @ApiModelProperty(value = "特殊原材料")
    private String specialrawmaterials;

    @TableField("orderNumber")
    private String ordernumber;

}

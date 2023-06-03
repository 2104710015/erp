package com.eleadmin.SalesManagement.concrete.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 *
 * @author EleAdmin
 * @since 2023-06-01 22:05:02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Concrete对象", description = "")
public class Concrete implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("concreteMarkings")
    private String concretemarkings;

    @ApiModelProperty(value = "强度等级")
    @TableField("Strengthlevel")
    private String strengthlevel;

    @ApiModelProperty(value = "坍落度")
    @TableField("Slump")
    private String slump;

    @ApiModelProperty(value = "抗渗等级")
    @TableField("Impermeabilitylevel")
    private String impermeabilitylevel;

    @ApiModelProperty(value = "抗冻等级")
    @TableField("FrostResistancelevel")
    private String frostresistancelevel;

    @ApiModelProperty(value = "抗硫酸盐等级")
    @TableField("SulfateResistancelevel")
    private String sulfateresistancelevel;

    @ApiModelProperty(value = "抗氯离子等级")
    @TableField("Chlorideionresistancelevel")
    private String chlorideionresistancelevel;

    @ApiModelProperty(value = "外加剂")
    @TableField("Admixture")
    private String admixture;

    @ApiModelProperty(value = "特殊原材料")
    @TableField("Specialrawmaterials")
    private String specialrawmaterials;

}

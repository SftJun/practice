package com.outlook.sftjun.domain.vo

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.hibernate.validator.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Created by yinjun on 20/12/2017
 */
@ApiModel
class PersonVO {

    @ApiModelProperty("年龄")
    @NotNull
    var age: Int? = null

    @ApiModelProperty("ID")
    var id: Long? = null

    @ApiModelProperty("姓名")
    @NotBlank
    @NotNull
    var name: String? = null
}
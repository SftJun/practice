package com.outlook.sftjun.domain.po

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.hibernate.validator.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Created by SftJun on 20/12/2017
 */
@ApiModel
class PersonPO {

    @ApiModelProperty("年龄")
    @NotNull
    var age: Int? = null


    @ApiModelProperty("姓名")
    @NotBlank
    @NotNull
    var name: String? = null
}
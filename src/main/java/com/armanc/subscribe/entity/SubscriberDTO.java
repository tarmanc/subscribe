package com.armanc.subscribe.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@ApiModel()
public class SubscriberDTO {

    @ApiModelProperty(required = true)
    @NotEmpty(message = "Must Enter an User Name")
    @Size(min = 4, max = 16, message = "asd")
    private String userName;

    @ApiModelProperty(allowEmptyValue = true)
    private boolean subs;

    @ApiModelProperty(allowEmptyValue = true)
    private LocalDate subDate = LocalDate.now();

}

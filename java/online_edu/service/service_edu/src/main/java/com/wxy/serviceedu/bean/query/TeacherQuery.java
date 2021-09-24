package com.wxy.serviceedu.bean.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wxy
 * @title: TeacherQuery
 * @description: TODO
 * @date 2021/9/2320:03
 */

@ApiModel(value = "teacher query object")
@Data
public class TeacherQuery {
    @ApiModelProperty(value = "the teacher's name : like %name%")
    private String name;
    @ApiModelProperty(value = "the teacher's level")
    private Integer level;

    // 时间为什么用String?

    @ApiModelProperty(value = "the begin time", example = "2020-01-01 10:10:10")
    private String begin;
    @ApiModelProperty(value = "the end of time", example = "2020-01-01 10:10:10")
    private String end;
}

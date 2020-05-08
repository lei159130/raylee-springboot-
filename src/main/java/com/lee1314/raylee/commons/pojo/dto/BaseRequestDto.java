package com.lee1314.raylee.commons.pojo.dto;

import lombok.Data;

@Data
public class BaseRequestDto {
    private Integer page;
    private Integer limit;
    private Long total;
}

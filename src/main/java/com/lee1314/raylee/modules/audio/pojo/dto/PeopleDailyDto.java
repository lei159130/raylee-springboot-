package com.lee1314.raylee.modules.audio.pojo.dto;

import com.lee1314.raylee.commons.pojo.dto.BaseRequestDto;
import lombok.Data;

@Data
public class PeopleDailyDto extends BaseRequestDto {
    private Integer id;
    private String title;
    private String audioPlayTime;
    private String audioUrl;
    private Integer commentCount;
    private String shareUrl;
    private Integer seminarId;
    private String content;
}

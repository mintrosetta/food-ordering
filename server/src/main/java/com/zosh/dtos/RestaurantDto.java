package com.zosh.dtos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// ทำให้ class ที่ระบุสามารถถูกนำไปฝังไว้กับ entity อื่นได้
// โดยมันจะนำตัวเองเข้าไปกลายเป็นส่วนหนึ่งของ entity นั้น ๆ
@Embeddable 
public class RestaurantDto {
    private String title;

    @Column(length = 1000)
    private List<String> images;

    private String description;
    private Long id;
}

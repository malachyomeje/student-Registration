package com.example.demo.dtos.request;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class StudentUpdateDto {
    private  long id;
    private String name;
    private String email;
    private String phone_no;
}

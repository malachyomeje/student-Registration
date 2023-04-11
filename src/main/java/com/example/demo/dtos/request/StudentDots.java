package com.example.demo.dtos.request;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class StudentDots {


    private String name;
    private String email;
    private String phone_no;
}

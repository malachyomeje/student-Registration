package com.example.demo.dtos.response;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class UpdateResponse<T> {
   private String data;
}

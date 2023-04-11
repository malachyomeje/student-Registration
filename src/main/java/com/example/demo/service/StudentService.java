package com.example.demo.service;

import com.example.demo.dtos.request.StudentDots;
import com.example.demo.dtos.request.StudentUpdateDto;
import com.example.demo.dtos.response.DeleteResponse;
import com.example.demo.dtos.response.RegistrationResponse;
import com.example.demo.dtos.response.UpdateResponse;
import com.example.demo.dtos.response.UserResponse;
import com.example.demo.model.Users;

import java.util.List;

public interface StudentService  {
    RegistrationResponse studentReg(StudentDots studentDots);

    List<Users> fetchAll();
    UserResponse findByMail(String email);

    UserResponse findByMailAndName(String email, String name);

    DeleteResponse deleteUser(Long id);

    UpdateResponse fixUsers (StudentUpdateDto studentUpdateDto);
}

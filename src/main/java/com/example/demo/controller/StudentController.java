package com.example.demo.controller;

import com.example.demo.dtos.request.StudentDots;
import com.example.demo.dtos.request.StudentUpdateDto;
import com.example.demo.dtos.response.DeleteResponse;
import com.example.demo.dtos.response.RegistrationResponse;
import com.example.demo.dtos.response.UpdateResponse;
import com.example.demo.dtos.response.UserResponse;
import com.example.demo.model.Users;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Register")
public class StudentController {
   private final StudentService studentService;

    @PostMapping("rigStudent")
    private RegistrationResponse registerStudents ( @RequestBody StudentDots studentDots){
         return studentService.studentReg(studentDots);
    }

    @GetMapping("/fetchAllStudents" )
    public List<Users> getAllUsers(){
       return studentService.fetchAll();
    }
@GetMapping( "/findByMail")
public UserResponse findbymail(@RequestParam String email){
     return studentService.findByMail(email);
    }

    @GetMapping( "/findByMailAndName")
    public UserResponse findbymailAndName(@RequestParam String email,@RequestParam String name){
        return studentService.findByMailAndName(email,name);
    }

    @DeleteMapping( "/deleteUsers")
   public DeleteResponse deleteUsers( @RequestParam Long id){
        return studentService.deleteUser(id);
   }


    @PutMapping( "/updateUsers")
    public UpdateResponse updateUsers(@RequestBody StudentUpdateDto studentUpdateDto){
        return studentService.fixUsers(studentUpdateDto);
    }
}


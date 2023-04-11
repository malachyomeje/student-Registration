package com.example.demo.service.serviceImpl;

import com.example.demo.dtos.request.StudentDots;
import com.example.demo.dtos.request.StudentUpdateDto;
import com.example.demo.dtos.response.DeleteResponse;
import com.example.demo.dtos.response.RegistrationResponse;
import com.example.demo.dtos.response.UpdateResponse;
import com.example.demo.dtos.response.UserResponse;
import com.example.demo.model.Users;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import com.example.demo.utils.Verifications;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

   public final StudentRepository studentRepository;
   public final String phoneRegex = "^0[789]\\\\d{8}";
@Override
   public RegistrationResponse studentReg(StudentDots studentDots) {
      Optional<Users> users = studentRepository.findByEmail(studentDots.getEmail());

      if (users.isPresent()) {
         return new RegistrationResponse("Student alrady exists");
      } else if (!Verifications.validEmail(studentDots.getEmail())) {
         return new RegistrationResponse("incCorrect email");}

         Users users1 = Users.builder()
                 .phone_no(Verifications.getFormattedNumber(studentDots.getPhone_no()))
                 .email(studentDots.getEmail())
                 .name(studentDots.getName())
                 .build();
         studentRepository.save(users1);


         return new RegistrationResponse("registration sucessful");

}
@Override
public  List<Users> fetchAll(){
   return studentRepository.findAll();
}
@Override
 public UserResponse findByMail(String email){
    Optional<Users> users=studentRepository.findByEmail(email);
    if(users.isPresent())
       return new UserResponse<>(users.get());
    return new UserResponse<>("User with the email is not found");
 }

   @Override
   public UserResponse findByMailAndName(String email, String name){
      Optional<Users> users=studentRepository.findByEmailAndName(email,name);
      if(users.isPresent())
         return new UserResponse<>(users.get());
      return new UserResponse<>("User with the email is not found");
   }

 @Override
 public DeleteResponse deleteUser(Long id){
    Optional< Users> users=studentRepository.findById(id);
    if(users.isPresent()){
       studentRepository.deleteById(id);
    return new DeleteResponse(" user deleted");
    }
    return new DeleteResponse("User with this id is not found");
 }

@Override
 public UpdateResponse fixUsers(StudentUpdateDto studentUpdateDto){
    Optional <Users> users = studentRepository.findById(studentUpdateDto.getId());
    if (users.isPresent()){
        Users updatedUser = users.get();
        if(Verifications.validEmail(studentUpdateDto.getEmail())){
        updatedUser.setEmail(studentUpdateDto.getEmail());
        }else{
            return new UpdateResponse<>("Invalid email supplied");
        }
        updatedUser.setName(studentUpdateDto.getName());
        updatedUser.setPhone_no(studentUpdateDto.getPhone_no());
        studentRepository.save(updatedUser);
        return new UpdateResponse("Updated successfully");
    }
    return new UpdateResponse("User noit found.");
 }
}

package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}



package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}




package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            return userRepository.save(updatedUser);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}




package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}




<div class="panel panel-default">
  <div class="panel-heading">
      <h1 style="text-align: center">Students</h1><br>
      <div class="row" [hidden]="!deleteMessage">
           
                <div class="col-sm-4"></div>
                <div class="col-sm-4">
                        <div class="alert alert-info alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                <strong>Student Data Deleted</strong>
                        </div>
                </div>
                <div class="col-sm-4"></div>
        </div>           
    </div>

  
  <div class="panel-body">
      <table  class="table table-hover table-sm" datatable [dtOptions]="dtOptions"
      [dtTrigger]="dtTrigger"  >
          <thead class="thead-light">
              <tr>
                  <th>Student Name</th>
                  <th>Student Email</th>
                  <th>Student Branch</th>
                  <th>Action</th>
                  
              </tr>
          </thead>
          <tbody>
               <tr *ngFor="let student of students ">
                  <td>{{student.student_name}}</td>
                  <td>{{student.student_email}}</td>
                  <td>{{student.student_branch}}</td>
                  <td><button (click)="deleteStudent(student.student_id)" class='btn btn-primary'><i class="fa fa-futboll-0">Delete</i></button>&nbsp;
                    <button (click)="updateStudent(student.student_id)" class='btn btn-info'
                    data-toggle="modal" data-target="#myModal">Update</button>
                  </td>
                </tr> 
          </tbody><br>
      </table>
  </div>
</div> 

<div class="modal" id="myModal">
        <div class="modal-dialog">
          <div class="modal-content">
                <form [formGroup]="studentupdateform" #updstu (ngSubmit)="updateStu(updstu)">
            <!-- Modal Header -->
            <div class="modal-header">
              <h4 class="modal-title" style="text-align: center">Update Student</h4>
              
            </div>
            
            <!-- Modal body -->
            <div class="modal-body" *ngFor="let student of studentlist " >
                <div [hidden]="isupdated">

                    <input type="hidden" class="form-control"  formControlName="student_id" [(ngModel)]="student.student_id">
                            <div class="form-group">
                                <label for="name">Student Name</label>
                                <input type="text" class="form-control"  formControlName="student_name" [(ngModel)]="student.student_name"  >
                            </div>
                    
                            <div class="form-group">
                                <label for="name">Student Email</label>
                                <input type="text" class="form-control" formControlName="student_email" [(ngModel)]="student.student_email">
                            </div>
                    
                            <div class="form-group">
                                <label for="name">Student Branch</label>
                                  <select class="form-control" formControlName="student_branch" required>                                   
                                    <option value="B-Tech" [selected]="'B-Tech' == student.student_branch">B-Tech</option>
                                    <option value="BCA" [selected]="'BCA' == student.student_branch">BCA</option>
                                    <option value="MCA" [selected]="'MCA' == student.student_branch" >MCA</option>
                                    <option value="M-Tech" [selected]="'M-Tech' == student.student_branch">M-Tech</option>
                                  </select>                               
                            </div>                   
                  </div>  
                  <div [hidden]="!isupdated">
                      <h4>Student Detail Updated!</h4>
                  </div>        
                    
            </div>
            
            <!-- Modal footer -->
            <div class="modal-footer" >
              <button type="submit" class="btn btn-success" [hidden]="isupdated">Update</button>
              <button type="button" class="btn btn-danger" data-dismiss="modal" (click)="changeisUpdate()">Close</button>
            </div>
            
        </form>
          </div>
        </div>
      </div>

package com.test;

//Interface
interface UserService {
 void registerUser(String name, String email);
 void readUsers();
}

//Model
class User {
 private String name;
 private String email;

 User(String name, String email) {
     this.name = name;
     this.email = email;
 }

 public String toString() {
     return "Name: " + name + ", Email: " + email;
 }
}

//Implementation
class UserServiceImpl implements UserService {
 private java.util.List<User> users = new java.util.ArrayList<>();

 public void registerUser(String name, String email) {
     users.add(new User(name, email));
 }

 public void readUsers() {
     for (User user : users) {
         System.out.println(user);
     }
 }
}

//Test
public class userInterface {
 public static void main(String[] args) {
     UserService service = new UserServiceImpl();
     service.registerUser("Ayan", "ayan@example.com");
     service.registerUser("Anik", "anik@example.com");
     service.readUsers();
 }
}
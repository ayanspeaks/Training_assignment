package com.test;

import java.util.Scanner;
import java.util.regex.Pattern;

public class regexValidation {
    static final String EMAIL_REGEX = "^\\S+@\\S+\\.\\S+$";
    static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$";

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        
        if (Pattern.matches(EMAIL_REGEX, email) && Pattern.matches(PASSWORD_REGEX, password)) {
            System.out.println("Registration successful for " + name);
        } else {
            System.out.println("Invalid email or password");
        }
    }
}


# Server Configuration
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/demo_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root

# Hibernate Configuration
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
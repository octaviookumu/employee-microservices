package com.octaviookumu.employeeservice.model;

import com.octaviookumu.employeeservice.entity.Gender;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeCreateRequest {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private Gender gender;

    @Past(message = "birth date needs to be in the past")
    private LocalDate birthDate;

    @PastOrPresent(message = "hire date needs to be in the past or present")
    private LocalDate hireDate;

}

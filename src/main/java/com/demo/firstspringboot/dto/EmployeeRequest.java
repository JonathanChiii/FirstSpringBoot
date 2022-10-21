package com.demo.firstspringboot.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    @NotNull(message = "Employee name cannot be null.")
    private String name;
    @Email(message = "Invalid email address.")
    private String email;
    private String password;
    @Min(0)
    @Max(9999999)
    private int salary;
    //@Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
    //String mobNum;
}

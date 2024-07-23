package com.example.register_form.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDTO {
    @Size(min = 5, max = 45, message = "First Name phải là từ 5 tới 45 ký tự!")
    private String firstName;
    @Size(min = 5, max = 45, message = "Last Name phải là từ 5 tới 45 ký tự!")
    private String lastName;
    @Pattern(regexp = "^[\\w.%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Email không đúng định dạng!")
    private String email;
    @Pattern(regexp = "^(0[3|5|7|8|9])([0-9]{8})$", message = "Số điện thoại không hợp lệ!")
    private String phoneNumber;
    @NotNull(message = "Tuổi không được để trống!")
    @Min(value = 18, message = "Yêu cầu độ tuổi lớn hơn 18!")
    @Max(value = 120, message = "Tuổi không được quá 120!")
    private int age;
}

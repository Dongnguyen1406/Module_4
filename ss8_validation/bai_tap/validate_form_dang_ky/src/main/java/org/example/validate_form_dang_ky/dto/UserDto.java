package org.example.validate_form_dang_ky.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.validate_form_dang_ky.validator.ValidAge;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    
    @NotBlank(message = "Họ không được để trống")
    @Pattern(regexp = "^[A-Za-z ]{5,45}$", message = "Tên phải đúng định dạng. Từ 5 - 45 ký tự")
    private String firstName;
    
    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^[A-Za-z ]{5,45}$", message = "Tên phải đúng định dạng. Từ 5 - 45 ký tự")
    private String lastName;
    
    @Size(min = 10, max = 14, message = "Số điện thoại phải từ 10 - 14 ký tự")
    private String phoneNumber;

    @Past(message = "Ngày sinh phải là trong quá khứ")
    @ValidAge
    private LocalDate dob;
    
    @Email(message = "Email không hợp lệ!")
    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,}$", message = "Email phải đúng định dạng, vd: van@gmail.com")
    private String email; 
}

package com.example.alpersonlogdemo.UserDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {

    @NotBlank(message = "Ad soyad boş ola bilməz")
    private String fullName;

    @Email(message = "Email formatı düzgün deyil")
    @NotBlank(message = "Email boş ola bilmez")
    private String email;

    @Size(min = 6, message = "Şifrə minium 6 simvol olmalıdır")
    private String password;

    @NotBlank(message = "Rol boş qala bilməz")
    private String role; //USER, ADMIN ve s.

}


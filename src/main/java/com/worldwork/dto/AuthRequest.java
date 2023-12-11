package com.worldwork.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AuthRequest {
    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 6, max = 16)
    private String password;
}

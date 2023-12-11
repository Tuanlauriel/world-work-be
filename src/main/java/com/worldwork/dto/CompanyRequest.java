package com.worldwork.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CompanyRequest {
    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 10, max = 15)
    private String phone;

    @NotNull
    private String location;

    @NotNull
    private String website;

    @NotNull
    private String logo;

    @NotNull
    private String businessLicense;
}

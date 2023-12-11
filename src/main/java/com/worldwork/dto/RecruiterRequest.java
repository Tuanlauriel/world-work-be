package com.worldwork.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RecruiterRequest {
    private UserRequest userRequest;
    private CompanyRequest companyRequest;
}

package com.worldwork.controllers;

import com.worldwork.dto.EntityResponse;
import com.worldwork.dto.RecruiterRequest;
import com.worldwork.entities.Company;
import com.worldwork.entities.Role;
import com.worldwork.entities.User;
import com.worldwork.services.AuthService;
import com.worldwork.services.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/recruiters")
@RequiredArgsConstructor
public class RecruiterController {
    private final CompanyService companyService;
    private final AuthService authService;

    @PostMapping
    public ResponseEntity<Object> createRecruiter(@Valid @RequestBody RecruiterRequest recruiterRequest,
                                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return EntityResponse.generateResponse("Invalid request data", HttpStatus.BAD_REQUEST, "Please check information");
        }
        Company company = companyService.createCompany(recruiterRequest.getCompanyRequest());
        User user = authService.createUser(recruiterRequest.getUserRequest(), Role.RECRUITER, company);
        return EntityResponse.generateResponse("Recruiter created successfully", HttpStatus.CREATED, user);
    }
}

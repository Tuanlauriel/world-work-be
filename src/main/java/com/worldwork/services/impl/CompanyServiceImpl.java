package com.worldwork.services.impl;

import com.worldwork.dto.CompanyRequest;
import com.worldwork.entities.Company;
import com.worldwork.repositories.CompanyRepository;
import com.worldwork.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public Company createCompany(CompanyRequest companyRequest) {
        Company company = Company.builder()
                .name(companyRequest.getName())
                .email(companyRequest.getEmail())
                .phone(companyRequest.getPhone())
                .website(companyRequest.getWebsite())
                .location(companyRequest.getLocation())
                .logo(companyRequest.getLogo())
                .business_license(companyRequest.getBusinessLicense())
                .status(false)
                .build();
        return companyRepository.save(company);
    }
}

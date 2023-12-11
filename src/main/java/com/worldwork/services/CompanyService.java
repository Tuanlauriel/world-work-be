package com.worldwork.services;

import com.worldwork.dto.CompanyRequest;
import com.worldwork.entities.Company;

public interface CompanyService {
    Company createCompany(CompanyRequest companyRequest);
}

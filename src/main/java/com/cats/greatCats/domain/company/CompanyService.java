package com.cats.greatCats.domain.company;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Resource
    private CompanyRepository companyRepository;


    public Company getActiveCompanyBy(Integer companyId) {
        return companyRepository.findActiveCompanyBy(companyId, true);
    }

    public void getActiveCompanyBy(String productUpc) {

    }
}

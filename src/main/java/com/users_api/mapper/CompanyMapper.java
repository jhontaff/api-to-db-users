package com.users_api.mapper;

import com.users_api.dto.CompanyDto;
import com.users_api.entity.Company;


public class CompanyMapper {

    public CompanyDto mapToDto(Company company){
        if(company == null){
            return null;
        }
        CompanyDto companyDto = new CompanyDto();
        companyDto.setName(company.getName());
        companyDto.setCatchPhrase(company.getCatchPhrase());
        companyDto.setBs(company.getBs());
        return companyDto;
    }

    public Company mapToEntity(CompanyDto companyDto){
        if(companyDto == null){
            return null;
        }
        Company company = new Company();
        company.setName(companyDto.getName());
        company.setCatchPhrase(companyDto.getCatchPhrase());
        company.setBs(companyDto.getBs());
        return company;
    }
}

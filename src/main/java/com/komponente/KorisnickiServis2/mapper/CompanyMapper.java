package com.komponente.KorisnickiServis2.mapper;

import com.komponente.KorisnickiServis2.domain.Company;
import com.komponente.KorisnickiServis2.dto.CompanyDto;
import com.komponente.KorisnickiServis2.dto.CompanyInformationDto;
import com.komponente.KorisnickiServis2.dto.SearchCompanyDto;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public CompanyInformationDto companyToCompanyInformationDto(Company company)
    {
        CompanyInformationDto companyInformationDto=new CompanyInformationDto();
        companyInformationDto.setId(company.getId());
        companyInformationDto.setCity(company.getCity());
        companyInformationDto.setName(company.getName());
        companyInformationDto.setId_manager(company.getId_manager());
        companyInformationDto.setDescription(company.getDescription());
        return companyInformationDto;

    }

    public SearchCompanyDto companyToSearchCompanyDto(Company company)
    {
        SearchCompanyDto searchCompanyDto=new SearchCompanyDto();
        searchCompanyDto.setCompanyName(company.getName());
        searchCompanyDto.setId(company.getId());
        return searchCompanyDto;
    }
}

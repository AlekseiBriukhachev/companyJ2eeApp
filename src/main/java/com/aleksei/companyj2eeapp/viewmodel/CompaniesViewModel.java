package com.aleksei.companyj2eeapp.viewmodel;

import com.aleksei.companyj2eeapp.beans.CompanyBeans;
import com.aleksei.companyj2eeapp.entities.Company;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

import javax.ejb.EJB;
import javax.ejb.Init;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CompaniesViewModel {
    @Inject
    private CompanyBeans companyBeans;

    private List<Company> companies;

    @Init
    public void init() {
        companies = companyBeans.getAllCompanies();
    }

    public List<Company> getCompanies() {
        return companies;
    }

    @Command(value = "saveCompany")
    @NotifyChange("companies")
    public void createCompany() {
        Company newCompany = new Company();
        companyBeans.createCompany(newCompany);
        companies.add(newCompany);
    }

    @Command(value = "editCompany")
    @NotifyChange("companies")
    public void editCompany(@BindingParam("company") Company company) {
        companyBeans.updateCompany(company);
    }

    @Command(value = "deleteCompany")
    @NotifyChange("companies")
    public void deleteCompany(@BindingParam("company") Company company) {
        companyBeans.deleteCompany(company);
        companies.remove(company);
    }
}

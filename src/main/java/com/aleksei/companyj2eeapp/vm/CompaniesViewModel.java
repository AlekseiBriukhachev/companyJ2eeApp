package com.aleksei.companyj2eeapp.vm;

import com.aleksei.companyj2eeapp.beans.CompanyBeans;
import com.aleksei.companyj2eeapp.entities.Company;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;

import javax.ejb.EJB;
import javax.ejb.Init;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CompaniesViewModel {
    @EJB
    private CompanyBeans companyBeans;

    private List<Company> companies;

    @Init
    public void init() {
        companies = companyBeans.getAllCompanies();
    }

    public List<Company> getCompanies() {
        return companies;
    }

    @Command
    @NotifyChange("companies")
    public void createCompany() {
        Company newCompany = new Company();
        companyBeans.createCompany(newCompany);
        companies.add(newCompany);
    }

    @Command
    @NotifyChange("companies")
    public void editCompany(@BindingParam("company") Company company) {
        companyBeans.updateCompany(company);
    }

    @Command
    @NotifyChange("companies")
    public void deleteCompany(@BindingParam("company") Company company) {
        companyBeans.deleteCompany(company);
        companies.remove(company);
    }
}

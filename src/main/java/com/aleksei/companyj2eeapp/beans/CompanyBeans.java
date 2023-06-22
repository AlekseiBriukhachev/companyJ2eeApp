package com.aleksei.companyj2eeapp.beans;


import com.aleksei.companyj2eeapp.entities.Company;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CompanyBeans {
    @PersistenceContext(name = "CompanyPersistence")
    private EntityManager entityManager;

    public void createCompany(Company company) {
        entityManager.persist(company);
    }

    public void updateCompany(Company company) {
        entityManager.merge(company);
    }

    public void deleteCompany(Company company) {
        Company companyForDelete = entityManager.find(Company.class, company.getId());
        entityManager.remove(companyForDelete);
    }

    public List<Company> getAllCompanies() {
        Query query = entityManager.createQuery("SELECT c FROM Company c");
        return query.getResultList();
    }
    public Company getCompanyById(Company company) {
        return entityManager.find(Company.class, company.getId());
    }
}

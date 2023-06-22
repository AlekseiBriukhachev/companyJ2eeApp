package com.aleksei.companyj2eeapp.beans;


import com.aleksei.companyj2eeapp.entities.Branch;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class BranchBeans {
    @PersistenceContext(name = "CompanyPersistence")
    private EntityManager entityManager;

    public void createBranch(Branch branch) {
        entityManager.persist(branch);
    }

    public void updateBranch(Branch branch) {
        entityManager.merge(branch);
    }

    public void deleteBranch(Branch branch) {
        Branch branchForDelete = entityManager.find(Branch.class, branch.getId());
        entityManager.remove(branchForDelete);
    }

    public List<Branch> getAllBranches() {
        Query query = entityManager.createQuery("SELECT b FROM Branch b");
        return query.getResultList();
    }

    public Branch getBranchById(Long branchId) {
        return entityManager.find(Branch.class, branchId);
    }
}

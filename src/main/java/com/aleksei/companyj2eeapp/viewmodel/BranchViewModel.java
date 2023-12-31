package com.aleksei.companyj2eeapp.viewmodel;

import com.aleksei.companyj2eeapp.beans.BranchBeans;
import com.aleksei.companyj2eeapp.entities.Branch;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

import javax.ejb.EJB;
import javax.ejb.Init;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class BranchViewModel {
    @Inject
    private BranchBeans branchBeans;

    private List<Branch> branches;

    @Init
    public void init() {
        branches = branchBeans.getAllBranches();
    }

    public List<Branch> getBranches() {
        return branches;
    }

    @Command(value = "saveBranch")
    @NotifyChange("branches")
    public void createBranch() {
        Branch newBranch = new Branch();
        branchBeans.createBranch(newBranch);
        branches.add(newBranch);
    }

    @Command(value = "editBranches")
    @NotifyChange("branches")
    public void editBranch(@BindingParam("branch") Branch branch) {
        branchBeans.updateBranch(branch);
    }

    @Command(value = "deleteBranches")
    @NotifyChange("branches")
    public void deleteBranch(@BindingParam("branch") Branch branch) {
        branchBeans.deleteBranch(branch);
        branches.remove(branch);
    }
}

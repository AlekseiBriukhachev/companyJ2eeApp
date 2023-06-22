package com.aleksei.companyj2eeapp.vm;

import com.aleksei.companyj2eeapp.beans.BranchBeans;
import com.aleksei.companyj2eeapp.entities.Branch;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

import javax.ejb.EJB;
import javax.ejb.Init;
import java.util.List;

public class BranchViewModel {
    @EJB
    private BranchBeans branchBeans;

    private List<Branch> branches;

    @Init
    public void init() {
        branches = branchBeans.getAllBranches();
    }

    public List<Branch> getBranches() {
        return branches;
    }

    @Command
    @NotifyChange("saveBranch")
    public void createBranch() {
        Branch newBranch = new Branch();
        branchBeans.createBranch(newBranch);
        branches.add(newBranch);
    }

    @Command
    @NotifyChange("editBranches")
    public void editBranch(@BindingParam("branch") Branch branch) {
        branchBeans.updateBranch(branch);
    }

    @Command
    @NotifyChange("deleteBranches")
    public void deleteBranch(@BindingParam("branch") Branch branch) {
        branchBeans.deleteBranch(branch);
        branches.remove(branch);
    }
}

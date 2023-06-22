package com.aleksei.companyj2eeapp.vm;

import com.aleksei.companyj2eeapp.beans.AddressBeans;
import com.aleksei.companyj2eeapp.entities.Address;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;

import javax.ejb.EJB;
import javax.ejb.Init;
import javax.servlet.annotation.WebServlet;
import java.util.List;

@WebServlet("/address")
public class AddressViewModel extends SelectorComposer<Component> {
    @EJB
    private AddressBeans addressBeans;

    private List<Address> addresses;

    @Init
    public void init() {
        addresses = addressBeans.getAllAddresses();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    @Command
    @NotifyChange("saveAddress")
    public void createAddress() {
        Address newAddress = new Address();
        addressBeans.createAddress(newAddress);
        addresses.add(newAddress);
    }

    @Command
    @NotifyChange("editAddresses")
    public void editAddresses(@BindingParam("address") Address address) {
        addressBeans.updateAddress(address);
    }

    @Command
    @NotifyChange("deleteAddresses")
    public void deleteAddress(@BindingParam("address") Address address) {
        addressBeans.deleteAddress(address);
        addresses.remove(address);
    }
}

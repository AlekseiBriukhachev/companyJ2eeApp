package com.aleksei.companyj2eeapp.viewmodel;

import com.aleksei.companyj2eeapp.beans.AddressBeans;
import com.aleksei.companyj2eeapp.entities.Address;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

import javax.ejb.EJB;
import javax.ejb.Init;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class AddressViewModel {
    @Inject
    private AddressBeans addressBeans;

    private List<Address> addresses;

    @Init
    public void init() {
        addresses = addressBeans.getAllAddresses();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    @Command(value = "saveAddress")
    @NotifyChange("addresses")
    public void createAddress() {
        Address newAddress = new Address();
        addressBeans.createAddress(newAddress);
        addresses.add(newAddress);
    }

    @Command(value = "editAddresses")
    @NotifyChange("addresses")
    public void editAddresses(@BindingParam("address") Address address) {
        addressBeans.updateAddress(address);
    }

    @Command(value = "deleteAddresses")
    @NotifyChange("addresses")
    public void deleteAddress(@BindingParam("address") Address address) {
        addressBeans.deleteAddress(address);
        addresses.remove(address);
    }
}

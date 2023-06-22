package com.aleksei.companyj2eeapp.beans;


import com.aleksei.companyj2eeapp.entities.Address;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Alternative
public class AddressBeans {
    @PersistenceContext(name = "CompanyPersistence")
    private EntityManager entityManager;

    public void createAddress(Address address) {
        entityManager.persist(address);
    }

    public void updateAddress(Address address) {
        entityManager.merge(address);
    }

    public void deleteAddress(Address address) {
        Address addressForDelete = entityManager.find(Address.class, address.getId());
        entityManager.remove(addressForDelete);
    }

    public List<Address> getAllAddresses() {
        Query query = entityManager.createQuery("SELECT a FROM Address a");
        return query.getResultList();
    }

    public Address getAddressById(Long addressId) {
        return entityManager.find(Address.class, addressId);
    }
}

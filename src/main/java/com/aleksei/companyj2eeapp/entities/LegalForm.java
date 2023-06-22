package com.aleksei.companyj2eeapp.entities;

import lombok.*;

public enum LegalForm {
    OOO("Общество с ограниченной ответственностью"),
    IP("Индивидуальный предприниматель"),
    AO("Акционерное общество");

    private String displayName;

    LegalForm(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

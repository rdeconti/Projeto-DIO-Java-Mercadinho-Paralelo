package com.rdeconti.mercadinho.models;

public enum enumStatus {
    ACTIVATED("Ativado"),
    DEACTIVATED("Desativado");

    private final String displayValue;

    private enumStatus(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}

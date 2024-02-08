package com.enviro.assessment.grad001.ThuthukaniMthiyane.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class WithDrawDTO {
    @NotBlank(message = "Name is blank")
    private String name;

    @NotNull(message = "Amount is blank")
    private long amount;
    @NotBlank(message = "Date is blank")
    private String date;
    @NotBlank(message = "BankName is blank")
    private String bankName;
    @NotNull(message = "BankAccountNumber is blank")
    private long bankAccountNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public long getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(long bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }


}

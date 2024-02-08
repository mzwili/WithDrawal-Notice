package com.enviro.assessment.grad001.ThuthukaniMthiyane.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class InvestDTO {

    @NotBlank(message = "Name is blank")
    private String name;

    @NotBlank(message = "Type is blank")
    private String type;
    @NotNull(message = "Amount is blank")
    private long amount;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}

package com.enviro.assessment.grad001.ThuthukaniMthiyane.interfaces;

public interface WithdrawalNoticeService {

    void withdrawalProcess(String productName, Long withdrawalAmount,
                           String date, String bankName, long bankAccountNumber);
    String withdrawalResponse();
}

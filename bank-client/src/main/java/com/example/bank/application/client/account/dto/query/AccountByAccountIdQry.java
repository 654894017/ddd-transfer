package com.example.bank.application.client.account.dto.query;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountByAccountIdQry {

    private Long accountId;

}

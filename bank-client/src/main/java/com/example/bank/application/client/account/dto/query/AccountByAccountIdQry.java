package com.example.bank.application.client.account.dto.query;

import ddd.core.Query;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountByAccountIdQry extends Query {

    private Long accountId;

}

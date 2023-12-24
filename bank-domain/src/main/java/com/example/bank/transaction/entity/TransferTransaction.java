package com.example.bank.transaction.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class TransferTransaction {
	@SuppressWarnings("unused")
	private long id;
	private Long createTime;
	private String fromAccountId;
	private String toAccountId;
	private BigDecimal amount;
	
	public TransferTransaction() {}
	
	public TransferTransaction(String fromAccountId, String toAccountId, BigDecimal amount, Long createTime) {
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
		this.createTime = createTime;
	}
	

	public Long getCreateTime() {
		return createTime;
	}

	public String getFromAccountId() {
		return fromAccountId;
	}

	public String getToAccountId() {
		return toAccountId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

}
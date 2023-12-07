package com.example.bank.web;

import com.example.bank.application.client.ITransferApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransferController {

    private final ITransferApplicationService transferApplicationService;

}

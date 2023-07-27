package com.louie.market.accountservice.controller;

import com.louie.market.accountservice.entity.AccountRequest;
import com.louie.market.accountservice.service.AccountProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  private final AccountProducerService accountProducerService;

  @Autowired
  public AccountController(AccountProducerService accountProducerService) {
    this.accountProducerService = accountProducerService;
  }

  @PostMapping("/accounts")
  public void createAccount(@RequestBody AccountRequest accountRequest) {
    // Xử lý logic tạo mới tài khoản ở đây
    // Sau đó, gửi thông điệp tới Kafka topic "account-topic"
    String message = "New account created: " + accountRequest.getAccountNumber();
    accountProducerService.sendMessage(message);
  }
}
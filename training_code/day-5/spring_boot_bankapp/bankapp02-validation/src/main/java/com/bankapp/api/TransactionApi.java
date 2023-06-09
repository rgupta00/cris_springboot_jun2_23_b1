package com.bankapp.api;

import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/transactions")
public class TransactionApi {

    private AccountService accountService;

    @Autowired
    public TransactionApi(AccountService accountService) {
        this.accountService = accountService;
    }

    //-------------deposit---------------- id, amount to deposit
    @PostMapping("deposit")
    public String deposit( @RequestBody DepositDto depositDto){
        accountService.deposit(depositDto.getId(), depositDto.getAmount());
        return "depositDto to account "+ depositDto.getId()+" is done successfully ";
    }

    //-------------withdraw----------------
    @PostMapping("withdraw")
    public String withdraw(@RequestBody WithdrawDto withdrawDto){
        accountService.withdraw(withdrawDto.getId(), withdrawDto.getAmount());
        return "withdraw to account "+ withdrawDto.getId()+" is done successfully ";
    }
    //-------------transfer----------------
    @PostMapping("transfer")
    public String transfer( @RequestBody TransferDto transferDto){
        accountService.transfer(transferDto.getFromId(), transferDto.getToId(), transferDto.getAmount());
        return "transfer to account "+ transferDto.getFromId()+" is done successfully to account "+transferDto.getToId();
    }

}

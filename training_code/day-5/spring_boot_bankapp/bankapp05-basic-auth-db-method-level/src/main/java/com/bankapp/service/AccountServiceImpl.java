package com.bankapp.service;

import com.bankapp.dto.ContactDto;
import com.bankapp.entities.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
//ACID
@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    private AccountRepo accountRepo;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public List<Account> getAll() {
        return accountRepo.findAll();
    }

    @Override
    public Account getById(int id) {
        return accountRepo.findById(id)
                .orElseThrow(()-> new BankAccountNotFoundException("account "+ id +" is not found"));
    }

    @Override
    public void deposit(int id, BigDecimal amount) {
        //first of all get the account ....
        //withdraw the moneny and update the acc
        Account account=getById(id);
        account.setBalance(account.getBalance().add(amount));
        accountRepo.save(account);
    }

    @Override
    public void withdraw(int id, BigDecimal amount) {
        Account account=getById(id);
        account.setBalance(account.getBalance().subtract(amount));//ex handling
        accountRepo.save(account);
    }

    @Override
    public void transfer(int fromId, int toId, BigDecimal amount) {
        Account fromAcc=getById(fromId);
        Account toAcc=getById(toId);

        fromAcc.setBalance(fromAcc.getBalance().subtract(amount));//ex handling
        toAcc.setBalance(toAcc.getBalance().add(amount));
        accountRepo.save(fromAcc);
        accountRepo.save(toAcc);
    }

    @Override
    public void addAccount(Account account) {
        accountRepo.save(account);
    }

    @Override
    public void deleteAccount(int id) {
        Account accountToDelete=getById(id);
        accountRepo.delete(accountToDelete);
    }

    @Override
    public void updateAccount(int id, ContactDto contactDto) {
        Account accountToUpdateContactDetails=getById(id);
        accountToUpdateContactDetails.setPhone(contactDto.getPhone());
        accountToUpdateContactDetails.setEmail(contactDto.getEmail());

        accountRepo.save(accountToUpdateContactDetails);
    }
}

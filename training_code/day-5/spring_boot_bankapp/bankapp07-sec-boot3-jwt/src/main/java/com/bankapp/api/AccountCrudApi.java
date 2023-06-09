package com.bankapp.api;

import com.bankapp.dto.ContactDto;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/opertions")
public class AccountCrudApi {

    private AccountService accountService;

    @Autowired
    public AccountCrudApi(AccountService accountService) {
        this.accountService = accountService;
    }

    //getting all account
    @PreAuthorize("hasAuthority('ROLE_MGR') or hasAuthority('ROLE_CLERK')")
    @GetMapping(path = "accounts")
    public List<Account> getAll(){
        return accountService.getAll();
    }

    //getby id
    @PreAuthorize("hasAuthority('ROLE_MGR') or hasAuthority('ROLE_CLERK')")
    @GetMapping(path = "accounts/{id}")
    public Account getAccountById(@PathVariable(name = "id") int id){
        return accountService.getById(id);
    }


    //add
    @PreAuthorize("hasAuthority('ROLE_MGR')")
    @PostMapping(path = "accounts")
    public ResponseEntity<String> addAccount(@Valid @RequestBody Account account){
        accountService.addAccount(account);
        String messge= "account is created with id "+ account.getId();
        return ResponseEntity.status(HttpStatus.CREATED).body(messge);
    }
    //delete
    @PreAuthorize("hasAuthority('ROLE_MGR')")
    @DeleteMapping (path = "accounts/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") int id){
         accountService.deleteAccount(id);
         return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //update
    @PreAuthorize("hasAuthority('ROLE_MGR')")
    @PutMapping  (path = "accounts/{id}")
    public ResponseEntity<String> updateContactDetails(@PathVariable(name = "id") int id, @RequestBody ContactDto contactDto){
        accountService.updateAccount(id, contactDto);
        String messge= "account is update with email and phone for account with id: "+ id;
        return  ResponseEntity.status(HttpStatus.OK).body(messge);
    }

}

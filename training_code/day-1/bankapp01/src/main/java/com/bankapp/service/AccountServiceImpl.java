package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.Account;
import com.bankapp.dao.AccountDao;

@Service(value ="accountService" )
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDao accountDao;
	
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public List<Account> getAll() {
		return accountDao.getAll();
	}

	@Override
	public Account getById(int id) {
		return accountDao.getById(id);
	}

	@Override
	public void deposit(int id, double amount) {
		Account account=getById(id);
		account.setBalance(account.getBalance()+amount);
		accountDao.updateAccount(account);
	}

	@Override
	public void withdraw(int id, double amount) {
		Account account=getById(id);
		account.setBalance(account.getBalance()-amount);
		accountDao.updateAccount(account);
	}

	@Override
	public void transfer(int fromId, int toId, double amount) {
		Account fromAcc=getById(fromId);
		Account toAcc=getById(toId);
		
		fromAcc.setBalance(fromAcc.getBalance()-amount);
		toAcc.setBalance(toAcc.getBalance()+amount);
		
		accountDao.updateAccount(fromAcc);
		accountDao.updateAccount(toAcc);
	}

	@Override
	public void addAccount(Account account) {
	
	}

	@Override
	public void deleteAccount(int id) {
		
	}

}

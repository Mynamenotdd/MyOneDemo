package com.powernode.bank.service;

import com.powernode.bank.exceptions.BankNotenoughmoneyException;
import com.powernode.bank.exceptions.ThetransferfailedException;

/**
     * 账户业务类
    * @author 李国庆
     * @version 1.0
     * @since 1.0
    * */
public interface AccountService {
    public void transfer(String formActon ,String toActon ,double money) throws BankNotenoughmoneyException, ThetransferfailedException;
}

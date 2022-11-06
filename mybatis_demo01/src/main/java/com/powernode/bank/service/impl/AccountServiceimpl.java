package com.powernode.bank.service.impl;

import com.powernode.bank.dao.daoimpl.Accountdaoimpl;
import com.powernode.bank.exceptions.BankNotenoughmoneyException;
import com.powernode.bank.exceptions.ThetransferfailedException;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;
import com.powernode.bank.utlis.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceimpl implements AccountService {

    /**
     *
     * @param formActon 转出账户
     * @param toActon 转入账户
     * @param money 转入金额
     */
    private  Accountdaoimpl accountdaoimpl=new Accountdaoimpl();
    public void transfer(String formActon, String toActon, double money) throws BankNotenoughmoneyException, ThetransferfailedException {
        //先把formActon对象提取出来
        SqlSession sqlSession= SqlSessionUtil.openSession();
        Account account = accountdaoimpl.selectByActon(formActon);
        double balance = account.getBalance();
        if(balance<money){
            throw new BankNotenoughmoneyException("余额不足");
        }
        //接下来就是余额充足开始进行转账
//        首先要改变内存中类中的数据
        account.setBalance(account.getBalance()-money);
        Account account2 = accountdaoimpl.selectByActon(toActon);
        account2.setBalance(account2.getBalance()+money);
//        在更新数据库中的数据
        int count = accountdaoimpl.updateByActon(account);
        count+= accountdaoimpl.updateByActon(account2);
        if(count!=2){
            throw new ThetransferfailedException("转账未知失败");
        }
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }
}

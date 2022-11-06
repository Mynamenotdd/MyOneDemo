package com.powernode.bank.dao;

import com.powernode.bank.pojo.Account;

public interface Accountdao {
    /**
     *
     * @param acton 要查询的账户name
     * @return 返回一个Account的信息
     */
    public Account selectByActon(String acton);

    /**
     *
     * @param acton 传入要更新的对象
     * @return 更新玩的条数
     */
    public int updateByActon(Account acton);
}

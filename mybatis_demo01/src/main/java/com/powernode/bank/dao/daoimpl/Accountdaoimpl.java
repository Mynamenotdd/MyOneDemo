package com.powernode.bank.dao.daoimpl;

import com.powernode.bank.dao.Accountdao;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.utlis.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class Accountdaoimpl implements Accountdao {
    /**
     * @param acton 要查询的账户name
     * @return 返回一个Account的信息
     */
    @Override
    public Account selectByActon(String acton) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account account =(Account) sqlSession.selectOne("account.selectByActno", acton);
        return account;

    }


    /**
     *
     * @param acton 传入要更新的对象
     * @return
     */

    @Override
    public int updateByActon(Account acton) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int update = sqlSession.update("updateByActno", acton);
        return update;
    }
}

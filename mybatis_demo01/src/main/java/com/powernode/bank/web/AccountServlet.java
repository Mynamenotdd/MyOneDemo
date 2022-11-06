package com.powernode.bank.web;

import com.powernode.bank.exceptions.BankNotenoughmoneyException;
import com.powernode.bank.exceptions.ThetransferfailedException;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.impl.AccountServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    private AccountServiceimpl accountService=new AccountServiceimpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String fromActno = req.getParameter("fromActno");
        String toActon = req.getParameter("toActon");
        double money = Double.parseDouble(req.getParameter("money"));
//        调用service层-->service层调用dao层
        try {
            accountService.transfer(fromActno ,toActon ,money);
        } catch (BankNotenoughmoneyException e) {
            e.printStackTrace();
        } catch (ThetransferfailedException e) {
            e.printStackTrace();
        }

    }
}

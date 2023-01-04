
package com.codegym.casem2.filter;

import com.codegym.casem2.modal.Client;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/carHome","/carModal"})
public class CheckLoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Client client = (Client) session.getAttribute("client");
        if(client == null){
            res.sendRedirect("/login");
        }else {
            chain.doFilter(req,res);
        }
    }
}


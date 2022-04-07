package com.example.demo.command.impl;

import com.example.demo.command.Command;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("pass");
        String page;
        UserService userService = UserServiceImpl.getInstance();
        if (userService.authenticate(login,password)){
            request.setAttribute("user",login);
            page = "pages/main.jsp";
        }else {
            request.setAttribute("login_msg","incorrect login or password");
            page = "index.jsp";
        }
        return page;
    }
}

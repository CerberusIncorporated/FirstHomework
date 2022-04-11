package com.example.demo.controller;

import java.io.*;

import com.example.demo.command.Command;
import com.example.demo.command.CommandType;
import com.example.demo.exception.CommandException;
import com.example.demo.pool.ConnectionPool;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = {"/controller", "*.do"})
public class Controller extends HttpServlet {
    private String message;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String commandStr = request.getParameter("command");
        Command command = CommandType.define(commandStr);
        String page = null;
        try {
            page = command.execute(request);
            request.getRequestDispatcher(page).forward(request, response);
          // response.sendRedirect(page);
        } catch (CommandException e) {
            // response.sendError(500); //1
            throw new ServletException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void destroy() {
      //  ConnectionPool.getInstance().destroyPool();
    }
}
package com.example.demo.controller.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class SessionCreateListenerImpl implements HttpSessionListener {

    static Logger LOGGER = LogManager.getLogger();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        LOGGER.info("Session is created " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        LOGGER.info("Session is destroyed " + se.getSession().getId());

    }

}

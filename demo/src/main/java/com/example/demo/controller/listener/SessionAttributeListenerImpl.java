package com.example.demo.controller.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class SessionAttributeListenerImpl implements HttpSessionAttributeListener {
    static Logger LOGGER = LogManager.getLogger();

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        LOGGER.info("attribute is created " + sbe.getSession().getAttribute("user_name"));
        LOGGER.info("attribute is created " + sbe.getSession().getAttribute("current_page"));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        LOGGER.info("attribute is replaced " + sbe.getSession().getAttribute("user_name"));
        LOGGER.info("attribute is replaced " + sbe.getSession().getAttribute("current_page"));
    }
}

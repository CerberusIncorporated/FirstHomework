package by.yukhnevich.array.service;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.service.impl.ArrayServiceImplement;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class main {
    public static void main(String[] args) {


        final Logger log = LogManager.getLogger(main.class);

        System.err.println("Initialisied Logger");
        log.trace("TRACE");
        log.debug("DEBUG");
        log.info("INFO");
        log.warn("WARN");
        log.error("ERROR");
        log.fatal("FATAL");

        System.err.println("END");
    }
}
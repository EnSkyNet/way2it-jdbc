package com.way2it.yk.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTest {

    public static final Logger logger = LogManager.getLogger(Logger.class);

    public static void main(String[] args) {
        logger.info("Log new");
        logger.warn("Log new");
        logger.error("Log new");
    }
}

package com.kh.sandbox.logtutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTutorApp {
    private static Logger logger = LoggerFactory.getLogger(LogTutorApp.class);

    public static void main(String[] args) {
        logger.info("main() started");
        logger.error("messa", new RuntimeException("lllll"));
    }
}

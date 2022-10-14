package br.com.queiroz.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingUtil {

    private static Logger logger;


    public static void logInfo(Class<?> typeClass, String msg){
        logger = LoggerFactory.getLogger(typeClass);
        logger.info(msg);
    }
}

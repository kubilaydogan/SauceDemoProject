package Utilities;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
    LOG dosyasinin olusmasi icin feature altinda log4j2.xml dosyasinin olmasi ve
    apache.logging.log4j kullanilmasi gerekiyor

    Bu class kullanilirsa, her yerde log create yapmaya gerek kalmaz (line 10'daki gibi)
    Ama loglarda class name'ler gozukmez, sadece Log gorunur.
    2020-12-12 15:25:38 [main] INFO  Log:12 - Test is Starting...
    2020-12-12 15:25:38 [main] INFO  Log:22 - Test step ended.
    2020-12-12 15:28:33 [main] INFO  Log:12 - Test is Starting...
    2020-12-12 15:28:33 [main] INFO  Log:22 - Test step ended.
    2020-12-12 15:28:33 [main] INFO  DataTablesStepDef:34 - Orjinal logger <== class ve
    line onemliyse sinif icerisinde kullan

 */
public class Log {

    //Initialize Log4j instance
    private static Logger logger = LogManager.getLogger(Log.class);

    //We can use it when starting tests
    public static void startLog (){
        logger.info("Test is Starting...");
    }

    //We can use it when ending tests
    public static void endLog (){
        logger.info("Test is Ending...");
    }

    //Info Level Logs
    public static void info (String message) {
        logger.info(message);
    }

    public static void info (String message,Object ...params) {
        LogManager.getFormatterLogger().info(message, params);
    }

    //Warn Level Logs
    public static void warn (String message) {
        logger.warn(message);
    }

    //Error Level Logs
    public static void error (String message) {
        logger.error(message);
    }

    //Fatal Level Logs
    public static void fatal (String message) {
        logger.fatal(message);
    }

    //Debug Level Logs
    public static void debug (String message) {
        logger.debug(message);
    }
}
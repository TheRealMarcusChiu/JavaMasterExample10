package third.party.logger;

import org.apache.log4j.Logger;

/**
 * https://www.mkyong.com/logging/log4j-hello-world-example/
 * log4j.properties file should exist in /src/main/resources directory
 */
public class HelloExample {
    final static Logger logger = Logger.getLogger(HelloExample.class);

    public static void main(String[] args) {

        HelloExample obj = new HelloExample();
        obj.runMe("marcus chiu");

    }

    private void runMe(String parameter){

        if(logger.isDebugEnabled()){
            logger.debug("This is debug : " + parameter);
        }

        if(logger.isInfoEnabled()){
            logger.info("This is info : " + parameter);
        }

        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter);

    }
}

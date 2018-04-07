package test.java;

import org.apache.log4j.Logger;
import org.junit.Test;

public class test {
    private static Logger logger = Logger.getLogger(test.class);
    @Test
    public void testOnline() throws Exception{
        logger.debug("This is debug message!");
        logger.info("This is info message!");
        logger.error("This is error message!");
    }
}

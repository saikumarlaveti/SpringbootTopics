package Log4j.com;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
	    private static final Logger logger = LogManager.getLogger(App.class);
	    public static void main(String[] args) {
	        logger.debug("This is a DEBUG message");
	        logger.info("This is an INFO message");
	        logger.warn("This is a WARN message");
	        logger.error("This is an ERROR message");
	        logger.fatal("This is a FATAL message");
	    }
	}


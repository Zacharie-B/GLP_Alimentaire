package tests;

import org.apache.log4j.Logger;

public class Log4JTests {
	
	private static Logger logger = Logger.getLogger(Log4JTests.class);
	
	public static void main(String[] args){
	      logger.info("Hello World!");
	}
	
}

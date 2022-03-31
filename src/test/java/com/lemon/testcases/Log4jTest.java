package com.lemon.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Log4jTest {
    private Logger logger=Logger.getLogger(Log4jTest.class);

    @Test
    public void test(){
        //要通过log4j记录日志
        logger.error("错误级别的日志");
        logger.warn("警告级别的日志");
        logger.debug("调试级别的日志");
        logger.info("一般提示信息级别的日志");


    }
}

package com.lemon.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.log4j.Logger;
import org.testng.Assert;


public class BaseTest {
    private Logger logger=Logger.getLogger(BaseTest.class);
    public WebDriver driver;

    /**
     * 统一封装的打开浏览器的方法
     * @param browserName 对应浏览器名字
     */
    public WebDriver openBrowser(String browserName){
        if("chrome".equalsIgnoreCase(browserName)){
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
//            logger.info("=====打开Chrome浏览器=======");
//            return new ChromeDriver();
            driver=new ChromeDriver();
            return driver;
        }else if("firefox".equalsIgnoreCase(browserName)){
            System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
//            logger.info("=====打开firefox浏览器========");
//            return new FirefoxDriver();
                driver=new FirefoxDriver();
                return driver;
        }else if("ie".equalsIgnoreCase(browserName)){
            //取消IE安全设置（忽略IE的Protected Mode的设置）
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            //忽略IE的缩放设置问题
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            //告诉代码驱动程序放在那里
            System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriverServer.exe");
//            return new InternetExplorerDriver(capabilities);
            driver=new InternetExplorerDriver(capabilities);
            return driver;
        }else {
            System.out.println("浏览器类型暂不支持，请确认你的浏览器名字是否正确");
            return null;
        }
    }

    /**
     * 访问对应网址
     * @param driver 驱动对象
     * @param rul 网址
     */
    public void toUrl(WebDriver driver,String rul){
        //记录日志
        logger.info("访问页面【"+rul+"】");
        driver.get(rul);

    }

    /**
     * 断言的第二次封装
     * @param actualt 实际值
     * @param expect 期望值
     *
     */
    public void myAssertEquals(String actualt,String expect){
        //记录日志
        logger.info("比较断言，实际值【"+actualt+"】，期望值【"+expect+"】");
        Assert.assertEquals(actualt,expect);
    }
    public void myAssertEquals(int actualt,int expect){
        //记录日志
        logger.info("比较断言，实际值【"+actualt+"】，期望值【"+expect+"】");
        Assert.assertEquals(actualt,expect);
    }
    public void myAssertEquals(short actualt,short expect) {
        //记录日志
        logger.info("比较断言，实际值【" + actualt + "】，期望值【" + expect + "】");
        Assert.assertEquals(actualt, expect);
    }

    /**
     * 断言的第二次封装
     * @param candition 条件表达式
     */
    public void myAssertTrue(boolean candition){
        logger.info("判断是否为真断言，【" + candition + "】");
        Assert.assertTrue(candition);
    }

    }

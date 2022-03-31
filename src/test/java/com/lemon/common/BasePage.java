package com.lemon.common;

import com.lemon.testcases.Log4jTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.ByteBuffer;


public class BasePage {
    private Logger logger=Logger.getLogger(Log4jTest.class);

    private WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    /**
     * 显式等待-->等待元素存在的封装
     *
     * @param by
     * @return
     */
    public WebElement waitElementPresence( By by) {
        WebElement webElement =null;
        try {
            //1、实例化webDriverWait对象
            WebDriverWait webDriverWait = new WebDriverWait(driver, 8);
            //2、设置显式等待的条件（可见、可被点击...）
             webElement = webDriverWait.
                    until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            logger.error("等待元素存在 失败");
        }
        return webElement;
    }

    /**
     * 显式等待-->等待元素可见的封装
     *

     * @param by
     * @return
     */
    public WebElement waitElementVisible( By by) {
        WebElement webElement =null;
        try {
            //1、实例化webDriverWait对象
            WebDriverWait webDriverWait = new WebDriverWait(driver, 8);
            //2、设置显式等待的条件（可见、可被点击...）
             webElement = webDriverWait.
                    until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch (Exception e){
            logger.error("等待元素可见 失败");
        }
        return webElement;
    }

    /**
     * 显式等待-->等待元素可被点击的封装
     *
     * @param by
     * @return
     */
    public WebElement waitElementClickable(By by) {
        WebElement webElement=null;
        try {
            //1、实例化webDriverWait对象
            WebDriverWait webDriverWait = new WebDriverWait(driver, 8);
            //2、设置显式等待的条件（可见、可被点击...）
             webElement = webDriverWait.
                    until(ExpectedConditions.elementToBeClickable(by));
        }catch (Exception e){
            logger.error("等待元素可被点击 失败");
        }
        return webElement;
    }

    public void click( By by,String desc){
        //日志的记录
        logger.info("点击元素【"+desc+"】");
        waitElementClickable(by).click();
    }


    public void type(By by, String data, String desc){
        logger.info("往元素【"+desc+"】输入了数据【"+data+"】");
        waitElementVisible(by).sendKeys(data);
    }

    public String getElementTest(By by,String desc){
        String text = waitElementVisible( by).getText();
        logger.info("获取元素【"+desc+"】文本值【"+text+"】");
        return text;
    }

    public String getElementAttribute(By by,String attributeName,String desc){
        String value = waitElementVisible( by).getAttribute(attributeName);
        logger.info("获取元素【"+desc+"】的属性【"+attributeName+"】对应的值的属性值为【"+value+"】");
        return value;
    }
}

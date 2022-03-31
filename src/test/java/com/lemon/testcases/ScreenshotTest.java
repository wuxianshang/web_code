package com.lemon.testcases;

import com.lemon.common.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ScreenshotTest extends BaseTest {
    //测试截图
    @Test
    public void test() throws InterruptedException, IOException {
        WebDriver driver=openBrowser("chrome");
        driver.get("https://www.baidu.com/");
        Thread.sleep(3000);
        //截图 getSrceenshotAs（截图的方法）
//        driver.getScreenshotAs();
        TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //图片保存路径
        File destFile=new File(System.getProperty("user.dir")+"\\target\\test.png");
        FileUtils.copyFile(srcFile,destFile);
        //获取当前项目根目录
        //System.out.println(System.getProperty("user.dir")+"\\target");
        //E:\tool\idealU2019\Text\web_auto_35\target


    }
}

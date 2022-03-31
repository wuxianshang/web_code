package com.lemon.testcases;

import com.lemon.common.BaseTest;
import com.lemon.pages.IndexPage;
import com.lemon.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginTest extends BaseTest {
    @Test
    public void test_success(){
        WebDriver driver = openBrowser("chrome");
        driver.get("http://mall.lemonban.com:3344/");
        /*waitElementClickable(driver,By.xpath("//a[text()='登录']")).click();*/
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickLogin();
        /*waitElementVisible(driver,By.xpath("//input[@placeholder='请输入手机号/用户名']")).sendKeys("waiwai");
        waitElementVisible(driver,By.xpath("//input[@placeholder='请输入密码']")).sendKeys("lemon123456");
        waitElementClickable(driver,By.xpath("//a[@class='login-button']")).click();*/
        //实例化LoginPage对象
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("waiwai","lemon123456");
        //断言？？
        /*try {
            waitElementVisible(driver,By.xpath("//span[text()='欢迎来到柠檬班X']"));
            System.out.println("用例通过");
        }catch (Exception e){
            System.out.println("用例不通过");
        }*/
        //testng 内置很多断言方法
       /* try {
            waitElementVisible(driver,By.xpath("//span[text()='欢迎来到柠檬班X']"));
            Assert.assertTrue(true);
        }catch (Exception e){
            Assert.assertTrue(false);
        }*/

    }

    @Test(dataProvider = "getDatas")
    public void test_login_failure(String phone,String pwd){
        WebDriver driver = openBrowser("chrome");
        driver.get("http://mall.lemonban.com:3344/");
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(phone,pwd);
        //断言
        Assert.assertEquals(loginPage.getTips(),"账号或密码不正确");
        //关闭浏览器
    }
    @DataProvider()
    public Object[] getDatas(){
        Object[][] datas={{"167777777774","123456"},{"168888888","123456"},{"16999999999","123456"}};
        return datas;
    }

}

package com.lemon.testcases;

import com.lemon.common.BaseTest;
import com.lemon.pages.CartPage;
import com.lemon.pages.GoodsDetailPage;
import com.lemon.pages.IndexPage;
import com.lemon.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddCartTest extends BaseTest {
    @BeforeTest
    public void setup(){
        //数据清洗？？
    }

    @Test
    @Parameters({"browserName"})
    public void add_one_success(String browserName) throws InterruptedException {
        WebDriver driver=openBrowser(browserName);
        driver.get("http://mall.lemonban.com:3344/");
        toUrl(driver,"http://mall.lemonban.com:3344/");
        //1、登录
        IndexPage indexPage=new IndexPage(driver);
        indexPage.clickLogin();
        LoginPage loginTest=new LoginPage(driver);
        loginTest.login("waiwai","lemon123456");
        //2、浏览商品
        indexPage.clickGoodslist();
        indexPage.selectGoods();
        //获取商品的数据
        //3、添加购物车
        GoodsDetailPage goodsDetailPage=new GoodsDetailPage(driver);
        //获取商品的数据
        //（1）商品标题
        String goodsTitle1=goodsDetailPage.getGoodsTitle();
        //商品价格
        String goodsPrice1 = goodsDetailPage.getGoodsPrice();
        //（2）商品数量
        String goodsNumber1 = goodsDetailPage.getGoodsNumber();
        System.out.println(goodsDetailPage.getGoodsNumber());
        //3、添加购物车
       goodsDetailPage.clickAddCart();
        //4、点击购物车
        indexPage.clickCart();
        //获取购物车里面的商品
        CartPage cartPage=new CartPage(driver);
        String goodsTitl2 = cartPage.getGoodsTitle();
        String goodsPrice2 = cartPage.getGoodsPrice();
        String goodsNumber2 = cartPage.getGoodsNumber();

        //断言
      /*  Assert.assertEquals(goodsTitl2,goodsTitle1);
        Assert.assertEquals(goodsPrice2,goodsPrice1);
        Assert.assertEquals(goodsNumber2,goodsNumber1);*/

        myAssertEquals(goodsTitl2,goodsTitle1);
        myAssertEquals(goodsPrice2,goodsPrice1);
        myAssertEquals(goodsNumber2,goodsNumber1);



    }










}


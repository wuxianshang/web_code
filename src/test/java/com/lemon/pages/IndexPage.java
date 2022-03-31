package com.lemon.pages;

import com.lemon.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class IndexPage extends BasePage {
    //登录链接
    private By login = By.xpath("//a[text()='登录']");
    //商品列表元素
    private By goodsList = By.linkText("商品列表");
    //要浏览的商品
    private By selectedGoods = By.xpath("//div[text()='创维(SKYWORTH) 186升冰箱双门冰箱']");
    //购物车
    private By cart = By.xpath("//span[@data-route='cart']");

    private WebDriver driver;

    public IndexPage(WebDriver driver){
        super(driver);
    }


    public void clickLogin(){
        //driver.findElement(login).click();
//        waitElementClickable(driver,login).click();
        click(login,"主页-登录链接");

    }


    public void clickGoodslist(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(goodsList,"主页-商品列表");
//        waitElementClickable(goodsList);
    }

    public void selectGoods(){
        click(selectedGoods,"主页-浏览商品");
//        waitElementClickable(selectedGoods).click();
    }

    public void clickCart(){
        click(cart,"主页-点击购物车");
//        waitElementClickable(cart).click();
    }
}

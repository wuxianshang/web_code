package com.lemon.pages;

import com.lemon.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage {
    //商品标题
    private By goodsTitle = By.xpath("//div[@class='activity-goods']//a[@class='name']");
    private WebDriver driver;

    //商品价格
    private By goodsPrice=By.xpath("//div[@class='unit-price']");
    //商品数量
    private By goodsNumber=By.xpath("//input[@class='number']");


    public CartPage(WebDriver driver){
        super(driver);
    }

    /**
     * 获取购物车页面的商品标题
     * @return
     */
    public String getGoodsTitle(){
//        return waitElementVisible(driver,goodsTitle).getText();
        return getElementTest(goodsTitle,"购物车页面-商品标题");
    }

    public String getGoodsPrice(){
//        return waitElementVisible(driver,goodsPrice).getText().trim();
          return getElementTest(goodsPrice,"购物车页面-商品价格").trim();
    }

    public String getGoodsNumber(){
//        return waitElementVisible(driver,goodsNumber).getAttribute("value");
         return getElementAttribute(goodsNumber,"value","购物车页面-商品数量");
    }

}

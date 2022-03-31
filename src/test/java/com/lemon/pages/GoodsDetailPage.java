package com.lemon.pages;

import com.lemon.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoodsDetailPage extends BasePage {
    //添加购物车元素
    private By addCart = By.linkText("加入购物车");
    //商品标题
    private By goodsTitle = By.xpath("//div[@class='name-box']//div[@class='name']");
   //商品价格
    private By goodsPrice=By.xpath("//div[@class='price-box']//div[@class='price']");
    //商品数量
    private By goodsNumber=By.xpath("//input[@class='number']");

    private WebDriver driver;

    public GoodsDetailPage(WebDriver driver){
        super(driver);
    }

    //点击添加到购物车
    public void clickAddCart(){
//        waitElementClickable(driver,addCart).click();
        click(addCart,"商品详情页面-点击添加到购物车");
    }

    /**
     * 获取商品标题的操作
     * @return
     */
    public String getGoodsTitle(){
//        return waitElementVisible(driver,goodsTitle).getText();
        return getElementTest(goodsTitle,"商品详情页面-点击添加到购物车");
    }
    public String getGoodsPrice(){
        //去掉换行符 .replaceAll("\n","")
        //￥
        //0
        //.01商品价格
        //￥0.01
//        return waitElementVisible(driver,goodsPrice).getText().replaceAll("\n","");
          return getElementTest(goodsPrice,"商品详情页面-商品价格").replaceAll("\n","");
    }

    public String getGoodsNumber(){
//        return waitElementVisible(driver,goodsNumber).getAttribute("value");
        return getElementAttribute(goodsNumber,"value","商品详情页面-商品数量");
    }
}

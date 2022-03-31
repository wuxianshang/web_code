package com.lemon.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTDemo {
    @Test(dataProvider = "getDatas")
    public void test(String phone,String pwd){
        System.out.println("手机号："+phone+",密码"+pwd);

    }

   @DataProvider()
    public Object[] getDatas(){
        Object[][] datas={{"16777777777","123456"},{"1688888888","123456"},{"16999999999","123456"}};
        return datas;
    }
}

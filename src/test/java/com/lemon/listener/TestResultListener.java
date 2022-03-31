package com.lemon.listener;


import com.lemon.common.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

public class TestResultListener implements IHookable {
    //如果一个类实现了这个接口，那么该接口的run方法将会代替@Test注解标注的测试方法执行

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        System.out.println("run方法的执行");
        //让测试方法能够正常的执行
        callBack.runTestMethod(testResult);
        //收集到测试结果testResult，判断testResult是否有异常
       if(testResult.getThrowable()!=null){
            /*//失败用例截图
           System.out.println("截图...");*/
           //获取当前运行的测试类的实例（对象），eg：AddCartTest
           BaseTest baseTest = (BaseTest) testResult.getInstance();
           TakesScreenshot takesScreenshot = (TakesScreenshot)baseTest.driver;
           byte[] screenshotDatas = takesScreenshot.getScreenshotAs(OutputType.BYTES);
           //将截图的数据保存到allure附件中
           add_to_allure(screenshotDatas);
       }
    }
    @Attachment
    public byte[] add_to_allure(byte[] datas){
        return datas;

    }



}

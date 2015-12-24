package AvtoTest2015.Listeners;

import AvtoTest2015.TestNgTestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Maksim on 14.12.2015.
 */


public class TestListener implements ITestListener {
    WebDriver driver=null;
    String filePath = "target/surefire-reports/";
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("***** Error "+result.getName()+" test has failed *****");
        String methodName=result.getName().toString().trim();
        //get the driver
        driver= ((TestNgTestBase)result.getInstance()).getDriver();
        takeScreenShot(methodName);
    }

    public void takeScreenShot(String methodName) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with test method name
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy_hh.mm.ss");
        String dateStringValue = df.format(new Date());
        try {
            FileUtils.copyFile(scrFile, new File(filePath + methodName + "_" + dateStringValue + ".png"));
            System.out.println("***Placed screen shot in "+filePath+" ***");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onFinish(ITestContext context) {}

    public void onTestStart(ITestResult result) {   }

    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
}

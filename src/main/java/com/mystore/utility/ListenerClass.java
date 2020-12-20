package com.mystore.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mystore.base.BaseClass;

public class ListenerClass extends extentReportManager implements ITestListener {
	
	 public void onTestStart(ITestResult result) {
	    //    System.out.println("New Test Started" + result.getName());
	        test = extentReport.createTest(result.getName());
	    }
	    public void onTestSuccess(ITestResult result) {
	       // System.out.println("Test Successfully Finished" + result.getName());
	        if(result.getStatus()==ITestResult.SUCCESS) {
	        	test.log(Status.PASS,  "Pass Test case is: " + result.getName());
	        	
	        }
	    }
	    public void onTestFailure(ITestResult result) {
	       // System.out.println("Test Failed" + result.getName());
	       
	        if(result.getStatus()==ITestResult.FAILURE) {
	        	
	        	test.log(Status.FAIL,
						MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
	        	test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"The Test Case Fail", ExtentColor.RED));
	       	 String imgPath= screenShot.takeScreenShotOfFailTC(BaseClass.getDriver(), result.getMethod().getMethodName());
	        	try {
					test.fail("ScreenShot is Attached",MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
	        	
	        }
	    }
	    public void onTestSkipped(ITestResult result) {
	      //  System.out.println("Test Skipped" + result.getName());
	        if(result.SKIP==ITestResult.SKIP) {
	        	test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
	        	
	        }
	    }
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        System.out.println("Test Failed but within success percentage" + result.getName());
	    }
	    public void onStart(ITestContext context) {
	        System.out.println("This is onStart method" + context.getOutputDirectory());
	    }
	    public void onFinish(ITestContext context) {
	        System.out.println("This is onFinish method" + context.getPassedTests());
	        System.out.println("This is onFinish method" + context.getFailedTests());
	    }


}

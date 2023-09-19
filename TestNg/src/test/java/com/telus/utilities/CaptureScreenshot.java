package com.telus.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.telus.listeners.Screennavigation;

public class CaptureScreenshot extends Screennavigation {
	
	//public static String trg;
	
	public void captureSceenshot() throws IOException {
		
	//  Take the Screenshot of Failed Testcases using testng Listeners	
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		try
		{   
			File trg=new File(".\\screenshot\\homepage.png");   // location of screenshot where we store
			FileUtils.copyFile(src, trg);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
	

}

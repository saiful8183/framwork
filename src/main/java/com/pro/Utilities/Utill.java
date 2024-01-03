package com.pro.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Utill {

	

	public static void capturescreenshot(WebDriver driver, String name) {

		/*
		LocalDateTime currentTime=LocalDateTime.now();
		DateTimeFormatter formateTime=DateTimeFormatter.ofPattern("dd-MM-yy_hh_mm_ss");
		String time=currentTime.format(formateTime);
 // LocalDateTime currentTime = LocalDateTime.now(); 
 // DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy_hh_mm_ss");
 // String time = currentTime.format(formatTime);
  * 
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File dest = new File("./Screenshot/"+time+"_"+ name + ".png");

		try {

			Files.copy(src, dest);

			System.out.println("Screenshot captured");
		} catch (Exception e) {
			System.out.println("Unable to capture"+e.getMessage());
		}



*/
	
		
		
		
		
		
		
		
		
		
		
		
		
		LocalDateTime currenttime=LocalDateTime.now();
		DateTimeFormatter formatetime=DateTimeFormatter.ofPattern("dd-MM-yy_hh_mm_ss");
		String time=currenttime.format(formatetime);
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File("./Screenshot/"+name+".png");
	
	try {
		Files.copy(src, dest);
		System.out.println("CaptureScreenshot");
	} catch (Exception e) {
		System.out.println("Unable CaptureScreenshot"+e.getMessage());

	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//return dest.getAbsolutePath()
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * public static String captureScreenshot(WebDriver driver, String name) {
	 * 
	 * LocalDateTime currentTime = LocalDateTime.now(); DateTimeFormatter formatTime
	 * = DateTimeFormatter.ofPattern("dd-MM-yyyy_hh_mm_ss"); String time =
	 * currentTime.format(formatTime);
	 * 
	 * 
	 * File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); File
	 * dstn = new File("./Screenshots1/"+name+"_"+time+".png"); try {
	 * Files.copy(src, dstn); System.out.println("Screenshot captured"); } catch
	 * (Exception e) {
	 * System.out.println("Unable to capture screenshot >> "+e.getMessage()); }
	 * return dstn.getAbsolutePath(); }
	 */
}

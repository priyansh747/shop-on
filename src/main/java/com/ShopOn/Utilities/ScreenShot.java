package com.ShopOn.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	
	/*	private final static Logger log =  
    Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); */
private WebDriver driver;	
private final String folderPath ;

private final String folderNotExistError = "screenshot folder does not exist";
private final String cannotCleanFolderError = "cannot clean screenshot folder";
private final String cannotCaptureScreenshotError = "cannot capture the screenshot";


public ScreenShot(WebDriver driver) throws Exception {		
this.driver = driver;
folderPath = new PropertyFile().get("screenshotsFolderPath");
validateFolderExists();				
}

private void validateFolderExists() {
File screenShotFolder = new File(folderPath);
if (!screenShotFolder.exists()) {
	//log.info(folderNotExistError);
	throw new RuntimeException(folderNotExistError);
}
}

public void cleanFolder()
{		
try{					
	File screenShotFolder = new File(folderPath);
	for(File file: screenShotFolder.listFiles()) 
		file.delete();
}
catch(Exception ex) {
	//log.info(cannotCleanFolderError);
	throw new RuntimeException(cannotCleanFolderError, ex);
}
}	

public void capture(String methodName) 
{		
File scrFile;
 
 try {
	 scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(scrFile, new File(getScreenshotName(methodName)));	
	 return;
 } 
 catch (IOException e) {
	 e.printStackTrace();
 }
 
 //log.info(cannotCaptureScreenshotError);
 throw new RuntimeException(cannotCaptureScreenshotError);

}

private String getScreenshotName(String methodName) {
 String localDateTime = LocalDateTime.now().toString().replaceAll("[^0-9a-zA-Z]", "");
 StringBuilder name = new StringBuilder().append(folderPath) 
		       							 .append(methodName)
		       							 .append("_")
		       							 .append(localDateTime)
		       							 .append(".png");
 return name.toString();
}

}

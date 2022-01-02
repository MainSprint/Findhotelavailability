package findhotelavailability;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.List;





import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.datadrivern.framework.utils.ExtentReportManager;

public class FindHotelAvability extends pagebaseclass{
	public static WebDriver driver;
	static Properties prop=new Properties();
    // WebDriver driver =null;
     ExtentReports report= ExtentReportManager.getReportInstance();
     
     @BeforeMethod
     
     public void openbrowser(){
    	 
	//Open Chrome browser
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\patil\\workspace\\Sample\\drivers\\chromedriver.exe");
        driver =new ChromeDriver();
       
    //    driver.manage().window().maximize();    //Command used to maximize browser window.
    //Open firefox browser
    //   System.setProperty("webdriver.gecko.driver","C:\\Users\\patil\\workspace\\Sample\\drivers\\geckodriver.exe");
 	//   driver = new FirefoxDriver();
					
		driver.manage().window().maximize();	//Command used to maximize browser
		
     //apply implicit wait   
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  }
     @AfterMethod
     //close Chrome browser
     
        public void closebrowser(){
    	 
      	 driver.quit();
      	 
     }
     
	@Test
	
	public void hotelavailability() throws InterruptedException, IOException{
	
		ExtentTest logger=report.createTest("Test One");
		
		FileReader FR = new FileReader("./properties/confi.properties");
		Properties data = new Properties();
		data.load(FR);
		
		//open make my trip
		logger.log(Status.INFO,"Initilizing The Browser");
		logger.log(Status.INFO,"Opening A Website");
		
		driver.get("https://www.makemytrip.com/hotels/");
		File screenshotFile0 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile0,new File("./screenshot/Image5.png")); 

		Thread.sleep(5000);
		// driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 
	//click on search	
		 driver.findElement(By.xpath("//*[@id='city']")).click();
		 logger.log(Status.INFO,"Click on search ");
			
			
		 Thread.sleep(3000);
//Add Mumbai city 
	//	driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys("Mumbai");
		 driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys(data.getProperty("city"));
		 Thread.sleep(3000);
		 logger.log(Status.INFO,"Enter The City Name");
			
	 	 driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-0']/div")).click();
		//driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-0']")).click();
		   Thread.sleep(3000);
		   
			
		   
	     File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(screenshotFile,new File("./screenshot/Image.png")); 
         
		 System.out.println("City=Mumbai");
		 setProperty("city","Mumbai");
	
		 //click on date	 
		 driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div/div[1]/div[2]")).click();
		 Thread.sleep(3000);
		 logger.log(Status.INFO,"Click on date");
			
//date choose 14Dec and 24Dec
		 driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[3]/div[3]")).click();
		 System.out.println("Date=14-Dec-2021");
		 setProperty("Date","14-Dec-2021");
		 logger.log(Status.INFO,"Choose Check in date");
			
		 
		 Thread.sleep(3000);
	     driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[6]")).click();
	     System.out.println("Date=24-Dec-2021");
	     setProperty("Date","24-Dec-2021");
	     logger.log(Status.INFO,"Choose Check out date");
			
	    
	     
	     Thread.sleep(3000);
	     File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(screenshotFile1,new File("./screenshot/Image1.png")); 

	//Add Rooms & Guest
	     driver.findElement(By.id("guest")).click();
	     Thread.sleep(3000);
	     
	     driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div/div[1]/div[4]/div[1]/div[1]/div/div[2]/div/ul[1]/li[1]")).click();
	     System.out.println("Room=1 Guest=1");
	     setProperty("Room=1","Guest=1");
	     logger.log(Status.INFO,"Add Room 1");
	     logger.log(Status.INFO,"Add Guest");
			
			
	     Thread.sleep(3000);
	  //Apply button   
	     driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div/div[1]/div[4]/div[1]/div[2]/button[2]")).click();
	     File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(screenshotFile2,new File("./screenshot/Image2.png")); 
         logger.log(Status.INFO,"Click on Apply Button");
 		

	     Thread.sleep(3000);
	  //Submit button
	     driver.findElement(By.id("hsw_search_button")).click();
	     Thread.sleep(3000);
	     File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(screenshotFile,new File("./screenshot/Image3.png")); 
         logger.log(Status.INFO,"Click on Search Button");
 		

	   //Rating only
	     driver.findElement(By.xpath("//*[@id='hlistpg_sortby_option']/span")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//*[@id='hlistpg_sortby_option']/ul/li[4]")).click();
	     File screenshotFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(screenshotFile,new File("./screenshot/Image4.png")); 
         logger.log(Status.INFO,"Choose Hotels By Rating Only");
 		
	     Thread.sleep(3000);
	
	//count hotel  and print hotel names
	
	 WebElement objLink=driver.findElement(By.xpath("//*[@id='hotelListingContainer']"));
	   List<WebElement> objcurrentLink =objLink.findElements(By.tagName("a"));
	   System.out.println("Hotel List = "+objcurrentLink.size());
	   logger.log(Status.INFO,"Display Hotel Names");
		
	   List<WebElement> objcurrentLink1 =driver.findElements(By.xpath("//*[@id='hlistpg_hotel_name']"));
	//   System.out.println("Hotel List = "+objcurrentLink1
	 
	   
	  for(WebElement objlink : objcurrentLink1) {
		/*  String objlinkText = objlink.getText();
		  
		  if(!objlinkText.isEmpty())
		  */ //setProperty("Types_of_Hotels",objlink.getText());
		
		  System.out.println(objlink.getText());
		  
		  OutputStream output= new FileOutputStream("./properties/config.properties");
		  for(int i=0;i<objcurrentLink1.size();i++){
			   String d=objcurrentLink1.get(i).getText();
			   prop.setProperty("*",d);
			   prop.store(output,"");
		   } 
			   
	  }
	  
	  
	  
	
	  report.flush();
	 
	}
}
	


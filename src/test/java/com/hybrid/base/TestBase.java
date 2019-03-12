package com.hybrid.base;

import com.hybrid.util.XLS_Reader;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.applet.Applet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static Properties OR,Config;
    public static FileInputStream ip,fp;
    public static boolean isintialized;
    public static XLS_Reader projectsuite,home,hotel,flights;
    public static String[] runmodes;
    public static Logger AppLogs;

    public WebDriver driver;

       public static void intialize() throws IOException {
           if(!isintialized) {

               AppLogs=Logger.getLogger("devpinoyLogger");
               AppLogs.debug("generating logs: *******************");
               AppLogs.debug("Properties files are loading: ");
               OR = new Properties();
               ip = new FileInputStream("/Users/shilpa/IdeaProjects/Hybridmakemytrip/src/test/java/com/hybrid/config/OR.properties");
               OR.load(ip);

               Config = new Properties();
               fp = new FileInputStream("/Users/shilpa/IdeaProjects/Hybridmakemytrip/src/test/java/com/hybrid/config/Config.properties");
               Config.load(fp);
               AppLogs.debug("Excel files are loading");
               projectsuite=new XLS_Reader("/Users/shilpa/IdeaProjects/Hybridmakemytrip/src/test/java/com/hybrid/testdata/projectsuite.xlsx");
               home=new XLS_Reader("/Users/shilpa/IdeaProjects/Hybridmakemytrip/src/test/java/com/hybrid/testdata/home.xlsx");
               hotel=new XLS_Reader("/Users/shilpa/IdeaProjects/Hybridmakemytrip/src/test/java/com/hybrid/testdata/hotel.xlsx");
               flights=new XLS_Reader("/Users/shilpa/IdeaProjects/Hybridmakemytrip/src/test/java/com/hybrid/testdata/flights.xlsx");


           }
       }

        public void Openbrowser(String browser){
           if(browser.equalsIgnoreCase("Firefox")){
               System.setProperty("webdriver.gecko.driver","/Users/shilpa/IdeaProjects/Hybridmakemytrip/src/test/java/com/hybrid/drivers/geckodriver");
               driver=new FirefoxDriver();
           }else if(browser.equalsIgnoreCase("Chrome")){
               System.setProperty("webdriver.chrome.driver","/Users/shilpa/IdeaProjects/Hybridmakemytrip/src/test/java/com/hybrid/drivers/chromedriver");
               driver=new ChromeDriver();

           }else if(browser.equalsIgnoreCase("safari")){
               System.setProperty("webdriver.safari.driver","/Users/shilpa/IdeaProjects/Hybridmakemytrip/src/test/java/com/hybrid/drivers/safaridriver");
               driver=new SafariDriver();

           }
        }

        public void Closebrowser(){
           driver.quit();
        }
        public void navigateUrl(String url){
           driver.get(url);
        }



        public WebElement getObject(String xpathkey){
           return driver.findElement(By.xpath(OR.getProperty(xpathkey)));
        }





}

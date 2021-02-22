package utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SeliniumUtility {

    public static Properties properties;
    public Logger log = Logger.getLogger(getClass().getSimpleName());
    public static CommonUtilities oCommonUtil = new CommonUtilities();



    static {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/resources/testdata/application.properties");
            properties.load(fis);
            oCommonUtil.loadLog4jProperty(System.getProperty("user.dir") + "/resources/testdata/Log4is2.properties");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   WebDrManager driverManagerWeb = new WebDrManager();



    public  void printAllDestination(Map<Integer, String> numToDestination) {
        Set<Integer> keys = numToDestination.keySet();
        for(Integer key : keys){
            String val = numToDestination.get(key);
            System.out.println("key :" + key + " Value : " + val);
        }
        System.out.println( numToDestination);
    }

    public Properties getProperties() {

        return properties;
    }

    public void waitExplicitly(int iSeconds, WebElement ele, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, iSeconds);
        wait.ignoring(NoSuchElementException.class, ElementNotVisibleException.class);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void verifyText(String actualText, String destn, String msg) throws IOException {

        Assert.assertEquals(actualText,destn);
    } 


}

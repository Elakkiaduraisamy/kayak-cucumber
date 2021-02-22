package kayak;

import utilities.SeliniumUtility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;


public class SearchStepDefinitions {
    public static WebDriver driverWeb;
    public SeliniumUtility oSelutil = new SeliniumUtility();
    public static Logger log = Logger.getLogger(SearchStepDefinitions.class.getSimpleName());


    @FindBy(xpath="//a[@href='/flights']")
    WebElement flightTab;

    @FindBy(xpath="//div[contains(@id,'origin-airport-display')and @data-placeholder='From?']")
    WebElement eorigin;

    @FindBy(xpath="//div[contains(@id,'destination-airport-display')and @data-placeholder='To?']")
    WebElement edestination ;

    @FindBy(xpath = "//input[contains(@id, \"destination-airport\")]")
    WebElement edestinationText;

    @FindBy(xpath="//*[contains(@id, 'dateRangeInput-display-start-inner')]")
    WebElement date_picker_from;

    @FindBy(xpath="//div[contains(@id, 'depart')]")
    WebElement from_date_click;

    @FindBy(xpath="//div[contains(@id, 'depart-input')]")
    WebElement from_date_text;

    @FindBy(xpath="//div[contains(@id, 'return-input')]")
    WebElement to_date_text;

    @FindBy(xpath="//button[contains(@id, 'submit')]")
    WebElement submit;

    @FindBy(xpath="//div[contains(@id,'searchResultsList')]//div[contains(@class,'resultWrapper')]")
    WebElement searchResults;

    @FindBy(xpath="//*[contains(@id, \"dialog-content\")]/*[contains(@id, \"dialog-close\")]")
    List<WebElement> close_alert_xpath;

    @FindBy(xpath="//div[contains(@id,'searchResultsList')]//div[contains(@class,'resultWrapper')]")
    List<WebElement> searchResult;


    @Given("^user is already on Kayak flights page$")
    public void user_is_already_on_Kayak_flights_page() throws Exception {
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        driverWeb = new ChromeDriver();
        PageFactory.initElements(driverWeb, this);
        driverWeb.get("https://www.kayak.com/");  //Kayak URL
        flightTab.click();
    }

    @When("^user enters  \"([^\"]*)\" and  \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and user clicks on search$")
    public void user_enters_and_and_and_and_user_clicks_on_search(String origin, String destination, String startDate, String returnDate) throws Exception {
        oSelutil.waitExplicitly(5,eorigin,driverWeb);
        eorigin.click();
        origin = "" + Keys.BACK_SPACE + Keys.BACK_SPACE + origin;
        destination = "" + Keys.BACK_SPACE + Keys.BACK_SPACE + destination;
        eorigin.sendKeys(origin);
        eorigin.sendKeys(Keys.ENTER);
        log.info("Origin is Entered");

        oSelutil.waitExplicitly(5,edestination,driverWeb);
        edestination.click();
        edestinationText.sendKeys(destination);
        edestinationText.sendKeys(Keys.ENTER);
        log.info("Destination is Entered");

        oSelutil.waitExplicitly(5,date_picker_from,driverWeb);
        date_picker_from.click();
        log.info("Calender is clicked");

        oSelutil.waitExplicitly(5,from_date_text,driverWeb);
        from_date_click.click();
        log.info("Date field is clicked");

        oSelutil.waitExplicitly(5,from_date_text,driverWeb);
        from_date_text.clear();
        from_date_text.sendKeys(startDate);
        log.info("Start Date is Entered");

        oSelutil.waitExplicitly(5,to_date_text,driverWeb);
        to_date_text.clear();
        Thread.sleep(1000);
        to_date_text.sendKeys(returnDate);
        Thread.sleep(2000);
        log.info("Return is Entered");

        submit.click();
        Thread.sleep(10000);
        log.info("Submit button is clicked");

    }

    @Then("^user is shown search results$")
    public void user_is_shown_search_results() throws Exception {
        log.info("Search result is shown");
        closePopUp(driverWeb);
    }

    @Then("^Verify the origin and  destination of the \"([^\"]*)\" th result$")
    public void verify_the_origin_and_destination_of_the_th_result(String nthResult) throws Exception {
        Map<Integer, Itinerary> numToDestination = new HashMap<>();
        int count =0;

        for (WebElement el : searchResult){
            //This gives for  divs SFO - PAR ; PAR - SFO
            List<WebElement> places = el.findElements(By.xpath(".//div[contains(@class,'section duration allow-multi-modal-icons')]//div[contains(@class,'bottom-airport')]"));
            // Only pick the second text . 1st corresponds to origin, 2nd corresponds to destination
            // 3rd corresponds to return flight origin, 4th corresponds to return flight destination
            String origin = places.get(0).getAttribute("title");
            String destination = places.get(1).getAttribute("title");

            numToDestination.put(++count, new Itinerary(origin, destination));

        }

//        printAllDestination(numToDestination);
        System.out.println("Print 5th Origin and Destination : " + numToDestination.get(Integer.parseInt(nthResult)));
    }



    @Then("^Close the browser$")
    public void close_the_browser() throws Exception {
        driverWeb.close();

    }
    public WebDriver closePopUp(WebDriver driver) {
////            List<WebElement> close_alert_xpathList = driver.findElements("close_alert_xpath");
//              List<WebElement> close_alert_xpath_List = driver.findElements(By.xpath("//*[contains(@id, \"dialog-content\")]/*[contains(@id, \"dialog-close\")]"));

        for (WebElement el : close_alert_xpath) {
            if (el.isDisplayed())
                el.click();
        }
        return driver;
    }
    private static void printAllDestination(Map<Integer, String> numToDestination) {
        Set<Integer> keys = numToDestination.keySet();
        for(Integer key : keys){
            String val = numToDestination.get(key);
            System.out.println("key :" + key + " Value : " + val);
        }
        System.out.println( numToDestination);
    }



}

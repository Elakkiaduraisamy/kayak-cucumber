//package com.kayak.StepDefintions;
//
//import POPages.SearchFlightPage;
//import utilities.SeliniumUtility;
//import cucumber.api.java.en.*;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.Properties;
//
//import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;
//
//
//public class Steps {
//
//    public WebDriver driver;
//    public SearchFlightPage search_flight;
//    public  Properties properties;
//
//
//
//    @Given("^Browser is launched$")
//    public void browser_is_launched() throws Exception{
//        WebDriverManager.getInstance(CHROME).setup();
//        driver = new ChromeDriver();
//        search_flight = new SearchFlightPage(driver);
//
//    }
//
//    @When("^Kayak \"([^\"]*)\" is entered and home page is opened$")
//    public void koyak_is_entered_and_home_page_is_opened(String url) throws Exception{
//        url = properties.getProperty.getproperties("kayak.url")
//        driver.get(url);
//    }
//
//    @When("^flights tab is choosen$")
//    public void flights_tab_is_choosen() throws Exception {
//        search_flight.clickFlightTab();
//    }
//
//    @Then("^user enters origin \"([^\"]*)\" and destination \"([^\"]*)\" places$")
//    public void user_enters_origin_and_destination_places(String origin, String destination) throws Exception {
//        search_flight.setEorigin(origin);
//        search_flight.setEdestination(destination);
//    }
//
//    @Then("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
//    public void user_enters_and(String startDate, String returnDate) throws Exception {
//        search_flight.clickFromDatePicker();
//        search_flight.clickFromDateClick();
//        search_flight.setStartDateText(startDate);
//        search_flight.setReturnDateText(returnDate);
//    }
//
//    @Then("^user clicks on search$")
//    public void user_clicks_on_search() throws Exception {
//        search_flight.clickSubmit();
//        search_flight.closePopUp(driver);
//
//    }
//
//    @Then("^web page navigates to list of searched flights$")
//    public void web_page_navigates_to_list_of_searched_flights() throws Exception {
//        System.out.println("List of flights are displayed");
//
//    }
//
//    @Then("^Verify the origin destination of the nth flight in the result$")
//    public void verify_the_origin_destination_of_the_nth_flight_in_the_result() throws Exception {
//        String  expectedDestn = "LAS";
//        String actaulDestn = search_flight.getNthElementDestination(6);
//        search_flight.verifyInfo(actaulDestn,expectedDestn);
//
//    }
//
//    @Then("^Close the browser$")
//    public void close_the_browser() throws Exception
//
//       driver.close();
//
//    }
//
//}
//
//

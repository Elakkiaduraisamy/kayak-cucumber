//package POPages;
//
//import utilities.SeliniumUtility;
//import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//public class SearchFlightPage {
//    public SeliniumUtility oSelutili = new SeliniumUtility();
//
//    WebDriver ldriver;
//
//    public SearchFlightPage(WebDriver rdriver){
//        this.ldriver = rdriver;
//        PageFactory.initElements(rdriver, this);
//    }
//    Logger log = Logger.getLogger(getClass().getSimpleName());
//
//    @FindBy(xpath="//a[@href='/flights']")
//    WebElement flightTab;
//
//    @FindBy(xpath="//div[contains(@id,'origin-airport-display')and @data-placeholder='From?']")
//    WebElement eorigin;
//
//    @FindBy(xpath="//div[contains(@id,'destination-airport-display')and @data-placeholder='To?']")
//    WebElement edestination ;
//
//    @FindBy(xpath="//*[contains(@id, 'dateRangeInput-display-start-inner')]")
//    WebElement date_picker_from;
//
//    @FindBy(xpath="//div[contains(@id, 'depart')]")
//    WebElement from_date_click;
//
//    @FindBy(xpath="//div[contains(@id, 'depart-input')]")
//    WebElement from_date_text;
//
//    @FindBy(xpath="//div[contains(@id, 'return-input')]")
//    WebElement to_date_text;
//
//    @FindBy(xpath="//button[contains(@id, 'submit')]")
//    WebElement submit;
//
//    @FindBy(xpath="//div[contains(@id,'searchResultsList')]//div[contains(@class,'resultWrapper')]")
//    WebElement searchResults;
//
//    @FindBy(xpath="//*[contains(@id, \"dialog-content\")]/*[contains(@id, \"dialog-close\")]")
//    List<WebElement> close_alert_xpath;
//
//    @FindBy(xpath="//div[contains(@id,'searchResultsList')]//div[contains(@class,'resultWrapper')]")
//    List<WebElement> searchResult;
//
//
//            public void setEorigin(String origin){
//                oSelutili.waitExplicitly(5,eorigin,ldriver);
//                eorigin.click();
//                eorigin.sendKeys(origin);
//                log.info("Origin is Entered");
//            }
//            public void setEdestination(String destn){
//                oSelutili.waitExplicitly(5,oSelutili.getProperties().getProperty("kayak.url"),ldriver);
//                edestination.click();
//                edestination.sendKeys(destn);
//                log.info("Destination is Entered");
//            }
//            public void setStartDateText(String startDate){
//                oSelutili.waitExplicitly(5,from_date_text,ldriver);
//                from_date_text.clear();
//                from_date_text.sendKeys(startDate);
//                log.info("Start Date is Entered");
//            }
//            public void setReturnDateText(String returnDate){
//                oSelutili.waitExplicitly(5,to_date_text,ldriver);
//                to_date_text.clear();
//                to_date_text.sendKeys(returnDate);
//                log.info("return is Entered");
//            }
//            public void clickFlightTab() {
//                oSelutili.waitExplicitly(5,flightTab,ldriver);
//                flightTab.click();
//                log.info("Flight Tab is clicked");
//            }
//            public void clickFromDatePicker() {
//                oSelutili.waitExplicitly(5,date_picker_from,ldriver);
//                date_picker_from.click();
//                log.info("Calender is clicked");
//            }
//            public void clickFromDateClick() {
//                oSelutili.waitExplicitly(5,from_date_text,ldriver);
//                from_date_click.click();
//                log.info("Date field is clicked");
//            }
//            public void clickSubmit() {
//                submit.click();
//                log.info("Submit button is clicked");
//            }
//           public WebDriver closePopUp(WebDriver driver) {
//////            List<WebElement> close_alert_xpathList = driver.findElements("close_alert_xpath");
////              List<WebElement> close_alert_xpath_List = driver.findElements(By.xpath("//*[contains(@id, \"dialog-content\")]/*[contains(@id, \"dialog-close\")]"));
//               oSelutili.waitExplicitly(5, from_date_text, ldriver);
//               for (WebElement el : close_alert_xpath) {
//                   if (el.isDisplayed())
//                       el.click();
//               }
//               return driver;
//           }
//           public String  getNthElementDestination(int n) {
//               Map<Integer, String> numToDestination = new HashMap<>();
//               int count = 0;
//               String actualDestn = "";
//               for (WebElement e : searchResult) {
//                   //This gives for  divs SFO - PAR ; PAR - SFO
//                   List<WebElement> places = e.findElements(By.xpath(".//div[contains(@class,'section duration allow-multi-modal-icons')]//div[contains(@class,'bottom-airport')]"));
//                   // Only pick the second text . 1st corresponds to origin, 2nd corresponds to destination
//                   // 3rd corresponds to return flight origin, 4th corresponds to return flight destination
//                   String destination = places.get(1).getAttribute("title");
//                   numToDestination.put(++count, destination);
//               }
//               while (n <= numToDestination.size()) {
//                   actualDestn = numToDestination.get(n);
//
//               }
//               return actualDestn;
////               printAllDestination(numToDestination);
////               System.out.println("Print 5th Destination : " + numToDestination.get(n))
//           }
//
//          public void printAllDestination(Map<Integer, String> numToDestination) {
//              Set<Integer> keys = numToDestination.keySet();
//              for (Integer key : keys) {
//                  String val = numToDestination.get(key);
//                  System.out.println("key :" + key + " Value : " + val);
//              }
//              System.out.println(numToDestination);
//
//          }
//          public void verifyInfo(String actual, String expected) throws IOException {
//                oSelutili.verifyText(actual,expected,"Destination and origin ");
//          }
//
//    }
//
//
//

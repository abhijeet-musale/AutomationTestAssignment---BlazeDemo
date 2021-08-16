package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import businessfunctions.Confirmation;
import businessfunctions.Home;
import businessfunctions.Purchase;
import businessfunctions.Reserve;
import databuilder.BookingDetailsBuilder;
import utilities.ConfigReader;
import utilities.CsvReader;
import utilities.Driver;
import java.util.List;
import java.io.File;

public class BookFlight extends MasterTest {

	private CsvReader readCsv = new CsvReader();
	private String baseUrl = ConfigReader.get("baseURL");

	public Home homePage;
	public Reserve reservePage;
	public Purchase purchasePage;
	public Confirmation confirmationPage;
	public Driver helperUtil;

	@BeforeClass
	public void setup(){
		homePage = PageFactory.initElements(driver, Home.class);
		reservePage = PageFactory.initElements(driver, Reserve.class);
		purchasePage = PageFactory.initElements(driver, Purchase.class);
		confirmationPage = PageFactory.initElements(driver, Confirmation.class);
		helperUtil = new Driver(driver);
	}

	@DataProvider(name= "bookFlight")
	public Object[][] bookFlightsData(){
		Object[][] rawData;
		List<String[]> bookFlights = readCsv.parseFile(new File(ConfigReader.get("BookingDetailsCSV"))
				.getAbsolutePath());
		rawData = new Object[bookFlights.size()][1];

		for(int i = 0; i< bookFlights.size(); i++){
			for(String[] bookFlight : bookFlights){
				rawData[i++][0] = new BookingDetailsBuilder(bookFlight);
			}
		}
		return rawData;
	}

	 @Test(dataProvider = "bookFlight")
	public void searchForFlights(BookingDetailsBuilder data){
		helperUtil.navigatePage(baseUrl);
		homePage.selectDepartureCity(data.getBookingDetails().getDeparture());
		homePage.selectDesitinationCity(data.getBookingDetails().getDestination());
		homePage.findFlights();
	}

	@Test(dependsOnMethods ="searchForFlights", dataProvider = "bookFlight")
	public void chooseLowestPricedAirline(BookingDetailsBuilder data){
		reservePage.verifyReservePageDisplayed();
		reservePage.flyLowCostAirLine();
	}


	@Test(dependsOnMethods ="chooseLowestPricedAirline", dataProvider = "bookFlight")
	public void purchaseFlightTicket(BookingDetailsBuilder data){
		purchasePage.verifyPurchasePageDisplayed();
		purchasePage.enterFlyerName(data.getBookingDetails().getName());
		purchasePage.enterFlyerAddress(data.getBookingDetails().getAddress());
		purchasePage.enterFlyerCity(data.getBookingDetails().getCity());
		purchasePage.enterFlyerState(data.getBookingDetails().getState());
		purchasePage.enterFlyerZipCode(data.getBookingDetails().getZipCode());
		purchasePage.enterFlyerCardNumber(data.getBookingDetails().getCardNumber());
		purchasePage.enterFlyerCardMonth(data.getBookingDetails().getMonth());
		purchasePage.enterFlyerCardYear(data.getBookingDetails().getYear());
		purchasePage.enterFlyerCardName(data.getBookingDetails().getCardName());
		purchasePage.clickPurchaseFlights();
	}


	@Test(dependsOnMethods ="purchaseFlightTicket")
	public void bookingConfirmed(){
		Assert.assertTrue(confirmationPage.verifyConfirmationPageDisplayed(), "Booking has been confirmed");
	}

	@AfterTest
	public void cleanup() {
		driver.quit();
	}

}


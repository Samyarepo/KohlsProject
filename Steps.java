package kohlsAutomate;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Base.BaseClass;
import PageFactory.CustomerDetailsPage;
import PageFactory.ProductDetailsPage;
import PageFactory.ProductListingPage;
import PageFactory.SearchPage;
import PageFactory.addressPage;
import PageFactory.cartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Steps extends BaseClass {
	//WebDriver driver = null;
	//CustomerDetailsPage customer;
	//addressPage address;
	
	@Given("he is on Home Page")
	public void he_is_on_home_Page()  {
		String title = driver.getTitle();
		System.out.println("Title of Home Page: "+title);
		Assert.assertEquals("Kohl's | Shop Clothing, Shoes, Home, Kitchen, Bedding, Toys & More", title);	
	}
	
	@When("he Searches for {string}")
	public void user_searches_for(String product) {
      SearchPage search = new SearchPage(driver);
      search.searchDress(product);
      System.out.println("************Searching for womens dress**************");
      
}
	@When("he Chooses to buy second item")
	public void chooses_to_buy_second_item() {
	    System.out.println("************Choosing second dress from List************");
		ProductListingPage PLP = new ProductListingPage(driver);
		PLP.chooseSecondItem();
	 }
	
	@When("he Chooses Size")
	public void user_chooses_size() throws Throwable {
		Thread.sleep(5000);
	    System.out.println("************Choosing Size***************");
	    ProductDetailsPage PDP = new ProductDetailsPage(driver);
		PDP.chooseSize();
	}
	
	@When("he Adds item in cart")
	public void clicks_on_guest_checkout() throws Throwable {
		System.out.println("************Adding To Cart****************");
		 cartPage c1 = new cartPage(driver);
		 c1.addToBag();
		 
		 cartPage c2= new cartPage(driver);
		 c2.minicart0();
		 
		 cartPage c3 = new cartPage(driver);
		 c3.checkout0();	
		 
		 cartPage c4= new cartPage(driver);
		 c4.guestCheckout0();
		 
}
  
	@Then("^he Enters (.*), (.*), (.*) and (.*) Details and Continue as Guest$")
     public void he_enters_customer_details_and_continue_as_guest(String firstname, String lastname, String emailID, String phonenumber) throws Throwable {
		Thread.sleep(4000);
		System.out.println("************Entering Customer Details******************");
		CustomerDetailsPage customer1 = new CustomerDetailsPage(driver) ;
		customer1.enterFirstName(firstname);
		System.out.println("fisrt name :"+firstname);
		CustomerDetailsPage customer2 = new CustomerDetailsPage(driver) ;
        customer2.enterLastName(lastname);
        System.out.println("lastname :"+lastname);
        CustomerDetailsPage customer3 = new CustomerDetailsPage(driver) ;
		customer3.enterEmailID(emailID);
        System.out.println("emailID :"+emailID);
		CustomerDetailsPage customer4 = new CustomerDetailsPage(driver) ;
		customer4.enterPhoneNumber(phonenumber);
		CustomerDetailsPage customer5 = new CustomerDetailsPage(driver) ;
		customer5.ContinueasGuest();	
		Thread.sleep(4000);

}
	@Then("^he enters (.*) details and clicks on done$")
	public void enters_address(String address) throws Throwable {
		addressPage adr= new addressPage(driver) ;
		adr.EnterAddressManually();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,300)");
		System.out.println("************Entering Address***************");
		addressPage street= new addressPage(driver) ;
		street.StreetAddress(address);
		//WebElement menuOption = driver.findElement(By.xpath("(//div[@title='5225 Cedar Glenn Ct'])[3]"));
		//act.moveToElement(menuOption).perform();
		Thread.sleep(4000);
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		
//		addressPage zip = new addressPage(driver) ;
//		zip.ZipCode(zipcode);
//		
//		addressPage cit = new addressPage(driver) ;
//		cit.City(city);
//		
//		addressPage stat = new addressPage(driver) ;
//		stat.State(state);
//		
		System.out.println("************Customer is almost Done Checking out*************");
		addressPage ok = new addressPage(driver) ;
		ok.DoneTab();

	}
	
}


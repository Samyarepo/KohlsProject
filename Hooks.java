package kohlsAutomate;


import Base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass{

		

		@Before
		public void beforevaldiation()
		
		{
			
			LaunchBrowser();
			System.out.println("************Hello Start test*******");
			
		}
		
		@After
		public void afterValidation()
		
		{
			
			driver.quit();
			
		}

}

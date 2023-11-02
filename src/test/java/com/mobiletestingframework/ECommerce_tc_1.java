package com.mobiletestingframework;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;



import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mobileTestingFramework.pagesObjects.android.CartPage;

import com.mobileTestingFramework.pagesObjects.android.ProductCataloguePage;
import com.mobileresringframework.TestUtils.AndroidBaseTest;



public class ECommerce_tc_1 extends AndroidBaseTest{

//	@BeforeMethod
//	public void preSetup() {
//		Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
//		driver.
//	}
	@Test(dataProvider = "getData", groups = "Smoke")
	public void fillForm_PositiveScenario(HashMap<String, String> input) throws InterruptedException{
		
		
     	formPage.setNameField(input.get("name"));
        formPage.chooseGenderOption(input.get("gender"));
        formPage.setCountrySelection(input.get("country")); 
		ProductCataloguePage cataloguePage =  formPage.submitForm();
       		
        cataloguePage.addItemToCartByIndex(0);
        cataloguePage.addItemToCartByIndex(0);
        CartPage cartPage = cataloguePage.goToCartPage();
   
       Thread.sleep(2000);
        

        

	   
	  double ActualSum =  cartPage.getProductSum();
	  double displayedSum =  cartPage.getTextFormattedAmount(cartPage.getFormattedSumTxt()) ;
 
 	 Assert.assertEquals(ActualSum, displayedSum);
	
     
 	 cartPage.clickOnTermsAndConditions();
	 cartPage.markTheCheckbox();
	 cartPage.clickOnProceed();
	 
	 Thread.sleep(6000);

	 
	}
	
	
//	@Test
//	public void fillForm_ErrorValidationScenario() throws InterruptedException{
//		
//		
//		//formPage.setNameField("Sara");
//        formPage.chooseGenderOption("female");
//        formPage.setCountrySelection("Argentina"); 
//		ProductCataloguePage cataloguePage =  formPage.submitForm();
//       		
//        cataloguePage.addItemToCartByIndex(0);
//        cataloguePage.addItemToCartByIndex(0);
//        CartPage cartPage = cataloguePage.goToCartPage();
//   
//       Thread.sleep(2000);
//
//
//	 
//	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String,String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//testData//eCommerce.json");
		return new Object[][] {
			                   {data.get(0)},{data.get(0)}
		  };
	}

}

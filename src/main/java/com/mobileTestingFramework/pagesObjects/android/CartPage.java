package com.mobileTestingFramework.pagesObjects.android;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mobileTestingFramework.utilis.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions{

	AndroidDriver driver ;
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrices ; 

	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement formattedSum ;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cart']")
	private WebElement cartText ;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement term ;
	
	@AndroidFindBy(id = "android:id/button1")
    private WebElement acceptTerms ;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement checkBox ;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed ;
	
	public int getProductPrice() {
		
		return productPrices.size();
	}
	
	public double getProductSum() {
		
		 double sum = 0 ;
		   
		   for (int i = 0; i <getProductPrice(); i++) {
			 
			   String amount =  productPrices.get(i).getText();
			   
			   Double price =  Double.parseDouble(amount.substring(1));
			   sum += price ;
			   
		}
		  return sum ;
		
	}
	
	
 public String getFormattedSumTxt() {
	return formattedSum.getText();
 }
	
 
 public void clickOnTermsAndConditions() {
	 longPressAction(term);
	 acceptTerms.click();
 }
 
 public void markTheCheckbox() {
	 checkBox.click();
 }
	
 public void clickOnProceed() {
	proceed.click();
}
}

package com.mobileTestingFramework.pagesObjects.android;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mobileTestingFramework.utilis.AndroidActions;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions{
	
	
	AndroidDriver driver ;

	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sara");
	//com.androidsample.generalstore:id/nameField
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private	WebElement nameField ;
	
	//By.xpath("//android.widget.RadioButton[@text='Female']"
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption; 
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption; 

	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	private WebElement selectCountryDropdown ;
	
	
	@AndroidFindBy(id  = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopBTN ;
	
	public void setNameField(String name) {
	nameField.sendKeys(name);
	}
	
	public void chooseGenderOption(String gender) {
		if(gender.contains("female"))
		      femaleOption.click();
		else
			maleOption.click();
	}
	
	
	
	public void setCountrySelection(String countryName) {
		
		selectCountryDropdown.click();
	    scrollToText(countryName);		
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	}
	
	
	public ProductCataloguePage submitForm(){
		
		shopBTN.click();
		return new ProductCataloguePage(driver);
	}
}

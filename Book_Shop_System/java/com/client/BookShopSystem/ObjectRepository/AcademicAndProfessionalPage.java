package com.client.BookShopSystem.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcademicAndProfessionalPage {
	WebDriver driver;
	public void AcademicAndProfessional(WebDriver driver) {
	this.driver= driver;
	PageFactory.initElements(driver,this );
	}
	
	@FindBy(xpath="//select[@id='select']")
	private WebElement SorybyEDt;
	
	public WebElement getSorybyEDt() {
		return SorybyEDt;
	}
	
	// Method to dynamically select SortBy option
    public void selectSortBy(String optionText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(SorybyEDt));

        Select select = new Select(SorybyEDt);
        boolean found = false;

        for (WebElement opt : select.getOptions()) {
            String visibleText = opt.getText().trim();
            if (visibleText.equalsIgnoreCase(optionText.trim()) ||
                visibleText.toLowerCase().contains(optionText.trim().toLowerCase())) {

                opt.click();
                System.out.println("Selected Sort By option: " + visibleText);
                found = true;
                break;
            }
        }}}
	
	
	



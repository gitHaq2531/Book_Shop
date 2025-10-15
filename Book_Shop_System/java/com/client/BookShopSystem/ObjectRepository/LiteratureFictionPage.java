package com.client.BookShopSystem.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LiteratureFictionPage {
	 WebDriver driver;

	    @FindBy(xpath = "//h2[text()=' Literature and Fiction STORE ']")
	    private WebElement LAFTitleEDT;

	    @FindBy(id="select")
	    private WebElement sortByEdt;

	    public LiteratureFictionPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public WebElement getLAFTitleEDT() {
	        return LAFTitleEDT;
	    }

	    public WebElement getSortByEdt() {
	        return sortByEdt;
	    }

	    // Method to dynamically select SortBy option
	    public void selectSortBy(String optionText) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.visibilityOf(sortByEdt));

	        Select select = new Select(sortByEdt);
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
	        }

	        if (!found) {
	            System.out.println("No matching SortBy option found for: " + optionText);
	            System.out.println("Available options are:");
	            for (WebElement opt : select.getOptions()) {
	                System.out.println(" - " + opt.getText());
	            }
	        }
	    }

}

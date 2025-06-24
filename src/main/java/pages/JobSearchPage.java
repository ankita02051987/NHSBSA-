
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class JobSearchPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By keywordField = By.id("keyword");
    private final By locationField = By.id("location");
    private final By searchButton = By.id("search");
    private final By jobResults = By.cssSelector("ul.nhsuk-list.search-results > li");
    private final By sortDropdown = By.id("sort");

    public JobSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ========== Input Methods ==========

    public void enterKeyword(String keyword) {
        WebElement keywordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(keywordField));
        keywordInput.clear();
        keywordInput.sendKeys(keyword);
    }

    public void enterLocation(String location) {
        WebElement locationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(locationField));
        locationInput.clear();
        locationInput.sendKeys(location);
    }

    // ========== Search Action ==========

    public void clickSearch() {
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchBtn.click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(jobResults, 0));
    }

    // ========== Results Handling ==========

    public boolean areResultsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(jobResults));
            List<WebElement> results = driver.findElements(jobResults);
            return !results.isEmpty();
        } catch (Exception e) {
            System.out.println("No job results found or timed out: " + e.getMessage());
            return false;
        }
    }

    public List<WebElement> getAllJobResults() {
        return driver.findElements(jobResults);
    }

    // ========== Sorting ==========

    public void sortByDatePosted() {
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sortDropdown));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownElement);

        Select sortSelect = new Select(dropdownElement);

        // Debugging: print available options
        System.out.println("Available sort options:");
        for (WebElement option : sortSelect.getOptions()) {
            System.out.println(" -> " + option.getText());
        }

        // Select the correct visible text
        sortSelect.selectByVisibleText("Date Posted (newest)");
    }
}

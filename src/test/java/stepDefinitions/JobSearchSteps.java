package stepDefinitions;



        import io.cucumber.java.en.*;
        import org.openqa.selenium.WebDriver;
        import pages.JobSearchPage;
        import utils.DriverFactory;

        import static org.junit.Assert.assertTrue;

public class JobSearchSteps {

    private WebDriver driver = DriverFactory.getDriver();
    private JobSearchPage jobSearchPage = new JobSearchPage(driver);

    @Given("I am a jobseeker on NHS Jobs website")
    public void i_am_on_nhs_jobs_website() {
        driver.get("https://www.jobs.nhs.uk/candidate/search");
    }

    @When("I put my preferences into the Search functionality")
    public void i_put_my_preferences() {
        jobSearchPage.enterKeyword("Nurse");
        jobSearchPage.enterLocation("London");
        jobSearchPage.clickSearch();
    }

    @Then("I should get a list of jobs which matches my preferences")
    public void i_should_get_matching_jobs() {
        assertTrue(jobSearchPage.areResultsDisplayed());
    }

    @Then("sort my search results with the newest Date Posted")
    public void sort_my_results_by_date() {
        jobSearchPage.sortByDatePosted();
    }
}

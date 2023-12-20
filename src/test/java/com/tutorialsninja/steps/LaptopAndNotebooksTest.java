package com.tutorialsninja.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LaptopAndNotebookPage;

import java.util.Collections;
import java.util.List;

public class LaptopAndNotebooksTest {

    List<Double> defaultPrice;

    @Given("I am on Desktops page")
    public void iAmOnDesktopsPage() {
    }

    @When("Mouse hover on {string} Tab and click")
    public void mouseHoverOnTabAndClick(String tab) {
        new HomePage().getTopMenuList(tab);
    }

    @And("Click on {string}")
    public void clickOn(String showAll) {
        new HomePage().setClickOnShowAll(showAll);
    }

    @And("Select Sort By position {string}")
    public void selectSortByPosition(String sortBy) {
        defaultPrice = new LaptopAndNotebookPage().getProductPrice();
        new LaptopAndNotebookPage().selectSortByHightoLow(sortBy);

    }

    @Then("Verify the Product will arrange in Descending order")
    public void verifyTheProductWillArrangeInDescendingOrder() {
        Collections.sort(defaultPrice, Collections.reverseOrder());
        List<Double> afterProductList = new LaptopAndNotebookPage().getProductPrice();
        Assert.assertEquals(afterProductList, defaultPrice);
    }
}

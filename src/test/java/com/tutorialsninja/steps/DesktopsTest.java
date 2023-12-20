package com.tutorialsninja.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DesksTopPage;
import pages.HomePage;

import java.util.Collections;
import java.util.List;

public class DesktopsTest {

    List<String> defaultproduct;

    @Given("Mouse hover {string} Tab and click")
    public void mouseHoverTabAndClick(String tab) {
        new HomePage().getTopMenuList(tab);
    }

    @When("Click on the {string}")
    public void clickOnThe(String showAll) {
        new HomePage().setClickOnShowAll(showAll);
    }

    @And("Select Sort By {string}")
    public void selectSortBy(String sortBy) {
        defaultproduct = new DesksTopPage().getProductList();
        new DesksTopPage().selectSortByZToA(sortBy);
    }

    @Then("Verify the Product price will arrange in High to Low order")
    public void verifyTheProductPriceWillArrangeInHighToLowOrder() {
        Collections.reverse(defaultproduct);
        List<String> afterProductList = new DesksTopPage().getProductList();
        Assert.assertEquals(afterProductList, defaultproduct);
    }
}

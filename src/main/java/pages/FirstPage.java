package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FirstPage {
    @FindBy(id = "idModuleImage") public WebElement elementWithId;
//    @FindBy(css = "#idModuleImage") public WebElement elementWithId;

    @FindBy(className = "w3-btn") public WebElement elementWithClass;
//    @FindBy(css = ".w3-btn") public WebElement elementWithClass;
    @FindBy(css = ".w3-btn.w3-padding.w3-border.w3-sand") public WebElement elementWithManyClasses;

    @FindBy(tagName = "h2") public WebElement elementWithTag;
//    @FindBy(css = "h2") public WebElement elementWithTag;

    @FindBy(xpath = "//*[@id=\"listModule\"]/ul/li[2]") public WebElement elementWithXpath;
    @FindBy(xpath = "//li[contains(text(), 'Espresso')]") public WebElement elementWithXpath2;

    @FindBy(css = "[width='189']") public WebElement imageWithSpecifiedWidth;
    @FindBy(css = "[src*='1878']") public WebElement imageWithSpecifiedSrc;

    @FindBy(id = "idModule") public WebElement container;

    ///////
    @FindBy(css = "[type=\"checkbox\"]") public WebElement checkbox;
    @FindBy(css = "[type=\"radio\"]") public WebElement radio;
    @FindBy(id = "buttonToClick") public WebElement buttonToClick;
    @FindBy(id = "linkToClick") public WebElement linkToClick;

    @FindBy(css = "[type=\"text\"]") public WebElement inputToTypeInto;
    @FindBy(css = "textarea") public WebElement textAreaToTypeInto;

    @FindBy(css = "[name=\"coffee\"]") public WebElement coffeeSelectElement;
    @FindBy(css = "[name=\"tea\"]") public WebElement teaSelectElement;
    @FindBy(css = "[name=\"refreshment\"]") public WebElement refreshmentSelectElement;

    @FindBy(css = "h5") public WebElement h5Element;
    @FindBy(id = "idModuleImage") public WebElement getAttributeElement;

    @FindBy(css = "[name=\"uncheckedCheckbox\"]") public WebElement uncheckedCheckbox;

    ////////////
    @FindBy(id = "btnForFrameWithId") public WebElement btnForFrameWithId;
    @FindBy(id = "btnForFrameWithIndex") public WebElement btnForFrameWithIndex;
    @FindBy(id = "btnForFrameAsWebElement") public WebElement btnForFrameAsWebElement;
    @FindBy(css = "[src=\"forFrameAsWebElement.html\"]") public WebElement thirdIframe;

    //////
    @FindBy(css = "a") public List<WebElement> listOfLinks;

    ////
    @FindBy(id = "alertButton") public WebElement alertButton;
    @FindBy(id = "confirmButton") public WebElement confirmButton;
    @FindBy(id = "promptButton") public WebElement promptButton;
}


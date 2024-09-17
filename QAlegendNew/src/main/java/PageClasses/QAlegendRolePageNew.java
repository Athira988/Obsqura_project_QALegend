package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendRolePageNew {
	
	WebDriver driver;

	@FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	WebElement addButton;
	
	@FindBy(name="name")
	WebElement rolenametextbox;
	
	@FindBy(xpath="(//ins[@class='iCheck-helper'])[2]")
	WebElement selectallusercheckbox;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement searchtextbox;
	
	
	
	
	public QAlegendRolePageNew(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddButton()
	{
		PageUtilities.clickOnElement(addButton);
	}
	
	public void enterTextToadd()
	{
		PageUtilities.enterText(rolenametextbox, "sales3");
	}
	
	public void clickOnUserCheckBox()
	{
		PageUtilities.clickOnElement(selectallusercheckbox);
	}
	
	public void enterTexttoSearch()
	{
		PageUtilities.enterText(searchtextbox, "sales");
	}
}

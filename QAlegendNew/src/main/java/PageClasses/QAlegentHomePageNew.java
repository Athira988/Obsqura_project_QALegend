package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegentHomePageNew {
	WebDriver driver;

	@FindBy(xpath="//span[text()='User Management']")
	WebElement UserManagementoption;

	@FindBy(xpath="//span[@class='title']//preceding::i[@class='fa fa-user']")
	WebElement usersoption;

   @FindBy(xpath="//button[text()='End tour']")
   WebElement endtourbutton;
   
   @FindBy(xpath="(//span[@class='title'])[2]")
	WebElement roleoption;
   
   
   public QAlegentHomePageNew(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnEndTourButton()
	{
		PageUtilities.clickOnElement(endtourbutton);
	}
	public void clickOnUserMangementOption()
	{
		PageUtilities.clickOnElement(UserManagementoption);
	}

	public void clickOnUserAction()
	{
		PageUtilities.clickOnElement(usersoption);
	}
	
	public void clickOnRoleAction()
	{
		PageUtilities.clickOnElement(roleoption);
	}
}

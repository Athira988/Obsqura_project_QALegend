package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegentUsersPageNew {
	WebDriver driver;

	@FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	WebElement addButton;

	@FindBy(id="surname")
	WebElement prefixsurnametextbox;

	@FindBy(id="first_name")
	WebElement firstnametextbox;

	@FindBy(id="last_name")
	WebElement lastnametextbox;

	@FindBy(id="email")
	WebElement emailtextbox;

	@FindBy(id="role")
	WebElement roledropdownlist;

	@FindBy(id="username")
	WebElement usernametextbox;

	@FindBy(name="password")
	WebElement passwordtextbox;

	@FindBy(id="confirm_password")
	WebElement confirmpasswordtextbox;

	@FindBy(id="cmmsn_percent")
	WebElement salescommissionpercentagetextbox;

	@FindBy(id="submit_user_button")
	WebElement  submituserbuttonButton;

	@FindBy(xpath="//div[@id='users_table_filter']//child::input")
	WebElement searchtextbox;

	@FindBy(xpath="(//button[@class='btn btn-xs btn-danger delete_user_button']//child::i)[1]")
	WebElement deletebutton;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement Okbutton;
	
	@FindBy(xpath="//td[@class='dataTables_empty']")
	WebElement errorMessage;



	public QAlegentUsersPageNew(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnUsersButton()
	{
		PageUtilities.clickOnElement(addButton);
	}

	/* public  void enterPrefix(String prefix)
	{
		PageUtilities.enterText(prefixsurnametextbox, prefix);
	}

	public void enterFirstName(String firstname)
	{
		PageUtilities.enterText(firstnametextbox, firstname);
	}

	public void enterLastname(String lastname)
	{
		PageUtilities.enterText(lastnametextbox, lastname);
	}

	public void enteremail(String email)
	{
		PageUtilities.enterText(emailtextbox, email);
	}

	public void selectRole(String role)
	{
		PageUtilities.dropdownSelectByVisibleText(roledropdownlist, role);
	}

	public void enterUsername(String usernamenew)
	{
		PageUtilities.enterText(usernametextbox, usernamenew);
	}

	public void enterPassword(String passwordnew)
	{
		PageUtilities.enterText(passwordtextbox, passwordnew);
	}

	public void enterConfirmPassword(String confirmpassword)
	{
		PageUtilities.enterText(confirmpasswordtextbox, confirmpassword);
	}

	public void enterSalesCommissionPercentage(String percentage)
	{
		PageUtilities.enterText(salescommissionpercentagetextbox, percentage);
	} */

	public void clicksaveButton()
	{
		PageUtilities.clickOnElement(submituserbuttonButton);
	} 

	public void enterTextToSearch(String texttosearch )
	{
		PageUtilities.enterText(searchtextbox, texttosearch);
	} 
	
	public void deleteButton()
	{
		PageUtilities.clickOnElement(deletebutton);
	}
	
	public void okButton()
	{
		PageUtilities.clickOnElement(Okbutton);
	}
	
	public String noMatchingRecordsFound()
	{
		return (PageUtilities.getElementText(errorMessage));
	}
	

	public void insertUserDetails(String prefix, String firstname, String lastname, String email, 
	        String usernamenew, String passwordnew, String confirmpassword,String percentage) {
		PageUtilities.enterText(prefixsurnametextbox, prefix);
		PageUtilities.enterText(firstnametextbox, firstname);
		PageUtilities.enterText(lastnametextbox, lastname);
		PageUtilities.enterText(emailtextbox, email);
		//PageUtilities.dropdownSelectByVisibleText(roledropdownlist, role);
		PageUtilities.enterText(usernametextbox, usernamenew);
		PageUtilities.enterText(passwordtextbox, passwordnew);
		PageUtilities.enterText(confirmpasswordtextbox, confirmpassword);
		PageUtilities.enterText(salescommissionpercentagetextbox, percentage);
		//PageUtilities.enterText(addButton, percentage);
		//PageUtilities.clickOnElement(submituserbuttonButton);

	}
}

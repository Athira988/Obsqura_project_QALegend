package TestCases;

import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;

import PageClasses.QAlegendLoginPageNew;
import PageClasses.QAlegendRolePageNew;
import PageClasses.QAlegentHomePageNew;

import PageClasses.QAlegentUsersPageNew;
import Utilities.ExcelUtility;

public class QAlegentNewTestCases extends BaseClass {
	WebDriver driver;
	QAlegendLoginPageNew loginpage;
	QAlegentHomePageNew homepage;
	QAlegentUsersPageNew userspage;
	QAlegendRolePageNew rolepage;
	Properties props;
	FileReader reader;
	
	@BeforeMethod (groups= {"smoketest","regression"})
	@Parameters({"Browser"})
	public void initilization(String browser) throws Exception
	{
		props =new Properties();
		reader=new FileReader(System.getProperty("user.dir")+ "\\src\\main\\java\\Resources\\TestData.properties");
		props.load(reader);
		driver= browserInitilization(browser);
		driver.get(props.getProperty("url"));// fetching these details from property file
		driver.manage().window().maximize();
		loginpage=new QAlegendLoginPageNew(driver);
		homepage=new QAlegentHomePageNew(driver);
		userspage=new QAlegentUsersPageNew(driver);
		rolepage=new QAlegendRolePageNew(driver);
		
	}
		
		@Test
		public void deleteUser() throws IOException
		{
			loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnUserMangementOption();
			homepage.clickOnUserAction();
			userspage.clickOnUsersButton();
			
			
		Random rand= new Random();
		int randomnumber= rand.nextInt(10000);

		String prefix=ExcelUtility.getString(1, 0, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1")+randomnumber;
		String firstname=ExcelUtility.getString(1, 1, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		String lastname=ExcelUtility.getString(1, 2, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		String mail=randomnumber+ExcelUtility.getString(1, 3, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		//String role=ExcelUtility.getString(1, 4, "\\src\\main\\java\\Resources\\UserDetails.xlsx", "Sheet1");
		String Username=randomnumber+ExcelUtility.getString(1, 4, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		String Password=ExcelUtility.getString(1, 5, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		String ConfirmPassword=ExcelUtility.getString(1, 6, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		String SalesCommissionPercentage=ExcelUtility.getString(1, 7, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");

		userspage.insertUserDetails(prefix,firstname,lastname,mail,Username,Password,ConfirmPassword,SalesCommissionPercentage);
		userspage.clicksaveButton();		
		userspage.enterTextToSearch("gazal");
		userspage.deleteButton();
		userspage.okButton();
		userspage.enterTextToSearch("gazal");
		Assert.assertEquals(userspage.noMatchingRecordsFound(), "No matching records found");
}
		
		public void addRole()
		{
			loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnUserMangementOption();
			homepage.clickOnRoleAction();
			rolepage.clickOnAddButton();
			rolepage.enterTextToadd();
			rolepage.clickOnUserCheckBox();
			Actions action=new Actions(driver);
			action.sendKeys(Keys.ENTER);
		}
		
		public void editRole() {
			
			loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnUserMangementOption();
			homepage.clickOnRoleAction();
			rolepage.clickOnAddButton();
			rolepage.enterTextToadd();
			rolepage.clickOnUserCheckBox();
			Actions action=new Actions(driver);
			action.sendKeys(Keys.ENTER);
			rolepage.enterTexttoSearch();
			//Random rand= new Random();
			//int randomnumber= rand.nextInt(10000);
		}
		
}

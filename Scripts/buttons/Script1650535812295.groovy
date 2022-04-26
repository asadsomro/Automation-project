import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.openqa.selenium.By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver 
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver



import org.openqa.selenium.interactions.Actions
WebUI.openBrowser('https://letcode.in/buttons')
WebUI.maximizeWindow()

WebUI.click(goto_home_btn)

WebUI.back()

position = WebUI.getElementLeftPosition(find_loc_button)

System.out.println(position)

clr = WebUI.getCSSValue(color_btn, 'background-color')

System.out.println(clr)

height = WebUI.getElementHeight(green_btn)

width = WebUI.getElementWidth(green_btn)

System.out.println('height and width of object is: ' + height)

System.out.println('width of object is: ' + width)

WebUI.verifyElementNotClickable(disabled_btn)

WebDriver driver = DriverFactory.getWebDriver()

obj = driver.findElement(By.xpath("//h2[contains(text(),'Button Hold!')]"))

Actions actions = new Actions(driver)

actions.clickAndHold(obj).build().perform()

WebUI.closeBrowser()


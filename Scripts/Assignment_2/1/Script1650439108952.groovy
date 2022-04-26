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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.openBrowser('https://www.google.com/')
WebUI.delay(5)

if (WebUI.waitForElementPresent(logo, 3)) {
	KeywordUtil.logInfo('Website is opened successfully')

	if(WebUI.waitForElementPresent(search, 2)) {
		KeywordUtil.markPassed('Search input field is diplayed')
		WebUI.setText(search, 'Automation')

		WebUI.sendKeys(search, Keys.chord(Keys.ENTER))
		KeywordUtil.markPassed('Enter Key Pressed')
		//Get text of 5th search result and print it on the console
		searchresult = WebUI.getText(searchresult)
		KeywordUtil.markPassed('5th Search result text saved in variable successfully')

		System.out.println('The 5th search result is: ' + searchresult)
		KeywordUtil.markPassed('Search Result Printed on console')

		WebUI.closeBrowser()


	}else {
		KeywordUtil.markFailed('FAILED: Search input field is not diplayed')
	}
}else {
	KeywordUtil.markFailed('FAILED: Unable to access Website')
}
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



WebUI.openBrowser('https://www.amazon.com/')
WebUI.maximizeWindow()


if(WebUI.waitForElementPresent(toast, 2)) {
	KeywordUtil.logInfo('Toast alert displayed')
	WebUI.click(toast)


	if(WebUI.waitForElementPresent(logo, 2)) {
		KeywordUtil.logInfo('Website opened successfully')


		if(WebUI.waitForElementPresent(tdeals_link, 2)) {
			KeywordUtil.logInfo('Todays Deals link displayed')
			WebUI.click(tdeals_link)

			WebUI.scrollToElement(home_checkbox, 3)

			if(WebUI.waitForElementPresent(home_checkbox, 2)) {
				KeywordUtil.logInfo('Checkbox is displayed')
				WebUI.click(home_checkbox)
				
				WebUI.closeBrowser()

			}else {
				KeywordUtil.markFailed('Checkbox is not displayed')
			}
		}else {
			KeywordUtil.markFailed('Todays Deals link is not diplayed')
		}
	}else {
		KeywordUtil.markFailed('Website not opened successfully')
	}
}else {
	KeywordUtil.markFailed('No Toast Alert is displayed')
}
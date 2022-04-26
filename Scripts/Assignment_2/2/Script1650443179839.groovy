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

WebUI.openBrowser('https://login.mailchimp.com/signup/')
WebUI.delay(4)
WebUI.maximizeWindow()

if(WebUI.waitForElementPresent(pagetitle, 2)) {
	KeywordUtil.logInfo('Page opened successfully')

	if(WebUI.waitForElementPresent(email_field, 2)) {
		KeywordUtil.markPassed('Email field displayed')
		WebUI.setText(email_field , email)

		if(WebUI.waitForElementPresent(username_field, 2)) {
			KeywordUtil.markPassed("Username filed displayed")
			WebUI.setText(username_field, username)

			if(WebUI.waitForElementPresent(password_field, 2)) {
				KeywordUtil.markPassed('Password filed is displayed')
				WebUI.setText(password_field, password)

				if(WebUI.waitForElementPresent(checkbox, 2)) {
					KeywordUtil.markPassed('Checkbox displayed')
					WebUI.click(checkbox)

					WebUI.scrollToElement(signup_btn, 2)

					if(WebUI.verifyElementPresent(signup_btn, 2)) {
						KeywordUtil.markPassed('Sign Up button is present')
						WebUI.click(signup_btn)

						WebUI.delay(5)
						//Get email sent successfully text and print it on console
						msgconfirm = WebUI.getText(confirmation_msg)
						System.out.println(msgconfirm)

						WebUI.closeBrowser()

					}else {
						KeywordUtil.markFailed('Sign Up button is not displayed')
					}
				}else {
					KeywordUtil.markFailed('Checkbox is not displayed')
				}
			}else {
				KeywordUtil.markFailed('Password filed not displayed')
			}
		}else {
			KeywordUtil.markFailed('Username filed not displayed')
		}
	}else {
		KeywordUtil.markFailed('Email filed not displayed')
	}


}else {
	KeywordUtil.markFailed('Failed to load website')
}
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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.google.common.base.Strings as Strings

WebUI.openBrowser('https://ultimateqa.com/filling-out-forms/')

WebUI.delay(5)

if (WebUI.verifyElementPresent(name, 2)) {
    KeywordUtil.logInfo('Web site is opened successfully')

    //----- Verification Of Share Buttons started ------ //
    //Facebook button verification
    if (WebUI.verifyElementPresent(btn_facebook, 2)) {
        KeywordUtil.markPassed('Facebook is displayed')
    } else {
        KeywordUtil.markFailed('Facebook button is not displayed')
    }
    
    //Twitter button verification
    if (WebUI.verifyElementPresent(btn_twitter, 2)) {
        KeywordUtil.markPassed('Twitter is displayed')
    } else {
        KeywordUtil.markFailed('Twitter button is not displayed')
    }
    
    //LinkedIn button verification
    if (WebUI.verifyElementPresent(btn_linkedin, 2)) {
        KeywordUtil.markPassed('LinkedIn is displayed')
    } else {
        KeywordUtil.markFailed('LinkedIn button is not displayed')
    }
    
    //----- Share buttons verification ends ------//
    if (text_name.toString().empty && text_message.toString().empty) {
        
		//Form verification
        if (WebUI.verifyElementPresent(name, 2)) {
            KeywordUtil.logInfo('Name is displayed')
			
			//WebUI.setText(name, findTestData("share_btn_test_data").getValue(1, 1))
            WebUI.setText(name, text_name)

            if (WebUI.verifyElementPresent(message, 2)) {
                KeywordUtil.logInfo('Message text area is displayed')

				//WebUI.setText(message, findTestData("share_btn_test_data").getValue(1, 1))
                WebUI.setText(message, text_message)

                if (WebUI.verifyElementPresent(submit, 2)) {
                    KeywordUtil.logInfo('Submit button is displayed. Now clicking...')

                    WebUI.click(submit)

                    if (WebUI.verifyElementPresent(msg_nameText, 2) && WebUI.verifyElementPresent(msg_messageText, 2)) {
                        KeywordUtil.markPassed('PASSED: Test Case is pass in case of empty name and message')
                    } else {
                        KeywordUtil.markFailed('FAILED: Test Case is fail in case of empty name and message')
                    }
                } else {
                    KeywordUtil.markFailed('FAILED: Submit button is not displayed')
                }
            } //Form verification when fields have some value
            else {
                KeywordUtil.markFailed('FAILED: Message text area is not displayed')
            }
            //Form verification when one of the value is missing
        } else {
            KeywordUtil.markFailed('FAILED: Name field is not displayed')
        }
    } else if ((text_name.toString().length() > 0) && (text_message.toString().length() > 0)) {
        if (WebUI.verifyElementPresent(name, 2)) {
            KeywordUtil.logInfo('Name is displayed')

            WebUI.setText(name, findTestData("share_btn_test_data").getValue(1, 1))

            if (WebUI.verifyElementPresent(message, 2)) {
                KeywordUtil.logInfo('Message text area is not displayed')

                WebUI.setText(message, findTestData("share_btn_test_data").getValue(2, 1))

                if (WebUI.verifyElementPresent(submit, 2)) {
                    KeywordUtil.logInfo('Submit button is displayed. Now clicking...')

                    WebUI.click(submit)

                    if (WebUI.waitForElementPresent(msg_thanksForContact, 2))
						 {
                        KeywordUtil.markPassed('PASSED: Test Case is pass when name and message have some value')
                    } else {
                        KeywordUtil.markFailed('FAILED: Test Case is FAIL when name and message have some value')
                    }
                } else {
                    KeywordUtil.markFailed('FAILED: Submit button is not displayed')
                }
            } else {
                KeywordUtil.markFailed('FAILED: Message text area is not displayed')
            }
        } else {
            KeywordUtil.markFailed('FAILED: Name field is not displayed')
        }
    } else {
        KeywordUtil.markFailed('FAILED: Test Case is failed due to other reason')
    }
} else {
    KeywordUtil.markFailed('FAILED: Unable to access Web Site')
}


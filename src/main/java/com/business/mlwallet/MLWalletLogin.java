package com.business.mlwallet;
import com.iosmlwalletpages.MLWalletLogOutPage;
import com.iosmlwalletpages.MLWalletLoginPage;
import com.iosmlwalletpages.MLWalletSettingsPage;
import org.openqa.selenium.WebElement;


import static com.utility.Utilities.*;


public class MLWalletLogin extends BaseClass {

    public MLWalletLogin() {
        super();

    }

    public static void mlWalletLogin(String sTier) throws Exception {
        waitTime(2000);
        type(MLWalletLoginPage.objMobileNumberTextField, sTier, "Mobile Number Text Field");
        waitTime(5000);
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        enterOTP("111111");
        waitTime(20000);
        handleMpin("1111", "MPin");
        waitTime(15000);
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("Application Logged In Successfully");
        } else {
            logger.info("Application not get Logged In Successfully");
        }
    }
    public static void mlWalletLogout() throws Exception {
        if (verifyElementPresent(MLWalletLogOutPage.objHamburgerMenu1, "Hamburger Menu")) {
            click(MLWalletLogOutPage.objHamburgerMenu1, "Hamburger Menu");
            waitTime(3000);
            click(MLWalletLogOutPage.objLogoutBtn, "Logout Button");
            waitTime(4000);
            click(MLWalletLogOutPage.objPopUpLogoutBtn,  "Logout Button");
            waitTime(3000);
            click(MLWalletLogOutPage.objChangeNumber, getTextVal(MLWalletLogOutPage.objChangeNumber, "Link"));
        }
        waitTime(3000);
        if (verifyElementPresent(MLWalletLoginPage.objLoginBtn, getTextVal(MLWalletLoginPage.objLoginBtn, "Link"))) {
            logger.info("Application Logged Out Successfully");
        } else {
            logger.info("Application not get Logged Out Successfully");
        }
    }

    public static void enterOTP(String OTP) throws Exception {
        waitTime(20000);
        if (verifyElementDisplayed(MLWalletLoginPage.objOtpContineBtn, "Continue Button Pop Up")) {
            click(MLWalletLoginPage.objOtpContineBtn, "OTP Continue Button");
        } else if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, "One Time Pin Page")) {
            explicitWaitVisible(MLWalletLoginPage.objOneTimePin, 20);
            waitTime(2000);
            verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
            verifyElementPresent(MLWalletLoginPage.objOtpTextField, "OTP text Field");
            waitTime(2000);
            type(MLWalletLoginPage.objOtpTextField, OTP, "OTP Text Field");
            waitTime(3000);
        } else {
            handleMpin("1111", "Entered");
            waitTime(8000);
        }
    }

    public static void handleMpin(String mPin, String validationText) throws Exception {
        for (int i = 0; i < mPin.length(); i++) {
            char ch = mPin.charAt(i);
            String ch1 = String.valueOf(ch);
            click(MLWalletSettingsPage.objEnterMpinVal(ch1),
                    getTextVal(MLWalletSettingsPage.objEnterMpinVal(ch1), "MPIN"));
        }
        logger.info(validationText + " MPIN " + mPin + " Successfully");
        extentLogger("Enter MPIN", "" + validationText + " MPIN " + mPin + " Successfully");
    }

    public static void changeNumberPage() throws Exception {
        try {
            waitTime(10000);
            if (verifyElementDisplayed(MLWalletLoginPage.objChangeNumber, getTextVal(MLWalletLoginPage.objChangeNumber, "Page"))) {
                waitTime(2000);
                click(MLWalletLoginPage.objChangeNumber, "Change Number Field");
                waitTime(10000);
            }
        } catch (Exception | AssertionError e) {
            logger.info("Change number page is not displayed");
            extentLogger("Change Number Page", "Change number page is not displayed");
        }
    }
    public static void mlWalletLogout1() throws Exception {
        if (verifyElementPresent(MLWalletLogOutPage.objHamburgerMenu1, "Hamburger Menu")) {
            click(MLWalletLogOutPage.objHamburgerMenu1, "Hamburger Menu");
            waitTime(2000);
            click(MLWalletLogOutPage.objLogoutBtn, getTextVal(MLWalletLogOutPage.objLogoutBtn, "Button"));
            waitTime(4000);
            click(MLWalletLogOutPage.objPopUpLogoutBtn, getTextVal(MLWalletLogOutPage.objPopUpLogoutBtn, "Button"));
            waitTime(3000);
            click(MLWalletLogOutPage.objChangeNumber, getTextVal(MLWalletLogOutPage.objChangeNumber, "Link"));
        }
        waitTime(3000);
        if (verifyElementPresent(MLWalletLoginPage.objLoginBtn, getTextVal(MLWalletLoginPage.objLoginBtn, "Link"))) {
            logger.info("Application Logged Out Successfully");
        } else {
            logger.info("Application not get Logged Out Successfully");
        }

    }

    //================================ Login ==========================================================//
    public void LogInScenarioWithValidMobNumber_Lgn_TC_01() throws Exception {
        HeaderChildNode("Login Scenarios With Valid Mobile Number");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("Lgn_TC_01, Logged In Successfully and redirected to Dashboard");
            extentLoggerPass("Lgn_TC_01", "Lgn_TC_01, Logged In Successfully and redirected to Dashboard");
            System.out.println("-----------------------------------------------------------");

        }
    }

    public void LogInScenarioWithInvalidMobNumber_Lgn_TC_02() throws Exception {
        HeaderChildNode("Login Scenarios With Invalid Mobile Number");
        changeNumberPage();
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("Invalid_MobileNumber"), "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        if (verifyElementPresent(MLWalletLoginPage.objInvalidMobNumberTxt, getTextVal(MLWalletLoginPage.objInvalidMobNumberTxt, "Error Message"))) {
            logger.info("Lgn_TC_02, Mobile number is Invalid Error Message is Displayed");
            extentLoggerPass("Lgn_TC_02", "Lgn_TC_02, Mobile number is Invalid Error Message is Displayed");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void LogInScenarioWithValidOTP_Lgn_TC_03() throws Exception {
        HeaderChildNode("Login Scenarios With Valid OTP");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("Lgn_TC_03, Logged In Successfully and redirected to Dashboard");
            extentLoggerPass("Lgn_TC_03", "Lgn_TC_03, Logged In Successfully and redirected to Dashboard");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void appLaunch_Lgn_TC_05() throws Exception {
        HeaderChildNode("App Launch");
        changeNumberPage();
        if(verifyElementPresent(MLWalletLoginPage.objLoginBtn,"Login Button")){
            logger.info("Lgn_TC_05, Application Launched Successfully");
            extentLoggerPass("Lgn_TC_05", "Lgn_TC_05, Application Launched Successfully");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginPageUIValidation_Lgn_TC_06() throws Exception {
        HeaderChildNode("Login Page UI Validation");
        changeNumberPage();
        if(verifyElementPresent(MLWalletLoginPage.objLoginBtn,"Login Button")){
            verifyElementPresent(MLWalletLoginPage.objMobileNumberTextField,  "Mobile Number Text Field");
            verifyElementPresent(MLWalletLoginPage.objTroubleSigningIn,getTextVal(MLWalletLoginPage.objTroubleSigningIn,"Button"));
            verifyElementPresent(MLWalletLoginPage.objHaveAnAccountMsg,getTextVal(MLWalletLoginPage.objHaveAnAccountMsg,"Message"));
            verifyElementPresent(MLWalletLoginPage.objCreateOneBtn,getTextVal(MLWalletLoginPage.objCreateOneBtn,"Button"));
            verifyElementPresent(MLWalletLoginPage.objBranchLocator,getTextVal(MLWalletLoginPage.objBranchLocator,"Button"));
            verifyElementPresent(MLWalletLoginPage.objAppVersion,getTextVal(MLWalletLoginPage.objAppVersion,"App Version"));
            logger.info("Lgn_TC_06, Login Page UI Validated");
            extentLoggerPass("Lgn_TC_06", "Lgn_TC_06,  Login Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginTroubleSigningIn_Lgn_TC_07() throws Exception {
        HeaderChildNode("LogIn Trouble Signing In Validation");
        changeNumberPage();
        if(verifyElementPresentAndClick(MLWalletLoginPage.objTroubleSigningIn,getTextVal(MLWalletLoginPage.objTroubleSigningIn,"Button"))){
            waitTime(5000);
            verifyElementPresent(MLWalletLoginPage.objTroubleSigningPage,getTextVal(MLWalletLoginPage.objTroubleSigningPage,"Page"));
            verifyElementPresent(MLWalletLoginPage.objMLWalletSupport,getTextVal(MLWalletLoginPage.objMLWalletSupport,"Header"));
            logger.info("Lgn_TC_07, Navigated to Trouble Signing In Page");
            extentLoggerPass("Lgn_TC_07", "Lgn_TC_07,  Navigated to Trouble Signing In Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginCreateOne_Lgn_TC_08() throws Exception {
        HeaderChildNode("LogIn Create One");
        changeNumberPage();
        if(verifyElementPresentAndClick(MLWalletLoginPage.objCreateOneBtn,getTextVal(MLWalletLoginPage.objCreateOneBtn,"Button"))){
            waitTime(5000);
            verifyElementPresent(MLWalletLoginPage.objRegistrationNumber,getTextVal(MLWalletLoginPage.objRegistrationNumber,"Page"));
            logger.info("Lgn_TC_08, Navigated to Create One Page");
            extentLoggerPass("Lgn_TC_08", "Lgn_TC_08, Navigated to Create One Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginBranchLocator_Lgn_TC_09() throws Exception {
        HeaderChildNode("LogIn Branch Locator");
        changeNumberPage();
        if(verifyElementPresentAndClick(MLWalletLoginPage.objBranchLocator,getTextVal(MLWalletLoginPage.objBranchLocator,"Button"))){
            waitTime(5000);
            verifyElementPresent(MLWalletLoginPage.objBranchLocator,getTextVal(MLWalletLoginPage.objBranchLocator,"Page"));
            logger.info("Lgn_TC_09, Navigated to Branch Locator Page");
            extentLoggerPass("Lgn_TC_09", "Lgn_TC_09, Navigated to Branch Locator Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginOTPPageUIValidation_Lgn_TC_10() throws Exception {
        HeaderChildNode("LogIn OTP Page UI Validation");
        changeNumberPage();
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        waitTime(3000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOtpTextField, "OTP text Field");
            //verifyElementPresent(MLWalletLoginPage.objResendCode, getTextVal(MLWalletCashOutPage.objResendCode, "Seconds"));
            //click(MLWalletLoginPage.objOk, "OK Button");
            logger.info("Lgn_TC_10, LogIn OTP Page UI Validated");
            extentLoggerPass("Lgn_TC_10", "Lgn_TC_10, LogIn OTP Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void loginWithExistingMobileNumber_Lgn_TC_17() throws Exception {
        HeaderChildNode("Login With Existing Mobile Number");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresent(MLWalletLogOutPage.objHamburgerMenu, "Hamburger Menu");
        click(MLWalletLogOutPage.objHamburgerMenu, "Hamburger Menu");
        waitTime(3000);
        click(MLWalletLogOutPage.objLogoutBtn, "Logout Button");
        waitTime(4000);
        click(MLWalletLogOutPage.objPopUpLogoutBtn,  "Logout Button");
        waitTime(3000);
        verifyElementPresent(MLWalletLogOutPage.objChangeNumber,"Mpin Page");
        handleMpin("1234", "Entered Mpin");
        explicitWaitVisible(MLWalletLoginPage.objAvailableBalance, 10);
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("Lgn_TC_17, Application Logged In Successfully");
            extentLoggerPass("Lgn_TC_17", "Lgn_TC_17, Application Logged In Successfully");
            System.out.println("-----------------------------------------------------------");
        } else {
            logger.info("Application not get Logged In Successfully");
        }
    }

    public void loginMPinPageUIValidation_Lgn_TC_18() throws Exception {
        HeaderChildNode("Login Mpin Page UI Validation");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresent(MLWalletLogOutPage.objHamburgerMenu, "Hamburger Menu");
        click(MLWalletLogOutPage.objHamburgerMenu, "Hamburger Menu");
        waitTime(3000);
        click(MLWalletLogOutPage.objLogoutBtn, "Logout Button");
        waitTime(4000);
        click(MLWalletLogOutPage.objPopUpLogoutBtn,  "Logout Button");
        waitTime(3000);
        if(verifyElementPresent(MLWalletLogOutPage.objChangeNumber,"Mpin Page")){
            verifyElementPresent(MLWalletLogOutPage.objChangeNumber,getTextVal(MLWalletLogOutPage.objChangeNumber,"button"));
            verifyElementPresent(MLWalletLoginPage.objTroubleSigningIn,getTextVal(MLWalletLoginPage.objTroubleSigningIn,"Button"));
            verifyElementPresent(MLWalletLoginPage.objBranchLocator,getTextVal(MLWalletLoginPage.objBranchLocator,"Button"));
            verifyElementPresent(MLWalletLoginPage.objAppVersionChangeNumber,getTextVal(MLWalletLoginPage.objAppVersionChangeNumber,"App Version"));
            logger.info("Lgn_TC_18, Application Logged In Successfully");
            extentLoggerPass("Lgn_TC_18", "Lgn_TC_18, Application Logged In Successfully");
            System.out.println("-----------------------------------------------------------");
        }
    }



    public void loginInAppOTPNavigation_Lgn_TC_22() throws Exception {
        HeaderChildNode("LogIn In App OTP Navigation");
        changeNumberPage();
        click(MLWalletLoginPage.objMobileNumberTextField, "Mobile Number Text Field");
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        waitTime(3000);
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        waitTime(10000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"));
            logger.info("Lgn_TC_22, LogIn In App OTP Navigation validated");
            extentLoggerPass("Lgn_TC_22", "Lgn_TC_22, LogIn In App OTP Navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginInAppOTPPageUIValidation_Lgn_TC_23() throws Exception {
        HeaderChildNode("Login InApp OTP Page UI Validation");
        changeNumberPage();
        click(MLWalletLoginPage.objMobileNumberTextField, "Mobile Number Text Field");
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        waitTime(3000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objOtpContineBtn,getTextVal(MLWalletLoginPage.objOtpContineBtn,"Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn,getTextVal(MLWalletLoginPage.objCancelBtn,"Button"));
            logger.info("Lgn_TC_23, LogIn In App OTP Navigation validated");
            extentLoggerPass("Lgn_TC_23", "Lgn_TC_23, LogIn In App OTP Navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginNewOTPAfterSixtySecondsValidation_Lgn_TC_24() throws Exception {
        HeaderChildNode("LogIn New OTP After Sixty Seconds Validation");
        changeNumberPage();
        click(MLWalletLoginPage.objMobileNumberTextField, "Mobile Number Text Field");
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        waitTime(2000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        if(verifyElementPresent(MLWalletLoginPage.objOTP,getTextVal(MLWalletLoginPage.objOTP,"One Time Pin"))){
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            waitTime(70000);
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP,sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("Lgn_TC_24, LogIn, After Sixty Seconds New OTP got generated is validated");
            extentLoggerPass("Lgn_TC_24", "Lgn_TC_24, LogIn, After Sixty Seconds New OTP got generated is validated");
            System.out.println("-----------------------------------------------------------");
        }
        getDriver().resetApp();
    }

    public void loginOTPCancelBtnFunctionality_Lgn_TC_25() throws Exception {
        HeaderChildNode("LogIn OTP Cancel Button Functionality");
        changeNumberPage();
        click(MLWalletLoginPage.objMobileNumberTextField, "Mobile Number Text Field");
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        explicitWaitVisible(MLWalletLoginPage.objOneTimePin, 5);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn,getTextVal(MLWalletLoginPage.objCancelBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletLoginPage.objLoginBtn,getTextVal(MLWalletLoginPage.objLoginBtn,"Button"))){
            logger.info("Lgn_TC_25, LogIn, After clicking on Cancel in One time pin popup App navigates to login Page validated");
            extentLoggerPass("Lgn_TC_25", "Lgn_TC_25, LogIn, After clicking on Cancel in One time pin popup App navigates to login Page validated");
            System.out.println("-----------------------------------------------------------");
        }
        getDriver().resetApp();
    }


    public void loginOTPContinueBtnFunctionality_Lgn_TC_26() throws Exception {
        HeaderChildNode("LogIn OTP Continue Button Functionality");
        changeNumberPage();
        click(MLWalletLoginPage.objMobileNumberTextField, "Mobile Number Text Field");
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objOtpContineBtn,getTextVal(MLWalletLoginPage.objOtpContineBtn,"Button"));
        waitTime(2000);
        if(verifyElementPresent(MLWalletLoginPage.objAvailableBalance,getTextVal(MLWalletLoginPage.objAvailableBalance,"Button"))){
            logger.info("Lgn_TC_26, LogIn, After clicking on Continue in One time pin popup App navigates to Home Page validated");
            extentLoggerPass("Lgn_TC_26", "Lgn_TC_26, LogIn, After clicking on Continue in One time pin popup App navigates to Home Page validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void LogInScenarioWithInvalidMobNumber_Lgn_TC_15() throws Exception {
        HeaderChildNode("Login Scenarios With Invalid Mobile Number");
        changeNumberPage();
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("AlphaNumericMobileNumber"), "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        if (verifyElementPresent(MLWalletLoginPage.objInvalidMobNumberTxt, getTextVal(MLWalletLoginPage.objInvalidMobNumberTxt, "Error Message"))) {
            logger.info("Lgn_TC_15, Mobile number is Invalid Error Message is Displayed");
            extentLoggerPass("Lgn_TC_15", "Lgn_TC_15, Mobile number is Invalid Error Message is Displayed");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginInvalidMPinValidation_Lgn_TC_27(String sTier,String OTP,String mPin) throws Exception {
        HeaderChildNode("Login Scenarios With Invalid Mpin validation");
        changeNumberPage();
        type(MLWalletLoginPage.objMobileNumberTextField,sTier, "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        waitTime(10000);
        if(verifyElementDisplayed(MLWalletLoginPage.objOtpContineBtn,  "Continue Button Pop Up"))
        {
            click(MLWalletLoginPage.objOtpContineBtn, "OTP Continue Button");
        }else
        {
            explicitWaitVisible(MLWalletLoginPage.objOneTimePin, 20);
            waitTime(2000);
            verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
            verifyElementPresent(MLWalletLoginPage.objOtpTextField, "OTP text Field");
            waitTime(2000);
            type(MLWalletLoginPage.objOtpTextField, OTP, "OTP Text Field");
            waitTime(3000);
        }
        waitTime(10000);
        handleMpin(mPin,"MPin field");
        waitTime(5000);
        if(verifyElementPresent(MLWalletLoginPage.objInvalidMPinMsg,getTextVal(MLWalletLoginPage.objInvalidMPinMsg,"Error msg"))){
            verifyElementPresent(MLWalletLoginPage.objCamPopUpOKBtn,getTextVal(MLWalletLoginPage.objCamPopUpOKBtn,"Button"));
            logger.info("Lgn_TC_27, Login Scenarios With Invalid Mpin Error Message validated");
            extentLoggerPass("Lgn_TC_27", "Lgn_TC_27, Login Scenarios With Invalid Mpin Error Message validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginEnterInvalidMPinAndBlock_Lgn_TC_28() throws Exception {
        HeaderChildNode("Login Enter Invalid MPin and block");
        waitTime(2000);
//        changeNumberPage();
//        mlWalletLogin("9999999995");
//        click(MLWalletLogOutPage.objHamburgerMenu, "Hamburger Menu");
//        waitTime(3000);
//        click(MLWalletLogOutPage.objLogoutBtn, "Logout Button");
//        waitTime(4000);
//        click(MLWalletLogOutPage.objPopUpLogoutBtn,  "Logout Button");
//        waitTime(3000);
//        verifyElementPresent(MLWalletLogOutPage.objChangeNumber, getTextVal(MLWalletLogOutPage.objChangeNumber, "Link"));
        for (int i = 0; i <= 6; i++) {
            handleMpin("1234", "MPin");
            waitTime(3000);
            if (verifyElementPresent(MLWalletLoginPage.obj24HoursBlockedMsg, getTextVal(MLWalletLoginPage.obj24HoursBlockedMsg, "Error Msg"))) {
                break;
            }waitTime(3000);
            click(MLWalletLoginPage.objOkBtn, getTextVal(MLWalletLoginPage.objOkBtn, "Button"));
        }
        if (verifyElementPresent(MLWalletLoginPage.obj24HoursBlockedMsg, getTextVal(MLWalletLoginPage.obj24HoursBlockedMsg, "Error Msg"))) {
            logger.info("Lgn_TC_28, Login Enter Invalid MPin and block validated");
            extentLoggerPass("Lgn_TC_28", "Lgn_TC_28, Login Enter Invalid MPin and block validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void loginMPinNavigation_LG_New_TC_01(String sTier,String OTP) throws Exception {
        HeaderChildNode("Login MPin page Navigation");
        changeNumberPage();
        type(MLWalletLoginPage.objMobileNumberTextField,sTier, "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        waitTime(10000);
        if(verifyElementDisplayed(MLWalletLoginPage.objOtpContineBtn,  "Continue Button Pop Up"))
        {
            click(MLWalletLoginPage.objOtpContineBtn, "OTP Continue Button");
        }else
        {
            explicitWaitVisible(MLWalletLoginPage.objOneTimePin, 20);
            waitTime(2000);
            verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
            verifyElementPresent(MLWalletLoginPage.objOtpTextField, "OTP text Field");
            waitTime(2000);
            type(MLWalletLoginPage.objOtpTextField, OTP, "OTP Text Field");
            waitTime(3000);
        }
        if(verifyElementPresent(MLWalletLoginPage.objChangeNumber,getTextVal(MLWalletLoginPage.objChangeNumber,"Header"))){
            logger.info("LG_New_TC_01, Login MPin page navigation validated");
            extentLoggerPass("LG_New_TC_01", "LG_New_TC_01, Login MPin page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginToAppWithChangeNumberUsingNewNumber_LG_New_TC_02() throws Exception {
        HeaderChildNode("Login to App with Change number using new number");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("ios_BranchVerified"));
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("LG_New_TC_02, Login to App with Change number using new number validated");
            extentLoggerPass("LG_New_TC_02", "LG_New_TC_02, Login to App with Change number using new number validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginToApplicationWithMPin_LG_New_TC_03() throws Exception {
        HeaderChildNode("Login to App with Mpin");
        changeNumberPage();
        mlWalletLogin(prop.getproperty("ios_BranchVerified"));
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("LG_New_TC_03, Login to App with Mpin validated");
            extentLoggerPass("LG_New_TC_03", "LG_New_TC_03, Login to App Mpin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }



}

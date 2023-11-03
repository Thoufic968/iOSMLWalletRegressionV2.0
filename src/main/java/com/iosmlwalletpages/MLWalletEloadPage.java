package com.iosmlwalletpages;

import org.openqa.selenium.By;

public class MLWalletEloadPage {


	public static By objEloadTab=By.xpath("//*[@name='PM3US2']");

	public static By objEloadtransactionPage=By.xpath("//*[@name='eLoad Transaction']");

	public static By objSelectTelco = By.xpath("//*[@label='Select Telco']");

	public static By objPhoneToLoad = By.xpath("//*[@label='Phone to load']");

	public static By objSelectFromContacts = By.xpath("//*[@label='Select from Contacts']");

	public static By telcoOptions(int indexTab)
	{
		return By.xpath("(//*[@name='P1S3TL']/descendant::XCUIElementTypeOther/child::XCUIElementTypeOther/child::XCUIElementTypeOther/child::XCUIElementTypeOther/child::XCUIElementTypeImage)["+indexTab+"]");
	}

	public static By objPromoLoads=By.xpath("(//*[XCUIElementTypeOther]/descendant::XCUIElementTypeScrollView/descendant::XCUIElementTypeOther)[11]");


	//	public static By objTelecommunicationTab=By.xpath("//*[android.view.ViewGroup]/following-sibling::android.view.ViewGroup/(descendant::android.widget.ImageView)[4]");
	public static By objMobileNoField=By.xpath("//*[@name='9** *** ****']/XCUIElementTypeTextField");

	public static By objNextBtn=By.xpath("(//*[@label='Next'])[2]");

	public static By objLoadSelectionPage=By.xpath("//*[@label='Load Selection']");

	public static By objPromoLoadTab=By.xpath("//*[@label='Promo Load']");

	public static By objRegularLoadTab = By.xpath("//*[@label='Regular Load']");

	public static By objTransaction=By.xpath("(//*[XCUIElementTypeOther]/descendant::XCUIElementTypeScrollView/descendant::XCUIElementTypeOther)[11]");

	public static By objContinuePromoPopUp=By.xpath("//*[@label='Would you like to continue with this promo?']");

	public static By objPromoName=By.xpath("(//*[android.view.ViewGroup]/child::android.view.ViewGroup/child::android.widget.TextView)[5]");

	//public static By objPromoConfirmationPopup = By.xpath("//*[@name='Would you ']");

	public static By objConfirmBtn=By.xpath("//*[@label='Confirm']");

	public static By obJconfirmBtnTwo = By.xpath("(//*[@name='Confirm'])[2]");

	public static By objCancelBtn = By.xpath("//*[@label='Cancel']");

	public static By objOTPCancelBtn = By.xpath("(//*[@name='CANCEL'])[3]");

	public static By objTransactionDetailsPage=By.xpath("//*[@label='Transaction Details']");

	public static By objTypeOfPromoUsed=By.xpath("(//*[@name='Type'])[3]");

	public static By objMobileNumber=By.xpath("(//*[@name='Mobile Number'])[3]");

	public static By objAmountToSend=By.xpath("(//*[@name='Amount to Send'])[3]");

	public static By objServiceFee=By.xpath("(//*[@name='Service Fee'])[3]");

	public static By objTotalAmount=By.xpath("(//*[@name='Total'])[3]");

	public static By objErrorMsg=By.xpath("//*[@name='Network and Mobile number does not match']");

	public static By objErrorMsgOne=By.xpath("//*[@name='Mobile number is required']");

	public static By objInsufficientBalPopup=By.xpath("//*[@name='There is insufficient balance to proceed with this transaction. Please try again.']");

	public static By objOkBtn=By.xpath("//*[@label='Ok']");

	public static By objMobileNumberInTransactionDetails = By.xpath("//*[@name='43NVTY']");

	public static By objELoadAmount = By.xpath("(//*[@name='Successfully bought load for']/following::XCUIElementTypeStaticText)[2]");

	public static By objBuyELoadTime = By.xpath("//*[@name='T66UCP']");

	public static By objBuyELoadStatus = By.xpath("(//*[@name='Successfully bought load for']/following::XCUIElementTypeStaticText)[4]");

	public static By objMaxLimitPopupMsg = By.xpath("//*[@label='The maximum E-load per transaction set for your verification level is P2,000.00. Please try again.']");

	public static By obj3000RegularLoad = By.xpath("(//XCUIElementTypeStaticText[@name='Globe Regular Load 3000'])[1]");

	public static By obj2000RegularLoad = By.xpath("(//XCUIElementTypeStaticText[@name='Globe Regular Load 2000'])[1]");

	public static By objBuyLoad = By.xpath("//*[@name='Buy Load']");

	public static By objLoadSelectionBackArrowBtn = By.xpath("//*[@name='']");

	public static By objMobileNumberInLoadSelection = By.xpath("//*[@name='Q4XIZZ']");

	public static By objChange =By.xpath("//*[@label='Change']");

	public static By objWalletBalanceInLoadSeletion = By.xpath("//*[@name='E90TP8']");

	public static By objLoadWithAmount = By.xpath("(//*[XCUIElementTypeStaticText])[2]");

	public static By objContacts =By.xpath("(//*[@label='Contacts'])[2]");

	public static By objListOfContacts = By.xpath("//*[@name='Contacts Favorites']/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeOther/descendant::XCUIElementTypeOther/child::XCUIElementTypeScrollView/child::XCUIElementTypeOther/descendant::XCUIElementTypeOther/child::XCUIElementTypeOther");

	public static By objFavorites =By.xpath("//*[@label='Favorites']");

	public static By objAllowBtn = By.xpath("//*[@label='Allow']");

	public static By objSearch = By.xpath("//*[@name='Search']/XCUIElementTypeTextField");

	public static By objSearchOne = By.xpath("//XCUIElementTypeTextField[@name='OO7ML4']");

	public static By objContactsBtn = By.xpath("(//*[@text='Contacts'])[2]");
	//	public static By objFavorites = By.xpath("//*[@text='Favorites']");
	public static By objContactsAndNumber(int i,int j){
		return By.xpath("(((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView' and ./parent::*[./parent::*[./parent::*[@class='android.widget.FrameLayout']]]]]/*[@class='android.view.ViewGroup'])["+i+"]/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']])[1]/*[@class='android.widget.TextView'])["+j+"]");
	}
	public static By objContactsPageBackBtn = By.xpath("//*[@name='']");

	public static By objInvalidPINMsg = By.xpath("//*[@name='You have entered an invalid PIN. Please try again.']");

	public static By objSearchedContactName = By.xpath("(//*[@name='Contacts Favorites']/following-sibling::XCUIElementTypeOther/child::XCUIElementTypeOther/descendant::XCUIElementTypeOther/child::XCUIElementTypeScrollView/child::XCUIElementTypeOther/descendant::XCUIElementTypeOther/child::XCUIElementTypeOther)[1]");

	public static By objSearchedContactNumber = By.xpath("(((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView' and ./parent::*[./parent::*[./parent::*[@class='android.widget.FrameLayout']]]]]/*[@class='android.view.ViewGroup'])[1]/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']])[1]/*[@class='android.widget.TextView'])[2]");

	//public static By objAddToFavoriteIcon = By.xpath("(//XCUIElementTypeOther[@name=''])[1]");

	public static By objAddToFavoriteIcon = By.xpath("(//*[XCUIElementTypeScrollView]/descendant::XCUIElementTypeOther/child::XCUIElementTypeOther/child::XCUIElementTypeOther/child::XCUIElementTypeOther/descendant::XCUIElementTypeOther/child::XCUIElementTypeOther/child::XCUIElementTypeOther)[3]");

	public static By objNoFavoritesFoundMsg = By.xpath("//*[@name='No favorites found']");

	//Loads
	public static By objGlobeRegLoad2000 = By.xpath("(//*[@name='Globe Regular Load 2000'])[1]");

	public static By objGlobeRegLoad3000 = By.xpath("(//*[@name='Globe Regular Load 3000'])[1]");

	public static By objLDLoad10 = By.xpath("(//*[@name='PHP 10 LD LD'])[2]");

	public static By objLDLoad2000 = By.xpath("(//*[@name='PHP 2000 LD2000 LD2000'])[2]");

	public static By objLDLoad3000 = By.xpath("(//*[@name='PHP 3000 LD3000 LD3000'])[2]");

	public static By objData10 = By.xpath("//XCUIElementTypeStaticText[@name=\"DATA 10\"]");

	public static By objLDLoad500 = By.xpath("(//*[@name='PHP 500 LD500 REGULAR LOAD'])[2]");

	public static By objMaxLimitErrorMsg = By.xpath("//*[@name='The maximum E-load per transaction set for your verification level is P2,000.00. Please try again.']");
	public static By objBuyLoadBackArrowBtn = By.xpath("//XCUIElementTypeOther[@name=\"\uE5CB\"]");

	public static By objSecondTimeConfirmationPopup = By.xpath("//XCUIElementTypeStaticText[@name='Would you like to continue with this promo?']");

	public static By objNoContactsFoundMsg = By.xpath("//*[@text='No contacts found']");
	public static By objBackToHomeBtn = By.xpath("//*[@text='Back To Home']");
	public static By objAppInfo = By.xpath("//*[@text='App info']");
	public static By objContactPopupMsg = By.xpath("//*[@resource-id='android:id/message']");
	public static By objAskMeLater = By.xpath("//*[@resource-id='android:id/button3']");
	public static By objAllowAccess = By.xpath("//*[@resource-id='android:id/button1']");
	public static By objNewTransaction = By.xpath("//*[@text='New Transaction']");
	public static By objFailedPaymentMsg = By.xpath("//XCUIElementTypeOther[@name=\"Ok\"]/preceding-sibling::XCUIElementTypeStaticText");
	public static By objRequestRefund = By.xpath("//XCUIElementTypeStaticText[@name=\"Request Refund\"]");
	public static By objRequestRefundBtn = By.xpath("(//XCUIElementTypeOther[@name=\"Request Refund\"])[2]");
	public static By objSelfServiceSupportForm = By.xpath("//XCUIElementTypeStaticText[@name=\"Self-Service Support Form\"]");

}
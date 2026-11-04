package co.qa.retail.constants;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AppConstants {
	/*
	 * Constants 1: Values that are not changing 2: are static 3: not dynamic 4:
	 * declare :: public static void >> public : accessible from anywhere in the
	 * project >> static: access them without creating their object >> final :
	 * values cannot be changed once assigned 5: Naming convention: Upper Case + _
	 * 
	 */
	// loginPage
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION = "route=account/login";

	// Handling hard-coded waits

	public static final int SHORT_DEFAULT_WAIT = 5;
	public static final int MEDIUM_DEFAULT_WAIT = 10;
	public static final int LONG_DEFAULT_WAIT = 20;
	public static final int POLLING_DEFAULT_WAIT = 2;

	// AccountPage
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_PAGE_URL_FRACTION = "route=account/account";
	public static final int ACCOUNT_PAGE_HEADERS_COUNT = 4;

	public static final List<String> ACCOUNTS_PAGE_HEADERS_LIST = Arrays.asList("My Account", "My Orders",
			"My Affiliate Account", "Newsletter");
	public static final String USER_REGISTER_SUCCESS_MESSAGE = "Your Account Has Been Created!";

}

package co.qa.retail.listener;

import org.testng.IRetryAnalyzer;

//public class Retry implements IRetryAnalyzer{
	/*	Retry
	 1: use the IRetryAnlyzer interface
	 2: Return faild test case
	 3: You can dicide how many times to retry a failed test
	 4:Not a selenium and it is a testng framework feature
	 5:Two ways to perform retry
	 	a: using the retry logic
	 	b: right -click project>refresh>
	 	should we use the retry logic in our framework?
	 	don't directly say yes or no!!
	 	>>while application is in early stages of development you are allow to use it.
	 	>> if you have net latency you can use it
	 	>> if your application slow -- RETAIL
	 	Reason Should not use it!!
	 	>> if your have LOCATOR ISSUES: XPATH--css...
	 	>> if you have Script issue : problems in automation script
	 	>> if your have Synchroniztion : wait time issues
	 	>> Application issue : Bugs -- Unexpected behavior
	 Do : Always diagnose the problem -- resolve it.
	 
	
	 */
//	private int count = 0;
//	private static int maxTry=3;
//	@Override
//	public boolean retry()

//}

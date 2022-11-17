package com.classplusapp.web.tests;

import static com.classplusapp.store.util.Constants.ADDCONTENT_SUBJECTIVETEST_TOTALMARKS;
import static com.classplusapp.store.util.Constants.SUBJECTIVETEST_TESTNAME;

import org.apache.log4j.Logger;

import com.classplusapp.web.pages.tutor.TutorAddContentPage;

public class CommonTest extends BaseClassplusAutomationTest {
	private TutorAddContentPage tutorAddContentPage = null;

	private static final Logger logger = Logger.getLogger(CommonTest.class.getName());

	public void subjectiveDetails(TutorAddContentPage tutorAddContentPage) {

		tutorAddContentPage.clickOnMenuSubjectiveTestIcon();

		tutorAddContentPage.clickOnNewCreateButton();

		tutorAddContentPage.setTestName(testDataProp.getProperty(SUBJECTIVETEST_TESTNAME));
		tutorAddContentPage.clickOnTextTotalMarks(testDataProp.getProperty(ADDCONTENT_SUBJECTIVETEST_TOTALMARKS));

	}
	public void clickOnCreateAndAdd(TutorAddContentPage tutorAddContentPage) {

	tutorAddContentPage.clickOnCreateAndAddTestButton();
	}


}

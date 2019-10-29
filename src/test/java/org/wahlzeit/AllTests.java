package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.handlers.TellFriendTest;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.services.mailing.EmailServiceTestSuite;
import org.wahlzeit.utils.UtilsTestSuite;

@RunWith(Suite.class)
@SuiteClasses({ TellFriendTest.class, UtilsTestSuite.class, EmailServiceTestSuite.class,
	ModelTestSuite.class})
public class AllTests {

}

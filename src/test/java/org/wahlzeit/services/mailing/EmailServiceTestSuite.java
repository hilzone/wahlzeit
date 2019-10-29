package org.wahlzeit.services.mailing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.services.EmailAddressTest;
import org.wahlzeit.services.LogBuilderTest;

@RunWith(Suite.class)
@SuiteClasses({ EmailServiceTest.class, EmailAddressTest.class, LogBuilderTest.class })
public class EmailServiceTestSuite {

}

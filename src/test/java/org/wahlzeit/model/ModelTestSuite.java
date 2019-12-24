package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccessRightsTest.class, CoordinateTest.class, FlagReasonTest.class, GenderTest.class, GuestTest.class,
		PhotoFilterTest.class, TagsTest.class, UserStatusTest.class, ValueTest.class, GamepadPhotoFactoryTest.class,
		GamepadPhotoManagerTest.class, CartesianCoordinateTest.class, GamepadManagerTest.class, GamepadTest.class, GamepadTypeTest.class  })
public class ModelTestSuite {

}

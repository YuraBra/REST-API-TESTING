package scooter;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import scooter.test.TestForActivateAccount;
import scooter.test.TestForAuthorizedUser;
import scooter.test.TestForNewUser;
import scooter.test.TestScooterStatus;
import scooter.test.TestScooters;

@RunWith(Categories.class)
@Suite.SuiteClasses({
        TestScooters.class,
        TestForNewUser.class,
        TestForActivateAccount.class,
        TestForAuthorizedUser.class,
        TestScooters.class,
        TestScooterStatus.class
})
public class RunScooterTests {
}

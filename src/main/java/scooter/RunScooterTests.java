package scooter;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import scooter.test.*;

@RunWith(Categories.class)
@Suite.SuiteClasses({
        TestScooters.class,
        TestForNewUser.class,
        TestForActivateAccount.class,
        TestForAuthorizedUser.class,
        TestForUserSolvency.class
})
public class RunScooterTests {
}

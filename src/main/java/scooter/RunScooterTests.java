package scooter;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import scooter.test.TestScooterStatus;
import scooter.test.TestScooters;

@RunWith(Categories.class)
@Suite.SuiteClasses({
        TestScooters.class,
        TestScooterStatus.class
})
public class RunScooterTests {
}

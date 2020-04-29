package scooter;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import scooter.test.TestScooters;

@RunWith(Categories.class)
@Suite.SuiteClasses({
        TestScooters.class
})
public class RunScooterTests {
}

package scooter;

import nasa.test.*;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Categories.class)
@Suite.SuiteClasses({
        TestForAPOD.class,
        TestForCME.class,
        TestForEarth.class,
        TestForMarsRoverPhotos.class,
        TestForSentry.class,
        TestForTechport.class
})
public class RunNasaTests {
}

package scooter.test;

import junitparams.JUnitParamsRunner;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(JUnitParamsRunner.class)
public class BaseTest {
    static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

        @Rule
        public TestWatcher watchman = new TestWatcher() {

            @Override
            public void starting(Description method) {
                logger.info("Run Test {}...", method.getMethodName());
            }

            @Override
            public void succeeded(Description method) {
                logger.info("Test {} succeeded.", method.getMethodName());
            }

            @Override
            public void failed(Throwable e, Description method) {
                logger.error("Test {} failed with {}.", method.getMethodName(), e);
            }
        };
}

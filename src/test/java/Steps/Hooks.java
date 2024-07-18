package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setup() {
        BaseTest.setup();
    }

    @After
    public void tearDown() {
        BaseTest.tearDown();
    }
}

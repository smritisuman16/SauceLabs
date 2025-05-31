package StepDefinitions;

import Screens.ScreenshotUtil;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;

public class Hooks {

    private final ScreenshotUtil screenshotUtil;

    public Hooks(ScreenshotUtil screenshotUtil) {
        this.screenshotUtil = screenshotUtil;
    }

    @Before
    public void before(Scenario scenario) {
        screenshotUtil.initializePDF(scenario);
    }

    @After
    public void after() {
        screenshotUtil.closePDF();
    }
}


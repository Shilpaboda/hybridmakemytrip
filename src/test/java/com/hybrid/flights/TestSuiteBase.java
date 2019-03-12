package com.hybrid.flights;

import com.hybrid.base.TestBase;
import com.hybrid.util.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestSuiteBase extends TestBase {
    @BeforeSuite
    public void checkSuiteSkip() throws IOException {
        intialize();
        if (!TestUtil.isSuiteRunnable(projectsuite,"flights")){
            throw  new SkipException("Runmode of the flights suite is set as no, so Skipping flights suite");
        }
    }
}

package com.hybrid.hotel;

import com.hybrid.base.TestBase;
import com.hybrid.util.TestUtil;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestSuiteBase extends TestBase {
    @BeforeSuite
    public void checksuitebase() throws IOException {
    intialize();
    if(!TestUtil.isSuiteRunnable(projectsuite,"hotel")){
        System.out.println("runmode of the hotel suite is set as no,it will skip hotelsuite");
    }

}}

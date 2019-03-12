package com.hybrid.home;

import com.hybrid.base.TestBase;
import com.hybrid.util.TestUtil;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestSuiteBase extends TestBase{

    @BeforeSuite
    public void checksuitskip() throws IOException {
      intialize();
    if(!TestUtil.isSuiteRunnable(projectsuite,"home")){
        System.out.println("Runmode of the home suite is set as no,skip home suite");
    }



}}

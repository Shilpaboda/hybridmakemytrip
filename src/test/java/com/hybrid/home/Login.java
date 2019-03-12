package com.hybrid.home;

import com.hybrid.util.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login extends TestSuiteBase{
    static int count=-1;
    @BeforeTest
    public void checkTestcaseSkip(){
        if(!TestUtil.isTestcaseRunnable(home, "Login")){
            throw new SkipException("Runmode of the Login test case is set as no, so skip Login test case");
        }
        runmodes = TestUtil.getTestdataRunmodes(home, "Login");

    }

    //test case creation:
    @Test(dataProvider = "getData")
    public void login(String uname, String pass){
        count++;
        if(!runmodes[count].equalsIgnoreCase("yes")){
            throw new SkipException("Runmode of the test data is set as no, so skipping row number: "+count);
        }
        //Excetion test case:
        System.out.println("Executing test cae with : "+ uname+" === "+pass);
        //webdriver code:
    }
    @DataProvider
    public Object[][] getData(){
        return TestUtil.getTestdata(home, "Login");
    }

}

package com.hybrid.flights;

import com.hybrid.util.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoundTripSearch extends TestSuiteBase {
    static int count=-1;
    @BeforeTest
    public void checktestcaseskip(){
        if(!TestUtil.isTestcaseRunnable(flights,"RoundTripSearch")){
            throw new SkipException("Runmode of the testcase roundtripsearch is as set no,skipping testcase ");
            }

            runmodes=TestUtil.getTestdataRunmodes(flights,"RoundTripSearch");
    }

    @Test(dataProvider = "getdata")
    public void roundtripsearch(String SortBy,String Products,String Departments,String Category){
        count++;

        if(!runmodes[count].equalsIgnoreCase("yes")){
            throw new SkipException("Runmode of the testcase roundtripsearch is as set no,skipping row number");
        }
    }
    @DataProvider
    public Object[][] getdata(){
        return TestUtil.getTestdata(flights,"RoundTripSearch");
    }
}

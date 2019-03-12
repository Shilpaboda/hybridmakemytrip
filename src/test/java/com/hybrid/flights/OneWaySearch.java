package com.hybrid.flights;

import com.hybrid.util.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OneWaySearch extends TestSuiteBase{
   static int count=-1;
    @BeforeTest

    public void checkTestcaseskip(){

        if(!TestUtil.isTestcaseRunnable(flights,"OneWaySearch")){
            throw new SkipException("Runmode of the testcase onewaysearch is set as no,skipping onewaysearch testcase");
        }

        runmodes=TestUtil.getTestdataRunmodes(flights,"OneWaySearch");
    }

    @Test(dataProvider = "getdata")
    public void onewaysearch(String From, String To,String Depart,String Class)
    {
        count++;
        if(!runmodes[count].equalsIgnoreCase("yes")){
            throw new SkipException("Runmode of the testcase onewaysearch is set as no,skipping row number");
        }
    }

    @DataProvider
    public Object[][] getdata(){
        return TestUtil.getTestdata(flights,"OneWaySearch");
    }



}

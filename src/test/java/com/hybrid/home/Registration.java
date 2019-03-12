package com.hybrid.home;

import com.hybrid.util.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Registration extends TestSuiteBase {
    static int count= -1;
    @BeforeTest
    public void checkTestCaseskip() {
        if (!TestUtil.isTestcaseRunnable(home, "Registration")) {
            throw new SkipException("Runmode of testcase is set as no,skip registration ");
        }

        runmodes = TestUtil.getTestdataRunmodes(home, "Registration");
    }
        @Test(dataProvider = "getdata")
        public void registration(String Title,String FirstName,String LastName,String Email,String Password,
                                       String DOB,String ContactTelephone,String HouseNumber,String Postcode){

            count++;
            if(!runmodes[count].equalsIgnoreCase("yes")){
               throw new SkipException("Runmodes of the Testdata is set as no,skip row number ");
            }
            //Executing test case:
                System.out.println("Executing test case with:    "+ Title+" == "+ FirstName+" == "+ LastName+" == "+ Email+" == "+ Password+" == "
                        + DOB+" == "+ ContactTelephone+" == "+ HouseNumber+" == "+ Postcode);

        }
        @DataProvider
        public Object[][] getdata(){
            return TestUtil.getTestdata(home,"Registration");
        }

}

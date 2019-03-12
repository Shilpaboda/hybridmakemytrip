package com.hybrid.hotel;
import com.hybrid.util.TestUtil;
import com.hybrid.util.XLS_Reader;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HotelSearch extends TestSuiteBase {

    static int count=-1;
    @BeforeTest
    public void checktestkip(){
        if(!TestUtil.isTestcaseRunnable(hotel,"HotelSearch")){
            throw new SkipException("Runmode of the testcase Hotelsearch is set as no,skipping hotelsearch testcase");

        }
        runmodes=TestUtil.getTestdataRunmodes(hotel,"HotelSearch");
    }

   @Test(dataProvider = "getdata")
   public void hotelsearch(String CityHotel,String Checkin,String Checkout,String RoomsGuests){
        count++;
        if(!runmodes[count].equalsIgnoreCase("yes")){
            throw new SkipException("Runmode of the testdata is set as no,skipping the rownumber");
        }
        System.out.println("Executing test case with: "+CityHotel+"  =  " +Checkin+" == "+ Checkout+" == "+  RoomsGuests);

        }




        @DataProvider
        public Object[][] getdata(){
            return TestUtil.getTestdata(hotel,"HotelSearch");

            }
        }







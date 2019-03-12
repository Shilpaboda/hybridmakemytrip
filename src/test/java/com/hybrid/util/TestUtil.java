package com.hybrid.util;

import com.hybrid.home.Registration;
import org.junit.runners.Suite;

public class TestUtil {
    public static void main(String[] args) {
        XLS_Reader xls = new XLS_Reader("/Users/shilpa/IdeaProjects/Hybridmakemytrip/src/test/java/com/hybrid/testdata/home.xlsx");

        System.out.println(isTestcaseRunnable(xls, "Registration"));

        getTestdataRunmodes(xls,"Registration");

        getTestdata(xls,"Registration");

    }

    public static boolean isSuiteRunnable(XLS_Reader xls, String Suitename) {

        boolean isExecutable = false;
        for (int i = 2; i <= xls.getRowCount("Testsuites"); i++) {

            String Suite = xls.getCellData("Testsuites", "TSID", i);
            String Runmode = xls.getCellData("Testsuites", "Runmode", i);
            System.out.println(Suite + "====" + Runmode);

            if (Suite.equalsIgnoreCase(Suitename)) {
                if (Runmode.equalsIgnoreCase("yes")) {
                    isExecutable = true;

                }
            }
        }
        return isExecutable = true;

    }

    //to get the runmode of the testcase/to check the runmode status
    public static boolean isTestcaseRunnable(XLS_Reader xls, String TestCaseName) {

        boolean isExecutable = false;
        for (int i = 2; i <= xls.getRowCount("Testcases"); i++) {

            String Testcasename = xls.getCellData("Testcases", "TCID", i);
            String Runmodes = xls.getCellData("Testcases", "Runmode", i);
            System.out.println(Testcasename + "=======" + Runmodes);

            if (Testcasename.equalsIgnoreCase(TestCaseName)) {
                if (Runmodes.equalsIgnoreCase("yes")) {
                    isExecutable = true;
                }
            }
        }
        return isExecutable;
    }


    public static String[] getTestdataRunmodes(XLS_Reader xls, String sheetName) {
        if (!xls.isSheetExist(sheetName)) {
            System.out.println("sheet not found");
        }
        int Rows = xls.getRowCount(sheetName);
        //declarate one array:
        String[] runmodes = new String[Rows - 1]; //array size declaration;
        for (int i = 2; i <= Rows; i++) {
            System.out.println(xls.getCellData(sheetName, "Runmode", i));
            //array values declaration:
            runmodes[i - 2] = xls.getCellData(sheetName, "Runmode", i);
        }
        return runmodes;
    }


    public static String[] getTestdataRunmodes1(XLS_Reader xls, String sheetName) {
        if (!xls.isSheetExist(sheetName)) {
            System.out.println("sheet not found");
        }
        int rows = xls.getRowCount(sheetName);
        String[] runmodes = new String[rows - 1];

        for (int i = 2; i <= rows; i++) {
            System.out.println(xls.getCellData(sheetName, "Runmode", i));

            runmodes[i - 2] = xls.getCellData(sheetName, "Runmode", i);

        }
        return runmodes;
    }


    public static Object[][] getTestdata(XLS_Reader xls,String sheetName) {
        if (!xls.isSheetExist(sheetName)) {
            System.out.println("sheet doest not exist");
        }

        int rows = xls.getRowCount(sheetName);
        int cols = xls.getColumnCount(sheetName);

        Object[][] data = new Object[rows - 1][cols - 1];
        for (int i = 2; i <= rows; i++) {
            for (int j = 0; j < cols - 1; j++) {
                System.out.print(xls.getCellData(sheetName, j, i)+" | ");
                data[i - 2][j] = xls.getCellData(sheetName, j, i);
            }
            System.out.println();
        }
       return  data;
    }

    }




























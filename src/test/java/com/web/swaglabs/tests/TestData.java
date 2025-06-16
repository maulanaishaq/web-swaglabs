package com.web.swaglabs.tests;

import com.web.swaglabs.utils.ExcelUtils;
import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "loginCredentials")
    public static Object[][] getLoginData() {
        return new Object[][] {
                {"standard_user", "secret_sauce"},
        };
    }


    @DataProvider(name = "loginFromExcel")
    public static Object[][] getExcelLoginData() {
        String path = "src/test/resources/testdata/loginData.xlsx";
        return ExcelUtils.getTestData(path, "Sheet1");
    }



}

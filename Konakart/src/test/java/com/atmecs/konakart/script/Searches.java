package com.atmecs.konakart.script;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.konakart.constant.Constants;
import com.atmecs.konakart.helper.Helper;
import com.atmecs.konakart.report.LogReport;
import com.atmecs.konakart.testbase.TestBase;
import com.atmecs.konakart.utility.Utility;
import com.atmecs.konakart.validation.Validation;

/**
 * In the search list box select any of the value from the drop down and perform
 * searches.(positive and negative test)
 * 
 * @author ranjitha.selvam
 *
 */
public class Searches extends TestBase {

	
	  @DataProvider
	  public Object[][] homePageData() throws IOException, InvalidFormatException 
	   { 
		  Object data[][] = Utility.getExcel(Constants.searchresultData_file, "Sheet1");
	  
		  return data; 
		  }
	 
	@Test(dataProvider="homePageData",priority=1)
	  public void positiveSearches(String positivesearches,String  negativesearches) throws IOException {
	  Helper.implicitWait(driver);
	  LogReport.info("positive searches....");
	  Helper.click(driver,Utility.propertyRead(Constants.selectLoc_file, "loc_dropdown_xpath_slt"));
	  Helper.selectIndex(driver, Utility.propertyRead(Constants.selectLoc_file,"loc_dropdown_xpath_slt"), 4);
	 
	  Helper.sendValues(driver, Utility.propertyRead(Constants.selectLoc_file,"loc_searchtext_xpath_txt"), "windows 8"); 
	  Helper.click(driver, Utility.propertyRead(Constants.selectLoc_file,"loc_search_xpath_btn"));
	 
	  String actualsearch1 = Helper.getText(driver,Utility.propertyRead(Constants.selectLoc_file,"loc_possearch_xpath_txt"));
	  
	  Validation.pageValidation(actualsearch1, positivesearches);
	  LogReport.info("products are available");
	  
	  }
	 

	
	  @Test(dataProvider="homePageData",priority=2)
	  
	  public void negativetiveSearches(String positivesearches,String  negativesearches) throws IOException
	  { 
		  
	  Helper.click(driver, Utility.propertyRead(Constants.selectLoc_file, "loc_dropdown_xpath_slt"));
	  Helper.selectIndex(driver, Utility.propertyRead(Constants.selectLoc_file, "loc_dropdown_xpath_slt"), 5);
	 
	  Helper.sendValues(driver, Utility.propertyRead(Constants.selectLoc_file, "loc_searchtext_xpath_txt"), "abcdefg");
	  Helper.click(driver, Utility.propertyRead(Constants.selectLoc_file, "loc_search_xpath_btn"));
		 
	  String actualSearch2 = Helper.getText(driver,Utility.propertyRead(Constants.selectLoc_file, "loc_negsearch_xpath_txt"));
	  
	  Validation.pageValidation(actualSearch2, negativesearches);
	  
	  
	  
	  
	  }
	 

   
  
  }
 
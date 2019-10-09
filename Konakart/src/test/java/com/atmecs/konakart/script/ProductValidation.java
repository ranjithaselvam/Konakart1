package com.atmecs.konakart.script;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.konakart.constant.Constants;
import com.atmecs.konakart.helper.Helper;
import com.atmecs.konakart.report.LogReport;
import com.atmecs.konakart.testbase.TestBase;
import com.atmecs.konakart.utility.Utility;

/**
 * Validate the content correctness in all the tabs (Product
 * description,specifications and Customer reviews). Perform sort with all the
 * combinations available and validate the correctness based on the sort
 * performed.(In customer reviews tab).
 * 
 * @author ranjitha.selvam
 *
 */
public class ProductValidation extends TestBase {
	@DataProvider
	public Object[][] imgPath() throws Exception {
		Object[][] data = Utility.getExcel(Constants.heroImgLoc_file, "Sheet1");
		return data;
	}

	@Test(dataProvider = "imgPath", priority = 1)
	public void contentCorrectness(String path, String textpath) throws IOException {

		Helper.implicitWait(driver);
		LogReport.info("clicking hero image");
		Helper.click(driver, Utility.propertyRead(Constants.productLoc_file, "loc_image_xpath_clk"));
		Helper.click(driver, path);
		Helper.getText(driver, textpath);

	}

	
	  @DataProvider 
	  public Object[][] sortReview() throws Exception { Object[][]
	  data = Utility.getExcel(Constants.customerReviewData_file, "Sheet1"); 
	  return data; 
	 }
	  
	  @Test( priority=2) 
	  public void customerReview(String categories) throws IOException
	  { 
		  LogReport.info("Inside customer review method");
		  
		  Helper.click(driver, Utility.propertyRead(Constants.productLoc_file,"loc_image_xpath_clk"));
		  Helper.scroll(driver, Utility.propertyRead(Constants.productLoc_file, "loc_customerreview_xpath_clk"));
		  Helper.selectByValue(driver, Utility.propertyRead(Constants.productLoc_file, "loc_sort_xpath_slt"),categories);
		  Helper.getText(driver,Utility.propertyRead(Constants.productLoc_file, "loc_sortlist_xpath_txt"));
	 
     }
	  
	  
	 
/*	@Test(priority = 2)
	public void customerReview() throws IOException {
		LogReport.info("sorting review");
		Helper.click(driver, Utility.propertyRead(Constants.productLoc_file, "loc_image_xpath_clk"));
		Helper.scroll(driver, Utility.propertyRead(Constants.productLoc_file, "loc_customerreview_xpath_clk"));
		Helper.selectIndex(driver, Utility.propertyRead(Constants.productLoc_file, "loc_sort_xpath_slt"), 2);
		Helper.getText(driver, Utility.propertyRead(Constants.productLoc_file, "loc_sortlist_xpath_txt"));
*/
	

}

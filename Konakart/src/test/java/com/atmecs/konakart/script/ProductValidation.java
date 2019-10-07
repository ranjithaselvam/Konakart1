package com.atmecs.konakart.script;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.konakart.constant.Constants;
import com.atmecs.konakart.helper.Helper;
import com.atmecs.konakart.testbase.TestBase;
import com.atmecs.konakart.utility.Utility;


/**
 * Validate the content correctness in all the tabs (Product description,specifications and Customer reviews).
 * Perform sort with all the combinations available and validate the correctness based on the sort performed.(In customer reviews tab).
 * @author ranjitha.selvam
 *
 */
public class ProductValidation extends TestBase{
	
	@Test(priority=1)
	public void contentCorrectness() throws IOException
	{
		Helper.implicitWait(driver);
		
		
		    Helper.click(driver, Utility.propertyRead(Constants.productLoc_file,"loc_image_xpath_clk"));
			Helper.getText(driver,Utility.propertyRead(Constants.productLoc_file,"loc_description_xpath_clk"));
			
			Helper.scroll(driver, Utility.propertyRead(Constants.productLoc_file,"loc_specification_xpath_clk"));
			Helper.getText(driver, Utility.propertyRead(Constants.productLoc_file, "loc_spetxt_xpath_txt"));
			Helper.click(driver, Utility.propertyRead(Constants.productLoc_file, "loc_customerreview_xpath_clk"));
			Helper.getText(driver, Utility.propertyRead(Constants.productLoc_file, "loc_custxt_xpath_txt"));
			
		}

	  @DataProvider
	  public Object[][] customerReviewPage() throws IOException, InvalidFormatException 
	   { 
		  Object data[][] = Utility.getExcel(Constants.customerreview_file, "Sheet1");
	  
		  return data; 
		  }
	 
	
	  @Test(dataProvider="customerReviewPage",priority=2)
	
		
	
	  public void customerReview(String categories,String review) throws IOException
	  {
		  Helper.click(driver, Utility.propertyRead(Constants.productLoc_file, "loc_sort_xpath_slt"));
		  Helper.selectByValue(driver, Utility.propertyRead(Constants.productLoc_file, "loc_sort_xpath_slt"), categories);
		  Helper.getText(driver,Utility.propertyRead(Constants.productLoc_file, "loc_sortlist_xpath_txt"));
		  
		  
	  }
				

		
	

}


package com.school.sms.constants;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public enum UserType {
		STUDENT, ADMIN, VENDOR, TEACHER;
	}

	public static final String[] MONTH_ARRAY = new String[] { "JANUARY",
			"FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST",
			"SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER" };
	
	public static final String[] BATCH_ARRAY = new String[] { "NURSERY",
		"LKG", "UKG", "STD 1", "STD 2", "STD 3", "STD 4",
		"STD 5", "STD 6", "STD 7", "STD 8","STD 9","STD 10","STD 11","STD 12"};
	
	public static final String[] SESSION_ARRAY = new String[] { "2010-2011",
		"2011-2012", "2012-2013", "2013-2014", "2014-2015", "2015-2016", "2016-2017", "2017-2018",
		"2018-2019", "2019-2020", "2020-2021", "2021-2022","2022-2023","2023-2024","2024-2024","2024-2025"};
	public static final String[] DESIGNATION_ARRAY = new String[] { "Teacher",
		"Principal", "Librarian", "Clerk", "Others"};
	
	public static final String[] GENDER_ARRAY = new String[] { "Male",
		"Female"};
	
	public static final String[] CUSTOMER_TYPE = new String[] { "Supplier",
	"Dealer"};
	
	public static final String[] PRODUCT_UOM = new String[] { "BAG",
		"BUCKET", "BOX", "BOOK", "SHEET", "TUBE" };

	public static final String[] YES_NO_ARRAY =  new String[] { "Yes",
		"No"};

	public static final String[] PURCHASE_TYPE_ARRAY = new String[] { "Credit",
		"Cash"};

	public static final String[] MAIL_TYPE= new String[] { "Fee Collection","Transport Pending","Fee Pending","Day Book"};
	
	public static final String[] MODE_OF_PAYMENT= new String[] { "Cash","Cheque","Draft"};;
	
	public static final String[] CLASS_SECTIONS= new String[] { "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
}

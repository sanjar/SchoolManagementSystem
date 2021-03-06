package com.school.sms.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.school.sms.model.FixedFeeBatchYearMonth;
import com.school.sms.model.StudentFeeDetails;
import com.school.sms.service.AbstractITextPdfView;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * @author www.codejava.net
 *
 */
public class PDFBuilder extends AbstractITextPdfView { 

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// get data model which is passed by the Spring container
		
		if("feeCollectionRequestDateWise".equalsIgnoreCase((String)model.get("feeCollectionRequestDateWise"))){
			generatePDFForFeeCollectionDateWise(model,doc,writer,request,response);
		}
		else if("feeCollectionRequest".equalsIgnoreCase((String)model.get("feeCollectionRequest"))){
			generatePDFForFeeCollection(model,doc,writer,request,response);
		}
		else if("feeCollectionDateSessionBatchWise".equalsIgnoreCase((String)model.get("feeCollectionType"))){
			generatePDFForFeeCollectionDateSessionBatchWise(model,doc,writer,request,response);
		}
		else if("transportfeePending".equalsIgnoreCase((String)model.get("reportType"))){
			generatePDFForPendingTransportFee(model,doc,writer,request,response);
		}
		else if("feeCollectionPending".equalsIgnoreCase((String)model.get("reportType"))){
			generatePDFForFeeCollectionPending(model,doc,writer,request,response);
		}
		else if("dayBook".equalsIgnoreCase((String)model.get("reportType"))){
			generatePDFForDayBook(model,doc,writer,request,response);
		}
		
	}

	

	private void generatePDFForDayBook(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws DocumentException {
		List<StudentFeeDetails> studentFixedFeeDetailsList = (List<StudentFeeDetails>) model.get("studentFixedFeeDetails");
		Map<String,String> enrolementFatherMap = (Map<String,String> ) model.get("enrolementFatherMap");
		String date = (String) model.get("date");
		Double totalFeeCollection = (Double) model.get("totalFeeCollection");
		Double totalPurchaseAmount = (Double) model.get("totalPurchaseAmount");
		Double totalSalesAmount = (Double) model.get("totalSalesAmount");
		Double totalOtherPaymentsAmount = (Double) model.get("totalOtherPaymentsAmount");
		doc.add(new Paragraph("DAY BOOK"));
		doc.add(new Paragraph("Date : "+date));
		
		
		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] {4.0f, 3.0f, 3.0f});
		table.setSpacingBefore(10);
		
		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		font.setSize(10);
		
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);
		
			
		
		cell.setPhrase(new Phrase("Header", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Earnings", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Expenses", font));
		table.addCell(cell);
		
		
		PdfPCell cell1 = new PdfPCell();
		cell1.setBackgroundColor(BaseColor.WHITE);
		cell1.setPadding(5);
		Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
		font1.setColor(BaseColor.BLACK);
		font1.setSize(10);
		Double totalAmount=0.00;
		Double netBalance = (totalFeeCollection+totalSalesAmount)-(totalPurchaseAmount+totalOtherPaymentsAmount);
		table.addCell(getCell(cell1, "Total Fee Collection", font1, 1, Element.ALIGN_CENTER));
		table.addCell(getCell(cell1,  String.valueOf(totalFeeCollection), font1, 1, Element.ALIGN_CENTER));
		table.addCell(getCell(cell1, "", font1, 1, Element.ALIGN_CENTER));
		table.addCell(getCell(cell1, "Total Purchase Amount", font1, 1, Element.ALIGN_CENTER));
		table.addCell(getCell(cell1, "", font1, 1, Element.ALIGN_CENTER));
		table.addCell(getCell(cell1,String.valueOf(totalPurchaseAmount),font1,5,Element.ALIGN_CENTER));
		table.addCell(getCell(cell1, "Total Sales Amount", font1, 1, Element.ALIGN_CENTER));
		table.addCell(getCell(cell1, String.valueOf(totalSalesAmount), font1, 1, Element.ALIGN_CENTER));
		table.addCell(getCell(cell1,"",font1,5,Element.ALIGN_RIGHT));
		table.addCell(getCell(cell1, "Total Other Payments", font1, 1, Element.ALIGN_CENTER));
		table.addCell(getCell(cell1, "", font1, 1, Element.ALIGN_CENTER));
		table.addCell(getCell(cell1,String.valueOf(totalOtherPaymentsAmount),font1,1,Element.ALIGN_CENTER));
		table.addCell(getCell(cell1," ",font1,3,Element.ALIGN_RIGHT));
		table.addCell(getCell(cell1,"Total Earnings : ",font1,2,Element.ALIGN_RIGHT));
		table.addCell(getCell(cell1,String.valueOf(totalFeeCollection+totalSalesAmount),font1,1,Element.ALIGN_RIGHT));
		table.addCell(getCell(cell1,"Total Expenses : ",font1,2,Element.ALIGN_RIGHT));
		table.addCell(getCell(cell1,String.valueOf(totalPurchaseAmount+totalOtherPaymentsAmount),font1,1,Element.ALIGN_RIGHT));
		table.addCell(getCell(cell1,"Net Balance : ",font1,2,Element.ALIGN_RIGHT));
		table.addCell(getCell(cell1,String.valueOf(netBalance),font1,1,Element.ALIGN_RIGHT));
		doc.add(table);
		
	}



	private void generatePDFForFeeCollectionPending(Map<String, Object> model,
			Document doc, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws DocumentException {
		List<StudentFeeDetails> studentFixedFeeDetailsList = (List<StudentFeeDetails>) model.get("studentFixedFeeDetails");
		Map<String,String> enrolementFatherMap = (Map<String,String> ) model.get("enrolementFatherMap");
		String month = (String) model.get("month");
		String batch = (String) model.get("batch");
		String session = (String) model.get("session");
		doc.add(new Paragraph("Fee Collection Pending Report"));
		doc.add(new Paragraph("Session : "+session));
		doc.add(new Paragraph("batch : "+ batch));
		doc.add(new Paragraph("Month : "+month));
		
		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] {2.2f, 2.0f, 2.2f, 3.0f, 3.0f,2.0f});
		table.setSpacingBefore(10);
		
		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		font.setSize(10);
		
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);
		
			
		
		cell.setPhrase(new Phrase("Enrolement No", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Student Name", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Batch", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Month", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Parent Name", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Pending Amount", font));
		table.addCell(cell);
		
		PdfPCell cell1 = new PdfPCell();
		cell1.setBackgroundColor(BaseColor.WHITE);
		cell1.setPadding(5);
		Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
		font1.setColor(BaseColor.BLACK);
		font1.setSize(10);
		Double totalAmount=0.00;
		for(StudentFeeDetails detail: studentFixedFeeDetailsList){
			if(detail.getPreviousDue()!=0.0 && detail.getPreviousDue()!=null){
			Double due = detail.getPreviousDue();
			
			table.addCell(getCell(cell1,detail.getEnrolementNo(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,detail.getStudentName(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,detail.getBatch(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,detail.getMonth(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,String.valueOf(enrolementFatherMap.get(detail.getEnrolementNo())),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,String.valueOf(due),font1,1,Element.ALIGN_CENTER));
			totalAmount=totalAmount+due;
			}
		}
		table.addCell(getCell(cell1,"Total Collection ",font1,5,Element.ALIGN_RIGHT));
		table.addCell(getCell(cell1,String.valueOf(totalAmount),font1,1,Element.ALIGN_RIGHT));
		doc.add(table);
		
	}



	private void generatePDFForPendingTransportFee(Map<String, Object> model,
			Document doc, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws DocumentException {
		List<StudentFeeDetails> studentFixedFeeDetailsList = (List<StudentFeeDetails>) model.get("studentFixedFeeDetails");
		Map<String,String> enrolementFatherMap = (Map<String,String> ) model.get("enrolementFatherMap");
		String month = (String) model.get("month");
		doc.add(new Paragraph("Transport Fee Pending Report"));
		doc.add(new Paragraph("Month : "+month));
		
		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] {2.2f, 2.0f, 2.2f, 3.0f, 3.0f,2.0f});
		table.setSpacingBefore(10);
		
		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		font.setSize(10);
		
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);
		
			
		
		cell.setPhrase(new Phrase("Enrolement No", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Student Name", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Batch", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Month", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Parent Name", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Pending Transport Amount", font));
		table.addCell(cell);
		
		PdfPCell cell1 = new PdfPCell();
		cell1.setBackgroundColor(BaseColor.WHITE);
		cell1.setPadding(5);
		Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
		font1.setColor(BaseColor.BLACK);
		font1.setSize(10);
		Double totalAmount=0.00;
		for(StudentFeeDetails detail: studentFixedFeeDetailsList){
			if(detail.getTransportDues()!=0.00 && detail.getTransportDues()!=null){
			table.addCell(getCell(cell1,detail.getEnrolementNo(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,detail.getStudentName(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,detail.getBatch(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,detail.getMonth(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,String.valueOf(enrolementFatherMap.get(detail.getEnrolementNo())),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,String.valueOf(detail.getTransportDues()),font1,1,Element.ALIGN_CENTER));
			totalAmount=totalAmount+detail.getTransportDues();
			}
		}
		table.addCell(getCell(cell1,"Total Collection ",font1,5,Element.ALIGN_RIGHT));
		table.addCell(getCell(cell1,String.valueOf(totalAmount),font1,1,Element.ALIGN_RIGHT));
		doc.add(table);
		
	}



	private void generatePDFForFeeCollectionDateSessionBatchWise(
			Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws DocumentException {
		List<StudentFeeDetails> feeCollectionDateSessionBatchWiseList = (List<StudentFeeDetails>) model.get("feeCollectionDateSessionBatchWiseList");
		String session = (String) model.get("session");
		String batch = (String) model.get("batch");
		doc.add(new Paragraph("Fee Collection Details"));
		doc.add(new Paragraph("From : "+model.get("fromDate")+"   to : "+ model.get("toDate")));
		doc.add(new Paragraph("Session : "+session));
		doc.add(new Paragraph("Batch : "+batch));
		
		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] {2.2f, 2.0f, 2.2f, 3.0f, 3.0f,2.0f,1.8f,2.0f});
		table.setSpacingBefore(10);
		
		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		font.setSize(10);
		
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);
		
		// write table header 
		cell.setPhrase(new Phrase("Date", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Session", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Batch", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Enrolement No", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Student Name", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Month", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Receipt No", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Amount", font));
		table.addCell(cell);
		
		PdfPCell cell1 = new PdfPCell();
		cell1.setBackgroundColor(BaseColor.WHITE);
		cell1.setPadding(5);
		Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
		font1.setColor(BaseColor.BLACK);
		font1.setSize(5);
		Double totalAmount=0.00;
		for(StudentFeeDetails detail: feeCollectionDateSessionBatchWiseList){
			table.addCell(getCell(cell1,detail.getDateOfPayment(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,detail.getSession(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,detail.getBatch(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,detail.getEnrolementNo(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,detail.getStudentName(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,detail.getMonth(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,String.valueOf(detail.getReceiptNo()),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,String.valueOf(detail.getAmountReceived()),font1,1,Element.ALIGN_CENTER));
			totalAmount=totalAmount+detail.getAmountReceived();
		}
		table.addCell(getCell(cell1,"Total Collection ",font1,7,Element.ALIGN_RIGHT));
		table.addCell(getCell(cell1,String.valueOf(totalAmount),font1,1,Element.ALIGN_RIGHT));
		doc.add(table);
		
	}



	private void generatePDFForFeeCollection(Map<String, Object> model,
			Document doc, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response)  throws Exception{
		List<StudentFeeDetails> studentFixedFeeDetailsList = (List<StudentFeeDetails>) model.get("studentFixedFeeDetails");
		Map<String,String> enrolementFatherMap = (Map<String,String> ) model.get("enrolementFatherMap");
		String month = (String) model.get("month");
		String session = (String) model.get("session");
		String batch = (String) model.get("batch");
		doc.add(new Paragraph("Fee Collection Details"));
		doc.add(new Paragraph("Month : "+month));
		
		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] {2.2f, 2.0f, 2.2f, 3.0f, 3.0f,2.0f,1.8f,2.0f});
		table.setSpacingBefore(10);
		
		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		font.setSize(10);
		
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);
		
		// write table header 
		cell.setPhrase(new Phrase("Date", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Session", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Batch", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Enrolement No", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Student Name", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Month", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Receipt No", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Amount", font));
		table.addCell(cell);
		
		PdfPCell cell1 = new PdfPCell();
		cell1.setBackgroundColor(BaseColor.WHITE);
		cell1.setPadding(5);
		Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
		font1.setColor(BaseColor.BLACK);
		font1.setSize(5);
		Double totalAmount=0.00;
		for(StudentFeeDetails detail: studentFixedFeeDetailsList){
			if(month.equalsIgnoreCase(detail.getMonth()) && session.equalsIgnoreCase(detail.getSession()) && batch.equalsIgnoreCase(detail.getBatch())){
			table.addCell(getCell(cell1,detail.getDateOfPayment(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,detail.getSession(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,detail.getBatch(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,detail.getEnrolementNo(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,detail.getStudentName(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,detail.getMonth(),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,String.valueOf(detail.getReceiptNo()),font1,1,Element.ALIGN_CENTER));
			table.addCell(getCell(cell1,String.valueOf(detail.getAmountReceived()),font1,1,Element.ALIGN_CENTER));
			totalAmount=totalAmount+detail.getAmountReceived();
			}
		}
		table.addCell(getCell(cell1,"Total Collection of "+month,font1,7,Element.ALIGN_RIGHT));
		table.addCell(getCell(cell1,String.valueOf(totalAmount),font1,1,Element.ALIGN_RIGHT));
		doc.add(table);
		
	}



	private PdfPCell getCell(PdfPCell cell1, String text, Font font,int span, int align) {
		cell1.setPhrase(new Phrase(text, font));
		cell1.setColspan(span);
		cell1.setHorizontalAlignment(align);
		return cell1;
	}
	
	
	private void generatePDFForFeeCollectionDateWise(Map<String, Object> model,
			Document doc, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		doc.setPageSize(PageSize.LETTER_LANDSCAPE.rotate());
		doc.add(new Paragraph("Fee Collection Details Header Wise"));
		doc.add(new Paragraph("From : "+model.get("fromDate")+"   to : "+ model.get("toDate")));
		
		PdfPTable table = new PdfPTable(23);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] {1.2f, 1.0f, 1.2f, 1.0f, 1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f});
		table.setSpacingBefore(2);
		
		// define font for table header row
				Font font = FontFactory.getFont(FontFactory.HELVETICA);
				font.setColor(BaseColor.WHITE);
				font.setSize(5);
				
				// define table header cell
				PdfPCell cell = new PdfPCell();
				cell.setBackgroundColor(BaseColor.BLUE);
				cell.setPadding(2);
				
				// write table header 
				cell.setPhrase(new Phrase("Enrolement No", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("Batch", font));
				table.addCell(cell);

				cell.setPhrase(new Phrase("Student Name", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("Receipt No", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("Month", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("Date Of Payment", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("Examination Fee", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("Maintainance Fee", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("Tuition Fee", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("ReportCard Fee", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("Book Fee", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("Icard Fee", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("Water Electricity Fee", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("Misc Fee", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("Sports Culture Fee", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("Activity Fee", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("Registration Fee", font));
				table.addCell(cell);
				
				
				cell.setPhrase(new Phrase("Late Fine", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("Other Fine", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("Discount", font));
				table.addCell(cell);
				cell.setPhrase(new Phrase("Concession", font));
				table.addCell(cell);
				cell.setPhrase(new Phrase("Previous Due", font));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase("Amount Received", font));
				table.addCell(cell);
				
				PdfPCell cell1 = new PdfPCell();
				cell1.setBackgroundColor(BaseColor.WHITE);
				cell1.setPadding(2);
				Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
				font1.setColor(BaseColor.BLACK);
				font1.setSize(5);
				Double totalAmount=0.00;
				List<FixedFeeBatchYearMonth> fixedFeeList= (List<FixedFeeBatchYearMonth>) model.get("fixedFeeList");
				SimpleDateFormat format = new SimpleDateFormat("DD/MM/YYYY");
				Date fromDate = format.parse((String) model.get("fromDate"));
				Date toDate = format.parse((String) model.get("toDate"));
				for(StudentFeeDetails detail: (List<StudentFeeDetails>) model.get("studentFixedFeeDetails")){
				
				 if(!detail.getDateOfPayment().isEmpty() && fromDate.compareTo(format.parse(detail.getDateOfPayment()))<=0 && toDate.compareTo(format.parse(detail.getDateOfPayment()))>=0){ 
					table.addCell(getCell(cell1,detail.getEnrolementNo(),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,detail.getBatch(),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,detail.getStudentName(),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,String.valueOf(detail.getReceiptNo()),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,detail.getMonth(),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,detail.getDateOfPayment(),font1,1,Element.ALIGN_CENTER));
					FixedFeeBatchYearMonth fixedFee = getFixedFee(fixedFeeList,detail.getFixedFeeId());
					table.addCell(getCell(cell1,String.valueOf(fixedFee.getExaminationFee()),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,String.valueOf(fixedFee.getMaintainanceFee()),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,String.valueOf(fixedFee.getTuitionFee()),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,String.valueOf(fixedFee.getReportCardFee()),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,String.valueOf(fixedFee.getBookFee()),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,String.valueOf(fixedFee.getIcardFee()),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,String.valueOf(fixedFee.getWaterElectricFee()),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,String.valueOf(fixedFee.getMiscFee()),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,String.valueOf(fixedFee.getSportsCultureFee()),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,String.valueOf(fixedFee.getActivityFee()),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,String.valueOf(fixedFee.getRegistrationFee()),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,String.valueOf(detail.getLateFine()),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,String.valueOf(detail.getOtherFine()),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,String.valueOf(detail.getDiscount()),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,String.valueOf(detail.getConcession()),font1,1,Element.ALIGN_CENTER));
					table.addCell(getCell(cell1,String.valueOf(detail.getPreviousDue()),font1,1,Element.ALIGN_CENTER));
					
					
					
					
					table.addCell(getCell(cell1,String.valueOf(detail.getAmountReceived()),font1,1,Element.ALIGN_CENTER));
					totalAmount=totalAmount+detail.getAmountReceived();
				}
				}
				table.addCell(getCell(cell1,"Total Collection" ,font1,22,Element.ALIGN_RIGHT));
				table.addCell(getCell(cell1,String.valueOf(totalAmount),font1,1,Element.ALIGN_RIGHT));
				doc.add(table);
	}



	private FixedFeeBatchYearMonth getFixedFee(
			List<FixedFeeBatchYearMonth> fixedFeeList, Integer fixedFeeId) {
		for(FixedFeeBatchYearMonth fixedFee:fixedFeeList){
			if(fixedFeeId.equals(fixedFee.getFixedFeeId())){
				return fixedFee;
			}
		}
		return new FixedFeeBatchYearMonth();
	}

}
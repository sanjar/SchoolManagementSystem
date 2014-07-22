package com.school.sms.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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
		List<StudentFeeDetails> studentFixedFeeDetailsList = (List<StudentFeeDetails>) model.get("studentFixedFeeDetails");
		Map<String,String> enrolementFatherMap = (Map<String,String> ) model.get("enrolementFatherMap");
		String month = (String) model.get("month");
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
		font1.setSize(10);
		Double totalAmount=0.00;
		for(StudentFeeDetails detail: studentFixedFeeDetailsList){
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

}
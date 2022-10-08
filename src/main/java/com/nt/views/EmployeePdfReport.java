package com.nt.views;

import java.util.ArrayList;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.model.Employee;
@Component("pdfreport")
public class EmployeePdfReport extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		Iterable<Employee> iterable = (Iterable<Employee>)model.get("empList");
		Iterable<Employee> employees=iterable;
		Paragraph paragraph = new Paragraph("Employee Report", new Font(Font.TIMES_ROMAN));
		document.add(paragraph);
		Table table=new Table(5, ((ArrayList<Employee>)employees).size());
		for(Employee emp:employees)
		{
			table.addCell(emp.getEmpno().toString());
			table.addCell(emp.getEname());
			table.addCell(emp.getMgr());
			table.addCell(emp.getJob());
			table.addCell(emp.getSalary().toString());
		}
		document.add(table);
	}

}

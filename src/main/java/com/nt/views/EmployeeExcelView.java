package com.nt.views;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;
//import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.nt.model.Employee;
@Component("excelreport")
public class EmployeeExcelView  extends AbstractXlsView{
	private int rowCount=1;
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"my-xlsx-file.xlsx\"");

        @SuppressWarnings("unchecked")
        Iterable<Employee> employees = (Iterable<Employee>) model.get("empList");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Employee Report");

        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("EMPNO");
        header.createCell(1).setCellValue("Name");
        header.createCell(2).setCellValue("MANAGER");
        header.createCell(3).setCellValue("JOB");
        header.createCell(4).setCellValue("SALARY");

        // Create data cells
        employees.forEach(employee->{
        	Row empRow=sheet.createRow(rowCount);
        	empRow.createCell(0).setCellValue(employee.getEmpno());
        	empRow.createCell(1).setCellValue(employee.getEname());
        	empRow.createCell(2).setCellValue(employee.getMgr());
        	empRow.createCell(3).setCellValue(employee.getJob());
        	empRow.createCell(4).setCellValue(employee.getSalary());
        	rowCount++;
        });
        /*for (Course course : courses){
            Row courseRow = sheet.createRow(rowCount++);
            courseRow.createCell(0).setCellValue(course.getId());
            courseRow.createCell(1).setCellValue(course.getName());
            courseRow.createCell(2).setCellValue(DATE_FORMAT.format(course.getDate()));
        }*/
		
	}

}

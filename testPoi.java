package com.mkyong.config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class PoiTest {


	public static void  main(String[] args) throws IOException {

            HashMap<String,String> map = new HashMap<String,String>();
            
            map.put("Etablissements", "Etab1,Etab2,Etab3,Etab4,Etab1,Etab2,Etab3,Etab4,Etab1,Etab2,Etab3,Etab4,Etab1,Etab2,Etab3,Etab4");
           map.put("nat", "aaaaaaaaaaaaaaaa");
           map.put("nat1", "aaaaaaaaaaaaaBBBaaa");
           map.put("nat2", "aaaaaXaaaaaaaaaaa");
           map.put("nat3", "aaaRaaaaaaaaaaaaa");
           map.put("nat4", "aaTaaaaaaaaaaaaaa");
           map.put("nat5", "aaaTaaaaaaaaaaaaa");
           map.put("nat6", "aaaYaaaaaaaaaaaaa");

	        createExcelMultiplicationTable(map);

	        System.out.println("Process successful executed");
	    }

	    private static void createExcelMultiplicationTable(HashMap<String,String> filtresList) throws IOException {
	        Workbook workbook = new HSSFWorkbook();
	        
	        Sheet sheetFiltre = workbook.createSheet("Filtres");
	        CreationHelper createHelper = workbook.getCreationHelper();
	        CellStyle headerStyle = getHeaderStyle(workbook);
            CellStyle columnStyle = getColumnStyle(workbook);
            CellStyle titleStye = getTitleStyle(workbook);
            
            Row rowTitle = sheetFiltre.createRow(3);
            Cell cellTitle = rowTitle.createCell(0);
            cellTitle.setCellValue("Recherche Effectuée le :");
            cellTitle.setCellStyle(titleStye);
            
            Cell dateTitle = rowTitle.createCell(1);
            
            titleStye.setDataFormat(
                createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
            dateTitle.setCellValue(new Date());
            dateTitle.setCellStyle(titleStye);
            
            
            
            Row rowFiltre = sheetFiltre.createRow(5);
            Cell filtreTitle = rowFiltre.createCell(1);
            filtreTitle.setCellValue("Filtres :");
            filtreTitle.setCellStyle(titleStye);
            
            
            int i = 7;
            for(String filtre : filtresList.keySet()){
            	
	            Row row = sheetFiltre.createRow(i);
	            
	            Cell cell = row.createCell(3);		        
	            cell.setCellValue(filtre);
                cell.setCellStyle(headerStyle);
                
                Cell cellValue = row.createCell(4);		        
                cellValue.setCellValue(filtresList.get(filtre));
                cellValue.setCellStyle(columnStyle);
                
	              
	            i++;
	        }
            
            
	        
            sheetFiltre.autoSizeColumn(0, true);
            sheetFiltre.setColumnWidth(1, 8000);
            sheetFiltre.autoSizeColumn(3, true);


            List<String>  mList = getList();
            
	        Sheet sheetResult = workbook.createSheet("Résultat");

	        addHeaders(sheetResult,headerStyle);
	        i=4;
            for(String s : mList) {
	            Row row = sheetResult.createRow(i);
            	Cell cell = row.createCell(3);		        
	            cell.setCellValue(s);
                cell.setCellStyle(columnStyle);
                i++;
            	
            }

	        FileOutputStream out = new FileOutputStream("C:\\Users\\lenovo\\Desktop\\IT\\test.xls");
	        workbook.write(out);
	        out.close();
	  }

private static CellStyle  getHeaderStyle (Workbook workbook) {
	
	CellStyle style = workbook.createCellStyle();

	style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
    
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

    	                    
	style.setBottomBorderColor(IndexedColors.BLUE.getIndex());
	style.setBorderLeft(BorderStyle.THIN);
	style.setLeftBorderColor(IndexedColors.BLUE.getIndex());
	style.setBorderRight(BorderStyle.THIN);
	style.setRightBorderColor(IndexedColors.BLUE.getIndex());
    style.setBorderTop(BorderStyle.THIN);
    style.setTopBorderColor(IndexedColors.BLUE.getIndex());
    style.setAlignment(HorizontalAlignment.CENTER);

    Font font = workbook.createFont();
    font.setColor(IndexedColors.WHITE.getIndex());
    style.setFont(font);
    
    return style;	
	
}

private static CellStyle getTitleStyle (Workbook workbook) {
	CellStyle style = workbook.createCellStyle();

    Font font = workbook.createFont();
    font.setColor(IndexedColors.BLACK.getIndex());
    font.setBold(true);
    short s = 14;
    font.setFontHeightInPoints(s);
    style.setFont(font);
    style.setAlignment(HorizontalAlignment.CENTER);

    
    return style;
}

private static CellStyle getColumnStyle (Workbook workbook) {
	
	 CellStyle style = workbook.createCellStyle();

	 style.setBorderBottom(BorderStyle.THIN);
	 style.setBottomBorderColor(IndexedColors.BLUE.getIndex());
	 style.setBorderLeft(BorderStyle.THIN);
	 style.setLeftBorderColor(IndexedColors.BLUE.getIndex());
	 style.setBorderRight(BorderStyle.THIN);
	 style.setRightBorderColor(IndexedColors.BLUE.getIndex());
	 style.setBorderTop(BorderStyle.THIN);
	 style.setTopBorderColor(IndexedColors.BLUE.getIndex());
	    style.setAlignment(HorizontalAlignment.CENTER);

 return style;
}
private static List<String> getList () {
	
	 List<String> r = new ArrayList<String>();
	 
	 r.add("ss");
	 r.add("sAs");
	 r.add("sRs");
	 r.add("sSs");
	 r.add("sPs");
	 r.add("sYs");
	 r.add("sTs");
	 r.add("ssG");
	 r.add("ssH");
	 r.add("ssJ");
	 r.add("ssK");
	 r.add("ssL");
	 r.add("ssM");
	 r.add("ss.");
	 
	
	return r;
}
private static void addHeaders(Sheet sheetResult,CellStyle headerStyle) {
    Row row = sheetResult.createRow(3);
    
    Cell cell = row.createCell(3);		        
    cell.setCellValue("Title Header");
    cell.setCellStyle(headerStyle);
    sheetResult.autoSizeColumn(3, true);

}
}

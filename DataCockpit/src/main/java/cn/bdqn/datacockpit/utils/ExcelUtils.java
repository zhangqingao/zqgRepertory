/**
 * Project Name:DataCockpit
 * File Name:ExcelAnalysis.java
 * Package Name:cn.bdqn.datacockpit.utils
 * Date:2017年8月27日下午2:06:15
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
*/

package cn.bdqn.datacockpit.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Description:	   <br/>
 * Date:     2017年8月27日 下午2:06:15 <br/>
 * @author   caoS
 * @version  
 * @see 	 
 */
public class ExcelUtils {
    
    
    /**
     * 对xls进行解析
     */
    public List<List<String>> readXls(String path) throws Exception{
        InputStream is=new FileInputStream(path);
        //HSSWorkbook表示整个excel文件的所有sheet
        HSSFWorkbook hssfWorkbook=new HSSFWorkbook(is);
        List<List<String>> result=new ArrayList<List<String>>();
        //处理当前页，循环每一行
        for(int numSheet=0;numSheet<hssfWorkbook.getNumberOfSheets();numSheet++){
            HSSFSheet hssfSheet=hssfWorkbook.getSheetAt(numSheet);
            if(hssfSheet==null){
                continue;
            }
            //处理当前页，循环每一行
            for(int rowNum=1;rowNum<=hssfSheet.getLastRowNum();rowNum++){
                HSSFRow hssfRow=hssfSheet.getRow(rowNum);
                int minColIx=hssfRow.getFirstCellNum();
                int maxColIx=hssfRow.getLastCellNum();
                List<String> rowList=new ArrayList<String>();
                //遍历该行，读取每一个元素
                for(int colIx=minColIx;colIx<maxColIx;colIx++){
                    HSSFCell cell=hssfRow.getCell(colIx);
                    if(cell==null){
                        continue;
                    }else{
                        //rowList.add(cell.toString());
                        rowList.add(cell.toString());
                    }
                }
                   result.add(rowList);
            }
        }
        return result;
        
    }
    
    
    /**
     * 对xlsx进行解析
     */
    public List<List<String>> readXlsx(String path) throws Exception{
        InputStream is=new FileInputStream(path);
        //HSSWorkbook表示整个excel文件的所有sheet
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook(is);
        List<List<String>> result=new ArrayList<List<String>>();
        //处理当前页，循环每一行
        for(int numSheet=0;numSheet<xssfWorkbook.getNumberOfSheets();numSheet++){
            XSSFSheet xssfSheet=xssfWorkbook.getSheetAt(numSheet);
            if(xssfSheet==null){
                continue;
            }
            //处理当前页，循环每一行
            for(int rowNum=1;rowNum<=xssfSheet.getLastRowNum();rowNum++){
                XSSFRow xssfRow=xssfSheet.getRow(rowNum);
                int minColIx=xssfRow.getFirstCellNum();
                int maxColIx=xssfRow.getLastCellNum();
                List<String> rowList=new ArrayList<String>();
                //遍历该行，读取每一个元素
                for(int colIx=minColIx;colIx<maxColIx;colIx++){
                    XSSFCell cell=xssfRow.getCell(colIx);
                    if(cell==null){
                        continue;
                    }else{
                        rowList.add(cell.toString());
                    }
                }
                result.add(rowList);
            }
        }
        return result;
        
    }
    //编写Excel
    public  void getHSSFWorkbook(String sheetName,String[] title,String [][] values, HSSFWorkbook wb){
        // 第一步，创建一个webbook，对应一个Excel文件  
       if(wb == null){
           wb = new HSSFWorkbook();
           
       }
       // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
       HSSFSheet sheet = wb.createSheet(sheetName);  
       // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
       HSSFRow row = sheet.createRow(0);  
       // 第四步，创建单元格，并设置值表头 设置表头居中  
       HSSFCellStyle style = wb.createCellStyle();  
       style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
       
       HSSFCell cell = null;  
       //创建标题
       for(int i=0;i<title.length;i++){
           cell = row.createCell(i);  
           cell.setCellValue(title[i]);  
           cell.setCellStyle(style);  
       }
       //创建内容
       for(int i=0;i<values.length;i++){
           row = sheet.createRow(i + 1); 
           for(int j=0;j<values[i].length;j++){
                row.createCell(j).setCellValue(values[i][j]);
           }
       }
       try {
    	   FileOutputStream out1 = new FileOutputStream("E://"+sheetName+".xls");
               wb.write(out1);
               out1.close();
          
       } catch (IOException e) {
           e.printStackTrace();
       }
//      return wb;
   }
    
 
}


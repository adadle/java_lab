package org.tony.file;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TonyLee on 2015/1/5.
 * By IDEA
 */
public class ReadExcel {


    public static void main(String[] args) {
        String path="E://test.xlsx";
        List<String []> list = readSheetContent(path,0);

        for (int i = 0; i < list.size(); i++) {
            String [] arr = list.get(i);
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]+"\t");
            }
            System.out.println();
        }

    }

    /**
     *
     * @param pathName
     * @param sheetNum
     * @return
     */
    public static List<String [] > readSheetContent(String pathName,int sheetNum){
        File file = new File(pathName);

        FileInputStream fis = null;
        Workbook book = null;
        if(file.exists() && file.getName().endsWith("xlsx")){//we don't want to support office 2003.
            try {
                fis = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                book = new XSSFWorkbook(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(book != null){
                Sheet sheet = book.getSheetAt(sheetNum);
                return getSheetData(sheet);
            }
        }
        return null;
    }

    /**
     *
     * @param sheet
     * @return
     */
    private static List<String []> getSheetData(Sheet sheet){
        if(sheet != null){
            List<String []> rowList = new ArrayList<String[]>();
//            System.out.println("===row num: "+sheet.getLastRowNum());
            NumberFormat format = NumberFormat.getInstance();
            format.setMaximumFractionDigits(2);
            format.setGroupingUsed(false);

            double allAcc=0,pcAcc=0,mobileAcc=0;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                String []  rowData = null;
                Row row = sheet.getRow(i);
                int cellNum = row.getLastCellNum();
                rowData = new String[cellNum+3]; // we add three col to accumulate the value.
                for (int j = 0; j < cellNum; j++) {
                    Cell cell = row.getCell(j);
                    String cellData = getCellData(cell);
                    if(j==2){// platform=all
                        //
                        allAcc += Double.valueOf(cellData);
                    }
                    if(j==3){// platform=pc
                        //
                        pcAcc += Double.valueOf(cellData);
                    }
                    if(j==4){// platform=mobile
                        //
                        mobileAcc += Double.valueOf(cellData);
                    }
                    rowData[j] = cellData;
                }
                rowData[5] = format.format(allAcc);
                rowData[6] = format.format(pcAcc);
                rowData[7] = format.format(mobileAcc);
                rowList.add(rowData);
            }
            return rowList;
        }
        return null;
    }

    /**
     *
     * @param cell
     * @return
     */
    private static String getCellData(Cell cell){
        if(cell != null){
//            System.out.println("---cell type: "+cell.getCellType());
            String cellData = "";
            switch(cell.getCellType()){
                case Cell.CELL_TYPE_NUMERIC:
                    if(DateUtil.isCellDateFormatted(cell)){
                        cellData = new SimpleDateFormat("yyyy-MM-dd").format(DateUtil.getJavaDate(cell.getNumericCellValue()));
                    }else{
                        BigDecimal num = new BigDecimal(cell.getNumericCellValue());
                        NumberFormat format = NumberFormat.getInstance();
                        format.setMaximumFractionDigits(2);
                        format.setGroupingUsed(false);
                        cellData = format.format(num);
                    }
                    break;
                case Cell.CELL_TYPE_STRING:
                    cellData = cell.getRichStringCellValue().toString();
                    break;
                default:
                    cellData = cell.getRichStringCellValue().toString();
            }
//            System.out.println("cell data:"+cellData);
            return cellData;
        }
        return null;
    }

}

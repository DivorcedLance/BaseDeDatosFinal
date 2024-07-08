package Utils;

import Modelo.DesignTable.Tabla;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Excel {

    public static String extension = ".xlsx";
    public static String basePath = "output/";

    public static HashMap<String, Object> sp1CellOptions = new HashMap<String, Object>() {{
        put("bold", true);
        put("fontColor", Colors.WHITE);
        put("fillForegroundColor", Colors.ROYAL_BLUE);
    }};

    public static HashMap<String, Object> sp2CellOptions = new HashMap<String, Object>() {{
        put("bold", true);
        put("fontColor", Colors.WHITE);
        put("fillForegroundColor", Colors.DARK_BLUE);
    }};

    public static HashMap<String, Object> normalCellOptions = new HashMap<String, Object>() {{
        put("wrapText", true);
    }};

    public static int defaultMargin = 512;

    public Workbook openWorkbook(String fileName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(basePath + fileName + extension);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        fileInputStream.close();
        return workbook;
    }

    public void saveWorkbook(Workbook workbook, String fileName) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(basePath + fileName + extension);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
    }

    public CellStyle createCustomStyle(Workbook workbook, HashMap<String, Object> options) {
        CellStyle customStyle = workbook.createCellStyle();
        Font customFont = workbook.createFont();

        if (options.containsKey("bold")) {
            customFont.setBold((Boolean) options.get("bold"));
        }
        if (options.containsKey("fontColor")) {
            customFont.setColor((Short) options.get("fontColor"));
        }
        if (options.containsKey("fontSize")) {
            customFont.setFontHeightInPoints((Short) options.get("fontSize"));
        }
        if (options.containsKey("fontName")) {
            customFont.setFontName((String) options.get("fontName"));
        }
        if (options.containsKey("fillForegroundColor")) {
            customStyle.setFillForegroundColor((Short) options.get("fillForegroundColor"));
            customStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        if (options.containsKey("wrapText")) {
            customStyle.setWrapText((Boolean) options.get("wrapText"));
        }
        customStyle.setFont(customFont);
        return customStyle;
    }

    public void writeHeaders(Sheet sheet, List<String> headers, CellStyle headerStyle) {
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers.get(i));
            cell.setCellStyle(headerStyle);
        }
    }

    private void setCellValue(Cell cell, Object value) {
        if (value instanceof Number) {
            cell.setCellValue(((Number) value).doubleValue());
        } else {
            cell.setCellValue(value.toString());
        }
    }

    public void writeRow(Sheet sheet, int rowNumber, List<Object> values, CellStyle dataStyle) {
        Row dataRow = sheet.createRow(rowNumber);
        for (int i = 0; i < values.size(); i++) {
            Cell cell = dataRow.createCell(i);
            setCellValue(cell, values.get(i));
            cell.setCellStyle(dataStyle);
        }
    }

    public void writeData(Sheet sheet, Tabla table, List<String> headers, CellStyle dataStyle) {
        for (int i = 0; i < table.getRowCount(); i++) {
            List<Object> values = new ArrayList<>();
            for (int j = 0; j < headers.size(); j++) {
                values.add(table.getValueAt(i, j));
            }
            writeRow(sheet, i + 1, values, dataStyle);
        }
    }

    public void writeData(Sheet sheet, Tabla table, List<String> headers, CellStyle dataStyle, List<Integer> specialRows, CellStyle specialStyle) {
        int rowCounter = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            List<Object> values = new ArrayList<>();
            for (int j = 0; j < headers.size(); j++) {
                values.add(table.getValueAt(i, j));
            }
            writeRow(sheet, rowCounter + 1, values, specialRows.contains(i + 1) ? specialStyle : dataStyle);
            rowCounter++;
        }
    }

    public void writeData(Sheet sheet, Tabla table, List<String> headers, CellStyle dataStyle, List<Integer> specialRows, CellStyle specialStyle, CellStyle lastRowStyle) {
        int rowCounter = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            List<Object> values = new ArrayList<>();
            for (int j = 0; j < headers.size(); j++) {
                values.add(table.getValueAt(i, j));
            }
            writeRow(sheet, rowCounter + 1, values, specialRows.contains(i + 1) ? specialStyle : dataStyle);
            rowCounter++;
        }
        Row lastRow = sheet.createRow(rowCounter + 1);
        for (int i = 0; i < headers.size(); i++) {
            Cell cell = lastRow.createCell(i);
            cell.setCellStyle(lastRowStyle);
        }
    }

    public void autoSizeColumns(Sheet sheet, List<String> headers, int margin) {
        for (int i = 0; i < headers.size(); i++) {
            sheet.autoSizeColumn(i);
            int currentWidth = sheet.getColumnWidth(i);
            sheet.setColumnWidth(i, currentWidth + margin);
        }
    }

    public void exportTableToExcel(Tabla table, List<String> headers, String fileName, List<Integer> specialRows, boolean specialLastRow) {
        Workbook workbook = null;

        try {
            workbook = new XSSFWorkbook();
            
            Sheet sheet = workbook.createSheet(fileName);

            CellStyle headerStyle = createCustomStyle(workbook, sp1CellOptions);
            CellStyle dataStyle = createCustomStyle(workbook, normalCellOptions);
            CellStyle specialStyle = createCustomStyle(workbook, sp1CellOptions);
            CellStyle lastRowStyle = createCustomStyle(workbook, sp2CellOptions);

            writeHeaders(sheet, headers, headerStyle);
            if (specialLastRow) {
                writeData(sheet, table, headers, dataStyle, specialRows, specialStyle, lastRowStyle);
            } else {
                writeData(sheet, table, headers, dataStyle, specialRows, specialStyle);
            }
            autoSizeColumns(sheet, headers, defaultMargin);

            saveWorkbook(workbook, fileName);
            System.out.println("Exportación de " + fileName + " a Excel completada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exportTableToExcel(Tabla table, List<String> headers, String fileName, List<Integer> specialRows) {
        exportTableToExcel(table, headers, fileName, specialRows, false);
    }

    public void exportTableToExcel(Tabla table, List<String> headers, String fileName) {
        exportTableToExcel(table, headers, fileName, new ArrayList<>(), false);
    }

    public void exportTablesToExcel(List<Tabla> tables, List<List<String>> headers, List<String> tableNames, String fileName) {
        Workbook workbook = null;

        try {
            workbook = new XSSFWorkbook();

            for (int i = 0; i < tables.size(); i++) {
                Sheet sheet = workbook.createSheet(tableNames.get(i));

                CellStyle headerStyle = createCustomStyle(workbook, sp1CellOptions);
                CellStyle dataStyle = createCustomStyle(workbook, normalCellOptions);
                CellStyle specialStyle = createCustomStyle(workbook, sp2CellOptions);
                CellStyle lastRowStyle = createCustomStyle(workbook, sp1CellOptions);

                writeHeaders(sheet, headers.get(i), headerStyle);
                writeData(sheet, tables.get(i), headers.get(i), dataStyle);
                autoSizeColumns(sheet, headers.get(i), defaultMargin);
            }

            saveWorkbook(workbook, fileName);
            System.out.println("Exportación de " + fileName + " a Excel completada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getSpecialRows(Tabla table, int col, String specialString) {
        
        List<Integer> specialRows = new ArrayList<>();

        for (int i = 0; i < table.getRowCount(); i++) {
            if (table.getValueAt(i, col).toString().equals(specialString)) {
                specialRows.add(i + 1);
            }
        }

        return specialRows;
    }
}

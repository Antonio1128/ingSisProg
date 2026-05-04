package Laborator8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import Laborator1.Student;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void readexcel(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.NUMERIC) {
                        System.out.print((int) cell.getNumericCellValue() + "\t");
                    } else if (cell.getCellType() == CellType.STRING) {
                        System.out.print(cell.getStringCellValue() + "\t");
                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeExcelmedie(String inputPath, String outputPath) {

        try (FileInputStream fis = new FileInputStream(inputPath);
             Workbook inputWorkbook = new XSSFWorkbook(fis)) {


            Workbook outputWorkbook = new XSSFWorkbook();
            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet("Sheet1");


            for (Row inputRow : inputSheet) {
                Row outputRow = outputSheet.createRow(inputRow.getRowNum());


                for (Cell inputCell : inputRow) {
                    Cell outputCell = outputRow.createCell(inputCell.getColumnIndex());

                    if (inputCell.getCellType() == CellType.NUMERIC) {
                        outputCell.setCellValue(inputCell.getNumericCellValue());
                    } else if (inputCell.getCellType() == CellType.STRING) {
                        outputCell.setCellValue(inputCell.getStringCellValue());
                    }
                }


                if (inputRow.getRowNum() > 0) {
                    double nota1 = inputRow.getCell(3).getNumericCellValue();
                    double nota2 = inputRow.getCell(4).getNumericCellValue();
                    double nota3 = inputRow.getCell(5).getNumericCellValue();

                    double medie = (nota1 + nota2 + nota3) / 3;

                    Cell medieCell = outputRow.createCell(6);
                    medieCell.setCellValue(medie);
                } else {
                    Cell medieCell = outputRow.createCell(6);
                    medieCell.setCellValue("medie");
                }
            }


            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                outputWorkbook.write(fos);
            }
            outputWorkbook.close();
            System.out.println("salvat: " + outputPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeExcelformula(String inputPath, String outputPath) {

        try (FileInputStream fis = new FileInputStream(inputPath);
             Workbook inputWorkbook = new XSSFWorkbook(fis)) {


            Workbook outputWorkbook = new XSSFWorkbook();
            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet("Sheet1");


            for (Row inputRow : inputSheet) {
                Row outputRow = outputSheet.createRow(inputRow.getRowNum());


                for (Cell inputCell : inputRow) {
                    Cell outputCell = outputRow.createCell(inputCell.getColumnIndex());

                    if (inputCell.getCellType() == CellType.NUMERIC) {
                        outputCell.setCellValue(inputCell.getNumericCellValue());
                    } else if (inputCell.getCellType() == CellType.STRING) {
                        outputCell.setCellValue(inputCell.getStringCellValue());
                    }
                }


                if (inputRow.getRowNum() > 0) {
                    double nota1 = inputRow.getCell(3).getNumericCellValue();
                    double nota2 = inputRow.getCell(4).getNumericCellValue();
                    double nota3 = inputRow.getCell(5).getNumericCellValue();

                    double medie = (nota1 + nota2 + nota3) / 3;

                    Cell medieCell = outputRow.createCell(6);
                    medieCell.setCellValue(medie);
                } else {
                    Cell medieCell = outputRow.createCell(6);
                    medieCell.setCellValue("Medie");
                }
            }


            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                outputWorkbook.write(fos);
            }
            outputWorkbook.close();
            System.out.println("salvat " + outputPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //readexcel("src/laborator8_input.xlsx");
       // writeExcelmedie("src/Laborator8_input.xlsx","src/Laborator8_output.xlsx");
        //writeExcelformula("src/Laborator8_input.xlsx","src/Laborator8_output2.xlsx");

        Set<Student> studenti = new LinkedHashSet<>();
        studenti.add(new Student(1, "Ion", "Popescu", "ISM"));

        studenti.add(new Student(2, "Maria", "Ionescu", "TI"));
        studenti.add(new Student(3, "Andrei", "Popa", "CALC"));
        studenti.add(new Student(4, "Elena", "Stan", "MEC"));

        String xlsFileName = "src/laborator8_students.xlsx";
      //  StudentExcel.writeToXls(studenti, xlsFileName);

        List<Student> studentsFromXls = StudentExcel.readFromXls(xlsFileName);
        System.out.println("\nstudenti xlsx:");
        for (Student st : studentsFromXls) {
            System.out.println(st);
        }
    }
}
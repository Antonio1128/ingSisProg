package Laborator8;

import Laborator1.Student;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentExcel {

    public static void writeToXls(Set<Student> studenti, String filePath) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Studenti");


        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Nr Matricol");
        header.createCell(1).setCellValue("Prenume");
        header.createCell(2).setCellValue("Nume");
        header.createCell(3).setCellValue("Formatie de Studiu");
        header.createCell(4).setCellValue("Nota");


        int rowNum = 1;
        for (Student st : studenti) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(st.getNrMatricol());
            row.createCell(1).setCellValue(st.getPrenume());
            row.createCell(2).setCellValue(st.getNume());
            row.createCell(3).setCellValue(st.getFormatiedeStudiu());
            row.createCell(4).setCellValue(st.getNota());
        }

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("studenti salvati in: " + filePath);
    }

    public static List<Student> readFromXls(String filePath) {
        List<Student> studenti = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                if (row.getRowNum() == 0) continue;

                int nrMatricol = (int) row.getCell(0).getNumericCellValue();
                String prenume = row.getCell(1).getStringCellValue();
                String nume = row.getCell(2).getStringCellValue();
                String formatie = row.getCell(3).getStringCellValue();
                float nota = (float) row.getCell(4).getNumericCellValue();

                Student st = new Student(nrMatricol, prenume, nume, formatie);
                st.setNota(nota);
                studenti.add(st);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return studenti;
    }
}
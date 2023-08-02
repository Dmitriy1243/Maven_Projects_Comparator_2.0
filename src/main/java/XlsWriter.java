import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {
    private XlsWriter() {
    }

    public static void writeXlsStatistics(List<Statistics> statisticsList,
                                          String filePath) throws IOException {

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet statisticsSheet = workbook.createSheet("Статистика");

    Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
    CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);

    int rowNumber = 0;
    Row headerRow = statisticsSheet.createRow(rowNumber++);
    Cell profileCellHeader = headerRow.createCell(0);
        profileCellHeader.setCellValue(" profile ");
        profileCellHeader.setCellStyle(headerStyle);
    Cell avgScoreCellHeader = headerRow.createCell(1);
        avgScoreCellHeader.setCellValue(" avgExamScore ");
        avgScoreCellHeader.setCellStyle(headerStyle);
    Cell KolStudentsProfCellHeader = headerRow.createCell(2);
        KolStudentsProfCellHeader.setCellValue(" KolStudentsProf ");
        KolStudentsProfCellHeader.setCellStyle(headerStyle);
    Cell KolUniversitiesProfCellHeader = headerRow.createCell(3);
        KolUniversitiesProfCellHeader.setCellValue(" KolUniversitiesProf ");
        KolUniversitiesProfCellHeader.setCellStyle(headerStyle);
    Cell universitiesCellHeader = headerRow.createCell(4);
        universitiesCellHeader.setCellValue(" universityNames ");
        universitiesCellHeader.setCellStyle(headerStyle);

        for (Statistics statistics : statisticsList) {
        Row dataRow = statisticsSheet.createRow(rowNumber++);
        Cell profileCell = dataRow.createCell(0);
            profileCell.setCellValue(statistics.getProfile().getProfileName());
        Cell avgScoreCell = dataRow.createCell(1);
            avgScoreCell.setCellValue(statistics.getAvgExamScore());
        Cell setKolStudentsProfCell = dataRow.createCell(2);
            setKolStudentsProfCell.setCellValue(statistics.getKolStudentsProf());
        Cell KolUniversitiesProfCell = dataRow.createCell(3);
            KolUniversitiesProfCell.setCellValue(statistics.getKolUniversitiesProf());
        Cell universitiesCell = dataRow.createCell(4);
            universitiesCell.setCellValue(statistics.getUniversityNames());
    }

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
        workbook.write(outputStream);
    }
}
}

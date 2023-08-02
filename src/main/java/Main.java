import comparator.StudentComparator;
import comparator.UniversityComparator;

import enums.StudentComparatorEnums;
import enums.StudyProfile;
import enums.UniversityComparatorEnums;

import uis.Student;
import uis.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {



        List<University> universities = readXlsUniversities("src/main/resources/University.xlsx");
        UniversityComparator universityComparator = ComparatorUS.getUniversityComparator(UniversityComparatorEnums.yearOfFoundation);
        universities.stream().sorted(universityComparator).forEach(System.out::println);

        List<Student> students = readXlsStudents("src/main/resources/University.xlsx");
        StudentComparator studentComparator = ComparatorUS.getStudentComparator(StudentComparatorEnums.avgExamScore);
        students.stream().sorted(studentComparator).forEach(System.out::println);

        List<Statistics> statisticsList = Statisticslist.createStatistics(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");
    }
    public static List<University> readXlsUniversities(String filePath) throws IOException {

        List<University> universities = new ArrayList<>();

        UniversityComparator universityComparator =  ComparatorUS.getUniversityComparator(UniversityComparatorEnums.yearOfFoundation);
        universities.stream() .sorted(universityComparator).forEach(System.out::println);

        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("University");


        Iterator<Row> rows = sheet.iterator();
        rows.next();

        while (rows.hasNext() == true) {
            Row currentRow = rows.next();
            University university = new University();
            universities.add(university);
            university.setId(currentRow.getCell(0).getStringCellValue());
            university.setFullName(currentRow.getCell(1).getStringCellValue());
            university.setShortName(currentRow.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int)currentRow.getCell(3).getNumericCellValue());
            university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, currentRow.getCell(4).getStringCellValue()));
        }

        return universities;
    }

    public static List<Student> readXlsStudents(String filePath) throws IOException {

        List<Student> students = new ArrayList<>();

        StudentComparator studentComparator = ComparatorUS.getStudentComparator(StudentComparatorEnums.avgExamScore);
        students.stream().sorted(studentComparator).forEach(System.out::println);

        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Student");


        Iterator<Row> rows = sheet.iterator();
        rows.next();

        while (rows.hasNext() == true) {
            Row currentRow = rows.next();
            Student student = new Student();
            students.add(student);

            student.setFullName(currentRow.getCell(0).getStringCellValue());
            student.setUniversityId(currentRow.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int)currentRow.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float)currentRow.getCell(3).getNumericCellValue());
        }

        return students;
    }
}

package org.example;

/*import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.String.join;

public class Main {
    public static ArrayList<String> status = new ArrayList<>();
    public static ArrayList<ArrayList<String>> finalOutput = new ArrayList<>();
    public static ArrayList<String> testDocHeader = new ArrayList<>();
    public static ArrayList<String> expectedOutputs = new ArrayList<>();
    public static ArrayList<String> actualOutputs = new ArrayList<>();

    public static ArrayList<ArrayList<String>> finalOutputList(ArrayList<String> expected, ArrayList<String> actual,
                                                        ArrayList<String> qaStatus){
        testDocHeader.add("Expected Result");
        testDocHeader.add("Actual Result");
        testDocHeader.add("QA status");
        finalOutput.add(testDocHeader);

        for(int i = 0; i <= expected.size() - 1; i++){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(expected.get(i));
            temp.add(actual.get(i));
            temp.add(qaStatus.get(i));

            finalOutput.add(temp);

        }
        return finalOutput;
    }

    public static void createTestDocument(ArrayList<ArrayList<String>> data) {
        BufferedWriter writer = null;
        try {
            FileWriter file = new FileWriter("Test Document.csv");
            writer = new BufferedWriter(file);
            System.out.println("Bf");
            for (ArrayList<String> row : data) {
                // Manually concatenate each row's elements with commas using StringBuilder
                StringBuilder rowString = new StringBuilder();
                System.out.println("sb");
                for (int i = 0; i < row.size(); i++) {
                    rowString.append(row.get(i));
                    System.out.println("ap" + row.get(i));
                    if (i < row.size() - 1) {
                        rowString.append(",");
                        System.out.println("in if");
                    }
                }
                // Write the row to the file
                writer.write(rowString.toString());
                // Add a new line after each row
                writer.newLine();
            }

        }catch (Exception e){
            System.err.println("Error appears when creating test document: " + e);
        } finally {
            try {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    public static void dataComparison(ArrayList<String> expArr, ArrayList<String> actArr){
        if(expArr.size() == actArr.size()){
            for(int i = 0; i <= expArr.size() - 1; i++){
                if(expArr.get(i).equalsIgnoreCase(actArr.get(i))){
                    System.out.println("Field Verification Completed!");
                    System.out.println("Expected Value: " + expArr.get(i));
                    System.out.println("Actual Value: " + actArr.get(i));
                    status.add("Pass");
                } else{
                    System.out.println("Field Verification Failed!");
                    System.out.println("Expected Value: " + expArr.get(i));
                    System.out.println("Actual Value: " + actArr.get(i));
                    status.add("Fail");
                }
                System.out.println("\n");
                System.out.println(status.get(i));
            }


        } else{
            System.out.println("Alert! Theres something wrong in Expected & Actual data list");
        }



    }

    /*public static String city(String[] cityCodes, String cityCode){
         String[] cityNames = {"Colombo", "Galle", "Kandy", "Trincomalee", "Jaffna"};


         for(int i = 0; i <= cityCodes.length - 1 ;i++){
             if(cityCodes[i].equalsIgnoreCase(cityCode)){
                 return cityNames[i];

             } else if(i == cityCodes.length -1){
                 return  "Please check whether given code is correct";
                 //System.out.println("PPP");
             }
         }
         return null;
    }*/

    public static void main(String[] args) throws IOException {

        //String[] fruits = {"apple", "orange", "papaya", "banana", "Yo Yo"};
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("papaya");
        fruits.add("banana");
        fruits.add("Yo Yo");

        //String[] favoriteFruits = {"apple", "Orange", "papaya", "watermelon", "Yo Yo"};
        ArrayList<String> favoriteFruits = new ArrayList<>();
        favoriteFruits.add("apple");
        favoriteFruits.add("Orange");
        favoriteFruits.add("papaya");
        favoriteFruits.add("watermelon");
        favoriteFruits.add("Yo Yo");


        System.out.println("Wanna check whether we have your favorite fruits");
        Main.dataComparison(fruits, favoriteFruits);
        System.out.println("Here We go!!!");


        Main.createTestDocument(finalOutputList(fruits, favoriteFruits, status));


        //String[] cityCodes = {"col", "gal", "kan", "tri", "jaf"};
        //System.out.println("The name of the \"jaf\" code is: " + city(cityCodes, "jaf"));
//        System.out.println("athal");

        //this line is to test git pull method

        /*//practicing exception handling and error handling
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a number: ");
            int userInput = scanner.nextInt();
            System.out.println("You entered : " + userInput);
        } catch(InputMismatchException e){
            System.err.println("Please input an integer");
        }*/

        //practicing file writing
        /*//file create class
        File newFile = new File("newExcelFile.xls");

        //file writer class
        FileWriter fw = new FileWriter(newFile);

        // print writer class
        PrintWriter pW = new PrintWriter(fw);

        pW.println("Hello ");
        pW.println("you");
        pW.println("idiot");
        pW.println("damn");
        pW.println("girl");

        pW.close();
        */

        /*//table creation in excel file
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        String[] header = { "Name", "Age", "City" };
        String[][] data = {
                { "John Doe", "30", "New York" },
                { "Jane Smith", "25", "Los Angeles" },
                { "Mike Johnson", "40", "Chicago" }
        };

        Row headerRow = sheet.createRow(0);
        *//*for (int i = 0; i < header.length; i++) {
            Cell cellvalue = headerRow.createCell(i);
            cellvalue.setCellValue(header[i]);
        }*//*

        for (int i = 0; i < data.length; i++) {
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < data[i].length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(data[i][j]);
            }
        }

        try (FileOutputStream fileOut = new FileOutputStream("table.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

/*
        String[][] data = {
                {"Name", "Age", "City"},
                {"John", "25", "New York"},
                {"Doe", "30", "Los Angeles"},
                {"Alice", "22", "Chicago"},
                {"Bob", "28", "San Francisco"}
        };

        // Define the file path for the CSV file
        String csvFile = "example.csv";

        // Write data to the CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            for (String[] row : data) {
                // Join each row's elements with commas and write to the file
                writer.write(join(",", row));
                // Add a new line after each row
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

*/

        /*ArrayList<ArrayList<String>> data = new ArrayList<>();

        // Adding headers
        ArrayList<String> header = new ArrayList<>();
        header.add("Name");
        header.add("Age");
        header.add("City");
        data.add(header);

        // Adding rows
        ArrayList<String> row1 = new ArrayList<>();
        row1.add("John");
        row1.add("25");
        row1.add("New York");
        data.add(row1);

        ArrayList<String> row2 = new ArrayList<>();
        row2.add("Doe");
        row2.add("30");
        row2.add("Los Angeles");
        data.add(row2);

        ArrayList<String> row3 = new ArrayList<>();
        row3.add("Alice");
        row3.add("22");
        row3.add("Chicago");
        data.add(row3);

        ArrayList<String> row4 = new ArrayList<>();
        row4.add("Bob");
        row4.add("28");
        row4.add("San Francisco");
        data.add(row4);*/

        //Main.createTestDocument(data);

        /*for(int i = 0; i <= fruits.length - 1; i++){
            System.out.println("\n");
            System.out.println(status.get(i));
        }*/


    }
}

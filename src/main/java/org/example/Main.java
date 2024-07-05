package org.example;

import java.util.ArrayList;

public class Main {


    public static void dataComparison(String[] expArr, String[] actArr){
        if(expArr.length == actArr.length){
            for(int i = 0; i <= expArr.length - 1; i++){
                if(expArr[i].equalsIgnoreCase(actArr[i])){
                    System.out.println("Field Verification Completed!");
                    System.out.println("Expected Value: " + expArr[i]);
                    System.out.println("Actual Value: " + actArr[i]);
                } else{
                    System.out.println("Field Verification Failed!");
                    System.out.println("Expected Value: " + expArr[i]);
                    System.out.println("Actual Value: " + actArr[i]);
                }
                System.out.println("\n");
            }


        } else{
            System.out.println("Alert! Theres something wrong in Expected & Actual data list");
        }


    }

    public static String city(String[] cityCodes, String cityCode){
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
    }

    public static void main(String[] args){

        /*String[] fruits = {"apple", "orange", "papaya", "banana"};
        String[] favoriteFruits = {"apple", "Orange", "papaya", "watermelon"};
        System.out.println("Wanna check whether we have your favorite fruits");
        Main.dataComparison(fruits, favoriteFruits);
        System.out.println("Here We go!!!");
        */

        String[] cityCodes = {"col", "gal", "kan", "tri", "jaf"};
        System.out.println("The name of the \"jaf\" code is: " + city(cityCodes, "jaf"));
//        System.out.println("athal");

        //this line is to test git pull method

    }
}

package com.example;

public class StringCalculator {


    int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        String delimiter = ",";
        String numsString = numbers;

        if (numbers.startsWith("//")){
            int delimiterIndex = numbers.indexOf("\n");
            if (delimiterIndex != -1){
                delimiter = numbers.substring(2,delimiterIndex);
                numsString = numbers.substring(delimiterIndex +1);
            }
        }



        String[] nums = numsString.split("[,\n"+delimiter+"/ ]");
        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }

}
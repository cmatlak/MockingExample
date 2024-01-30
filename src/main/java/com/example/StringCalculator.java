package com.example;

import java.util.ArrayList;
import java.util.List;

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

        List<Integer> negatives = new ArrayList<>();


        String[] nums = numsString.split("[,\n"+delimiter+"/ ]");
        int sum = 0;
        for (String num : nums) {
            if (!num.isEmpty()) {
                int neg = Integer.parseInt(num);
                if (neg < 0) {
                    negatives.add(neg);

                } else if (neg < 1000) {
                    sum += neg;

                }

            }
        }



            if (!negatives.isEmpty()){
                throw new IllegalArgumentException("Negatives not allowed " + negatives);
            }

        return sum;

    }

}
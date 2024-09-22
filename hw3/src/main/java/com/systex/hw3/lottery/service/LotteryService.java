package com.systex.hw3.lottery.service;

import java.util.ArrayList;

public class LotteryService {

    public String[] getNumbers(int groupCount, ArrayList<Integer> excludeNumber) {
    	String[] result = new String[groupCount];

        for (int i = 0; i < groupCount; i++) {

            ArrayList<Integer> lottery = new ArrayList<>();

            while (lottery.size() < 6) {

                int num = (int) (Math.random() * 49) + 1;

                if (!lottery.contains(num) && !excludeNumber.contains(num)) {
                    lottery.add(num);
                }

            }

            // sort lottery from small to large
            lottery.sort((a, b) -> a - b);

            // convert lottery to string
            StringBuilder sb = new StringBuilder();
            for (int num : lottery) {
                sb.append(num).append(", ");
            }
            
            // delete last comma
            result[i] = sb.substring(0, sb.length() - 2);
        }
        return result;
    }
    
}

package com.telusko.ProductSpring;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@Component
public class URLGenerate {
    private String chars = "absgdj";
    private HashMap<String, String> urlMap;
    private ArrayList<String> permutations;
    private Random random;

    public URLGenerate() {
        urlMap = new HashMap<>();
        permutations = generatePermutations(chars);
        random = new Random();
    }

    private ArrayList<String> generatePermutations(String chars) {
        ArrayList<String> result = new ArrayList<>();
        permute(chars.toCharArray(), 0, result);
        return result;
    }

    private void permute(char[] chars, int start, ArrayList<String> result) {
        if (start == chars.length - 1) {
            result.add(new String(chars));
        } else {
            for (int i = start; i < chars.length; i++) {
                swap(chars, start, i);
                permute(chars, start + 1, result);
                swap(chars, start, i);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public String generateURL(String oUrl) {
        if (urlMap.containsKey(oUrl)) {
            return urlMap.get(oUrl);
        } else {
            int index = random.nextInt(permutations.size());
            String sUrl = "telus.ko/" + permutations.get(index);
            urlMap.put(oUrl, sUrl);
            return sUrl;
        }
    }
}

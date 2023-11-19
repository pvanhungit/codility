package unit.codility;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        // Implement your solution here
        Map<Character,Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);

        int[] startMap = new int[S.length()];
        int[] endMap = new int[S.length()];
        int[] results = new int[P.length];

        for(int i =0 ; i < P.length; i ++) {
            int startPos = P[i];
            int endPos = Q[i];
            startMap[startPos] = i;
            endMap[endPos] = i;
            results[i] = 1;
        }

        for(int i=0; i < S.length(); i++) {
            char valueChar = S.charAt(i);
            int value = map.get(valueChar);

        }


        return results;
    }

    @Test
    void test(){


    }
}

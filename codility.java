//CreateLongestSpike

// you can also use imports, for example:
 import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        Arrays.sort(A);
        int len = A.length, cnt = 1, max = A[len - 1];
        int lastValue = A[0], currentCnt = 1;
        for(int i = 1 ; i < len; i++) {
            if(A[i] == max) {
                cnt++;
                break;
            }
            if(A[i] == A[i-1]) {
                if(currentCnt < 2) {
                    currentCnt++;
                    cnt++;
                }
            } else {
                lastValue = A[i];
                currentCnt = 1;
                cnt++;
            }

        }
        return cnt;
    }
}

//CommonLetter
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(String[] S) {
        // Implement your solution here
        for(int i = 0; i < S[0].length(); i++) {
            String strAtIdx = "";
            for(int k = 0; k < S.length; k++) {
                char currentChar = S[k].charAt(i);
                int index = strAtIdx.indexOf(currentChar);
                if( index >= 0) {
                    int[] results = new int[]{k, index, i};
                    return results;
                } else {
                    strAtIdx += currentChar;
                }
            }
        }
        return new int[]{};
    }
}

//LargestSquare
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int len = A.length,start = 0, min = 0;
        for(int i = 0 ; i < A.length; i++) {
            min = Math.min(i - start + 1, A[start]);
            if(i - start + 1 > min) {
                start++;
            }
        }
        return len - start;
    }
}

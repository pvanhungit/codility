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
        //return len - start;
     // return min;
    }
}

//TenBricks
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here

        int balance = 0, cnt = 0;
        for(int i = 0 ; i < A.length; i++) {
            balance += A[i] - 10;
            int steps = balance > 0 ? balance : -balance;
            cnt += steps;
        }

        return balance == 0 ? cnt : -1;
    }
}

//TournamentRounds
// you can also use imports, for example:
 import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] skills) {
        // Implement your solution here
        int len = skills.length;
        int[] results = new int[len];
        int[] currentIdxArr = new int[len];
        int[] nextIdxArr = new int[len];
        int rounds = len;
        for(int i = 0; i < len ; i++) {
            nextIdxArr[i] = i;
        }
        while(rounds > 1) {
            currentIdxArr = nextIdxArr;
            int cnt = 0;
            for(int i = 0 ; i < rounds; i+=2) {
                int idx1 = currentIdxArr[i];
                int idx2 = currentIdxArr[i + 1];

                results[idx1]++;
                results[idx2]++;

                int skill1 = skills[idx1];
                int skill2 = skills[idx2];

                if(skill1 > skill2) {
                    nextIdxArr[cnt++] = idx1;
                } else {
                    nextIdxArr[cnt++] = idx2;
                }
            }
            rounds = rounds/2;
        }

        return results;
    }
}


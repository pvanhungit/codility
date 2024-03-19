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

//XYSplit
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        // Implement your solution here
        int len = S.length();
        int cnt = 0,cntX = 0, cntY = 0;
        int[] xArr = new int[len];
        int[] yArr = new int[len];
        for(int i = 0; i < len ;i++) {
            char value = S.charAt(i);
            if(value == 'x') {
                ++cntX;
            }
            if(value == 'y') {
                ++cntY;
            }
            xArr[i] = cntX;
            yArr[i] = cntY;
            
        }
        


        for(int i = 1; i < len ;i++) {
            int cntX1 = xArr[i-1];
            int cntY1 = yArr[i-1];

            int cntX2 = cntX - cntX1;
            int cntY2 = cntY - cntY1;
    

            if(cntX1 == cntY1 || cntX2 == cntY2) {
                cnt++;
            }

        }
        return cnt;
    }
}

//FormatArray
// you can also use imports, for example:
// import java.util.*;

// you can write to stderr for debugging purposes, e.g.
// System.err.println("this is a debug message");

class Solution {
    public void solution(int[] A, int K) {
        // Implement your solution here
        int len = A.length, maxLen = 0;
        String[] numbersArr = new String[len];
        for(int i = 0 ;i < len ; i++) {
            String value = String.valueOf(A[i]);
            numbersArr[i] = value;
            maxLen = Math.max(value.length(), maxLen);
        }

        String lineNumbers = "", lineAboves = "", firstLines = "";
        for(int i = 0 ;i < len ; i++) {
            String number = numbersArr[i];
            int remainSpaces = maxLen - number.length();
            String printNumber = "|" + addChars(remainSpaces, ' ') + number;
            lineNumbers += printNumber;
            lineAboves += "+" + addChars(maxLen, '-');

            if(i + 1 <= K) {
                firstLines += "+" + addChars(maxLen, '-');
            }

            if( (i + 1 >= K && ( i + 1) % K == 0) || i == len - 1) {
                //print
                if(i + 1 <= K) {
                    firstLines += "+";
                    System.out.println(firstLines);
                }
                lineNumbers += "|";
                System.out.println(lineNumbers);

                lineAboves += "+";
                System.out.println(lineAboves);

                //reset
                lineNumbers = "";
                lineAboves = "";
            }
        }
    }

    static String addChars(int number, char character) {
        String rs = "";
        for(int i = 0 ; i < number ;i++) {
            rs += character;
        }
        return rs;
    }
}

package unit.codility;

//A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
//
//        S is empty;
//        S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
//        S has the form "VW" where V and W are properly nested strings.
//        For example, the string "{[()()]}" is properly nested but "([)()]" is not.
//
//        Write a function:
//
//class Solution { public int solution(String S); }
//
//that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
//
//        For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [0..200,000];
//        string S is made only of the following characters: '(', '{', '[', ']', '}' and/or ')'.

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;


public class Brackets {

    public int solution(String S) {
        // Implement your solution here

        if(S.isEmpty()) {
            return 1;
        }
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(index < S.length()) {
            char charIndex = S.charAt(index);
            char charInStack = !stack.isEmpty() ? stack.peek() : Character.MIN_VALUE;
            if(charIndex == '(' || charIndex == '[' || charIndex == '{') {
                stack.push(charIndex);
                if(stack.size() > 100000) {
                    return 0;
                }
            } else if ( (charInStack == '(' && charIndex == ')') ||
                    (charInStack == '[' && charIndex == ']') ||
                    (charInStack == '{' && charIndex == '}') )  {
                stack.pop();
            } else {
                return 0;
            }
            index++;
        }
        return stack.isEmpty() ? 1 : 0;
    }

    @Test
    void test(){

        String S  =  "{[()()]}";

        var result = solution(S);
        assertThat(result).isEqualTo(1);

    }

    @Test
    void test21(){

        String S  =  "[][][]{}{}()()()()";

        var result = solution(S);
        assertThat(result).isEqualTo(1);

    }

    @Test
    void test212(){

        String S  =  "[]{[][]}{}{}()[()()()]";

        var result = solution(S);
        assertThat(result).isEqualTo(1);

    }

    @Test
    void test21211(){

        String S  =  "[]{[][]}{}{}()[()()()]{";

        var result = solution(S);
        assertThat(result).isEqualTo(0);

    }

    @Test
    void test2(){

        String S  =  "([)()]";

        var result = solution(S);
        assertThat(result).isEqualTo(0);

    }


}

package unit.codility;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SmallestPostiveInterger {

    public int solution(int[] A) {
        // Implement your solution here
        int result = 1;
        boolean[] appearMap = new boolean[1000001 ];
        for(int i=0 ; i< A.length; i++) {
            int value = A[i];
            if(value > 0) {
                appearMap[value] = true;
            }
        }

        for(int i=1 ; i< appearMap.length; i++) {
            if(!appearMap[i]) {
                result = i;
                break;
            }
        }
        return result;
    }

    public int solution2(int[] A) {
        // Implement your solution here
        int result = 1;
        for(int i=0 ; i< A.length; i++) {
            int value = A[i];
            if(value > 0) {
               if(value == result) {
                   result += 1;
               } else if ( value < result) {
                   result = value;
               }
            }
        }
        return result;
    }

    @Test
    void test(){

        int[] A = new int[] {1,2};

        var result = solution(A);
        assertThat(result).isEqualTo(3);

    }

    @Test
    void test2(){

        int[] A = new int[] {-1, -2, -3};

        var result = solution(A);
        assertThat(result).isEqualTo(1);

    }

    @Test
    void test3(){

        int[] A = new int[] {1, 3, 6, 4, 1, 2};

        var result = solution(A);
        assertThat(result).isEqualTo(5);

    }

    @Test
    void test4(){

        int[] A = new int[] {1, 2, 3, 4};

        var result = solution(A);
        assertThat(result).isEqualTo(5);

    }

}

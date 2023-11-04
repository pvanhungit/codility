package unit.codility;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FrogRiverOne {

    public int solution(int X, int[] A) {
        // Implement your solution here
        int result = 0 ;

        boolean[] jumpMap = new boolean[X + 1];
        for(int i = 0 ; i < A.length; i++) {
            int position = A[i];
            if(!jumpMap[position]) {
                jumpMap[position] = true;
                result += 1;
                if (result == X) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Test
    void test(){

        int[] A = new int[] {1};
        int X = 1;

        var result = solution(X, A);
        assertThat(result).isEqualTo(0);

    }

    @Test
    void test1(){

        int[] A = new int[] {2,2,2,2,2,2};
        int X = 2;

        var result = solution(X, A);
        assertThat(result).isEqualTo(-1);

    }

    @Test
    void test3(){

        int[] A = new int[] {1, 3, 1, 4, 2, 3, 5, 4};
        int X = 5;

        var result = solution(X, A);
        assertThat(result).isEqualTo(6);

    }

    @Test
    void test4(){

        int[] A = new int[] {1, 5, 3, 1, 4, 2, 3, 5, 4};
        int X = 5;

        var result = solution(X, A);
        assertThat(result).isEqualTo(5);

    }
}

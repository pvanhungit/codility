package unit.codility;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Permutation {

    public int solution(int[] A) {
        // Implement your solution here
        int notPermutation = 0 ;
        int hasPermutation = 1 ;
        int count = 0;

        boolean[] checkExists = new boolean[A.length + 1];
        for(int i = 0 ; i < A.length; i++) {
            int value = A[i];
            if(value > A.length) {
                return notPermutation;
            }
            if(!checkExists[value]) {
                checkExists[value] = true;
                count += 1;
            } else {
                return notPermutation;
            }
        }

        return count == A.length ? hasPermutation : notPermutation;
    }

    @Test
    void test(){

        int[] A = new int[] {1,2};

        var result = solution(A);
        assertThat(result).isEqualTo(1);

    }

    @Test
    void test1(){

        int[] A = new int[] {1,2,3,4};

        var result = solution(A);
        assertThat(result).isEqualTo(1);

    }

    @Test
    void test3(){

        int[] A = new int[] {1,2,2};

        var result = solution(A);
        assertThat(result).isEqualTo(0);

    }

    @Test
    void test4(){

        int[] A = new int[] {1,2,4};

        var result = solution(A);
        assertThat(result).isEqualTo(0);

    }
}

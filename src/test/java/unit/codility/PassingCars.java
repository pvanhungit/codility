package unit.codility;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PassingCars {

    public int solution(int[] A) {
        // Implement your solution here
        int countZero = 0;
        int countPairs = 0;
        for(int i=0 ; i< A.length; i++) {
            int value = A[i];
            if (value == 1) {
                countPairs += countZero;
                if(countPairs > 1000000000) {//1 billion
                    return -1;
                }
            } else { //value = 0
                countZero++;
            }
        }

        return countPairs ;
    }

    @Test
    void test(){

        int[] A = new int[] {0 , 0, 0 , 1 , 1, 1};

        var result = solution(A);
        assertThat(result).isEqualTo(9);

    }

    @Test
    void test2(){

        int[] A = new int[] {0, 1, 0, 1, 1};

        var result = solution(A);
        assertThat(result).isEqualTo(5);

    }

    @Test
    void test3(){

        int[] A = new int[] {0, 1, 0, 1, 1};

        var result = solution(A);
        assertThat(result).isEqualTo(5);

    }


}

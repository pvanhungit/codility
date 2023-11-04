package unit.codility;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CoundDiv {

    public int solution(int A, int B, int K) {
        // Implement your solution here

        //restrict case K > B
//        if(K > B) {
//            return 0;
//        }

        int a = A/K;
        int b = B/K;
        int result =  b - a + (A%K == 0 ? 1 : 0);
        return result;
    }

    @Test
    void test() {
        int A = 6;
        int B = 8;
        int K = 2;
        int result = solution(A, B, K);
        assertThat(result).isEqualTo(2);

    }
    @Test
    void test2() {
        int A = 8;
        int B = 8;
        int K = 2;
        int result = solution(A, B, K);
        assertThat(result).isEqualTo(1);

    }
    @Test
    void test3() {
        int A = 6;
        int B = 11;
        int K = 2;
        int result = solution(A, B, K);
        assertThat(result).isEqualTo(3);

    }
    @Test
    void test4() {
        int A = 5;
        int B = 11;
        int K = 2;
        int result = solution(A, B, K);
        assertThat(result).isEqualTo(3);

    }

    @Test
    void test5() {
        int A = 6;
        int B = 8;
        int K = 7;
        int result = solution(A, B, K);
        assertThat(result).isEqualTo(1);

    }

    @Test
    void test6() {
        int A = 6;
        int B = 8;
        int K = 9;
        int result = solution(A, B, K);
        assertThat(result).isEqualTo(0);

    }

    @Test
    void test7() {
        int A = 6;
        int B = 8;
        int K = 8;
        int result = solution(A, B, K);
        assertThat(result).isEqualTo(1);

    }

    @Test
    void test8() {
        int A = 0;
        int B = 1;
        int K = 11;
        int result = solution(A, B, K);
        assertThat(result).isEqualTo(1);

    }



}

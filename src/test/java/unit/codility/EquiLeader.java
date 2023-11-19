package unit.codility;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EquiLeader {

    public int solution(int[] A) {
        // Implement your solution here
        int len = A.length, size = 0, candidate = -1;
        for(int i = 0; i < len; i++) {
            if(size == 0) {
                candidate = A[i];
                size = 1;
            } else {
                if(candidate != A[i]) {
                    size--;
                } else {
                    size++;
                }
            }
        }

        int totalcount = 0;
        for(int i = 0; i < len; i++) {
            if(candidate == A[i]) {
                totalcount++;
            }
        }

        if(totalcount <= len/2) {
            return 0;
        }

        System.out.println("totalcount:" + totalcount);



        int count = 0;
        int occurs = 0;
        for(int i = 0; i < len; i++) {
            if(candidate == A[i]) {
                count++;
            }
            System.out.println("------------");
            System.out.println("i:" + i);
            System.out.println("count:" + count);
            if(count > (i + 1)/2 &&  (totalcount - count) > (len - 1 - i)/2 ) {

                occurs++;
            }
        }
        return occurs;
    }

    @Test
    void test1() {
        var arr = new int[]{1, 1, 1, 1, 3, 3, 3, 1, 1, 1, 1};
        var result = solution(arr);
        assertThat(result).isEqualTo(10);

    }



}

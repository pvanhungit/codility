package unit.codility;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ArrayLeader {

    public int leader(int[] arr) {
        int len = arr.length, size = 0, candicate = -1;
        for(int i = 0; i < len; i++) {
            int currentValue = arr[i];
            if(size == 0) {
                candicate = arr[i];
                size++;
            } else {
                if(candicate != currentValue) {
                    size--;
                } else {
                    size++;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < len; i++) {
            if(arr[i] == candicate) {
                count++;
            }
        }

        if(count > len/2) {
            return candicate;
        }
        return -1;
    }

    @Test
    void test1() {
        var arr = new int[]{1,2,1,2,1,2,1,1,1,1,1};
        var result = leader(arr);
        assertThat(result).isEqualTo(1);

    }

    @Test
    void test2() {
        var arr = new int[]{1,5,4,7,3,3,3,4,6,3,3,3,3,3,3,3};
        var result = leader(arr);
        assertThat(result).isEqualTo(3);

    }

}

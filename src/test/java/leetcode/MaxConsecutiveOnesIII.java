package leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.*;
public class MaxConsecutiveOnesIII {

    public int longestOne(int[] nums, int k) {
        int start = 0, len = nums.length, count = 0;

        for(int i = 0;i < len; i++) {
            int value = nums[i];
            if(value == 0){
                count++;
            }

            if(count > k) {
                if(nums[start] == 0) {
                    count--;
                }
                start++;
            }
        }

        return len - start;
    }

    @Test
    void test1() {
        var arrays = new int[]{1,1,1,1,1,0,0,0,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 0, 0 ,0 ,0 ,0, 0, 0, 0,0,1};
        var k = 3;
        var result = longestOne(arrays, k);
        assertThat(result).isEqualTo(8);
    }

    @Test
    void test12() {
        var arrays = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        var k = 2;
        var result = longestOne(arrays, k);
        assertThat(result).isEqualTo(6);


        Stack<Integer> stack = new Stack();
    }
}

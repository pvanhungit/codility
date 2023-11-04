package unit.codility;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;


public class MaxCounters {

    public int[] solution(int N, int[] A) {
        // Implement your solution here
        int[] counters = new int[N];

        int maxCounter = 0;
        int maxCurrentValue = 0;
        for (int i = 0; i < A.length; i++) {
            int value = A[i];


            //update max counter value
            if (value == N + 1) {
                maxCounter = maxCurrentValue;
                continue;
            }

            int index = value -1;
            int currentValue = counters[index];

            //update counter to max counter
            if (currentValue < maxCounter) {
                counters[index] = maxCounter;
            }

            counters[index] += 1;

            //update max current value
            currentValue = counters[index];
            if (currentValue > maxCurrentValue) {
                maxCurrentValue = currentValue;
            }
        }

        for (int i = 0; i < N; i++) {
            if (counters[i] < maxCounter) {
                counters[i] = maxCounter;
            }
        }

        return counters;
    }

    @Test
    void test(){

        int[] A = new int[] {3, 4, 4, 6 ,1 ,4, 4};

        var result = solution(5, A);
        System.out.println(Arrays.toString(result));

    }
}

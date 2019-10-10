
import java.util.Queue;

/**
 * Write your solution to this assignment in this class
 */
public class Algorithms {

    /**
     * Write your implementation of the sortQueue algorithm here
     *
     * @param queue the queue to sort
     */
    public static <T extends Comparable<T>> void sortQueue(Queue<T> queue) {
        int size = queue.size(); // achieve the size of queue.
        int counter = 0;        // define a counter
        for (int k = 1; k < size; k++) {
            T max = queue.poll();   // assuming the first out element is the max value.

            for (int i = 0; i < size - k; i++) {
                if (max.compareTo(queue.peek()) >= 0) {   // compare the max value and the next out element,
                    queue.offer(queue.poll());             // and let the smaller one go back to the queue, the larger one become the max.
                }else {
                    T temp = max;
                    max = queue.poll();
                    queue.offer(temp);
                }
            }
            counter++;
            queue.offer(max);
            for (int j = counter; j >= 2; j--) { // let the largest element always in the end of queue.
                queue.offer(queue.poll());
            }
        }
    }

    /**
     * Write your implementation of the findMissingNumber algorithm here
     *
     * @param numbers the arithmetic sequence
     * @return the missing number in the sequence
     */
    public static int findMissingNumber(int[] numbers) {
        int commonDifference = (numbers[numbers.length - 1] - numbers[0]) / numbers.length; // Get the common difference of arithmetic sequence
        return helpFindMissingNumber(numbers, 0, numbers.length - 1, commonDifference);
    }

    private static int helpFindMissingNumber(int[] numbers, int start, int end, int commonDifference) {
        if (end - start + 1 == 2) {                         // if the length of array is 2, return the result immediately
            return numbers[start] + commonDifference;
        }

        int middle = (start + end) / 2;     // get the miidle index
        if ((numbers[middle] - numbers[start]) / (middle - start) != commonDifference) { // compute and compare the common difference
            return helpFindMissingNumber(numbers, start, middle, commonDifference);
        }else {
            return helpFindMissingNumber(numbers, middle, end, commonDifference);
        }
    }
}

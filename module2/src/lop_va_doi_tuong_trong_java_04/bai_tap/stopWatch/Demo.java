package lop_va_doi_tuong_trong_java_04.bai_tap.stopWatch;

public class Demo {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        long[] array = new long[(int) (Math.random() * (100000))];
        sort(array);
        stopWatch.stop();

        System.out.println(stopWatch.getElapsedTime());
    }
    public static void sort(long arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            long temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}

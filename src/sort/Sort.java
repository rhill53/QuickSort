package sort;

public class Sort
{
    /* The code below is contributed by Rajat Mishra */
    /*https://www.geeksforgeeks.org/java-program-for-quicksort/*/
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void sort(int arr[], int partStart, int partEnd, String partition, String pivotType, int minPartSize) {
        if ((partStart < partEnd) && ((partEnd - partStart) > minPartSize)) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = Partition.partitionHandler(arr, partStart, partEnd, partition, pivotType);

            // Recursively sort elements before
            // partition and after partition
            if (partition == "LOMUTO") {
                sort(arr, partStart, pi - 1, partition, pivotType, minPartSize);
                sort(arr, pi + 1, partEnd, partition, pivotType, minPartSize);
            }
            if (partition == "HOARE") {
                sort(arr, partStart, pi, partition, pivotType, minPartSize);
                sort(arr, pi +1, partEnd, partition, pivotType, minPartSize);
            }
        }
        insertionSort(arr);
    }
    /* The code above is contributed by Rajat Mishra */
    /*https://www.geeksforgeeks.org/java-program-for-quicksort/*/

    static void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

}


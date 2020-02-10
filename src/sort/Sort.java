package sort;

public class Sort
{
    /* The code below is contributed by Rajat Mishra */
    /*https://www.geeksforgeeks.org/java-program-for-quicksort/*/
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void sort(int arr[], int partStart, int partEnd, String partition, String pivot, int minPartSize) {
        if ((partStart < partEnd) && ((partEnd - partStart) > minPartSize)) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = Partition.partitionHandler(arr, partStart, partEnd, partition, pivot);

            // Recursively sort elements before
            // partition and after partition
            if (partition == "Lomuto") {
                sort(arr, partStart, pi - 1, partition, pivot, minPartSize);
                sort(arr, pi + 1, partEnd, partition, pivot, minPartSize);
            }
            if (partition == "Hoare") {
                sort(arr, partStart, pi, partition, pivot, minPartSize);
                sort(arr, pi +1, partEnd, partition, pivot, minPartSize);
            }
        }
        insertionSort(arr);
    }
    /* The code above is contributed by Rajat Mishra */
    /*https://www.geeksforgeeks.org/java-program-for-quicksort/*/

    static void insertionSort(int arr[])
    {
        int i = 1;
        while (i < arr.length) {
            int x = arr[i];
            int j = i - 1;
            while ((j >= 0) && (arr[j] > x) && (j < arr.length - 1)) {
                arr[j + 1] = arr[j];
                j++;
            }
            if (j + 1 < arr.length)
                arr[j + 1] = x;
            if (i + 1 <= arr.length)
                i++;
        }
    }

}


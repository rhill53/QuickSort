package sort;

public class Partition {
    static int partitionHandler(int arr[], int partStart, int partEnd, String partition, String pivot){
        switch (partition){
            case "Hoare":
                return hoarePartition(arr, partStart, partEnd, pivot);
            case "Lomuto":
                return lomutoPartition(arr, partStart, partEnd, pivot);
        }
        return 0;
    }

    static int hoarePartition(int arr[], int partStart, int partEnd, String pivot){
        int piv = pivot(arr, partStart, partEnd, pivot);
        int i = partStart - 1;
        int j = partEnd + 1;
        while (true)
        {
            do{
                i++;
            }
            while (arr[i] < piv);
            do{
                j--;
            } while (arr[j] > piv);
            if (i >= j){
                return j;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    static int lomutoPartition(int arr[], int partStart, int partEnd, String pivot){
        int piv = pivot(arr, partStart, partEnd, pivot);
        int i = (partStart - 1);
        for (int j = partStart; j <= partEnd- 1; j++) {
            if (arr[j] <= piv){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[partEnd];
        arr[partEnd] = temp;
        return (i + 1);
    }

    static int pivot(int arr[], int start, int end, String type){
        switch (type){
            case "median":
                return ((start + end) / 2);
            case "left":
                return (start);
            case "right":
                return (end);
        }
        return 0;
    }

}
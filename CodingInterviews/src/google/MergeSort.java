package google;

public class MergeSort{

    public static void mergesort(int[] array){
        int[] aux = new int[array.length];
        mergesort(array, aux, 0, array.length - 1);

    }

    private static void mergesort(int[] array,int[] aux, int l, int r){
        if(l < r){
            int mid = l + ((r-l)/2);
            mergesort(array, aux, l, mid);
            mergesort(array, aux, mid+1, r);
            merge(array, aux, l, mid, r);
        }

    }

    private static void merge(int[] array, int[] aux, int l, int m, int r){
        for(int i = l; i <= r; i++){
            aux[i] = array[i];
        }

        int i = l;
        int j = m + 1;
        int k = l;
        while(i <= m && j <= r){
            if(aux[i] <= aux[j]){
                array[k] = aux[i];
                i++;
            }
            else{
                array[k] = aux[j];
                j++;
            }
            k++;
        }
        while(i <= m){
            array[k] = aux[i];
            i++;
            k++;
        }
    }

}

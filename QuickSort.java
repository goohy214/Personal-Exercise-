public class QuickSort {
    public static void main(String[] args) {
        int[] inputs = new int[]{2,3,4,1,8,7,5};
        quickSort(inputs);
    }

    private static void swapReference(int[] a, int idx1, int idx2) {
        int tmp = a[idx2];
        a[idx2] = a[idx1];
        a[idx1] = tmp;
    }

    private static int median3(int[] inputs, int left, int right) {
        int center = (left + right) / 2;
        if(inputs[center] < inputs[left])
            swapReference(inputs, left, center);
        if(inputs[right] < inputs[center])
            swapReference(inputs, center, right);
        if(inputs[right] < inputs[left])
            swapReference(inputs, left, right);
        
        swapReference(inputs, center, right-1);
        return inputs[right-1];
    }

    public static void quickSort(int[] inputs) {
        quickSort(inputs, 0, inputs.length-1);
        for(int v:inputs)
            System.out.print(v);
    }

    public static void quickSort(int[] inputs, int left, int right) {
        if(left < right){
            int pivot = median3(inputs, left, right);

            int i = left, j = right-1;
            for(;;){
                while(inputs[++i] < pivot){}
                while(inputs[--j] > pivot){}
                if(i<j) swapReference(inputs, i, j);
                else break;
            }

            swapReference(inputs, i, right-1);

            quickSort(inputs, left, i-1);
            quickSort(inputs, i+1, right);
            }        
    }
}

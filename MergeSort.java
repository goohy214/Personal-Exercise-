public class MergeSort {
    public static void main(String[] args) {
        int[] inputs = new int[]{2,3,4,1,8,7,5};
        mergeSort(inputs);
    }

    public static void mergeSort(int[] inputs) {
        int[] tmpArray = new int[inputs.length];
        mergeSort(inputs, tmpArray, 0, inputs.length-1);
        for(int v: tmpArray)
            System.out.print(v);
    }

    public static void mergeSort(int[] inputs, int[] tmpArray, int left, int right) {
        if(left < right) {
            int center = (left + right) / 2;
            mergeSort(inputs, tmpArray, left, center);
            mergeSort(inputs, tmpArray, center+1, right);
            merge(inputs, tmpArray, left, center+1, right);
        }
    }

    public static void merge(int[] inputs, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while(leftPos <= leftEnd && rightPos <= rightEnd) {
            if(inputs[leftPos] <= inputs[rightPos])
                tmpArray[tmpPos++] = inputs[leftPos++];
            else
                tmpArray[tmpPos++] = inputs[rightPos++];
        }

        while(leftPos <= leftEnd)
            tmpArray[tmpPos++] = inputs[leftPos++];

        while(rightPos <= rightEnd)
            tmpArray[tmpPos++] = inputs[rightPos++];

        for(int i = 0; i < numElements; i++, rightEnd--)
            inputs[rightEnd] = tmpArray[rightEnd];
    }
}

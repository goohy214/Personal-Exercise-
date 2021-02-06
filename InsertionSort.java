public class InsertionSort {
    public static void main(String[] args) {
        int[] inputs = new int[]{2,3,4,1,8,7,5};
        int[] outputs = insertionSort(inputs);
        for(int v: outputs) {
            System.out.print(v);
        }
    }

    public static int[] insertionSort(int[] inputs) {
        for (int idx = 0; idx < inputs.length; idx ++) {
            int currentValue = inputs[idx];
            int position = idx;

            while (position > 0 && inputs[position-1] > currentValue) {
                inputs[position] = inputs[position-1];
                position -= 1;
            }

            inputs[position] = currentValue;
        }

        return inputs;
    }
}

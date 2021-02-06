public class SelectionSort {
    public static void main(String[] args) {
        int[] inputs = new int[]{2,3,4,1,8,7,5};
        int[] outputs = selectionSort(inputs);
        for(int v: outputs) {
            System.out.print(v);
        }
    }

    public static int[] selectionSort(int[] inputs) {
        for (int fillslot = inputs.length-1; fillslot >= 0; fillslot--) {
            int positionOfMax = 0;
            for (int i = 0; i <= fillslot; i++) {
                if (inputs[i] > inputs[positionOfMax]) {
                    positionOfMax = i;
                }
            }
            int tmp = inputs[fillslot];
            inputs[fillslot] = inputs[positionOfMax];
            inputs[positionOfMax] = tmp;
        }
        return inputs;
    }
}

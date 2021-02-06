public class ShellSort {
    public static void main(String[] args) {
        int[] inputs = new int[]{2,3,4,1,8,7,5};
        int[] outputs = shellSort(inputs);
        for(int v: outputs) {
            System.out.print(v);
        }
    }

    public static int[] shellSort(int[] inputs) {
        for (int gap = inputs.length / 2 ; gap > 0; gap /= 2) {
            for (int i = gap; i < inputs.length; i++) {
                int tmp = inputs[i];
                int j = i;
                while( j >= gap && inputs[j-gap] > tmp) {
                    inputs[j] = inputs[j-gap];
                    j -= gap;
                }
                inputs[j] = tmp;
            }
        }
        return inputs;
        // int n = inputs.length;

        // for (int gap = n / 2; gap > 0; gap /= 2) {
        //     for (int i = gap; i < n; i++) {
        //         int key = inputs[i];
        //         int j = i;
        //         while (j >= gap && inputs[j - gap] > key) {
        //             inputs[j] = inputs[j - gap];
        //             j -= gap;
        //         }
        //         inputs[j] = key;
        //     }
        // }
        // return inputs;
    }
}

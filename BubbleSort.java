public class BubbleSort {
    public static void main(String[] args) {
        int[] inputs = new int[]{2,3,4,1,8,7,5};
        int[] outputs = shortBubbleSort(inputs);
        for(int v: outputs) {
            System.out.print(v);
        }
    }

    public static int[] bubbleSort(int[] inputs) {
        for(int l = inputs.length-1; l >= 0; l--) {
            for(int i = 0; i < l; i++) {
                if(inputs[i] > inputs[i+1]) {
                    int tmp = inputs[i+1];
                    inputs[i+1] = inputs[i];
                    inputs[i] = tmp;
                }
            }
        }
        return inputs;
    }

    public static int[] shortBubbleSort(int[] inputs) {
        boolean exchanges = true;
        int passnum = inputs.length-1;

        while (exchanges && passnum > 0) {
            exchanges = false;
            for(int i = 0; i < passnum; i++){
                if(inputs[i] > inputs[i+1]) {
                    exchanges = true;
                    int tmp = inputs[i+1];
                    inputs[i+1] = inputs[i];
                    inputs[i] = tmp;
                }
            }
            passnum --;
        }
        return inputs;
    }
}

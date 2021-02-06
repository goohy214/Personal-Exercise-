import java.util.ArrayList;
import java.util.List;

public class Exe31 {
    public static void main(String[] args){
        long startTime = System.nanoTime();
        List<Integer> L = new ArrayList<>();
        List<Integer> P = new ArrayList<>();
        printLots(L, P);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }

    public static void printLots(List<Integer> L, List<Integer> P){
        for(int idx: P){
            System.out.println(L.get(idx));
        }     
    }
}

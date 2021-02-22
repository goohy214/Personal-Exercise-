import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

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
        Iterator<Integer> iterL = L.iterator();
        Iterator<Integer> iterP = P.iterator();

        int itemL = 0, itemP = 0, start  = 0;

        while(iterL.hasNext() && iterP.hasNext()){
            itemP = iterP.next();

            while(start < itemP && iterL.hasNext()){
                start ++;
                itemL = iterL.next();
            }

            System.out.println(itemL);
        }

    }
}

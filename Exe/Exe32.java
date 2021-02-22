
public class Exe32 {
    public static void main(String[] args){

    }

    public class SingleLinkedNode{
        public int val;
        public SingleLinkedNode next;

        public void SingleLinkedNode(int value){
            val = value;
        }
    }

    public class DoubleLinkedNode{
        public int val;
        public DoubleLinkedNode prev, next;

        public void DoubleLinkedNode(int value){
            val = value;
        }
    }

    public static void swapWithNext(SingleLinkedNode beforep){
        SingleLinkedNode p, afterp;

        p = beforep.next;
        afterp = p.next;

        p.next = afterp.next;
        beforep.next = afterp;
        afterp.next = p;
    } 

    public static void swapWithNext(DoubleLinkedNode beforep){
        DoubleLinkedNode p, afterp;

        
    }
}

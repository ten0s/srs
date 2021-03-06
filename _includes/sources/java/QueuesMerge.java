import java.util.*;

public class QueuesMerge<Item extends Comparable<Item>> {
    private Queue<Item> out;

    public QueuesMerge(Queue<Item>[] in) {
        //+BEGIN_SOLUTION
        int n = in.length;
        IndexMinPQ<Item> pq = new IndexMinPQ<>(n);
        for (int i = 0; i < n; i++) {
            if (!in[i].isEmpty()) {
                pq.add(i, in[i].remove());
            }
        }

        out = new LinkedList<>();
        while (!pq.isEmpty()) {
            out.add(pq.peekKey());
            int i = pq.remove();
            if (!in[i].isEmpty()) {
                pq.add(i, in[i].remove());
            }
        }
        //+END_SOLUTION
    }

    public Queue<Item> merged() {
        return out;
    }

    public int size() {
        return out.size();
    }

    //+BEGIN_FOLD Tests {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Throwable {
        Queue<Integer>[] queues = (Queue<Integer>[]) new Queue[] {
            new LinkedList<Integer>(Arrays.asList(new Integer[] {1,2,3,6,7,9,9,26})),
            new LinkedList<Integer>(Arrays.asList(new Integer[] {2,4,8,16,17,17})),
            new LinkedList<Integer>(Arrays.asList(new Integer[] {1,2,5,6,10,14})),
            new LinkedList<Integer>()
        };
        QueuesMerge<Integer> m = new QueuesMerge<>(queues);
        Integer[] exp = new Integer[] {1,1,2,2,2,3,4,5,6,6,7,8,9,9,10,14,16,17,17,26};
        Integer[] act = m.merged().toArray(new Integer[m.size()]);
        Assert.assertArrayEquals(exp, act);
        System.out.println("OK");
    }
    //+END_FOLD }
}

// Refs
/*+BEGIN_FOLD
class IndexMinPQ<Key extends Comparable<Key>> {
    public IndexMinPQ();
    public void add(int i, Key v);
    public int remove();
    public Key peekKey();
    public int size();
    public boolean isEmpty();
}
+END_FOLD*/

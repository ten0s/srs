import java.util.*;

public class EdgeWeightedDAGLPs2 {
    //+BEGIN_SOLUTION
    private EdgeWeightedDAGSPs sp;
    //+END_SOLUTION

    public EdgeWeightedDAGLPs2(EdgeWeightedDigraph G, int s) {
        //+BEGIN_SOLUTION
        sp = new EdgeWeightedDAGSPs(negate(G), s);
        //+END_SOLUTION
    }

    //+BEGIN_SOLUTION
    private EdgeWeightedDigraph negate(EdgeWeightedDigraph G) {
        EdgeWeightedDigraph N = new EdgeWeightedDigraph(G.V());
        for (DirectedEdge e : G.edges()) {
            N.addEdge(negate(e));
        }
        return N;
    }

    private DirectedEdge negate(DirectedEdge e) {
        return new DirectedEdge(e.from(), e.to(), -1.0 * e.weight());
    }
    //+END_SOLUTION

    public double distTo(int v) {
        //+BEGIN_SOLUTION
        return -1.0 * sp.distTo(v);
        //+END_SOLUTION
    }

    public boolean hasPathTo(int v) {
        //+BEGIN_SOLUTION
        return sp.hasPathTo(v);
        //+END_SOLUTION
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        //+BEGIN_SOLUTION
        Iterable<DirectedEdge> path = sp.pathTo(v);
        if (path == null) return null;
        Iterator<DirectedEdge> it = path.iterator();
        return new Iterable<DirectedEdge>() {
            public Iterator<DirectedEdge> iterator() {
                return new Iterator<DirectedEdge>() {
                    public boolean hasNext() {
                        return it.hasNext();
                    }
                    public DirectedEdge next() {
                        return negate(it.next());
                    }
                    public void remove() {
                        it.remove();
                    }
                };
            }
        };
        //+END_SOLUTION
    }

    //+BEGIN_FOLD Tests {
    public static void main(String[] args) throws Throwable {
        // data/tinyEWDAG.txt
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(8);
        G.addEdge(new DirectedEdge(5, 4, 0.35));
        G.addEdge(new DirectedEdge(4, 7, 0.37));
        G.addEdge(new DirectedEdge(5, 7, 0.28));
        G.addEdge(new DirectedEdge(5, 1, 0.32));
        G.addEdge(new DirectedEdge(4, 0, 0.38));
        G.addEdge(new DirectedEdge(0, 2, 0.26));
        G.addEdge(new DirectedEdge(3, 7, 0.39));
        G.addEdge(new DirectedEdge(1, 3, 0.29));
        G.addEdge(new DirectedEdge(7, 2, 0.34));
        G.addEdge(new DirectedEdge(6, 2, 0.40));
        G.addEdge(new DirectedEdge(3, 6, 0.52));
        G.addEdge(new DirectedEdge(6, 0, 0.58));
        G.addEdge(new DirectedEdge(6, 4, 0.93));
        //System.out.println(G);
        //System.out.println(G.toDot());

        EdgeWeightedDAGLPs2 lp0 = new EdgeWeightedDAGLPs2(G, 0);
        Assert.assertTrue(lp0.hasPathTo(0));
        Assert.assertEquals(0.0, lp0.distTo(0), 10e-4);
        Assert.assertEquals("", GraphUtil.directedWeightedPathToString(lp0.pathTo(0)));

        Assert.assertFalse(lp0.hasPathTo(5));
        Assert.assertEquals(Double.NEGATIVE_INFINITY, lp0.distTo(5));
        Assert.assertNull(lp0.pathTo(5));

        EdgeWeightedDAGLPs2 lp5 = new EdgeWeightedDAGLPs2(G, 5);
        Assert.assertTrue(lp5.hasPathTo(0));
        Assert.assertEquals(2.44, lp5.distTo(0));
        Assert.assertEquals("5->1->3->6->4->0", GraphUtil.directedWeightedPathToString(lp5.pathTo(0)));

        Assert.assertTrue(lp5.hasPathTo(6));
        Assert.assertEquals(1.13, lp5.distTo(6));
        Assert.assertEquals("5->1->3->6", GraphUtil.directedWeightedPathToString(lp5.pathTo(6)));

        G.addEdge(new DirectedEdge(2, 5, 0.0));
        try {
            new EdgeWeightedDAGLPs2(G, 0);
            Assert.assertTrue("No check if the graph is a DAG", false);
        } catch (IllegalArgumentException e) {}

        System.out.println("OK");
    }
    //+END_FOLD }
}

// Refs
/*+BEGIN_FOLD
public class EdgeWeightedDigraph {
    public EdgeWeightedDigraph(int V);
    public int V();
    public int E();
    public void addEdge(DirectedEdge e);
    public Iterable<DirectedEdge> adj(int v)
    public Iterable<DirectedEdge> edges();
}

public class DirectedEdge implements Comparable<DirectedEdge> {
    public DirectedEdge(int v, int w, double weight);
    public double weight();
    public int from();
    public int to();
}

public class EdgeWeightedDAGSPs {
    public EdgeWeightedDAGSPs(EdgeWeightedDigraph G, int s);
    public double distTo(int v);
    public boolean hasPathTo(int v);
    public Iterable<DirectedEdge> pathTo(int v)
}
+END_FOLD*/

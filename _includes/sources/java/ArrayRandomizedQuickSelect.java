class ArrayRandomizedQuickSelect {
    // 1st is the first
    // Nth is the last
    public static int kthMin(int k, int[] a) {
        if (k <= 0 || k > a.length)
            throw new IllegalArgumentException();
        //+BEGIN_SOLUTION
        return kth(k-1, a, 0, a.length-1);
        //+END_SOLUTION
    }

    public static int kthMax(int k, int[] a) {
        if (k <= 0 || k > a.length)
            throw new IllegalArgumentException();
        //+BEGIN_SOLUTION
        return kth(a.length-k, a, 0, a.length-1);
        //+END_SOLUTION
    }

    //+BEGIN_SOLUTION
    private static int kth(int k, int[] a, int lo, int hi) {
        if (lo >= hi) return a[lo];
        int p = partition(a, lo, hi);
        if      (k < p) return kth(k, a, lo, p-1);
        else if (p < k) return kth(k, a, p+1, hi);
        else            return a[p];
    }
    //+END_SOLUTION

    //+BEGIN_SOLUTION
    private static int partition(int[] a, int lo, int hi) {
        // choose pivot randomly
        int r = lo + (int) (Math.random() * (hi - lo + 1));
        swap(a, lo, r);
        int v = a[lo];
        int i = lo, j = hi+1;
        while (true) {
            while (a[++i] < v) if (i == hi) break;
            while (v < a[--j]) if (j == lo) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }
    //+END_SOLUTION

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    //+BEGIN_FOLD Tests {
    public static void main(String[] args) throws Throwable {
        try {
            kthMin(1, new int[] {});
        } catch (IllegalArgumentException e) {}
        Assert.assertEquals(1, kthMin(1, new int[] {1}));

        Assert.assertEquals(1, kthMin(1, new int[] {6,5,4,3,2,1}));
        Assert.assertEquals(3, kthMin(3, new int[] {6,5,4,3,2,1}));
        Assert.assertEquals(6, kthMin(6, new int[] {6,5,4,3,2,1}));

        Assert.assertEquals(1, kthMin(1, new int[] {1,2,3,4,5,6}));
        Assert.assertEquals(3, kthMin(3, new int[] {1,2,3,4,5,6}));
        Assert.assertEquals(6, kthMin(6, new int[] {1,2,3,4,5,6}));

        Assert.assertEquals(1, kthMin(1, ArrayUtil.shuffle(new int[] {1,2,3,4,5,6})));
        Assert.assertEquals(3, kthMin(3, ArrayUtil.shuffle(new int[] {1,2,3,4,5,6})));
        Assert.assertEquals(6, kthMin(6, ArrayUtil.shuffle(new int[] {1,2,3,4,5,6})));

        try {
            kthMax(1, new int[] {});
        } catch (IllegalArgumentException e) {}
        Assert.assertEquals(1, kthMax(1, new int[] {1}));

        Assert.assertEquals(6, kthMax(1, new int[] {6,5,4,3,2,1}));
        Assert.assertEquals(4, kthMax(3, new int[] {6,5,4,3,2,1}));
        Assert.assertEquals(1, kthMax(6, new int[] {6,5,4,3,2,1}));

        Assert.assertEquals(6, kthMax(1, new int[] {1,2,3,4,5,6}));
        Assert.assertEquals(4, kthMax(3, new int[] {1,2,3,4,5,6}));
        Assert.assertEquals(1, kthMax(6, new int[] {1,2,3,4,5,6}));

        Assert.assertEquals(6, kthMax(1, ArrayUtil.shuffle(new int[] {1,2,3,4,5,6})));
        Assert.assertEquals(4, kthMax(3, ArrayUtil.shuffle(new int[] {1,2,3,4,5,6})));
        Assert.assertEquals(1, kthMax(6, ArrayUtil.shuffle(new int[] {1,2,3,4,5,6})));

        System.out.println("OK");
    }
    //+END_FOLD }
}

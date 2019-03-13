public class StringRLE {
    public static String encode(String s) {
        //+BEGIN_SOLUTION
        final int n = s.length();
        if (n == 0) return s;
        StringBuilder sb = new StringBuilder();
        char symbol = s.charAt(0);
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != symbol) {
                sb.append(symbol);
                sb.append(count);
                symbol = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(symbol);
        sb.append(count);
        return sb.toString();
        //+END_SOLUTION
    }

    public static String decode(String s) {
        //+BEGIN_SOLUTION
        final int n = s.length();
        if (n == 0) return s;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            char symbol = s.charAt(i++);
            StringBuilder digits = new StringBuilder();
            while (i < n) {
                char ch = s.charAt(i);
                if (Character.isDigit(ch)) {
                    digits.append(ch);
                    i++;
                } else {
                    break;
                }
            }
            int count = Integer.parseInt(digits.toString());
            for (int k = 0; k < count; k++) {
                sb.append(symbol);
            }
        }
        return sb.toString();
        //+END_SOLUTION
    }

    //+BEGIN_FOLD Tests {
    public static void main(String[] args) throws Throwable {
        Assert.assertEquals("", decode(encode("")));
        Assert.assertEquals("", encode(decode("")));
        Assert.assertEquals("AAABBC", decode(encode("AAABBC")));
        Assert.assertEquals("A3B2C1", encode(decode("A3B2C1")));
        System.out.println("OK");
    }
    //+END_FOLD }
}
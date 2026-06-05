/**
 * Project Euler - Solutions (Problems 1-20)
 * Author: Eylül Alara Ceztırnak
 * Language: Java
 */
public class Solutions {

    // Problem 1 - Multiples of 3 or 5
    public static long problem01() {
        long sum = 0;
        for (int i = 1; i < 1000; i++)
            if (i % 3 == 0 || i % 5 == 0) sum += i;
        return sum;
    }

    // Problem 2 - Even Fibonacci Numbers
    public static long problem02() {
        long a = 1, b = 2, sum = 0;
        while (a <= 4_000_000) {
            if (a % 2 == 0) sum += a;
            long tmp = a + b; a = b; b = tmp;
        }
        return sum;
    }

    // Problem 3 - Largest Prime Factor
    public static long problem03() {
        long n = 600851475143L, largest = 1, f = 2;
        while (f * f <= n) {
            while (n % f == 0) { largest = f; n /= f; }
            f++;
        }
        return n > 1 ? n : largest;
    }

    // Problem 4 - Largest Palindrome Product
    public static int problem04() {
        int largest = 0;
        for (int i = 999; i > 99; i--)
            for (int j = i; j > 99; j--) {
                int p = i * j;
                if (p <= largest) break;
                String s = Integer.toString(p);
                if (s.equals(new StringBuilder(s).reverse().toString()))
                    largest = p;
            }
        return largest;
    }

    // Problem 5 - Smallest Multiple
    public static long problem05() {
        long result = 1;
        for (int i = 2; i <= 20; i++) result = lcm(result, i);
        return result;
    }
    private static long gcd(long a, long b) { return b == 0 ? a : gcd(b, a % b); }
    private static long lcm(long a, long b) { return a / gcd(a, b) * b; }

    // Problem 6 - Sum Square Difference
    public static long problem06() {
        long sumSq = 0, sqSum = 0;
        for (int i = 1; i <= 100; i++) { sumSq += (long)i*i; sqSum += i; }
        return sqSum * sqSum - sumSq;
    }

    // Problem 7 - 10001st Prime
    public static int problem07() {
        int count = 0, num = 1;
        while (count < 10001) { num++; if (isPrime(num)) count++; }
        return num;
    }
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; (long)i*i <= n; i += 2)
            if (n % i == 0) return false;
        return true;
    }

    // Problem 8 - Largest Product in a Series
    public static long problem08() {
        String n = "73167176531330624919225119674426574742355349194934"
                 + "96983520312774506326239578318016984801869478851843"
                 + "85861560789112949495459501737958331952853208805511"
                 + "12540698747158523863050715693290963295227443043557"
                 + "66896648950445244523161731856403098711121722383113"
                 + "62229893423380308135336276614282806444486645238749"
                 + "30358907296290491560440772390713810515859307960866"
                 + "70172427121883998797908792274921901699720888093776"
                 + "65727333001053367881220235421809751254540594752243"
                 + "52584907711670556013604839586446706324415722155397"
                 + "53697817977846174064955149290862569321978468622482"
                 + "83972241375657056057490261407972968652414535100474"
                 + "82166370484403199890008895243450658541227588666881"
                 + "16427171479924442928230863465674813919123162824586"
                 + "17866458359124566529476545682848912883142607690042"
                 + "24219022671055626321111109370544217506941658960408"
                 + "07198403850962455444362981230987879927244284909188"
                 + "84580156166097919133875499200524063689912560717606"
                 + "05886116467109405077541002256983155200055935729725"
                 + "71636269561882670428252483600823257530420752963450";
        long best = 0;
        for (int i = 0; i <= n.length() - 13; i++) {
            long prod = 1;
            for (int k = 0; k < 13; k++) prod *= (n.charAt(i+k) - '0');
            if (prod > best) best = prod;
        }
        return best;
    }

    // Problem 9 - Special Pythagorean Triplet
    public static long problem09() {
        for (int a = 1; a < 1000; a++)
            for (int b = a; b < 1000; b++) {
                int c = 1000 - a - b;
                if (c > 0 && a*a + b*b == c*c) return (long)a*b*c;
            }
        return -1;
    }

    // Problem 10 - Summation of Primes
    public static long problem10() {
        int limit = 2_000_000;
        boolean[] sieve = new boolean[limit];
        java.util.Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        for (int i = 2; (long)i*i < limit; i++)
            if (sieve[i]) for (int j = i*i; j < limit; j += i) sieve[j] = false;
        long sum = 0;
        for (int i = 2; i < limit; i++) if (sieve[i]) sum += i;
        return sum;
    }

    // Problem 11 - Largest Product in a Grid
    public static int problem11() {
        int[][] g = {
            {8,2,22,97,38,15,0,40,0,75,4,5,7,78,52,12,50,77,91,8},
            {49,49,99,40,17,81,18,57,60,87,17,40,98,43,69,48,4,56,62,0},
            {81,49,31,73,55,79,14,29,93,71,40,67,53,88,30,3,49,13,36,65},
            {52,70,95,23,4,60,11,42,69,24,68,56,1,32,56,71,37,2,36,91},
            {22,31,16,71,51,67,63,89,41,92,36,54,22,40,40,28,66,33,13,80},
            {24,47,32,60,99,3,45,2,44,75,33,53,78,36,84,20,35,17,12,50},
            {32,98,81,28,64,23,67,10,26,38,40,67,59,54,70,66,18,38,64,70},
            {67,26,20,68,2,62,12,20,95,63,94,39,63,8,40,91,66,49,94,21},
            {24,55,58,5,66,73,99,26,97,17,78,78,96,83,14,88,34,89,63,72},
            {21,36,23,9,75,0,76,44,20,45,35,14,0,61,33,97,34,31,33,95},
            {78,17,53,28,22,75,31,67,15,94,3,80,4,62,16,14,9,53,56,92},
            {16,39,5,42,96,35,31,47,55,58,88,24,0,17,54,24,36,29,85,57},
            {86,56,0,48,35,71,89,7,5,44,44,37,44,60,21,58,51,54,17,58},
            {19,80,81,68,5,94,47,69,28,73,92,13,86,52,17,77,4,89,55,40},
            {4,52,8,83,97,35,99,16,7,97,57,32,16,26,26,79,33,27,98,66},
            {88,36,68,87,57,62,20,72,3,46,33,67,46,55,12,32,63,93,53,69},
            {4,42,16,73,38,25,39,11,24,94,72,18,8,46,29,32,40,62,76,36},
            {20,69,36,41,72,30,23,88,34,62,99,69,82,67,59,85,74,4,36,16},
            {20,73,35,29,78,31,90,1,74,31,49,71,48,86,81,16,23,57,5,54},
            {1,70,54,71,83,51,54,69,16,92,33,48,61,43,52,1,89,19,67,48}
        };
        int best = 0;
        for (int r = 0; r < 20; r++)
            for (int c = 0; c < 20; c++) {
                if (c+3<20) best=Math.max(best,g[r][c]*g[r][c+1]*g[r][c+2]*g[r][c+3]);
                if (r+3<20) best=Math.max(best,g[r][c]*g[r+1][c]*g[r+2][c]*g[r+3][c]);
                if (r+3<20&&c+3<20) best=Math.max(best,g[r][c]*g[r+1][c+1]*g[r+2][c+2]*g[r+3][c+3]);
                if (r+3<20&&c-3>=0) best=Math.max(best,g[r][c]*g[r+1][c-1]*g[r+2][c-2]*g[r+3][c-3]);
            }
        return best;
    }

    // Problem 12 - Highly Divisible Triangular Number
    public static long problem12() {
        long n = 1, tri = 1;
        while (countDivisors(tri) <= 500) { n++; tri += n; }
        return tri;
    }
    private static int countDivisors(long n) {
        int count = 0;
        for (long i = 1; i*i <= n; i++)
            if (n % i == 0) count += (i != n/i) ? 2 : 1;
        return count;
    }

    // Problem 13 - Large Sum (first 10 digits)
    public static String problem13() {
        java.math.BigInteger sum = java.math.BigInteger.ZERO;
        String[] nums = {
            "37107287533902102798797998220837590246510135740250",
            "46376937677490009712648124896970078050417018260538",
            "74324986426247148859593507217946133067637129687455",
            "59523860731862182910478301714616361897542566430573",
            "27846847386401888654509234981184244490855547884900",
            "32441851643161497412171886453020466505512671535050",
            "34430150716738524074924184959886700712949541992534",
            "26107725852099704645060676685693439291742821013629",
            "79418974748684876890313460041435361429877971848584",
            "87384138279065326028379892917366126836817459753148",
        };
        for (String s : nums) sum = sum.add(new java.math.BigInteger(s));
        return sum.toString().substring(0, 10);
    }

    // Problem 14 - Longest Collatz Sequence
    public static int problem14() {
        int best = 0, bestStart = 0;
        for (int i = 1; i < 1_000_000; i++) {
            int len = collatzLen(i);
            if (len > best) { best = len; bestStart = i; }
        }
        return bestStart;
    }
    private static int collatzLen(long n) {
        int len = 1;
        while (n != 1) { n = (n % 2 == 0) ? n/2 : 3*n+1; len++; }
        return len;
    }

    // Problem 15 - Lattice Paths
    public static java.math.BigInteger problem15() {
        // C(40,20)
        java.math.BigInteger num = java.math.BigInteger.ONE;
        java.math.BigInteger den = java.math.BigInteger.ONE;
        for (int i = 0; i < 20; i++) {
            num = num.multiply(java.math.BigInteger.valueOf(40 - i));
            den = den.multiply(java.math.BigInteger.valueOf(i + 1));
        }
        return num.divide(den);
    }

    // Problem 16 - Power Digit Sum
    public static int problem16() {
        String s = java.math.BigInteger.TWO.pow(1000).toString();
        return s.chars().map(c -> c - '0').sum();
    }

    // Problem 17 - Number Letter Counts
    public static int problem17() {
        int[] ones = {0,3,3,5,4,4,3,5,5,4,3,6,6,8,8,7,7,9,8,8};
        int[] tens = {0,0,6,6,5,5,5,7,6,6};
        int total = 0;
        for (int n = 1; n <= 1000; n++) {
            if (n == 1000) { total += 11; continue; }
            int t = 0;
            if (n >= 100) { t += ones[n/100] + 7; if (n%100 > 0) t += 3; }
            int r = n % 100;
            if (r >= 20) t += tens[r/10] + ones[r%10];
            else if (r > 0) t += ones[r];
            total += t;
        }
        return total;
    }

    // Problem 18 - Maximum Path Sum I
    public static int problem18() {
        int[][] tri = {
            {75},{95,64},{17,47,82},{18,35,87,10},{20,4,82,47,65},
            {19,1,23,75,3,34},{88,2,77,73,7,63,67},{99,65,4,28,6,16,70,92},
            {41,41,26,56,83,40,80,70,33},{41,48,72,33,47,32,37,16,94,29},
            {53,71,44,65,25,43,91,52,97,51,14},{70,11,33,28,77,73,17,78,39,68,17,57},
            {91,71,52,38,17,14,91,43,58,50,27,29,48},
            {63,66,4,68,89,53,67,30,73,16,69,87,40,31},
            {4,62,98,27,23,9,70,98,73,93,38,53,60,4,23}
        };
        for (int i = tri.length-2; i >= 0; i--)
            for (int j = 0; j < tri[i].length; j++)
                tri[i][j] += Math.max(tri[i+1][j], tri[i+1][j+1]);
        return tri[0][0];
    }

    // Problem 19 - Counting Sundays
    public static int problem19() {
        int count = 0;
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(1901, 0, 1);
        while (cal.get(java.util.Calendar.YEAR) <= 2000) {
            if (cal.get(java.util.Calendar.DAY_OF_WEEK) == java.util.Calendar.SUNDAY)
                count++;
            cal.add(java.util.Calendar.MONTH, 1);
        }
        return count;
    }

    // Problem 20 - Factorial Digit Sum
    public static int problem20() {
        java.math.BigInteger fact = java.math.BigInteger.ONE;
        for (int i = 2; i <= 100; i++) fact = fact.multiply(java.math.BigInteger.valueOf(i));
        return fact.toString().chars().map(c -> c - '0').sum();
    }

    public static void main(String[] args) {
        System.out.println("Problem 01: " + problem01());
        System.out.println("Problem 02: " + problem02());
        System.out.println("Problem 03: " + problem03());
        System.out.println("Problem 04: " + problem04());
        System.out.println("Problem 05: " + problem05());
        System.out.println("Problem 06: " + problem06());
        System.out.println("Problem 07: " + problem07());
        System.out.println("Problem 08: " + problem08());
        System.out.println("Problem 09: " + problem09());
        System.out.println("Problem 10: " + problem10());
        System.out.println("Problem 11: " + problem11());
        System.out.println("Problem 12: " + problem12());
        System.out.println("Problem 13: " + problem13());
        System.out.println("Problem 14: " + problem14());
        System.out.println("Problem 15: " + problem15());
        System.out.println("Problem 16: " + problem16());
        System.out.println("Problem 17: " + problem17());
        System.out.println("Problem 18: " + problem18());
        System.out.println("Problem 19: " + problem19());
        System.out.println("Problem 20: " + problem20());
    }
}

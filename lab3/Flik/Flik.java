/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        // return a == b; //Integer objects are cached internally and reused via the same referenced objects for Integer values in the range between –128 to +127.
        return a.equals(b);
    }
}

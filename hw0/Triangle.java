public class Triangle {
    public static void drawTriangle(int N) {
        String s = "*";
        for (int i = 0; i < N; i++) {
            System.out.println(s);
            s += "*";
        }
    }

    public static void main(String[] args) {
        drawTriangle(10);
    }
}

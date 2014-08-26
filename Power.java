/**
 * Implement pow(x, n).
 */

public class Power {
    public double pow(double x, int n) {
        if (n > 0)
            return absPow(x, n);
        else
            return 1.0 / absPow(x, -n);
    }

    private double absPow(double x, int n) {
        if (n == 0)
            return 1;

        double sub = absPow(x, n / 2);
        return n % 2 == 1 ? sub * sub * x : sub * sub;
    }
}
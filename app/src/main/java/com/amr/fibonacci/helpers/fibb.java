package com.amr.fibonacci.helpers;

import io.reactivex.Observable;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class fibb {

    private static final BigDecimal SQRT_DIG = new BigDecimal(150);
    private static final BigDecimal SQRT_PRE = new BigDecimal(10).pow(SQRT_DIG.intValue());

    public static Observable<Long> fibsStartFrom(Long f1, Long f2) {
        return Observable.just(true)
                .repeat()
                .scan(new Tuple(f1, f2), (tuple, dummyTrue) -> new Tuple(tuple.value2, tuple.value1 + tuple.value2))
                .map(Tuple::value2);
    }

    public static BigDecimal fib(int n) {
        BigDecimal one = new BigDecimal(1);
        BigDecimal sqrtFive = bigSqrt(new BigDecimal(5));
        BigDecimal two = new BigDecimal(2);

        BigDecimal phi = one.add(sqrtFive).divide(two, RoundingMode.HALF_DOWN).pow(n);
        BigDecimal phi_ = one.subtract(sqrtFive).divide(two, RoundingMode.HALF_DOWN).pow(n);

        BigDecimal result = phi.subtract(phi_).divide(sqrtFive, RoundingMode.HALF_DOWN);

        return result;
    }

    /**
     * Private utility method used to compute the square root of a BigDecimal.
     *
     * @author Luciano Culacciatti
     * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
     */
    private static BigDecimal sqrtNewtonRaphson(BigDecimal c, BigDecimal xn, BigDecimal precision) {
        BigDecimal fx = xn.pow(2).add(c.negate());
        BigDecimal fpx = xn.multiply(new BigDecimal(2));
        BigDecimal xn1 = fx.divide(fpx, 2 * SQRT_DIG.intValue(), RoundingMode.HALF_DOWN);
        xn1 = xn.add(xn1.negate());
        BigDecimal currentSquare = xn1.pow(2);
        BigDecimal currentPrecision = currentSquare.subtract(c);
        currentPrecision = currentPrecision.abs();
        if (currentPrecision.compareTo(precision) <= -1) {
            return xn1;
        }
        return sqrtNewtonRaphson(c, xn1, precision);
    }

    /**
     * Uses Newton Raphson to compute the square root of a BigDecimal.
     *
     * @author Luciano Culacciatti
     * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
     */
    public static BigDecimal bigSqrt(BigDecimal c) {
        return sqrtNewtonRaphson(c, new BigDecimal(1), new BigDecimal(1).divide(SQRT_PRE));
    }

}



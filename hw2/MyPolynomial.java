import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double[] coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree(){
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        String sPoly = coeffs[coeffs.length - 1] +
                       "x^" + (coeffs.length - 1);
        for (int i = coeffs.length - 2; i > 0 ; i--) {
            if (coeffs[i] >= 0.0)
                sPoly+= "+";
            sPoly += coeffs[i] + "x^" + i;
        }
        sPoly += (coeffs[0] >= 0.0) ? "+" + coeffs[0] : coeffs[0];
        return sPoly;
    }

    public MyPolynomial add(MyPolynomial right){
        double[] resultCoeffs;
        int smallerLen = right.coeffs.length;
        if (getDegree() >= right.getDegree()) {
            resultCoeffs = coeffs.clone();
        }
        else {
            resultCoeffs = right.coeffs.clone();
            smallerLen = coeffs.length;
        }
        for (int i = 0; i < smallerLen; i++) {
            resultCoeffs[i] += right.coeffs[i];
        }
        return new MyPolynomial(resultCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial right){
        double[] resultCoeffs =
                new double[getDegree() + right.getDegree() + 1];
        double[] bigger, smaller;
        if (getDegree() >= right.getDegree()){
            bigger = this.coeffs;
            smaller = right.coeffs;
        }
        else {
            bigger = right.coeffs;
            smaller = this.coeffs;
        }
        for (int i = 0; i < smaller.length; i++)
            for (int j = 0; j < bigger.length; j++)
                resultCoeffs[i + j] += bigger[j] * smaller[i];
        return new MyPolynomial(resultCoeffs);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        MyPolynomial p = (MyPolynomial) obj;
        return Arrays.equals(coeffs, p.coeffs);
    }

    @Override
    public int hashCode() {
        int result = 17;
        long c;
        for(double coef: coeffs){
            c = Double.doubleToLongBits(coef);
            result = 31 * result + (int)(c ^ (c >>> 32));
        }
        return result;
    }
}

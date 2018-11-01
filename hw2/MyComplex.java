public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "(" + real + (imag >= 0.0? "+" : "") + imag + "i)";
    }

    public boolean isReal(){
        if(real != 0.0)
            return true;
        else
            return false;
    }

    public boolean isImaginary(){
        if(imag != 0.0)
            return true;
        else
            return false;
    }

    public boolean equals(double real, double imag) {
        if((Double.compare(this.real, real) == 0) &&
           (Double.compare(this.imag, imag) == 0))
            return true;
        else
            return false;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return  false;
        if (getClass() != obj.getClass()) return  false;

        MyComplex z = (MyComplex) obj;
        return equals(z.real, z.imag);
    }

    @Override
    public int hashCode() {
        int result = 17;
        long r = Double.doubleToLongBits(real);
        long i = Double.doubleToLongBits(imag);
        result = 31 * result + (int)(r ^ (r >>> 32));
        result = 31 * result + (int)(i ^ (i >>> 32));
        return result;
    }

    public double magnitude(){
        return Math.sqrt(Math.pow(real, 2.0) + Math.pow(imag, 2.0));
    }

    public  double argument(){
        return Math.atan(imag / real);
    }

    public MyComplex add(MyComplex right){
        real += right.real;
        imag += right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right){
        MyComplex z = new MyComplex(real, imag);
        z.real += right.real;
        z.imag += right.imag;
        return z;
    }

    public MyComplex subtract(MyComplex right){
        real -= right.real;
        imag -= right.imag;
        return this;
    }

    public MyComplex subtractNew(MyComplex right){
        MyComplex z = new MyComplex(real, imag);
        z.real -= right.real;
        z.imag -= right.imag;
        return z;
    }

    public MyComplex multiply(MyComplex right){
        real = real * right.real - imag * right.imag;
        imag = real * right.imag + right.real * imag;
        return this;
    }

    public MyComplex divide(MyComplex right){
        double newReal = (real * right.real + imag * right.imag);
        newReal /= Math.pow(right.real, 2.0) + Math.pow(right.imag, 2.0);

        double newImag = (right.real * imag - real * right.imag);
        newImag /= Math.pow(right.real, 2.0) + Math.pow(right.imag, 2.0);

        real = newReal;
        imag = newImag;
        return this;
    }

    public MyComplex conjugate(){
        return new MyComplex(real, -1.0 * imag);
    }


}

package com.netcracker;

import org.json.JSONObject;

public class Expression {
    private double a;
    private double b;
    private char operation = '+';
    private double result;

    public Expression(){}

    public Expression( char operation, double a, double b) {
        this.a = a;
        this.b = b;
        this.operation = operation;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public char getOperation() {
        return operation;
    }

    public double getResult() {
        calculate();
        return result;
    }

    public void calculate(){
        switch (operation){
            case '+': result = a + b; break;
            case '-': result = a - b; break;
            case '*': result = a * b; break;
            case '/': result = (b != 0.0 ) ? a / b : Double.NaN; break;
        }
    }

    public String toPlainText(){
        calculate();
        String result = "<calculation>\n" +
                "   <expression value=\"" + a + operation + b + "\"/>\n" +
                "   <result value=\"" + getResult() + "\"/>\n" +
                "</calculation>";
        return result;
    }

    public String toHtml(){
        calculate();
        String result =
                "<head> <title>RESTy calculator</title> </head>" +
                "<body>" +
                    "<h2>Expression: " + a + operation + b + "</h2>" +
                    "<h2>Result: " + getResult() + "</h2>" +
                "</body>";
        return result;
    }

    public String toJson(){
        calculate();
        JSONObject json = new JSONObject();
        json.put("a", a);
        json.put("b", b);
        json.put("operation", operation + "");
        json.put("result", result);
        return json.toString();
    }
}

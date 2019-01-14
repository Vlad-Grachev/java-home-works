package com.netcracker;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CalculationRestClient {
    public static void requestTextPlain(Client client, String operation, double a, double b){
        WebTarget webTarget = client.target("http://localhost:8080/rest/calc")
                .path(operation)
                .path(String.valueOf(a))
                .path(String.valueOf(b))
                .path("xml");
        Invocation.Builder builder = webTarget.request(MediaType.TEXT_PLAIN);
        Response response = builder.get();
        System.out.println(response.readEntity(String.class));
    }

    public static void requestJson(Client client, String operation, double a, double b){
        WebTarget webTarget = client.target("http://localhost:8080/rest/calc")
                .path(operation)
                .path(String.valueOf(a))
                .path(String.valueOf(b))
                .path("json");
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();
        System.out.println(response.readEntity(String.class));
    }

    public static void makeRequest(Client client, String operation, double a, double b, String responceType){
        if(responceType.equals("plain"))
            requestTextPlain(client, operation, a, b);
        if(responceType.equals("json"))
            requestJson(client, operation, a, b);
    }

    public static void main(String[] args) {
        double a = 1.0, b = 1.0;
        String operationPath = "add";
        String responceType = "plain";
        if(args.length == 4){
            switch (args[0].charAt(0)) {
                case '+': operationPath = "add";break;
                case '-': operationPath = "sub";break;
                case '*': operationPath = "mul";break;
                case '/': operationPath = "div";break;
            };
            a = Double.parseDouble(args[1]);
            b = Double.parseDouble(args[2]);
            responceType = args[3];
        }

        Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
        makeRequest(client, operationPath, a, b, responceType);
    }
}

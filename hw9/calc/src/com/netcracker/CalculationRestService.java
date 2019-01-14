package com.netcracker;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/calc")
public class CalculationRestService {
    @GET
    @Path("/add/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String getSumAsHtml(@PathParam("a") double a, @PathParam("b") double b){
        Expression expression = new Expression('+', a, b);
        return expression.toHtml();
    }

    @GET
    @Path("/sub/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String getDifAsHtml(@PathParam("a") double a, @PathParam("b") double b){
        Expression expression = new Expression('-', a, b);
        return expression.toHtml();
    }

    @GET
    @Path("/mul/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String getProdAsHtml(@PathParam("a") double a, @PathParam("b") double b){
        Expression expression = new Expression('*', a, b);
        return expression.toHtml();
    }

    @GET
    @Path("/div/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String getQuotAsHtml(@PathParam("a") double a, @PathParam("b") double b){
        Expression expression = new Expression('/', a, b);
        return expression.toHtml();
    }

    @GET
    @Path("/add/{a}/{b}/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSumAsJson(@PathParam("a") double a, @PathParam("b") double b){
        Expression expression = new Expression('+', a, b);
        return expression.toJson();
    }

    @GET
    @Path("/sub/{a}/{b}/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDifAsJson(@PathParam("a") double a, @PathParam("b") double b){
        Expression expression = new Expression('-', a, b);
        return expression.toJson();
    }

    @GET
    @Path("/mul/{a}/{b}/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProdAsJson(@PathParam("a") double a, @PathParam("b") double b){
        Expression expression = new Expression('*', a, b);
        return expression.toJson();
    }

    @GET
    @Path("/div/{a}/{b}/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String getQuotAsJson(@PathParam("a") double a, @PathParam("b") double b){
        Expression expression = new Expression('/', a, b);
        return expression.toJson();
    }

    @GET
    @Path("/add/{a}/{b}/xml")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSumAsXml(@PathParam("a") double a, @PathParam("b") double b){
        Expression expression = new Expression('+', a, b);
        return expression.toPlainText();
    }

    @GET
    @Path("/sub/{a}/{b}/xml")
    @Produces(MediaType.TEXT_PLAIN)
    public String getDifAsXml(@PathParam("a") double a, @PathParam("b") double b){
        Expression expression = new Expression('-', a, b);
        return expression.toPlainText();
    }

    @GET
    @Path("/mul/{a}/{b}/xml")
    @Produces(MediaType.TEXT_PLAIN)
    public String getProdAsXml(@PathParam("a") double a, @PathParam("b") double b){
        Expression expression = new Expression('*', a, b);
        return expression.toPlainText();
    }

    @GET
    @Path("/div/{a}/{b}/xml")
    @Produces(MediaType.TEXT_PLAIN)
    public String getQuotAsXml(@PathParam("a") double a, @PathParam("b") double b){
        Expression expression = new Expression('/', a, b);
        return expression.toPlainText();
    }
}

package com.qianhong.calculator;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

@Path("/calculator")
public class CalculatorService {

    @GET
    @Path("ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "Welcome to Java Maven Calculator Web App!!!\n" + new Date().toString();
    }

    @GET
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    public CalculatorResponse Add(@QueryParam("x") int x, @QueryParam("y") int y) {
        return new CalculatorResponse(x, y, x + y);
    }

    @GET
    @Path("sub")
    @Produces(MediaType.APPLICATION_JSON)
    public CalculatorResponse Sub(@QueryParam("x") int x, @QueryParam("y") int y) {
        return new CalculatorResponse(x, y, x - y);
    }

    @GET
    @Path("mul")
    @Produces(MediaType.APPLICATION_JSON)
    public CalculatorResponse Mul(@QueryParam("x") int x, @QueryParam("y") int y) {
        return new CalculatorResponse(x, y, x * y);
    }

    @GET
    @Path("div")
    @Produces(MediaType.APPLICATION_JSON)
    public CalculatorResponse Div(@QueryParam("x") int x, @QueryParam("y") int y) {
        if (y == 0) {
            throw new WebApplicationException("Your equation cannot divided by zero", 400);
        }
        return new CalculatorResponse(x, y, x / y);
    }

    @GET
    @Path("pow")
    @Produces(MediaType.APPLICATION_JSON)
    public CalculatorResponse Pow(@QueryParam("x") int x, @QueryParam("y") int y) {
        return new CalculatorResponse(x, y, (int) Math.pow(x, y));
    }
}

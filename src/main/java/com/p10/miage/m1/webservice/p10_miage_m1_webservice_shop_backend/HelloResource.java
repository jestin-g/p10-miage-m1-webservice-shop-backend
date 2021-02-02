package com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend;

import com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.model.Item;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/test")
public class HelloResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test() {
        return Response.ok("test").build();
    }
}
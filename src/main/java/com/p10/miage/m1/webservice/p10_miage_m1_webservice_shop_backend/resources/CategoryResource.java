package com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.resources;

import com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.data.CategoryDAO;
import com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.models.Category;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Path("/category")
public class CategoryResource {

    private CategoryDAO dao = CategoryDAO.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response all() {
        List<Category> all = dao.allOrganized();
        return Response.ok(all).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Optional<Category> category = dao.get(id);
        if (category.isPresent()) {
            return Response.ok(category.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

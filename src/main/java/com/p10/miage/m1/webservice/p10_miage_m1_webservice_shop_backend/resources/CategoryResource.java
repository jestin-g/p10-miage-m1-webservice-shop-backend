package com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.resources;

import com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.data.CategoryDAO;
import com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.models.Category;
import com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.models.Item;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Optional;

@Path("/category")
public class CategoryResource {

    private CategoryDAO dao = CategoryDAO.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response all() {
        Map<Integer, Category> all = dao.all();
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Category category) throws URISyntaxException {
        int newCategoryId = dao.save(category);
        URI uri = new URI("/category/" + newCategoryId);
        return Response.created(uri).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, Category newCategory) {
        if (dao.update(id, newCategory)) {
            return Response.ok().build();
        }
        return Response.notModified().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        if (dao.delete(id)) {
            return Response.ok().build();
        }
        return Response.notModified().build();
    }
}

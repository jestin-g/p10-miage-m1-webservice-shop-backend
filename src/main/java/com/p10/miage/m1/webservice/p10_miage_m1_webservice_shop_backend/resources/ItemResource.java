package com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.resources;

import com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.data.ItemDAO;
import com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.models.Item;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Optional;

@Path("/item")
public class ItemResource {

    private final ItemDAO dao = ItemDAO.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response all() {
        Map<Integer, Item> all = dao.all();
        all.forEach((integer, item) -> item.setId(integer));
        return Response.ok(all.values().toArray()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Optional<Item> item = dao.get(id);
        if (item.isPresent()) {
            item.get().setId(id);
            return Response.ok(item.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("category/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByCategory(@PathParam("category") String category) {
        Map<Integer, Item> res = dao.getByCategory(category);
        res.forEach((integer, item) -> item.setId(integer));
        return Response.ok(res.values().toArray()).build();
    }

    @GET
    @Path("maincategory/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByMainCategory(@PathParam("category") String category) {
        Map<Integer, Item> res = dao.getByMainCategory(category);
        res.forEach((integer, item) -> item.setId(integer));
        return Response.ok(res.values().toArray()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Item item) throws URISyntaxException {
        int newItemId = dao.save(item);
        URI uri = new URI("/item/" + newItemId);
        return Response.created(uri).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, Item newItem) {
        if (dao.update(id, newItem)) {
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
/**
 * @ (#) ProductResource.java      9/21/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week03_phantiensinh.backend.api;

import jakarta.ejb.EJB;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week03_phantiensinh.backend.business.ProductBeanRemote;
import vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.entities.Product;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/21/2024
 */
@Path("/products")
public class ProductResource {
    @EJB
    private ProductBeanRemote productBean;

    @GET
    @Produces("application/json")
    public Response getAll() {
        return Response.ok(productBean.getAllDTO()).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        return Response.ok(productBean.getById_DTO(id)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Transactional
    public Response add(Product product) {
        productBean.add(product);
        return Response.ok(product).build();
    }

//    @POST
//    @Consumes("application/json")
//    @Produces("application/json")
//    @Transactional
//    public Response update(Product product) {
//        productBean.update(product);
//        return Response.ok(product).build();
//    }
}

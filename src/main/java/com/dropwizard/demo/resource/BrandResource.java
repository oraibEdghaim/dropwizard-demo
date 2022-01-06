package com.dropwizard.demo.resource;

import com.dropwizard.demo.domain.Brand;
import com.dropwizard.demo.repository.BrandRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;


@Path("/brands")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BrandResource {
    private final BrandRepository brandRepository;

    public BrandResource(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GET
    public List<Brand> getBrands() throws SQLException {
        return brandRepository.findAll();
    }

    @GET
    @Path("/{id}")
    public Brand getById(@PathParam("id") Long id) throws SQLException {
        return brandRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @POST
    @Path("/new")
    public String insertBrand(Brand brand) throws SQLException {
        return brandRepository.insert(brand);
    }

    @DELETE
    @Path("/remove")
    public String deleteBrand(Brand brand) throws SQLException {
        return brandRepository.delete(brand);
    }

    @PUT
    @Path("/update")
    public String updateBrand(Brand brand) throws SQLException {
        return brandRepository.update(brand);
    }

}
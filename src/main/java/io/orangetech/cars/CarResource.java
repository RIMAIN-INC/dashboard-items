package io.orangetech.cars;


import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@RolesAllowed("USER")
@Path("/cars")
public class CarResource {


    @Inject
    CarService carService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCars(){
        List<Car> carList = carService.getAll();
        return Response.ok(carList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCar(@PathParam("id") long id){
        Car car = carService.getCar(id);
        return Response.ok(car).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCar(CarRequest car){
       carService.addCar(car);
       return Response.ok(car).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCar(@PathParam("id") long id, CarRequest car){
        carService.updateCar(id, car);
        return Response.ok(car).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCar(@PathParam("id") long id){
        carService.deleteCar(id);
        return Response.noContent().build();
    }

}

package io.orangetech.auth.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.orangetech.auth.controller.entity.AccessToken;
import io.orangetech.auth.controller.entity.LoginResponse;
import io.orangetech.auth.controller.entity.User;
import io.orangetech.auth.controller.entity.UserResponse;
import io.orangetech.auth.controller.service.AuthService;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/secured")
public class AuthController {


    @Inject
    AuthService authService;

    @POST
    @Path("/sign-up")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerUser(UserResponse userResponse){
        try{
            authService.registerUser(userResponse);
            JsonObject response = Json.createObjectBuilder()
                    .add("message", "Account Created Successfully")
                    .build();
            return Response.ok(response).build();
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity("Account is already created").build();
        }
    }

    @POST
    @Path("/sign-in")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logUserIn(LoginResponse loginResponse) throws Exception {
        try{
            AccessToken accessToken = authService.authenticateUser(loginResponse);
            return Response.accepted(accessToken).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }


}

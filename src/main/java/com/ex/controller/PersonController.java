package com.ex.controller;

import com.ex.model.Person;
import com.ex.service.PersonServiceImpl;
import com.ex.service.PersonService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("api/v1")
public class PersonController {

    private PersonService personService;

    public PersonController() throws ClassNotFoundException {
        this.personService = new PersonServiceImpl();
    }

    @GET
    @Path("persons/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findbyId(@PathParam("id") int personId) {
        Person person = personService.findbyId(personId);
        return Response.ok(person).build();
    }

    @GET
    @Path("persons")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<Person> personList =personService.findAll();
        return Response.ok(personList).build();
    }


    @POST
    @Path("persons")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(Person person) {
        personService.insert(person);
        return Response.status(201).entity(person).build();
    }

    @PUT
    @Path("persons")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Person person) {
        personService.update(person);
        return Response.status(203).entity(person).build();
    }

    @DELETE
    @Path("persons/{id}")
    public Response delete(@PathParam("id") int personId) {
        personService.delete(personId);
        return Response.noContent().build();
    }

    @DELETE
    @Path("persons")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(Person person){
        personService.deleteById(person);
        return Response.noContent().build();
    }
}
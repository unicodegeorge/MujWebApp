package cz.unicode.webapp;
import cz.unicode.webapp.models.AnimalModel;
import cz.unicode.webapp.managers.AnimalManager;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("animals")
public class AnimalsResource {
    @Inject
    private AnimalManager animalManager;
    @GET
    public Response getAllAnimals(){
        return Response.ok(animalManager.getAllAnimals()).build();
    }

    @POST
    public Response addAnimals(AnimalModel animal) {

        animalManager.addAnimals(animal);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    public Response editAnimal(@PathParam("id") int id, AnimalModel animal) {

        if(animalManager.editAnimals(id, animal)){
            return Response.ok("Animal edited").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
    @DELETE
    @Path("{id}")
    public Response deleteAnimal(@PathParam("id") int id) {
        if(animalManager.removeAnimal(id)){
            return Response.ok("Animal removed").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

    @GET
    @Path("{id}")
    public Response getAnimalById(@PathParam("id") int id){
        return Response.ok(animalManager.returnAnimal(id)).build();
    }

}

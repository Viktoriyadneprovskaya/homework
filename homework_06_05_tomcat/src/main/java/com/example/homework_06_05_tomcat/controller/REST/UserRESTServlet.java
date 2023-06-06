package com.example.homework_06_05_tomcat.controller.REST;

import com.example.homework_06_05_tomcat.dao.UserDaoImpl;
import com.example.homework_06_05_tomcat.model.User;
import com.example.homework_06_05_tomcat.model.command.UserCommand;
import com.example.homework_06_05_tomcat.model.command.UserUpdateCommand;
import com.example.homework_06_05_tomcat.util.UserCommandValidator;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Path("/")
public class UserRESTServlet {
    private final UserDaoImpl userDao;

    public UserRESTServlet() {
        this.userDao = new UserDaoImpl();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/users")
    public List<UserCommand> getAllUsers(){
        List<User> dbusers = userDao.getAllUsers();
        List<UserCommand> usersCommand = UserCommand.usersToCommand(dbusers);
        return usersCommand;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/users/{id}")
    public UserCommand getUserById(@PathParam("id") Long id){
        Optional<User> optional = userDao.getUserById(id);
        User user = optional.orElseThrow(()->new RuntimeException("User not found"));
        return UserCommand.userToCommand(user) ;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("users")
    public Response createUser(User user){
        try{
            userDao.createUser(user);
        }catch (Exception e){
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getCause().getMessage())
                    .build();
        }

        return Response
                .status(Response.Status.CREATED)
                .entity("User was created")
                .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("users/{id}")
    public Response updateUser(@PathParam("id") Long id, User user){

            UserUpdateCommand userUpdateCommand = UserUpdateCommand.builder()
                    .username(user.getUsername())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .address(user.getAddress())
                    .phoneNumber(user.getPhoneNumber())
                    //.date(birthDate)
                    .build();
        Map<String,String> errors = UserCommandValidator.validateUserCommand(userUpdateCommand);
        List<User> users = userDao.findUsersByUserName(user.getUsername());
        if(users.size()>0){
            errors.put("username", "Username already exists");
        }
        if(!errors.isEmpty()){
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(errors)
                    .build();
        }else {
            userDao.updateUserById(id,userUpdateCommand);
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity("User was updated")
                    .build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/users/{id}")
    public Response deleteUserById(@PathParam("id") Long id) {
        Optional<User> optional = userDao.getUserById(id);
        if (optional.isPresent()) {
            userDao.deleteUserById(id);
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity("User was deleted")
                    .build();

        } else {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("This user doesn't exist")
                    .build();
        }
    }
}

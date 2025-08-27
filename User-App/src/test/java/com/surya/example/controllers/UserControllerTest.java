package com.surya.example.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import com.surya.example.entities.User;
import com.surya.example.services.UserService;


@WebMvcTest//Loads only Spring MVC components (controllers,filters
//Loads only the given class (UserController) into the Spring test context.
@ContextConfiguration(classes = {UserController.class}) // Only load the controller
@Import(org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration.class)
class UserControllerTest {

    @Autowired
    //MockMvc to fake HTTP calls
    private MockMvc mockMvc;

    @MockitoBean// replaces the real bean with a mock
    private UserService userService;

    @Test
    void addUserTest() throws Exception {
        User user = new User(1L, "Surya", "surya@gmail.com");
        //"When userService.save(...) is called with any argument,
        //then return this user object instead of running real logic."
        Mockito.when(userService.save(Mockito.any())).thenReturn(user);

        mockMvc.perform(
                post("/addNewUser")                           // 1. POST request to the endpoint
                .contentType("application/json")              // 2. Tells Spring: "I'm sending JSON"
                .content("""
                    {
                      "name": "Surya",
                      "email": "surya@gmail.com"
                    }
                """)                                           // 3. Actual request body
            )
            .andExpect(status().isOk())                        // 4. Expect HTTP 200 OK response
            .andExpect(jsonPath("$.name").value("Surya"));  
        // 5. Expect response JSON to have name = "Surya"
}
    
    
    
    @Test
    void getAllUsersTest() throws Exception {
        List<User> users = List.of(
                new User(1L, "Surya", "surya@gmail.com"),
                new User(2L, "Ram", "ram@gmail.com")
        );
        Mockito.when(userService.findAllUser()).thenReturn(users);

        mockMvc.perform(get("/getAllUsers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void deleteUserByIdTest() throws Exception {
        Mockito.doNothing().when(userService).deleteUserById(1L);

        mockMvc.perform(delete("/deleteUserById/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("user deleted Sucesfully!"));
    }

    @Test
    void updateUserByIdTest() throws Exception {
        User updated = new User(1L, "Updated", "updated@gmail.com");
        Mockito.when(userService.updateUserById(Mockito.eq(1L), Mockito.any())).thenReturn(updated);

        mockMvc.perform(put("/updateUserById/1")
                .contentType("application/json")
                .content("""
                    { "name": "Updated", "email": "updated@gmail.com" }
                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated"));
    }

    @Test
    void patchUpdateUserByIdTest() throws Exception {
        User patched = new User(1L, "Patched", "surya@gmail.com");
        Mockito.when(userService.patchUpdateUserById(Mockito.eq(1L), Mockito.any())).thenReturn(patched);

        mockMvc.perform(patch("/patchUpdateUserById/1")
                .contentType("application/json")
                .content("{ \"name\": \"Patched\" }"))   
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Patched"));
    }


    @Test
    void getUsersByNameTest() throws Exception {
        List<User> users = List.of(new User(1L, "Surya", "surya@gmail.com"));
        Mockito.when(userService.getUsersByName("Surya")).thenReturn(users);

        mockMvc.perform(get("/getUsersByName/Surya"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Surya"));
    }
    
    
    
    
    
    
    
    
    
    
    
}

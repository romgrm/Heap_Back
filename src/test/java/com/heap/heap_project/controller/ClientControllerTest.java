package com.heap.heap_project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heap.heap_project.controllers.ClientController;
import com.heap.heap_project.models.Address;
import com.heap.heap_project.security.auth.ApplicationUserRole;
import com.heap.heap_project.models.Civility;
import com.heap.heap_project.models.Client;
import com.heap.heap_project.repositories.ClientRepository;
import com.heap.heap_project.security.auth.subscription.SubscriptionController;
import com.heap.heap_project.security.config.DisableApplicationSecurityConfig;
import com.heap.heap_project.services.ClientServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = {DisableApplicationSecurityConfig.class })
@Import(ClientController.class)
@Tag("controller_client")
@WebMvcTest(controllers = ClientController.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientServiceImpl clientService;

    @MockBean
    private ClientRepository clientRepository;

    // Service bean later

    @Test
    @DisplayName("Get all Clients")
    public void getAllClientsTest() throws Exception {
        mockMvc.perform(get("/client")).andExpect(status().isOk());
    }

    @DisplayName("Get client by id")
    @Test
    public void getClientByIdTest() throws Exception {
        //Given

        // Création de l'id
        int idClient = 1;

        // Création d'une address + client qu'on testera
        Address address = new Address("Nantes", 44000, "Quai Henri Barbusse", "11", "bis");
        Optional<Client> client = Optional.of(new Client("a.blache@gmail.com", "test","Blache", "Alexandre", Civility.Monsieur, ApplicationUserRole.ADMIN, address));
        // Setting de l'id créé dans le client pour le récupérer (on le fait pas en dur vu que l'id est AI)
        client.get().setId(idClient);
        when(clientService.findClientByIdServ(idClient)).thenReturn(client);

        //When
        // Appel de la request testée
        mockMvc.perform(get("/client/{id}", idClient))

                .andDo(print())// pour les test affiche le résultat dans le log


                //THen le statut de la réponse http est ok.
                .andExpect(status().isOk())

                //Then le type de contenu est json
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))

                //THEN existence d'une réponse
                .andExpect(jsonPath("$").exists())

                //THEN l'attribut 'id' a pour valeur 1
                .andExpect(jsonPath("$.id").value("1"))

                //THEN l'attribut 'lastName' a pour valeur 'Blache'
                .andExpect(jsonPath("$.lastName").value("Blache"))

                //THEN l'attribut 'firstName' a pour valeur "Alexandre"
                .andExpect(jsonPath("$.firstName").value("Alexandre"))

                //THEN l'attribut 'civility' a pour valeur "Monsieur"
                .andExpect(jsonPath("$.civility").value("Monsieur"))

                //THEN l'attribut 'ApplicationUserRole' a pour valeur "ADMIN"
                .andExpect(jsonPath("$.role").value("ADMIN"))

                //THEN l'attribut 'personAddress.city' a pour valeur "Nantes"
                .andExpect(jsonPath("$.personAddress.city").value("Nantes"))

                //THEN l'attribut 'personAddress.zipCode' a pour valeur "44000"
                .andExpect(jsonPath("$.personAddress.zipCode").value(44000))

                //THEN l'attribut 'personAddress.number' a pour valeur "bis Quai Henri Barbusse"
                .andExpect(jsonPath("$.personAddress.number").value(11))

                //THEN l'attribut 'personAddress.street' a pour valeur "bis Quai Henri Barbusse"
                .andExpect(jsonPath("$.personAddress.street").value("Quai Henri Barbusse"))

                //THEN l'attribut 'personAddress.addressComplement' a pour valeur "bis"
                .andExpect(jsonPath("$.personAddress.addressComplement").value("bis"))
        ;

    }

    @DisplayName("Add Client")
    @Test
    public void addAClientTest() throws Exception {
        // GIVEN

        Address address = new Address("Nantes", 44000, "Quai Henri Barbusse", "11", "bis");
        ObjectMapper mapper = new ObjectMapper();
        String clientNew = mapper.writeValueAsString(new Client("test@test.com", "test","Ladj", "Yann", Civility.Monsieur, ApplicationUserRole.ADMIN, address));

        Client clientOut = new Client("test@test.com","test","Blache", "Alexandre", Civility.Monsieur, ApplicationUserRole.ADMIN, address);
        clientOut.setId(1);
        when(clientService.addClientServ(ArgumentMatchers.isA(Client.class))).thenReturn(clientOut);

        //When
        mockMvc.perform(post("/client")
                .content(clientNew)
                .contentType(MediaType.APPLICATION_JSON)
        )
//                .andDo(print()) //pour les test affiche le résultat de la requete dans le log

                // THEN
                .andExpect(status().isOk())

                //Assert le type de contenu de réponse.
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))

                //THEN existence d'une réponse
                .andExpect(jsonPath("$").exists())

                //THEN l'attribut 'id' a pour valeur 1
                .andExpect(jsonPath("$.id").value("1"))

                //THEN l'attribut 'lastName' a pour valeur 'Blache'
                .andExpect(jsonPath("$.lastName").value("Blache"))

                //THEN l'attribut 'firstName' a pour valeur "Alexandre"
                .andExpect(jsonPath("$.firstName").value("Alexandre"))

                //THEN l'attribut 'civility' a pour valeur "Monsieur"
                .andExpect(jsonPath("$.civility").value("Monsieur"))

                //THEN l'attribut 'ApplicationUserRole' a pour valeur "ADMIN"
                .andExpect(jsonPath("$.role").value("ADMIN"))

                //THEN l'attribut 'personAddress.city' a pour valeur "Nantes"
                .andExpect(jsonPath("$.personAddress.city").value("Nantes"))

                //THEN l'attribut 'personAddress.zipCode' a pour valeur "44000"
                .andExpect(jsonPath("$.personAddress.zipCode").value(44000))

                //THEN l'attribut 'personAddress.number' a pour valeur "bis Quai Henri Barbusse"
                .andExpect(jsonPath("$.personAddress.number").value(11))

                //THEN l'attribut 'personAddress.street' a pour valeur "bis Quai Henri Barbusse"
                .andExpect(jsonPath("$.personAddress.street").value("Quai Henri Barbusse"))

                //THEN l'attribut 'personAddress.addressComplement' a pour valeur "bis"
                .andExpect(jsonPath("$.personAddress.addressComplement").value("bis"));
    }

    @DisplayName("Update a Client")
    @Test
    public void updateClientTest() throws Exception {
        //GIVEN
        int idClient = 1;
        Address address = new Address("Nantes", 44000, "Quai Henri Barbusse", "11", "bis");
        Client client = new Client("test@test.com","test","Blache", "Alexandre", Civility.Monsieur, ApplicationUserRole.ADMIN, address);
        client.setId(idClient);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(client);

        // RESOUDRE PRBLM TEST VOID //Todo
        /*//WHEN
        when(clientService.updateServ(isA(Integer.class), isA(Client.class))).thenReturn(void);*/

        //THEN
        mockMvc.perform(put("/client/{id}", idClient).content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                //THEN existence d'une réponse
                .andExpect(jsonPath("$").exists())

                //THEN l'attribut 'id' a pour valeur 1
                .andExpect(jsonPath("$.id").value("1"))

                //THEN l'attribut 'lastName' a pour valeur 'Blache'
                .andExpect(jsonPath("$.lastName").value("Blache"))

                //THEN l'attribut 'firstName' a pour valeur "Alexandre"
                .andExpect(jsonPath("$.firstName").value("Alexandre"))

                //THEN l'attribut 'civility' a pour valeur "Monsieur"
                .andExpect(jsonPath("$.civility").value("Monsieur"))

                //THEN l'attribut 'ApplicationUserRole' a pour valeur "ADMIN"
                .andExpect(jsonPath("$.role").value("ADMIN"))

                //THEN l'attribut 'personAddress.city' a pour valeur "Nantes"
                .andExpect(jsonPath("$.personAddress.city").value("Nantes"))

                //THEN l'attribut 'personAddress.zipCode' a pour valeur "44000"
                .andExpect(jsonPath("$.personAddress.zipCode").value(44000))

                //THEN l'attribut 'personAddress.number' a pour valeur "bis Quai Henri Barbusse"
                .andExpect(jsonPath("$.personAddress.number").value(11))

                //THEN l'attribut 'personAddress.street' a pour valeur "bis Quai Henri Barbusse"
                .andExpect(jsonPath("$.personAddress.street").value("bis Quai Henri Barbusse"))

                //THEN l'attribut 'personAddress.addressComplement' a pour valeur "bis"
                .andExpect(jsonPath("$.personAddress.addressComplement").value("bis"));
    }

        @DisplayName("Delete artist")
        @Test
        public void deleteArtistTest () throws Exception {

            //GIVEN
            int idClient = 1;
            Address address = new Address("Nantes", 44000, "Quai Henri Barbusse", "11", "bis");
            Optional<Client> client = Optional.of(new Client("test@test.com","test","Blache", "Alexandre", Civility.Monsieur, ApplicationUserRole.ADMIN, address));
            client.get().setId(idClient);
            when(clientRepository.findById(idClient)).thenReturn(client);
            doNothing().when(clientService).deleteClientServ(idClient);

            //WHEN
            mockMvc.perform(delete("/client/{id}", idClient).accept(MediaType.APPLICATION_JSON))

                    //THEN delete succesfull
                    .andExpect(status().is2xxSuccessful());
        }

    }

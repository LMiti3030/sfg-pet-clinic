package mititelu.laura.guru.springframework.sfgpetclinic.controllers;

import mititelu.laura.guru.springframework.sfgpetclinic.model.Owner;
import mititelu.laura.guru.springframework.sfgpetclinic.services.OwnerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnerController ownerController;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>(Set.of(
                Owner.builder().id(1L).lastName("Popescu").build(),
                Owner.builder().id(2l).lastName("Ionescu").build()
        ));

        //initializes mock environment for the controller
        mockMvc = MockMvcBuilders
                .standaloneSetup(ownerController)
                .build();
    }

    @Test
    void should_returnListOfOwners_When_ListOwners() throws Exception {

        //given
        String expectedView = "owners/index";

        when(ownerService.findAll()).thenReturn(owners);

        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
                //then
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("owners/index"))
                .andExpect(MockMvcResultMatchers.model().attribute("owners", Matchers.hasSize(2) ));

    }

    @Test
    void should_returnListOfOwners_When_ListOwnersByIndex() throws Exception {

        //given
        String expectedView = "owners/index";

        when(ownerService.findAll()).thenReturn(owners);

        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/index"))
                //then
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("owners/index"))
                .andExpect(MockMvcResultMatchers.model().attribute("owners", Matchers.hasSize(2) ));

    }

    @Test
    void should_Return404_WhenPageNotFound() throws Exception {

       mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().is(404));

    }


    @Test
    void findOwners() throws Exception{

        String expectedView = "notimplemented";

        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/find"))

        //then
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(expectedView));

        verifyNoInteractions(ownerService);
    }
}
package mititelu.laura.guru.springframework.sfgpetclinic.services.springdatajpa;

import mititelu.laura.guru.springframework.sfgpetclinic.model.Owner;
import mititelu.laura.guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import mititelu.laura.guru.springframework.sfgpetclinic.repositories.PetRepository;
import mititelu.laura.guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {


    }

    @Test
    void should_findAll_whenInputOk() {
        //given
        Owner owner1 = Owner.builder().id(1l).firstName("Adrian").lastName("Negrea").build();
        Owner owner2 = Owner.builder().id(2l).firstName("Dodo").lastName("Bravo").build();
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(owner1);
        ownerSet.add(owner2);
        when(ownerRepository.findAll()).thenReturn(ownerSet);
        int expectedSize = 2;

        //when
        Set<Owner> actualOwnerSet = service.findAll();
        int actualSize = ownerSet.size();

        //then
        assertNotNull(actualOwnerSet);
        assertEquals(expectedSize, actualSize);

        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void should_findById_WhenInputOK() {
        //given
        Long expectedId = 2L;
        Owner returnedOwner = Owner.builder().id(expectedId).build();
        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnedOwner));

        //when
        Owner actualOwner = service.findById(expectedId);
        Long actualId = actualOwner.getId();

        //then

        assertNotNull(actualOwner);
        assertEquals(expectedId, actualId);


    }

    @Test
    public void should_ReturnNull_WhenFindByIdNotFound(){
        //given
        Owner expectedOwner = null;
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());

        //when
        Owner actualOwner = service.findById(1l);

        //then
        assertNull(actualOwner);
    }

    @Test
    void save() {
        //given
        Owner ownerToSave = Owner.builder().id(1L).build();
        Owner returnedOwner = Owner.builder().id(1l).build();

        when(ownerRepository.save(any())).thenReturn(returnedOwner);

        //when
        Owner savedOwner = service.save(ownerToSave);

        //then
        assertNotNull(savedOwner);
        assertEquals(ownerToSave.getId(), savedOwner.getId());
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        //given
        Owner ownerToDelete = Owner.builder().id(1L).build();

        //when
        service.delete(ownerToDelete);

        //then
        verify(ownerRepository, times(1)).delete(any());

    }

    @Test
    void deleteById() {
        //given
        Long idToDelete = 1L;

        //when
        service.deleteById(idToDelete);

        //then
        verify(ownerRepository).deleteById(anyLong());


    }

    @Test
    void findByLastName() {

        //given
        Owner returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        //when
        Owner smith = service.findByLastName(LAST_NAME);

        //then
        assertEquals(LAST_NAME, smith.getLastName());

        verify(ownerRepository, times(1)).findByLastName(any());
    }
}
package mititelu.laura.guru.springframework.sfgpetclinic.services.map;

import mititelu.laura.guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;

    final Long ownerId = 1l;
    private final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        //using actual implems and not mocks
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(ownerId).lastName("Smith").build());
    }

    @Test
    void should_ReturnSet_WhenFindAll() {
        //given
        int expected = 1;

        //when
        Set<Owner> ownerSet= ownerMapService.findAll();
        int actual = ownerSet.size();

        //then
        assertEquals(expected, actual);

    }

    @Test
    void should_ReturnCorrectOwner_WhenFindById() {
        //given
        Owner expected = Owner.builder().id(ownerId).build();
        Long expecedId = ownerId;

        //when
        Owner actual = ownerMapService.findById(ownerId);
        Long actualId = actual.getId();

        //then
        assertEquals(expected, actual);
        assertEquals(expecedId, actualId);

    }

    @Test
    void should_SaveOwner_WhenIdProvided() {
        //given
        Long expectedId = 2L;
        Owner expected = Owner.builder().id(2L).build();

        //when
        Owner actual = ownerMapService.save(expected);
        Long actualId = actual.getId();

        //then
        assertEquals(expected, actual);
        assertEquals(expectedId, actualId);


    }

    @Test
    void should_SaveOwner_WhenIdNotProvided() {
        //given
        Owner expected = Owner.builder().build();

        //when
        Owner actual = ownerMapService.save(expected);

        //then
        assertNotNull(actual);
        assertNotNull(actual.getId());

    }

    @Test
    void delete() {
        //given
        Owner deletedOwner = ownerMapService.findById(ownerId);
        int expectedSize = 0;

        //when
        ownerMapService.delete(deletedOwner);
        Owner owner = ownerMapService.findById(ownerId);
        int actualSize = ownerMapService.findAll().size();

        //then
        assertAll(
                () -> assertNull(owner),
                () -> assertEquals(expectedSize, actualSize)
        );
    }


    @Test
    void should_Delete_whenDeleteById() {
        //given
        int expectedSize = 0;
        Owner deletedOwner = ownerMapService.findById(ownerId);

        //when
        ownerMapService.deleteById(ownerId);
        Owner owner = ownerMapService.findById(ownerId);
        int actualSize = ownerMapService.findAll().size();

        //then
        assertAll(
                () -> assertNull(owner),
                () -> assertEquals(expectedSize, actualSize)
        );

    }

    @Test
    void should_FindByLastName_WhenNameProvided() {
        //given

        //when
        Owner smith = ownerMapService.findByLastName(lastName);

        //then
        assertNotNull(smith);
        assertEquals(ownerId, smith.getId());
    }

    @Test
    void should_ReturnNul_WhenNameNotFound() {
        //given

        //when
        Owner owner = ownerMapService.findByLastName("popescu");

        //then
        assertNull(owner);
    }


}
package mititelu.laura.guru.springframework.sfgpetclinic.repositories;

import mititelu.laura.guru.springframework.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;


public interface PetRepository extends CrudRepository<Pet, Long> {
}

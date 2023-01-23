package mititelu.laura.guru.springframework.sfgpetclinic.repositories;

import mititelu.laura.guru.springframework.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}

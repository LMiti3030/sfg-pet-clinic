package mititelu.laura.guru.springframework.sfgpetclinic.repositories;

import mititelu.laura.guru.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;


public interface OwnerRepository extends CrudRepository<Owner, Long> {

    public Owner findByLastName(String lastName);
}

package mititelu.laura.guru.springframework.sfgpetclinic.services;

import mititelu.laura.guru.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

/**
 * @author LMiti3030
 * created on 02.12.2022
 */
public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}

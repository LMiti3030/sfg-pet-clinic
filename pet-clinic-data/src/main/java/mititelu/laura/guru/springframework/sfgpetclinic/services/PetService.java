package mititelu.laura.guru.springframework.sfgpetclinic.services;

import mititelu.laura.guru.springframework.sfgpetclinic.model.Owner;
import mititelu.laura.guru.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

/**
 * @author LMiti3030
 * created on 02.12.2022
 */
public interface PetService {

    Pet findById(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();
}

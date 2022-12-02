package mititelu.laura.guru.springframework.sfgpetclinic.services;

import mititelu.laura.guru.springframework.sfgpetclinic.model.Pet;
import mititelu.laura.guru.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

/**
 * @author LMiti3030
 * created on 02.12.2022
 */
public interface VetService {

    Vet findById(Long id);

    Vet save(Vet owner);

    Set<Vet> findAll();

}

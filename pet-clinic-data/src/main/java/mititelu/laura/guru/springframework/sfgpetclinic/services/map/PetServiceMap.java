package mititelu.laura.guru.springframework.sfgpetclinic.services.map;

import mititelu.laura.guru.springframework.sfgpetclinic.model.Pet;
import mititelu.laura.guru.springframework.sfgpetclinic.services.PetService;

import java.util.Set;

/**
 * @author LMiti3030
 * created on 02.12.2022
 */
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }
}

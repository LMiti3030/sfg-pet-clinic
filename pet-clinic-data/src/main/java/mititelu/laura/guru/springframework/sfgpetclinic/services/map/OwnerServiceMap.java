package mititelu.laura.guru.springframework.sfgpetclinic.services.map;

import mititelu.laura.guru.springframework.sfgpetclinic.model.Owner;
import mititelu.laura.guru.springframework.sfgpetclinic.model.Pet;
import mititelu.laura.guru.springframework.sfgpetclinic.services.OwnerService;
import mititelu.laura.guru.springframework.sfgpetclinic.services.PetService;
import mititelu.laura.guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author LMiti3030
 * created on 02.12.2022
 */
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Owner save(Owner owner) {
        if( owner != null){
            if(owner.getPets()!= null){
                owner.getPets().forEach( pet ->{
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                            //saving the new pet type in order to get an id
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required!");
                    }
                    if(pet.getId() == null){
                        //making sure I set an id on pet
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(owner);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}

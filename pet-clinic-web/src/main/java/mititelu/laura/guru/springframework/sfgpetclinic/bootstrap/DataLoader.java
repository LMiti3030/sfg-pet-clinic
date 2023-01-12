package mititelu.laura.guru.springframework.sfgpetclinic.bootstrap;

import mititelu.laura.guru.springframework.sfgpetclinic.model.Owner;
import mititelu.laura.guru.springframework.sfgpetclinic.model.PetType;
import mititelu.laura.guru.springframework.sfgpetclinic.model.Vet;
import mititelu.laura.guru.springframework.sfgpetclinic.services.OwnerService;
import mititelu.laura.guru.springframework.sfgpetclinic.services.PetTypeService;
import mititelu.laura.guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author LMiti3030
 * created on 21.12.2022
 */

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Laura");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("George");
        owner2.setLastName("Simpson");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Adrian");
        vet1.setLastName("Popescu");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Cristian");
        vet2.setLastName("Androne");

        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }
}

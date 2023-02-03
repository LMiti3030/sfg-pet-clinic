package mititelu.laura.guru.springframework.sfgpetclinic.bootstrap;

import mititelu.laura.guru.springframework.sfgpetclinic.model.*;
import mititelu.laura.guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author LMiti3030
 * created on 21.12.2022
 */

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    private final SpecialityService specialityService;

    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }



    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialityService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialityService.save(surgery);

        Owner owner1 = new Owner();
        owner1.setFirstName("Laura");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Vacaresti Street");
        owner1.setCity("Bucuresti");
        owner1.setTelephone("+40722012345");

        Pet  laurasPet= new Pet();
        laurasPet.setPetType(savedDogPetType);
        laurasPet.setOwner(owner1);
        laurasPet.setBirthDate(LocalDate.now());
        laurasPet.setName("Bruno");
        owner1.getPets().add(laurasPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("George");
        owner2.setLastName("Simpson");
        owner2.setAddress("456 Vadeni");
        owner2.setCity("Brasov");
        owner2.setTelephone("+40744012345");

        Pet  georgesPet= new Pet();
        georgesPet.setPetType(savedCatPetType);
        georgesPet.setOwner(owner2);
        georgesPet.setBirthDate(LocalDate.now());
        georgesPet.setName("Bianca");
        owner2.getPets().add(georgesPet);

        ownerService.save(owner2);

        //        using builder-
        Owner owner3 = Owner.builder().firstName("Andrei").lastName("Georgescu").city("Ploiesti").build();
        ownerService.save(owner3);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Adrian");
        vet1.setLastName("Popescu");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Cristian");
        vet2.setLastName("Androne");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets...");


        Visit visit = new Visit();
        visit.setPet(georgesPet);
        visit.setDate(LocalDate.of(2023,1,13));
        visit.setDescription("Less active");

        visitService.save(visit);

        Visit anotherVisit = new Visit();
        anotherVisit.setPet(laurasPet);
        anotherVisit.setDate(LocalDate.of(2023,1,24));
        anotherVisit.setDescription("Pregnant");

        visitService.save(anotherVisit);

        System.out.println("Loaded visits...");



    }
}

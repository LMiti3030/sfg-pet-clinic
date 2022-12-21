package mititelu.laura.guru.springframework.sfgpetclinic.bootstrap;

import mititelu.laura.guru.springframework.sfgpetclinic.model.Owner;
import mititelu.laura.guru.springframework.sfgpetclinic.model.Vet;
import mititelu.laura.guru.springframework.sfgpetclinic.services.OwnerService;
import mititelu.laura.guru.springframework.sfgpetclinic.services.VetService;
import mititelu.laura.guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import mititelu.laura.guru.springframework.sfgpetclinic.services.map.VetServiceMap;
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

    public DataLoader(){
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Laura");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("George");
        owner2.setLastName("Simpson");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Adrian");
        vet1.setLastName("Popescu");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Cristian");
        vet2.setLastName("Androne");

        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }
}

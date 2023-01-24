package mititelu.laura.guru.springframework.sfgpetclinic.services.map;

import mititelu.laura.guru.springframework.sfgpetclinic.model.Specialty;
import mititelu.laura.guru.springframework.sfgpetclinic.model.Vet;
import mititelu.laura.guru.springframework.sfgpetclinic.services.SpecialityService;
import mititelu.laura.guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author LMiti3030
 * created on 02.12.2022
 */
@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }


    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Vet save(Vet vet) {
        if(vet != null){
            if(vet.getSpecialties().size() > 0){
                vet.getSpecialties().forEach( specialty -> {
                    if(specialty.getId() == null){
                       Specialty savedSpecialty = specialityService.save(specialty);
                       specialty.setId(savedSpecialty.getId());
                    }
                });
            } else {
                throw new RuntimeException("Vet speciality is required");
            }
            return super.save(vet);
        } else {
            return null;
        }


    }
}

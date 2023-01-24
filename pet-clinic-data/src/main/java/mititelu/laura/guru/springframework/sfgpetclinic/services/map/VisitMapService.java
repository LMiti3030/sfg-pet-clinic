package mititelu.laura.guru.springframework.sfgpetclinic.services.map;

import mititelu.laura.guru.springframework.sfgpetclinic.model.Visit;
import mititelu.laura.guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {


    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit!=null){
            if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null
                    || visit.getPet().getOwner().getId() == null){
                throw  new RuntimeException("Invalid visit");
            }
            else {
                return super.save(visit);
            }
        } else{
            return null;
        }
    }

    @Override
    public Visit findById(Long id) {
        return super.findByID(id);
    }
}

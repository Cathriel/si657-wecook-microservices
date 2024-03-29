package pe.edu.upc.service.impls;

import pe.edu.upc.client.ProfileClient;
import pe.edu.upc.entity.Cookbook;
import pe.edu.upc.exception.ResourceNotFoundException;
import pe.edu.upc.model.Profile;
import pe.edu.upc.repository.CookbookRepository;
import pe.edu.upc.service.CookbookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CookbookServiceImpl implements CookbookService {

    @Autowired
    private CookbookRepository cookbookRepository;

    @Qualifier("pe.edu.upc.client.ProfileClient")
    @Autowired
    ProfileClient profileClient;

    @Override
    public Cookbook createCookbook(Cookbook cookbook) {
        return cookbookRepository.save(cookbook);
    }

    @Override
    public Cookbook getCookbookByName(String name) {
        return cookbookRepository.findCookbookByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Cookbook", "Name", name));
    }

    @Override
    public List<Cookbook> getAllCookbooksByProfileId(Long profileId) {
        return cookbookRepository.findCookbookByProfileId(profileId).orElse(null);
    }

    @Override
    public List<Cookbook> findAll() throws Exception {
        return cookbookRepository.findAll();
    }

    @Override
    public Cookbook findById(Long aLong) throws Exception {

        Cookbook cookbook=cookbookRepository.findById(aLong).orElse(null);
        if(cookbook!=null){
            Profile profile = profileClient.getProfile(cookbook.getProfileId()).getBody();
            cookbook.setProfile(profile);
        }
        return cookbook;
    }

    @Override
    public Cookbook update(Cookbook entity, Long aLong) throws Exception {
        Cookbook cookbook = cookbookRepository.findById(aLong)
                .orElseThrow(() -> new ResourceNotFoundException("Cookbook", "Id", aLong));
        cookbook.setName(entity.getName())
                .setProfileId(entity.getProfileId());
        return cookbookRepository.save(cookbook);
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        Cookbook cookbook = cookbookRepository.findById(aLong)
                .orElseThrow(() -> new ResourceNotFoundException("Cookbook", "Id", aLong));
        cookbookRepository.deleteById(aLong);
    }
}

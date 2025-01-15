package pt.iade.IADESocial.controllers;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pt.iade.IADESocial.models.Profiles;
import pt.iade.IADESocial.models.repositories.ProfilesRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/profiles")
public class ProfilesController {

    private final Logger logger = LoggerFactory.getLogger(ProfilesController.class);

    @Autowired
    private ProfilesRepository profilesRepository;

    // Listar todos os perfis
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Profiles> getProfiles() {
        logger.info("Retrieving all profiles");
        return profilesRepository.findAll();
    }

    // Obter um perfil específico por ID
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Profiles> getProfile(@PathVariable int id) {
        logger.info("Retrieving profile with ID {}", id);
        return profilesRepository.findById(id);
    }

    // Criar um novo perfil
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Profiles createProfile(@Valid @RequestBody Profiles newProfile) {
        logger.info("Creating a new profile for User ID {}", newProfile.getUserId());
        return profilesRepository.save(newProfile);
    }

    // Atualizar um perfil existente
    @PutMapping(path = "/{id}/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Profiles updateProfile(@PathVariable int id, @Valid @RequestBody Profiles updatedProfile) {
        logger.info("Updating profile with ID {}", id);

        return profilesRepository.findById(id)
                .map(profile -> {
                    profile.setName(updatedProfile.getName());
                    profile.setBio(updatedProfile.getBio());
                    profile.setProfilePicture(updatedProfile.getProfilePicture());
                    return profilesRepository.save(profile);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found"));
    }

    // Deletar um perfil
    @DeleteMapping(path = "/{id}/delete")
    public void deleteProfile(@PathVariable int id) {
        logger.info("Deleting profile with ID {}", id);
        if (profilesRepository.existsById(id)) {
            profilesRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found");
        }
    }
    // Obter um perfil por UserID
    @GetMapping(path = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Profiles> getProfileByUserId(@PathVariable int userId) {
        logger.info("Retrieving profile for User ID {}", userId);
        return Optional.ofNullable(profilesRepository.findByUserId(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found for User ID " + userId)));
    }

}


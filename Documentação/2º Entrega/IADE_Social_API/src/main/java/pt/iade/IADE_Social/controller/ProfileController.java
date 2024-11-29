package pt.iade.IADE_Social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.IADE_Social.model.Profile;
import pt.iade.IADE_Social.service.ProfileService;

@RestController 
@RequestMapping("/api/profiles")
public class ProfileController {
    @Autowired 
    private ProfileService profileService; 
    
    @GetMapping 
    public List<Profile> getAllProfiles() { return profileService.getAllProfiles(); }

    @GetMapping("{id}") 
    public ResponseEntity<Profile> getProfileById(@PathVariable Integer id) { 
        return new ResponseEntity<>(profileService.getProfileById(id), HttpStatus.OK); 
    }

    @PostMapping 
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) { 
        return new ResponseEntity<>(profileService.createProfile(profile), HttpStatus.CREATED); 
    }

    @PutMapping("{id}") 
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile, @PathVariable Integer id) { 
        Profile updatedProfile = profileService.updateProfile(id,profile); 
        if (updatedProfile != null) { return new ResponseEntity<>(updatedProfile, HttpStatus.OK); } 
        else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); } 
    }

    @DeleteMapping("{id}") 
    public ResponseEntity<Void> deleteProfileById(@PathVariable("id") Integer id) { 
        profileService.deleteProfileById(id); 
        return new ResponseEntity<>(HttpStatus.OK); 
    }
}

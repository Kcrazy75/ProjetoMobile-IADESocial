package pt.iade.IADE_Social.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.iade.IADE_Social.model.Profile;
import pt.iade.IADE_Social.repository.ProfileRepository;
import pt.iade.IADE_Social.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{
    @Autowired 
    private ProfileRepository pRep; 
    
    @Override 
    public List<Profile> getAllProfiles() { return pRep.findAll(); } 
    
    @Override 
    public Profile getProfileById(Integer id) { 
        Optional<Profile> profile =  pRep.findById(id);
        
        if(profile.isPresent()){ return profile.get(); }  //profile.get();
        else { throw new RuntimeException("Profile not found with id " + id); } 
    } 
    
    @Override 
    public Profile createProfile(Profile profile) { return pRep.save(profile); } 
    
    @Override 
    public Profile updateProfile(Integer profileId, Profile profile) { 
        Optional<Profile> existingProfile = pRep.findById(profileId); 
        
        if (existingProfile.isPresent()) {
            Profile updatedProfile = existingProfile.get();
            updatedProfile.setName(profile.getName());
            updatedProfile.setBio(profile.getBio());
            updatedProfile.setProfilePicture(profile.getProfilePicture());
            
            return pRep.save(updatedProfile); 
        } else { return null; } 
    } 
    
    @Override 
    public void deleteProfileById(Integer id) { 
        //check
        pRep.findById(id).orElseThrow( () -> new RuntimeException("Profile not found with id " + id) );
        //delete
        pRep.deleteById(id); 
    }
}

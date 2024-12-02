package pt.iade.IADE_Social.service;

import java.util.List;

import pt.iade.IADE_Social.model.Profile;

public interface ProfileService {
    List<Profile> getAllProfiles(); 
    Profile getProfileById(Integer profileId); 
    Profile createProfile(Profile profile); 
    Profile updateProfile(Integer profileId, Profile profile); 
    void deleteProfileById(Integer profileId);
}

-- Create Schema
CREATE SCHEMA iade_social;

-- Use Schema
USE iade_social;

-- Users Table
CREATE TABLE Users (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    StudentID INT NOT NULL
);

-- Profiles Table
CREATE TABLE Profiles (
    ProfileID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT NOT NULL,
    Name VARCHAR(255),
    Bio TEXT,
    ProfilePicture VARCHAR(255),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

-- Posts Table
CREATE TABLE Posts (
    PostID INT PRIMARY KEY AUTO_INCREMENT,
    ProfileID INT NOT NULL,
    Content TEXT NOT NULL,
    FOREIGN KEY (ProfileID) REFERENCES Profiles(ProfileID)
);

-- Comments Table
CREATE TABLE Comments (
    CommentID INT PRIMARY KEY AUTO_INCREMENT,
    PostID INT NOT NULL,
    ProfileID INT NOT NULL,
    Content TEXT NOT NULL,
    FOREIGN KEY (PostID) REFERENCES Posts(PostID),
    FOREIGN KEY (ProfileID) REFERENCES Profiles(ProfileID)
);

-- Likes Table
CREATE TABLE Likes (
    LikeID INT PRIMARY KEY AUTO_INCREMENT,
    PostID INT NOT NULL,
    ProfileID INT NOT NULL,
    FOREIGN KEY (PostID) REFERENCES Posts(PostID),
    FOREIGN KEY (ProfileID) REFERENCES Profiles(ProfileID)
);

-- Followers Table
CREATE TABLE Followers (
    FollowerID INT PRIMARY KEY AUTO_INCREMENT,
    ProfileID INT NOT NULL,
    FollowerProfileID INT NOT NULL,
    FOREIGN KEY (ProfileID) REFERENCES Profiles(ProfileID),
    FOREIGN KEY (FollowerProfileID) REFERENCES Profiles(ProfileID)
);

-- Create Table to join Users and Profiles
CREATE VIEW UserProfiles AS
SELECT 
    u.UserID,
    u.Username,
    u.Email,
    u.Password,
    u.StudentID,
    p.ProfileID,
    p.Name AS ProfileName,
    p.Bio,
    p.ProfilePicture
FROM 
    Users u
JOIN 
    Profiles p ON u.UserID = p.UserID;

-- Create Table to join Profiles and Posts
CREATE VIEW ProfilePosts AS
SELECT 
    p.ProfileID,
    p.Name AS ProfileName,
    p.Bio,
    p.ProfilePicture,
    po.PostID,
    po.Content AS PostContent
FROM 
    Profiles p
JOIN 
    Posts po ON p.ProfileID = po.ProfileID;

-- Create Table to join Posts and Comments
CREATE VIEW PostComments AS
SELECT 
    po.PostID,
    po.Content AS PostContent,
    c.CommentID,
    c.Content AS CommentContent,
    c.ProfileID,
    p.Name AS CommenterName,
    p.ProfilePicture AS CommenterProfilePicture
FROM 
    Posts po
JOIN 
    Comments c ON po.PostID = c.PostID
JOIN 
    Profiles p ON c.ProfileID = p.ProfileID;

-- Create Table to join Posts and Likes
CREATE VIEW PostLikes AS
SELECT 
    po.PostID,
    po.Content AS PostContent,
    l.LikeID,
    l.ProfileID,
    p.Name AS LikerName,
    p.ProfilePicture AS LikerProfilePicture
FROM 
    Posts po
JOIN 
    Likes l ON po.PostID = l.PostID
JOIN 
    Profiles p ON l.ProfileID = p.ProfileID;

-- Create Table to join Profiles and Followers
CREATE VIEW ProfileFollowers AS
SELECT 
    f.ProfileID,
    p.Name AS ProfileName,
    f.FollowerProfileID,
    fp.Name AS FollowerName,
    fp.ProfilePicture AS FollowerProfilePicture
FROM 
    Followers f
JOIN 
    Profiles p ON f.ProfileID = p.ProfileID
JOIN 
    Profiles fp ON f.FollowerProfileID = fp.ProfileID;
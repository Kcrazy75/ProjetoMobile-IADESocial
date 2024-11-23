-- Create Schema
CREATE SCHEMA IADE_Social;

-- Use Schema
USE IADE_Social;

-- Users Table
CREATE TABLE Users (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Name VARCHAR(255) NOT NULL,
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
    UserID INT NOT NULL,
    Content TEXT NOT NULL,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

-- Comments Table
CREATE TABLE Comments (
    CommentID INT PRIMARY KEY AUTO_INCREMENT,
    PostID INT NOT NULL,
    UserID INT NOT NULL,
    Content TEXT NOT NULL,
    FOREIGN KEY (PostID) REFERENCES Posts(PostID),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

-- Likes Table
CREATE TABLE Likes (
    LikeID INT PRIMARY KEY AUTO_INCREMENT,
    PostID INT NOT NULL,
    UserID INT NOT NULL,
    FOREIGN KEY (PostID) REFERENCES Posts(PostID),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

-- Followers Table
CREATE TABLE Followers (
    FollowerID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT NOT NULL,
    FollowerUserID INT NOT NULL,
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (FollowerUserID) REFERENCES Users(UserID)
);
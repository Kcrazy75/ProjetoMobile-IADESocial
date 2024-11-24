-- Create Users Table
CREATE TABLE Users (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Name VARCHAR(255) NOT NULL,
    StudentID INT NOT NULL
);

-- Create Profiles Table
CREATE TABLE Profiles (
    ProfileID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT NOT NULL,
    Name VARCHAR(255),
    Bio TEXT,
    ProfilePicture VARCHAR(255),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

-- Create Posts Table
CREATE TABLE Posts (
    PostID INT PRIMARY KEY AUTO_INCREMENT,
    ProfileID INT NOT NULL,
    Content TEXT NOT NULL,
    FOREIGN KEY (ProfileID) REFERENCES Profiles(ProfileID)
);

-- Create Comments Table
CREATE TABLE Comments (
    CommentID INT PRIMARY KEY AUTO_INCREMENT,
    PostID INT NOT NULL,
    ProfileID INT NOT NULL,
    Content TEXT NOT NULL,
    FOREIGN KEY (PostID) REFERENCES Posts(PostID),
    FOREIGN KEY (ProfileID) REFERENCES Profiles(ProfileID)
);

-- Create Likes Table
CREATE TABLE Likes (
    LikeID INT PRIMARY KEY AUTO_INCREMENT,
    ProfileID INT NOT NULL,
    PostID INT,
    CommentID INT,
    FOREIGN KEY (ProfileID) REFERENCES Profiles(ProfileID),
    FOREIGN KEY (PostID) REFERENCES Posts(PostID),
    FOREIGN KEY (CommentID) REFERENCES Comments(CommentID)
);

-- Create Followers Table
CREATE TABLE Followers (
    FollowerID INT PRIMARY KEY AUTO_INCREMENT,
    ProfileID INT NOT NULL,
    FollowerProfileID INT NOT NULL,
    FOREIGN KEY (ProfileID) REFERENCES Profiles(ProfileID),
    FOREIGN KEY (FollowerProfileID) REFERENCES Profiles(ProfileID)
);
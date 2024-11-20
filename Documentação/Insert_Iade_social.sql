-- Use the schema
USE IADE_Social;

-- Inserting into Users
INSERT INTO Users (Username, Email, Password, Name, StudentID) VALUES
('alice', 'alice@example.com', 'password123', 'Alice Wonderland', 1),
('bob', 'bob@example.com', 'password456', 'Bob Builder', 2);

-- Inserting into Profiles
INSERT INTO Profiles (UserID, Name, Bio, ProfilePicture) VALUES
(1, 'Alice Wonderland', 'I love exploring!', '/images/alice.jpg'),
(2, 'Bob Builder', 'Building dreams.', '/images/bob.jpg');

-- Inserting into Posts
INSERT INTO Posts (UserID, Content) VALUES
(1, 'Just started reading a new book!'),
(2, 'Working on a new project!');

-- Inserting into Comments
INSERT INTO Comments (PostID, UserID, Content) VALUES
(1, 2, 'Sounds interesting!'),
(2, 1, 'Good luck with that!');

-- Inserting into Likes
INSERT INTO Likes (PostID, UserID) VALUES
(1, 2),
(2, 1);

-- Inserting into Followers
INSERT INTO Followers (UserID, FollowerUserID) VALUES
(1, 2),
(2, 1);
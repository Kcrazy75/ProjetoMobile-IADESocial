-- Use the schema
USE IADE_Social;

-- Inserting into Users
INSERT INTO Users (Username, Email, Password, Name, StudentID) VALUES
('alice', 'alice@example.com', 'password123', 'Alice Wonderland', 1),
('bob', 'bob@example.com', 'password456', 'Bob Builder', 2),
('joao', 'joao@example.com', 'password789', 'João Neves', 3),
('maria', 'maria@example.com', 'password101', 'Maria Eduarda', 4),
('bianca', 'bianca@example.com', 'password202', 'Bianca Alexandra', 5),
('bruno', 'bruno@example.com', 'password303', 'Bruno Mendes', 6);

-- Inserting into Profiles
INSERT INTO Profiles (UserID, Name, Bio, ProfilePicture) VALUES
(1, 'Alice Wonderland', 'I love exploring!', '/images/alice.jpg'),
(2, 'Bob Builder', 'Building dreams.', '/images/bob.jpg'),
(3, 'João Neves', 'Passionate about technology and innovation.', '/images/joao.jpg'),
(4, 'Maria Eduarda', 'Lover of books and nature.', '/images/maria.jpg'),
(5, 'Bianca Alexandra', 'Music is my life!', '/images/bianca.jpg'),
(6, 'Bruno Mendes', 'Fitness enthusiast and entrepreneur.', '/images/bruno.jpg');

-- Inserting into Posts
INSERT INTO Posts (UserID, Content) VALUES
(1, 'Just started reading a new book!'),
(2, 'Working on a new project!'),
(3, 'Learning something new every day!'),
(4, 'Can’t wait for the weekend!'),
(5, 'New album release is out now!'),
(6, 'Starting my fitness journey!');

-- Inserting into Comments
INSERT INTO Comments (PostID, UserID, Content) VALUES
(1, 2, 'Sounds interesting!'),
(2, 1, 'Good luck with that!'),
(3, 4, 'Keep it up!'),
(4, 3, 'Enjoy your weekend!'),
(5, 6, 'Love your music!'),
(6, 5, 'Good luck with your fitness goals!');

-- Inserting into Likes
INSERT INTO Likes (PostID, UserID) VALUES
(1, 2),
(2, 1),
(3, 4),
(4, 3),
(5, 6),
(6, 5);

-- Inserting into Followers
INSERT INTO Followers (UserID, FollowerUserID) VALUES
(1, 2),
(2, 1),
(3, 4),
(4, 3),
(5, 6),
(6, 5),
(1, 3),
(2, 4),
(3, 5),
(4, 6),
(5, 1),
(6, 2);

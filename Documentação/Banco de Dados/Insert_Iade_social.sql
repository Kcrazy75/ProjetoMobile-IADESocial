-- Insert Users
INSERT INTO Users (Username, Email, Password, Name, StudentID) VALUES
('alice', 'alice@example.com', 'Password', 'Alice Wonderland', 20220001),
('bob', 'bob@example.com', 'Password', 'Bob Builder', 20220002),
('carol', 'carol@example.com', 'Password', 'Carol Smith', 20220003),
('dave', 'dave@example.com', 'Password', 'Dave Johnson', 20220004),
('eve', 'eve@example.com', 'Password', 'Eve Williams', 20220005),
('frank', 'frank@example.com', 'Password', 'Frank Miller', 20220006),
('grace', 'grace@example.com', 'Password', 'Grace Hopper', 20220007),
('heidi', 'heidi@example.com', 'Password', 'Heidi Klum', 20220008);

-- Insert Profiles
INSERT INTO Profiles (UserID, Name, Bio, ProfilePicture) VALUES
(1, 'Alice Wonderland', 'Exploring the world of AI.', '/images/alice.jpg'),
(2, 'Bob Builder', 'Building the future, one block at a time.', '/images/bob.jpg'),
(3, 'Carol Smith', 'Technology enthusiast and avid reader.', '/images/carol.jpg'),
(4, 'Dave Johnson', 'Passionate about coding and music.', '/images/dave.jpg'),
(5, 'Eve Williams', 'Traveler, foodie, and adventure seeker.', '/images/eve.jpg'),
(6, 'Frank Miller', 'Comic book artist and storyteller.', '/images/frank.jpg'),
(7, 'Grace Hopper', 'Pioneer in computer programming.', '/images/grace.jpg'),
(8, 'Heidi Klum', 'Fashion icon and TV host.', '/images/heidi.jpg');

-- Insert Posts
INSERT INTO Posts (ProfileID, Content) VALUES
(1, 'Just started a new AI project!'),
(2, 'Completed a new building design.'),
(3, 'Reading a fascinating book on technology.'),
(4, 'Jamming to some new tunes while coding.'),
(5, 'Exploring new places and trying new foods.'),
(6, 'Sketching some new comic book characters.'),
(7, 'Solving complex programming problems.'),
(8, 'Hosting a fashion show this weekend.');

-- Insert Comments
INSERT INTO Comments (PostID, ProfileID, Content) VALUES
(1, 2, 'That sounds exciting! Good luck!'),
(2, 3, 'Can’t wait to see it!'),
(3, 4, 'What book are you reading?'),
(4, 5, 'Music and coding, perfect combination!'),
(5, 6, 'Where are you traveling to next?'),
(6, 7, 'Looking forward to your new comic book!'),
(7, 8, 'Amazing work on the programming front!'),
(8, 1, 'Can’t wait to see the fashion show!');

-- Insert Likes
INSERT INTO Likes (ProfileID, PostID, CommentID) VALUES
(1, 2, NULL),
(2, 1, NULL),
(3, 3, NULL),
(4, 4, NULL),
(5, 5, NULL),
(6, 6, NULL),
(7, 7, NULL),
(8, 8, NULL),
(1, NULL, 1),
(2, NULL, 2),
(3, NULL, 3),
(4, NULL, 4),
(5, NULL, 5),
(6, NULL, 6),
(7, NULL, 7),
(8, NULL, 8);

-- Insert Followers
INSERT INTO Followers (ProfileID, FollowerProfileID) VALUES
(1, 2),
(2, 1),
(3, 4),
(4, 3),
(5, 6),
(6, 5),
(7, 8),
(8, 7),
(1, 5),
(5, 1),
(2, 6),
(6, 2),
(3, 7),
(7, 3),
(4, 8),
(8, 4);
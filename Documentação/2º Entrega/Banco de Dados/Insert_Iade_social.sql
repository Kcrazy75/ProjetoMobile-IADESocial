-- Insert Users
INSERT INTO Users (Username, Email, Password, StudentID) VALUES
('alice', 'alice@example.com', 'Password', 20220001),
('bob', 'bob@example.com', 'Password', 20220002),
('carol', 'carol@example.com', 'Password', 20220003),
('dave', 'dave@example.com', 'Password', 20220004),
('eve', 'eve@example.com', 'Password', 20220005),
('frank', 'frank@example.com', 'Password', 20220006),
('grace', 'grace@example.com', 'Password', 20220007),
('heidi', 'heidi@example.com', 'Password', 20220008);

-- Insert Profiles
INSERT INTO Profiles (Name, Bio, ProfilePicture) VALUES
('Alice Wonderland', 'Exploring the world of AI.', '/images/alice.jpg'),
('Bob Builder', 'Building the future, one block at a time.', '/images/bob.jpg'),
('Carol Smith', 'Technology enthusiast and avid reader.', '/images/carol.jpg'),
('Dave Johnson', 'Passionate about coding and music.', '/images/dave.jpg'),
('Eve Williams', 'Traveler, foodie, and adventure seeker.', '/images/eve.jpg'),
('Frank Miller', 'Comic book artist and storyteller.', '/images/frank.jpg'),
('Grace Hopper', 'Pioneer in computer programming.', '/images/grace.jpg'),
('Heidi Klum', 'Fashion icon and TV host.', '/images/heidi.jpg');

-- Insert Posts
INSERT INTO Posts (ProfileID, Picture, Content) VALUES
(1, '/images/alice/post1.jpg','Just started a new AI project!'),
(2, '/images/bob/post1.jpg','Completed a new building design.'),
(3, '/images/carol/post1.jpg','Reading a fascinating book on technology.'),
(4, '/images/dave/post1.jpg','Jamming to some new tunes while coding.'),
(5, '/images/eve/post1.jpg','Exploring new places and trying new foods.'),
(6, '/images/frank/post1.jpg','Sketching some new comic book characters.'),
(7, '/images/grace/post1.jpg','Solving complex programming problems.'),
(8, '/images/heide/post1.jpg','Hosting a fashion show this weekend.');

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
INSERT INTO Likes (PostID, ProfileID) VALUES
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 6),
(6, 7),
(7, 8),
(8, 1);

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
-- Listar utilizadores e respetivos perfis
SELECT U.UserID,U.Username, U.studentID, U.Email, P.Name AS ProfileName, P.Bio, P.ProfilePicture
FROM Users U
LEFT JOIN Profiles P ON U.UserID = P.UserID;

-- Contar o número total de posts por utilizador
SELECT U.Username, COUNT(P.PostID) AS Posts
FROM Users U
LEFT JOIN Posts P ON U.UserID = P.profileID
GROUP BY U.Username
ORDER BY Posts DESC;

-- Mostrar os likes de cada post com os utilizadores que os deram
SELECT L.LikeID, U.Username AS LikedBy, P.Content AS Content
FROM Likes L
INNER JOIN Users U ON L.profileID = U.UserID
INNER JOIN Posts P ON L.PostID = P.PostID
ORDER BY P.PostID;

-- Identificar utilizadores com mais seguidores
SELECT U.Username AS User, COUNT(F.FollowerprofileID) AS Followers 
FROM Users U
LEFT JOIN Followers F ON U.UserID = F.profileID
GROUP BY U.UserID, U.Username
ORDER BY Followers DESC;

-- Listar utilizadores que se seguem mutuamente
SELECT U1.Username AS Follower, U2.Username AS Followed
FROM Followers F1
INNER JOIN Followers F2 ON F1.profileID = F2.FollowerprofileID AND F1.FollowerprofileID = F2.profileID
INNER JOIN Users U1 ON F1.FollowerprofileID = U1.UserID
INNER JOIN Users U2 ON F1.profileID = U2.UserID
ORDER BY Follower, Followed;

-- Listar utilizadores e respetivos perfis
SELECT U.UserID, U.Username, U.Email, P.Name AS ProfileName, P.Bio, P.ProfilePicture
FROM Users U
LEFT JOIN Profiles P ON U.UserID = P.UserID;

-- Contar o número total de posts por utilizador
SELECT U.Username, COUNT(P.PostID) AS TotalPosts
FROM Users U
LEFT JOIN Posts P ON U.UserID = P.UserID
GROUP BY U.Username
ORDER BY TotalPosts DESC;

-- Mostrar os likes de cada post com os utilizadores que os deram
SELECT L.LikeID, U.Username AS LikedBy, P.Content AS PostContent
FROM Likes L
INNER JOIN Users U ON L.UserID = U.UserID
INNER JOIN Posts P ON L.PostID = P.PostID
ORDER BY P.PostID;

-- Identificar utilizadores com mais seguidores
SELECT U.Username AS User, COUNT(F.FollowerUserID) AS TotalFollowers
FROM Users U
LEFT JOIN Followers F ON U.UserID = F.UserID
GROUP BY U.UserID, U.Username
ORDER BY TotalFollowers DESC;

-- Listar utilizadores que se seguem mutuamente
SELECT U1.Username AS Follower, U2.Username AS Followed
FROM Followers F1
INNER JOIN Followers F2 ON F1.UserID = F2.FollowerUserID AND F1.FollowerUserID = F2.UserID
INNER JOIN Users U1 ON F1.FollowerUserID = U1.UserID
INNER JOIN Users U2 ON F1.UserID = U2.UserID
ORDER BY Follower, Followed;

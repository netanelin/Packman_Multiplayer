# Packman_Multiplayer

**Welcome to the Packman_Multiplayer wiki!**

**By Eitan Lichtman & Netanel Indik**

This project is a packman game with 9 different senerios and multiple components: the player, fruits, packmans, ghosts, black boxes. The game includes an option to play manualy using the mouse or to run the senerio automaticly using the algorithm that's programed in to the system. The game ends once the fruits are all eaten or when the time is up, whatever comes first. Every time a game is played the score is uploaded to a database on the internet. The goal is to recieve as many points as possible and get a high rank compared to other players!


***

**Game Components:**

> Player

Our Player is the only component that's controlled either by the person playing manualy or by running the algorithm, the rest of the components that move (Packmans and Ghosts) are controlled by a server.
The goal of the player is to eat all of the fruit as fast as possible without running in to black boxes or ghosts and earn as many points as possible. In addition to fruits the player can also eat packmans. The player moves faster than Packmans and Ghosts.

![](https://github.com/netanelin/Packman_Multiplayer/blob/master/Images%20for%20wiki/player.png)


> GameBoard Map

The GameBoard backgroung is a map of Ariel university in Samaria Israel, which is the university that we are currently studying in and where this project was given to us as a task.

The player cannot leave the borders of the map, if it tries to leave 1 point is reduced for every attempt.

![](https://github.com/netanelin/Packman_Multiplayer/blob/master/Images%20for%20wiki/ArielMap.png)


> Black Boxes

The black boxes are also static like the fruit and do not move.

The player cannot walk in to boxes, if it tries to touch a box 1 point is reduced for every attempt.

![](https://github.com/netanelin/Packman_Multiplayer/blob/master/Images%20for%20wiki/black%20boxes.png)


> Packman

A packman is Programmed to move towards the closest fruit at all times and when arrived to eat the fruit. A packman is slower than the player. Packmans can also be eaten by the Player.

When the packman eats a fruit no points are added but it helps the game end faster. When the player eats a packman 1 point is added.

![](https://github.com/netanelin/Packman_Multiplayer/blob/master/Images%20for%20wiki/packman.png)


> Ghost

A ghost is Programmed to move towards the player at all times, but it's slower than the player.

Every time a ghost touches the player 20 points are reduced.

![](https://github.com/netanelin/Packman_Multiplayer/blob/master/Images%20for%20wiki/ghost.png)


> Fruits

The fruits are what give us points if eaten by the player and help us end the game faster, they can also be eaten by packmans. A fruit has a static location and disapears when eaten.

Every fruit eaten by the player adds 1 point, and if all of the fruit are eaten before the time runs out the game ends and more points are added according to the amount of time left.

![](https://github.com/netanelin/Packman_Multiplayer/blob/master/Images%20for%20wiki/fruits.png)


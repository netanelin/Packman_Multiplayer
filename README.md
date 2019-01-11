# Packman_Multiplayer


**By Eitan Lichtman & Netanel Indik**

This project is a packman game with 9 different senerios and multiple components: the player, fruits, packmans, ghosts, black boxes. The game includes an option to play manualy using the mouse or to run the senerio automaticly using the algorithm that's programed in to the system. The game ends once the fruits are all eaten or when the time is up, whatever comes first. Every time a game is played the score is uploaded to a database on the internet. The goal is to recieve as many points as possible and get a high rank compared to other players!


***

**GAME COMPONENTS**

> Player

Our Player is the only component that's controlled either by the person playing manualy or by running the algorithm, the rest of the components that move (Packmans and Ghosts) are controlled by a server.
The goal of the player is to eat all of the fruit as fast as possible without running in to black boxes or ghosts and earn as many points as possible. In addition to fruits the player can also eat packmans. The player moves faster than Packmans and Ghosts.

![](https://github.com/netanelin/Packman_Multiplayer/blob/master/Images%20for%20wiki/player.png)


> GameBoard Map

The GameBoard backgroung is a map of Ariel university in Samaria Israel, which is the university that we are currently studying in and where this project was given to us as a task. The locations are translated from lat lon coordinates to image pixels.

The player cannot leave the borders of the map, if it tries to leave 1 point is reduced for every attempt.

![](https://github.com/netanelin/Packman_Multiplayer/blob/master/Images%20for%20wiki/ArielMap.png)


> Black Boxes

The black boxes are static and do not move.

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


***

**MENU OPTIONS**

> Choose Senerio

This option allows you to choose 1 out of 9 game senerios to activate.

![](https://github.com/netanelin/Packman_Multiplayer/blob/master/Images%20for%20wiki/senerio.png)

Once a senerio is chosen the program will draw the components on the gameboard in the correct places.
For example if senerio_5 was chosen this is what the gameBoard would look like:

![](https://github.com/netanelin/Packman_Multiplayer/blob/master/Images%20for%20wiki/senerio_5.png)


> Run Manual

After Run Manual is activated, the first click initiates our players location and then every time the mouse is pressed down our player moves towards the mouse and all packmans & ghosts move according to their algorithm. When the mouse is released the whole game stops moving. Whenever there are no more fruits left or the time runs out the game stops and the board is cleared, the results are written on the console.

![](https://github.com/netanelin/Packman_Multiplayer/blob/master/Images%20for%20wiki/run_manual.png)


> Run Algorithm

If Run Algorithm is activated, immediately the player is initiated and starts running through the game eating the fruit by using our algorithm which finds the closest fruit to players location, when the distanse is defined as follows: If there are no boxes in the way we take the actual distanse (in meters) between the player and the fruit. If there are boxes blocking the fruit we travel near the box corners until we can go straight to the fruit and that whole path is the distance.

![](https://github.com/netanelin/Packman_Multiplayer/blob/master/Images%20for%20wiki/run_algo.png)

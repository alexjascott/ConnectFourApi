# ConnectFourApi
Connect Four Restful API

Simple little API to facilitate a game of Connect 4. Developed rather quickly over the weekend, hopefully it will give a nod that I know a little bit of coding. I'm sure there are some logic issues remaining (such as what happens when tokens get higher than the top of the game grid).

Libraries used;
- Spring Boot
- Spring Rest
- Jersey/Jackson JSON serialisation
- Javax Validation
- JUnit

To use;
- "maven install"
- enter /target directory
- "java -jar connectfour-rest-api-1.0.0.jar"

Then to create a new game;
POST request to 'localhost:8080/newgame' with json body;
{
	"player1":"player one",
	"player2":"player two"
}

You can then get status from a standard get (browser);
http://localhost:8080/status?uuid=<uuid>
  
And you will need to post to 'localhost:8080/move?uuid=<uuid>&playername=player%20one&column=1' for each turn.

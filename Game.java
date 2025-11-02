    /**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 7.0
 */
public class Game 
{
    private Parser parser;
    private Room currentRoom;
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room foodCourt, mainCorridor, petShop, exitArea, mainExit;
      
        // create the rooms
        foodCourt = new Room(" in the grand food court where customers go to eat.");
        mainCorridor = new Room(" in the wide corridor centered by large stores.");
        petShop = new Room("in the pet shop to adopt small animals and buy pet food.");
        exitArea = new Room("in a quiet hall leading to the exit.");
        mainExit = new Room("free from the bustling mall!");
        
        // initialise room exits
        foodCourt.setExits(null, mainCorridor, exitArea, exitArea);
        mainCorridor.setExits(null, null, null, foodCourt);
        petShop.setExits(null, foodCourt, null, null);
        exitArea.setExits(foodCourt, mainExit, null, null);
        mainExit.setExits(null, null, null, exitArea);

        // start game outside
        currentRoom = foodCourt;  
    }

    /**
     *  Main play routine. Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    
    /*
     * This is a new method we replace for the if statements in printWelcome()
     */
    private void printLocationInfo()
    {
        // Prints room description you are in
        System.out.println("You are " + currentRoom.getDescription); 
        
        //Prints the exit header
        System.out.println("Exits: ");
        
        if(currentRoom.getExit != null) {
            System.out.print("north");
        }
        if(currentRoom.getExit != null) {
            System.out.print("east");
        }
        if(currentRoom.southExit != null){
            System.out.print("south");
        }
        if(currentRoom.westExit != null) {
            System.out.print("west");
        }
        System.out.println();
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        
        //replaces the code deleted
        printLocationInfo();
        /*
         * All of this is deleted
         * System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
        if(currentRoom.northExit != null) {
            System.out.print("north ");
        }
        if(currentRoom.eastExit != null) {
            System.out.print("east ");
        }
        if(currentRoom.southExit != null) {
            System.out.print("south ");
        }
        if(currentRoom.westExit != null) {
            System.out.print("west ");
        }
        System.out.println();
         */
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }
        
        Room nextRoom = null;
        
        Room nextRoom = currentRoom.getExit(direction);


        String direction = command.getSecondWord();

        // Try to leave current room.
        // This is the line that replaced the previous code
        
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            
            //Replaced the code.
            printLocationInfo();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            // signal that we want to quit
            return true;  
        }
    }
}

package infrastructure;

import application.GameService;

public class GameController {

    public static void main(String[] args) {

        GameService gameService = new GameService(new InMemoryGameRepository());
        while(runTurn(gameService));
    }

    public static boolean runTurn(GameService gameService, String... args) {
        switch (args[0]) {
            case "create":
                gameService.createDefaultPersonage(args[1]);
                return true;
            case "hit":
                String name = args[1];
                int dmg = Integer.parseInt(args[2]);
                gameService.hitPersonage(name, dmg);
                return true;
            case "exit":
                return false;
            default:
                System.out.println("Expected 'create', 'hit' or 'exit'");
                return true;
        }
    }

}

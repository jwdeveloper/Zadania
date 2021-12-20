package commands;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //zadanie rozpisac w klasie CommandManager metody
        // - addCommand  - dodaje komende wraz z jej eventem do hashmapy
        // - invokeCommand  - wyszukuje podana komende a nastepnie odpala jej event
        // - removeCommand - usuwa komende z hashmapy

        //zerknijcie do srodka tej metody
        tutorial();
        //taki ma byc efekt koncowy
        example();
    }
    public static void example()
    {
        CommandManager commandManager = new CommandManager();

        //zwyczajnie dodawanie lamdy
        CommandEvent kickEvent = ()->
        {
            System.out.println("==================");
            System.out.println("kick'nieto gracza");
            System.out.println("==================");
        };
        commandManager.addCommand("kick",kickEvent);

        //dodawanie lambdy tak jak kox programisci
        commandManager.addCommand("give_hp",() ->
        {
            System.out.println("==================");
            System.out.println("Dodano HP");
            System.out.println("==================");
        });

        Scanner scanner = new Scanner(System.in);
        //nieskonczonsc wpisywac komendy w nieskocznosc
        while (true)
        {
            System.out.println("Wpisz komende?");
            String command = scanner.nextLine();
            commandManager.invokeCommand(command);
        }
    }
    public static void tutorial()
    {
        //==============================================================================
        //co trzeba umiec
        // Uzywanie interfacu jako lamdy
        // HashMap
        // petla while
        // if
        //==============================================================================
        //przyklad lamdy
        //lamda czyli taki interfacje ktory nie sluzy do dziedziczenia
        //ale do zapisania kawalku kodu ktory mozna wywolac w dowolnym momencie

        //lamde mozna stworzyc tak
        CommandEvent kickEvent = new CommandEvent() {
            @Override
            public void execute()
            {
                System.out.println("Player kicked");
            }
        };
        //lub tak (bardziej prefewrowana opcja)
        CommandEvent banEvent = ()->
        {
            System.out.println("Player banned");
        };

        //aby odpalic kod zapisany w lamdzie trzeba zrobic tak
        kickEvent.execute();
        banEvent.execute();


        //==============================================================================
        //przyklad HashMap
        //jest to taka lista ktora przechowuje klucz i jego wartosc
        //klucze w hashmapie sa unikalne czyli nie mozna wlozyc 2 razy tego samego klucza
        HashMap<String,Integer> playerPoints = new HashMap<>();

        //przyklad na dodawanie
        playerPoints.put("Pawel",69);
        playerPoints.put("Iza",2137);

        //przyklad na pobranie wartosci
        Integer points =  playerPoints.get("Pawel");

        //przyklad na sprawdzenie czy klucz isnieje

        boolean keyExists = playerPoints.containsKey("Pawel");

        //przyklad na usuwanie
        playerPoints.remove("Pawel");
        playerPoints.remove("Pawel");

        //przyklad na zamiane wartosci
        playerPoints.replace("Pawel",22222);

        //wszystko o hashMapach
        //==============================================================================
    }
}
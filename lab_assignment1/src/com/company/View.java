package com.company;

import java.util.Scanner;

public class View {
    private String username;
    private String usermc;
    private String userrating;

    public void getInputToSetFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enterAnime name.");
        username = scanner.nextLine();
        System.out.println("enterAnime Mc.");
        usermc = scanner.nextLine();
        System.out.println("enterAnime Rating.");
        userrating = scanner.nextLine();
    }
    /**
     * This method takes the input from user directly.
     **/
    public void getInputFromUser()
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your favourite Anime name.");
        username = scanner.nextLine();
    }

    /**
     * This method is used by controller to get the anime name
     **/
    public String giveAnimeNameToController()
    {
        return username;
    }

    /**
     * This method prints information of anime that user has requested.
     * @param animeName The name of the anime the user has requested
     * @param animeMc The name of the main character of the Anime
     * @param animeRating My anime list rating of the Anime
     **/
    public void printAnimeDetails(String animeName,String animeMc,String animeRating)
    {
        System.out.println("Anime Info: ");
        System.out.println("Anime Name: " + animeName);
        System.out.println("Main Character Name: " + animeMc);
        System.out.println("Ratings: " + animeRating);
    }

    /**
     * This method will allow the view to give the animename to save to controller
     **/
    public String giveAnimeNameInputToController()
    {
        return username;
    }

    /**
     * This method will allow the view to give the animemc name to save to controller
     **/
    public String giveAnimeMcInputTocontroller()
    {
        return usermc;
    }

    /**
     * This method will allow the view to give the animerating to save to controller
     **/
    public String giveAnimeRatingInputToController()
    {
        return userrating;
    }
}

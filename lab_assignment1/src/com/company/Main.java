package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);


        System.out.println(" Choose your option");
        System.out.println("1.View Anime info");
        System.out.println("2.Add new Anime");

        Scanner scanner = new Scanner(System.in);
        int opt=scanner.nextInt();
        //System.out.println();
        if(opt==1) {
            controller.getInputFromView();
            controller.getUserRequestedInfoFromModel();
            controller.giveUserRequestedInfoToView();
        }
        else if(opt==2){
            controller.getInputFromViewToSave();
            controller.giveUserGivenInfoToModel();

        }


    }
}

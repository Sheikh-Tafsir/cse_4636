package com.company;

public class Controller {
    private Model model;
    private View view;

    private String animeName;
    private String animeMc;
    private String animeRating;

    /**
     * The controller constructor takes a model and view as parameters
     * as it will act as the mediator between them.
     * @param model the model object that will store the student's info
     * @param view the view object that the user will see
     **/
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }


    /**
     * This method will allow the controller to take the user input from view
     **/
    public void getInputFromView()
    {
        view.getInputFromUser();
    }
    public void getInputFromViewToSave()
    {
        view.getInputToSetFromUser();
    }
    public void giveUserGivenInfoToModel()
    {
        animeName = view.giveAnimeNameInputToController();
        animeMc = view.giveAnimeMcInputTocontroller();
        animeRating = view.giveAnimeRatingInputToController();
        model.saveAnimeInfo(animeName, animeMc, animeRating);
    }


    /**
     * Through this method, the controller will get requested info from the model
     **/
    public void getUserRequestedInfoFromModel()
    {
        model.setAnimeInfo(view.giveAnimeNameToController());
        animeName = model.giveAnimeNameToController();
        animeMc = model.giveAnimeMcTocontroller();
        animeRating = model.giveAnimeRatingToController();
    }

    /**
     * Through this method, the controller will pass the user requested info to the view
     **/
    public void giveUserRequestedInfoToView()
    {
        view.printAnimeDetails(animeName, animeMc, animeRating);
    }
}

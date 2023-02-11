package com.company;

import java.sql.*;

public class Model {
    private String animeName;
    private String animeMc;
    private String animeRating;
    private String username;

    /**
     * This method will communicate with the database
     * and get the information that the user has requested.
     **/
    public void setAnimeInfo(String username)
    {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/anime", "root", "Rubaiyat26");

            /**
             * Here sonoo is database name, root is username and password
             * Statement stmt = con.createStatement();
             * ResultSet rs = stmt.executeQuery("select * from users where name = ?");
             **/
            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE animename = ?");
            System.out.println(username);
            psCheckUserExists.setString(1, username);
            resultSet = psCheckUserExists.executeQuery();
            /**/
            if (resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    //System.out.println(resultSet.getInt(1) + "  " + resultSet.getString(2) + "  " + resultSet.getString(3));
                    this.animeName = resultSet.getString(2);
                    this.animeMc = resultSet.getString(3);
                    this.animeRating = resultSet.getString(4);
                }
                connection.close();
            }
            else {
                //System.out.println("no user");
                this.animeName = "Not found";
                this.animeMc = "Not found";
                this.animeRating = "Not found";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveAnimeInfo(String animename,String animemc,String animerating)
    {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/anime", "root", "Rubaiyat26");

            /**
             * Here sonoo is database name, root is username and password
             * Statement stmt = con.createStatement();
             * ResultSet rs = stmt.executeQuery("select * from users where name = ?");
             **/
            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE animename = ?");
            //System.out.println(username);
            psCheckUserExists.setString(1, username);
            resultSet = psCheckUserExists.executeQuery();
            /**/
            if (resultSet.isBeforeFirst()) {
                System.out.println("already exists");
                connection.close();
            }
            else {
                psInsert = connection.prepareStatement("INSERT INTO users(animename,animemc,animerating) VALUES(?,?,?)");
                psInsert.setString(1, animename);
                psInsert.setString(2, animemc);
                psInsert.setString(3, animerating);
                psInsert.executeUpdate();
                Statement stm = connection.createStatement();
                System.out.println("saved");

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method will allow the model to give the animename to controller
     **/
    public String giveAnimeNameToController()
    {
        return animeName;
    }

    /**
     * This method will allow the model to give the animemcname to controller
     **/
    public String giveAnimeMcTocontroller()
    {
        return animeMc;
    }

    /**
     * This method will allow the model to give the animerating to controller
     **/
    public String giveAnimeRatingToController()
    {
        return animeRating;
    }
}

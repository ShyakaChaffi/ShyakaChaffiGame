package repositories;

import domain.Category;
import domain.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

//TRAINER: this class already exists (see GameJDBCRepository in JDBC package)
public class GameReposity {

    private static final GameReposity instance = new GameReposity();

    public static GameReposity getInstance() {
        return instance;
    }

    public Connection createConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/games"
                , "root"
                , "");
    }

    public Game getGameWithIdFive() throws SQLException { // READ
        Game game= new Game();
        try (PreparedStatement preparedStatement = createConnection().prepareStatement("select * from game where id=5 ")) {
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while(resultSet.next()){
                game.setId(resultSet.getInt("id"));
                game.setAge(resultSet.getString("age"));
                game.setAuthor(resultSet.getString("author"));
                //game.setDifficulty_id(resultSet.getInt("difficulty_id"));
                game.setEditor(resultSet.getString("editor"));
                game.setGame_name(resultSet.getString("game_name"));
                game.setMax_player(resultSet.getInt("max_players"));
                game.setMin_players(resultSet.getInt("min_players"));
                game.setImage(resultSet.getString("image"));
                game.setPlay_duration(resultSet.getString("play_duration"));
                game.setPrice(resultSet.getInt("price"));
                game.setYear_edition(resultSet.getInt("year_edition"));
                createConnection().close();
            }
           return game;
        }
        }


    public Game GetGameOfYourChoice(String choice) throws SQLException { // READ
          Game game= new Game();
          try (PreparedStatement preparedStatement = createConnection().prepareStatement("select * from game where id=5 ")) {
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while(resultSet.next()){

            }
            return game;
        }
    }




}

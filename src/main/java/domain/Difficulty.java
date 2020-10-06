package domain;

import domain.enums.DifficultyType;
import domain.enums.DifficultyType2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Difficulty implements Serializable {

    @Id @GeneratedValue
    private Integer Id;

    @Column(nullable = false,length = 200)
    private String difficulty_name;

    public Difficulty(String difficultyName, Integer id) {
        this.difficulty_name = difficultyName;
        this.Id = id;
    }

    public Difficulty(String difficultyName) {
        this.difficulty_name = difficultyName;
    }

    public Difficulty() {

    }

    public String getDifficulty_name() { return difficulty_name;}

    public void setDifficulty_name(String difficulty_name) {
        this.difficulty_name = difficulty_name;
    }
    public static boolean equalOrMore(Difficulty d1, DifficultyType difficulty){
        //TODO: Replace that by a system were each enum of difficulty contain a tab of less level difficulties,
        // then search if the d1.difficulty_name is not in this tab
        System.out.println(d1.Id + " " + difficulty.getDifficultyValue());
        return d1.Id >= difficulty.getDifficultyValue();
    }

    public static boolean equalOrMore(Difficulty d1, DifficultyType2 difficulty){
        //TODO: Replace that by a system were each enum of difficulty contain a tab of less level difficulties,
        // then search if the d1.difficulty_name is not in this tab
        List<String> strings = new ArrayList<String>(Arrays.asList(difficulty.getDifficultyValue().split(",")));
        return !strings.contains(d1.difficulty_name);
    }

}

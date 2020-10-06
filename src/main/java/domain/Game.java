package domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Game implements Serializable {

    @Id @GeneratedValue
    private Integer Id;

    @Column(nullable = false,length = 200)
    private String game_name;

    @Column(nullable = false,length = 200)
    private String editor;

    @Column(nullable = false,length = 200)
    private String author;

    @Column(nullable = false)
    @NotNull
    private int  year_edition;

    @Transient
    private String age;

    @Column(name = "min_players")
    private int min_players;
    @Column(name = "max_players")
    private int max_player;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private String play_duration;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "difficulty_id")
    private Difficulty difficulty;

    private float price;

    private String image;

    public void setId(int id) {
        Id = id;
    }

    public Game() {
    }
    public Game(Builder builder) {
        this.Id = builder.Id;
        this.game_name = builder.game_name;
        this.editor = builder.editor;
        this.author = builder.author;
        this.year_edition = builder.year_edition;
        this.age = builder.age;
        this.min_players = builder.min_players;
        this.max_player = builder.max_player;
        this.play_duration = builder.play_duration;
        this.price = builder.price;
        this.image = builder.image;
        this.category = builder.category;
        this.difficulty = builder.difficulty;
    }

    //--------------------Builder----------------------------


    public static class Builder {
        private Integer Id;
        private String game_name;
        private String editor;
        private String author;
        private int  year_edition;
        private String age;
        private int min_players;
        private int max_player;
        private Integer category_id;
        private String play_duration;
        private int difficulty_id;
        private float price;
        private String image;
        private Category category;
        private Difficulty difficulty;



        public Builder(String game_name) {
            this.game_name = game_name;
        }

        public Builder withId(int Id) {
            this.Id = Id;
            return this;
        }

        public Builder withname(String name) {
            this.game_name = name;
            return this;
        }


        public Builder withEditor(String editor) {
            this.editor = editor;
            return this;
        }

        public Builder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder withYearEdition(int yearEdition) {
            this.year_edition = yearEdition;
            return this;
        }
        public Builder withAge(String age) {
            this.age = age;
            return this;
        }

        public Builder withMinPlayers(int minPlayers) {
            this.min_players = minPlayers;
            return this;
        }
        public Builder withMaxPlayers(int maxPlayers) {
            this.max_player = maxPlayers;
            return this;
        }
        public Builder withPlayDuration(String playDuration) {
            this.play_duration = playDuration;
            return this;
        }
        public Builder withPrice(int price) {
            this.price = price;
            return this;
        }
        public Builder withImage(String image) {
            this.image = image;
            return this;
        }
        public Builder withCategory(Category category) {
            this.category = category;
            return this;
        }
        public Builder withDifficulty(Difficulty difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        public Game build() {
            return new Game(this);
        }

        }

// ------------------Builder-------------------------
    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear_edition(int year_edition) {
        this.year_edition = year_edition;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setMin_players(int min_players) {
        this.min_players = min_players;
    }

    public void setMax_player(int max_player) {
        this.max_player = max_player;
    }

    public void setCategory_id(Category category_id) {
        this.category = category_id;
    }

    public void setPlay_duration(String play_duration) {
        this.play_duration = play_duration;
    }

    public void setDifficulty_id(Difficulty difficulty_id) {
        this.difficulty = difficulty_id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return Id;
    }

    public String getGame_name() {
        return game_name;
    }

    public String getEditor() {
        return editor;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear_edition() {
        return year_edition;
    }

    public String getAge() {
        return age;
    }

    public int getMin_players() {
        return min_players;
    }

    public int getMax_player() {
        return max_player;
    }

    public Category getCategory_id() {
        return category;
    }

    public String getPlay_duration() {
        return play_duration;
    }

    public Difficulty getDifficuty_id() {
        return difficulty;
    }

    public float getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Game with id 5 \n" +
                ", name='" + getGame_name() + '\'' +
                ", editor='" + getEditor() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", year of edition=" + getYear_edition() +
                ", age='" + getAge() + '\'' +
                ", min_players=" + getMin_players() +
                ", max_player=" + getMax_player() +
                ", category_id=" + getCategory_id() +
                ", play_duration='" + getPlay_duration() + '\'' +
                ", difficulty_id=" + getDifficuty_id() +
                ", price=" + getPrice() +
                ", image='" + getImage() + '\'';
    }
}

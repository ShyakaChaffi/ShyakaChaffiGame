package domain;

import javax.persistence.*;

import java.io.Serializable;

@Entity
public  class Category  implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //TRAINER: use Strategy for your primary key
    private Integer id;

    @Column(nullable = false,length = 200)
    //TRAINER: use @Column(name = "category_name") and give this field a proper name, where you follow the naming conventions of java
    //TRAINER no snake casing, use camel casing for your field names
    private String category_name;


  public Category(int id, String category_name){
      this.id = id;
      this.category_name=category_name;
  }

    public Category() {
    }

    public Category(String category_name) { this.category_name=category_name; }

    public int getId() {
        return id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return  "ID: "+ this.getId()+" - category_name='" + getCategory_name() + '\'';
    }
}

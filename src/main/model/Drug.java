package model;

import org.json.JSONObject;
import persistence.Writable;

import java.io.Writer;

//Represent the medicine that Diabetes Patient need to take
//with its name, Drug instruction and its category
public class Drug implements Writable {
    private String name;
    private Category category;


    // EFFECTS: Drug that with its name and instruction and has not been taken.
    public Drug(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    // EFFECTS: returns name
    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }


    // EFFECTS: returns string representation of this drug
    public String toString() {
        return category + ": " + name;
    }


    @Override

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("category", category);
        return json;
    }

}

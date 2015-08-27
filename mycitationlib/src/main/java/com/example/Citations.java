package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Citations {
    List<String> author = new ArrayList<String>();
    List<String> citation = new ArrayList<String>();

    String lastRes = "";

    public Citations() {
        author.add("Autor1");
        author.add("Autor2");
        author.add("Autor3");
        author.add("Autor4");
        author.add("Autor5");
        citation.add("Texto1");
        citation.add("Texto2");
        citation.add("Texto3");
        citation.add("Texto4");
        citation.add("Texto5");      
        
    }

    public String GetCitation() {
        Integer number ;
        String res;
        String authorRes;
        String citationRes;

        number = (randInt(0, this.author.size()-1));
        authorRes = this.author.get(number);
        if (authorRes.length() <= 30)
            res = authorRes;
        else
            res = authorRes.substring(0, 28) + "..";

        citationRes = this.citation.get(number);
        if (citationRes.length() <= 200)
            res = res + ": " + citationRes;
        else
            res = res + ": " + citationRes.substring(0, 198) + "..";

        while (lastRes.equals(res)){
            number = (randInt(0, this.author.size()-1));
            authorRes = this.author.get(number);
            if (authorRes.length() <= 30)
                res = authorRes;
            else
                res = authorRes.substring(0, 28) + "..";

            citationRes = this.citation.get(number);
            if (citationRes.length() <= 200)
                res = res + ": " + citationRes;
            else
                res = res + ": " + citationRes.substring(0, 198) + "..";
        }
        return res;
    }

    public void AddCitation(String addAuthor, String addCitation) {
        author.add(addAuthor);
        citation.add(addCitation);
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }
}

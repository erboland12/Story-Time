package com.shapesandsuch.storytime.backend;

import java.util.ArrayList;

public class Poem extends Post {

    public Poem(Template type, String title, ArrayList<String> authors, long unix){
        super.type = type;
        super.title = title;
        super.authors = authors;
        super.unixTime = unix;
    }

}

package com.shapesandsuch.storytime.backend;

import java.util.ArrayList;

public abstract class Post {
    public Template type;
    public String title;
    public ArrayList<String> authors;
    public long unixTime;

    public Template getType(){ return type; }
    public void setType(Template t){ this.type = t; }

    public String getTitle(){ return this.title; }
    public void setTitle(String t){ this.title = t; }

    public ArrayList<String> getAuthors(){ return this.authors; }
    public void setAuthors(ArrayList<String> auths){ this.authors = auths; }

    public long getUnixTime(){ return this.unixTime; }
    public void setUnixTime(long ut){ this.unixTime = ut; }

}

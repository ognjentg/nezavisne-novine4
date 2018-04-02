package com.telegroup.myapplication;

import android.support.v17.leanback.widget.ArrayObjectAdapter;

import java.util.List;

/**
 * Created by bojan on 3/27/18.
 */

public class Kategorije {
    static CardPresenter presenter = new CardPresenter();

    public Kategorije(int id, String naziv, String  boja){
        this.boja = boja;
        this.id = id;
        this.naziv = naziv;
        this.setAdapter(new ArrayObjectAdapter(presenter));


    }
    public Kategorije(int id, String naziv, String boja, List<Vijesti> vijesti){
        this.boja = boja;
        this.id = id;
        this.naziv = naziv;
        this.setVijesti(vijesti);
        this.setAdapter(new ArrayObjectAdapter(presenter));
    }

    private int id;
    private String naziv;
    private String  boja;
    private List<Vijesti> vijesti;
    private ArrayObjectAdapter adapter;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    @Override
    public String toString() {
        return "";
    }

    public List<Vijesti> getVijesti() {
        return vijesti;
    }

    public void setVijesti(List<Vijesti> vijesti) {
        this.vijesti = vijesti;
    }

    public ArrayObjectAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(ArrayObjectAdapter adapter) {
        this.adapter = adapter;
    }
}

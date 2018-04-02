package com.telegroup.myapplication;

/**
 * Created by bojan on 3/27/18.
 */

public class Vijesti {
    private int vijestId;
    private String naslov;
    private String autor;
    private String datum;
    private String opis;
    private String tjelo;
    private String url_Slika;
    private int katagerijaID;

    public Vijesti(int vijestId, String naslov, String autor, String datum, String opis, String tjelo, String url_Slika,int katagerijaID) {
        this.vijestId = vijestId;
        this.naslov = naslov;
        this.autor = autor;
        this.datum = datum;
        this.opis = opis;
        this.tjelo = tjelo;
        this.url_Slika = url_Slika;
        this.katagerijaID = katagerijaID;
    }

    public int getVijestId() {
        return vijestId;
    }

    public void setVijestId(int vijestId) {
        this.vijestId = vijestId;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTjelo() {
        return tjelo;
    }

    public void setTjelo(String tjelo) {
        this.tjelo = tjelo;
    }

    public String getUrl_Slika() {
        return url_Slika;
    }

    public void setUrl_Slika(String url_Slika) {
        this.url_Slika = url_Slika;
    }

    public int getKatagerijaID() {
        return katagerijaID;
    }

    public void setKatagerijaID(int katagerijaID) {
        this.katagerijaID = katagerijaID;
    }
}

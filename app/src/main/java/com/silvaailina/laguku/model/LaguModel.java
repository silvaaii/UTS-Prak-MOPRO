package com.silvaailina.laguku.model;
public class LaguModel {
        String judul;
        String penyanyi;
        String genre;


        public LaguModel(String judul, String penyanyi, String genre) {
            this.judul = judul;
            this.penyanyi = penyanyi;
            this.genre = genre;

        }

    public LaguModel(String judul, String penyanyi, String genre, String description) {
        this.judul = judul;
        this.penyanyi = penyanyi;
        this.genre = genre;

    }

    public String getJudul() {
            return judul;
        }

        public void setJudul(String judul) {
            this.judul = judul;
        }

        public String getPenyanyi() {
            return penyanyi;
        }

        public void setPenyanyi(String penyanyi) {
            this.penyanyi = penyanyi;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }


    }

package com.devsuperior.dslist.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity /* Permite que os dados da classe se torne uma tabela no banco de dados relacional */
@Table (name = "tb_game") /* Nome da tabela */

public class Game {

    @Id /* Tornando ID como chave primária do banco */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Gera auto-incremento */

    private Long id;
    private String title;
    @Column(name = "game_year")
    private Integer year; /* A palavra year é reservada no SQL, para evitar problema, a atribuição acima
    troca o nome da coluna para "game_year" */
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;
    /* Em situações que o nome da coluna se encontra como camecase na classe, na tabela o nome ficara com underline
    entre as palavras: img_url */

    public Game(){ }

    public Game(String title, Long id, Integer year, String genre,
                String platforms, Double score, String shortDescription,
                String imgUrl, String longDescription) {
        this.title = title;
        this.id = id;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.score = score;
        this.shortDescription = shortDescription;
        this.imgUrl = imgUrl;
        this.longDescription = longDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

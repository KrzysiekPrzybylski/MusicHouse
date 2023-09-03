package com.music;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.mapping.List;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="artists")


public class Artist {

    @Id
    @GeneratedValue
    @NonNull
    private Long id;
    private String firstName;
    private String lastName;
    private String musicType;
    private int age;
    private String country;


    @ManyToMany(mappedBy = "artists")
    private List<Album> albums = new ArrayList<>();

    @ManyToMany(mappedBy = "artists")
    private List<Song> songs = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}

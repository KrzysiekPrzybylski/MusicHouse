//package com.example.MusicCompany.service;
//
//import com.example.MusicCompany.model.Artist;
//import com.example.MusicCompany.repository.ArtistRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DataInitializer implements CommandLineRunner {
//
//    private final ArtistRepository artistRepository;
//
//    @Autowired
//    public DataInitializer(ArtistRepository artistRepository) {
//        this.artistRepository = artistRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        String defaultName = "Domyślny";
//        if (findArtistByName(defaultName) == null) {
//            Artist defaultArtist = new Artist();
//
//            defaultArtist.setName("Domyślny");
//            defaultArtist.setSurname("Artysta");
//            defaultArtist.setAge(99);
//            defaultArtist.setCountry("Polska");
//            defaultArtist.setType("Pop");
//
//            artistRepository.save(defaultArtist);
//        }
//    }
//
//    public Artist findArtistByName(String name) {
//        for (Artist artist : artistRepository.findAll()) {
//            if (artist.getName().equals(name)) {
//                return artist;
//            }
//        }
//        return null;
//    }
//}
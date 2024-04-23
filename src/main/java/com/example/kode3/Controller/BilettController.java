package com.example.kode3.Controller;

import com.example.kode3.Modell.Bilett;
import com.example.kode3.Modell.Film;
import com.example.kode3.Repository.BilettRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BilettController {


    List<Film> filmer = new ArrayList<Film>();

    @Autowired
    BilettRepository rp;

    //API Requests
    @GetMapping("/listFilms")
    public List<Film> listFilms(){
        filmer.add(new Film("The equalizer 1"));
        filmer.add(new Film("Black Hawk Down"));
        filmer.add(new Film("Christopher Robin"));
        filmer.add(new Film("Green Zone"));
        filmer.add(new Film("The Covenant"));
        return filmer;
    }

    @PostMapping("/lagreBilett")
    public void lagreBilett(Bilett bilett){
        rp.lagreBilett(bilett);
    }

    @GetMapping("/ListBiletter")
    public List<Bilett> listBiletter(){
        return rp.listBiletter();
    }

    @GetMapping("/sletteBiletter")
    public void sletteBiletter(){
        rp.sletteBiletter();
    }

}

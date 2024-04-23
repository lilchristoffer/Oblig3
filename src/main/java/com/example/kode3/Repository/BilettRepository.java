package com.example.kode3.Repository;

import com.example.kode3.Modell.Bilett;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BilettRepository {


    @Autowired
    JdbcTemplate db;

    public void lagreBilett(Bilett bilett){
        String sql = "INSERT INTO bilett(film,antall,fornavn,etternavn,telefonnr,epost)VALUES(?,?,?,?,?,?)";
        db.update(sql,bilett.getFilm(),bilett.getAntall(),bilett.getFornavn(),bilett.getEtternavn(),bilett.getTelefonnr(),bilett.getEpost());
    }
    public List<Bilett> listBiletter(){
        String sql = "SELECT * FROM bilett";
        List<Bilett> biletter = db.query(sql,new BeanPropertyRowMapper<>(Bilett.class));
        return biletter;
    }

    public void sletteBiletter(){
        String sql = "DELETE FROM bilett";
        db.update(sql);
    }


}

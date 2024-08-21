package com.Teachers.booklet.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class StudentCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Enumerated(EnumType.STRING)
    private OptionsPonCas ponasanjeNaCasu;
    @Enumerated(EnumType.STRING)
    private OptionsRad radNaCasu;
    @Enumerated(EnumType.STRING)
    private OptionsKomNast komunikacijaSNastavnikom;
    @Enumerated(EnumType.STRING)
    private OptionsKomUce komunikacijaSUcenicima;
    @Enumerated(EnumType.STRING)
    private OptionsTempo tempoNapredovanja;
    @Lob
    private String saradnjaSRoditeljem;
    @Lob
    private String planiranRadSDetetom;
    @Lob
    private String komentar;
    @OneToOne
    @JoinColumn(name = "student_name")  // A 'student_name' az oszlop neve, amely a Student 'name' mezőjére hivatkozik
    private Student student;
}

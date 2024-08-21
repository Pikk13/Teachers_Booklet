package com.Teachers.booklet.Model;

import jakarta.persistence.OneToOne;

public enum OptionsKomUce {
    @OneToOne ODLICNA,
    @OneToOne ZADOVALJAVAJUCA,
    @OneToOne NEZADOVOLJAVAJUCA,
    @OneToOne SUKOBLJAVA,
    @OneToOne ANTISOCIJALNO_PONASANJE
}

package com.Teachers.booklet.Model;

import jakarta.persistence.OneToOne;

public enum OptionsPonCas {
    @OneToOne ZAINTERESOVAN_AKTIVAN,
    @OneToOne PASIVAN,
    @OneToOne SLABA_KONCENTRACIJA,
    @OneToOne NEFLEKSIBILAN,
    @OneToOne NEZAINTERESOVAN
}

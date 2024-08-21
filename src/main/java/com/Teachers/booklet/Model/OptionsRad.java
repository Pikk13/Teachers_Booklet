package com.Teachers.booklet.Model;

import jakarta.persistence.OneToOne;

public enum OptionsRad {
    @OneToOne RADI_VISE,
    @OneToOne SAMOSTALAN,
    @OneToOne PREOKUPIRAN_DETALJIMA,
    @OneToOne KAMPANJSKI,
    @OneToOne KONZISTENTAN,
    @OneToOne NEORGANIZOVAN
}

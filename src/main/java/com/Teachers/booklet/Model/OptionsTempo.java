package com.Teachers.booklet.Model;

import jakarta.persistence.OneToOne;

public enum OptionsTempo {
    @OneToOne UBRZANI,
    @OneToOne PROSECAN,
    @OneToOne SPORO
}

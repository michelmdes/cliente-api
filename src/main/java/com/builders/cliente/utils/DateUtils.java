package com.builders.cliente.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

    public static Integer calculaIdade(Date dataNascimento) {
        final Period periodo = Period.between(dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
        return periodo.getYears();
    }
}

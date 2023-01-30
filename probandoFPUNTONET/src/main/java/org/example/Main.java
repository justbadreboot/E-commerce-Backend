package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws ParseException {


        System.out.println("resultado");

        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);

        String timeEND = "27/01/2023 11:05:23";
        String horasmin ="24";
        Integer parseoHorasMin= Integer.valueOf(horasmin);

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date t1 = formato.parse(timeStamp);
        System.out.println("hora actual: "+timeStamp);
        Date t2 = formato.parse(timeEND);
        System.out.println("hora de guardado: "+timeEND);
        Long diferencia = t1.getTime()-t2.getTime();

        System.out.println("diferencia de horas en ml: "+diferencia);

        System.out.println("Probando convertidor de horas: "+ (diferencia/(1000*60*60)));
        Integer diferenciaTotalHoras= Math.toIntExact((diferencia / (1000 * 60 * 60)));
        System.out.println(diferenciaTotalHoras);

        Long horasDiferencia = (diferencia/(1000*60*60))%24;
        Long minutosDiferencia = (diferencia/(1000*60))%60;

        long difference_In_Days = (diferencia/ (1000 * 60 * 60 * 24))%365;

        System.out.println("diferencia entre dias "+ difference_In_Days);
        System.out.println("diferencia de horas "+ horasDiferencia);
        System.out.println("diferencia de minutos: "+ minutosDiferencia);

        if (difference_In_Days!=0){
            System.out.println("se reaiza el procedimiento");
        }else {
            System.out.println("Han pasado "+ horasDiferencia + " horas y " + minutosDiferencia+ " minutos desde que actualizaste tu contrasenia");
        }

        if(diferenciaTotalHoras<parseoHorasMin){
            System.out.println("han pasado tal horas para actualizar");
            System.out.println("te faltan "+(parseoHorasMin-horasDiferencia-1)+" horas y "+(60-minutosDiferencia)+" minutos para actualiza tu password");
        }




        funcionComparativa();

    }
    public static String algo(){
        return "true";
    }

    public static Boolean funcionComparativa(){
        String valor = "true";
        String valorafUNCION= algo();
        if (!Objects.equals(valorafUNCION, "true")){
            System.out.println("el valor es verdadero aqui devuelve el error");
            return false;
        }else {
            System.out.println("el valor es falso, aqui devuelve que se actualizo la contra");
            return true;
        }

    }
}
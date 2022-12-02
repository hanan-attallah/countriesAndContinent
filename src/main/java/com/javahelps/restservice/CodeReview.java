package com.harri;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class CodeReview {

    Integer x;
    String Name;
    String employee_address;

    // This function is used to pass the employee name
    public void setName(String newName){
        if (newName == null || newName == ""){
            return;
        }

        this.Name = newName.toLowerCase(Locale.ROOT);
    }

    /**
     * This function is used to calculate the age of the employee
     * @param start date
     * @return age
     */
    public Integer calculateAge(LocalDate start){
        LocalDate end = LocalDate.now();
        long years = ChronoUnit.YEARS.between(start, end);
        System.out.println(years); // 17
        return x;
    }

    /**
     * This function used to return the value of divsion 
     * @param y
     * @return
     */
    public Integer checkTheValueOfX(Integer y){
        return y/x;
    }


}

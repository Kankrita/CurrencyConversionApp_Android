package com.example.finalandroid_2015233.Model;

public class Converter
{
        public double EuroToBrazilian(Double euro)
        {
            return Math.round(euro / 0.18) ;
        }

        public double EuroToUSD(Double euro)
        {
            return Math.round(euro / 0.92) ;
        }
}

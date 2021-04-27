package br.com.willi.williMeter.util;

public class InsufficientFundsException extends Exception{

    public String toString(){
        return "Saldo insuficiente.";
    }
}

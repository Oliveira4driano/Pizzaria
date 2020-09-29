/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Dev-2810
 */
public class Pizza {
    
    private static final long serialVersionUID = 1L;
    private String massa;
    private String lote;
    private String quantidade;
    private String temperatura;
    private String data;
    private String Impressora;
    private String semana;

    public Pizza() {
    }

    public Pizza(String massa, String lote, String quantidade, String temperatura, String data, String Impressora, String semana) {
        this.massa = massa;
        this.lote = lote;
        this.quantidade = quantidade;
        this.temperatura = temperatura;
        this.data = data;
        this.Impressora = Impressora;
        this.semana = semana;
    }

    public String getMassa() {
        return massa;
    }

    public void setMassa(String massa) {
        this.massa = massa;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getImpressora() {
        return Impressora;
    }

    public void setImpressora(String Impressora) {
        this.Impressora = Impressora;
    }

    public String getSemana() {
        return semana;
    }

    public void setSemana(String semana) {
        this.semana = semana;
    }

   
   

}
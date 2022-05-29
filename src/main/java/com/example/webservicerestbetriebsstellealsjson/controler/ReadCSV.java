package com.example.webservicerestbetriebsstellealsjson.controler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadCSV {
    //konvertiert ein String to Map mit Namen
    public static Map stringMap(String row){
        Map einBelletrist =new LinkedHashMap();
        einBelletrist.put("Name", row.split(";", -1)[1]);
        einBelletrist.put("Kurzname", row.split(";", -1)[2]);
        einBelletrist.put("Typ", row.split(";", -1)[3]);
        return einBelletrist;
    }
    //Alle Zeilen anzeigen
    public static ArrayList<Map> readAll(String file) throws Exception {
        String row ;
        ArrayList<Map> allEllement = new ArrayList<>();
        //Reader-Instanz erstellen
        BufferedReader br = new BufferedReader(new FileReader(file));
        //Liest die CSV-Datei Zeile für Zeile
        while ((row = br.readLine()) != null) {
            allEllement.add(stringMap(row));
        }
        br.close();
        return allEllement;
    }
    //Zeile anzeige mit abk
    public static Map readElement(String file , String abk) throws Exception
    {
        String row="";
        ArrayList<Map> listEllement = new ArrayList<>();
        //Reader-Instanz erstellen
        BufferedReader br = new BufferedReader(new FileReader(file));
        //Liest die CSV-Datei Zeile für Zeile und überprüft die Abk-Angabe
        while ((row=br.readLine())!=null){
            if(row.split(";",-1)[0].toUpperCase().equals(abk.toUpperCase())){
                br.close();
                return stringMap(row);
            }
        }
        return null;
    }
    //Alle Zeilen anzeigen,die ein Teil von abk haben
    public static  ArrayList<Map> readElementContTeilAbk(String file , String teilabk) throws Exception
    {
        String row="";
        ArrayList<Map> listEllement = new ArrayList<>();
        //Reader-Instanz erstellen
        BufferedReader br = new BufferedReader(new FileReader(file));
        //Liest die CSV-Datei Zeile für Zeile und überprüft die teil von Abk-Angabe
        while ((row=br.readLine())!=null){
            if(row.split(";",-1)[0].toUpperCase().contains(teilabk.toUpperCase())){
                listEllement.add( stringMap(row));
            }
        }
        br.close();
        return listEllement;
    }
}

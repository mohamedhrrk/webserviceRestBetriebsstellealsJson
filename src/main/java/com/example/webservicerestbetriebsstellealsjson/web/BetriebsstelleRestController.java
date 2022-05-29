package com.example.webservicerestbetriebsstellealsjson.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.webservicerestbetriebsstellealsjson.controler.ReadCSV;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/betriebsstelle")
public class BetriebsstelleRestController {

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Map> betriebsstellenList() throws Exception {
        return   ReadCSV.readAll("C:\\Users\\Mohamedhrrk\\Downloads\\DBNetz-Betriebsstellenverzeichnis-Stand2018-04.csv");
    }
    @GetMapping (path = "/{abk}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map betriebsstelleAbk(@PathVariable("abk") String abk) throws Exception {
        return ReadCSV.readElement("C:\\Users\\Mohamedhrrk\\Downloads\\DBNetz-Betriebsstellenverzeichnis-Stand2018-04.csv",abk);
    }
    @GetMapping (path = "/content/{teilAbk}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Map> betriebsstelleContTeilAbk(@PathVariable("teilAbk") String teilAbk) throws Exception {
        return ReadCSV.readElementContTeilAbk("C:\\Users\\Mohamedhrrk\\Downloads\\DBNetz-Betriebsstellenverzeichnis-Stand2018-04.csv",teilAbk);
    }
}

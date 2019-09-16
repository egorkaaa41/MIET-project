package miet.server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("service")
public class Rest_APIController {



    /**
     * curl -X POST -i localhost:8080/service/transaction -d "json={\"code\": 10, \"contractNumber\": 802369, \"status\": \"NEW\" }"
     */
   /* @RequestMapping(
            path = "transaction",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> transaction(@RequestParam("json")  String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Transactions trans = mapper.readValue(json, Transactions.class);
            if (codesDao.getbycode(trans.getCode()) == null) {
                Codes codes = new Codes();
                codes.setCode(trans.getCode());
                codesDao.save(codes);
                transDao.save(trans);
            }
            else
            {
                transDao.update(trans);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok().build();
    }

*//**
 * с возможность вывести все статусы по определенному коду = 11 *
 *  curl -i localhost:8080/service/11
 **//*
    @GetMapping("/{code}")
    //@ResponseBody
    public ResponseEntity<String> email(@PathVariable String code) {
        if (code.equals("11")){
           List<Transactions> all =  transDao.findAllStatus();
            String responseBody = all.stream()
                    .map(m ->  m.getStatus() )
                    .collect(Collectors.joining("\n"));

            return ResponseEntity.ok().body(responseBody);
        }

        return ResponseEntity.badRequest().body("Неверный код");
    }*/
}

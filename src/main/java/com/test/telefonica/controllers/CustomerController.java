package com.test.telefonica.controllers;

import com.test.telefonica.entities.CustomerEntity;
import com.test.telefonica.services.CustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("customer")
public class CustomerController extends BaseControllerImpl<CustomerEntity, Long> implements BaseController<CustomerEntity, Long> {

    private final CustomerService customerService;

    public CustomerController(CustomerService service) {
        super(service);
        customerService = service;
    }

    @PostMapping("list-by-document-number-and-document-type")
    public ResponseEntity<?> listByDocumentNumberAndDocumentType(@RequestBody Map<String, String> body) {
        String documentNumber, documentType;
        try {
            documentNumber = body.get("documentNumber");
            documentType = body.get("documentType");
            return new ResponseEntity<>(customerService.listByDocumentNumberAndDocumentType(documentNumber, documentType), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("There was an error on the server", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("list-by-offer-date")
    public ResponseEntity<?> listByOfferDate(@RequestBody Map<String, Date> body) {
        Date dateFrom, dateTo;
        try {
            dateFrom = body.get("dateFrom");
            dateTo = body.get("dateTo");

            assert dateFrom != null: "Date from is null";
            assert dateTo != null: "Date to is null";

            return new ResponseEntity<>(customerService.listByOfferDate(dateFrom, dateTo), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("There was an error on the server", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

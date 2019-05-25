package ru.mithril.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mithril.demo.service.serviceInterface.DocumentService;
import ru.mithril.demo.view.DocumentView;
import ru.mithril.demo.view.operations.document.ListDocument;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "DocumentController", description = "Управление информацией о документах")
@RestController
@RequestMapping(value = "/document", produces = APPLICATION_JSON_VALUE)
public class DocumentController {


    @Autowired
    private final DocumentService documentService;
    public static final Logger logger = LoggerFactory.getLogger(DocumentController.class);
    @RequestMapping("/")
    @ResponseBody
    public String welcome(){
        return "Welcome to RestTemplate Example";
    }

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @ApiOperation(value = "Получить список всех документов", httpMethod = "GET")
    @GetMapping("/list")
    public List<DocumentView> get(@Validated(ListDocument.class) @RequestBody DocumentView documentView) {
        return documentService.doc(documentView);
    }

}

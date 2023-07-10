package com.example.storage_project.controller;

import com.example.storage_project.model.Address;
import com.example.storage_project.model.Contractors;
import com.example.storage_project.model.Document;
import com.example.storage_project.model.DocumentDetails;
import com.example.storage_project.service.DocDetailsService;
import com.example.storage_project.service.DocumentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/documents")
public class DocumentsController {
    private final DocumentsService documentsService;
    private final DocDetailsService docDetailsService;

    public DocumentsController(DocumentsService documentsService, DocDetailsService docDetailsService) {
        this.documentsService = documentsService;
        this.docDetailsService = docDetailsService;
    }

    @GetMapping
    public String getAllDocuments(Model model, @RequestParam("invoice_type") Long invoiceType) {
        List<Document> documents = documentsService.getAllDocuments(invoiceType);
        model.addAttribute("documents", documents);
        return "documents";
    }

    }
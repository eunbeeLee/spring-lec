package com.practice.spring.uploadfiles;

import com.practice.spring.uploadfiles.storage.StorageFileNotException;
import com.practice.spring.uploadfiles.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.stream.Collectors;

@Controller
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService){
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String listUploadFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toUri().toString())
        .collect(Collectors.toList()));

        return "uploadForm";
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file")MultipartFile file,
                                   RedirectAttributes redirectAttributes){

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded" +
                file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotException exc){
        return ResponseEntity.notFound().build();
    }
}

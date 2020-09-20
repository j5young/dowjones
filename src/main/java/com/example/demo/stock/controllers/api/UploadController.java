package com.example.demo.stock.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.stock.FileUploadException;
import com.example.demo.stock.services.api.UploadService;

@Controller
public class UploadController {

    @Autowired
    UploadService uploadService;

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

    	try {
			uploadService.uploadFile(file);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message",
		            e.getMessage());

	        return "redirect:/";
		}

        redirectAttributes.addFlashAttribute("message",
            "Successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }
}

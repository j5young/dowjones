package com.example.demo.stock.services.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.stock.FileUploadException;

@Service
public class UploadService {

    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;
    @Value("${spring.datasource.url}")
    public String connUrl; 
    @Value("${spring.datasource.username}")
    public String user; 
    @Value("${spring.datasource.password}")
    public String pwd;  

    public void uploadFile(MultipartFile file) throws FileUploadException {
    	Path copyLocation;

        try {
            copyLocation = Paths
                .get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileUploadException("Could not store file " + file.getOriginalFilename()
                + ". Please try again!");
        }
        
        //import into Database
        try (Connection conn = DriverManager.getConnection(connUrl, user, pwd)) {
            long rowsInserted = new CopyManager((BaseConnection) conn)
                    .copyIn(
                        "COPY \"StockData\" FROM STDIN WITH CSV", 
                        new BufferedReader(new FileReader(copyLocation.toString()))
                        );
            System.out.printf("%d row(s) inserted%n", rowsInserted);
        }catch (Exception e) {
            e.printStackTrace();
            throw new FileUploadException("Could not import bulk data file " + file.getOriginalFilename()
                + ". Please try again!");
        }
    }
}

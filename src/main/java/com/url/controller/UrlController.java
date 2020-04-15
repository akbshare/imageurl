package com.url.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UrlController {
    @RequestMapping(value = "/share/{image}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_PNG_VALUE)
            //produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable String image) throws IOException {
        //var imgFile = new ClassPathResource("images/corona-two.jpeg");
        //ClassPathResource imgFile = new ClassPathResource("images/image-one.png");
        ClassPathResource imgFile = new ClassPathResource("images/"+image);
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(bytes);
    }
}

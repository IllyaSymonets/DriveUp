package com.softserve.brain.contoller;

import com.softserve.brain.dto.CustomerDTO;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "/brain")
public class BrainController {
    private final OkHttpClient httpClient = new OkHttpClient();

    @PostMapping(path = "/registration", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getArgs(@RequestBody CustomerDTO dto) throws IOException {
        FormBody formBody = new FormBody.Builder()
                .add("phone", dto.getPhone())
                .add("password", dto.getPassword())
                .build();

        Request request = new Request.Builder()
                .url("http://localhost:8761/driveUp/customer/customers/save")
                .addHeader("User-Agent", "OkHttp Bot")
                .post(formBody)
                .header("Content-Type", "application/json; charset=UTF-8")
                .build();
        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}

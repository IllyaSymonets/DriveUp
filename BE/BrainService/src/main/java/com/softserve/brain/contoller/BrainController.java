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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "/brain")
public class BrainController {
    private final OkHttpClient httpClient = new OkHttpClient();
    @PostMapping(path = "/registration", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getArgs(@org.springframework.web.bind.annotation.RequestBody CustomerDTO dto) throws IOException {
//        URL url = new URL("http://localhost:8086/driveUp/customer/customers/save");
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("POST");

//        HttpPost post = new HttpPost("http://localhost:8761/driveUp/customer/customers/save");
//        List<NameValuePair> urlParams = new ArrayList<>();
//        urlParams.add(new BasicNameValuePair("phone", dto.getPhone()));
//        urlParams.add(new BasicNameValuePair("password", dto.getPassword()));
//
//        System.out.println(urlParams);
//
//        post.setEntity(new UrlEncodedFormEntity(urlParams));

//        try (CloseableHttpClient httpClient = HttpClients.createDefault();
//             CloseableHttpResponse response = httpClient.execute(post)) {
//
//            System.out.println(EntityUtils.toString(response.getEntity()));
//        }
        FormBody formBody = new FormBody.Builder()
                .add("phone", dto.getPhone())
                .add("password", dto.getPassword())
                .build();

        Request request = new Request.Builder()
                .url("http://localhost:8761/driveUp/customer/customers/save")
                .addHeader("User-Agent", "OkHttp Bot")
                .post(formBody)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}

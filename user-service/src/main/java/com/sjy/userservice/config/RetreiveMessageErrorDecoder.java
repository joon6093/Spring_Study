package com.sjy.userservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;

import java.io.IOException;
import java.io.InputStream;

public class RetreiveMessageErrorDecoder implements ErrorDecoder {
    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        ExceptionMessage message = null;
        try (InputStream bodyIs = response.body().asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(bodyIs, ExceptionMessage.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }
        return switch (response.status()) {
            case 400 -> new BadRequestException(message.getMessage() != null ? message.getMessage() : "Bad Request");
            case 404 -> new NotFoundException(message.getMessage() != null ? message.getMessage() : "Not found");
            default -> errorDecoder.decode(methodKey, response);
        };
    }
}

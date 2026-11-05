package com.adam.message.functions;

import com.adam.message.dto.VoitureMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunctions {

    private static final Logger log = LoggerFactory.getLogger(MessageFunctions.class);

    @Bean
    public Function<VoitureMessageDto, VoitureMessageDto> email() {
        return voitureMessageDto -> {
            log.info("Sending email with the details : {}", voitureMessageDto);
            return voitureMessageDto;
        };
    }

    @Bean
    public Function<VoitureMessageDto, Long> sms() {
        return voitureMessageDto -> {
            log.info("Sending sms with the details : {}", voitureMessageDto);
            return voitureMessageDto.voitureId();
        };
    }
}

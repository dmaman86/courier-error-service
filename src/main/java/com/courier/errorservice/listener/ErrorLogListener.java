package com.courier.errorservice.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.courier.errorservice.objects.dto.ErrorLogDto;
import com.courier.errorservice.objects.entity.ErrorLog;
import com.courier.errorservice.objects.mapper.ErrorLogMapper;
import com.courier.errorservice.repository.ErrorLogRepository;

@Service
public class ErrorLogListener {

  @Autowired private ErrorLogRepository errorLogRepository;

  @Autowired private ErrorLogMapper errorLogMapper;

  @KafkaListener(
      topics = "error-topic",
      groupId = "error-service-group",
      containerFactory = "kafkaListenerContainerFactory")
  public void listen(ErrorLogDto errorLogDto) {
    ErrorLog errorLog = errorLogMapper.toEntity(errorLogDto);
    errorLogRepository.save(errorLog);
  }
}

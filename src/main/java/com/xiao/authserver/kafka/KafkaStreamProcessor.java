package com.xiao.authserver.kafka;

import com.xiao.authserver.config.AppConfig;
import com.xiao.authserver.dto.UserSyncDto;
import com.xiao.authserver.serdes.UserSyncSerde;
import com.xiao.authserver.service.UserSyncService;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class KafkaStreamProcessor {

  private final AppConfig appConfig;

  private final UserSyncService userSyncService;

    public KafkaStreamProcessor(AppConfig appConfig, UserSyncService userSyncService) {
        this.appConfig = appConfig;
        this.userSyncService = userSyncService;
    }
  @Bean
  public KStream<String, UserSyncDto> kStream(StreamsBuilder streamsBuilder) {

    KStream<String, UserSyncDto> stream =
        streamsBuilder.stream(
            appConfig.getUserSyncTopic(), Consumed.with(Serdes.String(), new UserSyncSerde()));

    stream.peek(userSyncService::processSyncUser);

    return stream;
  }
}

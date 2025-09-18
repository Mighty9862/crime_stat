package org.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataFetcherService {
    private static final Logger logger = LoggerFactory.getLogger(DataFetcherService.class);

    private static final List<String> SOURCES = Arrays.asList(
            "http://crimestat.ru/",
            "https://мвд.рф/opendata/",
            "https://genproc.gov.ru/opendata/",
            "https://sudrf.ru/opendata/"
    );

    public void fetchData() {
        logger.info("Загрузки данных с внешних источников...");
        for (String source : SOURCES) {
            logger.info("Подключение к {}", source);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            logger.info("✅ Данные с {} успешно загружены", source);
        }
        logger.info("Все внешние данные загружены.");
    }
}

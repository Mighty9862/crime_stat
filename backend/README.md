# Crime API

Приложение для загрузки и анализа данных о преступлениях по регионам РФ.  
Написано на **Java 22 + Spring Boot 3 + PostgreSQL**.

## Возможности
- Загрузка данных из XML-файлов (`src/main/resources/data/*.xml`) в PostgreSQL
- REST API для получения:
    - всех данных (`/api/crimes/all`)
    - экстремизм (`/api/crimes/extremism`)
    - особые (`/api/crimes/osob`)
    - терроризм (`/api/crimes/terrorism`)
    - оружие (`/api/crimes/weapon`)
    - сумма (`/api/crimes/total`)
- Swagger UI для тестирования API
- Настроен глобальный **CORS** (любой фронтенд может обращаться к API)

## Требования
- Java 22
- Maven 3.9+
- PostgreSQL (создать базу `crime_db`)

## Настройка
1. В `src/main/resources/application.properties` укажите свои доступы к БД:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/crime_db
   spring.datasource.username=test
   spring.datasource.password=test

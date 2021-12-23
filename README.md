### Реализованная функциональность
- Регистрация/авторизация
- CRUD API для всех сущностей
- Прохождение тестов

### Стек технологий
- Git, Docker
- Java 11, Spring Boot, PostgreSQL

### Задание:
Система тестирования
1. Администратор
   1. Составление списка групп студентов
   2. Составление списка дисциплин
   3. Вывод результатов тестирования
2. Преподаватель
   1. Подготовка списка вопросов для тестирования и вариантов ответов на каждый тест.
      1. Правильным может быть один или несколько ответов
3. Студент
   1. Регистрация в системе
   2. Прохождение тестирования

### Среда запуска
1. Развертывание производится в любой системе с поддержкой docker engine 
2. Для сборки backend все образы указаны в docker-compose файле

### Установка

````
docker run regyl/testing-system:latest
````

Далее переходим в папку с файлом docker-compose

````
docker-compose up -d
````
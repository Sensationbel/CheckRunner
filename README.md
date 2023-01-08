# CheckRunner
Приложение выводит в консоль, текстовый файл или localhost:8080 кассовый чек по заданным параметрам id, quantity и card numb.
Параметр запроса должен соответствоват шаблону - 3-1 2-5 5-1 card-1234

Для запуска приложения произвести настройки соединения с Вашей базой данных в application.yml 

Пример запуска приложения из консолию
- java -jar ...\shop_receipt-0.0.1-SNAPSHOT.jar 3-1 2-5 5-1 card-1234 - выводит чек в консоль
- java -jar ...\shop_receipt-0.0.1-SNAPSHOT.jar ....\data.txt - выводит чек в файл (В application.yml нужно указать путь к папке сохранения)
- java -jar ...\shop_receipt-0.0.1-SNAPSHOT.jar
 
Запущенное приложение позволяет вводить параметры и выводить результат на экран браузера по адресу localhost:8080.

В приложении используются SpringBoot, PostgreSql, Liquibase, Thymeleaf, Lombok.

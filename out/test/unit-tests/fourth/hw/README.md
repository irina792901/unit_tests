### 1) Почему использование тестовых заглушек может быть полезным при написании модульных тестов?

   Причин несколько:
* Изоляция тестируемого модуля от его зависимостей от остального кода. Это позволяет более четко выделить место ошибки.  
* Повторяемость, надежность  и скорость написания тестов: используются одни и те же конструкции для создания тестов
* Гибкость: можно настраивать заглушку, чтобы она возвращала определенное значение или имитировала определенное поведение. Например, можно сымитировать подключение к базе данных или веб-сервису. Поэтому можно отследить реакцию модуля на различные сценарии.

В итоге использование заглушек при написании модульных тестов приводит к улучшению качества программного обеспечения.  
 
### 2) Какой тип тестовой заглушки следует использовать, если вам нужно проверить, что метод был вызван с определенными аргументами?

Stub

### 3) Какой тип тестовой заглушки следует использовать, если вам просто нужно вернуть определенное значение или исключение в ответ на вызов метода?

Mock

### 4) Какой тип тестовой заглушки вы бы использовали для имитации  взаимодействия с внешним API или базой данных?

Fake, Mock

# par-lab4

1. Создаем actor system
2. В приложении будем использовать следующие акторы :
   - актор который хранит результаты тестов.
      Обрабатывает следующие сообщения :
      - cообщение с результатом одного теста → кладет его в локальное хранилище.
      - cообщение с запросом результата теста → отвечает сообщением с результатом всех тестов для заданного packageId
   - актор который исполняет один тест из пакета.
      Для исполнения JS кода можно воспользоваться следующим примером
      ```java
      ScriptEngine engine = new
      ScriptEngineManager().getEngineByName("nashorn");
      engine.eval(jscript);
      Invocable invocable = (Invocable) engine;
      return invocable.invokeFunction(functionName, params).toString();
      ```
      После исполнения теста результат передается актору хранилищу
   - актор роутер
      инициализирует актор хранилище а также пул акторов исполнителей тестов
3. После инициализации actor system — создаем актор роутер который в свою
очередь создает все дочерние акторы
4. Создаем `ActorMaterializer` и инициализируем `http` систему с помощью
`high level api`
5. Cтроим дерево route и пишем обработчики запросов.
6. Когда приходит запрос на запуск теста — запускаем тест и сразу
овтечаем константным ответом.
7. В случае запроса на получение информции о тесте — используем
`Putterns.ask` и возвращаем `Future` с ответом

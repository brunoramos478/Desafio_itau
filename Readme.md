# Suposto desafio Itaú

O desafio propôs criar uma **API REST** que recebe transações e retorna estatísticas sobre essas transações. Para este desafio, a API foi desenvolvida utilizando **Java** e **Spring Boot**.

## Minhas Decisões Técnicas

* **Virtual Threads:** Proporcionam um melhor gerenciamento da aplicação ao todo, pois, diferente da abordagem tradicional (que é considerada pesada), as threads virtuais são extremamente leves, permitindo que a aplicação lide com muito mais usuários de forma mais eficiente.
<br>
<br>
* **ConcurrentLinkedDeque:** Escolhido para o armazenamento em memória, pois não sofre com ações bloqueantes de forma severa, garantindo o **thread-safety** necessário para operações simultâneas.
<br>
<br>
* **Global Handler:** Decidi utilizar para a centralização de erros junto com o `@ControllerAdvice`, garantindo a conformidade da aplicação e respeitando rigorosamente o enunciado do desafio.
<br>
<br>
* **DTO:** Decidi utilizar o padrão **DTO** aliado ao `@Lombok` para reduzir o **boilerplate** e deixar a aplicação muito mais limpa e legível.

## Tech Stack

* **Java 25**
* **Spring Boot 4.0.6**
* **Maven**
* **Validation**
* **Spring Web**
* **Lombok**
* **Actuator**
* **Dev Tools**

---
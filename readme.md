# 💱 Conversor de Moedas - Java + ExchangeRate API

Projeto simples em **Java** que consome a [ExchangeRate API](https://www.exchangerate-api.com/) para realizar conversões de moedas. O programa solicita ao usuário a moeda de origem, a moeda de destino e o valor a ser convertido, exibindo o resultado.

---

## Funcionalidades

* Obtenção de taxas de câmbio em tempo real.
* Entrada de dados pelo usuário:

    * Moeda de origem (ex.: USD, BRL, EUR)
    * Moeda de destino
    * Valor a converter
* Exibição do valor convertido no console.
* Mapeamento da resposta da API para classes Java usando JSON.

---

## Tecnologias Utilizadas

* **Java 17+**
* **Gson** (desserialização JSON)
* **HttpURLConnection** (requisições HTTP)
* **ExchangeRate API** (taxas de câmbio)

---

## Estrutura do Projeto

```
src/
 ├── Main.java                # Classe principal que executa o programa
 └── model/
      ├── Moeda.java          # Classe que armazena dados da moeda e realiza conversão
      └── MoedaAPI.java       # Classe que representa o JSON retornado pela API
```

---

## Como Usar

1. **Obtenha uma chave da API** gratuitamente em:
   [https://www.exchangerate-api.com/](https://www.exchangerate-api.com/)
2. **Clone este repositório**:

   ```bash
   git clone https://github.com/EnricoCB/conversor-de-moedas.git
   cd conversor-de-moedas
   ```
3. **Compile e execute**:

   ```bash
   javac -cp gson-2.10.1.jar src/*.java src/model/*.java -d out
   java -cp gson-2.10.1.jar:out Main
   ```
4. **Exemplo de uso**:

   ```
   Informe a moeda de origem (ex.: USD): USD
   Informe a moeda de destino (ex.: BRL): BRL
   Informe o valor: 100
   Resultado: 100 USD = 543.34 BRL
   ```

---

## Observações

* Necessário **Java 17+**.
* É preciso conexão com a internet.
* Verifique se sua chave de API está ativa caso ocorra erro.

---

##

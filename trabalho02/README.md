# Cálculo do número de Euler

## Sobre
Repositório destinado para as implementações utilizadas no estudo sobre programação concorrente. O objetivo é projetar e implementar uma solução concorrente para o cálculo do número *Euler (e)* mediante uma série infinita utilizando threads independentes e concorrentes. 

Foram implementadas três versões diferentes do mesmo programa, no qual foram utilizados, para gerenciamento das threads que executarão as tarefas definidas para o programa, thread pools de diferentes tipos disponibilizados pelo *framework Executor* e sua classe Executors, que foram: *fixed*, *cached* e *work stealing thread pools*.


## Ferramentas utilizadas

As ferramentas utilizadas foram: 

- Java 11.0.16

## Execução

Para execução deve ser fornecida como entrada, em todas as versões do programa, *fixed*, *cached* e *workstealing*, o número de termos que determina a aproximação a ser calculada. No programa *fixed* também é necessário fornecer como entrada um número predefinido de threads a serem utilizadas.

1. Para compilar as classes em Java:

```bash
javac trabalho02/src/nome-da-versao/Main.java
```

2. Para realizar a execução no console, utilize os seguintes comandos na versão *fixed*:

```bash
java trabalho02/src/nome-da-versao/Main <numero-de-termos> <numero-de-threads>
```

Ou utilize os seguintes comandos nas versões *cached* e *workstealing*:

```bash
java trabalho02/src/nome-da-versao/Main <numero-de-termos>
```


## Desenvolvedoras
- [Neylane Lopes](https://github.com/neylanepl) 
- [Raíssa Santos](https://github.com/raixasantos)
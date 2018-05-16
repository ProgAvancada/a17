# Resolução do exercício de Reflection e Annotations


Nesta aula, apresentamos a solução do exercício da aula de reflection, mostrando um caso prático e real do uso da 
tecnologia.

O exercício propunha a criação de uma tabela, em modo texto, que imprimisse os dados de uma lista contendo um objeto de 
uma classe qualquer. É importante destacar que um dos objetivos desse desafio era separar duas lógicas:

1. A do desenho da tabela
1. A dos dados que a tabela contém

Ou seja, a classe que desenha a tabela deve ser capaz de se adaptar a diferentes fontes de dados, sem que as classes de 
negócio pertencentes a essa fonte precisem implementar uma interface ou fornecer métodos para isso.

Ao mesmo tempo, deve-se permitir ao usuário configurar regras de formatação e quais campos da classe serão impressos. 
Por fim o exercício pede para gerar duas tabelas, com duas fontes de dados distintas, contendo classes não relacionadas.

## Reflection

A solução se deu utilizando o recurso de Reflection. Esse recurso permite inspecionar uma classe, perguntando a ela 
quais atributos ou métodos possuem. Este uso é feito no 
[método inspect](https://github.com/ProgAvancada/a17/blob/master/src/br/pucpr/annotations/Table.java#L12-L34) da classe 
[Table](https://github.com/ProgAvancada/a17/blob/master/src/br/pucpr/annotations/Table.java).

Observe nesse método o uso do método getClass() e de classes como 
[Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html) e 
[Field](https://docs.oracle.com/javase/8/docs/api/java/lang/Field.html).

## Annotations

Foi criada as anotations [@Column](https://github.com/ProgAvancada/a17/blob/master/src/br/pucpr/annotations/Column.java)
e [@Header](https://github.com/ProgAvancada/a17/blob/master/src/br/pucpr/annotations/Header.java) que permitem marcar 
quais campos da classe irão aparecer na tabela e quais terão cabeçalho impresso. Além disso, as anotações permitem 
definir configurações. Observe novamente o 
[método inspect](https://github.com/ProgAvancada/a17/blob/master/src/br/pucpr/annotations/Table.java#L12-L34)
para verificar seu uso.

As informações são usadas para gerar objetos da classe 
[TableColumn](https://github.com/ProgAvancada/a17/blob/master/src/br/pucpr/annotations/TableColumn.java)
que são posteriormente usados para desenhar a tabela.

## Resolução sem annotations

Verifique também a resolução deste problema sem o uso do recurso de annotations, através do padrão 
[DataMapper](https://github.com/ProgAvancada/a17-02) (DataSource).

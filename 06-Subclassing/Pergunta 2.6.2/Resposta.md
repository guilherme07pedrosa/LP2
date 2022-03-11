
Vou citar como resposta um código bem simples descrito nos exemplos da IDE BlueJ;
disponível em:
https://www.bluej.org
Após o dowload deste programa são disponbilizados exemplos, vou utilizar o exemplo  do cadatro de estudantes e funcionários em uma escola. Esse código consiste de uma superclasse abstrata chamada de "People" e duas concretas "Students" e "Staff". Esses objetos "herdam" da superclasse duas características em comumtem em comum 
    String name (nome que é uma string)
   int yearOfBirth (idade que é um inteiro)

Ao se cadstrar os objetos que podem ser "Students" ou "Staff" a s "Database" vai sendo construida e os objetos imediatamante mostrados  na bancada de objetos. Observe a parte do código da "Database"

/**
     * List all the persons currently in the database on standard out.
     */
    public void listAll () 
    {
        for (Iterator i = persons.iterator(); i.hasNext();) {
            System.out.println(i.next());
        }
        
   Observe que na linha 13 não há a especificação se o objeto a ser mostrado na bancada de objetos  é um "Student" ou "Staf" o método ja "sabe" se este objeto é um  "Staf" ou um "Student". 
   Esse é um exemplo do Despacho Dinâmico. 
   Os códigos e a UML estão mostrados na resposta. 

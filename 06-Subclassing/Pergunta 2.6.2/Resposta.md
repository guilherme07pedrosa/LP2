
Vou cita como exemplo um código bem simples descrito nos exemplos da IDE BlueJ;
disponível em:
https://www.bluej.org
Após o dowload deste IDE são disponbilizados exemplos, vou utilizar o de cadatro de estudantes e funcionários em uma escola.Esse código consiste de uma classe abstrata chamada de "People" e duas concretas "Students" e "Staff". Esses objetos tem em commum as características nome = String"e data de aniversario  - int.  Ao se cadstrar os objetos que podem ser "Students" ou "Staff" a superclasse "Database" vai sendo construida e os objetos imediatamante impresso na tela. Observe a parte do código da superclasse "Database"

/**
     * List all the persons currently in the database on standard out.
     */
    public void listAll () 
    {
        for (Iterator i = persons.iterator(); i.hasNext();) {
            System.out.println(i.next());
        }
        
   Observe que na linha 13 não há a especificação se o objeto a ser impresso na tela é um "Student" ou "Staf" o método ja "sabe" trata-se de um "Staf" ou um "Student". 
   Esse é um exemplo do Despacho Dinâmico. 
   Os códigos e a UML estão mostrados na resposta. 

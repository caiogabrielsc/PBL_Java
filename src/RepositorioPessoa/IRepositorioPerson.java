package RepositorioPessoa;
import  Entity.Person;

public interface IRepositorioPerson {

    // AQUI VAI TER SÓ CHAMADA PARA AS FUNÇOES FEITAS NO REPOSITÓRIO.JAVA
    public boolean savePerson(Person person);
    public int findPersonById(int id);
    public boolean editNamePerson(int idbuscado, String newName);


    //public boolean deletePerson(int id);
    //public List<Person> listPerson();
    //public boolean alterPerson(Person person);


}

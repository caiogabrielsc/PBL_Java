package Repositorio;
import java.util.List;
import  Entity.Person;

public interface IRepositorio {
    // AQUI VAI TER SÓ CHAMADA PARA AS FUNÇOES FEITAS NO REPOSITÓRIO
    public boolean savePerson(Person person);
    public int findPersonById(int id);
    //public boolean deletePerson(int id);
    //public List<Person> listPerson();
    //public boolean alterePerson(Person person);


}

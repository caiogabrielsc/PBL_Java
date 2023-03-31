package Entity;

public class Person {

    protected int id;
    protected String name;
    /*
    protected String age;
    protected String cpf;
    protected String email;
    protected String adress;

     */

    public Person(int id, String name ){ // String age, String cpf, String email, String adress */) {
        this.id = id;
        this.name = name;
        /*
        this.age = age;
        this.cpf = cpf;
        this.email = email;
        this.adress = adress;

         */

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /*
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

     */
}

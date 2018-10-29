public class Employee {
    private int id;
    private String firstName;
    private String lasName;
    private int salary;

    public Employee(int id, String firstName, String lasName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lasName = lasName;
        this.salary = salary;
    }

    public int getID() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLasName() {
        return lasName;
    }

    public String getName() {
        return firstName + ' ' + lasName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary(){
        return salary * 12;
    }

    public int raiseSalary(int percent){
        salary = salary * (100 + percent) / 100;
        return salary;
    }

    @Override
    public String toString() {
        return "Employee[id=" + id + ",name=" + getName() +
                ",salary=" + salary + "]";
    }
}

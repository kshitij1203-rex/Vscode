package com.example.demo;


import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Location;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LocationRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
    private  DepartmentRepository departmentRepository;

	@Autowired
    private  EmployeeRepository employeeRepository;

	@Autowired
    private  LocationRepository locationRepository;

 

    public DemoApplication(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository,
			LocationRepository locationRepository) {
		this.departmentRepository = departmentRepository;
		this.employeeRepository = employeeRepository;
		this.locationRepository = locationRepository;
	}

	@Override
	public void run(String... args) throws Exception {
        // Create and save default Location
        Location L1 = new Location("New York", "123 Main St", "10001", "NY", "USA");
        locationRepository.save(L1);

		Location L2 = new Location("Lodon", "456 High St", "SW1A 1AA", "ENGLAND", "UNITED KINGDOM");
        locationRepository.save(L2);

		Location L3 = new Location("Tokyo", "789 Sakura St", "100-0000", "Tokyo", "JAPAN");
        locationRepository.save(L3);

		Location L4 = new Location("Banglore", "123 Bangalore Blvd", "560001", "Karnataka", "INDIA");
        locationRepository.save(L4);


 		// Create and save default Department
        Department d1 = new Department("Human Resource", null , L1 );
        d1=departmentRepository.save(d1);

		Department d2 = new Department("Information Technology", null , L2 );
       d2= departmentRepository.save(d2);

		Department d3 = new Department("Sales", null , L3 );
        d3=departmentRepository.save(d3);

		Department d4 = new Department("Analyst", null , L4 );
        d4 = departmentRepository.save(d4);
		



       // Create and save default Employee (Manager)
        Employee m1 = new Employee("John", "Doe", 101, "john.doe@gmail.com", "123-456-7890", LocalDate.of(2020, 1, 15), "Manager", BigDecimal.valueOf(80000), BigDecimal.valueOf(0.1), d1);
        m1=employeeRepository.save(m1);
		d1.setEmp(m1);
		departmentRepository.save(d1);

		Employee m2 = new Employee("Sophia", "Williams", 105, "sophia.williams@gmail.com", "444-333-2222", LocalDate.of(2023, 6, 10), "Analyst", BigDecimal.valueOf(65000), BigDecimal.valueOf(0.05), d2);
		m2=employeeRepository.save(m2);
		d2.setEmp(m2);
		departmentRepository.save(d2);

		Employee m3 = new Employee("Michael", "Johnson", 103, "michael.johnson@gmail.com", "555-555-5555", LocalDate.of(2019, 4, 10), "Engineer", BigDecimal.valueOf(70000), BigDecimal.valueOf(0.08), d3);
		m3=employeeRepository.save(m3);
		d3.setEmp(m3);
		departmentRepository.save(d3);

		Employee m4 = new Employee("Emily", "Brown", 104, "emily.brown@gmail.com", "111-222-3333", LocalDate.of(2022, 3, 5), "Designer", BigDecimal.valueOf(75000), BigDecimal.valueOf(0.07), d4);
		m4=employeeRepository.save(m4);
		d4.setEmp(m4);
		departmentRepository.save(d4);
		

	
	}
}

       
		

		

        // Create and save default Employees



        // Associate employees with the department
      
	//         for (Employee employee : E1) {
    //         d2.addEmployee(employee);
    //     }
    

    // private List<Employee> generateDefaultEmployees2(Department department) {
    //    List<Employee> employee = new ArrayList<>();
    //     employee.add(new Employee("Liam", "Martinez", 208, "liam.martinez@example.com", "222-333-4444", LocalDate.of(2022, 6, 15), "Designer", BigDecimal.valueOf(57000), BigDecimal.valueOf(0.03), department));
	// 	employee.add(new Employee("Isabella", "Rodriguez", 209, "isabella.rodriguez@example.com", "888-999-0000", LocalDate.of(2020, 7, 20), "Manager", BigDecimal.valueOf(80000), BigDecimal.valueOf(0.1), department));
	// 	employee.add(new Employee("James", "Garcia", 210, "james.garcia@example.com", "111-222-3333", LocalDate.of(2021, 9, 5), "Engineer", BigDecimal.valueOf(72000), BigDecimal.valueOf(0.08), department));
    //     return employee;
    // }



        // Associate employees with the department
//        for (Employee employee : E2) {
//            d2.addEmployee(employee);
//        }
    



//	    private List<Employee> generateDefaultEmployees2(Department department) {
//        List<Employee> employee = new ArrayList<>();
//        employee.add(new Employee("Liam", "Martinez", 208, "liam.martinez@example.com", "222-333-4444", LocalDate.of(2022, 6, 15), "Designer", BigDecimal.valueOf(57000), BigDecimal.valueOf(0.03), department));
//		employee.add(new Employee("Isabella", "Rodriguez", 209, "isabella.rodriguez@example.com", "888-999-0000", LocalDate.of(2020, 7, 20), "Manager", BigDecimal.valueOf(80000), BigDecimal.valueOf(0.1), department));
//		employee.add(new Employee("James", "Garcia", 210, "james.garcia@example.com", "111-222-3333", LocalDate.of(2021, 9, 5), "Engineer", BigDecimal.valueOf(72000), BigDecimal.valueOf(0.08), department));
//        return employee;
		

//}




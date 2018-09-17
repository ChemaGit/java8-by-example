package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import com.example.domain.Admin;
import com.example.domain.Director;
import com.example.domain.Employee;
import com.example.domain.Engineer;
import com.example.domain.Gender;
import com.example.domain.Manager;

public class EmployeeTestLambda {

	public static void main(String[] args) {
		Employee e1 = new Engineer(101,"Jane Smith","012-34-5678",120_345.27,"Industry",Gender.FEMALE);		
		Employee e2 = new Engineer(102,"Twin Jane Smith","012-34-5679",122_345.27,"Bank", Gender.FEMALE);
		Employee mgr = new Manager(207, "Barbara Johnson", "054-12-2367", 109_501.36, "US Marketing",Gender.FEMALE);		
		Employee ad1 = new Admin(304, "Bill Munroe", "108-23-6509",75_002.34,"Juridic", Gender.MALE);	
		Employee ad2 = new Admin(305, "Victoria Givens", "108-23-6511",90_002.34,"Rrhh",Gender.FEMALE);
		Employee ad3 = new Admin(306, "Diane Diamonds", "108-23-6516",85_002.34,"Clerk",Gender.FEMALE);
		Employee d1 = new Director(12,"Susan Wheeler","099-45-2340",125_567.36,"Global Marketing",1_000_000.00,Gender.FEMALE);		

		List<Employee> pl = Employee.createShortList(); 
		
		System.out.println("\n===Print List===");
		pl.forEach(p -> System.out.println(p));
		
		System.out.println("\n===Calling all drivers Lambda===");
		pl.stream().filter(p -> p.getId() > 100 && p.getId() < 300)
		.forEach(p -> System.out.println(p));
		
		System.out.println("\n===Calling all drivers Variable===");
		Predicate<Employee> allEngineersInd = p -> ((Manager)p).getDeptName().equalsIgnoreCase("INDUSTRY");
		pl.stream().filter(allEngineersInd).forEach(p -> System.out.println(p));
		
		System.out.println("\n===Gender Translations Lambda===");
		pl.stream().filter(p -> p.getGender().equals(Gender.FEMALE)).forEach(p -> p.printSummary());
		
		System.out.println("\n===Filters Chaining===");
		pl.stream().filter(p -> p.getGender().equals(Gender.FEMALE)).filter(allEngineersInd).forEach(p -> p.printSummary());
		pl.stream().filter(p -> p.getGender().equals(Gender.FEMALE) && 
				((Manager)p).getDeptName().equalsIgnoreCase("INDUSTRY")).forEach(p -> p.printSummary());
		
		System.out.println("\n===Lesson nine===");
		System.out.println("\n===Salary stream===");
		Employee first = pl.get(0);
		
		Predicate<Employee> allBestPaid = p -> p.getEmployeeSalary() > 50_000.00;
		pl.stream().filter(allBestPaid).forEach(p -> p.printSummary());
		
		System.out.println("\n===Salary stream. Same result===");
		for(Employee e : pl) {
			if(allBestPaid.test(e)) {
				e.printSummary();
			}
		}
		
		System.out.println("\n===Consumer example===");
		Consumer<Employee> NameAndGender = t -> System.out.println("NAME: " + t.getName() + "--GENDER: " + t.getGender());
		Consumer<List<Employee>> listNameGender = t -> t.forEach(NameAndGender);
		pl.stream().forEach(NameAndGender);
		System.out.println("\n===First Consumer===");
		NameAndGender.accept(first);
		
		System.out.println("\n===Consumer example List===");
		listNameGender.accept(pl);
		
		System.out.println("\n===Function example===");
		System.out.println("\n===First Employee===");
		Function<Employee, String> employeeFunction = t -> t.getName();
		System.out.println(employeeFunction.apply(first));
		
		System.out.println("\n===Supplier example===");
		Supplier<Employee> supplierEmployee = () -> new Manager(208, "Alicia Rhodes", "054-12-2369", 95_501.36, "UE Marketing",Gender.FEMALE);
		pl.add(supplierEmployee.get());
		pl.stream().forEach(t -> t.printSummary());
		
		System.out.println("\n===Primitive Interface example. ToDoubleFunction===");
		ToDoubleFunction<Employee> bonusEmployee = t -> t.getEmployeeSalary() * 0.02; 
		System.out.println(bonusEmployee.applyAsDouble(first));
		
		System.out.println("\n===Primitive Interface example. DoubleFunction===");
		DoubleFunction<String> calc = t -> String.valueOf(t * 3); 
		String result = calc.apply(20);
		System.out.println("\nThe new value is: " + result);
		
		System.out.println("\n===Interface BiPredicate Example===");
		String testState = "Jane Smith";
		BiPredicate<Employee,String> biPredicate = (t,s) -> t.getName().equals(testState);
		System.out.println(biPredicate.test(first, testState));
		
		System.out.println("\n===Interface UnaryOperator Example===");
		UnaryOperator<String> unaryStr = s -> s.toUpperCase();
		System.out.println(unaryStr.apply(first.getName()));
		
		System.out.println("\n===Lambda Operations===");
		
		System.out.println("\n===Example MAP Operations===");
		pl.stream().filter(p -> p.getGender().equals(Gender.FEMALE))
		.filter(allBestPaid)
		.map(e -> e.getEmployeeSalary() * 0.7)
		.forEach(s -> System.out.printf("Bonus paid: $%, 6.2f %n", s));
		
		System.out.println("\n===Example PEEK Operations===");
		pl.stream().filter(p -> p.getGender().equals(Gender.FEMALE))
		.filter(allBestPaid)
		.peek(e -> System.out.println("Name: " + e.getName() + "- Gender: " + e.getGender()))
		.map(e -> e.getEmployeeSalary() * 0.7)
		.forEach(s -> System.out.printf("Bonus paid: $%, 6.2f %n", s));		
		
		System.out.println("\n===Example findFirst Operations===");
		Optional<Employee> answer;
		answer = pl.stream().filter(p -> p.getGender().equals(Gender.FEMALE))
				.filter(allBestPaid)
				.findFirst();		
		if(answer.isPresent()) {
			answer.get().printSummary();
		}
		
		System.out.println("\n===Example findFirst Lazy Operations===");
		pl.stream()
		.peek(e -> System.out.println("Stream Start"))
		.filter(p -> p.getGender().equals(Gender.FEMALE))
		.peek(e -> System.out.println("Gender Female"))	
		.filter(allBestPaid)
		.peek(e -> System.out.println("All Woman Best Paid"))
		.map(e -> e.getEmployeeSalary() * 0.7)
		.forEach(s -> System.out.printf("Bonus paid: $%, 6.2f %n", s));	
		
		System.out.println("\n===Example findFirst Lazy Operations===");
		Optional<Employee> findFirst = pl.stream()
				.peek(e -> System.out.println("Stream Start"))
				.filter(p -> p.getGender().equals(Gender.FEMALE))
				.peek(e -> System.out.println("Gender Female"))	
				.filter(allBestPaid)
				.findFirst();		
		if(findFirst.isPresent()) {
			findFirst.get().printSummary();
		}		
		
		System.out.println("\n===Example anyMatch Operations===");
		Optional<Employee>resultFirst;
		if(pl.stream().anyMatch(p -> p.getGender().equals(Gender.FEMALE))){
			resultFirst = pl.stream()
					.peek(e -> System.out.println("Stream Start"))
					.filter(p -> p.getGender().equals(Gender.FEMALE))					
					.filter(allBestPaid)
					.findFirst();	
			if(resultFirst.isPresent()) {
				resultFirst.get().printSummary();
			}
		}
		
		System.out.println("\n===Example count Operations===");
		long execCount = pl.stream()
				.filter(p -> p.getGender().equals(Gender.FEMALE)) 
				.count();
		System.out.println("Female Count: " + execCount);
		
		System.out.println("\n===Example max Operations===");
		System.out.println("\n===Female Best Paid===");
		Optional<Employee> exampleMax = pl.stream()
				.filter(p -> p.getGender().equals(Gender.FEMALE))
				.max(Employee::sortBySalary);
		if(exampleMax.isPresent()) {
			System.out.printf("Name: " + exampleMax.get().getName() +
					"\nSalary paid: $%, 6.2f %n", exampleMax.get().getEmployeeSalary());
		}
		
		System.out.println("\n===Example min Operations===");
		System.out.println("\n===Female Worst Paid===");
		Optional<Employee> exampleMin = pl.stream()
				.filter(p -> p.getGender().equals(Gender.FEMALE))
				.min(Employee::lowestSalary);
		if(exampleMin.isPresent()) {
			System.out.printf("Name: " + exampleMin.get().getName() +
					"\nSalary paid: $%, 6.2f %n", exampleMin.get().getEmployeeSalary());
		}		
		
		System.out.println("\n===Female Worst Paid===");
		exampleMin = pl.stream()
				.filter(p -> p.getGender().equals(Gender.FEMALE))
				.min(Comparator.comparingDouble( e -> ((Employee)e).getEmployeeSalary()));
		if(exampleMin.isPresent()) {
			System.out.printf("Name: " + exampleMin.get().getName() +
					"\nSalary paid: $%, 6.2f %n", exampleMin.get().getEmployeeSalary());
		}	
		
		System.out.println("\n===Example sum Operations===");
		double exampleSum = pl.stream()
				.filter(p -> p.getGender().equals(Gender.FEMALE))
				.filter(allBestPaid)
				.peek(e -> System.out.print("Name: " + e.getName() + "-- Gender: " + e.getGender()))
				.mapToDouble(e -> e.getEmployeeSalary() * 0.7)
				.peek(d -> System.out.printf("--Bonus paid: $%, 6.2f %n", d))
				.sum();		
		 System.out.printf("Total Bonuses paid: $%, 6.2f %n", exampleSum);
		 
		 System.out.println("\n===Example Average Operations===");
		 OptionalDouble exampleAverage = pl.stream()
				.filter(p -> p.getGender().equals(Gender.FEMALE))
				.filter(allBestPaid)
				.peek(e -> System.out.print("Name: " + e.getName() + "-- Gender: " + e.getGender()))
				.mapToDouble(e -> e.getEmployeeSalary() * 0.7)
				.peek(d -> System.out.printf("--Bonus paid: $%, 6.2f %n", d))
				.average();		
		 if(exampleAverage.isPresent()) {
			 System.out.printf("Average Bonuses paid: $%, 6.2f %n", exampleAverage.getAsDouble());
		 }
		 
		 System.out.println("\n===Example Sorted Operations===");
		 pl.stream()
			.filter(p -> p.getGender().equals(Gender.FEMALE))
			.filter(allBestPaid)
			.mapToDouble(e -> e.getEmployeeSalary() * 0.7)
			.sorted()
			.forEach(d ->  System.out.printf("Bonuses paid: $%, 6.2f %n", d));
		 
		 System.out.println("\n===Example Sorted with Comparator Operations===");
		 pl.stream()
			.filter(p -> p.getGender().equals(Gender.FEMALE))
			.filter(allBestPaid)
			.sorted(Comparator.comparing(e -> e.getName()))
			.forEach(d -> d.printSummary());
		 
		 System.out.println("\n===Example Sorted Reversed with Comparator Operations. Doesn't work===");
		 pl.stream()
			.filter(p -> p.getGender().equals(Gender.FEMALE))
			.filter(allBestPaid)
			.sorted(Comparator.comparing(e -> e.getName()) )
			.forEach(d -> d.printSummary());
		 
		 System.out.println("\n===Example Sorted Two Level Sort with Comparator Operations. Doesn't work===");
		 pl.stream()
			.filter(p -> p.getGender().equals(Gender.FEMALE))
			.filter(allBestPaid)
			.sorted(Comparator.comparing(e -> e.getName()) )
			.forEach(d -> d.printSummary());
		 
		 System.out.println("\n===Example Collect Operations===");
		 List<Employee> nList = new ArrayList<Employee>();
		 nList = pl.stream()
			.filter(p -> p.getGender().equals(Gender.FEMALE))
			.filter(allBestPaid)	
			.sorted(Comparator.comparing(e -> e.getName()))
			.collect(Collectors.toList());		 
		 nList.stream()
		 .forEach(d -> d.printSummary());
		 
		 System.out.println("\n===Example Collectors and Math Operations===");
		 double avgSalary = pl.stream()
			.filter(p -> p.getGender().equals(Gender.FEMALE))
			.filter(allBestPaid)	
			.collect(Collectors.averagingDouble(d -> d.getEmployeeSalary()));
		 System.out.println("AVG Salary Employee");
		 System.out.printf("Average: $%,9.2f %n", avgSalary);
		 
		 System.out.println("\n===Example Collectors and Joinings Operations===");
		 String deptList = pl.stream()
				 .map(e -> ((Manager)e).getDeptName())
				 .distinct()
				 .collect(Collectors.joining(", "));
		 System.out.println("===Dep List===");
		 System.out.println("Total: " + deptList);
		 
		 System.out.println("\n===Example Collectors and Groupings Operations===");
		 Map<String, List<Employee>> gMap = new HashMap<String, List<Employee>>();
		 gMap = pl.stream()
				 .collect(Collectors.groupingBy(e -> ((Manager)e).getDeptName()));
		 System.out.println("===Employee by Dept===");
		 gMap.forEach((k,v) -> {System.out.println("\nDept: " + k);
		                        v.forEach(e -> e.printSummary());});
		 
		 System.out.println("\n===Example Collectors, Groupings and Countings Operations===");
		 Map<String, Long> gMap1 = new HashMap<String, Long>();
		 gMap1 = pl.stream()
				 .collect(Collectors.groupingBy(e -> ((Manager)e).getDeptName() ,Collectors.counting()) );		
		 System.out.println("===Count Employees by Dept===");
		 gMap1.forEach((k,v) -> System.out.println("Dept: " + k + "==Count: " + v));
		 
		 System.out.println("\n===Example Collectors, and Partitionings Operations===");
		 Map<Boolean, List<Employee>>gMap2 = new HashMap<Boolean, List<Employee>>();
		 gMap2 = pl.stream()
				 .collect(Collectors.partitioningBy(e -> ((Manager)e).getGender().equals(Gender.FEMALE)));
		 System.out.println("===Employees by Gender===");
		 gMap2.forEach((k,v) -> {System.out.println("\nGroup: " + (k == true ? Gender.FEMALE : Gender.MALE) ); 
		                        v.forEach(e -> e.printSummary());
		                        });
	}
}

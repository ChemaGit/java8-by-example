package com.animals;

import com.animals.domain.Cat;
import com.animals.domain.Fish;
import com.animals.domain.Spider;

public class PetMain {

	public static void main(String[] args) {
		Animal a;
		//Test a spider with a Spider reference
		Spider s = new Spider();
		s.eat();
		s.walks();
		//Test a spider with Animal reference
		System.out.println();
		a = new Spider();
		a.eat();
		a.walks();
		//Test a cat and a fish
		System.out.println();
		Pet p;
		
		Cat c = new Cat("Tom");
		c.eat();
		c.play();
		c.walks();
		System.out.println();
		a = new Cat();
		a.eat();
		a.walks();
		System.out.println();
		p = new Cat();
		p.setName("Mr. Whiskers");
		p.play();
		System.out.println();
		Fish f = new Fish();
		f.setName("Guppy");
		f.eat();
		f.play();
		f.walks();
		System.out.println();
		a = new Fish();
		a.eat();
		a.walks();
		System.out.println();
		PetMain.playWithAnimals(f);
		PetMain.playWithAnimals(a);
		PetMain.playWithAnimals(c);
		PetMain.playWithAnimals(s);
	}
	
	public static void playWithAnimals(Animal a) {
		if(a instanceof Pet) {
			Pet p = (Pet)a;
			p.play();
		} else {
			System.out.println("Danger! Wild animal.");
		}
	}

}

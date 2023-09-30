/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.oop;

/**
 *
 * @author aqnaa
 */
import java.util.Scanner;

import java.util.Scanner;

public class DuckSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih jenis bebek:");
        System.out.println("1. Mallard Duck");
        System.out.println("2. Rubber Duck");
        System.out.println("3. Decoy Duck");
        System.out.println("4. Model Duck");
        
        int choice = scanner.nextInt();
        
        Duck selectedDuck = null;
        
        switch (choice) {
            case 1:
                selectedDuck = new MallardDuck();
                break;
            case 2:
                FlyBehavior cantFly = () -> System.out.println("I cant fly");
                QuackBehavior squeak = () -> System.out.println("squeak");
                selectedDuck = new RubberDuck(cantFly, squeak);
                break;
            case 3:
                selectedDuck = new DecoyDuck();
                break;
            case 4:
                selectedDuck = new ModelDuck();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return; // Keluar dari program jika pilihan tidak valid.
        }
        
        selectedDuck.performQuack();
        selectedDuck.performFly();
        
        if (choice == 4) {
            System.out.println("Apakah Anda ingin mengubah perilaku terbang Model Duck? (y/n): ");
            char changeFlyBehavior = scanner.next().charAt(0);
            if (changeFlyBehavior == 'y' || changeFlyBehavior == 'Y') {
                selectedDuck.setFlyBehavior(new FlyRocketPowered());
                selectedDuck.performFly();
            }
        }
        
        scanner.close();
    }
}





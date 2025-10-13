/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.java_projectile_motion_simulation;

/**
 *
 * @author Mukisa
 */
import java.util.Scanner;

public class Java_Projectile_Motion_Simulation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Gravitational acceleration (m/s^2)
        final double g = 9.8;

        // Get user input
        System.out.print("Enter initial velocity (m/s): ");
        double u = input.nextDouble();

        System.out.print("Enter launch angle (degrees): ");
        double thetaDeg = input.nextDouble();

        // Convert angle to radians
        double theta = Math.toRadians(thetaDeg);

        // Components of velocity
        double uX = u * Math.cos(theta); // horizontal velocity
        double uY = u * Math.sin(theta); // vertical velocity

        // --- Physics formulas from the diagram ---
        // Time of flight (T) = (2 * u * sinθ) / g
        double timeOfFlight = (2 * uY) / g;

        // Maximum height (H) = (u^2 * sin^2θ) / (2g)
        double maxHeight = (uY * uY) / (2 * g);

        // Horizontal Range (R) = (u^2 * sin(2θ)) / g
        double range = (u * u * Math.sin(2 * theta)) / g;

        // Display results
        System.out.println("\n=== Projectile Motion Results ===");
        System.out.printf("Initial Velocity (u): %.2f m/s%n", u);
        System.out.printf("Launch Angle: %.2f degrees%n", thetaDeg);
        System.out.printf("Time of Flight (T): %.2f seconds%n", timeOfFlight);
        System.out.printf("Maximum Height (H): %.2f meters%n", maxHeight);
        System.out.printf("Horizontal Range (R): %.2f meters%n", range);

        input.close();
    }
}

        
    


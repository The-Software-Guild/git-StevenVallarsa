/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sv.doggenetics;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author: Steven Vallarsa
 * email: stevenvallarsa@gmail.com
 * date: 11/10/2021
 * purpose: Display a fake DNA report on a dog's heritage with up to five breeds
 */
public class DogsLife {
    public static void main(String[] args) {
        
        Random rnd = new Random();
        Scanner myScanner = new Scanner(System.in);
        
        String[] dogBreeds = {
            "Alaskan Klee Kai", 
            "Australian Stumpy Tail Cattle Dog", 
            "Brussels Griffon",
            "Irish Wolfhound",
            "Catalburun",
            "Xoloitzcuintli",
            "Norwegian Lundehund",
            "Pembroke Welch Corgi"
        };
        
        ArrayList<Integer> dnaPercentages = new ArrayList<Integer>();
        ArrayList<Integer> dogIndex = new ArrayList<Integer>();
        
        int percentageRemaining = 100;
        
        
        // Create array of percentages that add up to 100 in five or less items
        while (percentageRemaining > 0) {
            if (dnaPercentages.size() == 4) {
                dnaPercentages.add(percentageRemaining);
                percentageRemaining = 0;
            } else {
                int percent = rnd.nextInt(percentageRemaining + 1);
                dnaPercentages.add(percent);
                percentageRemaining -= percent;
            }
        }
        
        // Sort dnaPercentages ArrayList in descending order
        Collections.sort(dnaPercentages);
        Collections.reverse(dnaPercentages);
        
        // create ArrayList of indexes that will randomly select dog breeds to go with the dnaPercentages ArrayList
        while (dogIndex.size() < dnaPercentages.size()) {
            int randomDogBreed = rnd.nextInt(dogBreeds.length);
            if (!dogIndex.contains(randomDogBreed)) {
                dogIndex.add(randomDogBreed);
            }
        }
        
        // Get dog name from user and print results
        String dogsName;
        
        System.out.println("What is your dog's name? ");
        dogsName = myScanner.nextLine();
        
        System.out.println("Well then, I have this highly reliable report on " + dogsName +"'s prestigious background right here. ");
        System.out.println();
        System.out.println(dogsName + " is:");
        System.out.println();
        
        int index = 0;
        while (index < dnaPercentages.size()) {
            System.out.println(dnaPercentages.get(index) + "% " + dogBreeds[index]);
            index++;
        }
        
        System.out.println();
        System.out.println("Wow, that's QUITE the dog!");
    }
}

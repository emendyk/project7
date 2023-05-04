package edu.guilford;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Driver {
    private static final int NUM_ELEMENTS = 1000;

    public static void main(String[] args) {
        List<Clothes> list = new ArrayList<>();

        // Step 1: Add randomly generated objects to the list
        long startTime = System.nanoTime();
        Random rand = new Random();
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            Clothes clothes = generateRandomClothes(rand);
            list.add(clothes);
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Time to add " + NUM_ELEMENTS + " elements: " + elapsedTime/ 1e6 + " ms");

        // Step 2: Sort the list using Collections.sort
        startTime = System.nanoTime();
        Collections.sort(list);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Time taken to sort Collections.sort: " + elapsedTime/ 1e6 + " ms");

        // Step 3: Shuffle the list using Collections.shuffle
        startTime = System.nanoTime();
        Collections.shuffle(list);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Time to taken shuffle Collections.shuffle: " + elapsedTime/ 1e6 + "ms");

        // Step 4: Get a random element from the list 1,000,000 times
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            int index = rand.nextInt(list.size());
            Clothes clothes = list.get(index);
        }
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Time to get a random element 1,000,000 times: " + elapsedTime/ 1e6 + " ms");

        // Step 5: Get each element from the list sequentially
        startTime = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            Clothes clothes = list.get(i);
        }
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Time to get each element sequentially: " + elapsedTime/ 1e6 + " ms");
    
        //Step 6: Sort the list using linked list
        startTime = System.nanoTime();
        
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Time taken to add " + NUM_ELEMENTS + " elements to LinkedList: " + elapsedTime + " ns");

        // Sort the list using LinkedList.sort (which uses merge sort algorithm)
        startTime = System.nanoTime();
        list.sort(null);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Time taken to sort LinkedList: " + elapsedTime/ 1e6 + " ms");

        // Shuffle the list using Collections.shuffle
        startTime = System.nanoTime();
        Collections.shuffle(list);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Time taken to shuffle LinkedList: " + elapsedTime/ 1e6 + " ms");

        // Get a random element from the list 1,000,000 times
        Random random = new Random();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            int randomIndex = random.nextInt(list.size());
            Clothes randomClothes = list.get(randomIndex);
        }
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Time taken to get a random element from LinkedList 1,000,000 times: " + elapsedTime/ 1e6 + " ms");

        // Get each element from the list sequentially
        startTime = System.nanoTime();
        for (Clothes clothes : list) {
            // Do something with clothes object, e.g. call a method on it
            clothes.wear();
        }
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Time taken to get each element sequentially from LinkedList: " + elapsedTime/ 1e6 + " ms");
    }
        
    


    private static Clothes generateRandomClothes(Random rand) {
        int typeRand = rand.nextInt(4);
        String color = generateRandomColor(rand);
        int size = rand.nextInt(10) + 1;
        String material = generateRandomMaterial(rand);
        switch (typeRand) {
            case 0:
                return new Shirt(color, size, material);
            case 1:
                return new Jacket(color, size, material);
            case 2:
                return new Shorts(color, size, material);
            default:
                return new Pants(color, size, material);
        }
    }

    private static String generateRandomColor(Random rand) {
        String[] colors = {"Red", "Orange", "Yellow", "Green", "Blue", "Purple", "Pink", "White", "Gray", "Black"};
        int colorRand = rand.nextInt(colors.length);
        return colors[colorRand];
    }

    private static String generateRandomMaterial(Random rand) {
        String[] materials = {"Cotton", "Polyester", "Silk", "Wool", "Nylon", "Leather", "Denim", "Velvet", "Satin", "Linen"};
        int materialRand = rand.nextInt(materials.length);
        return materials[materialRand];
    }
}

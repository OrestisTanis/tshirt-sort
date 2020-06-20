/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtsort.randomizer;

import tshirtsort.models.Color;
import tshirtsort.models.Fabric;
import tshirtsort.models.Size;

/**
 *
 * @author Walter
 */
public class Random {
    
    public Color getRandomColor() {
        Color[] values = Color.values();
        return values[(int) (Math.random() * values.length)];
    }
    
    public Size getRandomSize() {
        Size[] values = Size.values();
        return values[(int) (Math.random() * values.length)];
    }
    
    public Fabric getRandomFabric() {
        Fabric[] values = Fabric.values();
        return values[(int) (Math.random() * values.length)];
    }
    
    public String getRandomName() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        java.util.Random random = new java.util.Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}

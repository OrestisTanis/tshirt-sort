/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtsort.randomizer;

import tshirtsort.models.Color;
import tshirtsort.models.Fabric;
import tshirtsort.models.Size;
import tshirtsort.models.TShirt;

/**
 *
 * @author Walter
 */
public class RandomTShirt {
    
//    public RandomTShirt(){
//        super();
//        setName(rnd.getRandomName());
//        setColor(rnd.getRandomColor());
//        setSize(rnd.getRandomSize());
//        setFabric(rnd.getRandomFabric());
//    }
    
    Random rnd = new Random();

    public TShirt generate() {
        Color color = rnd.getRandomColor();
        Size size = rnd.getRandomSize();
        Fabric fabric = rnd.getRandomFabric();
        String name = rnd.getRandomName();
        TShirt ts = new TShirt(name, color, size, fabric, 0);
        return ts;
    }
}

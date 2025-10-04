package com.abach42.designpatterns.creational.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuilderTest { 
    private Director director;

    @BeforeEach
    public void setUp() {
        director = new Director();
    }

    @Test
    @DisplayName("Barebone builder builds basic computer")
    public void testBareboneBuilderBasicComputer() {
        BareboneConcreteBuilder bareboneBuilder = new BareboneConcreteBuilder();
        director.constructBasicComputer(bareboneBuilder);
        BareboneProduct bareboneProduct = bareboneBuilder.build();
    
        String expectedProduct = "BareboneProduct[" +
        "cpu=Intel Core i3" + 
        ",ramSize=" + 16 +
        ",hardDiskSize=" + 500 +
        ",cooler=SMALL" +
        "]";
    
        assertEquals(expectedProduct, bareboneProduct.toString());
    }

    @Test
    @DisplayName("Barebone builder builds gaming computer")
    public void testBareboneBuilderGamingComputer() {
        BareboneConcreteBuilder bareboneBuilder = new BareboneConcreteBuilder();
        director.constructGamingComputer(bareboneBuilder);
        BareboneProduct bareboneProduct = bareboneBuilder.build();
    
        String expectedProduct = "BareboneProduct[" +
        "cpu=Intel Core i9" + 
        ",ramSize=" + 64 +
        ",hardDiskSize=" + 2000 +
        ",cooler=SMALL" +
        "]";
    
        assertEquals(expectedProduct, bareboneProduct.toString());
    }

    @Test
    @DisplayName("Tower builder builds basic computer")
    public void testTowerBuilderBasicComputer() {
        TowerConcreteBuilder towerBuilder = new TowerConcreteBuilder();
        director.constructBasicComputer(towerBuilder);
        TowerProduct towerProduct = towerBuilder.build();
    
        String expectedProduct = "TowerProduct[" +
        "cpu=Intel Core i3" + 
        ",ramSize=" + 16 +
        ",hardDiskSize=" + 500 +
        ",cooler=LARGE" +
        "]";
    
        assertEquals(expectedProduct, towerProduct.toString());
    }

    @Test
    @DisplayName("Tower builder builds gaming computer")
    public void testTowerBuilderGamingComputer() {
        TowerConcreteBuilder towerBuilder = new TowerConcreteBuilder();
        director.constructGamingComputer(towerBuilder);
        TowerProduct towerProduct = towerBuilder.build();
    
        String expectedProduct = "TowerProduct[" +
        "cpu=Intel Core i9" + 
        ",ramSize=" + 64 +
        ",hardDiskSize=" + 2000 +
        ",cooler=LARGE" +
        "]";
    
        assertEquals(expectedProduct, towerProduct.toString());
    }
}
package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    @Test
    void newHero_instantiatesCorrectly_true() throws Exception{
        Hero newHero = Hero.setUPNewHero();
        assertTrue(newHero instanceof Hero);
    }

    @Test
    void newHero_getName_String() {
        Hero newHero = Hero.setUPNewHero();
        assertEquals("Melisa",newHero.getName());
    }

    @Test
     public void newHero_getAge_Int() {
        Hero newHero = Hero.setUPNewHero();
        assertEquals(23,newHero.getAge());
    }

    @Test
    void newHero_getPower_String() {
        Hero newHero = Hero.setUPNewHero();
        assertEquals("flying",newHero.getPower());
    }

    @Test
    void newHero_getWeakness_String() {
        Hero newHero = Hero.setUPNewHero();
        assertEquals("fire",newHero.getWeakness());
    }

    @Test
    void newHero_getAllInstances_true() {
        Hero newHero = Hero.setUPNewHero();
        Hero another = Hero.setUPNewHero();
        assertTrue(Hero.getAllInstances().contains(newHero));
        assertTrue(Hero.getAllInstances().contains(another));
    }

    @Test
    void newHero_getId_Int() {
        Hero.clearAllHeroes();
        Hero newHero = Hero.setUPNewHero();
        Hero another = Hero.setUPNewHero();
        Hero another1 = Hero.setUPNewHero();
        assertEquals(3,another1.getId());
    }

    @Test
    void newHero_findById_id() {
        Hero.clearAllHeroes();
        Hero newHero =Hero.setUPNewHero();
        Hero another =Hero.setUPNewHero();
        assertEquals(2,Hero.findById(another.getId()).getId());
    }
}
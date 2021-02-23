package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    @Test
    void newHero_instantiatesCorrectly_true() {
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
}
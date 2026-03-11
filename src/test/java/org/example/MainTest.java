package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    private Point point;
    private Player player;

    @BeforeEach
    void setUp() {
        point = new Point(6, 5);
        player = new Player("John", 100, Weapon.SWORD);
    }

    @DisplayName("Point sınıf değişkenleri doğru access modifier a sahip mi ?")
    @Test
    public void testPointTypesAccessModifiers() throws NoSuchFieldException {
        Field xField = point.getClass().getDeclaredField("x");
        assertEquals(2, xField.getModifiers());

        Field yField = point.getClass().getDeclaredField("y");
        assertEquals(2, yField.getModifiers());
    }

    @DisplayName("Point sınıf değişkenleri doğru tipte mi ?")
    @Test
    public void testPointTypes() {
        assertThat(point.getX(), instanceOf(Integer.class));
        assertThat(point.getY(), instanceOf(Integer.class));
    }

    @DisplayName("Parametre almayan distance methodu doğru çalışıyor mu ?")
    @Test
    public void testDistanceMethodWithoutParameter() {
        assertEquals(7.810249675906654, point.distance());
    }

    @DisplayName("Parametre alan distance methodu doğru çalışıyor mu ?")
    @Test
    public void testDistanceMethodWithTwoParameter() {
        assertEquals(5.0, point.distance(2, 2));
    }

    @DisplayName("Point sınıfı parametresi alan distance methodu doğru çalışıyor mu ?")
    @Test
    public void testDistanceMethodWithPointParameter() {
        Point second = new Point(3, 1);
        assertEquals(5.0, point.distance(second));
    }

    @DisplayName("Player sınıf değişkenleri doğru access modifier a sahip mi ?")
    @Test
    public void testPlayerTypesAccessModifiers() throws NoSuchFieldException {
        Field nameField = player.getClass().getDeclaredField("name");
        assertEquals(2, nameField.getModifiers());

        Field healthPercentageField = player.getClass().getDeclaredField("healthPercentage");
        assertEquals(2, healthPercentageField.getModifiers());

        Field weaponField = player.getClass().getDeclaredField("weapon");
        assertEquals(2, weaponField.getModifiers());
    }

    @DisplayName("Weapon enum değişkenleri doğru tipte mi ?")
    @Test
    public void testWeaponTypesAccessModifiers() {
        assertThat(Weapon.SWORD.getDamage(), instanceOf(Integer.class));
        assertThat(Weapon.SWORD.getAttackSpeed(), instanceOf(Double.class));
    }

    @DisplayName("HealthPercentage metodu doğru çalışıyor mu ?")
    @Test
    public void testPlayerHealthMethods() {
        assertEquals(100, player.healthRemaining());
        player.loseHealth(20);
        assertEquals(80, player.healthRemaining());
        player.restoreHealth(50);
        assertEquals(100, player.healthRemaining());
    }

    @DisplayName("loseHealth metodu doğru çalışıyor mu ?")
    @Test
    public void testLoseHealth() {
        player.loseHealth(20);
        player.loseHealth(20);
        assertEquals(60, player.healthRemaining());
        player.loseHealth(80);
        assertEquals(0, player.healthRemaining());
    }

    @DisplayName("restoreHealth metodu doğru çalışıyor mu ?")
    @Test
    public void testRestoreHealth() {
        player.loseHealth(20);
        player.restoreHealth(10);
        assertEquals(90, player.healthRemaining());
        player.restoreHealth(20);
        assertEquals(100, player.healthRemaining());
    }
}


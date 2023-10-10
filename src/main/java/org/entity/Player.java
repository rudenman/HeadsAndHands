package org.entity;

public class Player extends Entity {
    private int healingCount;

    public Player(String name, int health, int attack, int protection, int minDamage, int maxDamage) {
        super(name, health, attack, protection, minDamage, maxDamage);
        healingCount = 4;
    }


    public void heal() {
        if (healingCount == 0) {
            System.out.println("Исцеление недоступно");
            return;
        }
        health += healing;
        healingCount--;
        if (health > maxHealth) {
            health = maxHealth;
        }
        System.out.printf("Здоровье увеличено на %d единиц\n", healing);
    }
}

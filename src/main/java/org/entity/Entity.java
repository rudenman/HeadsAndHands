package org.entity;

import java.util.Random;

public abstract class Entity {
    String name;
    protected int maxHealth;
    protected int healing;
    protected int health;
    protected int attack;
    protected int protection;
    protected int minDamage;
    protected int maxDamage;
    protected boolean isAlive;

    public Entity(String name, int health, int attack, int protection, int minDamage, int maxDamage) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.healing = (int) Math.round(health * 0.3);
        this.attack = attack;
        this.protection = protection;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        isAlive = true;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getHealth() {
        return health;
    }

    public void checkHealth() {
        System.out.printf("%s имеет %d единиц здоровья\n", name, health);
    }

    public int getAttack() {
        return attack;
    }

    public int getProtection() {
        return protection;
    }

    public void hit(Entity purpose) {
        if (!isAlive) {
            System.out.printf("%s умер и не может атаковать\n", name);
            return;
        }
        if (purpose == null) {
            System.out.println("Цель не найдена");
            return;
        }
        if (!purpose.isAlive()) {
            System.out.printf("%s метрв\n", purpose.getName());
            return;
        }
        int attackModifier = Math.max(attack - purpose.getProtection() + 1, 1);
        boolean successOfTheAttack = checkSuccessOfTheAttack(attackModifier);
        if (successOfTheAttack) {
            purpose.damage(minDamage, maxDamage);
        } else {
            System.out.printf("%s увернулся\n", purpose.getName());
        }

    }

    private boolean checkSuccessOfTheAttack(int attackModifier) {
        Random cube = new Random();
        for (int i = 0; i < attackModifier; i++) {
            if (cube.nextInt(6) + 1 >= 5) {
                return true;
            }
        }
        return false;
    }

    private void damage(int minEnemyDamage, int maxEnemyDamage) {
        int enemyDamage = new Random().nextInt(maxEnemyDamage) + minEnemyDamage;
        health -= enemyDamage;
        if (health <= 0) {
            health = 0;
            System.out.printf("%s убит\n", name);
            isAlive = false;
        }
        System.out.printf("%s получил %d урона\n", name, enemyDamage);
    }
}

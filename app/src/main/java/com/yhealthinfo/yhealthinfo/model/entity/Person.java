package com.yhealthinfo.yhealthinfo.model.entity;

public class Person {
    private String name;
    private byte age;
    private double heigth;
    private double weight;
    private double fatPercentage;
    private Biotype biotype;

    public Person() {
    }

    public Person(String name, byte age, double heigth, double weight, double fatPercentage, Biotype biotype) {
        this.name = name;
        this.age = age;
        this.heigth = heigth;
        this.weight = weight;
        this.fatPercentage = fatPercentage;
        this.biotype = biotype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(double fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    public Biotype getBiotype() {
        return biotype;
    }

    public void setBiotype(Biotype biotype) {
        this.biotype = biotype;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", heigth=" + heigth +
                ", weight=" + weight +
                ", fatPercentage=" + fatPercentage +
                ", biotype=" + biotype +
                '}';
    }
}

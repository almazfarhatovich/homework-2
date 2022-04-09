package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Truck {

    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./trucks.json");
    private int id;
    private String name;
    private String driver;
    private String state;

    public Truck(int id, String name, String driver, String state) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static void getCar() {

        Truck[] trucks = {
                new Truck(1, "Renault", "", "base"),
                new Truck(2, "Volvo  ", "", "base"),
                new Truck(3, "DAF XT ", "", "base")};

        Gson gson = new Gson();
        String json = GSON.toJson(trucks);
        System.out.println(readCarFile());
        writeCarFile(json);

        Truck[] truck = GSON.fromJson(readCarFile(), Truck[].class);
        for (Truck truck1 : truck) {
            System.out.println(truck1.toString());
        }
    }

    public static void writeCarFile(String object) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write, object, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readCarFile() {
        StringBuilder json = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(String.valueOf(WRITE_PATH));
            int a;
            while ((a = fileReader.read()) != -1) {
                json.append((char) a);
            }
            return json.toString();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return json.toString();
    }

    @Override
    public String toString() {
        return
                " " + id +
                        "| " + name +
                        " |    " + driver +
                        "  |  " + state;
    }
}

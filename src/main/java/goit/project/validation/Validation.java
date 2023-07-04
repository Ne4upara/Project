package goit.project.validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Validation {
    private Map<Character, List<String>> citiesMap;
    private List<String> usedCities;
    private Random random;

    public Validation() {
        citiesMap = new HashMap<>();
        usedCities = new ArrayList<>();
        random = new Random();

        initializeCitiesMap();
    }

    private void initializeCitiesMap() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/resources/cities.txt");//список городов
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String city;
            while ((city = reader.readLine()) != null) {
                city = city.trim();
                if (!city.isEmpty()) {
                    char firstChar = Character.toUpperCase(city.charAt(0));
                    citiesMap.computeIfAbsent(firstChar, k -> new ArrayList<>()).add(city);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String startGame() {
        usedCities.clear();
        return getRandomCity();
    }

    public String makeMove(String userCity) {
        userCity = userCity.trim();
        if (!isValidCity(userCity)) {
            return "Невірне місто";
        }

        char lastChar = getLastChar(userCity);
        String computerCity = getValidComputerCity(lastChar);
        if (computerCity == null) {
            return "Ви виграли! Комп'ютер не має відповіді.";
        }

        usedCities.add(userCity);
        usedCities.add(computerCity);
        return computerCity;
    }

    private boolean isValidCity(String city) {
        if (usedCities.contains(city)) {
            return false; //проверка на дубликат слова
        }

        char lastChar = getLastChar(city);
        char lastCharWithoutSoftSign = removeSoftSign(lastChar);
        Set<Character> validFirstChars = citiesMap.keySet();

        return lastCharWithoutSoftSign != ' ' && validFirstChars.contains(lastCharWithoutSoftSign);
    }

    private char getLastChar(String city) {
        city = city.replaceAll("ь|Ь$", "");
        return Character.toUpperCase(city.charAt(city.length() - 1));
    }

    private char removeSoftSign(char c) {
        if (c == 'Ь' || c == 'ь') {
            return ' ';
        }
        return c;
    }

    private String getValidComputerCity(char firstChar) {
        List<String> cities = citiesMap.get(firstChar);
        if (cities != null && !cities.isEmpty()) {
            for (String city : cities) {
                if (!usedCities.contains(city)) {
                    return city;
                }
            }
        }
        return null;
    }

    private String getRandomCity() { //рандомайзер
        List<String> cities = new ArrayList<>(citiesMap.values().stream()
                .flatMap(List::stream)
                .toList());

        while (!cities.isEmpty()) {
            int randomIndex = random.nextInt(cities.size());
            String city = cities.remove(randomIndex);
            if (!usedCities.contains(city)) {
                return city;
            }
        }

        return null;//города закончились
    }
}


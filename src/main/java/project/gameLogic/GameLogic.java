package project.gameLogic;

import project.frame.GameOverFrame;

import java.io.*;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class GameLogic {
    private final Map<String, Integer> citiesMap;
    private final Random random;

    private Score score = new Score();

    public GameLogic() {
        citiesMap = new TreeMap<>();
        random = new Random();
        loadCitiesFromFile();
    }

    private void loadCitiesFromFile() {
        try (InputStream inputStream = getClass().getResourceAsStream("/cities.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String city = line.trim();
                if (!city.isEmpty()) {
                    citiesMap.put(city, 0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String checkLastLetterIsValid(String city) {
        char lastChar = city.charAt(city.length() - 1);
        if (lastChar == 'ь' || lastChar == 'и' || lastChar == 'й') {
            return city.substring(0, city.length() - 2);
        }
        return city;
    }

    public String isValidWord(String word, String answerComp) {
        String city = costructorCorrectEnterWord(word);
        if (!validLastLetter(city, answerComp)) {
            return "first_letter_not_found";
        } else if (!isValidCityExists(city)) {
            return "the_city_exists";
        } else if (!isValidKeyCity(city)) {
            return "city_used";
        } else
            return getNextCity(city);
    }

    private String getNextCity(String currentCity) {
        citiesMap.put(currentCity, 1);
        score.score(currentCity); //подсчет очков
        System.out.println("score.getCount() = " + score.getCount());//проверка подсчета
        String checkLastLetter = checkLastLetterIsValid(currentCity);
        String lastLetter = checkLastLetter.substring(checkLastLetter.length() - 1).toLowerCase();
        Map<String, Integer> suitableCities = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : citiesMap.entrySet()) {
            String city = entry.getKey();
            if (city.toLowerCase().startsWith(lastLetter) && entry.getValue() == 0) {
                suitableCities.put(city, 0);
            }
        }
        if (!suitableCities.isEmpty()) {
            int randomIndex = random.nextInt(suitableCities.size());
            String[] cityArray = suitableCities.keySet().toArray(new String[0]);
            String nextCity = cityArray[randomIndex];
            citiesMap.put(nextCity, 1);
            return nextCity;
        }

        return "over";
    }

    private boolean isValidCityExists(String city) {
        return citiesMap.containsKey(city);
    }

    private boolean isValidKeyCity(String city) {
        return citiesMap.get(city) == 0;
    }

    private boolean validLastLetter(String city, String answerComp) {
        if (answerComp.equals("")) return true;
        String lastLetter = checkLastLetterIsValid(answerComp.substring(answerComp.length() - 1).toLowerCase());
        String firstLetter = String.valueOf(city.charAt(0));
       return lastLetter.equalsIgnoreCase(firstLetter);
    }

    private String costructorCorrectEnterWord(String city) {
        String one = city.substring(0, 1).toUpperCase();
        return one + city.substring(1).toLowerCase();
    }
}
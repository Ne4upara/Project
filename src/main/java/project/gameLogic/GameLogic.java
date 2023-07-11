package project.gameLogic;

import lombok.Getter;
import lombok.Setter;
import project.frame.GameFrame;
import project.frame.GameOverFrame;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameLogic {
    private Map<String, Integer> citiesMap;
    private Random random;
    private GameFrame gameFrame;

    private ScoreCounter scoreCounter;
    private GameOverFrame gameover; //11

    public GameLogic() {

        citiesMap = new HashMap<>();// Инициализация HashMap
        random = new Random();
        gameFrame = new GameFrame();
//        scoreCounter = new ScoreCounter();
        gameover = new GameOverFrame();//11
        loadCitiesFromFile();
    }
    public GameLogic(ScoreCounter scoreCounter) {
        this.scoreCounter = scoreCounter;
    }


    private void loadCitiesFromFile() {
        try (InputStream inputStream = getClass().getResourceAsStream("/cities.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String city = line.trim();
                if (!city.isEmpty()) {
                    citiesMap.put(city, 0); // Добавление слова в HashMap с начальным значением 0
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String normalizeCity(String city) {
        char lastChar = city.charAt(city.length() - 1);
        if (lastChar == 'ь' || lastChar == 'и' || lastChar == 'й') {
            char previousChar = city.charAt(city.length() - 2);
            return city.substring(0, city.length() - 2) + previousChar;
        }
        return city;
    }

    public String isValidWord (String sscity) {
        String city = costructorEnterWord(sscity);
        System.out.println(city);
        if (!validLastLetter(city)) return "first_not_found";
        else if (!isValidFirstCity(city)) {
            return "error";//нету такого города
        }
        else if (!isValidKeyCity(city)) {
            return "is";// город использован
        }else
            return getNextCity(city);
    }

    private String getNextCity(String currentCity) {
//        if (!validLastLetter(currentCity)) return "first_not_found";
//        if (!isValidFirstCity(currentCity)){
//            return "error";//нету такого города
//        }
//        if (!isValidKeyCity(currentCity)){
//            return "is";// город использован
//        } else {

            citiesMap.put(currentCity, 1);
            scoreCounter.counterScore(currentCity);
//            gameover.gameOverFrame(scoreCounter.getPlayerScore(), scoreCounter.getComputerScore());// чтото не так, разобратса
        System.out.println("scoreCounter.getPlayerScore() = " + scoreCounter.getPlayerScore());//для проверки счетчика
        System.out.println(gameover.getPlayer());
        String normal = normalizeCity(currentCity); // убираем мягкий знак
            String lastLetter = normal.substring(normal.length() - 1).toLowerCase();// Получение последней буквы слова


            // Создаем список подходящих городов
            Map<String, Integer> suitableCities = new HashMap<>();
            for (Map.Entry<String, Integer> entry : citiesMap.entrySet()) {
                String city = entry.getKey();
                if (city.toLowerCase().startsWith(lastLetter) && entry.getValue() == 0) {
                    suitableCities.put(city, 0);
                }
            }

            // Если есть подходящие города, выбираем случайный из них
            if (!suitableCities.isEmpty()) {
                int randomIndex = random.nextInt(suitableCities.size());
                String[] cityArray = suitableCities.keySet().toArray(new String[0]);
                String nextCity = cityArray[randomIndex];
                citiesMap.put(nextCity, 1);// Изменение значения индекса на 1
                gameFrame.setOutputWord(nextCity);
                scoreCounter.counterScore(nextCity);
                System.out.println("scoreCounter.getComputerScore() = " + scoreCounter.getComputerScore());// для проверки счетчика
//                gameover.gameOverFrame(scoreCounter.getPlayerScore(), scoreCounter.getComputerScore());// чтото не так, разобратса
                return nextCity;
            }


        return scoreCounter.vinnerOrLose(); // Если нет подходящего города, возвращаем null
    }

    private boolean isValidFirstCity(String firstCity) {

        return citiesMap.containsKey(firstCity);
    }

    private boolean isValidKeyCity (String city){
        return citiesMap.get(city) == 0;
    }

    private boolean validLastLetter (String city){
        String outputWord = (gameFrame.getOutputWord());
        if (outputWord.equals("")) return true;
        String lastLetter = normalizeCity(outputWord.substring(outputWord.length()-1).toLowerCase());
        String firstLette = String.valueOf(city.charAt(0));
        if (lastLetter.equalsIgnoreCase(firstLette)) return true;
        else return false;
    }

    private String costructorEnterWord (String city){
        String one = city.substring(0, 1).toUpperCase();
        return one + city.substring(1, city.length()).toLowerCase();
    }


    }


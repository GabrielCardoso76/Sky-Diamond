package com.example.bloukemon.service;

import org.springframework.stereotype.Service;

@Service
public class GameService {

    private static final int MAP_WIDTH = 20;
    private static final int MAP_HEIGHT = 10;
    private static final int WALL = 1;
    private static final int PATH = 0;
    private static final int TALL_GRASS = 2;
    private static final int WATER = 3;

    private int[][] map;
    private int playerX;
    private int playerY;

    public GameService() {
        initializeMap();
        // Player starts at a valid path position
        this.playerX = 1;
        this.playerY = 1;
    }

    private void initializeMap() {
        this.map = new int[MAP_HEIGHT][MAP_WIDTH];

        // Fill the map with path
        for (int i = 0; i < MAP_HEIGHT; i++) {
            for (int j = 0; j < MAP_WIDTH; j++) {
                map[i][j] = PATH;
            }
        }

        // Create a border of walls
        for (int i = 0; i < MAP_HEIGHT; i++) {
            map[i][0] = WALL;
            map[i][MAP_WIDTH - 1] = WALL;
        }
        for (int j = 0; j < MAP_WIDTH; j++) {
            map[0][j] = WALL;
            map[MAP_HEIGHT - 1][j] = WALL;
        }

        // Add tall grass areas
        for (int i = 1; i < MAP_HEIGHT - 1; i++) {
            for (int j = 1; j < 8; j++) {
                map[i][j] = TALL_GRASS;
            }
        }
        for (int i = 1; i < MAP_HEIGHT - 1; i++) {
            for (int j = 12; j < 19; j++) {
                map[i][j] = TALL_GRASS;
            }
        }

        // Add water area
        for (int i = 5; i < 9; i++) {
            for (int j = 8; j < 12; j++) {
                map[i][j] = WATER;
            }
        }
    }

    public void movePlayer(String direction) {
        int newX = playerX;
        int newY = playerY;

        switch (direction) {
            case "up":
                newY--;
                break;
            case "down":
                newY++;
                break;
            case "left":
                newX--;
                break;
            case "right":
                newX++;
                break;
        }

        if (isValidMove(newX, newY)) {
            this.playerX = newX;
            this.playerY = newY;
        }
    }

    private boolean isValidMove(int x, int y) {
        // Check boundaries
        if (y < 0 || y >= MAP_HEIGHT || x < 0 || x >= MAP_WIDTH) {
            return false;
        }
        // Check for walls or water
        if (map[y][x] == WALL || map[y][x] == WATER) {
            return false;
        }
        return true;
    }

    public int[][] getMap() {
        return map;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }
}
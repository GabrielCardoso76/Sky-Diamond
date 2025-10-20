package com.example.bloukemon.service;

import org.springframework.stereotype.Service;

@Service
public class GameService {

    private static final int MAP_WIDTH = 10;
    private static final int MAP_HEIGHT = 10;
    private static final int WALL = 1;
    private static final int PATH = 0;

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
        // Create a border of walls
        for (int i = 0; i < MAP_HEIGHT; i++) {
            for (int j = 0; j < MAP_WIDTH; j++) {
                if (i == 0 || i == MAP_HEIGHT - 1 || j == 0 || j == MAP_WIDTH - 1) {
                    map[i][j] = WALL;
                } else {
                    map[i][j] = PATH;
                }
            }
        }
        // Add some internal walls for complexity
        map[3][3] = WALL;
        map[3][4] = WALL;
        map[3][5] = WALL;
        map[6][7] = WALL;
        map[7][7] = WALL;
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
        // Check for walls
        if (map[y][x] == WALL) {
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
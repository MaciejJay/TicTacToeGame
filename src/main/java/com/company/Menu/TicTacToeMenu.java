package com.company.Menu;

public class TicTacToeMenu extends Menu {
    public final static String PLAY_WITH_AI = "Human vs. Computer - Hard Mode";
    public final static String PLAY_WITH_RANDOMCOMPUTER = "Human vs. Computer - Easy Mode";
    public final static String PLAY_WITH_HUMAN = "Human vs. Human";
    public final static String EXIT = "Exit";

    public TicTacToeMenu() {
        addElement(PLAY_WITH_AI);
        addElement(PLAY_WITH_RANDOMCOMPUTER);
        addElement(PLAY_WITH_HUMAN);
        addElement(EXIT);
    }
}

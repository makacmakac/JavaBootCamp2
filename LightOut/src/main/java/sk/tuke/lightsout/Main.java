package sk.tuke.lightsout;

public class Main {


    public static void main(String[] args) {
        var field = new Field(5,5, 3);
        var consoleUI = new ConsoleUI(field);
        consoleUI.play();
    }

}

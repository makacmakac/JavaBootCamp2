package sk.tuke.lightsout;

public class Main {


    public static void main(String[] args) {
        var field = new Field(3,3, 2);
        var consoleUI = new ConsoleUI(field);
        consoleUI.play();
    }

}

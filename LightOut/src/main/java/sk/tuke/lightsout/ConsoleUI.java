package sk.tuke.lightsout;

import java.util.Scanner;

public class ConsoleUI {
    private Field field;

    private Scanner scanner;

    private int attempts;

    private boolean isPlaying;

    public ConsoleUI(Field field) {
        this.field = field;
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        this.isPlaying = true;

        do {
            renderField();
            processInput();
        }while (this.isPlaying);

    }

    private void processInput() {
        System.out.print("Zadaj príkaz:");
        String[] input = scanner.nextLine().trim().toLowerCase().split(" ");

        switch (input[0]) {
            case "koniec": {
                this.isPlaying = false;
                break;
            }
            case "oznac": {
                int row = Integer.valueOf(input[1])-1;
                int column = Integer.valueOf(input[2])-1;

                // test či bol zadaný row alebo column v rámci rozsahu
                if(testRange(row,column)) {
                    this.field.toggleLight(row, column);
                    this.attempts++;

                }else System.out.println("Zadali ste nesprávny riadok alebo stĺpec");

                // test či som zvíťazil alebo prehral
                if(field.isSolved())
                {
                    System.out.println("WIN");
                } else
                    System.out.println("PLAYING");
                break;
            }
            default:
                System.out.println("Tento príkaz nepoznám.");

        }

    }

    public boolean testRange(int row, int column){
        return  (1 <= row+1 && row+1 <= field.getRowCount()) && (1 <= column+1 && column+1 <= field.getColumnCount());
    }

    public void renderField() {
        String header = String.format("obtiažnosť: %d pokusy: %d, vyriešenie: %s", field.getDifficulty(), this.attempts, this.field.isSolved());
        System.out.println(header);

        for (var row = 0; row < field.getRowCount(); row++) {
            for (var column = 0; column < field.getColumnCount(); column++) {
                var light = field.getLights(row, column);

                if (light.getOnOff())
                    System.out.print("🥎");
                else
                    System.out.print("⚾");

            }
            System.out.println();
        }


    }

}

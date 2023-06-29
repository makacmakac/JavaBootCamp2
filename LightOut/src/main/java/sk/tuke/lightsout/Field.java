package sk.tuke.lightsout;


import java.util.Random;

public class Field {

    private int rowCount;
    private int columnCount;

    private boolean solved;

    private Light[][] lights;

    private boolean initializing; // možno výskyty v tomto kóde odstrániť a bdue to fungovať

    private int difficulty;

    public Field(int rowCount, int columnCount, int difficulty) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.lights = new Light[rowCount][columnCount];
        this.difficulty = difficulty;
        this.solved = false;
        this.initializing = true;
        generate();
    }

    public void generate() {
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                lights[row][column] = new Light(false);
            }
        }
        this.initializationToggleLights();
        initializing = false;

    }

    public boolean isSolved() {
        return solved;
    }

    public void toggleLight(int rowInput, int columnInput) {
        this.lights[rowInput][columnInput].toggleOnOff();
        if (rowInput - 1 >= 0)
            this.lights[rowInput - 1][columnInput].toggleOnOff();
        if (rowInput + 1 < rowCount)
            this.lights[rowInput + 1][columnInput].toggleOnOff();
        if (columnInput - 1 >= 0)
            this.lights[rowInput][columnInput - 1].toggleOnOff();
        if (columnInput + 1 < columnCount)
            this.lights[rowInput][columnInput + 1].toggleOnOff();
        int allLightning = 0;

        //test víťazstva
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                if (this.lights[row][column].getOnOff() == true)
                    allLightning++;
            }
        }
        if (allLightning == (rowCount * columnCount)) {
            this.solved = true;
        }

    }


    public void initializationToggleLights() {
        Random random = new Random();
        for (int dif = 1; dif <= this.difficulty; dif++) {
            int row = random.nextInt(rowCount);
            int column = random.nextInt(columnCount);
//            //for (var row = 0; row < this.rowCount; row++) {
//            //    for (var column = 0; column < this.columnCount; column++) {
//                    if (row == rowRand && column == columnRand && initializing) {
//                        if (!this.lights[row][column].getOnOff()) {
//                            this.lights[row][column].toggleOnOff();
//                            if (row - 1 >= 0)
//                                this.lights[row - 1][column].toggleOnOff();
//                            if (row + 1 < rowCount)
//                                this.lights[row + 1][column].toggleOnOff();
//                            if (column - 1 >= 0)
//                                this.lights[row][column - 1].toggleOnOff();
//                            if (column + 1 < columnCount)
//                                this.lights[row][column + 1].toggleOnOff();
//                        }
//                    } else continue;
//               // }
//           // }

            if (!this.lights[row][column].getOnOff()) {
                this.lights[row][column].toggleOnOff();
                if (row - 1 >= 0)
                    this.lights[row - 1][column].toggleOnOff();
                if (row + 1 < rowCount)
                    this.lights[row + 1][column].toggleOnOff();
                if (column - 1 >= 0)
                    this.lights[row][column - 1].toggleOnOff();
                if (column + 1 < columnCount)
                    this.lights[row][column + 1].toggleOnOff();
            }
        }
    }


    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public Light getLights(int rowCount, int columnCount) {
        return lights[rowCount][columnCount];
    }

    public int getDifficulty() {
        return difficulty;
    }
}



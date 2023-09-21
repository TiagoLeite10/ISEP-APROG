import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmpresaABC {
    private static final String FILE = "files/data.txt";
    private static final int EX_C_ALTERATION = -1;
    private static final int EX_H_ALTERATION = 1;
    private static final int CUBE_SIZE = 3;
    private static final int TOP_CUBE = 0;

    public static void main(String[] args) throws FileNotFoundException {
        int[][] terrain, newTerrain;

        terrain = readInformation(FILE);

        if (terrain != null) {
            int maxValueTerrain, maxValueNewTerrain, totalAreasM2, totalFlood, verticalDryPath;

            System.out.println("b)");
            // Saber quantos dígitos tem o maior número da matriz, para fazer a formatação da apresentação
            maxValueTerrain = maxValue(terrain);
            showInformation(terrain, countNumberDigits(maxValueTerrain) + 4);

            System.out.println("c)");
            newTerrain = cloneArray(terrain);
            changeWaterLevel(newTerrain, EX_C_ALTERATION);
            // Saber quantos dígitos tem o maior número da matriz, para fazer a formatação da apresentação
            maxValueNewTerrain = maxValue(newTerrain);
            showInformation(newTerrain, countNumberDigits(maxValueNewTerrain) + 4);

            System.out.println("d)");
            totalAreasM2 = terrain.length * terrain[0].length;
            System.out.printf("%s %.2f%c%n", "area submersa:", percentageSubmergedArea(totalAreasM2, countSubmergedAreas(newTerrain)), '%');

            System.out.println("e)");
            System.out.printf("%s %d %s%n", "variacao da area inundada:", floodedAreaVariation(terrain, newTerrain), "m2");

            System.out.println("f)");
            System.out.printf("%s %d %s%n", "volume de agua:", volumeOfWaterInTerrain(newTerrain), "m3");

            System.out.println("g)");
            totalFlood = totalFlood(maxValueNewTerrain);
            System.out.printf("%s%d %c%n", "para inundacao total, subir :", totalFlood, 'm');

            System.out.println("h)");
            System.out.printf("%18s | %18s%n", "subida da agua (m)", "area inundada (m2)");
            System.out.printf("%18s | %18s%n", "------------------", "------------------");
            calculateIncrementsUntilAllSubmersed(newTerrain, EX_H_ALTERATION, totalFlood);

            System.out.println("i)");
            terrainCoordinates(newTerrain, CUBE_SIZE, TOP_CUBE);

            System.out.println("j)");
            verticalDryPath = searchVerticalDryPath(newTerrain);
            printVerticalDryPathInformation(verticalDryPath);
        } else {
            System.out.println("dimensões inválidas");
        }
    }

    //Alínea A - Procedimento para ler a informação de um terreno a partir de um ficheiro e armazená-la em memória numa
    // matriz
    private static int[][] readInformation(String file) throws FileNotFoundException {
        Scanner read = new Scanner(new File(file));
        String nameTerrain;
        int[][] terrain;
        int line = 0, column = 0;

        if (read.hasNextLine()) {
            nameTerrain = read.nextLine();
        }

        if (read.hasNextInt()) {
            line = read.nextInt();
        }

        if (read.hasNextInt()) {
            column = read.nextInt();
        }

        if (line > 0 && column > 0) {
            terrain = new int[line][column];
            for (line = 0; line < terrain.length; line++) {
                for (column = 0; column < terrain[line].length; column++) {
                    if (read.hasNextInt()) {
                        terrain[line][column] = read.nextInt();
                    }
                }
            }
        } else {
            terrain = null;
        }

        read.close();

        return terrain;
    }

    //Alínea B - Procedimento para imprimir o mapa do terreno no ecrã, com os valores das colunas alinhados à direita
    private static void showInformation(int[][] terrain, int digitsPlaces) {
        for (int line = 0; line < terrain.length; line++) {
            for (int column = 0; column < terrain[line].length; column++) {
                System.out.printf("%" + digitsPlaces + "d", terrain[line][column]);
            }
            System.out.println();
        }
    }

    //Alínea C - Procedimento para obter um novo mapa do terreno para refletir uma alteração no nível da água de X metros
    private static void changeWaterLevel(int[][] terrain, int alteration) {
        for (int line = 0; line < terrain.length; line++) {
            for (int column = 0; column < terrain[line].length; column++) {
                terrain[line][column] = terrain[line][column] - alteration;
            }
        }
    }

    //Alínea D - Função para visualizar a percentagem da área do terreno que está submerso (2 casas decimais)
    private static double percentageSubmergedArea(int totalOfAreas, int amountOfSubmergedArea) {
        return (double) (amountOfSubmergedArea * 100) / totalOfAreas;
    }

    //Alínea D - Função para contar o número de áreas submersas
    private static int countSubmergedAreas(int[][] terrain) {
        int submergedAreas = 0;

        for (int line = 0; line < terrain.length; line++) {
            for (int column = 0; column < terrain[line].length; column++) {
                if (terrain[line][column] < 0) {
                    submergedAreas++;
                }
            }
        }

        return submergedAreas;
    }

    //Alínea E - Função para visualizar a variação da área inundada (em m2)
    private static int floodedAreaVariation(int[][] terrain, int[][] newTerrain) {
        return countSubmergedAreas(newTerrain) - countSubmergedAreas(terrain);
    }

    //Alínea F - Função para visualizar o volume de água existente no terreno
    private static int volumeOfWaterInTerrain(int[][] terrain) {
        int volumeOfWater = 0;

        for (int line = 0; line < terrain.length; line++) {
            for (int column = 0; column < terrain[line].length; column++) {
                if (terrain[line][column] < 0) {
                    volumeOfWater += terrain[line][column];
                }
            }
        }

        return Math.abs(volumeOfWater);
    }

    //Alínea G - Função visualizar quantos metros terá de subir a água para inundar todo o terreno
    private static int totalFlood(int maxValue) {
        return (maxValue >= 0 ? maxValue + 1 : 0);
    }

    //Alínea H - Procedimento para calcular os incrementos em m2 de área inundada, por cada subida da água em metros,
    // até ficar tudo submerso
    private static void calculateIncrementsUntilAllSubmersed(int[][] terrain, int increment, int totalFlood) {
        int[][] terrainToSubmerge = cloneArray(terrain);
        int lastSubmergedAreas = countSubmergedAreas(terrain);
        int actualSubmergedAreas;

        for (int meter = 1; meter <= totalFlood; meter++) {
            changeWaterLevel(terrainToSubmerge, increment);
            actualSubmergedAreas = countSubmergedAreas(terrainToSubmerge);
            printIncrements(meter, (actualSubmergedAreas - lastSubmergedAreas));
            lastSubmergedAreas = actualSubmergedAreas;
        }
    }

    //Alínea H - Procedimento para imprimir o valor de subida de água em metros e o respetivo número de m2 que passam a
    // ficar inundados
    private static void printIncrements(int meter, int newSubmergedArea) {
        System.out.printf("%18d | %18d%n", meter, newSubmergedArea);
    }

    //Alínea I - Procedimento para calcular as coordenadas do terreno ideais para colocar um cubo
    private static void terrainCoordinates(int[][] terrain, int cubeSide, int topCube) {
        int coordinateLine = 0, coordinateColumn = 0, coordinateLineMinSum = 0, coordinateColumnMinSum = 0, minSum = Integer.MAX_VALUE;
        boolean placeTerrainCube = false;

        if (terrain.length >= cubeSide && terrain[0].length >= cubeSide) {
            while (coordinateLine + cubeSide <= terrain.length) {
                while (coordinateColumn + cubeSide <= terrain[coordinateLine].length) {

                    int sum = landMobilize(terrain, coordinateLine, coordinateColumn, cubeSide, topCube);

                    if (minSum > sum) {
                        minSum = sum;
                        coordinateLineMinSum = coordinateLine;
                        coordinateColumnMinSum = coordinateColumn;
                    }

                    coordinateColumn++;
                }

                coordinateLine++;
                coordinateColumn = 0;
            }

            placeTerrainCube = true;
        }

        printTerrainCoordinatesInformation(placeTerrainCube, coordinateLineMinSum, coordinateColumnMinSum, minSum);
    }

    //Alínea I - Função para calcular a terra a mobilizar do terreno para colocar um cubo
    private static int landMobilize(int[][] terrain, int coordinateLine, int coordinateColumn, int cubeSide, int topCube) {
        int sum = 0;
        int bottomCube = topCube - cubeSide;

        for (int line = coordinateLine; line < coordinateLine + cubeSide; line++) {
            for (int column = coordinateColumn; column < coordinateColumn + cubeSide; column++) {
                sum += Math.max(terrain[line][column], bottomCube) - Math.min(terrain[line][column], bottomCube);
            }
        }

        return sum;
    }

    //Alínea I - Procedimento para imprimir a informação sobre as coordenadas do terreno ideais para colocar um cubo e o valor da terra a imobilizar
    private static void printTerrainCoordinatesInformation(boolean placeTerrainCube, int coordinateLineMinSum, int coordinateColumnMinSum, int minSum) {
        if (placeTerrainCube) {
            System.out.printf("%s %c%d%c%d%s %d %s%n", "coordenadas do cubo:", '(', coordinateLineMinSum, ',', coordinateColumnMinSum, "), terra a mobilizar:", minSum, "m2");
        } else {
            System.out.println("não é possível colocar o cubo no terreno");
        }
    }

    //Alínea J - Função para descobrir se existe um caminho seco na vertical mais a este possível, para ser atravessado
    private static int searchVerticalDryPath(int[][] terrain) {
        boolean foundNotDryPath, foundDryPath = false;
        int dryPathPosition = -1;
        int line, column = terrain[0].length - 1;

        while (!foundDryPath && column >= 0) {

            line = 0;
            foundNotDryPath = false;

            while (!foundNotDryPath && line < terrain.length) {

                if (terrain[line][column] < 0) {
                    foundNotDryPath = true;
                }

                line++;
            }

            if (!foundNotDryPath) {
                foundDryPath = true;
                dryPathPosition = column;
            }

            column--;
        }

        return dryPathPosition;
    }

    //Alínea J - Procedimento para imprimir a informação sobre o caminho vertical seco
    private static void printVerticalDryPathInformation(int dryVerticalPathColumn) {
        if (dryVerticalPathColumn >= 0) {
            System.out.printf("%s (%d)%n", "caminho seco na vertical na coluna", dryVerticalPathColumn);
        } else {
            System.out.println("não há caminho seco na vertical");
        }
    }

    //Função para copiar um array de inteiros
    private static int[][] cloneArray(int[][] arrayToClone) {
        int[][] clonedArray = new int[arrayToClone.length][arrayToClone[0].length];

        for (int line = 0; line < arrayToClone.length; line++) {
            for (int column = 0; column < arrayToClone[line].length; column++) {
                clonedArray[line][column] = arrayToClone[line][column];
            }
        }

        return clonedArray;
    }

    //Função para contar o número de dígitos de um número
    private static int countNumberDigits(int number) {
        int count = 1;

        while (number > 9) {

            number /= 10;
            count++;

        }

        return count;
    }

    //Função para ver o valor maior do terreno
    private static int maxValue(int[][] terrain) {
        int maxValue = Integer.MIN_VALUE;

        for (int line = 0; line < terrain.length; line++) {
            for (int column = 0; column < terrain[line].length; column++) {
                if (terrain[line][column] > maxValue) {
                    maxValue = terrain[line][column];
                }
            }
        }
        return maxValue;
    }
}
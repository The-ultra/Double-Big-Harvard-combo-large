import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class executor {


    Short instructionMemory[] = new Short[10230];
    Byte dataMemory[] = new Byte[2047];
    Byte[] registers = new Byte[63];
    Short[] statusReg = new Short[7];
    int programCounter = 0;

    public void executor() {


        parser("test.txt");

        function();
    }


    public void function() {

        ArrayList decoded = null;
        Short fetchGetter = null;

        while (programCounter < instructionMemory.length - 1) {
            execute(decoded);
            decoded = decode(fetchGetter);
            fetchGetter = fetch();
            programCounter++;
        }


    }

    public void parser(String filename) {


        try {
            //the file to be opened for reading
            FileInputStream fis = new FileInputStream(filename);
            Scanner sc = new Scanner(fis);    //file to be scanned
            // returns true if there is another line to read
            int instructionLocation = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(" ");
                if (parts != null) {
                    parsing(parts, instructionLocation);
                    instructionLocation++;
                    //returns the line that was skipped
                }
            }
            sc.close();     //closes the scanner
        } catch (IOException e) {

            System.out.print("end of lines");
        }
    }

    public void parsing(String[] parts, int location) {
        switch (parts[0]) {

            case "ADD":
                parseAdd(parts[1], parts[2], location);
                break;
            case "SUB":
                parseSub(parts[1], parts[2], location);
                break;
            case "MUL":
                parseMul(parts[1], parts[2], location);
                break;
            case "LDI":
                parseLDI(parts[1], parts[2], location);
                break;
            case "BEQZ":
                parseBEQZ(parts[1], parts[2], location);
                break;
            case "AND":
                parseAnd(parts[1], parts[2], location);
                break;
            case "OR":
                parseOr(parts[1], parts[2], location);
                break;
            case "JR":
                parseJR(parts[1], parts[2], location);
                break;
            case "SLC":
                parseSLC(parts[1], parts[2], location);
                break;
            case "SRC":
                parseSRC(parts[1], parts[2], location);
                break;
            case "LB":
                parseLB(parts[1], parts[2], location);
                break;
            case "SB":
                parseSB(parts[1], parts[2], location);
                break;

        }
    }

    public void parseAdd(String r1, String r2, int location) {

        String addR1 = r1.substring(1);
        String addR2 = r2.substring(1);
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "0000" + addStr1 + addStr2;
        instructionMemory[location] = Short.parseShort(addFinalThing, 2);
    }

    public void parseSub(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2.substring(1);
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "0001" + addStr1 + addStr2;
        instructionMemory[location] = Short.parseShort(addFinalThing, 2);
    }

    public void parseMul(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2.substring(1);
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "0010" + addStr1 + addStr2;
        instructionMemory[location] = Short.parseShort(addFinalThing, 2);
    }

    public void parseLDI(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2;
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "0011" + addStr1 + addStr2;
        instructionMemory[location] = Short.parseShort(addFinalThing, 2);
    }

    public void parseBEQZ(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2;
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "0100" + addStr1 + addStr2;
        instructionMemory[location] = Short.parseShort(addFinalThing, 2);
    }

    public void parseAnd(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2.substring(1);
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "0101" + addStr1 + addStr2;
        instructionMemory[location] = Short.parseShort(addFinalThing, 2);
    }

    public void parseOr(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2.substring(1);
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "0110" + addStr1 + addStr2;
        instructionMemory[location] = Short.parseShort(addFinalThing, 2);
    }

    public void parseJR(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2.substring(1);
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "0111" + addStr1 + addStr2;
        instructionMemory[location] = Short.parseShort(addFinalThing, 2);
    }

    public void parseSLC(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2;
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "1000" + addStr1 + addStr2;
        instructionMemory[location] = Short.parseShort(addFinalThing, 2);
    }

    public void parseSRC(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2;
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "1001" + addStr1 + addStr2;
        instructionMemory[location] = Short.parseShort(addFinalThing, 2);
    }

    public void parseLB(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2;
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "1010" + addStr1 + addStr2;
        instructionMemory[location] = Short.parseShort(addFinalThing, 2);
    }

    public void parseSB(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2;
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        }
        if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        }
        if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "1011" + addStr1 + addStr2;
        instructionMemory[location] = Short.parseShort(addFinalThing, 2);
    }


    public short fetch() {

        return instructionMemory[programCounter];


    }

    public ArrayList decode(Short instruction) {
        ArrayList<Short> output = null;

        short address;
        short opcode;
        short r1;
        short r2;
        short imm;


        opcode = (short) ((instruction & 0b1111000000000000) >> 12);
        r1 = (short) ((instruction & 0b0000111111000000) >> 6);
        r2 = (short) ((instruction & 0b0000000000111111) >> 0);
        imm = (short) ((instruction & 0b0000000000111111) >> 0);

        output.add(opcode);     //pos 0
        output.add(r1);         //pos 1
        output.add(r2);         //pos 2
        output.add(imm);        //pos 3

        return output;

    }


    public void execute(ArrayList<Short> input) {
        //this Decides using the value of opcode upon which function to execute
        // thus if opcode ==  0 then it adds, if 1 it subtracts and so on
        switch (input.get(0)) {
            case 0:
                short r1 = input.get(2);
                short r2 = input.get(3);
                add(r1, r2);
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;


        }
    }

    public void add(int r1, int r2) {


        System.out.println("change");

        // adds r1 to r2 and then store in r1 location


    }


    //----------------------------------------------------------------------------------------------------------------------
    //fetchers and writers.... why? someone would ask, well it's for pipelining. just use them in the program
    public int dataRegFetcher(int rPos) {
        return registers[rPos];

    }

    public void dataRegWriter(int rPos, Byte value) {
        registers[rPos] = value;
    }


    public int dataMemoryFetcher(int mPos) {
        return dataMemory[mPos];

    }

    public void dataMemoryWriter(int mPos, Byte value) {
        dataMemory[mPos] = value;
    }

    public int instructionMemoryFetcher(int iMPos) {


        return instructionMemory[iMPos];
    }

    public void instructionMemoryWriter(int iMPos, short value) {
        instructionMemory[iMPos] = value;
    }
//----------------------------------------------------------------------------------------------------------------------
    //flags in SREG

    public int zeroFlagFetch() {

        return statusReg[0];
    }

    public void setZeroFlag(short value) {

        if (value == 0 || value == 1) {
            statusReg[0] = value;
        } else
            System.out.println("Insert correct value please");

    }


    public int signFlagFetch() {
        return statusReg[1];
    }

    public void setSignFlag(short value) {
        if (value == 0 || value == 1) {
            statusReg[1] = value;
        } else
            System.out.println("Insert correct either 1 or 0 please");

    }

    public int negativeFlagFetch() {
        return statusReg[2];
    }

    public void setNegativeFlag(short value) {
        if (value == 0 || value == 1) {
            statusReg[2] = value;
        } else
            System.out.println("Insert correct either 1 or 0 please");

    }

    public int twoComplementOverflowFlagFetch() {
        return statusReg[3];
    }

    public void twoComplementOverflowFlag(short value) {
        if (value == 0 || value == 1) {
            statusReg[3] = value;
        } else
            System.out.println("Insert correct either 1 or 0 please");

    }


    public int carryFlagFetch() {
        return statusReg[4];
    }

    public void setCarryFlag(short value) {
        if (value == 0 || value == 1) {
            statusReg[4] = value;
        } else
            System.out.println("Insert correct either 1 or 0 please");

    }


}

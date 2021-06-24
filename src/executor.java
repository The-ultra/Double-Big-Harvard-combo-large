import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class executor {

    ArrayList<Short> instructionMemory = new ArrayList<Short>(1023);
    Byte dataMemory[] = new Byte[2047];
    Byte[] registers = new Byte[63];
    Short[] statusReg = new Short[7];
    int programCounter = 0;

    public executor() {
        parser("test.txt");
        function();
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
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "0000" + addStr1 + addStr2;
        instructionMemory.set(location, Short.parseShort(addFinalThing, 2));
    }

    public void parseSub(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2.substring(1);
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "0001" + addStr1 + addStr2;
        instructionMemory.set(location, Short.parseShort(addFinalThing, 2));
    }

    public void parseMul(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2.substring(1);
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "0010" + addStr1 + addStr2;
        instructionMemory.set(location, Short.parseShort(addFinalThing, 2));
    }

    public void parseLDI(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2;
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "0011" + addStr1 + addStr2;
        instructionMemory.set(location, Short.parseShort(addFinalThing, 2));
    }

    public void parseBEQZ(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2;
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "0100" + addStr1 + addStr2;
        instructionMemory.add( Short.parseShort(addFinalThing, 2));
    }

    public void parseAnd(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2.substring(1);
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "0101" + addStr1 + addStr2;
        instructionMemory.add( Short.parseShort(addFinalThing, 2));
    }

    public void parseOr(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2.substring(1);
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "0110" + addStr1 + addStr2;
        instructionMemory.add( Short.parseShort(addFinalThing, 2));
    }

    public void parseJR(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2.substring(1);
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
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
        instructionMemory.add( Short.parseShort(addFinalThing, 2));
    }

    public void parseSLC(String r1, String r2, int location) {


        String addR1 = r1.substring(1);
        String addR2 = r2;
        int addTheR1 = Integer.parseInt(addR1);
        int addTheR2 = Integer.parseInt(addR2);
        String addStr1 = Integer.toBinaryString(addTheR1);
        if ((Integer.parseInt(addStr1) <= (2 ^ 0))) {
            addStr1 = "00000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 1))) {
            addStr1 = "0000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 3))) {
            addStr1 = "000" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr1 = "00" + addStr1;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 5))) {
            addStr1 = "0" + addStr1;
        }


        String addStr2 = Integer.toBinaryString(addTheR2);


        if ((Integer.parseInt(addStr2) <= (2 ^ 0))) {
            addStr2 = "00000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 1))) {
            addStr2 = "0000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 3))) {
            addStr2 = "000" + addStr2;
        } else if ((Integer.parseInt(addStr1) <= (2 ^ 4))) {
            addStr2 = "00" + addStr2;
        } else if ((Integer.parseInt(addStr2) <= (2 ^ 5))) {
            addStr2 = "0" + addStr2;
        }
        String addFinalThing = "1000" + addStr1 + addStr2;
        instructionMemory.add( Short.parseShort(addFinalThing, 2));
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
        instructionMemory.add( Short.parseShort(addFinalThing, 2));
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
        instructionMemory.add( Short.parseShort(addFinalThing, 2));
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
        instructionMemory.add( Short.parseShort(addFinalThing, 2));
    }


    public void function() {

        ArrayList decoded = null;
        Short fetchGetter = null;

        while (programCounter < instructionMemory.size() - 1) {
            execute(decoded);////// msh elmafrood en heya fel awl beteb2a null?
            decoded = decode(fetchGetter);
            fetchGetter = fetch();
            programCounter++;
        }

    }

    public short fetch() {

        return instructionMemory.get(programCounter);

    }

    public ArrayList decode(Short instruction) {
        if (instruction != null) {
            ArrayList<Short> output = null;

            short opcode;
            short r1;
            short r2;
            short imm;

            opcode = (short) ((instruction & 0b1111000000000000) >> 12);
            r1 = (short) ((instruction & 0b0000111111000000) >> 6);
            r2 = (short) ((instruction & 0b0000000000111111) >> 0);
            imm = (short) ((instruction & 0b0000000000111111) >> 0);

            output.add(opcode); // pos 0
            output.add(r1); // pos 1
            output.add(r2); // pos 2
            output.add(imm); // pos 3

            return output;

        }
        return null;
    }

    public void execute(ArrayList<Object> input) {
        // this Decides using the value of opcode upon which function to execute
        // thus if opcode == 0 then it adds, if 1 it subtracts and so on
        if (input != null) {
            switch ((short) input.get(0)) {
                case 0:
                    short r1 = (short) input.get(1);
                    short r2 = (short) input.get(2);
                    add(r1, r2);
                    break;
                case 1:
                    r1 = (short) input.get(1);
                    r2 = (short) input.get(2);
                    sub(r1, r2);

                    break;
                case 2:
                    r1 = (short) input.get(1);
                    r2 = (short) input.get(2);
                    mult(r1, r2);
                    break;
                case 3:
                    r1 = (short) input.get(1);
                    byte imm = (byte) input.get(3);
                    loadImm(r1, imm);
                    break;
                case 4:
                    r1 = (short) input.get(1);
                    imm = (byte) input.get(3);
                    branchIfEq(r1, imm);
                    break;
                case 5:
                    r1 = (short) input.get(1);
                    r2 = (short) input.get(2);
                    and(r1, r2);
                    break;
                case 6:
                    r1 = (short) input.get(1);
                    r2 = (short) input.get(2);
                    or(r1, r2);
                    break;
                case 7:
                    r1 = (short) input.get(1);
                    r2 = (short) input.get(2);
                    jumpReg(r1, r2);
                    break;
                case 8:
                    r1 = (short) input.get(1);
                    imm = (byte) input.get(3);
                    ShiftLeftCircular(r1, imm);
                    break;
                case 9:
                    r1 = (short) input.get(1);
                    imm = (byte) input.get(3);
                    ShiftRightCircular(r1, imm);
                    break;
                case 10:
                    r1 = (short) input.get(1);
                    loadByte(r1, (byte) input.get(3));
                    break;
                case 11:
                    r1 = (short) input.get(1);
                    storeByte(r1, (byte) input.get(3));
                    break;

            }
        }
    }

    public void add(Short r1, Short r2) {

        Byte num1 = dataRegFetcher(r1);
        Byte num2 = dataRegFetcher(r2);
        boolean check1;
        boolean check2;

        int temp1 = (int) num1 + (int) num2;
        // Check Carry
        if (temp1 > 256)
            setCarryFlag((short) 1);
        else
            setCarryFlag((short) 0);
        // Check Overflow
        if ((int) num1 > 0 && (int) num2 > 0)
            twoComplementOverflowFlag((short) 1);
        if ((int) num1 < 0 && (int) num2 < 0)
            twoComplementOverflowFlag((short) 1);
        if ((int) num1 > 0 && (int) num2 < 0)
            twoComplementOverflowFlag((short) 0);
        if ((int) num1 < 0 && (int) num2 > 0)
            twoComplementOverflowFlag((short) 0);
        // Check negative
        if (temp1 < 0)
            setNegativeFlag((short) 1);
        else
            setNegativeFlag((short) 0);
        // Check sign
        if (negativeFlagFetch() == 1) {
            check1 = true;
        } else {
            check1 = false;
        }
        if (twoComplementOverflowFlagFetch() == 1) {
            check2 = true;
        } else {
            check2 = false;
        }
        if ((check1 ^ check2))
            setSignFlag((short) 1);
        else
            setSignFlag((short) 0);
        // Check Zero
        if (temp1 == 0)
            setZeroFlag((short) 1);
        else
            setZeroFlag((short) 0);

        registers[r1] = (byte) temp1;
        System.out.println("change");

        // adds r1 to r2 and then store in r1 location
    }

    public void sub(short r1, short r2) {

        Byte num1 = dataRegFetcher(r1);
        Byte num2 = dataRegFetcher(r2);
        boolean check1;
        boolean check2;

        int temp = (int) num1 - (int) num2;

        // Check Carry
        if (temp > 256)
            setCarryFlag((short) 1);
        else
            setCarryFlag((short) 0);
        // Check Overflow
        if ((int) num1 > 0 && (int) num2 > 0)
            twoComplementOverflowFlag((short) 1);
        if ((int) num1 < 0 && (int) num2 < 0)
            twoComplementOverflowFlag((short) 1);
        if ((int) num1 > 0 && (int) num2 < 0)
            twoComplementOverflowFlag((short) 0);
        if ((int) num1 < 0 && (int) num2 > 0)
            twoComplementOverflowFlag((short) 0);
        // Check negative
        if (temp < 0)
            setNegativeFlag((short) 1);
        else
            setNegativeFlag((short) 0);
        // Check sign
        if (negativeFlagFetch() == 1) {
            check1 = true;
        } else {
            check1 = false;
        }
        if (twoComplementOverflowFlagFetch() == 1) {
            check2 = true;
        } else {
            check2 = false;
        }
        if ((check1 ^ check2))
            setSignFlag((short) 1);
        else
            setSignFlag((short) 0);
        // Check Zero
        if (temp == 0)
            setZeroFlag((short) 1);
        else
            setZeroFlag((short) 0);

        registers[r1] = (byte) temp;
    }

    public void mult(short r1, short r2) {
        Byte num1 = dataRegFetcher(r1);
        Byte num2 = dataRegFetcher(r2);
        boolean check1;
        boolean check2;

        int temp = (int) num1 * (int) num2;

        // Check Carry
        if (temp > 256)
            setCarryFlag((short) 1);
        else
            setCarryFlag((short) 0);
        // Check Overflow
        if ((int) num1 > 0 && (int) num2 > 0)
            twoComplementOverflowFlag((short) 1);
        if ((int) num1 < 0 && (int) num2 < 0)
            twoComplementOverflowFlag((short) 1);
        if ((int) num1 > 0 && (int) num2 < 0)
            twoComplementOverflowFlag((short) 0);
        if ((int) num1 < 0 && (int) num2 > 0)
            twoComplementOverflowFlag((short) 0);
        // Check negative
        if (temp < 0)
            setNegativeFlag((short) 1);
        else
            setNegativeFlag((short) 0);
        // Check sign
        if (negativeFlagFetch() == 1) {
            check1 = true;
        } else {
            check1 = false;
        }
        if (twoComplementOverflowFlagFetch() == 1) {
            check2 = true;
        } else {
            check2 = false;
        }
        if ((check1 ^ check2))
            setSignFlag((short) 1);
        else
            setSignFlag((short) 0);
        // Check Zero
        if (temp == 0)
            setZeroFlag((short) 1);
        else
            setZeroFlag((short) 0);

        registers[r1] = (byte) temp;
    }

    public void loadImm(short r1, Byte imm) {
        registers[r1] = imm;
    }

    public void branchIfEq(short r1, Byte imm) {
        if (r1 == 0) {
            programCounter = programCounter + 1 + imm;
        }
    }

    public void and(short r1, short r2) {
        Byte num1 = dataRegFetcher(r1);
        Byte num2 = dataRegFetcher(r2);

        int temp1 = num1 & num2;
        // Check negative
        if (temp1 < 0)
            setNegativeFlag((short) 1);
        else
            setNegativeFlag((short) 0);
        if (temp1 == 0)
            setZeroFlag((short) 1);
        else
            setZeroFlag((short) 0);

        registers[r1] = (byte) temp1;
    }

    public void or(short r1, short r2) {
        Byte num1 = dataRegFetcher(r1);
        Byte num2 = dataRegFetcher(r2);

        int temp1 = num1 | num2;
        // Check negative
        if (temp1 < 0)
            setNegativeFlag((short) 1);
        else
            setNegativeFlag((short) 0);
        if (temp1 == 0)
            setZeroFlag((short) 1);
        else
            setZeroFlag((short) 0);

        registers[r1] = (byte) temp1;
    }

    public void jumpReg(short r1, short r2) {
        Byte num1 = dataRegFetcher(r1);
        Byte num2 = dataRegFetcher(r2);
        int x = (int) num1;
        int y = (int) num2;
        int k = Integer.valueOf(String.valueOf(x) + String.valueOf(y));
        programCounter = k;
    }

    public void loadByte(short r1, byte address) {
        byte value = (byte) dataMemoryFetcher(address);
        dataRegWriter(r1,value);



    }

    public void storeByte(short r1, int address) {
       byte value = dataRegFetcher(r1);

        dataMemoryWriter(address,value);

    }

    public void ShiftRightCircular(short R1, short imm) {



        int num = dataRegFetcher(R1);
        int shifted = (num >> imm | num << 32 - imm) - 1;

        if (shifted<0) {

            setNegativeFlag((short) 1);
        } else {

            setNegativeFlag((short) 0);
        }

        if (shifted == 0)
            setZeroFlag((short) 1);
        else
            setZeroFlag((short) 0);

        dataRegWriter(R1, (byte) shifted);

    }

    public void ShiftLeftCircular(short R1, short imm) {

        int num = dataRegFetcher(R1);
        int shifted = (num << imm  | num >> 32 - imm) - 1;

        if (shifted<0) {
            setNegativeFlag((short) 1);
        } else {

            setNegativeFlag((short) 0);
        }

        if (shifted == 0)
            setZeroFlag((short) 1);
        else
            setZeroFlag((short) 0);

        dataRegWriter(R1, (byte) shifted);

    }

    // ----------------------------------------------------------------------------------------------------------------------
    // fetchers and writers.... why? someone would ask, well it's for pipelining.
    // just use them in the program
    public byte dataRegFetcher(Short rPos) {
        return registers[rPos];

    }

    public void dataRegWriter(int rPos, Byte value) {
        registers[rPos] = value;
    }

    public byte dataMemoryFetcher(byte mPos) {
        return dataMemory[mPos];

    }

    public void dataMemoryWriter(int mPos, Byte value) {
        dataMemory[mPos] = value;
    }
//----------------------------------------------------------------------------------------------------------------------
    // flags in SREG

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

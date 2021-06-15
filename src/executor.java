import java.util.ArrayList;

public class executor {


    Short instructionMemory[] = new Short[1023];
    Byte dataMemory[] = new Byte[2047];
    Byte[] registers = new Byte[63];
    Short[] statusReg = new Short[7];
    int programCounter = 0;

    public void executor() {


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

    public void add(Short r1, Short r2) {

        Byte num1 = dataRegFetcher(r1);
        Byte num2 = dataRegFetcher(r2);
        boolean check1;
        boolean check2;

        int temp1 = (int) num1 + (int) num2;
        //Check Carry
        if (temp1 > 256)
            setCarryFlag((short) 1);
        else
            setCarryFlag((short) 0);
        //Check Overflow
        if ((int) num1 > 0 && (int) num2 > 0)
            twoComplementOverflowFlag((short) 1);
        if ((int) num1 < 0 && (int) num2 < 0)
            twoComplementOverflowFlag((short) 1);
        if ((int) num1 > 0 && (int) num2 < 0)
            twoComplementOverflowFlag((short) 0);
        if ((int) num1 < 0 && (int) num2 > 0)
            twoComplementOverflowFlag((short) 0);
        //Check negative
        if (temp1 < 0)
            setNegativeFlag((short) 1);
        else
            setNegativeFlag((short) 0);
        //Check sign
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
        //Check Zero
        if (temp1 == 0)
            setZeroFlag((short) 1);
        else
            setZeroFlag((short) 0);


        System.out.println("change");

        // adds r1 to r2 and then store in r1 location
    }

    public void sub(short r1, short r2) {

        Byte num1 = dataRegFetcher(r1);
        Byte num2 = dataRegFetcher(r2);
        boolean check1;
        boolean check2;

        int temp = (int) num1 - (int) num2;

        //Check Carry
        if (temp > 256)
            setCarryFlag((short) 1);
        else
            setCarryFlag((short) 0);
        //Check Overflow
        if ((int) num1 > 0 && (int) num2 > 0)
            twoComplementOverflowFlag((short) 1);
        if ((int) num1 < 0 && (int) num2 < 0)
            twoComplementOverflowFlag((short) 1);
        if ((int) num1 > 0 && (int) num2 < 0)
            twoComplementOverflowFlag((short) 0);
        if ((int) num1 < 0 && (int) num2 > 0)
            twoComplementOverflowFlag((short) 0);
        //Check negative
        if (temp < 0)
            setNegativeFlag((short) 1);
        else
            setNegativeFlag((short) 0);
        //Check sign
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
        //Check Zero
        if (temp == 0)
            setZeroFlag((short) 1);
        else
            setZeroFlag((short) 0);
    }

    public void mult(short r1, short r2) {
        Byte num1 = dataRegFetcher(r1);
        Byte num2 = dataRegFetcher(r2);
        boolean check1;
        boolean check2;

        int temp = (int) num1 * (int) num2;

        //Check Carry
        if (temp > 256)
            setCarryFlag((short) 1);
        else
            setCarryFlag((short) 0);
        //Check Overflow
        if ((int) num1 > 0 && (int) num2 > 0)
            twoComplementOverflowFlag((short) 1);
        if ((int) num1 < 0 && (int) num2 < 0)
            twoComplementOverflowFlag((short) 1);
        if ((int) num1 > 0 && (int) num2 < 0)
            twoComplementOverflowFlag((short) 0);
        if ((int) num1 < 0 && (int) num2 > 0)
            twoComplementOverflowFlag((short) 0);
        //Check negative
        if (temp < 0)
            setNegativeFlag((short) 1);
        else
            setNegativeFlag((short) 0);
        //Check sign
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
        //Check Zero
        if (temp == 0)
            setZeroFlag((short) 1);
        else
            setZeroFlag((short) 0);
    }

    public void loadImm(short r1, short imm) {

    }

    public void branchIfEq(short r1, short imm) {
        if (r1 == 0) {
            programCounter = programCounter + 1 + imm;
        }
    }

    public void and(short r1, short r2) {
        Byte num1 = dataRegFetcher(r1);
        Byte num2 = dataRegFetcher(r2);

        int temp1 = num1 & num2;
        //Check negative
        if (temp1 < 0)
            setNegativeFlag((short) 1);
        else
            setNegativeFlag((short) 0);
        if (temp1 == 0)
            setZeroFlag((short) 1);
        else
            setZeroFlag((short) 0);
    }

    public void or(short r1, short r2) {
        Byte num1 = dataRegFetcher(r1);
        Byte num2 = dataRegFetcher(r2);

        int temp1 = num1 | num2;
        //Check negative
        if (temp1 < 0)
            setNegativeFlag((short) 1);
        else
            setNegativeFlag((short) 0);
        if (temp1 == 0)
            setZeroFlag((short) 1);
        else
            setZeroFlag((short) 0);
    }

    public void jumpReg(short r1, short r2) {
        Byte num1 = dataRegFetcher(r1);
        Byte num2 = dataRegFetcher(r2);
        int x = (int) num1;
        int y = (int) num2;
        int k = Integer.valueOf(String.valueOf(x) + String.valueOf(y));
        programCounter = k;
    }


    //----------------------------------------------------------------------------------------------------------------------
    //fetchers and writers.... why? someone would ask, well it's for pipelining. just use them in the program
    public Byte dataRegFetcher(Short rPos) {
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

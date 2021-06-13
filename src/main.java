public class main {


    int instructionMemory[] = new int[1023];
    int dataMemory[] = new int[2047];
    int[] registers = new int[63];
    int[] statusReg = new int[7];
    int programCounter = 0;

    public void fetch() {

        decode(instructionMemory[programCounter]); //get the current instruction to decode it
        programCounter++; //incrementation

    }

    public void decode(int instruction) {

        int address;
        int opcode;
        int r1;
        int r2;
        int imm;


        address = (instruction & 0b00001111111111111111111111111111) >> 0;
        opcode = (instruction & 0b11110000000000000000000000000000) >> 28;
        r1 = (instruction & 0b00001111000000000000000000000000) >> 24;
        r2 = (instruction & 0b00000000111100000000000000000000) >> 20;
        imm = (instruction & 0b00000000000011111111111111111111) >> 0;
        Decider(opcode, address, r1, r2, imm);

    }


    public void execute() {

    }

    public void Decider(int opcode, int address, int r1, int r2, int imm) {
        //this Decides using the value of opcode upon which function to execute
        // thus if opcode ==  0 then it adds, if 1 it subtracts and so on
        switch (opcode) {
            case 0:
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
            case 12:
                break;


        }
    }

    public void add(int r1, int r2) {
        // adds r1 to r2 and then store in r1 location


    }


    //----------------------------------------------------------------------------------------------------------------------
    //fetchers and writers.... why? someone would ask, well it's for pipelining. just use them in the program
    public int dataRegFetcher(int rPos) {
        return registers[rPos];

    }

    public void dataRegWriter(int rPos, int value) {
        registers[rPos] = value;
    }


    public int dataMemoryFetcher(int mPos) {
        return dataMemory[mPos];

    }

    public void dataMemoryWriter(int mPos, int value) {
        dataMemory[mPos] = value;
    }

    public int instructionMemoryFetcher(int iMPos) {


        return instructionMemory[iMPos];
    }

    public void instructionMemoryWriter(int iMPos, int value) {
        instructionMemory[iMPos] = value;
    }
//----------------------------------------------------------------------------------------------------------------------
    //flags in SREG

    public int zeroFlagFetch() {
        return statusReg[0];
    }

    public void setZeroFlag(int value) {

        if (value == 0 || value == 1) {
            statusReg[0] = value;
        } else
            System.out.println("Insert correct value please");

    }


    public int signFlagFetch() {
        return statusReg[1];
    }

    public void setSignFlag(int value) {
        if (value == 0 || value == 1) {
            statusReg[1] = value;
        } else
            System.out.println("Insert correct either 1 or 0 please");

    }

    public int negativeFlagFetch() {
        return statusReg[2];
    }

    public void setNegativeFlag(int value) {
        if (value == 0 || value == 1) {
            statusReg[2] = value;
        } else
            System.out.println("Insert correct either 1 or 0 please");

    }

    public int twoComplementOverflowFlagFetch() {
        return statusReg[3];
    }

    public void twoComplementOverflowFlag(int value) {
        if (value == 0 || value == 1) {
            statusReg[3] = value;
        } else
            System.out.println("Insert correct either 1 or 0 please");

    }


    public int carryFlagFetch() {
        return statusReg[4];
    }

    public void setCarryFlag(int value) {
        if (value == 0 || value == 1) {
            statusReg[4] = value;
        } else
            System.out.println("Insert correct either 1 or 0 please");

    }


}

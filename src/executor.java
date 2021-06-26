import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class executor {
	boolean jump;
	ArrayList<String> instructionMemory = new ArrayList<String>(1023);
	Byte dataMemory[] = new Byte[2047];
	Byte[] registers = new Byte[63];
	Short[] statusReg = new Short[7];
	int programCounter = 0;

	public executor() {
		parser("C:\\Users\\Ahmed Hamouda\\Documents\\GitHub\\Double-Big-Harvard-combo-large\\src\\testing.txt");
		function();
	}
	
	private  void parser(String filePath) {
		ArrayList<String[]> lines = new ArrayList<>();

		BufferedReader reader = null;
		String line = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null) {

				parsing(line.split(" "));

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
	}

	public void parsing(String[] parts) {
		switch (parts[0]) {

		case "ADD":

			parseAdd(parts[1], parts[2]);
			break;
		case "SUB":
			parseSub(parts[1], parts[2]);
			break;
		case "MUL":
			parseMul(parts[1], parts[2]);
			break;
		case "LDI":
			parseLDI(parts[1], parts[2]);
			break;
		case "BEQZ":
			parseBEQZ(parts[1], parts[2]);
			break;
		case "AND":
			parseAnd(parts[1], parts[2]);
			break;
		case "OR":
			parseOr(parts[1], parts[2]);
			break;
		case "JR":
			parseJR(parts[1], parts[2]);
			break;
		case "SLC":
			parseSLC(parts[1], parts[2]);
			break;
		case "SRC":
			parseSRC(parts[1], parts[2]);
			break;
		case "LB":
			parseLB(parts[1], parts[2]);
			break;
		case "SB":
			parseSB(parts[1], parts[2]);
			break;

		}
		String x="";
		for (int i = 0; i < instructionMemory.size(); i++) {
			if(instructionMemory.get(i)!= null)
			x = x + i + instructionMemory.get(i).toString() + "\n";
					}

	}

	public void parseAdd(String r1, String r2) {

		String addR1 = r1.substring(1);
		String addR2 = r2.substring(1);
		int addTheR1 = Integer.parseInt(addR1);
		int addTheR2 = Integer.parseInt(addR2);
		String addStr1 = Integer.toBinaryString(addTheR1);

		 if ((Integer.parseInt(addStr1,2) <= 1)) {
			addStr1 = "00000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 3)) {
			addStr1 = "0000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 7)) {
			addStr1 = "000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 15)) {
			addStr1 = "00" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr1 = "0" + addStr1;
		}

		String addStr2 = Integer.toBinaryString(addTheR2);

		if ((Integer.parseInt(addStr2,2) <= 1)) {
			addStr2 = "00000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 3)) {
			addStr2 = "0000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= (Math.pow(2, 3)))) {
			addStr2 = "000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= (Math.pow(2, 3)))) {
			addStr2 = "000" + addStr2;
		} else if ((Integer.parseInt(addStr1,2) <= (Math.pow(2, 4)))) {
			addStr2 = "00" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= (Math.pow(2, 5)))) {
			addStr2 = "0" + addStr2;
		}
		String addFinalThing = "0000" + addStr1 + addStr2;
		instructionMemory.add(addFinalThing);
	}

	public void parseSub(String r1, String r2) {

		String addR1 = r1.substring(1);
		String addR2 = r2.substring(1);
		int addTheR1 = Integer.parseInt(addR1);
		int addTheR2 = Integer.parseInt(addR2);
		String addStr1 = Integer.toBinaryString(addTheR1);



		if ((Integer.parseInt(addStr1,2) <= 1)) {
			addStr1 = "00000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 3)) {
			addStr1 = "0000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 7)) {
			addStr1 = "000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 15)) {
			addStr1 = "00" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr1 = "0" + addStr1;
		}

		String addStr2 = Integer.toBinaryString(addTheR2);

		if ((Integer.parseInt(addStr2,2) <= 1)) {
			addStr2 = "00000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 3)) {
			addStr2 = "0000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 7)) {
			addStr2 = "000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 15)) {
			addStr2 = "00" + addStr2;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr2 = "0" + addStr2;
		}


		String addFinalThing = "0001" + addStr1 + addStr2;
		instructionMemory.add(addFinalThing);
	}

	public void parseMul(String r1, String r2) {

		String addR1 = r1.substring(1);
		String addR2 = r2.substring(1);
		int addTheR1 = Integer.parseInt(addR1);
		int addTheR2 = Integer.parseInt(addR2);
		String addStr1 = Integer.toBinaryString(addTheR1);
		if ((Integer.parseInt(addStr1,2) <= 1)) {
			addStr1 = "00000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 3)) {
			addStr1 = "0000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 7)) {
			addStr1 = "000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 15)) {
			addStr1 = "00" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr1 = "0" + addStr1;
		}


		String addStr2 = Integer.toBinaryString(addTheR2);
		if ((Integer.parseInt(addStr2,2) <= 1)) {
			addStr2 = "00000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 3)) {
			addStr2 = "0000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 7)) {
			addStr2 = "000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 15)) {
			addStr2 = "00" + addStr2;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr2 = "0" + addStr2;
		}

		String addFinalThing = "0010" + addStr1 + addStr2;
		instructionMemory.add(addFinalThing);
	}

	public void parseLDI(String r1, String r2) {

		String addR1 = r1.substring(1);
		String addR2 = r2;
		int addTheR1 = Integer.parseInt(addR1);
		int addTheR2 = Integer.parseInt(addR2);

		String addStr1 = Integer.toBinaryString(addTheR1);

		if ((Integer.parseInt(addStr1,2)  <= 1)) {
			addStr1 = "00000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 3)) {
			addStr1 = "0000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 7)) {
			addStr1 = "000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 15)) {
			addStr1 = "00" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr1 = "0" + addStr1;
		}

		String addStr2 = Integer.toBinaryString(addTheR2);

		if ((Integer.parseInt(addStr2,2) <= 1))		 {
			addStr2 = "00000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 3)) {
			addStr2 = "0000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 7)) {
			addStr2 = "000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 15)) {
			addStr2 = "00" + addStr2;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr2 = "0" + addStr2;
		}





		String addFinalThing = "0011" + addStr1 + addStr2;
		instructionMemory.add(addFinalThing);
	}

	public void parseBEQZ(String r1, String r2) {

		String addR1 = r1.substring(1);
		String addR2 = r2;
		int addTheR1 = Integer.parseInt(addR1);
		int addTheR2 = Integer.parseInt(addR2);
		String addStr1 = Integer.toBinaryString(addTheR1);
		if ((Integer.parseInt(addStr1,2) <= 1)) {
			addStr1 = "00000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 3)) {
			addStr1 = "0000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 7)) {
			addStr1 = "000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 15)) {
			addStr1 = "00" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr1 = "0" + addStr1;
		}

		String addStr2 = Integer.toBinaryString(addTheR2);

		if ((Integer.parseInt(addStr2,2) <= 1)) {
			addStr2 = "00000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 3)) {
			addStr2 = "0000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 7)) {
			addStr2 = "000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 15)) {
			addStr2 = "00" + addStr2;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr2 = "0" + addStr2;
		}

		String addFinalThing = "0100" + addStr1 + addStr2;
		instructionMemory.add(addFinalThing);
	}

	public void parseAnd(String r1, String r2) {

		String addR1 = r1.substring(1);
		String addR2 = r2.substring(1);
		int addTheR1 = Integer.parseInt(addR1);
		int addTheR2 = Integer.parseInt(addR2);
		String addStr1 = Integer.toBinaryString(addTheR1);
		if ((Integer.parseInt(addStr1,2) <= 1)) {
			addStr1 = "00000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 3)) {
			addStr1 = "0000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 7)) {
			addStr1 = "000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 15)) {
			addStr1 = "00" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr1 = "0" + addStr1;
		}

		String addStr2 = Integer.toBinaryString(addTheR2);

		if ((Integer.parseInt(addStr2,2) <= 1)) {
			addStr2 = "00000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 3)) {
			addStr2 = "0000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 7)) {
			addStr2 = "000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 15)) {
			addStr2 = "00" + addStr2;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr2 = "0" + addStr2;
		}

		String addFinalThing = "0101" + addStr1 + addStr2;
		instructionMemory.add(addFinalThing);
	}

	public void parseOr(String r1, String r2) {

		String addR1 = r1.substring(1);
		String addR2 = r2.substring(1);
		int addTheR1 = Integer.parseInt(addR1);
		int addTheR2 = Integer.parseInt(addR2);
		String addStr1 = Integer.toBinaryString(addTheR1);
		if ((Integer.parseInt(addStr1,2) <= 1)) {
			addStr1 = "00000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 3)) {
			addStr1 = "0000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 7)) {
			addStr1 = "000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 15)) {
			addStr1 = "00" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr1 = "0" + addStr1;
		}

		String addStr2 = Integer.toBinaryString(addTheR2);

		if ((Integer.parseInt(addStr2,2) <= 1)) {
			addStr2 = "00000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 3)) {
			addStr2 = "0000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 7)) {
			addStr2 = "000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 15)) {
			addStr2 = "00" + addStr2;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr2 = "0" + addStr2;
		}

		String addFinalThing = "0110" + addStr1 + addStr2;
		instructionMemory.add(addFinalThing);
	}

	public void parseJR(String r1, String r2) {

		String addR1 = r1.substring(1);
		String addR2 = r2.substring(1);
		int addTheR1 = Integer.parseInt(addR1);
		int addTheR2 = Integer.parseInt(addR2);
		String addStr1 = Integer.toBinaryString(addTheR1);
		if ((Integer.parseInt(addStr1,2) <= 1)) {
			addStr1 = "00000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 3)) {
			addStr1 = "0000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 7)) {
			addStr1 = "000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 15)) {
			addStr1 = "00" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr1 = "0" + addStr1;
		}
		String addStr2 = Integer.toBinaryString(addTheR2);

		if ((Integer.parseInt(addStr2,2) <= 1)) {
			addStr2 = "00000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 3)) {
			addStr2 = "0000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 7)) {
			addStr2 = "000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 15)) {
			addStr2 = "00" + addStr2;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr2 = "0" + addStr2;
		}

		String addFinalThing = "0111" + addStr1 + addStr2;
		instructionMemory.add(addFinalThing);
	}

	public void parseSLC(String r1, String r2) {

		String addR1 = r1.substring(1);
		String addR2 = r2;
		int addTheR1 = Integer.parseInt(addR1);
		int addTheR2 = Integer.parseInt(addR2);
		String addStr1 = Integer.toBinaryString(addTheR1);
		if ((Integer.parseInt(addStr1,2) <= 1)) {
			addStr1 = "00000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 3)) {
			addStr1 = "0000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 7)) {
			addStr1 = "000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 15)) {
			addStr1 = "00" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr1 = "0" + addStr1;
		}
		String addStr2 = Integer.toBinaryString(addTheR2);

		if ((Integer.parseInt(addStr2,2) <= 1)) {
			addStr2 = "00000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 3)) {
			addStr2 = "0000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 7)) {
			addStr2 = "000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 15)) {
			addStr2 = "00" + addStr2;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr2 = "0" + addStr2;
		}

		String addFinalThing = "1000" + addStr1 + addStr2;
		instructionMemory.add(addFinalThing);
	}

	public void parseSRC(String r1, String r2) {

		String addR1 = r1.substring(1);
		String addR2 = r2;
		int addTheR1 = Integer.parseInt(addR1);
		int addTheR2 = Integer.parseInt(addR2);
		String addStr1 = Integer.toBinaryString(addTheR1);
		if ((Integer.parseInt(addStr1,2) <= 1)) {
			addStr1 = "00000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 3)) {
			addStr1 = "0000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 7)) {
			addStr1 = "000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 15)) {
			addStr1 = "00" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr1 = "0" + addStr1;
		}

		String addStr2 = Integer.toBinaryString(addTheR2);

		if ((Integer.parseInt(addStr2,2) <= 1)) {
			addStr2 = "00000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 3)) {
			addStr2 = "0000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 7)) {
			addStr2 = "000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 15)) {
			addStr2 = "00" + addStr2;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr2 = "0" + addStr2;
		}

		String addFinalThing = "1001" + addStr1 + addStr2;
		instructionMemory.add(addFinalThing);
	}

	public void parseLB(String r1, String r2) {

		String addR1 = r1.substring(1);
		String addR2 = r2;
		int addTheR1 = Integer.parseInt(addR1);
		int addTheR2 = Integer.parseInt(addR2);
		String addStr1 = Integer.toBinaryString(addTheR1);
		if ((Integer.parseInt(addStr1,2) <= 1)) {
			addStr1 = "00000" + addStr1;
		}else
		if ((Integer.parseInt(addStr1,2) <= 3)) {
			addStr1 = "0000" + addStr1;
		}else

		if ((Integer.parseInt(addStr1,2) <= 7)) {
			addStr1 = "000" + addStr1;
		}else
		if ((Integer.parseInt(addStr1,2) <= 15)) {
			addStr1 = "00" + addStr1;
		}else
		if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr1 = "0" + addStr1;
		}

		String addStr2 = Integer.toBinaryString(addTheR2);

		if ((Integer.parseInt(addStr2,2) <= 1)) {
			addStr2 = "00000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 3)) {
			addStr2 = "0000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 7)) {
			addStr2 = "000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 15)) {
			addStr2 = "00" + addStr2;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr2 = "0" + addStr2;
		}

		String addFinalThing = "1010" + addStr1 + addStr2;
		instructionMemory.add(addFinalThing);
	}

	public void parseSB(String r1, String r2) {

		String addR1 = r1.substring(1);
		String addR2 = r2;
		int addTheR1 = Integer.parseInt(addR1);
		int addTheR2 = Integer.parseInt(addR2);
		String addStr1 = Integer.toBinaryString(addTheR1);



		if ((Integer.parseInt(addStr1,2) <= 1)) {
			addStr1 = "00000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 3)) {
			addStr1 = "0000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 7)) {
			addStr1 = "000" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 15)) {
			addStr1 = "00" + addStr1;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr1 = "0" + addStr1;
		}

		String addStr2 = Integer.toBinaryString(addTheR2);

		if ((Integer.parseInt(addStr2,2) <= 1)) {
			addStr2 = "00000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 3)) {
			addStr2 = "0000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 7)) {
			addStr2 = "000" + addStr2;
		} else if ((Integer.parseInt(addStr2,2) <= 15)) {
			addStr2 = "00" + addStr2;
		} else if ((Integer.parseInt(addStr1,2) <= 31)) {
			addStr2 = "0" + addStr2;
		}

		String addFinalThing = "1011" + addStr1 + addStr2;
		instructionMemory.add(addFinalThing);
	}

	public void function() {

		Object decoded = null;
		String fetchGetter =null;

		while (programCounter < instructionMemory.size()+2) {
			System.out.println("/------------------------------------------");
			System.out.println("Current Clock Cycle:" + programCounter);
			System.out.println("/------------------------------------------");
			if (jump) {
				decoded = null;
				fetchGetter = null;
				jump = false;
			}

			if (decoded != null) {
				execute(decoded);////// msh elmafrood en heya fel awl beteb2a null?
			}
			if (fetchGetter!= null){
				decoded = decode(fetchGetter);
		}
			fetchGetter = fetch();

			System.out.println("/------------------------------------------");
			System.out.println("Register content except nulls:");
			for(int i = 0;i<registers.length; i++){
				if(registers[i]!=null){
					System.out.println("Content of R"+i+ " is "+registers[i]);
				}
			}
			System.out.println("/------------------------------------------");
			System.out.println("instruction Memory content except nulls:");
			for(int i = 0;i<instructionMemory.size(); i++){
				if(instructionMemory.get(i)!=null){
					System.out.println("Content At " + i + " is "+ instructionMemory.get(i));
				}
			}
			System.out.println("/------------------------------------------");
			System.out.println("Data Memory content except nulls:");
			for(int i = 0;i<dataMemory.length; i++){
				if(dataMemory[i] !=null){
					System.out.println("Content At " + i + " is "+ dataMemory[i]);
				}
			}

			System.out.println("/------------------------------------------");

			programCounter++;

		}

	}

	public String fetch() {

		if (programCounter<instructionMemory.size()) {
			System.out.println("/------------------------------------------");
			System.out.println("fetching: "+instructionMemory.get(programCounter));
			System.out.println("/------------------------------------------");
			return instructionMemory.get(programCounter);

		}else
			return null;
	}

	public ArrayList decode(String instruction) {

		if (instruction != null) {
			System.out.println("/------------------------------------------");
			System.out.println("instruction "+instruction+" is being decoded");
			System.out.println("/------------------------------------------");
			ArrayList<Object> output = new ArrayList<Object>();
			Short opcode;
			Short r1;
			Short r2;
			Byte imm;

			opcode = Short.parseShort(instruction.substring(0, 4), 2);
			r1 = Short.parseShort(instruction.substring(4, 10), 2);
			r2 = Short.parseShort(instruction.substring(10, 16), 2);
			imm = Byte.parseByte(instruction.substring(10, 16), 2);

			output.add(opcode); // pos 0
			output.add(r1); // pos 1
			output.add(r2); // pos 2
			output.add(imm); // pos 3

			System.out.println("/------------------------------------------");
			System.out.println("Decoded Instruction is "+output);
			System.out.println("/------------------------------------------");


			return output;

		}
		return null;
	}

	public void execute(Object instruction) {
		// this Decides using the value of opcode upon which function to execute
		// thus if opcode == 0 then it adds, if 1 it subtracts and so on
		if (instruction != null) {
			System.out.println("Executing Input is "+instruction );
			ArrayList input = (ArrayList) instruction;

			switch ((short) input.get(0)) {
			case 0:
				short r1 = (short) input.get(1);
				short r2 = (short) input.get(2);
				System.out.println("/------------------------------------------");
				System.out.println("Executing Add "+input.get(1)+" "+input.get(2));
				System.out.println("/------------------------------------------");
				add(r1, r2);
				break;
			case 1:
				r1 = (short) input.get(1);

				System.out.println("/------------------------------------------");
				System.out.println("Executing sub "+input.get(1)+" "+input.get(2));
				System.out.println("/------------------------------------------");

				r2 = (short) input.get(2);
				sub(r1, r2);

				break;
			case 2:
				r1 = (short) input.get(1);
				System.out.println("/------------------------------------------");
				System.out.println("Executing mult "+input.get(1)+" "+input.get(2));
				System.out.println("/------------------------------------------");
				r2 = (short) input.get(2);
				mult(r1, r2);
				break;
			case 3:
				r1 = (short) input.get(1);
				System.out.println("/------------------------------------------");
				System.out.println("Executing LDI "+input.get(1)+" "+input.get(3));
				System.out.println("/------------------------------------------");

				Byte imm = (Byte) input.get(3);
				loadImm(r1, imm);
				break;
			case 4:
				r1 = (Short) input.get(1);
				System.out.println("/------------------------------------------");
				System.out.println("Executing BEQZ "+input.get(1)+" "+input.get(3));
				System.out.println("/------------------------------------------");
				imm = (Byte) input.get(3);
				branchIfEq(r1, imm);
				break;
			case 5:
				r1 = (short) input.get(1);
				System.out.println("/------------------------------------------");
				System.out.println("Executing and on r"+input.get(1)+" r"+input.get(2));
				System.out.println("/------------------------------------------");
				r2 = (short) input.get(2);
				and(r1, r2);
				break;
			case 6:
				r1 = (short) input.get(1);
				System.out.println("/------------------------------------------");
				System.out.println("Executing or on r"+input.get(1)+" r"+input.get(2));
				System.out.println("/------------------------------------------");
				r2 = (short) input.get(2);
				or(r1, r2);
				break;
			case 7:
				r1 = (short) input.get(1);
				System.out.println("/------------------------------------------");
				System.out.println("Executing JR using r"+input.get(1)+" and r"+input.get(2));
				System.out.println("/------------------------------------------");
				r2 = (short) input.get(2);
				jumpReg(r1, r2);
				break;
			case 8:
				r1 = (short) input.get(1);
				System.out.println("/------------------------------------------");
				System.out.println("Executing SLC on r"+input.get(1)+" "+input.get(3)+" bits");
				System.out.println("/------------------------------------------");
				imm = (Byte) input.get(3);
				ShiftLeftCircular(r1, imm);
				break;
			case 9:
				r1 = (short) input.get(1);
				System.out.println("/------------------------------------------");
				System.out.println("Executing SRC on r"+input.get(1)+" "+input.get(3)+" bits");
				System.out.println("/------------------------------------------");
				imm = (Byte) input.get(3);
				ShiftRightCircular(r1, imm);
				break;
			case 10:
				r1 = (short) input.get(1);
				System.out.println("/------------------------------------------");
				System.out.println("Executing LB on r"+input.get(1)+"at Data Memory "+input.get(3));
				System.out.println("/------------------------------------------");
				loadByte(r1, (Byte) input.get(3));
				break;
			case 11:
				r1 = (short) input.get(1);
				System.out.println("/------------------------------------------");
				System.out.println("Executing SB on r"+input.get(1)+"at Data Memory "+input.get(3));
				System.out.println("/------------------------------------------");
				storeByte(r1, (Byte) input.get(3));
				break;

			}
			System.out.println("/------------------------------------------");
			System.out.println("Status Register Value is"+statusReg);
			System.out.println("/------------------------------------------");
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
		dataRegWriter(r1,(byte) temp1);

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

		dataRegWriter(r1,(byte) temp);
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

		dataRegWriter(r1,(byte) temp);
	}

	public void loadImm(short r1, Byte imm) {
		dataRegWriter(r1,(byte) imm);
	}

	public void branchIfEq(short r1, Byte imm) {
		if (r1 == 0) {
			programCounter = programCounter + 1 + imm;
			jump = true;
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
		dataRegWriter(r1,(byte) temp1);

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


		dataRegWriter(r1,(byte) temp1);
	}

	public void jumpReg(short r1, short r2) {
		Byte num1 = dataRegFetcher(r1);
		Byte num2 = dataRegFetcher(r2);
		int x = (int) num1;
		int y = (int) num2;
		int k = Integer.valueOf(String.valueOf(x) + String.valueOf(y));
		programCounter = k;
		jump = true;
	}

	public void loadByte(short r1, Byte address) {
		byte value = (byte) dataMemoryFetcher(address);
		dataRegWriter(r1, value);

	}

	public void storeByte(short r1, Byte address) {
		byte value = dataRegFetcher(r1);

		dataMemoryWriter(address, value);

	}

	public void ShiftRightCircular(short R1, short imm) {

		int num = dataRegFetcher(R1);
		int shifted = (num >> imm | num << 8 - imm);

		if (shifted < 0) {

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
		int shifted = (num << imm | num >> 8 - imm);

		if (shifted < 0) {
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
		System.out.println("register r"+rPos+"was changed to"+value);
	}

	public byte dataMemoryFetcher(byte mPos) {
		return dataMemory[mPos];

	}

	public void dataMemoryWriter(int mPos, Byte value) {
		dataMemory[mPos] = value;
		System.out.println("data memory was changed at "+mPos+"to"+value);
	}
//----------------------------------------------------------------------------------------------------------------------
	// flags in SREG

	public void setZeroFlag(short value) {


			statusReg[0] = value;



	}

	public void setSignFlag(short value) {

			statusReg[1] = value;



	}

	public int negativeFlagFetch() {
		return statusReg[2];
	}

	public void setNegativeFlag(short value) {

			statusReg[2] = value;



	}

	public int twoComplementOverflowFlagFetch() {
		return statusReg[3];
	}

	public void twoComplementOverflowFlag(short value) {

			statusReg[3] = value;



	}

	public void setCarryFlag(short value) {
		

			statusReg[4] = value;
			



	}



}

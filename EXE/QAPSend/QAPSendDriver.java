import java.util.Scanner;

class QAPSendDriver extends AbstractDriver{ 

	public static void main(String args[]){
		
		//Generico del driver
		QAPSend q = new QAPSend();

		//Generico del menu
		Scanner in = new Scanner(System.in);
		int opc = 0;
		String argv[];		
		
		//Menu
		_menu();
		
		do {
			argv = Console.read_line(in);
			
			if (argv == null) opc = 0;
			else if (argv.length > 0){
				//Console.print(argv.length + "");
				opc = Integer.parseInt(argv[0]);
				switch (opc){
				case 0:
					break;
				case 1:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						q = create_qapsend(argv[1], argv[2]);
					}
					break;
				case 2:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						set_planet(p,argv[1]);
					}
					break;
				case 4:
					if (argv.length < 3)
						_msg_error_param_insuf();
					else {
						set_packet(p,argv[1]);
					}
					break;
				case 5:
					Console.print("" + q.getPlanet().getName());
					break;
				case 6:
					Console.print("" + q.getPacket().getName());
					break;
			}
		}
		while(opc != 0);
	}
	
	
	// Actions
	// ---------------------------------------------

	public static void set_planet(QAPSend q, String p){
		try{
			q.setPlanet(p);
		}
		catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}
	/**
	 * 
	 * @param p
	 */
	public static void set_packet(QAPSend q, Packet p){
		try{
			q.setPacket(p);
		} catch (Exception e) {
			_msg_error(e.getMessage());
		}
	}
	
	// To Basic
	//---------------------------------------------

	public static String ToString(QAPSend q){
		return q.getPlanet().planet.getName() + " " + q.getPacket().packet.getName();
	}
	
	// Menu
	// ---------------------------------------------

	private static void _menu(){
		title = "Planet Collection Driver";
		
		menu.add("QAPSend(p,pack) : QAPSend"); 
		menu.add("setPlanet(Planet p) : void");
		menu.add("setPacket(Packet p) : void"); //3
		menu.add("getPlanet() : Planet");
		menu.add("getPacket() : Packet");
		menu.add("ToString() : String");
		print_menu();
	}
}

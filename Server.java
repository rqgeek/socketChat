import java.net.*;
import java.io.*;
class ServerSystem{
	String str;
	Socket s;
	ServerSystem()throws Exception{
                String fColor="\033[36m";
		String cStop="\033[0m";
		String cReceiver="\033[35m";
		String cSender="\033[32m";
		System.out.print("\033[2J\033[1H");
		ServerSocket ss=new ServerSocket(2001);
		System.out.println(fColor+"\t\tCHAT APPLICATION"+cStop+"\nServer started("+InetAddress.getLocalHost()+")...");
		System.out.println("---Enter ## at the last line of message to send");
		System.out.println("---Enter $$ to stop the chat");
		s=ss.accept();
		BufferedReader brReceive=new BufferedReader(new InputStreamReader(s.getInputStream()));
		BufferedReader brSend=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
		do{
			str=brReceive.readLine();
                        System.out.print(" -^-------------------------\n|");
                        System.out.println(cSender+"Client : "+cStop);
			while(!str.equals("##")&&!str.equals("$$")){
				System.out.println("| "+str);
				str=brReceive.readLine();
			}
                        System.out.println(" ---------------------------");
                        if(str.equals("$$")) break;
			System.out.print("\t\t ----------------------------\n\t\t|");
			System.out.println(cReceiver+"You : "+cStop);
			do{
				System.out.print("\t\t| ");
				str=brSend.readLine();
				pw.write(str+"\n");
			}while(!str.equals("##")&&!str.equals("$$"));
			pw.flush();
			System.out.print("\t\t ----------------------------\n");
                        if(str.equals("$$")) break;
		}while(true);
	}

}
class Server{
	public static void main(String args[])throws Exception{
		ServerSystem s=new ServerSystem();
	}
}

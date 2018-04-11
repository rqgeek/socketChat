import java.net.*;
import java.io.*;
class ClientSystem{
	String str;
	ClientSystem()throws Exception{
                System.out.print("\033[2J\033[1H");
		String cSender="\033[32m";
		String cReceiver="\033[35m";
		String fColor="\033[36m";
		String cStop="\033[0m";
		Socket s=new Socket("127.0.1.1",2001);
		System.out.println(fColor+"\t\tCHAT APPLICATION"+cStop+"\nClient started...");
		System.out.println("---Enter ## at the last line of message to send");
                System.out.println("---Enter $$ to stop the chat");
                BufferedReader brSend=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(s.getOutputStream());
		BufferedReader brReceive=new BufferedReader(new InputStreamReader(s.getInputStream()));
		do{
			System.out.print("\t\t -----------------------------\n\t\t|");
			System.out.println(cReceiver+"You : "+cStop);
			do{
				System.out.print("\t\t| ");
				str=brSend.readLine();
				pw.write(str+"\n");
			}while(!str.equals("##")&&!str.equals("$$"));
			pw.flush();
			System.out.println("\t\t -----------------------------");
                        if(str.equals("$$")) break;
                     	str=brReceive.readLine();
			System.out.print(" -^------------------------\n|");
			System.out.println(cSender+"Server : "+cStop);
			while(!str.equals("##")&&!str.equals("$$")){
				System.out.println("| "+str);
				str=brReceive.readLine();
			}
			System.out.println(" --------------------------");
                        if(str.equals("$$")) break;
        	}while(true);
	}

}
class Client{
	public static void main(String args[])throws Exception{
		ClientSystem s=new ClientSystem();
	}
}

package chatbot;

public class Chatbot {
	private String username;
	private boolean chatting;
	private Topic jessica;
	private Topic areej;
	private Topic vickie;
	private Topic ji;

	public String getUsername ()
	{
		return username;
	}
	public Topic getJessica()
	{
		return jessica;
	}
	public Topic getAreej()
	{
		return areej;
	}
	public Topic getVickie()
	{
		return vickie;
	}
	public Topic getJi()
	{
		return ji;
	}
	public Chatbot() {
		jessica = new ChatbotJessica();
		areej = new ChatbotAreej();
		vickie = new ChatbotVickie();
		ji = new ChatbotJi();
		username = "Unknown User";
		chatting = true;
	}

	public void startChatting() {
		
		ChatbotMain.print("Hi! I am an intelligence machiene that can respond to your input. What is your name?");
		username = ChatbotMain.getInput();
		while (chatting)
		{
			ChatbotMain.print("What would you like to talk about?");
			String response = ChatbotMain.getInput();
			if(jessica.isTriggered(response))
			{
				chatting = false; //exits the while loop IMPORTANT
				jessica.talk(response);
			}
			else if(areej.isTriggered(response))
			{
				chatting = false; //exits the while loop IMPORTANT
				areej.talk(response);
			}
			else if(vickie.isTriggered(response))
			{
				chatting = false; //exits the while loop IMPORTANT
				vickie.talk(response);
			}
			else if(ji.isTriggered(response))
			{
				chatting = false; //exits the while loop IMPORTANT
				ji.talk(response);
			}
			else
			{
				ChatbotMain.print("I'm sorry. I don't understand. Please rephrase that.");
			}
		}
	}
	
	

	

	public static boolean keywordIsIsolated(int position ,String keyword ,String s)//keywordIsIsolated(4,"good","i'm good")

	{

		if(s.substring(position, position+keyword.length()).equals(keyword)) //found word
		{
			if( position == 0) //space infront or is in the front
			{
				return true;
			}
			if(s.substring(position-1, position).equals(" "))
			{
				return true;
			}
		}
	return false;
	}
}

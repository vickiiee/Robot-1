package chatbot;

public class Chatbot {
	private String username;
	private boolean chatting;
	private Topic jessica;
	private ChatbotAreej areej;
	private Topic vickie;
	private ChatbotJi ji;

	private String[] upsetResArr;
	
	
	public String getUsername ()
	{
		return username;
	}
	public Topic getJessica()
	{
		return jessica;
	}
	public ChatbotAreej getAreej()
	{
		return areej;
	}
	public Topic getVickie()
	{
		return vickie;
	}
	public ChatbotJi getJi()
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
	
		String[] upsetRes = {"We already said Hi.", "Let's move on. What do you want to speak about?" 
				,"Please stop saying hi. ", "Do you really understand? ", "You have to say something else!"};
		upsetResArr = upsetRes;
	

	}

	public void startChatting() {
		
		ChatbotMain.print("Hi! I am a guidance counselor, and here to help you through your years at high school! What is your name?");
		username = ChatbotMain.getInput();
		ChatbotMain.print("Hi, " + getUsername() + ". What would you like to talk about? Classes, colleges, any personal things, or a joke?");
		while (chatting)
		{
			
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
				//if((ChatbotMain.findKeyword(response, "hello" , 0) >= 0) || (ChatbotMain.findKeyword(response, "hi" , 0) >= 0))
				if(response.indexOf("hello") >= 0|| response.indexOf("hi") >= 0)
				{
					
					ChatbotMain.print(upsetResArr[(int) (Math.random()*3)]);	
					
				}
				else {
				ChatbotMain.print("I'm sorry. I don't understand. Do you want to talk about classes, colleges, any personal things, "
						+ "or maybe even a joke?");
				}
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

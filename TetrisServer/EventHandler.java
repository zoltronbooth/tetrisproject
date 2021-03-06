package TetrisServer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

public class EventHandler implements ActionListener
{
private ServerGUI gui2 = null;
public EventHandler(ServerGUI server)
{
	this.gui2 = server;
}
public void actionPerformed(ActionEvent event)
{

  if(event.getActionCommand().equals("Stop"))
  {
  	if(gui2 != null)
  	{
    	if(!gui2.didListen())
    	{
    		gui2.inccorectStop();
    	}
   	  else
  	  {
  	  	gui2.stopListening();
  	  }
	  }
  }
  else if(event.getActionCommand().equals("Listen"))
  {
  	if(!gui2.checkListen())
  	{
  		gui2.incorrectListen();
  	}
  	else
  	{
  		gui2.setListen();
  	}
  }
  else if(event.getActionCommand().equals("Close"))
  {
  	if(!gui2.didListen())
  	{
  		gui2.inccorectStop();
  	}
  	else
  	{
  		gui2.closeServer();
  	}	
  }
  else if(event.getActionCommand().equals("Quit"))
  {
  	gui2.stopDatabase();
  	gui2.dispose();
  	System.exit(0);
  }
  else if(event.getActionCommand().equals("Server Information"))
  {
  	try
		{
			gui2.showServerInformation();
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  else if(event.getActionCommand().equals("Player Information"))
  {
  	gui2.showPlayerInformation();
  }
  
  else
  	System.out.println("Error with button press");
  }
}

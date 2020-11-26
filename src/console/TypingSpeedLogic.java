package console;

public class TypingSpeedLogic {
	float time,characters,result;
	public void gettime(long elapsed) {
		time = (float)elapsed;
	}
	public void getwords(int c)
	{
		characters = c;

	}
	
	public float returnresult()
	{  
		
		time = time/60;
		if(time > 0)
			{
			 result = (characters/5)/time;  
			}
		return result;
	}
	
}
	

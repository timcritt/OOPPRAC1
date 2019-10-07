package PRAC1_ex1;

public class Team{

	private String shortName, longName, imageSrc, president, sponsor;
	private int members, budget, founded;
					
	public Team() throws Exception{
		shortName = "Default";
		longName = "Team Default";
		imageSrc = "./";
		president = "Dummy";
		sponsor = "UOC";
		members = 1000;
		budget = 1000000;
		founded = 2019;
	}	
		
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortNameNew) throws Exception{
		if(shortNameNew.length()>40) {
			throw new Exception("[ERROR] Short name cannot be longer than 40 characters!!");
		}
		
		shortName = shortNameNew;
	}
}

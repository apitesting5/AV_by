package dataClasses;

public class FooterData {
	
	private String AutiWithMiles;
	private String NewCars;
	private boolean YouTubeIcon;
	private String YouTube;
	private boolean AndroidBlock;
	
	public FooterData(String autiWithMiles, String newCars, boolean youTubeIcon, String youTube, boolean androidBlock) {
		super();
		AutiWithMiles = autiWithMiles;
		NewCars = newCars;
		YouTubeIcon = youTubeIcon;
		YouTube = youTube;
		AndroidBlock = androidBlock;
	}

	public String getAutiWithMiles() {
		return AutiWithMiles;
	}

	public String getNewCars() {
		return NewCars;
	}

	public boolean isYouTubeIcon() {
		return YouTubeIcon;
	}

	public String getYouTube() {
		return YouTube;
	}

	public boolean isAndroidBlock() {
		return AndroidBlock;
	}

} 

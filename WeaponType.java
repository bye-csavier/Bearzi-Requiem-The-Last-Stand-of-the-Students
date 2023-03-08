public enum WeaponType {
	FIREARM("Firearm"),
	MAGIC("Magic weapon"),
	MELEE("Melee");
	
	private String desc;
	
	WeaponType ( String desc )	{
		this.desc = desc;
	}
	
	public String getDesc()	{
		return desc;
	}
}

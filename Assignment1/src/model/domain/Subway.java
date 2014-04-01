package model.domain;

public class Subway{
	
	private int subwayCode;
	private String subwayName;
	private int subwayLength;
	private int subwayPrice;
	public Subway() {
		super();
	}
	public Subway(int sCode, String sName, int sLength, int sPrice) {
		super();
		this.subwayCode = sCode;
		this.subwayName = sName;
		this.subwayLength = sLength;
		this.subwayPrice = sPrice;
	}
	public int getSubwayCode() {
		return subwayCode;
	}
	public void setSubwayCode(int subwayCode) {
		this.subwayCode = subwayCode;
	}
	public String getSubwayName() {
		return subwayName;
	}
	public void setSubwayName(String subwayName) {
		this.subwayName = subwayName;
	}
	public int getSubwayLength() {
		return subwayLength;
	}
	public void setSubwayLength(int subwayLength) {
		this.subwayLength = subwayLength;
	}
	public int getSubwayPrice() {
		return subwayPrice;
	}
	public void setSubwayPrice(int subwayPrice) {
		this.subwayPrice = subwayPrice;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Subway [subwayCode=");
		builder.append(subwayCode);
		builder.append(", subwayName=");
		builder.append(subwayName);
		builder.append(", subwayLength=");
		builder.append(subwayLength);
		builder.append(", subwayPrice=");
		builder.append(subwayPrice);
		builder.append("]");
		return builder.toString();
	}
	
}